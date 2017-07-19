package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 13:43
 */
public class MylvshihanViewHolder extends RecyclerView.ViewHolder {

    public final TextView price;
    public final TextView name;
    public final TextView message;
    public final TextView time;
    public final LinearLayout mLl;

    public MylvshihanViewHolder(View itemView) {
        super(itemView);
        price = (TextView) itemView.findViewById(R.id.wode_lvlvshihan_price);
        name = (TextView) itemView.findViewById(R.id.wode_lvlvshihan_name);
        message = (TextView) itemView.findViewById(R.id.wode_lvlvshihan_message);
        time = (TextView) itemView.findViewById(R.id.wode_lvlvshihan_time);
        mLl = (LinearLayout) itemView.findViewById(R.id.wode_lvlvshihan_ll);
    }
}
