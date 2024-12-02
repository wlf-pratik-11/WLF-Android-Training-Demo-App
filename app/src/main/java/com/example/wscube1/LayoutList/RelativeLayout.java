package com.example.wscube1.LayoutList;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.service.controls.actions.CommandAction;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityRelativeLayoutBinding;

import com.example.wscube1.R;

public class RelativeLayout extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRelativeLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRelativeLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d("Log Of Relative Layout","Log Of Relative Layout");
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Relative Layout Demo",true);
    }
}