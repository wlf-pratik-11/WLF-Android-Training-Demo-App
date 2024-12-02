package com.example.wscube1.BundelDemo;

import android.os.Bundle;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.databinding.ActivityBundlePracBinding;

public class BundlePracActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBundlePracBinding binding;

    TextView txtString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_prac);

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Bundel Demo",true);

        txtString = findViewById(R.id.txtString);

        Bundle bundle = getIntent().getExtras();

        txtString.setText(bundle.getString("key1","No String Arived..!!"));

    }
}
