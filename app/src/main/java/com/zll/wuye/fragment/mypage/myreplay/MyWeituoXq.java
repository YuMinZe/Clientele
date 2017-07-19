package com.zll.wuye.fragment.mypage.myreplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.bean.MyWeiTuoxqBean;
import com.zll.wuye.fragment.mypage.adapter.MyWeituoXqAdapter;
import com.zll.wuye.fragment.mypage.adapter.WeiTuoXqAdapter;
import com.zll.wuye.http.DividerItemDecoration;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

import static android.support.v7.widget.StaggeredGridLayoutManager.*;

public class MyWeituoXq extends AutoLayoutActivity {

    private String token;
    private String id;
    private ImageView wode_weituoxq_fanhui;
    private TextView wode_weituoxq_title;
    private TextView wode_weituoxq_zhuangtai;
    private TextView wode_weituoxq_time;
    private TextView wode_weituoxq_baojia;
    private TextView wode_weituoxq_leixing;
    private TextView wode_weituoxq_diqu;
    private TextView wode_weituoxq_xiangqing;
    private RecyclerView wode_weituoxq_recycleziliao;
    private RecyclerView wode_weituoxq_recyclelxshi;
    private String[] split;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_weituo_xq);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        id = intent.getStringExtra("id");
        qingqiu();
        initdata();
    }

    private void initdata() {
        wode_weituoxq_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_weituoxq_recycleziliao .setLayoutManager(new StaggeredGridLayoutManager(1,
                HORIZONTAL));

        wode_weituoxq_recyclelxshi.setLayoutManager(new LinearLayoutManager(this));
        wode_weituoxq_recyclelxshi.addItemDecoration(new DividerItemDecoration(
                MyWeituoXq.this, DividerItemDecoration.HORIZONTAL_LIST));
    }

    private void qingqiu() {
        OkGo.get("https://wuye.kylinlaw.com/case/user/show?token=" + token + "&caseId=" + id)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        MyWeiTuoxqBean myWeituoXq = gson.fromJson(s, MyWeiTuoxqBean.class);
                        MyWeiTuoxqBean.BodyBean body = myWeituoXq.getBody();
                        int i = body.getStatus();
                        if(i==1){
                            wode_weituoxq_zhuangtai.setText("竞标中");
                        }else if(i==2){
                            wode_weituoxq_zhuangtai.setText("已中标");
                        }else if(i==3){
                            wode_weituoxq_zhuangtai.setText("已成交");
                        }else if(i==4){
                            wode_weituoxq_zhuangtai.setText("已完成");
                        }

                        wode_weituoxq_title.setText(body.getTitle());
                        String time = getStrTime(body.getCreatTm() + "");
                        wode_weituoxq_time.setText(time);
                        wode_weituoxq_leixing.setText(body.getTypeName());
                        wode_weituoxq_baojia.setText(body.getOfferStrt()+"-"+body.getOfferEnd()+"元");
                        wode_weituoxq_diqu.setText(body.getAddress());
                        wode_weituoxq_xiangqing.setText(body.getCntn());
                        if(body.getFileUrls().length()>=1){
                            String urls = body.getFileUrls();
                            split = urls.split("[,]");
                        }
                        if(body.getFileUrls().length()>=1){
                            wode_weituoxq_recycleziliao.setAdapter(new WeiTuoXqAdapter(split,MyWeituoXq.this));
                        }

                        wode_weituoxq_recyclelxshi.setAdapter(new MyWeituoXqAdapter(MyWeituoXq.this,body.getList(),token,id,body));
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initView() {
        wode_weituoxq_fanhui = (ImageView) findViewById(R.id.wode_weituoxq_fanhui);
        wode_weituoxq_title = (TextView) findViewById(R.id.wode_weituoxq_title);
        wode_weituoxq_zhuangtai = (TextView) findViewById(R.id.wode_weituoxq_zhuangtai);
        wode_weituoxq_time = (TextView) findViewById(R.id.wode_weituoxq_time);
        wode_weituoxq_baojia = (TextView) findViewById(R.id.wode_weituoxq_baojia);
        wode_weituoxq_leixing = (TextView) findViewById(R.id.wode_weituoxq_leixing);
        wode_weituoxq_diqu = (TextView) findViewById(R.id.wode_weituoxq_diqu);
        wode_weituoxq_xiangqing = (TextView) findViewById(R.id.wode_weituoxq_xiangqing);
        wode_weituoxq_recycleziliao = (RecyclerView) findViewById(R.id.wode_weituoxq_recycleziliao);
        wode_weituoxq_recyclelxshi = (RecyclerView) findViewById(R.id.wode_weituoxq_recyclelxshi);
    }
    //时间戳转时间
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        qingqiu();
        initdata();
    }
}
