package com.example.wscube1.ApiCallDemo;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wscube1.databinding.ActivityApiCallDemoBinding;

import com.example.wscube1.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCallDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityApiCallDemoBinding binding;
    List<UserModel> allUsersList;
    RecyclerView rcvForApi;
    ShimmerFrameLayout shimmerFrameLayout;
    View contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityApiCallDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rcvForApi = findViewById(R.id.rcvForApi);
        rcvForApi.setLayoutManager(new LinearLayoutManager(this));
        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "API Call Demo", true);
        allUsersList = new ArrayList<UserModel>();

        shimmerFrameLayout = findViewById(R.id.shimmerForApiDataCard);

        RetrofitInstance.getInstance().apiInterface.getUser().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {

                allUsersList = response.body();
                ApiCallDemoRecyclerViewAdapter adapter = new ApiCallDemoRecyclerViewAdapter(ApiCallDemoActivity.this, allUsersList);
                rcvForApi.setAdapter(adapter);
                new Handler().postDelayed(() -> {
                shimmerFrameLayout.stopShimmer(); // Stop shimmer effect
                shimmerFrameLayout.setVisibility(View.GONE); // Hide shimmer layout
                rcvForApi.setVisibility(View.VISIBLE);
                }, 5000);


            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable throwable) {
                Log.d("Data Not Arrived..!!","Data Not Arrived..!!");
//                shimmerFrameLayout.stopShimmer();
//                shimmerFrameLayout.setVisibility(View.GONE);
            }
        });


    }
}