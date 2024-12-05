package com.example.wscube1.LayoutList;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;
import com.example.wscube1.databinding.ActivityLayoutListBinding;

public class LinearLayout extends AppCompatActivity {
    private ActivityLayoutListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLayoutListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_linear_layout);

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),getString(R.string.Linear_Layout_Demo),true);

    }
}