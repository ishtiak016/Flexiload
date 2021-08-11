package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class All_mobile_banking extends AppCompatActivity {
    LinearLayout bBkash,bNagad,bSureCash,bRocket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_mobile_banking);
        bBkash= (LinearLayout) findViewById(R.id.bkash);
        bNagad= (LinearLayout) findViewById(R.id.nagad);
        bSureCash= (LinearLayout) findViewById(R.id.sureCash);
        bRocket= (LinearLayout) findViewById(R.id.rocket);
        bBkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_mobile_banking.this, bkash.class);
                startActivity(intent);

            }
        });
        bNagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_mobile_banking.this, nagad.class);
                startActivity(intent);
            }
        });
        bSureCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_mobile_banking.this, surecash.class);
                startActivity(intent);

            }
        });
        bRocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_mobile_banking.this,rocket.class);
                startActivity(intent);

            }
        });
    }
}