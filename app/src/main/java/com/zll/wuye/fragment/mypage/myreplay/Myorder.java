package com.zll.wuye.fragment.mypage.myreplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.Dingdan;
import com.zll.wuye.fragment.mypage.adapter.DingdanAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
//我的订单
public class Myorder extends AutoLayoutActivity {

    private String token;
    private RecyclerView dingdan_recycle;
    private MaterialRefreshLayout mRefreshLayout;
    private boolean isLoadMore = true;
    private int p=1;
    private int size;
    ArrayList<Dingdan.BodyBean> list = new ArrayList<>();
    private DingdanAdapter adapter;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        qingqiu("https://wuye.kylinlaw.com/order/user/list?token="+token);
        initview();

    }

    private void initview() {
        ImageView image = (ImageView) findViewById(R.id.shouye_wodedingdan_zuo);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dingdan_recycle = (RecyclerView) findViewById(R.id.wode_dingdan_recycle);
        dingdan_recycle.setLayoutManager(new LinearLayoutManager(this));
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.wode_dingdan_material);
        mRefreshLayout.setLoadMore(isLoadMore);

        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();
            }


            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(list.size()>=1){
                    size = list.size();
                    qingqiu("https://wuye.kylinlaw.com/order/user/list?token="+token+"&pageSize=10&lastId="+(list.get(size-1).getId()));
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
        tv = (TextView) findViewById(R.id.wode_dingdan_shangla);
    }

    private void qingqiu(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        Dingdan dingdan = gson.fromJson(s, Dingdan.class);
                        List<Dingdan.BodyBean> body = dingdan.getBody();
                        if(body!=null&&body.size()>=1){
                            if(p==1){
                                list.addAll(body);
                                adapter = new DingdanAdapter(list, Myorder.this,token);
                                dingdan_recycle.setAdapter(adapter);
                                p++;
                            }else{
                                if(body.size()>=10){
                                    list.addAll(body);
                                    adapter.notifyItemRangeChanged(size-1,list.size()-1);
                                }else{
                                    tv.setVisibility(View.VISIBLE);
                                }
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
        if(list.size()>0){
            list.clear();
            initview();
            qingqiu("https://wuye.kylinlaw.com/order/user/list?token="+token);
            adapter.notifyDataSetChanged();
        }
    }
}
