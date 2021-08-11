package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup extends AppCompatActivity {
    EditText name,phone,email,reference,pin;
    Button registration;
    private APIService registrationApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.nameTxt);
        phone=(EditText)findViewById(R.id.phoneTxt);
        email=(EditText)findViewById(R.id.emailTxt);
        reference=(EditText)findViewById(R.id.referenceTxt);
        pin=(EditText)findViewById(R.id.pinTxt);
        registration=(Button)findViewById(R.id.registration);

        registrationApi=ApiUtils.getAPIService();

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (name.getText().toString().length() == 0)
                    {
                        name.setError("Please Enter a username!");
                        return ;
                    }
                    if (phone.getText().toString().length() == 0)
                    {
                        phone.setError("Please Enter a Phone!");
                        return ;
                    }
                    if (email.getText().toString().length() == 0)
                    {
                        email.setError("Please Enter a Email!");
                        return ;
                    }
                    if (pin.getText().toString().length() == 0)
                    {
                        pin.setError("Please Enter a pin!");
                        return ;
                    }
                    sendPost(name.getText().toString(), phone.getText().toString(), email.getText().toString(),
                            reference.getText().toString(),pin.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void sendPost(String name,String phone, String email,String reference, String pin) throws IOException {

        Call<loginModel> call = registrationApi.getStringScalar(name,phone,email,reference,pin);

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                loginModel loginModel=response.body();
                Toast.makeText(signup.this, loginModel.getResponseoff(), Toast.LENGTH_SHORT).show();
                if(loginModel.getResponseoff().equals("send")){
                    Intent intent = new Intent(signup.this,login.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {

                Toast.makeText(signup.this, "Error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}