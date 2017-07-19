package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.MoreEvaluateBean;
import com.zll.wuye.fragment.homepage.activity.MoreEvaluate;
import com.zll.wuye.fragment.homepage.viewholder.MorePjViewHolder;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 16:53
 */
public class MorePjAdapter extends RecyclerView.Adapter<MorePjViewHolder> {
    private final Context context;
    private final List<MoreEvaluateBean.BodyBean> body;

    public MorePjAdapter(Context context, List<MoreEvaluateBean.BodyBean> body) {
        this.context = context;
        this.body = body;
    }

    @Override
    public MorePjViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.moreevaluate_recycle, null);
        MorePjViewHolder holder = new MorePjViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MorePjViewHolder holder, int position) {
        if(body.get(position).getHeadUrl()!=null){
            Glide.with(context).load(body.get(position).getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        }
        holder.name.setText("用户姓名:  "+body.get(position).getName());
        holder.message.setText("评价内容:  "+body.get(position).getCntn());
        int score = body.get(position).getScore();
        if(score==0){
            holder.huida.setText("不满意");
        }else if(score==0){
            holder.huida.setText("一般");
        }else if(score==0){
            holder.huida.setText("满意");
        }else{

        }


    }

    @Override
    public int getItemCount() {
        return body.size();
    }
}
