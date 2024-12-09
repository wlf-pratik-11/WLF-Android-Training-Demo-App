package com.example.wscube1.FirebaseDemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wscube1.databinding.ActivityFirebaseDemoBinding;

import com.example.wscube1.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FirebaseDemoActivity extends AppCompatActivity implements CourceRVAdapter.CourceClickInterface {

    private AppBarConfiguration appBarConfiguration;
    private ActivityFirebaseDemoBinding binding;
    private RecyclerView rcvForCource;
    private RelativeLayout CourceBottomSheet;
    private ProgressBar mainProgressBar;
    private FloatingActionButton addCourceFloatingButton;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<CourceModel> courceModelsArrayList;
    private CourceRVAdapter courceRVAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFirebaseDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Firebase Realtimedatabse Demo",true);

        CourceBottomSheet = findViewById(R.id.CourceBottomSheet);
        rcvForCource = findViewById(R.id.rcvForCource);
        mainProgressBar = findViewById(R.id.mainProgressBar);
        addCourceFloatingButton = findViewById(R.id.addCourceFloatingButton);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Cources");
        courceModelsArrayList = new ArrayList<>();

        courceRVAdapter = new CourceRVAdapter(courceModelsArrayList,this,this);

        rcvForCource.setLayoutManager(new LinearLayoutManager(this));
        rcvForCource.setAdapter(courceRVAdapter);

        addCourceFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirebaseDemoActivity.this, AddCourceActivity.class);
                startActivity(i);

            }
        });
        getAllCources();
    }

    private void getAllCources(){
        courceModelsArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                mainProgressBar.setVisibility(View.GONE);
                courceModelsArrayList.add(snapshot.getValue(CourceModel.class));
                courceRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                mainProgressBar.setVisibility(View.GONE);
                courceRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                mainProgressBar.setVisibility(View.GONE);
                courceRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                mainProgressBar.setVisibility(View.GONE);
                courceRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onCourceClick(int position) {
        displayBottomSheet(courceModelsArrayList.get(position));
    }

    private void displayBottomSheet(CourceModel courceModel){
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View layout = LayoutInflater.from(this).inflate(R.layout.cource_bottom_sheet,CourceBottomSheet);
        bottomSheetDialog.setContentView(layout);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.show();

        TextView CourceName,CourceDescripton,CourceSutedFor,CourcePrice;
        ImageView CourceImage;
        Button EditCource,ViewDetail;

        CourceName = layout.findViewById(R.id.CourceName);
        CourceDescripton = layout.findViewById(R.id.CourceDescripton);
        CourceSutedFor = layout.findViewById(R.id.CourceSutedFor);
        CourcePrice = layout.findViewById(R.id.CourcePrice);
        CourceImage = layout.findViewById(R.id.CourceImage);
        EditCource = layout.findViewById(R.id.EditCource);
        ViewDetail = layout.findViewById(R.id.ViewDetail);

        CourceName.setText(courceModel.getCourceName());
        CourceDescripton.setText(courceModel.getCourceDescri());
        CourceSutedFor.setText(courceModel.getCourceSutedFor());
        CourcePrice.setText("Rs. "+courceModel.getCourcePrice());
        Picasso.get().load(courceModel.getCourceImgLink()).into(CourceImage);

        EditCource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirebaseDemoActivity.this,EditCourceActivity.class);
                i.putExtra("cource",courceModel);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

            }
        });

        ViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(courceModel.getCourceLink()));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }
}