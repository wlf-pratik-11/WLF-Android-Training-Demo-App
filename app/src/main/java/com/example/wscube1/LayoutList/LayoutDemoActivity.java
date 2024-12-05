package com.example.wscube1.LayoutList;

import android.os.Bundle;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.databinding.ActivityLayoutDemoBinding;

public class LayoutDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLayoutDemoBinding binding;
    ListView listView;
    String lstData[] = {
            getString(R.string.android_linear_layout)     ,
            getString(R.string.android_relative_layout)   ,
            getString(R.string.android_constraint_layout) ,
            getString(R.string.android_frame_layout)      ,
            getString(R.string.android_table_layout)      ,
            getString(R.string.android_web_view)          ,
            getString(R.string.android_listview)         ,
            getString(R.string.android_grid_view)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLayoutDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),getString(R.string.layout_demo),true);


        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arr;

        arr = new ArrayAdapter<String>(this,R.layout.activity_textview_for_listview,lstData);
        listView.setAdapter(arr);


    }

}