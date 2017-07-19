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
import com.zll.wuye.R;
import com.zll.wuye.base.BaseFragment;
import com.zll.wuye.bean.MyAnswerBean;
import com.zll.wuye.fragment.mypage.adapter.AnswerAdapter;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/3 13:14
 */
public class Freefragment extends BaseFragment {

    private View mView;
    private SharedPreferences sp;
    private String token;
    private RecyclerView answer_recycle;
    private TextView tv;
    private MaterialRefreshLayout mRefreshLayout;
    private ArrayList<MyAnswerBean.BodyBean> mlist = new ArrayList<>();
    private int p=1;
    private boolean isLoadMore = true;
    private int size;
    private AnswerAdapter adapter;
    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.freefragment, null);
        return mView;
    }

    @Override
    public void initdata() {
        sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", null);
        mRefreshLayout = (MaterialRefreshLayout) mView.findViewById(R.id.wode_zixun_mianfei_mater);
        answer_recycle = (RecyclerView) mView.findViewById(R.id.wode_zixun_mianfei_recycle);
        tv = (TextView) mView.findViewById(R.id.wode_zixun_mianfei_shangla);
        shuju("https://wuye.kylinlaw.com/ask/my/list?token="+token);
        answer_recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRefreshLayout.setLoadMore(isLoadMore);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tv.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(mlist.size()>1){
                    isLoadMore = true;
                    size = mlist.size()-1;
                    String url = "https://wuye.kylinlaw.com/ask/my/list?token="+token+"&lastId="+mlist.get(size).getId();
                    shuju(url);
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });

    }

    private void shuju(String url) {
        HttpOkGo.okgoget(url, MyAnswerBean.class, new HttpOkGo.okget<MyAnswerBean>() {
            @Override
            public void shuju(ArrayList<MyAnswerBean> list) {
                List<MyAnswerBean.BodyBean> body = list.get(0).getBody();
                if(body!=null&&body.size()>=1){
                    if(p==1){
                        mlist.addAll(body);
                        adapter = new AnswerAdapter(getActivity(),mlist,token);
                        answer_recycle.setAdapter(adapter);
                        p++;
                    }else{
                        if(body.size()>=10){
                            mlist.addAll(body);
                            adapter.notifyItemRangeChanged(size,mlist.size()-1);
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
