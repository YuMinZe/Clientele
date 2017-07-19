package com.zll.wuye.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.system.ErrnoException;
import android.view.View;
import android.widget.ImageView;

import com.zll.wuye.R;

public class WelcomeActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    private ImageView yindaoye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    handler.sendEmptyMessageDelayed(0, 2000);
                }
            });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(0);
    }

    private void initView() {
        yindaoye = (ImageView) findViewById(R.id.yindaoye);
        yindaoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                handler.removeMessages(0);
                finish();
            }
        });
    }
}
