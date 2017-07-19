package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.bean.MoreEvaluateBean;
import com.zll.wuye.bean.ReplyConsulting;
import com.zll.wuye.fragment.homepage.adapter.MorePjAdapter;
import com.zll.wuye.fragment.homepage.adapter.ReplyAdapter;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MoreEvaluate extends AutoLayoutActivity {

    private ImageView morepingjia_zuo;
    private RecyclerView morepingjia;
    private Long id;
    private TextView morepingjiawu;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_evaluate);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        Intent intent = getIntent();
        id = Long.valueOf(intent.getStringExtra("lvshiid"));
        initView();
        initdata();
    }

    private void initdata() {
        morepingjia_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        morepingjia.setLayoutManager(new LinearLayoutManager(this));
        jiexi();
    }

    private void jiexi() {
        OkGo.get("https://wuye.kylinlaw.com/lawyer/commt/list?lawyerId="+id+"&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        MoreEvaluateBean more = gson.fromJson(s, MoreEvaluateBean.class);
                        List<MoreEvaluateBean.BodyBean> body = more.getBody();
                        if(body==null||body.equals("")){
                            morepingjiawu.setText("暂无评论");
                        }else{
                            morepingjia.setAdapter(new MorePjAdapter(MoreEvaluate.this,body));
                        }

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initView() {
        morepingjia_zuo = (ImageView) findViewById(R.id.morepingjia_zuo);
        morepingjia = (RecyclerView) findViewById(R.id.morepingjia);
        morepingjiawu = (TextView) findViewById(R.id.morepingjiawu);
    }
}
