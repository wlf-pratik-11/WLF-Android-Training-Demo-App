package com.example.wscube1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.example.wscube1.common.Contact;
import com.example.wscube1.common.DatabaseHandler;
import com.example.wscube1.common.RecyclerViewAdapter;
import com.example.wscube1.common.RecyclerViewAdapterForSQLiteDemo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.service.controls.actions.CommandAction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wscube1.databinding.ActivitySqliteDemoBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLiteDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySqliteDemoBinding binding;
    TextView contactName,contactNumber;
    FloatingActionButton addContact;
    RecyclerView contactListView;
    private static final int ADD_CONTACT_REQ_CODE = 100;
    DatabaseHandler databaseHandler = new DatabaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySqliteDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        contactListView = binding.contactListView;

        contactListView = findViewById(R.id.contactListView);
        contactName = findViewById(R.id.contactName);
        contactNumber = findViewById(R.id.contactNumber);
        addContact = findViewById(R.id.addContact);

        //region ToolBar
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"SQLite Demo",true);
        //endregion

        contactListView.setLayoutManager(new LinearLayoutManager(this));
        List<Contact> contacts = databaseHandler.getAllContacts();
        contactListView.setPadding(0,0,0,200);
        contactListView.setClipToPadding(false);
        RecyclerViewAdapterForSQLiteDemo adapter = new RecyclerViewAdapterForSQLiteDemo(this,this,contacts);
        contactListView.setAdapter(adapter);

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),AddContactPageActivity.class);
            startActivityForResult(intent,ADD_CONTACT_REQ_CODE);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sqlite_demo);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:
                    if(resultCode==RESULT_OK){
                        String id = data.getStringExtra("id");
                        String name = data.getStringExtra("name");
                        String phoneNumber = data.getStringExtra("phoneNumber");

                        if (id == null) {
                            // Add new contact

                            databaseHandler.addContact(new Contact(name, phoneNumber));
                        } else {
                            // Update existing contact
                            Contact contact = new Contact(Integer.parseInt(id), name, phoneNumber);
                            databaseHandler.updateContact(contact);
                        }
                        List<Contact> contacts = databaseHandler.getAllContacts();
                        RecyclerViewAdapterForSQLiteDemo adapter = new RecyclerViewAdapterForSQLiteDemo(this,this,contacts);
                        adapter.notifyDataSetChanged();
                        contactListView.setAdapter(adapter);

                    }
                break;
            default:
                Log.d("ADD_CONTACT_REQ_CODE",requestCode+"  "+"RequestCode2");
                break;
        }
    }
}