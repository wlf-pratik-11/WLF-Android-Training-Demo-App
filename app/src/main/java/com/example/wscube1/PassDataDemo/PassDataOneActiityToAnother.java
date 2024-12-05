package com.example.wscube1.PassDataDemo;

import android.content.Intent;
import android.os.Bundle;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityPassDataOneActiityToAnotherBinding;

public class PassDataOneActiityToAnother extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPassDataOneActiityToAnotherBinding binding;

    Button btnFillForm, btnFillForm2;
    TextView formDataView, formDataView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPassDataOneActiityToAnotherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), getString(R.string.pass_data_one_to_other_activity), true);

        formDataView = findViewById(R.id.formDataView);
        formDataView2 = findViewById(R.id.formDataView2);

        btnFillForm = findViewById(R.id.btnFillForm);
        btnFillForm2 = findViewById(R.id.btnFillForm2);

        btnFillForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FillFormActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        btnFillForm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FillFormActivity.class);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_pass_data_one_actiity_to_another);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    formDataView.setText(bundle.getString("name", getString(R.string.name_not_arrived)));
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    formDataView2.setText(bundle.getString("name", getString(R.string.name_not_arrived)));
                }
                break;
            default:
                break;
        }
    }
}
