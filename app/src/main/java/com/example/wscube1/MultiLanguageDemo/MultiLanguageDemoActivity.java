package com.example.wscube1.MultiLanguageDemo;

import android.app.LocaleManager;
import android.os.Build;
import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.LocaleList;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityMultiLanguageDemoBinding;

import com.example.wscube1.R;

import java.util.Locale;

public class MultiLanguageDemoActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMultiLanguageDemoBinding binding;

    private LocaleManager localeManager;
    private TextView idTVSubHeading, idTVCurrentLanguage;
    private Button idBtnHindi, idBtnGujrati,idBtnEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMultiLanguageDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), getString(R.string.multilanguagedemo), true);

        idTVSubHeading = findViewById(R.id.idTVSubHeading);
        idTVCurrentLanguage = findViewById(R.id.idTVCurrentLanguage);
        idBtnHindi = findViewById(R.id.idBtnHindi);
        idBtnGujrati = findViewById(R.id.idBtnGujrati);
        idBtnEnglish = findViewById(R.id.idBtnEnglish);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            localeManager = (LocaleManager) getSystemService(getApplicationContext().LOCALE_SERVICE);
        }

        idBtnHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    localeManager.setApplicationLocales(new LocaleList(Locale.forLanguageTag("hi")));
                }
            }
        });

        idBtnGujrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    localeManager.setApplicationLocales(new LocaleList(Locale.forLanguageTag("gu")));
                }
            }
        });
        idBtnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    localeManager.setApplicationLocales(new LocaleList(Locale.forLanguageTag("en")));
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onResume() {
        super.onResume();

        String language;
        String languageTag = localeManager.getApplicationLocales().toLanguageTags();
        switch (languageTag){
            case "hi":
                language = "Hindi";
                break;
            case "gu":
                language="Gujrati";
                break;
            case "en":
                language="English";
                break;
            default:
                language="English";
                break;

        }
        idTVCurrentLanguage.setText("Current Language :"+language);
    }
}