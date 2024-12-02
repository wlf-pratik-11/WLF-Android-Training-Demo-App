package com.example.wscube1.FragmentDemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;
import com.example.wscube1.databinding.ActivityFragmentDemoBinding;

public class FragmentDemoActivity extends AppCompatActivity {

    private ActivityFragmentDemoBinding binding;
    private Button btnFrag1, btnFrag2, btnFrag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFragmentDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Fragment Demo", true);

        btnFrag1 = findViewById(R.id.btn1);
        btnFrag2 = findViewById(R.id.btn2);
        btnFrag3 = findViewById(R.id.btn3);

        btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button 1 is clicked..!!", Toast.LENGTH_SHORT).show();
                replaceFragment(new AFragment());
            }
        });

        btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button 2 is clicked..!!", Toast.LENGTH_SHORT).show();
                replaceFragment(new BFragment());
            }
        });

        btnFrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button 3 is clicked..!!", Toast.LENGTH_SHORT).show();
                replaceFragment(new CFragment());
            }
        });
    }

    private void replaceFragment(androidx.fragment.app.Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fram1, fragment);
        ft.commit();
    }
}
