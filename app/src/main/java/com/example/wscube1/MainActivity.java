package com.example.wscube1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.ApiCallDemo.ApiCallDemoActivity;
import com.example.wscube1.BundelDemo.BundelDemoActivity;
import com.example.wscube1.DateTimeDemo.DateAndTimeDemoActivity;
import com.example.wscube1.FragmentDemo.FragmentDemoActivity;
import com.example.wscube1.LayoutList.LayoutListActivity;
import com.example.wscube1.LoadImageNetworkAndGallaryDemo.LoadImageNetworkAndGallaryActivity;
import com.example.wscube1.PassDataDemo.PassDataOneActiityToAnother;
import com.example.wscube1.RecyclerViewDemo.RecyclerViewActivity;
import com.example.wscube1.RelativeScreenDemo.CompatibleScreenActivity;
import com.example.wscube1.SQLiteDemo.SQLiteDemoActivity;
import com.example.wscube1.SharedPreferencesDemo.SharedPreferencesActivity;
import com.example.wscube1.ShimmerDemo.ShimmerDemoActivity;
import com.example.wscube1.ToastDemo.ToastDemoActivity;
import com.example.wscube1.common.CommonFunctions;
import com.example.wscube1.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    TextView mainName,mainEmail;
    private Button logout;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainName = findViewById(R.id.mainName);
        mainEmail = findViewById(R.id.mainEmail);

        SharedPreferences sharedPreferences = getSharedPreferences("accountDetail", MODE_PRIVATE);
        String name = sharedPreferences.getString("userName", "White Lable Fox");
        String email = sharedPreferences.getString("userEmail", "whitelabelfox123@gmail.com");
        mainName.setText(name);
        mainEmail.setText(email);

        //region Drawer Demo

        Toolbar toolbar;

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        NavigationView navigationView = findViewById(R.id.navViewMenuItems);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.layoutDemo){

                    Intent intent = new Intent(getApplicationContext(), LayoutListActivity.class);
                    startActivity(intent);

                }
                else if(id==R.id.fragmentDemo){
                        startActivity(new Intent(getApplicationContext(), FragmentDemoActivity.class));
                }
                else if(id==R.id.bundleDemo){
                    startActivity(new Intent(getApplicationContext(), BundelDemoActivity.class));
                }
                else if(id==R.id.toastDemo){
                    startActivity(new Intent(getApplicationContext(), ToastDemoActivity.class));
                }
                else if(id==R.id.dateTimeDemo){
                    startActivity(new Intent(getApplicationContext(), DateAndTimeDemoActivity.class));
                }
                else if(id==R.id.passDataDemo){
                    startActivity(new Intent(getApplicationContext(), PassDataOneActiityToAnother.class));
                }
                else if(id==R.id.relativeScreenDemo){
                    Intent intent = new Intent(getApplicationContext(), CompatibleScreenActivity.class);
                    startActivity(intent);
                }
                else if(id==R.id.sharedPreferencesDemo){
                    startActivity(new Intent(getApplicationContext(), SharedPreferencesActivity.class));
                }
                else if(id==R.id.loadImageNetworkAndGalleryDemo){
                    startActivity(new Intent(getApplicationContext(), LoadImageNetworkAndGallaryActivity.class));
                }
                else if(id==R.id.recyclerviewDemo){
                    startActivity(new Intent(getApplicationContext(), RecyclerViewActivity.class));
                }
                else if(id==R.id.sqliteDemo){
                    startActivity(new Intent(getApplicationContext(), SQLiteDemoActivity.class));
                }
                else if(id==R.id.shimmerDemo){
                    startActivity(new Intent(getApplicationContext(), ShimmerDemoActivity.class));
                }
                else if(id==R.id.logOut){
                    Log.d("LogOut Button","LogOut Button");
                                // Sign out from Firebase
                                mAuth = FirebaseAuth.getInstance();
                                mAuth.signOut();

                                // Sign out from Google (if you are using Google Sign-In as well)
                                GoogleSignIn.getClient(getApplicationContext(), GoogleSignInOptions.DEFAULT_SIGN_IN).signOut();

                                // Update SharedPreferences to mark the user as logged out
                                SharedPreferences sharedPreferences = getSharedPreferences("Name", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putBoolean("isLoggedIn", false); // Set login status to false
                                editor.commit();

                                // Redirect to the SignInActivity
                                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                                Log.d("Pratik Tank","NotWorking2");
                                startActivity(intent);
                                finish();  // Close the current activity
                }
                else if(id==R.id.apiCallDemo){
                    startActivity(new Intent(getApplicationContext(), ApiCallDemoActivity.class));
                }
                else {
                    Log.d("Pratik Tank","NotWorking2");
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(Color.parseColor("#FFFFFF"));

        toggle.syncState();


        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Main Activity",false);
        //endregion
    }
}

