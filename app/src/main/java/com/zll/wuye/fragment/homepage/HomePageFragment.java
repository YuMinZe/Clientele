package com.zll.wuye.fragment.homepage;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.base.BaseFragment;
import com.zll.wuye.fragment.homepage.activity.Alot;
import com.zll.wuye.fragment.homepage.adapter.HomepagerAdapter;
import com.zll.wuye.http.Panduan;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 14:44
 */
public class HomePageFragment extends BaseFragment {


    private View mView;
    private RecyclerView mRecyclerView;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.homepagefragment, null);
        return mView;
    }

    @Override
    public void initdata() {

        mRecyclerView = (RecyclerView) mView.findViewById(R.id.zhuye_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRecyclerView.setAdapter(new HomepagerAdapter(getActivity()));
        ImageView zixunkefu = (ImageView) mView.findViewById(R.id.shouye_zixunkefu);
        zixunkefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Alot().dadianhua(getActivity());
            }
        });
    }
}
