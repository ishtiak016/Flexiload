package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pakageBuyPage extends AppCompatActivity {
    TextView minutes,gbs,smss,days,operators,regularPrice,offerPrices,areas;
    EditText userNumber,userPin;
    Button send;
    String number,pin,minute,gb,sms,day,operator,regular,offer,area;
    String pNumber;
    private APIService pakagebuyapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakage_buy_page);

        send=(Button)findViewById(R.id.sends);
        userNumber=(EditText) findViewById(R.id.userNumbers);
        userPin=(EditText)findViewById(R.id.pins);
        minutes=(TextView)findViewById(R.id.minutes);
        gbs=(TextView)findViewById(R.id.gbs);
        smss=(TextView)findViewById(R.id.smss);
        days=(TextView)findViewById(R.id.days);
        operators=(TextView)findViewById(R.id.operators);
        regularPrice=(TextView)findViewById(R.id.regularPrices);
        offerPrices=(TextView)findViewById(R.id.offerprices);
        areas=(TextView)findViewById(R.id.area);

        pakagebuyapi=ApiUtils.getAPIService();

        minute=getIntent().getStringExtra("minute");
        gb=getIntent().getStringExtra("internet");
        sms=getIntent().getStringExtra("sms");
        day=getIntent().getStringExtra("days");
        operator=getIntent().getStringExtra("operator");
        regular=getIntent().getStringExtra("regularPrice");
        offer=getIntent().getStringExtra("offerPrice");
        area=getIntent().getStringExtra("area");
        minutes.setText("Minutes: "+minute);
        gbs.setText("Internet: "+gb+"GB");
        smss.setText("SMS :"+sms);
        days.setText("Expire Days :"+day);
        operators.setText(operator);
        regularPrice.setText("Regula Price :"+regular+"Tk");
        offerPrices.setText("Offer Price :"+offer+"Tk");
        areas.setText(area);

        SessionManagment sessionManagment = new SessionManagment(pakageBuyPage.this);
         pNumber=sessionManagment.getSession();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (userNumber.getText().toString().length() <=10 ||userNumber.getText().toString().length() >11)
                    {
                        userNumber.setError("Please Enter a Number!");
                        return ;
                    }

                    if (userPin.getText().toString().length() == 0)
                    {
                        userPin.setError("Please Enter a pin!");
                        return ;
                    }

                    sendPost(minute, gb, sms,
                            day,area,operator,regular,offer,pNumber,userNumber.getText().toString()
                    ,userPin.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


//        number=userNumber.getText().toString();
//        pin=userPin.getText().toString();
//        minute=minutes.getText().toString();
//        gb=gbs.getText().toString();
//        sms=smss.getText().toString();
//        day=days.getText().toString();
//        operator=operators.getText().toString();
//        regular=operators.getText().toString();
//        offer=offerPrices.getText().toString();




    }
    public void sendPost(String minute,String gb,String sms, String day,String area
            , String operator,String regular,String offer,String pNumber,String usernumber,
                         String userpin) throws IOException {

        Call<loginModel> call = pakagebuyapi.pakagebilltransaction(minute,gb,sms,day,
                area,operator,regular,offer,pNumber,usernumber,userpin);

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                loginModel loginModel=response.body();
                Toast.makeText(pakageBuyPage.this, loginModel.getResponseoff(), Toast.LENGTH_SHORT).show();
                if(loginModel.getResponseoff().equals("send")){
                    Intent intent = new Intent(pakageBuyPage.this,login.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {

                Toast.makeText(pakageBuyPage.this, "Error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}