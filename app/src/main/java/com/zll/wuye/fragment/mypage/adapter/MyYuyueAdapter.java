package com.zll.wuye.fragment.mypage.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.MyYuyueBean;
import com.zll.wuye.fragment.mypage.viewholder.MyYuyueViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 15:46
 */
public class MyYuyueAdapter extends RecyclerView.Adapter<MyYuyueViewHolder> {

    private final Context context;
    private final List<MyYuyueBean.BodyBean> body;
    private final String token;
    private MyYuyueViewHolder holder;

    public MyYuyueAdapter(Context context, List<MyYuyueBean.BodyBean> body, String token) {
        this.context = context;
        this.body = body;
        this.token = token;
    }

    @Override
    public MyYuyueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wode_yuyue_iten, null);
        holder = new MyYuyueViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyYuyueViewHolder holder, final int position) {
        holder.price.setText("支付金额:￥"+body.get(position).getTotalPrice());
        String strTime = getStrTime(body.get(position).getCreatTm() + "");
        holder.time.setText("购买时间:"+strTime);
        if(body.get(position).getLawyer().getHeadUrl()!=null){
            Glide.with(context).load(body.get(position).getLawyer().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        }
        holder.name.setText("姓名:"+body.get(position).getLawyer().getName());
        holder.jingyan.setText(body.get(position).getLawyer().getPeriod()+"");

        holder.diyu.setText("地域:"+body.get(position).getLawyer().getAddress());
        holder.techang.setText("特长:"+body.get(position).getLawyer().getTypeName());
        holder.danwei.setText("单位:"+body.get(position).getLawyer().getLawName());

        if(body.get(position).getPayStatus()==0){
            holder.queren.setText("未支付");
        }else{
            if(body.get(position).getOrderStatus()==0){
                holder.queren.setText("确认已见面");
                holder.queren.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("确认见面完成了吗？");
                        builder.setTitle("提示");
                        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                                OkGo.get("https://wuye.kylinlaw.com/order/user/finish?token=" + token+"&orderNo="+body.get(position).getOrderNo())//
                                        .tag(this)//
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {
                                                holder.queren.setText("见面已完成");
                                                holder.queren.setBackgroundColor(R.mipmap.biankuang);
                                                holder.queren.setTextColor(Color.BLUE);
                                                holder.queren.setFocusable(false);
                                            }

                                            @Override
                                            public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                                            }
                                        });
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                });
            }else{
                holder.queren.setText("见面已完成");
                holder.queren.setBackgroundColor(R.mipmap.biankuang);
                holder.queren.setTextColor(Color.BLUE);
                holder.queren.setFocusable(false);
            }
        }


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
