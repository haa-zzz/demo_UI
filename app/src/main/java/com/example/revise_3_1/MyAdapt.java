package com.example.revise_3_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapt extends RecyclerView.Adapter<MyAdapt.ViewHolder> {
    private List<Msg> list = new ArrayList<>();
    public MyAdapt(List<Msg> list){
        this.list = list;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView leftTextView;
        TextView rightTextView;
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftTextView = (TextView)itemView.findViewById(R.id.leftTextView);
            rightTextView = (TextView)itemView.findViewById(R.id.rightTextView);
            leftLayout = (LinearLayout)itemView.findViewById(R.id.left_item);
            rightLayout = (LinearLayout)itemView.findViewById(R.id.right_item);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg msg = list.get(position);
        if(msg.getContent()==Msg.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftTextView.setText(msg.getMessage());
        }else if(msg.getContent() == Msg.TYPE_SEND){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightTextView.setText(msg.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
