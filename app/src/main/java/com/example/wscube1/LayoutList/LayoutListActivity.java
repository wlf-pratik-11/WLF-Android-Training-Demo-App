package com.example.wscube1.LayoutList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

public class LayoutListActivity extends AppCompatActivity {

    Button listBtn1,listBtn2,listBtn3,listBtn4,listBtn5,listBtn6,listBtn7,listBtn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_list);

        listBtn1 = findViewById(R.id.listBtn1);
        listBtn2 = findViewById(R.id.listBtn2);
        listBtn3 = findViewById(R.id.listBtn3);
        listBtn4 = findViewById(R.id.listBtn4);
        listBtn5 = findViewById(R.id.listBtn5);
        listBtn6 = findViewById(R.id.listBtn6);
        listBtn7 = findViewById(R.id.listBtn7);
        listBtn8 = findViewById(R.id.listBtn8);

        // Apply theme changes
        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), getString(R.string.Layout_List),true);


        // Set the onClickListener for listBtn1
        listBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LinearLayout.class));
            }
        });
        listBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RelativeLayout.class));
            }
        });
        listBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ConstraintLayout.class));
            }
        });
        listBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FrameLayout.class));
            }
        });
        listBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TableLayout.class));
            }
        });
        listBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WebViewLayout.class));
            }
        });
        listBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListViewLayout.class));
            }
        });
        listBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GridViewLayout.class));
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
