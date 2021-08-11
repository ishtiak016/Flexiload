package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class all_pakage_all_operator extends AppCompatActivity {
    LinearLayout grameenphone,airtel,banglalink,robi,teletalk,pakagehistoryj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_pakage_all_operator);
        grameenphone=(LinearLayout)findViewById(R.id.grameenPhone);
        pakagehistoryj=(LinearLayout)findViewById(R.id.historypakageM);
        airtel=(LinearLayout)findViewById(R.id.airtel);
        banglalink=(LinearLayout)findViewById(R.id.banglalink);
        robi=(LinearLayout)findViewById(R.id.robi);
        teletalk=(LinearLayout)findViewById(R.id.teletalk);
        grameenphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(all_pakage_all_operator.this,allPakage.class);
                String orr="Grameenphone";
                intent.putExtra("message",orr);
                startActivity(intent);
            }
        });
        airtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(all_pakage_all_operator.this,allPakage.class);
                String orr="Airtel";
                intent.putExtra("message",orr);
                startActivity(intent);
            }
        });
        banglalink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(all_pakage_all_operator.this,allPakage.class);
                String orr="Banglalink";
                intent.putExtra("message",orr);
                startActivity(intent);
            }
        });
        robi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(all_pakage_all_operator.this,allPakage.class);
                String orr="Robi";
                intent.putExtra("message",orr);
                startActivity(intent);
            }
        });
        teletalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(all_pakage_all_operator.this,allPakage.class);
                String orr="Teletalk";
                intent.putExtra("message",orr);
                startActivity(intent);
            }
        });
        pakagehistoryj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(all_pakage_all_operator.this,pakageHistory.class);
                startActivity(intent);
            }
        });

    }
}