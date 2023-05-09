package com.example.projectandroid.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.data.Product;

import java.util.ArrayList;

public class MyHomeRecyclerViewAdapter1 extends RecyclerView.Adapter<MyHomeRecyclerViewAdapter1.MyViewHolder> {

    private Activity activity;
    private int layoutID;
    private ArrayList<Product> listProduct;
    private OnItemClickRecycLerView1 onItemClickRecycLerView1;

    public void setOnItemClickRecycLerView1(OnItemClickRecycLerView1 onItemClickRecycLerView1) {
        this.onItemClickRecycLerView1 = onItemClickRecycLerView1;
    }

    public MyHomeRecyclerViewAdapter1(Activity activity, int layoutID, ArrayList<Product> list) {
        this.activity = activity;
        this.layoutID = layoutID;
        this.listProduct = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        CardView view = (CardView) inflater.inflate(viewType, viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product ld = listProduct.get(position);
        if (ld.getImage().equalsIgnoreCase("onepiece")){
            holder.img.setImageDrawable(activity.getResources().getDrawable(R.drawable.onepiece, activity.getTheme()));
        }
        holder.text.setText(ld.getName()+"");
        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickRecycLerView1.onClickListenner(position, v);
            }
        };
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    public interface OnItemClickRecycLerView1 {
        void onClickListenner(int position, View itemView);
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView text;
        View.OnClickListener onClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgMain);
            text = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onClickListener != null){
                onClickListener.onClick(v);
            }
        }
    }
}
