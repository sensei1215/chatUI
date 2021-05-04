package com.example.chatui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    String names[],msg[];
    int dp[];
    Context context;

    public  CustomAdapter(Context ct,String[] s,String[] m, int[] i){
        names=s;
        dp=i;
        msg=m;
        context=ct;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_item, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, final int i) {
        customViewHolder.n.setText(names[i]);
        customViewHolder.m.setText(msg[i]);
        customViewHolder.iv.setImageResource(dp[i]);

        customViewHolder.baseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ChatActivity.class);
                intent.putExtra("Name",names[i]);
                intent.putExtra("Message",msg[i]);
                intent.putExtra("DP",dp[i]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView n,m;
        ImageView iv;
        ConstraintLayout baseLayout;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            n=itemView.findViewById(R.id.nameText);
            iv=itemView.findViewById(R.id.dpImage);
            m=itemView.findViewById(R.id.msgText);
            baseLayout=itemView.findViewById(R.id.baseLayout);
        }
    }
}
