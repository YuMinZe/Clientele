package com.zll.wuye.fragment.mypage.RegisterLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.bean.XiugaiMima;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

//修改密码
public class ForgetMe extends AutoLayoutActivity implements View.OnClickListener {

    private ImageView mImageView;
    private String token;
    private EditText wode_xiugaimima_yuan;
    private EditText wode_xiugaimima_xin;
    private EditText wode_xiugaimima_xin2;
    private Button wode_xiugaimima_queren;
    private String yuan;
    private String xin;
    private String xin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_me);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initview();
        initdata();
    }

    private void initdata() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initview() {
        mImageView = (ImageView) findViewById(R.id.wode_gaimima_fanhui);
    }

    private void initView() {
        wode_xiugaimima_yuan = (EditText) findViewById(R.id.wode_xiugaimima_yuan);
        wode_xiugaimima_xin = (EditText) findViewById(R.id.wode_xiugaimima_xin);
        wode_xiugaimima_xin2 = (EditText) findViewById(R.id.wode_xiugaimima_xin2);
        wode_xiugaimima_queren = (Button) findViewById(R.id.wode_xiugaimima_queren);

        wode_xiugaimima_queren.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wode_xiugaimima_queren:
                yuan = wode_xiugaimima_yuan.getText().toString().trim();
                xin = wode_xiugaimima_xin.getText().toString().trim();
                xin2 = wode_xiugaimima_xin2.getText().toString().trim();
                if(yuan.equals("")){
                    Toast.makeText(ForgetMe.this,"请输入原密码",Toast.LENGTH_SHORT).show();
                }else if(xin.equals("")){
                    Toast.makeText(ForgetMe.this,"请输入新密码",Toast.LENGTH_SHORT).show();
                }else if(xin2.equals("")){
                    Toast.makeText(ForgetMe.this,"请再次输入密码",Toast.LENGTH_SHORT).show();
                }else if(!xin.equals(xin2)){
                    Toast.makeText(ForgetMe.this,"新密码2次输入不一样",Toast.LENGTH_SHORT).show();
                }else{
                    photomath();
                }
                break;
        }
    }

    private void photomath() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("initPswd", yuan);
        params.put("newPswd", xin);
        params.put("code", xin2);
        JSONObject jsonObject = new JSONObject(params);
        OkGo.post("https://wuye.kylinlaw.com/user/password/update?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson= new Gson();
                        XiugaiMima xiugaiMima = gson.fromJson(s, XiugaiMima.class);
                        int status = xiugaiMima.getStatus();
                        if(status==703){
                            Toast.makeText(ForgetMe.this,"验证码不正确",Toast.LENGTH_SHORT).show();
                        }else if(status==707){
                            Toast.makeText(ForgetMe.this,"原密码不正确",Toast.LENGTH_SHORT).show();
                        }else if(status==708){
                            Toast.makeText(ForgetMe.this,"新密码格式不正确",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ForgetMe.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

}
