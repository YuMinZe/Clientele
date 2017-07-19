package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 14:33
 */
public class MyCuishouViewHolder extends RecyclerView.ViewHolder {

    public final TextView shenhe;
    public final TextView message;
    public final TextView time;

    public MyCuishouViewHolder(View itemView) {
        super(itemView);
        shenhe = (TextView) itemView.findViewById(R.id.wode_cuishou_shenhe);
        message = (TextView) itemView.findViewById(R.id.wode_cuishou_message);
        time = (TextView) itemView.findViewById(R.id.wode_cuishou_time);
    }
}
