package com.zll.wuye.fragment.consult;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.base.BaseFragment;
import com.zll.wuye.bean.InformationBean;
import com.zll.wuye.fragment.consult.adapter.ConsultAdapter;


import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 1. 资讯
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 14:44
 */
public class ConsultFragment extends BaseFragment {


    private View mInflate;
    private RecyclerView recycler;
    ArrayList<InformationBean.BodyBean> list = new ArrayList();
    private MaterialRefreshLayout mRefreshLayout;
    private int p=1;
    private boolean isLoadMore = true;
    private int size;
    private String token;
    private ConsultAdapter adapter;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflate = View.inflate(getActivity(), R.layout.consultfragment, null);
        return mInflate;
    }

    @Override
    public void initdata() {
        final SharedPreferences sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        zixun("https://wuye.kylinlaw.com/artcl?type=0&tokrn="+token);

        recycler = (RecyclerView) mInflate.findViewById(R.id.zixun_recycle);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRefreshLayout = (MaterialRefreshLayout) mInflate.findViewById(R.id.zixun_mater);
        mRefreshLayout.setLoadMore(isLoadMore);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mRefreshLayout.finishRefresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if(list.size()>1){
                    size = list.size()-1;
                    String url = "https://wuye.kylinlaw.com/artcl?type=0&token="+token+"&lastId="+list.get(size).getId();
                    zixun(url);
                }else{
                    Toast.makeText(getActivity(),"暂无更多数据",Toast.LENGTH_SHORT).show();
                    mRefreshLayout.finishRefreshLoadMore();
                }

            }
        });

    }

    public void zixun(String url){
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        InformationBean bean = gson.fromJson(s, InformationBean.class);
                        List<InformationBean.BodyBean> body = bean.getBody();
                        if(body.size()>=1){
                            list.addAll(body);
                            if(p==1){
                                adapter = new ConsultAdapter(getActivity(), list,token);
                                recycler.setAdapter(adapter);
                            }else{
                                adapter.notifyItemRangeChanged(size,list.size()-1);
                            }
                        }else{
                            Toast.makeText(getActivity(),"暂无更多数据",Toast.LENGTH_SHORT).show();
                        }

                        mRefreshLayout.finishRefreshLoadMore();

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }
}
