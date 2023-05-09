package com.example.projectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.projectandroid.fragment.AbstracsFragment;
import com.example.projectandroid.fragment.BillFragment;
import com.example.projectandroid.fragment.CartFragment;
import com.example.projectandroid.fragment.ChangePasswordFragment;
import com.example.projectandroid.fragment.DetailFragment;
import com.example.projectandroid.fragment.EditProfileFragment;
import com.example.projectandroid.fragment.HomeFragment;
import com.example.projectandroid.fragment.LoginFragment;
import com.example.projectandroid.fragment.OrderFragment;
import com.example.projectandroid.fragment.ProductByTitleFragment;
import com.example.projectandroid.fragment.ProfileFragment;
import com.example.projectandroid.fragment.RegisterFragment;
import com.example.projectandroid.fragment.ResultSearchFragment;
import com.example.projectandroid.fragment.ShopFragment;
import com.example.projectandroid.player.CustomerPlayerNavigationBar;

public class CustomerActivity extends AppCompatActivity {
    public static final int HOME_ID = 0;
    public static final int SHOP_ID = 1;
    public static final int CART_ID = 2;
    public static final int BILL_ID = 3;
    public static final int PROFILE_ID = 4;
    public static final int DETAIL_ID = 5;
    public static final int ORDER_ID = 6;
    public static final int EDIT_PROFILE_ID = 7;
    public static final int CHANGE_PASSWORD_ID = 8;
    public static final int RESULT_SEARCH_ID = 9;
    public static final int PRODUCT_BY_TITLE = 10;
    public static final int LOGIN_ID = 11;
    public static final int REGISTER_ID = 12;

//    Navigation bar and Naviagtion view
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private CustomerPlayerNavigationBar playerNavigationBar;
    private Toolbar toolbar;

    private ImageView btnSearchIcon;
    private EditText edtSearch;
//    Fragment
    public static int screenID;
    public static AbstracsFragment fragment;
    public static FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_customer_layout);

        FrameLayout frameLayout = findViewById(R.id.drawMainLayout);
        Button btnOrder = findViewById(R.id.btnOrder);
        Button btnEditProfile = findViewById(R.id.btnEditProfile);
        Button btnChangePassword = findViewById(R.id.btnChangePassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        getLayoutInflater().inflate(R.layout.main_layout, frameLayout);

        edtSearch = findViewById(R.id.edtSearch);
        btnSearchIcon = findViewById(R.id.imgSearch);
        playerNavigationBar = findViewById(R.id.playerNavigationBarID);
        toolbar = findViewById(R.id.toolbar);

        ///////////////////////////////////////////////////////////////////////////
        //   Nút chuyển màn hình để mọi người chạy thử màn hình mình làm         //
        //   Những cái này sau khi làm xong sẽ xóa                               //


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenID = ORDER_ID;
                updateUI();
            }
        });

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenID = EDIT_PROFILE_ID;
                updateUI();
            }
        });
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenID = CHANGE_PASSWORD_ID;
                updateUI();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenID = LOGIN_ID;
                updateUI();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenID = REGISTER_ID;
                updateUI();
            }
        });
        /////                        END                               ////////////
        ///////////////////////////////////////////////////////////////////////////


        btnSearchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenID = RESULT_SEARCH_ID;
                updateUI();
            }
        });

        playerNavigationBar.setOnPlayerClickListenner(new CustomerPlayerNavigationBar.OnPlayerClickListenner() {
            @Override
            public void home(boolean active) {
                screenID = HOME_ID;
                updateUI();
            }

            @Override
            public void shop(boolean active) {
                screenID = SHOP_ID;
                updateUI();
            }

            @Override
            public void cart(boolean active) {
                screenID = CART_ID;
                updateUI();
            }

            @Override
            public void bill(boolean active) {
                screenID = BILL_ID;
                updateUI();
            }

            @Override
            public void profile(boolean active) {
                screenID = PROFILE_ID;
                updateUI();
            }
        });
    }


    // Hiển thị dấu menu mở ra và đóng
    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout , R.string.drawerOpen , R.string.drawerClose);
        drawerLayout.addDrawerListener(drawerToggle);
        //Đồng bộ
        drawerToggle.syncState();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void updateUI() {
        if (getSupportFragmentManager().findFragmentByTag(screenID+"") != null){
            fragment = (AbstracsFragment) getSupportFragmentManager().findFragmentByTag(screenID+"");
        }
        else {
            if (screenID == HOME_ID){
                fragment = new HomeFragment();
            }
            if (screenID == SHOP_ID){
                fragment = new ShopFragment();
            }
            if (screenID == CART_ID){
                fragment = new CartFragment();
            }
            if (screenID == BILL_ID){
                fragment = new BillFragment();
            }
            if (screenID == PROFILE_ID){
                fragment = new ProfileFragment();
            }
            if (screenID == DETAIL_ID){
                fragment = new DetailFragment();
            }
            if (screenID == ORDER_ID){
                fragment = new OrderFragment();
            }
            if (screenID == EDIT_PROFILE_ID){
                fragment = new EditProfileFragment();
            }
            if (screenID == CHANGE_PASSWORD_ID){
                fragment = new ChangePasswordFragment();
            }
            if (screenID == RESULT_SEARCH_ID){
                fragment = new ResultSearchFragment();
            }
            if (screenID == PRODUCT_BY_TITLE){
                fragment = new ProductByTitleFragment();
            }
            if (screenID == LOGIN_ID){
                fragment = new LoginFragment();
            }
            if (screenID == REGISTER_ID){
                fragment = new RegisterFragment();
            }
        }

        if (fragment != null){
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_content, fragment, screenID+"");
            if (getSupportFragmentManager().findFragmentByTag(screenID+"") == null){
                transaction.addToBackStack(screenID+"");
            }
            transaction.commit();
        }
    }
}