package com.zll.wuye.fragment.mypage.myreplay;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.fragment.mypage.fragment.Freefragment;
import com.zll.wuye.fragment.mypage.fragment.Onefragment;

//我的咨询
public class Myreplay extends AutoLayoutActivity{


    private ImageView wode_zixun_fanhui;
    private Button wode_zixun_mianfei;
    private Button wode_zixun_dianhua;
    private TextView wode_zixun_mianfeitv;
    private TextView wode_zixun_dianhuatv;
    private FrameLayout wode_zixun_frame;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myreplay);
        mFragmentManager = getSupportFragmentManager();
        initView();
        initdata();

    }

    private void initdata() {
        Freefragment free = new Freefragment();
        mFragmentManager.beginTransaction().replace(R.id.wode_zixun_frame,free).commit();

        wode_zixun_mianfei.setTextColor(R.color.button_yes);
        wode_zixun_dianhua.setTextColor(Color.BLACK);
        wode_zixun_mianfeitv.setVisibility(View.VISIBLE);
        wode_zixun_dianhuatv.setVisibility(View.GONE);
        wode_zixun_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        wode_zixun_mianfei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Freefragment free = new Freefragment();
                mFragmentManager.beginTransaction().replace(R.id.wode_zixun_frame,free).commit();

                wode_zixun_mianfei.setTextColor(R.color.button_yes);
                wode_zixun_dianhua.setTextColor(Color.BLACK);
                wode_zixun_mianfeitv.setVisibility(View.VISIBLE);
                wode_zixun_dianhuatv.setVisibility(View.GONE);
            }
        });
        wode_zixun_dianhua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onefragment one = new Onefragment();
                mFragmentManager.beginTransaction().replace(R.id.wode_zixun_frame,one).commit();

                wode_zixun_dianhua.setTextColor(R.color.button_yes);
                wode_zixun_mianfei.setTextColor(Color.BLACK);
                wode_zixun_dianhuatv.setVisibility(View.VISIBLE);
                wode_zixun_mianfeitv.setVisibility(View.GONE);
            }
        });

    }

    private void initView() {
        wode_zixun_fanhui = (ImageView) findViewById(R.id.wode_zixun_fanhui);
        wode_zixun_mianfei = (Button) findViewById(R.id.wode_zixun_mianfeizixun);
        wode_zixun_dianhua = (Button) findViewById(R.id.wode_zixun_dianhua);
        wode_zixun_mianfeitv = (TextView) findViewById(R.id.wode_zixun_mianfeitv);
        wode_zixun_dianhuatv = (TextView) findViewById(R.id.wode_zixun_dianhuatv);
        wode_zixun_frame = (FrameLayout) findViewById(R.id.wode_zixun_frame);
    }

}
