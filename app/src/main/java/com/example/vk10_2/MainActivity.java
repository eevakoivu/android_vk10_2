package com.example.vk10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView web;
    EditText editText;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webView);
        editText = (EditText) findViewById(R.id.editText);

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.google.fi");
        editText();
    }

    public void editText(){
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_NULL && keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    url = editText.getText().toString();
                    if(!url.isEmpty()){
                        web.loadUrl("http://"+url);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public void refresh(View v){ //setOnClickListener
        web.reload();
    }
}