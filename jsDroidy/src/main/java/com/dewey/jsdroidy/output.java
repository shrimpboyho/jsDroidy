package com.dewey.jsdroidy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 6/3/13.
 */
public class output extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        // Get the sent data

        Intent sentpackage = getIntent();

        String html = sentpackage.getStringExtra("HTML");
        String js = sentpackage.getStringExtra("JS");
        String css = sentpackage.getStringExtra("CSS");

        // Set up client

        WebViewClient yourWebClient = new WebViewClient()
        {
            // Override page so it's load on my view only
            @Override
            public boolean shouldOverrideUrlLoading(WebView  view, String  url)
            {

                    return false;


            }
        };



       WebView myWebView = (WebView) findViewById(R.id.webView);

        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                //Required functionality here
                return super.onJsAlert(view, url, message, result);
           }
        });
        myWebView.setWebViewClient(yourWebClient);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setSupportZoom(true);		 //Zoom Control on web (You don't need this
        //if ROM supports Multi-Touch
        myWebView.getSettings().setBuiltInZoomControls(true); //Enable Multitouch if supported by RO



        myWebView.loadData("<html>"+"<head>"+"<style>"+css+"</style>"+"</head>"+"<body>"+html+"<script type=\"text/javascript\" >"+js+"</script>"+"</body>"+"</html>","text/html","UTF-8");

    }
    }