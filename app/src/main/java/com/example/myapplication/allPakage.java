package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class allPakage extends AppCompatActivity {
    RecyclerView recyclerView;
    String number;
    List<all_pakage_model> data;
    private APIService allpakageApi;
    all_pakage_adapter all_pakage_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_pakage);

        allpakageApi=ApiUtils.getAPIService();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        number=getIntent().getStringExtra("message");;
    Call<List<all_pakage_model>> call=allpakageApi.allpakageQuery(number);
    call.enqueue(new Callback<List<all_pakage_model>>() {
        @Override
        public void onResponse(Call<List<all_pakage_model>> call, Response<List<all_pakage_model>> response) {
            data=response.body();

            all_pakage_adapter=new all_pakage_adapter(data,getApplicationContext());
            recyclerView.setAdapter(all_pakage_adapter);
        }

        @Override
        public void onFailure(Call<List<all_pakage_model>> call, Throwable t) {

        }
    });




    }
}