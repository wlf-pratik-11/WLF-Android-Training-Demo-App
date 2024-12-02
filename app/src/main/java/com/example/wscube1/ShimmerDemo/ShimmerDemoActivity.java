package com.example.wscube1.ShimmerDemo;

import android.os.Bundle;

import com.example.wscube1.LayoutList.LinearLayout;
import com.example.wscube1.common.CommonFunctions;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.service.controls.actions.CommandAction;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityShimmerDemoBinding;

import com.example.wscube1.R;

public class ShimmerDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityShimmerDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShimmerDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ShimmerFrameLayout shimmer = findViewById(R.id.shimmer_view_container);
        View contentLayout = findViewById(R.id.actualLogo);

        // Show actual content after 10 seconds
        new Handler().postDelayed(() -> {
            shimmer.stopShimmer(); // Stop shimmer effect
            shimmer.setVisibility(View.GONE); // Hide shimmer layout
            contentLayout.setVisibility(View.VISIBLE); // Show actual content
        }, 10000); // 10 seconds

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Shimmer Demo",true);

    }
}