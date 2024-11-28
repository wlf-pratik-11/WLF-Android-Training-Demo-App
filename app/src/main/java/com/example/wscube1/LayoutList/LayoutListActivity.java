package com.example.wscube1.LayoutList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

public class LayoutListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_list);

        Button listBtn1 = findViewById(R.id.listBtn1);

        // Apply theme changes
        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Layout List",true);


        // Set the onClickListener for listBtn1
        listBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LinearLayout.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Using onBackPressedDispatcher to handle the "up" navigation
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
