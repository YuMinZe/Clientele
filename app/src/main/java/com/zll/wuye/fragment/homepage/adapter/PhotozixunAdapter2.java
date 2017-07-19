package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.PhotoBean;
import com.zll.wuye.fragment.homepage.activity.AttorneyMessage;
import com.zll.wuye.fragment.homepage.viewholder.PhotozixunViewVolder;
import com.zll.wuye.fragment.homepage.viewholder.PhotozixunViewVolder2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/31 16:55
 */
public class PhotozixunAdapter2 extends RecyclerView.Adapter<PhotozixunViewVolder2> {
    private final List<PhotoBean.BodyBean> body;
    private final Context context;
    private final String token;

    public PhotozixunAdapter2(List<PhotoBean.BodyBean> body, Context context, String token) {
        this.body = body;
        this.context = context;
        this.token=token;
    }

    @Override
    public PhotozixunViewVolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_photozixun_recycle2, null);
        PhotozixunViewVolder2 photozixunViewVolder = new PhotozixunViewVolder2(view);
        return photozixunViewVolder;
    }

    @Override
    public void onBindViewHolder(PhotozixunViewVolder2 holder, final int position) {
        if(!body.get(position).getHeadUrl().equals("")){
            Glide.with(context).load(body.get(position).getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.img);
        }
        holder.name.setText("姓名:  "+body.get(position).getName());
        holder.diyu.setText("地域:  "+body.get(position).getAddress());
        holder.techang.setText("特长:  "+body.get(position).getTypeName());
        holder.danwei.setText("单位:  "+body.get(position).getLawName());

        holder.jingyan.setText(body.get(position).getPeriod()+"年");
        holder.xiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token.length()>1){
                    Intent intent = new Intent(context, AttorneyMessage.class);
                    intent.putExtra("attorney",""+body.get(position).getId());
                    context.startActivity(intent);
                }else{
                 Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return body.size();
    }
}
