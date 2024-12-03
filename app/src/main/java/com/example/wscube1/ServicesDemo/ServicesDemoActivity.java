package com.example.wscube1.ServicesDemo;

import static android.app.Service.START_STICKY;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.databinding.ActivityServicesDemoBinding;

import com.example.wscube1.R;

public class ServicesDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityServicesDemoBinding binding;
    Button startMedia,stopMedia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityServicesDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),getString(R.string.android_services_demo),true);

        startMedia = findViewById(R.id.startMedia);
        stopMedia = findViewById(R.id.stopMedia);

        startMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), NewService.class));
            }
        });

        stopMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(),NewService.class));

            }
        });
    }
}