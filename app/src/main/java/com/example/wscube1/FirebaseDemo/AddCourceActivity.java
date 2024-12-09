package com.example.wscube1.FirebaseDemo;

import android.content.Intent;
import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityAddCourceBinding;

import com.example.wscube1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddCourceActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityAddCourceBinding binding;
    private TextInputEditText courceName, courcePrice, courceSutedFor, courceImgLink, courceLink, courceDescri;
    private Button addCource;
    private ProgressBar addCourceProgressBar;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String CourceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cource);
        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Add Cource", true);

        courceName = findViewById(R.id.courceName);
        courcePrice = findViewById(R.id.courcePrice);
        courceSutedFor = findViewById(R.id.courceSutedFor);
        courceImgLink = findViewById(R.id.courceImgLink);
        courceLink = findViewById(R.id.courceLink);
        courceDescri = findViewById(R.id.courceDescri);
        addCource = findViewById(R.id.addCource);
        addCourceProgressBar = findViewById(R.id.addCourceProgressBar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Cources");

        addCource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCourceProgressBar.setVisibility(View.VISIBLE);

                String CourceName = courceName.getText().toString();
                String CourcePrice = courcePrice.getText().toString();
                String CourceSutedFor = courceSutedFor.getText().toString();
                String CourceImgLink = courceImgLink.getText().toString();
                String CourceLink = courceLink.getText().toString();
                String CourceDescri = courceDescri.getText().toString();
                CourceID = CourceName;

                CourceModel courceModel = new CourceModel(
                        CourceName,
                        CourcePrice,
                        CourceSutedFor,
                        CourceImgLink,
                        CourceLink,
                        CourceDescri,
                        CourceID
                );

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        addCourceProgressBar.setVisibility(View.GONE);
                        databaseReference.child(CourceID).setValue(courceModel);
                        Toast.makeText(AddCourceActivity.this, "Cource Added Succesfully", Toast.LENGTH_LONG).show();
                        courceName.setText("");
                        courcePrice.setText("");
                        courceSutedFor.setText("");
                        courceImgLink.setText("");
                        courceLink.setText("");
                        courceDescri.setText("");
                        Intent i = new Intent(AddCourceActivity.this, FirebaseDemoActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        addCourceProgressBar.setVisibility(View.GONE);
                        Toast.makeText(AddCourceActivity.this, "Error is :" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}