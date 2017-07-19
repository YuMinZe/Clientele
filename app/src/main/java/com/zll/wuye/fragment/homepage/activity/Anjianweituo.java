package com.zll.wuye.fragment.homepage.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.fragment.homepage.fragment.IntroduceFragment;
import com.zll.wuye.fragment.homepage.fragment.IssueFragment;


public class Anjianweituo extends AutoLayoutActivity {

    private ImageView shouye_weituo_zuo;
    private RadioButton shouye_weituo_jieshao;
    private RadioGroup shouye_weituo_radio;
    private FrameLayout shouye_weituo_frame;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anjianweituo);
        mFragmentManager = getSupportFragmentManager();
        initView();
        initdata();
        IntroduceFragment introduce = new IntroduceFragment();
        mFragmentManager.beginTransaction().replace(R.id.shouye_weituo_frame,introduce).commit();
    }

    private void initdata() {
        shouye_weituo_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        shouye_weituo_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.shouye_weituo_jieshao:
                        IntroduceFragment introduce = new IntroduceFragment();
                        mFragmentManager.beginTransaction().replace(R.id.shouye_weituo_frame,introduce).commit();
                        break;
                }
            }
        });

    }

    private void initView() {
        shouye_weituo_zuo = (ImageView) findViewById(R.id.shouye_weituo_zuo);
        shouye_weituo_jieshao = (RadioButton) findViewById(R.id.shouye_weituo_jieshao);
        shouye_weituo_radio = (RadioGroup) findViewById(R.id.shouye_weituo_radio);
        shouye_weituo_frame = (FrameLayout) findViewById(R.id.shouye_weituo_frame);
    }
}
