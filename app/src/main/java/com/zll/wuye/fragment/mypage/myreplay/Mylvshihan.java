package com.zll.wuye.fragment.mypage.myreplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.MyWeituoBean;
import com.zll.wuye.bean.MylvshihanBean;
import com.zll.wuye.fragment.mypage.adapter.MylvshihanAdapter;
import com.zll.wuye.fragment.mypage.adapter.WeiTuoAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class Mylvshihan extends AppCompatActivity {

    private String token;
    private ImageView wode_lvshihan_fanhui;
    private RecyclerView wode_lvshihan_recycle;

    private MaterialRefreshLayout mRefreshLayout;
    ArrayList<MylvshihanBean.BodyBean> list= new ArrayList<>();
    private boolean isLoadMore = true;
    private  int p = 1;
    private int size;
    private MylvshihanAdapter adapter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylvshihan);
        initView();

        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        shuju("https://wuye.kylinlaw.com/order/user/letter/list?token=" + token);
        initdata();
    }

    private void initdata() {
        wode_lvshihan_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_lvshihan_recycle.setLayoutManager(new LinearLayoutManager(this));

        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.wode_lvshihan_mater);

        mRefreshLayout.setLoadMore(isLoadMore);

        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            /**
             * 刷新的方法，我这里演示的是下拉刷新，因为没有数据，我这里也就只是toast一下
             * 如果想要实现你们自己要的结果，就会在定义一个方法，获取最新数据，或者是在次
             * 在这里调用之前获取数据的方法，以达到刷新数据的功能
             * @param materialRefreshLayout
             */
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();
            }

            /**
             * 上拉加载更多的方法，在这里我只是简单的模拟了加载四条数据
             * 真正用的时候，就会去定义方法，获取数据，一般都是分页，在数据端获取的时候
             * 把页数去增加一，然后在去服务端去获取数据
             * @param materialRefreshLayout
             */
            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(list.size()>=1){
                    size = list.size();
                    shuju("https://wuye.kylinlaw.com/order/user/letter/list?token=" + token+"&lastId="+(list.size()-1));
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();

            }
        });
    }

    private void shuju(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        MylvshihanBean bean = gson.fromJson(s, MylvshihanBean.class);
                        List<MylvshihanBean.BodyBean> body = bean.getBody();
                        if(body.size()>=1){
                            if(p==1){
                                tv.setVisibility(View.GONE);
                                list.addAll(body);
                                adapter = new MylvshihanAdapter(Mylvshihan.this, list,token);
                                wode_lvshihan_recycle.setAdapter(adapter);
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

    private void initView() {
        wode_lvshihan_fanhui = (ImageView) findViewById(R.id.wode_lvshihan_fanhui);
        wode_lvshihan_recycle = (RecyclerView) findViewById(R.id.wode_lvshihan_recycle);
        tv = (TextView) findViewById(R.id.wode_lvshihan_shangla);
    }
}
