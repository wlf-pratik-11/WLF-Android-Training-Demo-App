package com.example.wscube1.BundelDemo;

import android.content.Intent;
import android.os.Bundle;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityBundelDemoBinding;

public class BundelDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBundelDemoBinding binding;

    Button btnPassData, btnPassNoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBundelDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), getString(R.string.bundel_demo), true);

        btnPassData = findViewById(R.id.btnPassData);
        btnPassNoData = findViewById(R.id.btnPassNoData);

        btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(
                        getString(R.string.key1),
                        getString(R.string.passing_bundle_with_data)
                );
                Intent intent = new Intent(getApplicationContext(), BundlePracActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnPassNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(
                        getString(R.string.key2),
                        getString(R.string.passing_bundle_no_data)
                );
                Intent intent = new Intent(getApplicationContext(), BundlePracActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_bundel_demo);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
