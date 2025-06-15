package com.example.kupiapp;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class FanAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forfan);
        WebView webView = findViewById(R.id.video);
        webView.loadUrl("file:///android_res/drawable/image.gif");
    }
}
