package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.http.HttpOkGo;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplyActivity extends AppCompatActivity{

    private String token;
    private ImageView shouye_apply_zuo;
    private EditText shouye_apply_name;
    private EditText shouye_apply_photo;
    private Button shouye_apply_tijiao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initdata();

    }

    private void initdata() {
        shouye_apply_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        shouye_apply_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = shouye_apply_name.getText().toString().trim();
                String photo = shouye_apply_photo.getText().toString().trim();
                if(name.equals("")&&name.length()<=0){
                    Toast.makeText(ApplyActivity.this,"请输入名字",Toast.LENGTH_SHORT).show();
                }else if(photo.equals("")&&photo.length()<=0){
                    Toast.makeText(ApplyActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(photo)){
                    Toast.makeText(ApplyActivity.this,"您输入的手机号不合法",Toast.LENGTH_SHORT).show();
                }else{
                    tijiao(name,photo);
                }

            }
        });

    }

    public static boolean isPhoneNum(String phone_num) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(14[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone_num);
        return m.matches();
    }

    private void tijiao(String name, String photo) {
        String url = "https://wuye.kylinlaw.com/sign/create?token="+token;
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("tel",photo);
        map.put("type",0);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Toast.makeText(ApplyActivity.this,"报名成功!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void initView() {
        shouye_apply_zuo = (ImageView) findViewById(R.id.shouye_apply_zuo);
        shouye_apply_name = (EditText) findViewById(R.id.shouye_apply_name);
        shouye_apply_photo = (EditText) findViewById(R.id.shouye_apply_photo);
        shouye_apply_tijiao = (Button) findViewById(R.id.shouye_apply_tijiao);

    }

}
