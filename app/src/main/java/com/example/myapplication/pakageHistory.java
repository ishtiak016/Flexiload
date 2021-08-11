package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pakageHistory extends AppCompatActivity {
    RecyclerView recyclerView;
    List<pakageHistoryModel> data;
    String number;
    private APIService pakagehistoryApi;
    pakageHistoryApdapter pakageHistoryApdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakage_history);
        pakagehistoryApi=ApiUtils.getAPIService();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SessionManagment sessionManagment = new SessionManagment(pakageHistory.this);
        number=sessionManagment.getSession();
        Call<List<pakageHistoryModel>>call=pakagehistoryApi.pakagehistory(number);
        call.enqueue(new Callback<List<pakageHistoryModel>>() {
            @Override
            public void onResponse(Call<List<pakageHistoryModel>> call, Response<List<pakageHistoryModel>> response) {
                data=response.body();
                pakageHistoryApdapter=new pakageHistoryApdapter(data,getApplicationContext());
                recyclerView.setAdapter(pakageHistoryApdapter);
            }

            @Override
            public void onFailure(Call<List<pakageHistoryModel>> call, Throwable t) {

            }
        });

    }
}