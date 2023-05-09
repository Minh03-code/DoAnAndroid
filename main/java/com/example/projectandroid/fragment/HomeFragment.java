package com.example.projectandroid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.CustomerActivity;
import com.example.projectandroid.R;
import com.example.projectandroid.adapter.MyHomeRecyclerViewAdapter1;
import com.example.projectandroid.adapter.MyHomeRecyclerViewAdapter2;
import com.example.projectandroid.data.Product;

import java.util.ArrayList;

public class HomeFragment extends AbstracsFragment {
    private TextView textView;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private ArrayList<Product> listProductNew;
    private MyHomeRecyclerViewAdapter1 myRecyclerViewAdapter1;
    private MyHomeRecyclerViewAdapter2 myRecyclerViewAdapter2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.fragment_home_layout, container, false);

        listProductNew = new ArrayList<>();

        anhXa(fragmentLayout);
        duLieuGia(listProductNew);
        doDuLieuRecyclerview1();
        doDuLieuRecyclerview2();

        batSuKienChoNutXemThem();
        batSuKienChoItemRecyclerView1();
        batSuKienChoItemRecyclerView2();
        return fragmentLayout;
    }

    private void batSuKienChoItemRecyclerView1() {
        myRecyclerViewAdapter1.setOnItemClickRecycLerView1(new MyHomeRecyclerViewAdapter1.OnItemClickRecycLerView1() {
            @Override
            public void onClickListenner(int position, View itemView) {
                goToDetailScreen();
            }
        });
    }

    private void batSuKienChoItemRecyclerView2() {
        myRecyclerViewAdapter2.setOnItemClickListenner2(new MyHomeRecyclerViewAdapter2.OnItemClickListenner2() {
            @Override
            public void onClickListenner(int position, View itemView) {
                goToDetailScreen();
            }
        });
    }

    //Chuyển tới màn hình thông tin chi tiết của sản phẩm
    public void goToDetailScreen(){
        CustomerActivity.screenID = CustomerActivity.DETAIL_ID;
        if (getActivity().getSupportFragmentManager().findFragmentByTag(CustomerActivity.screenID+"") != null){
            CustomerActivity.fragment = (AbstracsFragment) getActivity().getSupportFragmentManager().findFragmentByTag(CustomerActivity.screenID+"");
        }
        else {
            CustomerActivity.fragment = new DetailFragment();
        }

        if (CustomerActivity.fragment != null){
            CustomerActivity.transaction = getActivity().getSupportFragmentManager().beginTransaction();
            CustomerActivity.transaction.replace(R.id.fragment_content, CustomerActivity.fragment, CustomerActivity.screenID+"");
            if (getActivity().getSupportFragmentManager().findFragmentByTag(CustomerActivity.screenID+"") == null){
                CustomerActivity.transaction.addToBackStack(CustomerActivity.screenID+"");
            }
            CustomerActivity.transaction.commit();
        }
    }

    private void batSuKienChoNutXemThem(){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMoreViewScreen();
            }
        });
    }
    //Chuyển tới màn hình xem thêm
    public void goToMoreViewScreen(){
        CustomerActivity.screenID = CustomerActivity.PRODUCT_BY_TITLE;
        if (getActivity().getSupportFragmentManager().findFragmentByTag(CustomerActivity.screenID+"") != null){
            CustomerActivity.fragment = (AbstracsFragment) getActivity().getSupportFragmentManager().findFragmentByTag(CustomerActivity.screenID+"");
        }
        else {
            CustomerActivity.fragment = new ProductByTitleFragment();
        }

        if (CustomerActivity.fragment != null){
            CustomerActivity.transaction = getActivity().getSupportFragmentManager().beginTransaction();
            CustomerActivity.transaction.replace(R.id.fragment_content, CustomerActivity.fragment, CustomerActivity.screenID+"");
            if (getActivity().getSupportFragmentManager().findFragmentByTag(CustomerActivity.screenID+"") == null){
                CustomerActivity.transaction.addToBackStack(CustomerActivity.screenID+"");
            }
            CustomerActivity.transaction.commit();
        }
    }

    private void duLieuGia(ArrayList<Product> listProductNew) {
        listProductNew.add(new Product(1, "onepiece 100", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(2, "onepiece 111", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(3, "onepiece 222", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(4, "onepiece 333", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(5, "onepiece 444", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(6, "onepiece 666", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(7, "onepiece 777", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(8, "onepiece 888", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(9, "onepiece 999", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(10, "onepiece 10", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(11, "onepiece 11", "Mo ta", 10000, 20, "onepiece", 1, 1));
        listProductNew.add(new Product(12, "onepiece 12", "Mo ta", 10000, 20, "onepiece", 1, 1));
    }

    private void doDuLieuRecyclerview1() {
        myRecyclerViewAdapter1 = new MyHomeRecyclerViewAdapter1( getActivity(), R.layout.cart_view_1_layout, listProductNew);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(myRecyclerViewAdapter1);
    }
    private void doDuLieuRecyclerview2() {
        myRecyclerViewAdapter2 = new MyHomeRecyclerViewAdapter2( getActivity(), R.layout.cart_view_2_layout, listProductNew);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(myRecyclerViewAdapter2);
    }

    private void anhXa(View fragmentLayout) {
        textView = fragmentLayout.findViewById(R.id.tvMoreView);
        recyclerView1 = fragmentLayout.findViewById(R.id.recyclerView1);
        recyclerView2 = fragmentLayout.findViewById(R.id.recyclerView2);

    }
}
