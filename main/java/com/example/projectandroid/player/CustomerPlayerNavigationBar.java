package com.example.projectandroid.player;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.projectandroid.R;

public class CustomerPlayerNavigationBar extends LinearLayout {

    private OnPlayerClickListenner onPlayerClickListenner;
    private ViewGroup group;;
    private OnClickListener onClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.isSelected()){
//                v.setSelected(false);
            }else {
                v.setSelected(true);
                for (int i = 0; i < group.getChildCount(); i++){
                    if (v.getId() != group.getChildAt(i).getId()){
                        group.getChildAt(i).setSelected(false);
                    }
                }
            }

            if (onPlayerClickListenner!=null){
                //Even processing
                int id = v.getId();
                if (id == R.id.imgHome) {
                    onPlayerClickListenner.home(v.isSelected());
                } else if (id == R.id.imgShop) {
                    onPlayerClickListenner.shop(v.isSelected());
                } else if (id == R.id.imgCart) {
                    onPlayerClickListenner.cart(v.isSelected());
                } else if (id == R.id.imgBill) {
                    onPlayerClickListenner.bill(v.isSelected());
                } else if (id == R.id.imgProfile) {
                    onPlayerClickListenner.profile(v.isSelected());
                }
            }
            else {
                //
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Báo lỗi");
                builder.setMessage("Bạn chưa chưa khởi tạo Player");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();

            }

        }
    };

    public CustomerPlayerNavigationBar(Context context) {
        super(context);
        init(context);
    }

    public CustomerPlayerNavigationBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomerPlayerNavigationBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomerPlayerNavigationBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        //Liên kết cái layout player_navigation_bar_layout cho PlayerNavigationBar
        inflate(context, R.layout.player_navigation_bar_layout, this);

        group = (ViewGroup) getChildAt(0);

        ImageView home = findViewById(R.id.imgHome);
        home.setOnClickListener(onClick);
        ImageView shop = findViewById(R.id.imgShop);
        shop.setOnClickListener(onClick);
        ImageView cart = findViewById(R.id.imgCart);
        cart.setOnClickListener(onClick);
        ImageView bill = findViewById(R.id.imgBill);
        bill.setOnClickListener(onClick);
        ImageView profile = findViewById(R.id.imgProfile);
        profile.setOnClickListener(onClick);
    }
    //Interface definition
    public interface OnPlayerClickListenner{
        void home(boolean active);
        void shop(boolean active);
        void cart(boolean active);
        void bill(boolean active);
        void profile(boolean active);
    }
    // Setter
    public void setOnPlayerClickListenner(OnPlayerClickListenner onPlayerClickListenner) {
        this.onPlayerClickListenner = onPlayerClickListenner;
    }
}
