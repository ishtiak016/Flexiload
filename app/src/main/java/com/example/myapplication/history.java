package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class history extends AppCompatActivity {
    RecyclerView recyclerView;
    String number;
    List<historyModel> data;
    private APIService historyApi;
    historyApdapter historyApdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyApi=ApiUtils.getAPIService();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SessionManagment sessionManagment = new SessionManagment(history.this);
        number=sessionManagment.getSession();

        Call<List<historyModel>> call=historyApi.historyfunction(number);
        call.enqueue(new Callback<List<historyModel>>() {
            @Override

            public void onResponse(Call<List<historyModel>> call, Response<List<historyModel>> response) {

                data=response.body();
                historyApdapter=new historyApdapter(data,getApplicationContext());
                recyclerView.setAdapter(historyApdapter);
            }

            @Override
            public void onFailure(Call<List<historyModel>> call, Throwable t) {
            Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }
}