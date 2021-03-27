package com.example.harkka10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText_address;
    Button button_back, button_next, button_refresh, button_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_address = (EditText) findViewById(R.id.editText_address);
        button_back = (Button) findViewById(R.id.button_back);
        button_next = (Button) findViewById(R.id.button_next);
        button_refresh = (Button) findViewById(R.id.button_refresh);
        button_search = (Button) findViewById(R.id.button_search);
        webView = (WebView) findViewById(R.id.webView);

        //Testi

        //Selain ikkuna
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/");

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_site();
            }
        });

        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goForward();
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });





    }
    public void search_site() {
        String site;
        site = editText_address.getText().toString();
        /*if (site == "index.html") {
            webView.loadUrl("file://android_asset/index.html");
        }
        else {*/
        webView.loadUrl("https://" + site);
        //webView.loadUrl("file://android_assets/index.html");
        editText_address.setText("");


    }



}