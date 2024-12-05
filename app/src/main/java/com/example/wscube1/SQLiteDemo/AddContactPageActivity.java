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
    private String contactId = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddOrEditContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Change theme for app bar and status bar
        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), getString(R.string.add_edit_contact_title), true);

        // Initialize UI elements
        EditText nameAdd = binding.nameAdd;
        EditText phoneNumberAdd = binding.phoneNumberAdd;
        Button saveContact = binding.saveContact;

        // Check if there is data to edit
        Intent intent = getIntent();
        if (intent.hasExtra("id")) {
            contactId = intent.getStringExtra("id");
            nameAdd.setText(intent.getStringExtra("name"));
            phoneNumberAdd.setText(intent.getStringExtra("phoneNumber"));
        }

        // Handle save button click
        saveContact.setOnClickListener(view -> {
            String name = nameAdd.getText().toString();
            String phoneNumber = phoneNumberAdd.getText().toString();

            // Validation for empty fields
            if (name.isEmpty() || phoneNumber.isEmpty()) {
                if (name.isEmpty()) {
                    nameAdd.setError(getString(R.string.error_name_required));
                }
                if (phoneNumber.isEmpty()) {
                    phoneNumberAdd.setError(getString(R.string.error_phone_required));
                }
                return;
            }

            // Prepare data to send back to the calling activity
            Bundle bundle = new Bundle();
            bundle.putString("id", contactId);
            bundle.putString("name", name);
            bundle.putString("phoneNumber", phoneNumber);

            Intent resultIntent = new Intent();
            resultIntent.putExtras(bundle);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
