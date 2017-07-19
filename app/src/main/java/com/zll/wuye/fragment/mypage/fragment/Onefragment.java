package com.zll.wuye.fragment.mypage.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.base.BaseFragment;
import com.zll.wuye.bean.MyZiXuBean;
import com.zll.wuye.fragment.mypage.adapter.MyReplayAdapter;
import com.zll.wuye.fragment.mypage.myreplay.Myreplay;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/3 13:14
 */
public class Onefragment extends BaseFragment {

    private View mView;
    private RecyclerView wode_zixun_recycle;
    private SharedPreferences sp;
    private String token;
    ArrayList<MyZiXuBean.BodyBean> list = new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private boolean isLoadMore = true;
    private  int p = 1;
    private int size;
    private MyReplayAdapter adapter;
    private TextView tv;
    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.onefragment, null);
        return mView;
    }

    @Override
    public void initdata() {
        sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", null);
        wode_zixun_recycle = (RecyclerView) mView.findViewById(R.id.wode_zixun_recycle);
        wode_zixun_recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        shuju("https://wuye.kylinlaw.com/order/user/ask/list?token="+token);

        mRefreshLayout = (MaterialRefreshLayout) mView.findViewById(R.id.wode_zixun_mater);

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
                    size = list.size() - 1;
                    shuju("https://wuye.kylinlaw.com/order/user/ask/list?token="+token+"&lastId="+list.get(size).getId());
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();

            }
        });
        tv = (TextView) mView.findViewById(R.id.wode_zixun_shangla);
    }

    private void shuju(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        MyZiXuBean bean = gson.fromJson(s, MyZiXuBean.class);
                        List<MyZiXuBean.BodyBean> body = bean.getBody();
                        if(body.size()>=1){
                            if(p==1){
                                tv.setVisibility(View.GONE);
                                list.addAll(body);
                                adapter = new MyReplayAdapter(list, getActivity(), token, new MyReplayAdapter.sx() {
                                    @Override
                                    public void shuxin() {
                                        list.clear();
                                        initdata();
                                    }
                                });
                                wode_zixun_recycle.setAdapter(adapter);
                                p++;
                            }else{
                                if(body.size()>=10){
                                    list.addAll(body);
                                    adapter.notifyItemRangeChanged(size,list.size()-1);
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
}
