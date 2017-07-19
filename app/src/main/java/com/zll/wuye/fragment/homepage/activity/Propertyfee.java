package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.IndentBean;
import com.zll.wuye.bean.PhotoBeanfore;
import com.zll.wuye.fragment.mypage.adapter.WeiTuoXqAdapter;
import com.zll.wuye.local.ImgFileListActivity;
import com.zll.wuye.local.ImgFileListActivity2;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

import static android.support.v7.widget.StaggeredGridLayoutManager.HORIZONTAL;

//物业费催收

public class Propertyfee extends AutoLayoutActivity {

    private ImageView shouye_weituoxiangqing_zuo;
    private EditText wuyefei_message;
    private EditText wuyefei_name;
    private EditText wuyefei_photo;
    private Button wuyefei_tijiao;
    private String message;
    private String name;
    private String photo;
    ArrayList<String> listfile=new ArrayList<String>();
    private String token;
    private boolean b=true;
    private int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertyfee);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        initView();

        initdata();
    }

    private void initdata() {
        shouye_weituoxiangqing_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        wuyefei_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dedaoshuju();
                if(token.equals("")){
                    Toast.makeText(Propertyfee.this,"请先登录",Toast.LENGTH_SHORT).show();
                }else {
                    if (message.equals("") || message.length() < 0) {
                        Toast.makeText(Propertyfee.this, "请描述案件", Toast.LENGTH_SHORT).show();
                    } else if (name.equals("") || name.length() < 0) {
                        Toast.makeText(Propertyfee.this, "请输入您的姓名", Toast.LENGTH_SHORT).show();
                    } else if (photo.equals("") || photo.length() < 0) {
                        Toast.makeText(Propertyfee.this, "请输入您的手机号码", Toast.LENGTH_SHORT).show();
                    } else if(!isPhoneNum(photo)){
                        Toast.makeText(Propertyfee.this, "您输入的手机号不合法", Toast.LENGTH_SHORT).show();
                    }else {

                        shangchuan();
                    }
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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }


    private void shangchuan() {
        wuyefei_tijiao.setEnabled(false);
        HashMap<String, Object> params = new HashMap<>();
        params.put("type","property");
        params.put("typeId",0);
        params.put("title","物业催收");
        params.put("price",0);
        params.put("num",1);


        Map<String,Object> map = new HashMap<>();
        map.put("type",1);
        map.put("tel",photo);
        map.put("name",name);
        map.put("cntn",message);
        map.put("fileUrls","");
        params.put("attr",map);

        JSONObject jsonObject = new JSONObject(params);
        OkGo.post("https://wuye.kylinlaw.com/order/create?token="+token)
                .tag(this)//
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        wuyefei_tijiao.setEnabled(true);
                        Intent intent = new Intent(Propertyfee.this,SubmitSuccess.class);
                        startActivity(intent);
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    private void dedaoshuju(){
        message = wuyefei_message.getText().toString().trim();
        name = wuyefei_name.getText().toString().trim();
        photo = wuyefei_photo.getText().toString().trim();
    }

    private void initView() {
        shouye_weituoxiangqing_zuo = (ImageView) findViewById(R.id.shouye_weituoxiangqing_zuo);
        wuyefei_message = (EditText) findViewById(R.id.wuyefei_message);
        wuyefei_name = (EditText) findViewById(R.id.wuyefei_name);
        wuyefei_photo = (EditText) findViewById(R.id.wuyefei_photo);
        wuyefei_tijiao = (Button) findViewById(R.id.wuyefei_tijiao);
    }

}
