package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class airtel extends AppCompatActivity {
    RadioGroup category;
    RadioButton rButton;
    Button button;
    TextView title;
    EditText usernumber,ammount,pin;
    String number;
    private APIService grameenApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel);
        category=(RadioGroup)findViewById(R.id.categoryButton);
        button=(Button)findViewById(R.id.gSend);
        title=(TextView)findViewById(R.id.gTitle);
        usernumber=(EditText)findViewById(R.id.gNumber);
        ammount=(EditText)findViewById(R.id.gAmmount);
        pin=(EditText)findViewById(R.id.gPin);
        grameenApi=ApiUtils.getAPIService();
        SessionManagment sessionManagment = new SessionManagment(airtel.this);
        number=sessionManagment.getSession();




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernumber.getText().toString().length() <=10 ||usernumber.getText().toString().length() >11)
                {
                    usernumber.setError("Please Enter a Number!");
                    return ;
                }
                if (ammount.getText().toString().length() == 0)
                {
                    ammount.setError("Please Enter a amount!");
                    return ;
                }
                if (pin.getText().toString().length() == 0)
                {
                    pin.setError("Please Enter a pin!");
                    return ;
                }
                try {
                    int selectedId=category.getCheckedRadioButtonId();
                    rButton=(RadioButton)findViewById(selectedId);
                    sendPost(number, usernumber.getText().toString(), rButton.getText().toString(),
                            ammount.getText().toString(),title.getText().toString(),pin.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });

    }
    public void sendPost(String number,String usernumber,String numbertype, String ammount,String title, String pin) throws IOException {

        Call<loginModel> call = grameenApi.flexiLoadTransaction(number,usernumber,numbertype,ammount,pin,title);

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                loginModel loginModel=response.body();
                Toast.makeText(airtel.this, loginModel.getResponseoff(), Toast.LENGTH_SHORT).show();
                if(loginModel.getResponseoff().equals("send")){
                    Intent intent = new Intent(airtel.this,login.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {

                Toast.makeText(airtel.this, "Error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}