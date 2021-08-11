package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    Button loginBtn,signupBtn;
    EditText Tname,Tpin;
    String phoneNumber;
    private APIService loginApi;
    public static  String KEY_PHONE=null;
    SharedPreferences pref;

    @Override
    protected void onStart() {
        super.onStart();
        SessionManagment sessionManagment = new SessionManagment(login.this);
        String phoneNumber=sessionManagment.getSession();
        if(!phoneNumber.equals("0"))
        {
            Intent intent = new Intent(login.this,MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn=(Button)findViewById(R.id.login);
        signupBtn=(Button)findViewById(R.id.signup);
        Tname=(EditText)findViewById(R.id.loginTxt);
        Tpin=(EditText)findViewById(R.id.loginPinTxt);
        loginApi=ApiUtils.getAPIService();
        pref = getSharedPreferences("user_details",MODE_MULTI_PROCESS);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Tname.getText().toString().length() == 0)
                {
                    Tname.setError("Please Enter a username!");
                    return ;
                }
                if (Tpin.getText().toString().length() == 0)
                {
                    Tpin.setError("Please Enter a pin!");
                    return ;
                }
                try {
                    loginsend();

                }catch (Exception e){

                }

            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);
            }
        });
    }
    public void loginsend() throws IOException {
        String name=Tname.getText().toString();
        String password=Tpin.getText().toString().trim();

        Call<loginModel> call=loginApi.performUserLogin(name,password);
        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                if(response.body().getResponseoff().equals("ok")){

                    SessionManagment sessionManagment = new SessionManagment(login.this);

                    sessionManagment.saveSession(name);

                    Intent intent = new Intent(login.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(login.this, response.body().getResponseoff(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {
                Toast.makeText(login.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}