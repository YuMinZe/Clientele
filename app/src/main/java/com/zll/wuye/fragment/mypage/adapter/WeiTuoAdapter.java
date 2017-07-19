package com.zll.wuye.fragment.mypage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.MyWeituoBean;
import com.zll.wuye.fragment.mypage.myreplay.MyWeiTuo;
import com.zll.wuye.fragment.mypage.myreplay.MyWeituoXq;
import com.zll.wuye.fragment.mypage.viewholder.WeiTuoViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 13:30
 */
public class WeiTuoAdapter extends RecyclerView.Adapter<WeiTuoViewHolder> {
    private final List<MyWeituoBean.BodyBean> body;
    private final Context context;
    private final String token;

    public WeiTuoAdapter(List<MyWeituoBean.BodyBean> body, Context context, String token) {
        this.body = body;
        this.context = context;
        this.token = token;
    }

    @Override
    public WeiTuoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weituoitem, null);
        WeiTuoViewHolder viewHolder = new WeiTuoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeiTuoViewHolder holder, final int position) {
        int i = body.get(position).getStatus();
        if(i==1){
            holder.panduan.setText("竞标中");
        }else if(i==2){
            holder.panduan.setText("已中标");
        }else if(i==3){
            holder.panduan.setText("已成交");
        }else if(i==4){
            holder.panduan.setText("已完成");
        }
        holder.baojia.setText("报价 : "+body.get(position).getOfferStrt()+"-"+body.get(position).getOfferEnd());
        holder.name.setText(body.get(position).getUser().getName());
        holder.message.setText("\t\t\t\t\t\t"+body.get(position).getCntn());
        holder.leixing.setText(body.get(position).getTypeName());
        String s = getStrTime(body.get(position).getCreatTm() + "");
        holder.time.setText(s+"");
        if(body.get(position).getUser().getHeadUrl()!=null){
            Glide.with(context).load(body.get(position).getUser().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        }
        holder.mWeituo_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyWeituoXq.class);
                intent.putExtra("token",token);
                intent.putExtra("id",body.get(position).getId()+"");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return body.size();
    }

    //时间戳转时间
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}
