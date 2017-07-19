package com.zll.wuye.fragment.mypage.RegisterLogin.change;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class Personage_sex extends AutoLayoutActivity {

    private String token;
    private ImageView wode_xiugaisex_fanhui;
    private ImageView iv1;
    private ImageView iv2;
    private int num=0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personage_sex);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initview();

    }

    private void initview() {
        wode_xiugaisex_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv1.setImageResource(R.mipmap.xingbiexianzhong);
                iv2.setImageResource(R.mipmap.xingbiewei);
                num=1;
            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv2.setImageResource(R.mipmap.xingbiexianzhong);
                iv1.setImageResource(R.mipmap.xingbiewei);
                num=2;
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num==0){
                    Toast.makeText(Personage_sex.this,"请选择性别",Toast.LENGTH_SHORT).show();
                }else if(num==1){
                    photomath(1);
                }else if(num==2){
                    photomath(0);
                }
            }
        });
    }

    private void initView() {
        wode_xiugaisex_fanhui = (ImageView) findViewById(R.id.wode_xiugaisex_fanhui);
        iv1 = (ImageView) findViewById(R.id.xiugaixingbie_iv1);
        iv2 = (ImageView) findViewById(R.id.xiugaixingbie_iv2);
        tv = (TextView) findViewById(R.id.wode_xiugaisextv);
    }

    private void photomath(int trim) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("sex", trim);
        JSONObject jsonObject = new JSONObject(params);
        OkGo.post("https://wuye.kylinlaw.com/user/update?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Toast.makeText(Personage_sex.this,"更改性别成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }
}
