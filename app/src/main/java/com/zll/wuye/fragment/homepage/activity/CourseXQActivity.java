package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.R;
import com.zll.wuye.bean.ConsultXqBean;
import com.zll.wuye.http.HttpOkGo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CourseXQActivity extends AppCompatActivity {

    private String id;
    private SharedPreferences sp;
    private String token;
    private ImageView course_fanhui;
    private TextView course_title;
    private TextView course_message;
    private TextView course_liulanliang;
    private TextView course_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_xq);
        initView();
        sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        initdata();
    }

    private void initdata() {
        jiexi();
        course_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void jiexi() {
        String url = "https://wuye.kylinlaw.com/artcl/show?id=" + id + "&token=" + token;
        HttpOkGo.okgoget(url, ConsultXqBean.class, new HttpOkGo.okget<ConsultXqBean>() {
            @Override
            public void shuju(ArrayList<ConsultXqBean> list) {
                ConsultXqBean.BodyBean body = list.get(0).getBody();
                course_title.setText(body.getTitle());
                course_message.setText(body.getCntn());
                course_liulanliang.setText("浏览量:"+body.getSeeCnt());
                String time = getStrTime(body.getCreatTm() + "");
                course_time.setText(time);
            }
        });
    }

    private void initView() {
        course_fanhui = (ImageView) findViewById(R.id.course_fanhui);
        course_title = (TextView) findViewById(R.id.course_title);
        course_message = (TextView) findViewById(R.id.course_message);
        course_liulanliang = (TextView) findViewById(R.id.course_liulanliang);
        course_time = (TextView) findViewById(R.id.course_time);
    }

    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}
