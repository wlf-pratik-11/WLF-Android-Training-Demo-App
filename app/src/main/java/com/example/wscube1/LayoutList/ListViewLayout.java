package com.example.wscube1.LayoutList;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityListViewLayoutBinding;

import com.example.wscube1.R;

public class ListViewLayout extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityListViewLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListViewLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"ListView Layout Demo",true);

        String lstData[] = {
                "M.S.Dhoni",
                "Ravindra Jadeja",
                "Pathirana",
                "Ruturaj Gayakwad",
                "Suresh Raina",
                "Shivam Dube",
                "Super King",
                "Chennai Super"
        };

        ListView lstView = findViewById(R.id.lstView);
        ArrayAdapter<String> arrayAdapter;

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.card_for_listview,R.id.cardTextview,lstData);
        lstView.setAdapter(arrayAdapter);
    }

}