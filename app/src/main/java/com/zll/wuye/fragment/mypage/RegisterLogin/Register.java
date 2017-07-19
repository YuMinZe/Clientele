package com.zll.wuye.fragment.mypage.RegisterLogin;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.bean.RegisterBean;
import com.zll.wuye.bean.SuccessRegister;
import com.zll.wuye.bean.ThreeRegister;
import com.zll.wuye.fragment.mypage.MyPageFragment;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 1. 登录
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 17:20
 */
public class Register extends AutoLayoutActivity implements View.OnClickListener {

    private static final String TAG = "Jpush";
    private TextView mZhuce;
    private ImageView mImageView;
    private TextView mWangjimima;
    private EditText wode_denglu_shoujihao;
    private EditText wode_denglu_mima;
    private Button wode_denglu_denglu;
    private String shoujihao;
    private String mima;
    private SharedPreferences mSp;
    private String token;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_register);
        mSp = getSharedPreferences("token", MODE_PRIVATE);
        token = mSp.getString("token", "");
        edit = mSp.edit();
        initView();
        initview();
        initdata();
    }

    private void initdata() {
        mZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Register.this, Loginzhuce.class);
                startActivity(in);
                finish();
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mWangjimima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, WangjiMima.class);

                startActivity(intent);
            }
        });
    }

    private void initview() {
        mZhuce = (TextView) findViewById(R.id.wode_denglu_zhuce);
        mImageView = (ImageView) findViewById(R.id.register_zuo);
        mWangjimima = (TextView) findViewById(R.id.wode_denglu_wangjimima);
    }

    private void initView() {
        wode_denglu_shoujihao = (EditText) findViewById(R.id.wode_denglu_shoujihao);
        wode_denglu_mima = (EditText) findViewById(R.id.wode_denglu_mima);
        wode_denglu_denglu = (Button) findViewById(R.id.wode_denglu_denglu);
        wode_denglu_denglu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wode_denglu_denglu:
                shoujihao = wode_denglu_shoujihao.getText().toString().trim();
                mima = wode_denglu_mima.getText().toString().trim();
                denglu();
                break;
        }
    }
    public void denglu(){
        HashMap<String, String> params = new HashMap<>();
        params.put("uname", shoujihao);
        params.put("pswd", mima);
        params.put("type", "0");
        params.put("source", "android");
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("https://wuye.kylinlaw.com/user/login?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                       Gson gson = new Gson();
                        SuccessRegister successRegister = gson.fromJson(s, SuccessRegister.class);
                        int status = successRegister.getStatus();
                        if(status==701){
                            Toast.makeText(Register.this,"手机号码格式不正确",Toast.LENGTH_SHORT).show();
                        }else  if(status==702){
                            Toast.makeText(Register.this,"密码格式不正确",Toast.LENGTH_SHORT).show();
                        }else  if(status==703){
                            Toast.makeText(Register.this,"验证码格式不正确",Toast.LENGTH_SHORT).show();
                        }else  if(status==704){
                            Toast.makeText(Register.this,"用户名不存在",Toast.LENGTH_SHORT).show();
                        }else  if(status==705){
                            Toast.makeText(Register.this,"密码不正确",Toast.LENGTH_SHORT).show();
                        }else{
                            if(successRegister.getMessage().equals("律师账号不能登录用户端")){
                                Toast.makeText(Register.this,"律师账号不能登录用户端",Toast.LENGTH_SHORT).show();
                            }else{
                                SuccessRegister.BodyBean body = successRegister.getBody();
                                if(!body.equals("")){
                                    String token1 = body.getToken();
                                    if(!token.equals("")){
                                        mSp.edit().clear().commit();
                                    }
                                    edit.putString("token",token1).commit();
                                    JPushInterface.setAliasAndTags(getApplicationContext(),
                                            shoujihao, null, mAliasCallback);
                                    Toast.makeText(Register.this,"登录成功",Toast.LENGTH_SHORT).show();
                                    finish();
                                }else{
                                    Toast.makeText(Register.this,"登录失败",Toast.LENGTH_SHORT).show();
                                }
                            }

                        }


                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private Handler mHandler1;
    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success极光推送别名设置成功";
                    Log.i(TAG, logs);
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.极光推送别名设置失败，60秒后重试";
                    Log.i(TAG, logs);
                    break;
                default:
                    logs = "极光推送设置失败，Failed with errorCode = " + code;
                    Log.e(TAG, logs);
                    break;
            }
        }
    };

}
