package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.bean.ZaixianZixun;
import com.zll.wuye.fragment.homepage.adapter.HomepagezixunHolder;


import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

//资讯页
public class Consult extends AutoLayoutActivity {

    private RecyclerView recycler;
    private String token;
    private MaterialRefreshLayout mRefreshLayout;
    ArrayList<ZaixianZixun.BodyBean> list = new ArrayList();
    private HomepagezixunHolder adapter;
    private int p=1;
    private boolean isLoadMore = true;
    private int size;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        initView();
    }

    private void initView() {
        qingqiu("https://wuye.kylinlaw.com/ask/list?token="+token);
        recycler = (RecyclerView) findViewById(R.id.shouye_zaixianzixun_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        ImageView zuo = (ImageView) findViewById(R.id.shouye_zaixianzixun_zuo);
        zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button mianfei = (Button) findViewById(R.id.shouye_mianfei);
        mianfei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token.equals("")||token.length()<1){
                    Toast.makeText(Consult.this,"请先登录",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Consult.this, MianfeiZixun.class);
                    intent.putExtra("token", token);
                    startActivity(intent);
                }
            }
        });
        Button dianhua = (Button) findViewById(R.id.shouye_dianhua);
        dianhua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token.equals("")||token.length()<1){
                    Toast.makeText(Consult.this,"请先登录",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Consult.this, Photozixun.class);
                    intent.putExtra("name", "电话咨询");
                    intent.putExtra("token", token);
                    startActivity(intent);
                }
            }
        });

        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.shouye_zaixianzixun_mater);
        mRefreshLayout.setLoadMore(isLoadMore);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(list.size()>1){
                    isLoadMore = true;
                    size = list.size();
                    qingqiu("https://wuye.kylinlaw.com/ask/list?token="+token+"&pageSize=10&lastId="+(list.get(size-1).getId()));
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
        tv = (TextView) findViewById(R.id.zixun_shangla);

    }



    public void qingqiu(String url){
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        ZaixianZixun zaixianZixun = gson.fromJson(s, ZaixianZixun.class);
                        List<ZaixianZixun.BodyBean> body = zaixianZixun.getBody();
                        if(body!=null&&body.size()>=1){
                            tv.setVisibility(View.GONE);
                            list.addAll(body);
                            if(p==1){
                                adapter = new HomepagezixunHolder(Consult.this, list, token);
                                recycler.setAdapter(adapter);
                                p++;
                            }else{
                                adapter.notifyItemRangeChanged(size-1,list.size()-1);
                            }
                        }else{
                            tv.setVisibility(View.VISIBLE);
                        }

                        mRefreshLayout.finishRefreshLoadMore();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }
}
