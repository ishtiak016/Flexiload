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

public class all_pakage_adapter extends RecyclerView.Adapter<all_pakage_adapter.myviewholder>{
List<all_pakage_model> data;
Context context;
private  all_pakage_adapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public void setOnClickListener (historyApdapter.OnItemClickListener listener){
        mListener= (OnItemClickListener) listener;
    }
    public all_pakage_adapter(List<all_pakage_model> data,Context context){
        this.data = data;
        this.context=context;
    }
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_pakage,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  all_pakage_adapter.myviewholder holder, int position) {
        all_pakage_model obj=data.get(position);
        holder.internet.setText(obj.getGb()+"GB");
        holder.minute.setText(obj.getMinute()+"Minute");
        holder.operator.setText(obj.getOperator());
        holder.sms.setText(obj.getSms()+"SMS");
        holder.regularprice.setText("Regular Price :"+obj.getRegularprice());
        holder.days.setText(obj.getDay()+" Days");
        holder.offerprice.setText("Offer Price"+obj.getOfferprice());
        holder.area.setText(obj.getArea());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,pakageBuyPage.class);
                intent.putExtra("id",obj.getId());
                intent.putExtra("internet",obj.getGb());
                intent.putExtra("minute",obj.getMinute());
                intent.putExtra("operator",obj.getOperator());
                intent.putExtra("sms",obj.getSms());
                intent.putExtra("regularPrice",obj.getRegularprice());
                intent.putExtra("days",obj.getDay());
                intent.putExtra("offerPrice",obj.getOfferprice());
                intent.putExtra("area",obj.getArea());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView internet,minute,operator,sms,regularprice,days,offerprice,area;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
          internet=itemView.findViewById(R.id.internet);
          minute=itemView.findViewById(R.id.minute);
          operator=itemView.findViewById(R.id.operator);
          sms=itemView.findViewById(R.id.sms);
          regularprice=itemView.findViewById(R.id.regularPrice);
          days=itemView.findViewById(R.id.days);
          offerprice=itemView.findViewById(R.id.offerPrice);
          area=itemView.findViewById(R.id.area);
        }
    }
}
