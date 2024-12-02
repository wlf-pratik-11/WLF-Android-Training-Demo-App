package com.example.wscube1.RelativeScreenDemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;

public class CompatibleScreenActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

//    MaterialCardView card1 = findViewById(R.id.card1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatible_screen);

        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Compatible Screen Demo",true);

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

    @Override
    public boolean onSupportNavigateUp() {
        // Handle the "up" navigation using onBackPressedDispatcher
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
