package com.example.wscube1.SharedPreferencesDemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;
import com.example.wscube1.databinding.ActivitySharedPreferencesBinding;

public class SharedPreferencesActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySharedPreferencesBinding binding;

    Button saveData,clearData;
    private EditText nameSP, emailSP;
    private CheckBox verifiedDataSP;
    private RadioGroup radioGroup;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySharedPreferencesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        nameSP = findViewById(R.id.nameSP);
        emailSP = findViewById(R.id.emailSP);
        verifiedDataSP = findViewById(R.id.verifiedDataSP);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        saveData = findViewById(R.id.saveData);
        clearData = findViewById(R.id.clearData);


        try {
            sharedPreferences = getSharedPreferences("MyShredPref", MODE_PRIVATE);
            String name = sharedPreferences.getString("name", "");
            String email = sharedPreferences.getString("email", "");
            boolean verified = sharedPreferences.getBoolean("verified", false);
            int rBtn = sharedPreferences.getInt("selected_radio_id", -1);

            nameSP.setText(name);
            emailSP.setText(email);
            verifiedDataSP.setChecked(verified);
            radioGroup.check(rBtn);
        } catch (Exception e) {
            Log.d("Radio Button Value", "");
        }
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editText = sharedPreferences.edit();

                editText.putString("name", nameSP.getText().toString());
                editText.putString("email", emailSP.getText().toString());
                editText.putBoolean("verified", verifiedDataSP.isChecked());

                editText.putInt("selected_radio_id", radioGroup.getCheckedRadioButtonId());
                editText.commit();

                Toast.makeText(getApplicationContext(), "Data Successfully Saved..!!", Toast.LENGTH_SHORT).show();

                nameSP.setText("");
                emailSP.setText("");
                verifiedDataSP.setChecked(false);
                radioGroup.clearCheck();

            }
        });

        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences deleteData = getApplicationContext().getSharedPreferences("MyShredPref",MODE_PRIVATE);
                deleteData.edit().clear().commit();
                Toast.makeText(getApplicationContext(),"Data is Cleared..!!",Toast.LENGTH_SHORT).show();

                nameSP.setText("");
                emailSP.setText("");
                verifiedDataSP.setChecked(false);
                radioGroup.clearCheck();
            }
        });


        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Shared Prefernces Demo", true);
    }
}