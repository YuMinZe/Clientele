package com.zll.wuye.fragment.mypage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.MyWeiTuoxqBean;
import com.zll.wuye.fragment.mypage.RegisterLogin.Register;
import com.zll.wuye.fragment.mypage.myreplay.LvshiXq;
import com.zll.wuye.fragment.mypage.myreplay.MyWeituoXq;
import com.zll.wuye.fragment.mypage.myreplay.Myorder;
import com.zll.wuye.fragment.mypage.viewholder.MyWeituoXqViewHolder;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/27 10:54
 */
public class MyWeituoXqAdapter extends RecyclerView.Adapter<MyWeituoXqViewHolder> {
    private final Context context;
    private final List<MyWeiTuoxqBean.BodyBean.ListBean> list;
    private final String token;
    private final String id;
    private final MyWeiTuoxqBean.BodyBean body;

    public MyWeituoXqAdapter(Context context, List<MyWeiTuoxqBean.BodyBean.ListBean> list, String token, String id, MyWeiTuoxqBean.BodyBean body) {
        this.context = context;
        this.list = list;
        this.token = token;
        this.id=id;
        this.body = body;
    }

    @Override
    public MyWeituoXqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myweituo_recycle, null);
        MyWeituoXqViewHolder holder = new MyWeituoXqViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyWeituoXqViewHolder holder, final int position) {
        Glide.with(context)
                .load(list.get(position).getLawyer().getHeadUrl())
                .bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                .crossFade(1000)
                .into(holder.touxiang);
        holder.name.setText("姓名:"+list.get(position).getLawyer().getName());
        holder.diyu.setText("地域:"+list.get(position).getLawyer().getAddress());
        holder.techang.setText("特长:"+list.get(position).getLawyer().getTypeName());
        holder.danwei.setText("单位:"+list.get(position).getLawyer().getLawName());
        final int status = list.get(position).getStatus();
        if(status==0){
           holder.canjia.setText("竞标中");
        }else if(status==1){
            holder.canjia.setText("已中标");
        }else if(status==2){
            holder.canjia.setText("未中标");
        }
        if(body.getStatus()==4){
            holder.canjia.setText("已完成");
        }
        holder.mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(body.getStatus()==4){
                    Toast.makeText(context,"投标结束",Toast.LENGTH_SHORT).show();
                }else{
                    if(status==0){
                        Intent intent = new Intent(context, LvshiXq.class);
                        intent.putExtra("token",token);
                        intent.putExtra("id",id+"");
                        intent.putExtra("id2",list.get(position).getId()+"");
                        intent.putExtra("position",position+"");
                        intent.putExtra("p",0+"");
                        context.startActivity(intent);
                    }else if(status==1){
                        if(body.getStatus()==3){
                            Intent intent = new Intent(context, LvshiXq.class);
                            intent.putExtra("token",token);
                            intent.putExtra("id",id+"");
                            intent.putExtra("id2",list.get(position).getId()+"");
                            intent.putExtra("position",position+"");
                            intent.putExtra("p",1+"");
                            context.startActivity(intent);
                        }else{
                            Intent intent = new Intent(context, Myorder.class);
                            intent.putExtra("token",token);
                            context.startActivity(intent);
                        }
                    }else if(status==2){
                        Toast.makeText(context,"您未中标",Toast.LENGTH_SHORT).show();
                    }else if(status==4){
                        Toast.makeText(context,"您未中标",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
