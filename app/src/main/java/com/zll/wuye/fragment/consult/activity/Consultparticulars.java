package com.zll.wuye.fragment.consult.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.bean.ConsultXqBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

public class Consultparticulars extends AutoLayoutActivity {

    private int id;
    private String token;
    private ImageView consult_fanhui;
    private TextView consult_title;
    private TextView consult_message;
    private TextView consult_liulanliang;
    private TextView consult_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultparticulars);
        initView();
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        id = Integer.parseInt(getIntent().getStringExtra("id"));
        zixun();
        initdata();
    }

    private void initdata() {
        consult_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void zixun() {
        OkGo.get("https://wuye.kylinlaw.com/artcl/show?id=" + id + "&token=" + token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        ConsultXqBean fromJson = gson.fromJson(s, ConsultXqBean.class);
                        ConsultXqBean.BodyBean body = fromJson.getBody();

                        consult_title.setText(body.getTitle());
                        consult_message.setText(body.getCntn());
                        consult_liulanliang.setText("浏览量:"+body.getSeeCnt());
                        String time = getStrTime(body.getCreatTm() + "");
                        consult_time.setText(time);
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initView() {
        consult_fanhui = (ImageView) findViewById(R.id.consult_fanhui);
        consult_title = (TextView) findViewById(R.id.consult_title);
        consult_message = (TextView) findViewById(R.id.consult_message);
        consult_liulanliang = (TextView) findViewById(R.id.consult_liulanliang);
        consult_time = (TextView) findViewById(R.id.consult_time);
    }

    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}
