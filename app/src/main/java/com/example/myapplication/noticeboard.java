package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class noticeboard extends AppCompatActivity {
    RecyclerView recyclerView;
    String number;
    List<noticeboardModel> data;
    private APIService noticeboardApi;
    noticeBoardAdapter noticeBoardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticeboard);
        noticeboardApi=ApiUtils.getAPIService();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Call<List<noticeboardModel>> call=noticeboardApi.allnotice();
        call.enqueue(new Callback<List<noticeboardModel>>() {
            @Override
            public void onResponse(Call<List<noticeboardModel>> call, Response<List<noticeboardModel>> response) {
                data=response.body();
                noticeBoardAdapter=new noticeBoardAdapter(data,getApplicationContext());
                recyclerView.setAdapter(noticeBoardAdapter);
            }

            @Override
            public void onFailure(Call<List<noticeboardModel>> call, Throwable t) {

            }
        });

    }
}