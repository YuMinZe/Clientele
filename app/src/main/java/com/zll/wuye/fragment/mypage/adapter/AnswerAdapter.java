package com.zll.wuye.fragment.mypage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.AnliLeixing;
import com.zll.wuye.bean.MyAnswerBean;
import com.zll.wuye.fragment.homepage.activity.ZixunXiangQing;
import com.zll.wuye.fragment.mypage.viewholder.AnswerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/20 11:04
 */
public class AnswerAdapter extends RecyclerView.Adapter<AnswerViewHolder> {
    private final Context context;
    private final ArrayList<MyAnswerBean.BodyBean> list;
    private final String token;
    private List<AnliLeixing.BodyBean> mBody;

    public AnswerAdapter(Context context, ArrayList<MyAnswerBean.BodyBean> mlist, String token) {
        this.context = context;
        this.list = mlist;
        this.token=token;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shouye_huidazixun, null);
        AnswerViewHolder holder = new AnswerViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, final int position) {
        Glide.with(context)
                .load(list.get(position).getHeadImg())
                .bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                .crossFade(1000).into(holder.mTouxiang);
        holder.mName.setText(list.get(position).getUserName());
        holder.mTime.setText("发布时间:"+list.get(position).getQuestTm());
        holder.mMessage.setText("问题内容:"+list.get(position).getQuest());
        holder.mRen.setText(list.get(position).getAnsCnt()+"个人回答");
        holder.mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, ZixunXiangQing.class);
                in.putExtra("id",list.get(position).getId()+"");
                in.putExtra("token",token);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
