package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class add_money_history_adapter extends RecyclerView.Adapter<add_money_history_adapter.myviewholder>{
    List<add_money_history_model> data;
    Context context;
    private add_money_history_adapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public add_money_history_adapter(List<add_money_history_model> data, Context context) {
        this.data = data;
        this.context=context;
    }
    @Override
    public myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_money_history_single,parent,false);
        return new add_money_history_adapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  add_money_history_adapter.myviewholder holder, int position) {
        add_money_history_model obj=data.get(position);
        holder.numberL.setText(obj.getNumber());
        holder.tnxId.setText(obj.getTxnid());
        holder.ammountL.setText(obj.getAmmount());
        holder.typeL.setText(obj.getType());
        holder.statusL.setText(obj.getStatus());
        holder.timeL.setText(obj.getTime());
        holder.dateL.setText(obj.getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
      TextView numberL,tnxId,ammountL,typeL,statusL,timeL,dateL;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            numberL=itemView.findViewById(R.id.uNumberS);
            tnxId=itemView.findViewById(R.id.utxnid);
            ammountL=itemView.findViewById(R.id.uAmmount);
            typeL=itemView.findViewById(R.id.uType);
            statusL=itemView.findViewById(R.id.uStatuss);
            timeL=itemView.findViewById(R.id.uTimes);
            dateL=itemView.findViewById(R.id.uDates);

        }
    }
}
