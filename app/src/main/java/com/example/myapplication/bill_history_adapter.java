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

public class bill_history_adapter extends RecyclerView.Adapter<bill_history_adapter.myviewholder>{
    List<bill_history_model> data;
    Context context;
    private bill_history_adapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public bill_history_adapter(List<bill_history_model> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @Override
    public myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_history_single_row,parent,false);
        return new bill_history_adapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  bill_history_adapter.myviewholder holder, int position) {
        bill_history_model obj=data.get(position);

        holder.billMonth.setText(obj.getBill_month());
        holder.billNumber.setText(obj.getBill_number());
        holder.billstatus.setText(obj.getStatus());
        holder.billtime.setText(obj.getTime());
        holder.billdate.setText(obj.getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
     TextView billMonth,billNumber,ammountBill,billstatus,billtime,billdate;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
         billMonth=itemView.findViewById(R.id.uBillMonthM);
         billNumber=itemView.findViewById(R.id.uBillNumberM);
         ammountBill=itemView.findViewById(R.id.uAmmountM);
         billstatus=itemView.findViewById(R.id.uStatuBillM);
         billtime=itemView.findViewById(R.id.uTimeBillM);
         billdate=itemView.findViewById(R.id.uDateBillM);


        }
    }
}
