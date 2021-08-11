package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    LinearLayout bRocket,bBillPay,bFlexiload,bPakage,
            bHistory,bAddMoney,bAddMoneyHistory,bBillhistory,logout,profilepageT,noticeboardA;
    private APIService balanceApi;
    private APIService noticeApi;
    TextView balanceId,phone,notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRocket= (LinearLayout) findViewById(R.id.rocket);
        bBillPay=(LinearLayout)findViewById(R.id.billPay);
        bAddMoneyHistory=(LinearLayout)findViewById(R.id.addMoneyHistory);
        logout=(LinearLayout)findViewById(R.id.Logout);
        bFlexiload=(LinearLayout)findViewById(R.id.flexiload);
        bPakage=(LinearLayout)findViewById(R.id.pakage);
        bHistory=(LinearLayout)findViewById(R.id.history);
        bBillhistory=(LinearLayout)findViewById(R.id.billHistory);
        balanceId=(TextView)findViewById(R.id.balanceTxt);
        phone=(TextView)findViewById(R.id.phoneNumber);
        notice=(TextView)findViewById(R.id.notice);
        bAddMoney=(LinearLayout)findViewById(R.id.addmoney);
        noticeboardA=(LinearLayout)findViewById(R.id.noticeMain);
        profilepageT=(LinearLayout)findViewById(R.id.prifilePageConnect);
        notice.setSelected(true);
        balanceApi=ApiUtils.getAPIService();

        SessionManagment sessionManagment = new SessionManagment(MainActivity.this);
        String phoneNumber=sessionManagment.getSession();
        phone.setText(phoneNumber);

        Call<noticeModel>noticel=balanceApi.noticeT();
        noticel.enqueue(new Callback<noticeModel>() {
            @Override
            public void onResponse(Call<noticeModel> call, Response<noticeModel> response) {
               notice.setText(response.body().getNotice());
            }

            @Override
            public void onFailure(Call<noticeModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

        Call<loginModel> call=balanceApi.balanceCheck(phoneNumber);

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {

                String s=null;
                s=response.body().getResponseoff().toString();
                balanceId.setText("BDT :"+s);
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        bRocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, All_mobile_banking.class);
                startActivity(intent);

            }
        });
        bBillPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,billpay.class);
                startActivity(intent);

            }
        });
        bFlexiload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,all_operator.class);
                startActivity(intent);

            }
        });
        bPakage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,all_pakage_all_operator.class);
                startActivity(intent);
            }
        });
        bHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,history.class);
                startActivity(intent);
            }
        });
        bAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Add_Money.class);
                startActivity(intent);
            }
        });
        bAddMoneyHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,add_money_history.class);
                startActivity(intent);
            }
        });
        bBillhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,bill_history.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManagment sessionManagment=new SessionManagment(MainActivity.this);
                sessionManagment.removeSession();
                Intent intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
        profilepageT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,profilePage.class);
                startActivity(intent);
            }
        });
        noticeboardA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,noticeboard.class);
                startActivity(intent);
            }
        });
        
    }
}