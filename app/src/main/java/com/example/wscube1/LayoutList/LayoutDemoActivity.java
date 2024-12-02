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
            "Android Linear Layout",
            "Android Relative Layout",
            "Android Constraint Layout",
            "Android Frame Layout",
            "Android Table Layout",
            "Android Web View",
            "Android ListView",
            "Android Grid View"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLayoutDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Layout Demo",true);


        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arr;

        arr = new ArrayAdapter<String>(this,R.layout.activity_textview_for_listview,lstData);
        listView.setAdapter(arr);


    }

}