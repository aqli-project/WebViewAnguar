package com.example.webviewanguar;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;


public class MainActivity extends AppCompatActivity {
    private WebView _webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Pastikan Anda memiliki layout ini di res/layout/activity_main.xml

        _webView1 = (WebView) findViewById(R.id.webView1);

        // Setup WebViewClient dan WebChromeClient
        WebViewClient webViewClient = new WebViewClient();
        _webView1.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        _webView1.setWebChromeClient(webChromeClient);

        // Setup WebSettings
        WebSettings webSettings = _webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Menambahkan WebAppInterface
        WebView webView = findViewById(R.id.webView1);
        webView.addJavascriptInterface(new WebAppInterface(this, this), "Android");

        // Memuat URL
        String url = "https://stmikpontianak.net/011100862/angular011100862";
        _webView1.loadUrl(url);
    }
}