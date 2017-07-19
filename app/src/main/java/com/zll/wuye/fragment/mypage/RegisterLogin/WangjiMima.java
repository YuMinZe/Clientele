package com.zll.wuye.fragment.mypage.RegisterLogin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import com.zll.wuye.bean.RegisterBean;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

public class WangjiMima extends AutoLayoutActivity implements View.OnClickListener {

    private ImageView wode_zhaomima_fanhui;
    private EditText mShoujihao;
    private EditText mYanzhengma1;
    private Button mYanzhengma;
    private EditText wode_zhaomima_xinmima;
    private Button wode_zhaomima_queding;
    private String shoujihao;
    private String yanzhengma;
    private CountDownTimer timer;
    private String mima;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangji_mima);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        initView();
        initdata();
    }

    private void initdata() {
        wode_zhaomima_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        wode_zhaomima_fanhui = (ImageView) findViewById(R.id.wode_zhaomima_fanhui);
        mShoujihao = (EditText) findViewById(R.id.wode_zhaomima_shoujihao);
        mYanzhengma1 = (EditText) findViewById(R.id.wode_zhaomima_yanzhengma);
        mYanzhengma = (Button) findViewById(R.id.wode_zhaomima_yanzhengmabt);
        wode_zhaomima_xinmima = (EditText) findViewById(R.id.wode_zhaomima_xinmima);
        wode_zhaomima_queding = (Button) findViewById(R.id.wode_zhaomima_queding);

        mYanzhengma.setOnClickListener(this);
        wode_zhaomima_queding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wode_zhaomima_yanzhengmabt:

                shoujihao = mShoujihao.getText().toString().trim();
                if(shoujihao.equals("")){
                    Toast.makeText(WangjiMima.this,"手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(shoujihao)){
                    Toast.makeText(WangjiMima.this,"手机号格式不正确", Toast.LENGTH_SHORT).show();
                }else{
                    mYanzhengma.setEnabled(false);

                    OkGo.get("https://wuye.kylinlaw.com/validate/code?tel="+shoujihao+"&type=pswd")//
                            .tag(this)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {

                                }
                            });

                    timer = new CountDownTimer(60 * 1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            mYanzhengma.setText(millisUntilFinished/1000+"s");
                        }

                        @Override
                        public void onFinish() {
                            mYanzhengma.setText("请重新获取验证码");
                            mYanzhengma.setEnabled(true);
                        }
                    };

                    timer.start();// 开始计时
                    // // 取消
                }

                break;
            case R.id.wode_zhaomima_queding:
                shoujihao = mShoujihao.getText().toString().trim();
                yanzhengma = mYanzhengma1.getText().toString().trim();
                mima = wode_zhaomima_xinmima.getText().toString().trim();
                okgo();
                break;
        }
    }

    public static boolean isPhoneNum(String phone_num) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(14[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone_num);
        return m.matches();
    }
    public void okgo(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("tel", shoujihao);
        params.put("pswd", mima);
        params.put("code", yanzhengma);
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("https://wuye.kylinlaw.com/user/find/password?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Gson gson = new Gson();
                        RegisterBean register = gson.fromJson(s,RegisterBean.class);
                        int status = register.getStatus();
                        if(status==703){
                            Toast.makeText(WangjiMima.this,"验证码不正确", Toast.LENGTH_SHORT).show();
                        }else if(status==704){
                            Toast.makeText(WangjiMima.this,"用户名不存在", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(WangjiMima.this,"修改成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                    }
                });
    }

}
