package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class flexiload_history extends AppCompatActivity {
    RecyclerView recyclerView;
    String number;
    List<flexiload_history_model> data;
    private APIService flexiloadhistoryApi;
    flexiload_history_adapter flexiload_history_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexiload_history);
        flexiloadhistoryApi=ApiUtils.getAPIService();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SessionManagment sessionManagment = new SessionManagment(flexiload_history.this);
        number=sessionManagment.getSession();

        Call<List<flexiload_history_model>> call=flexiloadhistoryApi.flexiloadhistoryfunction(number);
        call.enqueue(new Callback<List<flexiload_history_model>>() {
            @Override
            public void onResponse(Call<List<flexiload_history_model>> call, Response<List<flexiload_history_model>> response) {
                data=response.body();
                flexiload_history_adapter=new flexiload_history_adapter(data,getApplicationContext());
                recyclerView.setAdapter(flexiload_history_adapter);

            }

            @Override
            public void onFailure(Call<List<flexiload_history_model>> call, Throwable t) {

            }
        });




    }
}