package com.example.wscube1.SQLiteDemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;
import com.example.wscube1.databinding.AddOrEditContactBinding;


public class AddContactPageActivity extends AppCompatActivity {
    private AddOrEditContactBinding binding;

    Button saveContact;
    EditText nameAdd,phoneNumberAdd;
    private String id = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddOrEditContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"Add/Edit Contact",true);

        saveContact = findViewById(R.id.saveContact);
        nameAdd = findViewById(R.id.nameAdd);
        phoneNumberAdd = findViewById(R.id.phoneNumberAdd);

        //region Put Data in Add contact Page Edit Text field if intent Has ID
        Intent intent = getIntent();
        if (intent.hasExtra("id")) {
            id = intent.getStringExtra("id");
            nameAdd.setText(intent.getStringExtra("name"));
            phoneNumberAdd.setText(intent.getStringExtra("phoneNumber"));
        }
        //endregion

        saveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameAdd.getText().toString();
                String phoneNumber = phoneNumberAdd.getText().toString();

                if (name.isEmpty() || phoneNumber.isEmpty()) {
                    if (name.isEmpty()) {
                        nameAdd.setError("Name is required");
                    }
                    if (phoneNumber.isEmpty()) {
                        phoneNumberAdd.setError("Phone Number is required");
                    }
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                bundle.putString("name", name);
                bundle.putString("phoneNumber", phoneNumber);

                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });



    }
}











