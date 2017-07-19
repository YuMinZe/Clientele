package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zll.wuye.R;

import java.lang.ref.WeakReference;

public class MyVideoXQ extends AppCompatActivity {

    private String id;
    private String token;
    private WebView webview;
    private ProgressBar progressBar;
    private ProgressBarHandler mProgressBarHandler = new ProgressBarHandler(MyVideoXQ.this);
    private String url;
    private String name;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_video_xq);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        initView();
        url = intent.getStringExtra("url");
        jiexi();
    }

    private void jiexi() {

        WebSettings webSettings = webview.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }



        });

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressBarHandler.sendEmptyMessage(0);
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                loadUrl(view, url);
                return true;
            }


        });

        webview.setBackgroundColor(0);
            webview.loadUrl(url);

    }


    private void initView() {
        webview = (WebView) findViewById(R.id.video_wv);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final ImageView fanhui = (ImageView) findViewById(R.id.shouye_xiangqing_zuo);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                webview.removeAllViews();
                webview.destroy();
            }
        });
        title = (TextView) findViewById(R.id.shouye_title);
        title.setText(name);
    }

    private void loadUrl(final WebView view, final String url) {
        mProgressBarHandler.sendEmptyMessage(1);
        view.loadUrl(url);
    }

    private static class ProgressBarHandler extends Handler {
        private final WeakReference<MyVideoXQ> mActivity;
        public ProgressBarHandler(MyVideoXQ activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mActivity.get() == null || mActivity.get().isFinishing()) {
                return;
            }

            switch (msg.what) {
                case 0:
                    if (mActivity.get().progressBar != null && mActivity.get().webview != null) {
                        mActivity.get().progressBar.setVisibility(View.INVISIBLE);
                        mActivity.get().webview.setVisibility(View.VISIBLE);
                    }
                    break;
                case 1:
                    if (mActivity.get().progressBar != null && mActivity.get().webview != null) {
                        mActivity.get().progressBar.setVisibility(View.VISIBLE);
                        mActivity.get().webview.setVisibility(View.INVISIBLE);
                    }
                    break;
            }
            super.handleMessage(msg);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview != null && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview.removeAllViews();
        webview.destroy();
    }
}
