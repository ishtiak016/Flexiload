package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_Money extends AppCompatActivity {
TextView usernumber,ammount,numbersDisplay;
Button send;
String number;
private APIService addmoneyApi;
    private APIService numberDisplayApi;
    RadioGroup category;
    RadioButton rButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        usernumber=(TextView)findViewById(R.id.gNumber);
        ammount=(TextView)findViewById(R.id.gAmountA);
        send=(Button)findViewById(R.id.gSend);
        numbersDisplay=(TextView) findViewById(R.id.gNumbers);
        category=(RadioGroup)findViewById(R.id.categoryButton);
        SessionManagment sessionManagment = new SessionManagment(Add_Money.this);
        number=sessionManagment.getSession();
        addmoneyApi=ApiUtils.getAPIService();
        numberDisplayApi=ApiUtils.getAPIService();
        numbersDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersDisplay.setTextIsSelectable(true);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernumber.getText().toString().length() == 0)
                {
                    usernumber.setError("Please Enter a TXnId!");
                    return ;
                }
                if (ammount.getText().toString().length() == 0)
                {
                    ammount.setError("Please Enter a amount!");
                    return ;
                }
                try {
                    int selectedId=category.getCheckedRadioButtonId();
                    rButton=(RadioButton)findViewById(selectedId);
                    sendPost(number, usernumber.getText().toString(),ammount.getText().toString(),rButton.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Call<noticeModel> call=numberDisplayApi.numberdisplay();
        call.enqueue(new Callback<noticeModel>() {
            @Override
            public void onResponse(Call<noticeModel> call, Response<noticeModel> response) {
                noticeModel numbersdisplaymodel=response.body();
                numbersDisplay.setText(numbersdisplaymodel.getNotice());
            }

            @Override
            public void onFailure(Call<noticeModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
    public void sendPost(String number,String usernumber,String ammount,String type) throws IOException {

        Call<loginModel> call = addmoneyApi.addmoney(number,usernumber,ammount,type);

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                loginModel loginModel=response.body();
                Toast.makeText(Add_Money.this, loginModel.getResponseoff(), Toast.LENGTH_SHORT).show();
                if(loginModel.getResponseoff().equals("send")){
                    Toast.makeText(getApplicationContext(),loginModel.getResponseoff(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Add_Money.this,login.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
}