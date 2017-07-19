package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;

public class SubmitSuccess extends AppCompatActivity implements View.OnClickListener {

    private ImageView tijiaochenggong_fanhui;
    private Button tijiaochenggong_shouye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_success);
        initView();
        initdata();
    }

    private void initdata() {
        tijiaochenggong_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        tijiaochenggong_fanhui = (ImageView) findViewById(R.id.tijiaochenggong_fanhui);
        tijiaochenggong_shouye = (Button) findViewById(R.id.tijiaochenggong_shouye);

        tijiaochenggong_shouye.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tijiaochenggong_shouye:
                Intent intent = new Intent(SubmitSuccess.this, MainActivity.class);

                startActivity(intent);
                break;
        }
    }
}
