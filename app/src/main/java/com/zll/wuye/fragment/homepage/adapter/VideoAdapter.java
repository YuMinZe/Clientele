package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.VideoBean;
import com.zll.wuye.bean.VideodanBean;
import com.zll.wuye.fragment.homepage.activity.MyVideoXQ;
import com.zll.wuye.fragment.homepage.activity.PaymentActivity;
import com.zll.wuye.fragment.homepage.viewholder.VideoViewHolder;
import com.zll.wuye.http.HttpOkGo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 15:09
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private final ArrayList<VideoBean.BodyBean> list;
    private final Context context;
    private final String token;
    private int i=1;
    public VideoAdapter(ArrayList<VideoBean.BodyBean> list, Context context, String token) {
        this.list = list;
        this.context = context;
        this.token=token;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_recycle, null);
        VideoViewHolder holder = new VideoViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getImgUrl()).into(holder.image);
        holder.title.setText(""+list.get(position).getTitle());
        holder.jianjie.setText(""+list.get(position).getIntro());
        if(list.get(position).isIsBuyVideo()){
            holder.price.setText("已购买");
        }else{
            holder.price.setText(list.get(position).getPrice()+"元");
        }
        String strTime = getStrTime(list.get(position).getCreatTm() + "");
        holder.time.setText(strTime+"");
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).isIsBuyVideo()){
                    Intent intent = new Intent(context, MyVideoXQ.class);
                    intent.putExtra("name","视频详情");
                    intent.putExtra("url","http://wuye.kylinlaw.com/artcl/videoShow.html?id=" + list.get(position).getId() + "&token=" + token);
                    context.startActivity(intent);
                }else{
                    if(i==1){
                        shipinding(position);
                        i++;
                    }else{
                       Toast.makeText(context,"获取订单中...",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }

    public void shipinding(int position){
        HashMap<String,Object> map = new HashMap<>();
        map.put("type","video");
        map.put("typeId",list.get(position).getId());
        map.put("title",list.get(position).getTitle());
        map.put("price",list.get(position).getPrice());
        map.put("num",1);
        Map<String,String> mmp = new HashMap<>();
        mmp.put("title",list.get(position).getTitle());
        map.put("cntn",list.get(position).getIntro());
        map.put("attr",mmp);
        String url = "https://wuye.kylinlaw.com/order/create?token="+token;
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Gson gson = new Gson();
                VideodanBean bean = gson.fromJson(s, VideodanBean.class);
                Intent intent = new Intent(context, PaymentActivity.class);
                intent.putExtra("token",token);
                intent.putExtra("indent",bean.getBody().getOrderNo());
                intent.putExtra("leixing",bean.getBody().getOrderNo());
                intent.putExtra("price",bean.getBody().getTotalPrice());
                context.startActivity(intent);
                i=1;
            }
        });


    }
}
