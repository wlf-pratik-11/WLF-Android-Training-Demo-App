package com.example.wscube1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityTextviewForListviewBinding;

public class TextviewForListview extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTextviewForListviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTextviewForListviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle the "up" navigation using onBackPressedDispatcher
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}