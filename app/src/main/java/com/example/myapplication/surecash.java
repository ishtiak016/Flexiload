package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class surecash extends AppCompatActivity {
    TextView title;
    EditText usernumber,ammount,pin;
    Button sendBkash;
    SharedPreferences pref;
    String number;
    private APIService bkashApi;
    RadioGroup category;
    RadioButton rButton;
    loginModel loginModel;
    public static  String KEY_PHONE=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surecash);
        bkashApi=ApiUtils.getAPIService();
        title=(TextView)findViewById(R.id.bTitle);
        usernumber=(EditText)findViewById(R.id.bNumber);
        ammount=(EditText)findViewById(R.id.bAmmount);
        pin=(EditText)findViewById(R.id.bPin);
        sendBkash=(Button)findViewById(R.id.bSend);
        category=(RadioGroup)findViewById(R.id.categoryButton);
        SessionManagment sessionManagment = new SessionManagment(surecash.this);
        number=sessionManagment.getSession();
        sendBkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (usernumber.getText().toString().length() <=10 ||usernumber.getText().toString().length() >11)
                    {
                        usernumber.setError("Please Enter a username!");
                        return ;
                    }
                    if (pin.getText().toString().length() == 0)
                    {
                        pin.setError("Please Enter a pin!");
                        return ;
                    }
                    if (ammount.getText().toString().length() == 0)
                    {
                        ammount.setError("Please Enter a amount!");
                        return ;
                    }
                    int selectedId=category.getCheckedRadioButtonId();
                    rButton=(RadioButton)findViewById(selectedId);
                    sendPost(number, usernumber.getText().toString(), ammount.getText().toString(),
                            title.getText().toString(),pin.getText().toString(),rButton.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void sendPost(String number,String usernumber, String ammount,String title, String pin,String account) throws IOException {

        Call<loginModel> call = bkashApi.transaction(number,usernumber,ammount,title,pin,account);

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {


                loginModel=response.body();
                Toast.makeText(surecash.this, loginModel.getResponseoff(), Toast.LENGTH_SHORT).show();
                if(loginModel.getResponseoff().equals("send")){
                    Intent intent = new Intent(surecash.this,login.class);
                    startActivity(intent);
            }
        }
            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {

                Toast.makeText(surecash.this, "Error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }



}