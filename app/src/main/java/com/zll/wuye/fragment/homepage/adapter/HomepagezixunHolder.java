package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.ZaixianZixun;
import com.zll.wuye.fragment.homepage.activity.ZixunXiangQing;
import com.zll.wuye.fragment.homepage.viewholder.HomePagezixun;
import java.util.List;

import okhttp3.Call;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/26 15:40
 */
public class HomepagezixunHolder extends RecyclerView.Adapter<HomePagezixun> {


    private final Context context;
    private final List<ZaixianZixun.BodyBean> body;
    private final String token;

    public HomepagezixunHolder(Context context, List<ZaixianZixun.BodyBean> body, String token) {
        this.context = context;
        this.body = body;
        this.token = token;
    }

    @Override
    public HomePagezixun onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shouye_zaixianzixun, parent, false);
        HomePagezixun homePagezixun = new HomePagezixun(inflate);
        return homePagezixun;
    }

    @Override
    public void onBindViewHolder(HomePagezixun holder, final int position) {
        if(!body.get(position).getHeadImg().equals("")){
            Glide.with(context).load(body.get(position).getHeadImg()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        }
        holder.name.setText("用户姓名:"+body.get(position).getUserName());
        holder.timer.setText("发布时间:"+body.get(position).getQuestTm());
        holder.message.setText("问题内容:"+body.get(position).getQuest());
        holder.huida.setText(body.get(position).getAnsCnt()+"个人回答");
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, ZixunXiangQing.class);
                in.putExtra("id",body.get(position).getId()+"");
                in.putExtra("token",token);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return body.size();
    }


}
