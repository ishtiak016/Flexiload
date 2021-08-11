package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class pakageDataAdapter extends RecyclerView.Adapter<pakageDataAdapter.myviewholder> {

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_pakage,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pakageDataAdapter.myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class myviewholder extends RecyclerView.ViewHolder{

        public myviewholder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
