package com.zll.wuye.fragment.mypage.myreplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.zll.wuye.R;

public class Xieyi extends AppCompatActivity {

    private WebView xieyi_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xieyi);
        initView();
        xieyi_webview.loadUrl("http://wuye.kylinlaw.com/xieyi/index.html");
    }

    private void initView() {
        xieyi_webview = (WebView) findViewById(R.id.xieyi_webview);
    }
}
