package com.zll.wuye.fragment.homepage.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zll.wuye.R;
import com.zll.wuye.fragment.homepage.fragment.Coursefragment;
import com.zll.wuye.fragment.homepage.fragment.Videofragment;

public class OpenClassActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView shouye_peixun_zuo;
    private Button shouye_peixun_kecheng;
    private Button shouye_peixun_shipin;
    private FrameLayout shouye_peixun_frame;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_class);
        mFragmentManager = getSupportFragmentManager();
        initView();
        initdata();

    }

    private void initdata() {
        shouye_peixun_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        shouye_peixun_zuo = (ImageView) findViewById(R.id.shouye_peixun_zuo);
        shouye_peixun_kecheng = (Button) findViewById(R.id.shouye_peixun_kecheng);
        shouye_peixun_shipin = (Button) findViewById(R.id.shouye_peixun_shipin);
        shouye_peixun_frame = (FrameLayout) findViewById(R.id.shouye_peixun_frame);

        shouye_peixun_kecheng.setOnClickListener(this);
        shouye_peixun_shipin.setOnClickListener(this);
        Coursefragment course = new Coursefragment();
        mFragmentManager.beginTransaction().replace(R.id.shouye_peixun_frame,course).commit();

        shouye_peixun_kecheng.setTextColor(R.color.button_yes);
        shouye_peixun_shipin.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouye_peixun_kecheng:
                Coursefragment course = new Coursefragment();
                mFragmentManager.beginTransaction().replace(R.id.shouye_peixun_frame,course).commit();

                shouye_peixun_kecheng.setTextColor(R.color.button_yes);
                shouye_peixun_shipin.setTextColor(Color.BLACK);
                break;
            case R.id.shouye_peixun_shipin:
                Videofragment video = new  Videofragment();
                mFragmentManager.beginTransaction().replace(R.id.shouye_peixun_frame,video).commit();

                shouye_peixun_shipin.setTextColor(R.color.button_yes);
                shouye_peixun_kecheng.setTextColor(Color.BLACK);
                break;
        }
    }
}
