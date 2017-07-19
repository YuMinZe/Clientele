package com.zll.wuye.fragment.homepage.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.zll.wuye.R;
import com.zll.wuye.base.BaseFragment;
import com.zll.wuye.bean.CourseBean;
import com.zll.wuye.bean.KeFuBean;
import com.zll.wuye.fragment.homepage.activity.Alot;
import com.zll.wuye.fragment.homepage.activity.ApplyActivity;
import com.zll.wuye.fragment.homepage.adapter.CourseAdapter;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 10:14
 */
public class Coursefragment extends BaseFragment {

    private View view;
    private RecyclerView recycle;
    private Button zixunkefu;
    private Button woyaoweituo;
    private TextView tv;
    private String token;
    ArrayList<CourseBean.BodyBean> mList = new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private boolean isLoadMore = true;
    private  int p = 1;
    private int size;
    private CourseAdapter adapter;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_course, null);
        return view;
    }

    @Override
    public void initdata() {
        final SharedPreferences sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        recycle = (RecyclerView) view.findViewById(R.id.shouye_kecheng_recycler);
        zixunkefu = (Button) view.findViewById(R.id.kecheng_zixunkefu);
        woyaoweituo = (Button) view.findViewById(R.id.kecheng_woyaoweituo);
        tv = (TextView) view.findViewById(R.id.kecheng_shangla);

        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        jiexi("https://wuye.kylinlaw.com/artcl?type=1&token="+token);
        mRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.shouye_kecheng_mater);
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
                if(mList.size()>=1){
                    size = mList.size();
                    jiexi("https://wuye.kylinlaw.com/artcl?type=1&token="+token+"&lastId="+mList.get(size-1).getId());
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });

        zixunkefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Alot().dadianhua(getActivity());
            }
        });

        woyaoweituo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ApplyActivity.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });

    }

    private void jiexi(String url) {
        HttpOkGo.okgoget(url, CourseBean.class, new HttpOkGo.okget<CourseBean>() {
            @Override
            public void shuju(ArrayList<CourseBean> list) {
                List<CourseBean.BodyBean> body = list.get(0).getBody();
                if(body.size()>=1) {
                    if(p==1){
                        mList.addAll(body);
                        adapter = new CourseAdapter(getActivity(), mList,token);
                        recycle.setAdapter(adapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            mList.addAll(body);
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



}
