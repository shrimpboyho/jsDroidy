package com.dewey.jsdroidy;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Administrator on 6/3/13.
 */
public class output extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://www.google.com");

    }
}