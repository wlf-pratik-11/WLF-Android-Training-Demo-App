package com.example.wscube1.PassDataDemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

public class FillFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fill_form);

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Pass Data Demo",true);

        Button doneFillData = findViewById(R.id.doneFillData);
        EditText nameFillData = findViewById(R.id.nameFillData);

        doneFillData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name",nameFillData.getText().toString());
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}