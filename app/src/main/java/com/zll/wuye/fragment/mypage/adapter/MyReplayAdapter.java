package com.zll.wuye.fragment.mypage.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.MyZiXuBean;
import com.zll.wuye.bean.WanchengBean;
import com.zll.wuye.fragment.homepage.activity.PaymentActivity;
import com.zll.wuye.fragment.mypage.myreplay.Myreplay;
import com.zll.wuye.fragment.mypage.viewholder.MyReplayViewHolder;
import com.zll.wuye.http.HttpOkGo;

import java.io.DataInput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/21 15:30
 */
public class MyReplayAdapter extends RecyclerView.Adapter<MyReplayViewHolder> {
    private final ArrayList<MyZiXuBean.BodyBean> list;
    private final Context context;
    private final String token;
    private final sx ssx;

    public MyReplayAdapter(ArrayList<MyZiXuBean.BodyBean> list, Context context, String token,sx sx) {
        this.list = list;
        this.context = context;
        this.token=token;
        this.ssx = sx;
    }

    @Override
    public MyReplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myreplay_recycle, null);
        MyReplayViewHolder holder = new MyReplayViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyReplayViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getLawyer().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(holder.touxiang);
        holder.name.setText("律师姓名:"+list.get(position).getLawyer().getName());
        holder.photo.setText("律师电话:"+list.get(position).getLawyer().getTel());
        String data = data(list.get(position).getCreatTm() + "");
        holder.time.setText(data);
        final int payStatus = list.get(position).getPayStatus();
        final int orderStatus = list.get(position).getOrderStatus();

        if(payStatus==0){
            holder.queren.setText("未支付");
            holder.queren.setEnabled(true);
        }else if (payStatus == 1&&orderStatus == 0){
            holder.queren.setText("确认完成");
            holder.queren.setEnabled(true);
        }else if (orderStatus == 1){
            holder.queren.setText("咨询已完成");
            holder.queren.setEnabled(false);
        }

        holder.queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(payStatus==0){
                    Intent intent = new Intent(context,PaymentActivity.class);
                    intent.putExtra("token",token);
                    intent.putExtra("indent",list.get(position).getOrderNo());
                    intent.putExtra("leixing",list.get(position).getTitle());
                    intent.putExtra("price",list.get(position).getTotalPrice()+"");
                    context.startActivity(intent);
                }else if (payStatus == 1&&orderStatus == 0){
                    dialog(list.get(position).getOrderNo());
                }

            }
        });
    }

    private void dialog(final String orderNo) {
        final AlertDialog alert = new AlertDialog.Builder(context).create();
        alert.setMessage("您是否确认电话咨询已完成");
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String url = "https://wuye.kylinlaw.com/order/user/finish?orderNo="+orderNo+"&token="+token;
                HttpOkGo.okgoget(url, WanchengBean.class, new HttpOkGo.okget<WanchengBean>() {
                    @Override
                    public void shuju(ArrayList<WanchengBean> list) {
                        alert.dismiss();
                        ssx.shuxin();
                    }
                });
            }
        });

        alert.setButton2("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.dismiss();
            }
        });
        alert.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static String data(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }

    public interface sx{
        void shuxin();
    }
}
