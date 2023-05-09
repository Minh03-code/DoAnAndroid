package com.example.projectandroid.adapter;

import android.app.Activity;
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

public class MyHomeRecyclerViewAdapter2 extends RecyclerView.Adapter<MyHomeRecyclerViewAdapter2.MyViewHolder> {

    private Activity activity;
    private int layoutID;
    private ArrayList<Product> listProduct;

    private OnItemClickListenner2 onItemClickListenner2;

    public void setOnItemClickListenner2(OnItemClickListenner2 onItemClickListenner2) {
        this.onItemClickListenner2 = onItemClickListenner2;
    }

    public MyHomeRecyclerViewAdapter2(Activity activity, int layoutID, ArrayList<Product> list) {
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
        Product ld1 = listProduct.get(position);
        if (ld1.getImage().equalsIgnoreCase("onepiece")){
            holder.img.setImageDrawable(activity.getResources().getDrawable(R.drawable.onepiece, activity.getTheme()));
        }
        holder.text.setText(ld1.getName()+"");
        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListenner2.onClickListenner(position, v);
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
            if (onClickListener != null){
                onClickListener.onClick(v);
            }
        }
    }

    public interface OnItemClickListenner2 {
        void onClickListenner(int position, View itemView);
    }
}
