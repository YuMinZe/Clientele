package com.zll.wuye.fragment.mypage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zll.wuye.R;
import com.zll.wuye.bean.MyCuishouBean;
import com.zll.wuye.fragment.mypage.myreplay.MCuiShou;
import com.zll.wuye.fragment.mypage.viewholder.MyCuishouViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 14:33
 */
public class MyCuishouAdapter extends RecyclerView.Adapter<MyCuishouViewHolder> {
    private final Context context;
    private final List<MyCuishouBean.BodyBean> body;

    public MyCuishouAdapter(Context context, List<MyCuishouBean.BodyBean> body) {
        this.context = context;
        this.body = body;
    }

    @Override
    public MyCuishouViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wode_cuishou_recycle, null);
        MyCuishouViewHolder holder = new MyCuishouViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyCuishouViewHolder holder, int position) {
        int i = body.get(position).getOrderStatus();
        if(i==0){
            holder.shenhe.setText("正在审核");
        }else if(i==1){
            holder.shenhe.setText("审核通过");
        }else if(i==2){
            holder.shenhe.setText("审核未通过");
        }
        holder.message.setText("\t\t\t\t\t"+body.get(position).getCntn());
        String time = getStrTime(body.get(position).getCreatTm() + "");
        holder.time.setText("时间:"+time);

    }

    @Override
    public int getItemCount() {
        return body.size();
    }

    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}
