package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null) {
            String resource = bundle.getString("link");
            WebView wb = findViewById(R.id.webView);
            wb.loadUrl(resource);
            wb.setWebViewClient(new WebViewClient());
        }

    }
}