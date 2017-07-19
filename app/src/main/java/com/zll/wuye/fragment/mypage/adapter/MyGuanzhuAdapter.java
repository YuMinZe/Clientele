package com.zll.wuye.fragment.mypage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.MyGuanzhuBean;
import com.zll.wuye.fragment.homepage.activity.AttorneyMessage;
import com.zll.wuye.fragment.mypage.myreplay.MyGuanZhu;
import com.zll.wuye.fragment.mypage.viewholder.MyGuanzhuViewHolder;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 11:12
 */
public class MyGuanzhuAdapter extends RecyclerView.Adapter<MyGuanzhuViewHolder>{
    private final List<MyGuanzhuBean.BodyBean> body;
    private final Context context;
    private final String token;

    public MyGuanzhuAdapter(List<MyGuanzhuBean.BodyBean> body, Context context, String token) {
        this.body = body;
        this.context = context;
        this.token = token;
    }

    @Override
    public MyGuanzhuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.my_guanzhu, null);
        MyGuanzhuViewHolder holder = new MyGuanzhuViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyGuanzhuViewHolder holder, final int position) {
        if(!body.get(position).getHeadUrl().equals("")){
            Glide.with(context).load(body.get(position).getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        }
        holder.name.setText("姓名:  "+body.get(position).getName());
        holder.diyu.setText("地域:  "+body.get(position).getAddress());
        holder.techang.setText("特长:  "+body.get(position).getTypeName());
        holder.danwei.setText("单位:  "+body.get(position).getLawName());
        holder.jingyan.setText(body.get(position).getPeriod()+"年");
        holder.guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.guanzhu.setText("关注");
                guanzhu(body.get(position).getId());
            }
        });
        holder.touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AttorneyMessage.class);
                intent.putExtra("attorney",""+body.get(position).getLawyerId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return body.size();
    }

    private void guanzhu(int id) {
        OkGo.get("https://wuye.kylinlaw.com/lawyer/del/flw?token=" + token+"&flwId="+id)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }
}
