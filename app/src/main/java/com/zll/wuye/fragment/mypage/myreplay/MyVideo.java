package com.zll.wuye.fragment.mypage.myreplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.zll.wuye.R;
import com.zll.wuye.bean.VideoBean;
import com.zll.wuye.fragment.homepage.adapter.VideoAdapter;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

public class MyVideo extends AppCompatActivity {

    private ImageView wode_shipin_zuo;
    private RecyclerView recycle;
    private String token;
    ArrayList<VideoBean.BodyBean> mList = new ArrayList<>();
    private VideoAdapter adapter;
    private MaterialRefreshLayout mRefreshLayout;
    private boolean isLoadMore = true;
    private  int p = 1;
    private int size;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_video);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        initView();
        initdata();
        jiexi("https://wuye.kylinlaw.com/artcl?type=2&token="+token);
    }

    private void jiexi(String url) {
        HttpOkGo.okgoget(url, VideoBean.class, new HttpOkGo.okget<VideoBean>() {
            @Override
            public void shuju(ArrayList<VideoBean> list) {
                List<VideoBean.BodyBean> body = list.get(0).getBody();
                if(body.size()>0){
                    if(p==1){
                        for (int i = 0; i < body.size(); i++) {
                            if(body.get(i).isIsBuyVideo()){
                                mList.add(body.get(i));
                            }
                        }
                        adapter = new VideoAdapter(mList,MyVideo.this,token);
                        recycle.setAdapter(adapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            for (int i = 0; i < body.size(); i++) {
                                if(body.get(i).isIsBuyVideo()){
                                    mList.add(body.get(i));
                                }
                            }
                            adapter.notifyItemRangeChanged(size-1,mList.size()-1);
                        }else{
                            tv.setVisibility(View.VISIBLE);
                        }
                    }
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();

            }
        });
    }

    private void initdata() {
        wode_shipin_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recycle.setLayoutManager(new LinearLayoutManager(MyVideo.this));
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
                if(mList.size()>=1){
                    size = mList.size();
                    jiexi("https://wuye.kylinlaw.com/artcl?type=2&token="+token+"&lastId="+mList.get(size-1).getId());
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
    }

    private void initView() {
        wode_shipin_zuo = (ImageView) findViewById(R.id.wode_shipin_zuo);
        recycle = (RecyclerView) findViewById(R.id.wode_shipin_recycle);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.wode_shipin_mater);
        tv = (TextView) findViewById(R.id.wode_shipin_shangla);
    }
}
