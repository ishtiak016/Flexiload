package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class historyApdapter  extends RecyclerView.Adapter<historyApdapter.myviewholder> {

    List<historyModel> data;
    Context context;
    private historyApdapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnClickListener (OnItemClickListener listener){
        mListener=listener;
    }

    public historyApdapter(List<historyModel> data,Context context) {
        this.data = data;
        this.context=context;
    }
    @Override
    public myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_history,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull historyApdapter.myviewholder holder, int position) {
        historyModel obj=data.get(position);
        holder.userNumber.setText(obj.getUsernumber());
        holder.userAmmount.setText(obj.getAmmount());
        holder.userTitle.setText(obj.getTitle());
        holder.userStatus.setText(obj.getStatus());
        holder.userTime.setText(obj.getTime());
        holder.userDate.setText(obj.getDate());
        holder.uAccountType.setText(obj.getAccount());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView userNumber,userAmmount,userTitle,userStatus,userTime,userDate,uAccountType;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            userNumber=itemView.findViewById(R.id.uName);
            userAmmount=itemView.findViewById(R.id.uAmmount);
            userTitle=itemView.findViewById(R.id.uTitle);
            userStatus=itemView.findViewById(R.id.uStatus);
            userTime=itemView.findViewById(R.id.uTime);
            userDate=itemView.findViewById(R.id.uDate);
            uAccountType=itemView.findViewById(R.id.uAccount);
        }
    }
}
