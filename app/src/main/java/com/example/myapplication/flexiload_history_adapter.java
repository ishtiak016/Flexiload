package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class flexiload_history_adapter extends RecyclerView.Adapter<flexiload_history_adapter.myviewholder>{
    List<flexiload_history_model> data;
    Context context;
    private flexiload_history_adapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnClickListener (flexiload_history_adapter.OnItemClickListener listener){
        mListener=listener;
    }

    public flexiload_history_adapter(List<flexiload_history_model> data,Context context) {
        this.data = data;
        this.context=context;
    }
    @Override
    public flexiload_history_adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.flexiload_single_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  flexiload_history_adapter.myviewholder holder, int position) {
     flexiload_history_model obj=data.get(position);
     holder.usernumber.setText(obj.getNumber());
     holder.ammount.setText(obj.getAmmount());
     holder.operator.setText(obj.getTitle());
     holder.status.setText(obj.getStatus());
     holder.time.setText(obj.getTime());
     holder.date.setText(obj.getDate());
     holder.accounttype.setText(obj.getNumbertype());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView usernumber,ammount,accounttype,operator,status,time,date;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            usernumber=itemView.findViewById(R.id.uNumber);
            ammount=itemView.findViewById(R.id.uAmmount);
            accounttype=itemView.findViewById(R.id.uAccountType);
            operator=itemView.findViewById(R.id.uOperator);
            status=itemView.findViewById(R.id.uStatus);
            time=itemView.findViewById(R.id.uTime);
            date=itemView.findViewById(R.id.uDate);



        }
    }
}
