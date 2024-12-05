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

import com.example.wscube1.databinding.ActivityTableLayoutBinding;

import com.example.wscube1.R;

public class TableLayout extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTableLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTableLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),getString(R.string.Table_Layout_Demo),true);

    }

}