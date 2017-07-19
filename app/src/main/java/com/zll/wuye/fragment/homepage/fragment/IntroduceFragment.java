package com.zll.wuye.fragment.homepage.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.KeFuBean;
import com.zll.wuye.fragment.homepage.activity.Alot;
import com.zll.wuye.fragment.homepage.activity.Anjianweituo_tuo;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/5 14:16
 */
public class IntroduceFragment extends Fragment{

    private View mInflate;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflate = View.inflate(getActivity(), R.layout.weituo_introduce, null);
        return mInflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        Button zixunkefu = (Button) mInflate.findViewById(R.id.anjianweituo_zixunkefu);
        Button woyaoweituo = (Button) mInflate.findViewById(R.id.anjianweituo_woyaoweituo);
        woyaoweituo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token.equals("")){
                    Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getActivity(),Anjianweituo_tuo.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }

            }
        });
        zixunkefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Alot().dadianhua(getActivity());
            }
        });
    }
}
