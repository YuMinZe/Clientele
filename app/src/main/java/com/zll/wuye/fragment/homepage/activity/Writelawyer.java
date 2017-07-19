package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.IndentBean;
import com.zll.wuye.fragment.mypage.RegisterLogin.BasicMessage;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

public class Writelawyer extends AutoLayoutActivity {

    private ImageView lvshihan_zuo;
    private EditText lvshihan_xuqiu;
    private EditText lvshihan_name;
    private EditText lvshihan_photo;
    private Button tijiao;
    private String xuqiu;
    private String name;
    private String photo;
    private String token;
    private SharedPreferences sp;
    private String faprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writelawyer);
        sp = getSharedPreferences("token", MODE_PRIVATE);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        faprice = intent.getStringExtra("price");
        initView();
        initdata();
    }

    private void initdata() {
        lvshihan_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuqiu = lvshihan_xuqiu.getText().toString().trim();
                name = lvshihan_name.getText().toString().trim();
                photo = lvshihan_photo.getText().toString().trim();
                if(xuqiu.equals("")||xuqiu.length()<1){
                    Toast.makeText(Writelawyer.this,"请简单描述一下需求",Toast.LENGTH_SHORT).show();
                }else if(name.equals("")||name.length()<1){
                    Toast.makeText(Writelawyer.this,"请输入您的名字",Toast.LENGTH_SHORT).show();
                }else if(photo.equals("")||photo.length()<1){
                    Toast.makeText(Writelawyer.this,"请输入您的手机号",Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(photo)){
                    Toast.makeText(Writelawyer.this,"您输入的手机号不合法",Toast.LENGTH_SHORT).show();
                }else{
                    shangchuan();
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

    private void shangchuan() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("type","letter");
        params.put("typeId",0);
        params.put("title","律师函");
        params.put("price",faprice);
        params.put("num",1);


        Map<String,Object> map = new HashMap<>();
        map.put("tel",photo);
        map.put("name",name);
        map.put("cntn",xuqiu);
        params.put("attr",map);

        JSONObject jsonObject = new JSONObject(params);
        OkGo.post("https://wuye.kylinlaw.com/order/create?token="+token)
                .tag(this)//
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson= new Gson();
                        IndentBean bean = gson.fromJson(s, IndentBean.class);
                        IndentBean.BodyBean body = bean.getBody();
                        if(bean.getMessage().equals("请求成功")){
                            Intent intent = new Intent(Writelawyer.this,PaymentActivity.class);
                            intent.putExtra("token",token);
                            intent.putExtra("indent",body.getOrderNo()+"");
                            intent.putExtra("leixing","律师函费用");
                            intent.putExtra("price",faprice+"");
                            startActivity(intent);
                        }else{
                            Toast.makeText(Writelawyer.this,"登录过期请重新登录",Toast.LENGTH_SHORT).show();
                            sp.edit().clear().commit();
                            finish();
                        }


                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    private void initView() {
        lvshihan_zuo = (ImageView) findViewById(R.id.lvshihan_zuo);
        lvshihan_xuqiu = (EditText) findViewById(R.id.lvshihan_xuqiu);
        lvshihan_name = (EditText) findViewById(R.id.lvshihan_name);
        lvshihan_photo = (EditText) findViewById(R.id.lvshihan_photo);
        tijiao = (Button) findViewById(R.id.lvshihan_tijiao);
    }

}
