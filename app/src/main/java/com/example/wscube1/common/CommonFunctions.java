package com.example.wscube1.common;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.wscube1.R;

public class CommonFunctions {

    public  static void appBarAndStatusBarThemeChange(@NonNull Context context, Activity activity, Window window, String titleName,boolean showBacButton) {
        window.setStatusBarColor(ContextCompat.getColor(context, R.color.dBlue));
        View decorView = window.getDecorView(); //set status background black
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//set status text  light
        TextView toolbarTextView =  activity.findViewById(R.id.toolbarTextView);

        toolbarTextView.setText(titleName);

        if(showBacButton) {
            Toolbar toolbar =  activity.findViewById(R.id.toolBar);

            toolbar.setNavigationIcon(R.drawable.arrow_back);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });

        }


    }
}
