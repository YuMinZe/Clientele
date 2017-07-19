package com.zll.wuye.fragment.consult.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.bean.InformationBean;
import com.zll.wuye.fragment.consult.activity.Consultparticulars;
import com.zll.wuye.fragment.consult.viewholder.ConsultViewHolder;
import com.zll.wuye.fragment.homepage.activity.MyVideoXQ;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/5 12:59
 */
public class ConsultAdapter extends RecyclerView.Adapter<ConsultViewHolder> {
    private final Context context;
    private final ArrayList<InformationBean.BodyBean> bean;
    private final String token;

    public ConsultAdapter(Context context, ArrayList<InformationBean.BodyBean> bean, String token) {
        this.context = context;
        this.bean = bean;
        this.token=token;
    }

    @Override
    public ConsultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.consult_recycle, null);
        ConsultViewHolder holder = new ConsultViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ConsultViewHolder holder, final int position) {
        if(bean.get(position).getImgUrl().length()>0){
            holder.image.setVisibility(View.VISIBLE);
            Glide.with(context).load(bean.get(position).getImgUrl()).into(holder.image);
        }else{
            holder.image.setVisibility(View.GONE);
        }
        holder.title.setText(bean.get(position).getTitle());
        holder.message.setText(bean.get(position).getIntro());
        String strTime = getStrTime(bean.get(position).getCreatTm() + "");
        holder.shi.setText(strTime);
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyVideoXQ.class);
                intent.putExtra("name","咨询详情");
                intent.putExtra("url","http://wuye.kylinlaw.com/artcl/show.html?id=" + bean.get(position).getId() + "&token=" + token);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }


    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }

}
