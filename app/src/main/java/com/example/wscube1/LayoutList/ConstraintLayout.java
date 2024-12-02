package com.example.wscube1.LayoutList;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityConstraintLayoutBinding;

import com.example.wscube1.R;

public class ConstraintLayout extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityConstraintLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityConstraintLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Constraint Layout Demo",true);
    }

}