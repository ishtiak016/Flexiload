package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add_money_history extends AppCompatActivity {
    RecyclerView recyclerView;
    String number;
    List<add_money_history_model> data;
    private APIService addmoneyhistoryApi;
    add_money_history_adapter add_money_history_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money_history);

        addmoneyhistoryApi=ApiUtils.getAPIService();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SessionManagment sessionManagment = new SessionManagment(add_money_history.this);
        number=sessionManagment.getSession();

        Call<List<add_money_history_model>> call=addmoneyhistoryApi.addmoneyhist(number);
        call.enqueue(new Callback<List<add_money_history_model>>() {
            @Override
            public void onResponse(Call<List<add_money_history_model>> call, Response<List<add_money_history_model>> response) {
                data=response.body();
                add_money_history_adapter=new add_money_history_adapter(data,getApplicationContext());
                recyclerView.setAdapter(add_money_history_adapter);
            }

            @Override
            public void onFailure(Call<List<add_money_history_model>> call, Throwable t) {

            }
        });


    }
}