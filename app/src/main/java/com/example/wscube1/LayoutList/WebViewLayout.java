package com.example.wscube1.LayoutList;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityWebViewLayoutBinding;

import com.example.wscube1.R;

public class WebViewLayout extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityWebViewLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWebViewLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),getString(R.string.WebView_Layout_Demo),true);

        WebView webView = findViewById(R.id.web);
        webView.loadUrl("https://www.geeksforgeeks.org/how-to-use-webview-in-android/");
        webView.setWebViewClient(new WebViewClient());
    }
}