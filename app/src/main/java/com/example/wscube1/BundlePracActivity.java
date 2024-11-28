package com.example.wscube1;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

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
