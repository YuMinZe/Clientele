package com.zll.wuye.fragment.mypage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zll.wuye.R;
import com.zll.wuye.bean.Dingdan;
import com.zll.wuye.fragment.homepage.activity.PaymentActivity;
import com.zll.wuye.fragment.mypage.RegisterLogin.EvaluateActivity;
import com.zll.wuye.fragment.mypage.viewholder.DingdanViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 10:18
 */
public class DingdanAdapter extends RecyclerView.Adapter<DingdanViewHolder> {
    private final List<Dingdan.BodyBean> body;
    private final Context context;
    private final String token;

    public DingdanAdapter(List<Dingdan.BodyBean> body, Context context, String token) {
        this.body = body;
        this.context = context;
        this.token = token;
    }

    @Override
    public DingdanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wode_dingdan, null);
        DingdanViewHolder dingdan = new DingdanViewHolder(inflate);
        return dingdan;
    }

    @Override
    public void onBindViewHolder(DingdanViewHolder holder, final int position) {

        holder.jine.setText(body.get(position).getTotalPrice()+"元");
        holder.bianhao.setText(body.get(position).getOrderNo()+"");
        if(body.get(position).getTitle().equals("案件委托第二次付款")){
            holder.neirong.setText("案件委托费用");
        }else{
            holder.neirong.setText(body.get(position).getTitle()+"");
        }

        if(body.get(position).getPayWay()==1){
            holder.fangshi.setText("支付宝");
        }else if(body.get(position).getPayWay()==2){
            holder.fangshi.setText("微信");
        }else{
            holder.fangshi.setText("--");
        }

        if(body.get(position).getPayStatus()==1){
            holder.zhuangtai.setText("已交易");
            holder.pingjia.setText("立即评价");
            if(body.get(position).getType().equals("mentLawyer")||body.get(position).getType().equals("askLawyer")){
                if(body.get(position).getOrderStatus()==1&&body.get(position).getIsComment()==0){
                    if(body.get(position).getTitle().equals("物业催收")){
                        holder.pingjia.setVisibility(View.GONE);
                    }else{
                        holder.pingjia.setVisibility(View.VISIBLE);
                    }
                }else{
                    holder.pingjia.setVisibility(View.GONE);
                }
            }else{
                holder.pingjia.setVisibility(View.GONE);
            }
        }else if(body.get(position).getPayStatus()==0){
            holder.zhuangtai.setText("未交易");
            holder.pingjia.setText("立即支付");
        }
        String time = getStrTime(body.get(position).getCreatTm() + "");
        holder.timer.setText(time);

        if(body.get(position).getTitle().equals("物业催收")){
            holder.pingjia.setVisibility(View.GONE);
        }

        holder.pingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(body.get(position).getPayStatus()==1){
                    Intent intent = new Intent(context, EvaluateActivity.class);
                    intent.putExtra("token",token);
                    intent.putExtra("indent",body.get(position).getOrderNo());
                    context.startActivity(intent);
                }else if(body.get(position).getPayStatus()==0) {
                    Intent intent = new Intent(context, PaymentActivity.class);
                    intent.putExtra("token",token);
                    intent.putExtra("indent",body.get(position).getOrderNo());
                    intent.putExtra("leixing",body.get(position).getTitle());
                    intent.putExtra("price",body.get(position).getTotalPrice()+"");
                    context.startActivity(intent);
                }
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
