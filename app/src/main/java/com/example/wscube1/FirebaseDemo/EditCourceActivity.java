package com.example.wscube1.FirebaseDemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class EditCourceActivity extends AppCompatActivity {

    private TextInputEditText courceName,courcePrice,courceSutedFor,courceImgLink,courceLink,courceDescri;
    private Button updateCource,deleteCource;
    private ProgressBar updateCourceProgressBar;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String CourceID;
    private CourceModel courceModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cource);

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Edit Cource",true);

        firebaseDatabase = FirebaseDatabase.getInstance();

        courceName = findViewById(R.id.courceName);
        courcePrice = findViewById(R.id.courcePrice);
        courceSutedFor = findViewById(R.id.courceSutedFor);
        courceImgLink = findViewById(R.id.courceImgLink);
        courceLink = findViewById(R.id.courceLink);
        courceDescri = findViewById(R.id.courceDescri);
        updateCource = findViewById(R.id.updateCource);
        deleteCource = findViewById(R.id.deleteCource);
        updateCourceProgressBar = findViewById(R.id.updateCourceProgressBar);

        courceModel = getIntent().getParcelableExtra("cource");
        if(courceModel!=null){
            courceName.setText(courceModel.getCourceName());
            courcePrice.setText(courceModel.getCourcePrice());
            courceSutedFor.setText(courceModel.getCourceSutedFor());
            courceImgLink.setText(courceModel.getCourceImgLink());
            courceLink.setText(courceModel.getCourceLink());
            courceDescri.setText(courceModel.getCourceDescri());
            CourceID = courceModel.getCourceID();
        }

        databaseReference = firebaseDatabase.getReference("Cources").child(CourceID);

        updateCource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCourceProgressBar.setVisibility(View.VISIBLE);
                String CourceName = courceName.getText().toString();
                String CourcePrice = courcePrice.getText().toString();
                String CourceSutedFor = courceSutedFor.getText().toString();
                String CourceImgLink = courceImgLink.getText().toString();
                String CourceLink = courceLink.getText().toString();
                String CourceDescri = courceDescri.getText().toString();

                Map<String,Object> map = new HashMap<>();
                map.put("CourceName",CourceName);
                map.put("CourcePrice",CourcePrice);
                map.put("CourceSutedFor",CourceSutedFor);
                map.put("CourceImgLink",CourceImgLink);
                map.put("CourceLink",CourceLink);
                map.put("CourceDescri",CourceDescri);
                map.put("CourceID",CourceID);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        updateCourceProgressBar.setVisibility(View.GONE);
                        databaseReference.updateChildren(map);
                        Toast.makeText(EditCourceActivity.this,"Cource Updated",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(EditCourceActivity.this, FirebaseDemoActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditCourceActivity.this,"Failed to Update Cource",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        deleteCource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteCourceFun();
            }
        });
    }
    private void deleteCourceFun(){
        databaseReference.removeValue();
        Toast.makeText(EditCourceActivity.this,"Cource Deleted",Toast.LENGTH_LONG).show();
        Intent i = new Intent(EditCourceActivity.this, FirebaseDemoActivity.class);
        startActivity(i);
        finish();
    }
}