package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class noticeBoardAdapter extends RecyclerView.Adapter<noticeBoardAdapter.myviewholder> {
    List<noticeboardModel> data;
    Context context;
    private noticeBoardAdapter.OnItemClickListener mListener;
    public noticeBoardAdapter(List<noticeboardModel> data,Context context) {
        this.data = data;
        this.context=context;
    }
    @Override
    public myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_board_single_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  noticeBoardAdapter.myviewholder holder, int position) {
        noticeboardModel obj=data.get(position);
        holder.nHead.setText(obj.getNoticeheader());
        holder.nBody.setText(obj.getNoticedetails());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public void setOnClickListener (noticeBoardAdapter.OnItemClickListener listener){
        mListener=listener;
    }

    class myviewholder extends RecyclerView.ViewHolder{
       TextView nHead,nBody;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
         nHead=itemView.findViewById(R.id.noticeheadline);
         nBody=itemView.findViewById(R.id.noticeboarddetails);
        }
    }
}
