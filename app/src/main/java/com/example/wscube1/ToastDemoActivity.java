package com.example.wscube1;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityToastDemoBinding;

public class ToastDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityToastDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityToastDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Toast Demo",true);

        Button tostDemoBtn = findViewById(R.id.tostDemoBtn);

        tostDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Tost Demo Running Successfully ..!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_toast_demo);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}