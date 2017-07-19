package com.zll.wuye.fragment.mypage.RegisterLogin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.zll.wuye.bean.FindPasswordBean;
import com.zll.wuye.bean.RegisterBean;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

public class Findpassword extends AutoLayoutActivity implements View.OnClickListener {

    private ImageView zhaohui_zuo;
    private EditText wode_zhaohui_shoujihao;
    private EditText wode_zhaohui_yanzhengmaet;
    private Button wode_zhaohui_yanzhengma;
    private EditText wode_zhaohui_mima;
    private Button wode_zhaohui_queding;
    private String shoujihao;
    private CountDownTimer timer;
    private String yanzhengma;
    private String mima;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpassword);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        initView();
        initdata();
    }

    private void initdata() {
        zhaohui_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initView() {
        zhaohui_zuo = (ImageView) findViewById(R.id.zhaohui_zuo);
        wode_zhaohui_shoujihao = (EditText) findViewById(R.id.wode_zhaohui_shoujihao);
        wode_zhaohui_yanzhengmaet = (EditText) findViewById(R.id.wode_zhaohui_yanzhengmaet);
        wode_zhaohui_yanzhengma = (Button) findViewById(R.id.wode_zhaohui_yanzhengma);
        wode_zhaohui_mima = (EditText) findViewById(R.id.wode_zhaohui_mima);
        wode_zhaohui_queding = (Button) findViewById(R.id.wode_zhaohui_queding);

        wode_zhaohui_yanzhengma.setOnClickListener(this);
        wode_zhaohui_queding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wode_zhaohui_yanzhengma:
                shoujihao = wode_zhaohui_shoujihao.getText().toString().trim();
                if(shoujihao==null||shoujihao.length()<1){
                    Toast.makeText(Findpassword.this,"手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(shoujihao)){
                    Toast.makeText(Findpassword.this,"手机号格式不正确", Toast.LENGTH_SHORT).show();
                }else{
                    wode_zhaohui_yanzhengma.setEnabled(false);
                    timer = new CountDownTimer(60 * 1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            wode_zhaohui_yanzhengma.setText(millisUntilFinished/1000+"s");
                        }

                        @Override
                        public void onFinish() {
                            wode_zhaohui_yanzhengma.setText("请重新获取验证码");
                            wode_zhaohui_yanzhengma.setEnabled(true);
                        }
                    };

                    timer.start();// 开始计时
                    // // 取消
                }

                break;
            case R.id.wode_zhaohui_queding:
                yanzhengma = wode_zhaohui_yanzhengmaet.getText().toString().trim();
                mima = wode_zhaohui_mima.getText().toString().trim();
                wangluoqingqiu();
                break;
        }
    }

    private void wangluoqingqiu() {
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
                        FindPasswordBean bean = gson.fromJson(s, FindPasswordBean.class);
                        int status = bean.getStatus();
                        if(status==703){
                            Toast.makeText(Findpassword.this,"验证码不正确",Toast.LENGTH_SHORT).show();
                        }else if(status==704){
                            Toast.makeText(Findpassword.this,"用户名不存在",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Findpassword.this,"修改成功!",Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                    }
                });
    }

    public static boolean isPhoneNum(String phone_num) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(14[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone_num);
        return m.matches();
    }


}
