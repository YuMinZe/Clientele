package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.KeFuBean;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;

public class Wuyefeijieshao extends AppCompatActivity implements View.OnClickListener {

    private ImageView shouye_wuyefei_zuo;
    private Button shouye_wuyefei_zixunkefu;
    private Button shouye_wuyefei_woyaozixun;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuyefeijieshao);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        initView();
        initdata();
    }

    private void initdata() {
        shouye_wuyefei_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        shouye_wuyefei_zuo = (ImageView) findViewById(R.id.shouye_wuyefei_zuo);
        shouye_wuyefei_zixunkefu = (Button) findViewById(R.id.shouye_wuyefei_zixunkefu);
        shouye_wuyefei_woyaozixun = (Button) findViewById(R.id.shouye_wuyefei_woyaozixun);

        shouye_wuyefei_zixunkefu.setOnClickListener(this);
        shouye_wuyefei_woyaozixun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouye_wuyefei_zixunkefu:
                new Alot().dadianhua(Wuyefeijieshao.this);
                break;
            case R.id.shouye_wuyefei_woyaozixun:
                if(!token.equals("")&&token.length()>=1){
                    Intent intent = new Intent(Wuyefeijieshao.this, Propertyfee.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Wuyefeijieshao.this,"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
