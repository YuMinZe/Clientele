package com.zll.wuye.fragment.mypage.RegisterLogin.change;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class Personage_name extends AutoLayoutActivity {

    private ImageView wode_xiugainame_fanhui;
    private TextView wode_xiugainametv;
    private EditText wode_xiugainameed;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personage_name);
        initView();
        initdata();
    }

    private void initdata() {
        wode_xiugainame_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_xiugainametv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = wode_xiugainameed.getText().toString().trim();
                if(trim==null){
                    Toast.makeText(Personage_name.this,"名称不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    photomath(trim);
                }
            }
        });
    }

    private void initView() {
        wode_xiugainame_fanhui = (ImageView) findViewById(R.id.wode_xiugainame_fanhui);
        wode_xiugainametv = (TextView) findViewById(R.id.wode_xiugainametv);
        wode_xiugainameed = (EditText) findViewById(R.id.wode_xiugainameed);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
    }

    private void photomath(String trim) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("rname", trim);
        JSONObject jsonObject = new JSONObject(params);
        OkGo.post("https://wuye.kylinlaw.com/user/update?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Toast.makeText(Personage_name.this,"更改名字成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }


}
