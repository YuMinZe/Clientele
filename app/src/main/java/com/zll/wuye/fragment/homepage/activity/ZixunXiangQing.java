package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.Particulars;
import com.zll.wuye.bean.ReplyConsulting;
import com.zll.wuye.fragment.homepage.adapter.ReplyAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class ZixunXiangQing extends AutoLayoutActivity {

    private ImageView shouye_xiangqing_zuo;
    private RecyclerView shouye_xiangqing_recycle;

    private String token;
    private Long id;
    private ImageView shouye_zixunxiangqing_touxiang;
    private TextView shouye_zixunxiangqing_name;
    private TextView shouye_zixunxiangqing_timer;
    private TextView shouye_zixunxiangqing_message;
    private Particulars particulars;
    private MaterialRefreshLayout mRefreshLayout;
    private ArrayList<ReplyConsulting.BodyBean> mList = new ArrayList<>();
    private int size;
    private boolean isLoadMore = true;
    private int p=1;
    private int num=0;
    private ReplyAdapter adapter;
    private TextView shangla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zixun_xiang_qing);
        initView();
        initdata();
        Intent intent = getIntent();
        id = Long.valueOf(intent.getStringExtra("id"));
        token = intent.getStringExtra("token");
        qingqiu();
    }

    private void Reply(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        ReplyConsulting replyConsulting = gson.fromJson(s, ReplyConsulting.class);
                        List<ReplyConsulting.BodyBean> body = replyConsulting.getBody();
                        if(particulars.getBody().getUserId()==particulars.getBody().getSelfId()){
                            num=1;
                        }else{
                            num=2;
                        }

                        if(body!=null&&body.size()>=1){
                            if(p==1){
                                shangla.setVisibility(View.GONE);
                                mList.addAll(body);
                                adapter = new ReplyAdapter(ZixunXiangQing.this, mList, token, num);
                                shouye_xiangqing_recycle.setAdapter(adapter);
                                p++;
                            }else{
                                if(body.size()>=10){
                                    mList.addAll(body);
                                    adapter.notifyItemRangeChanged(size,mList.size()-1);
                                }else{
                                    shangla.setVisibility(View.VISIBLE);
                                }
                            }
                        }else{
                            shangla.setVisibility(View.VISIBLE);
                        }

                        mRefreshLayout.finishRefreshLoadMore();
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initdata() {
        shouye_xiangqing_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        shouye_xiangqing_zuo = (ImageView) findViewById(R.id.shouye_xiangqing_zuo);
        shouye_xiangqing_recycle = (RecyclerView) findViewById(R.id.shouye_xiangqing_recycle);

        shouye_zixunxiangqing_touxiang = (ImageView) findViewById(R.id.shouye_zixunxiangqing_touxiang);
        shouye_zixunxiangqing_name = (TextView) findViewById(R.id.shouye_zixunxiangqing_name);
        shouye_zixunxiangqing_timer = (TextView) findViewById(R.id.shouye_zixunxiangqing_timer);
        shouye_zixunxiangqing_message = (TextView) findViewById(R.id.shouye_zixunxiangqing_message);
        shouye_xiangqing_recycle.setLayoutManager(new LinearLayoutManager(ZixunXiangQing.this));
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.shouye_xiangqing_mater);

        mRefreshLayout.setLoadMore(isLoadMore);

        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                shangla.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();
            }


            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(mList.size()>=1){
                    size = mList.size()-1;
                    String url = "https://wuye.kylinlaw.com/ask/reply/list?askId="+id+"&token="+token+"&lastAskRecId="+mList.get(size).getId();
                    Reply(url);
                }else{
                    shangla.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
        shangla = (TextView) findViewById(R.id.shouye_xiangqing_shangla);
    }

    public void qingqiu() {
        OkGo.get("https://wuye.kylinlaw.com/ask/detail?askId="+id+"&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        particulars = gson.fromJson(s, Particulars.class);
                        if(!particulars.getBody().getHeadImg().equals("")){
                            Glide.with(ZixunXiangQing.this).load(particulars.getBody().getHeadImg()).bitmapTransform(new RoundedCornersTransformation(ZixunXiangQing.this, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(shouye_zixunxiangqing_touxiang);
                        }
                        shouye_zixunxiangqing_name.setText("用户姓名 :   "+ particulars.getBody().getUserName());

                        shouye_zixunxiangqing_timer.setText("发布时间 :   "+ particulars.getBody().getQuestTm());

                        shouye_zixunxiangqing_message.setText("发布内容 :   "+ particulars.getBody().getQuest());
                        Reply("https://wuye.kylinlaw.com/ask/reply/list?askId="+id+"&token="+token);
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }
}
