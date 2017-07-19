package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.ReplyConsulting;
import com.zll.wuye.fragment.homepage.activity.AttorneyMessage;
import com.zll.wuye.fragment.homepage.activity.ZixunXiangQing;
import com.zll.wuye.fragment.homepage.viewholder.ReplyViewHolder;

import java.util.List;
import java.util.Queue;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/27 10:05
 */
public class ReplyAdapter extends RecyclerView.Adapter<ReplyViewHolder> {
    private final Context context;
    private final List<ReplyConsulting.BodyBean> body;
    private final String token;
    private final int num;
    private TextView caina;

    public ReplyAdapter(Context context, List<ReplyConsulting.BodyBean> body, String token,int num) {
        this.context = context;
        this.body = body;
        this.token = token;
        this.num = num;
    }

    @Override
    public ReplyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_zixunhuifu, null);
        ReplyViewHolder holder = new ReplyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ReplyViewHolder holder, final int position) {
        if(body!=null){
            if(!body.get(position).getHeadImg().equals("")){
                Glide.with(context).load(body.get(position).getHeadImg()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
            }
            holder.name.setText("律师姓名:  "+body.get(position).getUserName());
            holder.timer.setText("发布时间:  "+body.get(position).getAnsTm());
            holder.message.setText("回答内容:  "+body.get(position).getAns());
            if(body.get(position).getIsAdopt()==0){
                holder.caina.setText("采纳");
                holder.tv.setVisibility(View.GONE);
                holder.caina.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        caina1(body.get(position).getId());
                        holder.tv.setVisibility(View.VISIBLE);
                        caina = holder.caina;
                    }
                });
            }else if(body.get(position).getIsAdopt()==1){
                holder.caina.setText("已采纳");
                holder.tv.setVisibility(View.VISIBLE);
            }
            if(num==1){
                holder.caina.setVisibility(View.VISIBLE);
            }else{
                holder.caina.setVisibility(View.GONE);
            }

            holder.zhaota.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, AttorneyMessage.class);
                    intent.putExtra("attorney",""+body.get(position).getReplyLawyerId());
                    context.startActivity(intent);
                }
            });
        }




    }

    @Override
    public int getItemCount() {
        return body.size();
    }

    public void caina1(int id){
        OkGo.get("https://wuye.kylinlaw.com/ask/adopt?askRecId="+id+"&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        caina.setText("已采纳");
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }
}
