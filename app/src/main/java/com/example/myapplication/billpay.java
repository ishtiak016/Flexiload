package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class billpay extends AppCompatActivity {
    TextView title;
    EditText billMonth,billNumber,billAmmount,pin;
    Button sendBill;
    SharedPreferences pref;
    String number;
    private APIService billApi;
    public static  String KEY_PHONE=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpay);
        billApi=ApiUtils.getAPIService();


        title=(TextView)findViewById(R.id.billTitle);
        billMonth=(EditText)findViewById(R.id.billMonth);
        billNumber=(EditText)findViewById(R.id.billNumber);
        billAmmount=(EditText)findViewById(R.id.billAmmount);
        pin=(EditText)findViewById(R.id.billPin) ;
        sendBill=(Button)findViewById(R.id.billSend);

        SessionManagment sessionManagment = new SessionManagment(billpay.this);
        number=sessionManagment.getSession();
        sendBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (billMonth.getText().toString().length() == 0)
                {
                   billMonth.setError("Please Enter a Bill Month!");
                    return ;
                }
                if (billNumber.getText().toString().length() == 0)
                {
                    billNumber.setError("Please Enter a pin!");
                    return ;
                }
                if (billAmmount.getText().toString().length() == 0)
                {
                    billAmmount.setError("Please Enter a amount!");
                    return ;
                }
                if (pin.getText().toString().length() == 0)
                {
                    pin.setError("Please Enter a pin!");
                    return ;
                }
                try {
                    sendPost(number, billMonth.getText().toString(), billNumber.getText().toString(),
                            billAmmount.getText().toString(),pin.getText().toString(),title.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void sendPost(String number,String bill_month, String bill_number,String bill_ammount, String pin,String title) throws IOException {

        Call<loginModel> call = billApi.billpaytransaction(number,bill_month,bill_number,bill_ammount,pin,title);

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                loginModel loginModel=response.body();
                Toast.makeText(billpay.this, loginModel.getResponseoff(), Toast.LENGTH_SHORT).show();
                if(loginModel.getResponseoff().equals("send")){
                    Intent intent = new Intent(billpay.this,login.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {

                Toast.makeText(billpay.this, "Error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}