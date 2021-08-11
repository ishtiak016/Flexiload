package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profilePage extends AppCompatActivity {
   TextView name,phone,email,reference,pin,total,numberofref,referencebalan;
   private APIService profilApi,refApi;

   String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        name=(TextView) findViewById(R.id.nameTxtp);
        phone=(TextView) findViewById(R.id.phoneTxtp);
        email=(TextView) findViewById(R.id.emailTxtp);
        reference=(TextView) findViewById(R.id.referenceTxtp);
        numberofref=(TextView)findViewById(R.id.numberofreference);
        reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.setTextIsSelectable(true);
            }
        });
        total=(TextView)findViewById(R.id.totalTxtp);
        pin=(TextView) findViewById(R.id.pinTxtp);
        referencebalan=(TextView)findViewById(R.id.referenceBalance);
        profilApi=ApiUtils.getAPIService();
        refApi=ApiUtils.getAPIService();
        SessionManagment sessionManagment = new SessionManagment(profilePage.this);
        number=sessionManagment.getSession();
        Call<profileModel> call=profilApi.profilequery(number);
        call.enqueue(new Callback<profileModel>() {
            @Override
            public void onResponse(Call<profileModel> call, Response<profileModel> response) {
           name.setText(response.body().getName());
           phone.setText(response.body().getPhone());
           email.setText(response.body().getEmail());
           reference.setText(response.body().getPhone());
           pin.setText(response.body().getPin());
           total.setText("BDT :"+response.body().getTotal());
           referencebalan.setText("BDT :"+response.body().getReferencebalance());

            }

            @Override
            public void onFailure(Call<profileModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
        Call<noticeModel>reto=refApi.referencenumber(number);
        reto.enqueue(new Callback<noticeModel>() {
            @Override
            public void onResponse(Call<noticeModel> call, Response<noticeModel> response) {
                numberofref.setText(response.body().getNotice());
            }

            @Override
            public void onFailure(Call<noticeModel> call, Throwable t) {

            }
        });




    }
}