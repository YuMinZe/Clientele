package com.zll.wuye.fragment.mypage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zll.wuye.R;
import com.zll.wuye.bean.MylvshihanBean;
import com.zll.wuye.fragment.homepage.activity.PaymentActivity;
import com.zll.wuye.fragment.mypage.myreplay.Mylvshihan;
import com.zll.wuye.fragment.mypage.viewholder.MyGuanzhuViewHolder;
import com.zll.wuye.fragment.mypage.viewholder.MylvshihanViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 13:44
 */
public class MylvshihanAdapter extends RecyclerView.Adapter<MylvshihanViewHolder> {

    private final Context context;
    private final List<MylvshihanBean.BodyBean> body;
    private final String token;

    public MylvshihanAdapter(Context context, List<MylvshihanBean.BodyBean> body, String token) {
        this.context = context;
        this.body = body;
        this.token = token;
    }

    @Override
    public MylvshihanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wode_lvshihan_recycle, null);
        MylvshihanViewHolder mylvshihanViewHolder = new MylvshihanViewHolder(inflate);
        return mylvshihanViewHolder;
    }

    @Override
    public void onBindViewHolder(MylvshihanViewHolder holder, final int position) {
        final int payStatus = body.get(position).getPayStatus();
        if(payStatus==0){
            holder.price.setText(body.get(position).getTotalPrice()+"元(未付款)");
        }else if(payStatus==1){
            holder.price.setText(body.get(position).getTotalPrice()+"元(已付款)");
        }
        holder.name.setText(body.get(position).getOrderNo());
        holder.message.setText("\t\t\t\t\t\t\t\t\t"+body.get(position).getCntn());
        String time = getStrTime(body.get(position).getCreatTm() + "");
        holder.time.setText(time);

        holder.mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(payStatus==0){
                    Intent intent = new Intent(context,PaymentActivity.class);
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
