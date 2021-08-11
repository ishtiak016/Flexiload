package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class pakageHistoryApdapter extends RecyclerView.Adapter<pakageHistoryApdapter.myviewholder> {
    List<pakageHistoryModel> data;
    Context context;
    public pakageHistoryApdapter(List<pakageHistoryModel> data,Context context){
        this.data = data;
        this.context=context;
    }
    @Override
    public myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pakage_single_history,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  pakageHistoryApdapter.myviewholder holder, int position) {
        pakageHistoryModel obj=data.get(position);
        holder.internet.setText(obj.getGb()+"GB");
        holder.minute.setText(obj.getMinute()+"Minute");
        holder.operator.setText(obj.getOperator());
        holder.sms.setText(obj.getSms()+"SMS");
        holder.regularprice.setText("Regular Price :"+obj.getRegularprice());
        holder.days.setText(obj.getDay()+" Days");
        holder.offerprice.setText("Offer Price"+obj.getOfferprice());
        holder.area.setText(obj.getArea());
        holder.status.setText(obj.getStatus());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView internet,minute,operator,sms,regularprice,days,offerprice,area,status;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            internet=itemView.findViewById(R.id.internetP);
            minute=itemView.findViewById(R.id.minuteP);
            operator=itemView.findViewById(R.id.operatorP);
            sms=itemView.findViewById(R.id.smsP);
            regularprice=itemView.findViewById(R.id.regularPriceP);
            days=itemView.findViewById(R.id.daysP);
            offerprice=itemView.findViewById(R.id.offerPriceP);
            area=itemView.findViewById(R.id.areaP);
            status=itemView.findViewById(R.id.statuspakageP);

        }
    }
}
