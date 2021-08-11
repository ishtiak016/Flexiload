package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bill_history extends AppCompatActivity {
    RecyclerView recyclerView;
    String number;
    List<bill_history_model> data;
    private APIService billApi;
    bill_history_adapter bill_history_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_history);
        billApi=ApiUtils.getAPIService();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SessionManagment sessionManagment = new SessionManagment(bill_history.this);
        number=sessionManagment.getSession();

        Call<List<bill_history_model>> call=billApi.billhistory(number);
        call.enqueue(new Callback<List<bill_history_model>>() {
            @Override
            public void onResponse(Call<List<bill_history_model>> call, Response<List<bill_history_model>> response) {
                data=response.body();
                bill_history_adapter=new bill_history_adapter(data,getApplicationContext());
                recyclerView.setAdapter(bill_history_adapter);
            }

            @Override
            public void onFailure(Call<List<bill_history_model>> call, Throwable t) {

            }
        });
    }
}