package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.zll.wuye.bean.IndentBean;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

//填写信息     电话咨询   提交信息返回订单
public class FilinMessage extends AutoLayoutActivity {

    private ImageView tianxiexinxin_guanbi;
    private EditText tianxiexinxin_name;
    private EditText tianxiexinxin_photo;
    private Button tianxiexinxin_queren;
    private String token;
    private int id;
    private String price;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filin_message);
        Intent intent = getIntent();
        id = Integer.valueOf(intent.getStringExtra("lvshiid"));
        token = intent.getStringExtra("token");
        price = intent.getStringExtra("price");
        initView();
        initdata();

    }

    private void initdata() {
        tianxiexinxin_guanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tianxiexinxin_queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tianxiexinxin_name.getText().toString().trim().equals("")){
                    Toast.makeText(FilinMessage.this,"姓名不能为空!",Toast.LENGTH_SHORT).show();
                }else if(tianxiexinxin_photo.getText().toString().trim().equals("")){
                    Toast.makeText(FilinMessage.this,"手机号不能为空!",Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(tianxiexinxin_photo.getText().toString().trim())){
                    Toast.makeText(FilinMessage.this,"您输入的手机号不合法",Toast.LENGTH_SHORT).show();
                }else{
                    chuanshuju();
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

    private void initView() {
        tianxiexinxin_guanbi = (ImageView) findViewById(R.id.tianxiexinxin_guanbi);
        tianxiexinxin_name = (EditText) findViewById(R.id.tianxiexinxin_name);
        tianxiexinxin_photo = (EditText) findViewById(R.id.tianxiexinxin_photo);
        tianxiexinxin_queren = (Button) findViewById(R.id.tianxiexinxin_queren);
        message = (EditText) findViewById(R.id.tianxiexinxin_message);
    }

    public void chuanshuju(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("type","askLawyer");
        params.put("typeId",id);
        params.put("title","电话咨询律师");
        params.put("price",price);
        params.put("num",1);

        String name = tianxiexinxin_name.getText().toString().trim();
        String tel = tianxiexinxin_photo.getText().toString().trim();
        String cntn = message.getText().toString().trim();
        Map<String,String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("name",name);
        map.put("cntn",cntn);
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

                        Intent intent = new Intent(FilinMessage.this,PaymentActivity.class);
                        intent.putExtra("token",token);
                        intent.putExtra("indent",body.getOrderNo()+"");
                        intent.putExtra("leixing","电话咨询律师");
                        intent.putExtra("price",price);
                        startActivity(intent);

                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

}
