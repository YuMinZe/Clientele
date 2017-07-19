package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 15:46
 */
public class MyYuyueViewHolder extends RecyclerView.ViewHolder {

    public final TextView price;
    public final TextView time;
    public final ImageView touxiang;
    public final TextView jingyan;
    public final TextView name;
    public final TextView diyu;
    public final TextView techang;
    public final TextView danwei;
    public final Button queren;

    public MyYuyueViewHolder(View itemView) {
        super(itemView);

        price = (TextView) itemView.findViewById(R.id.wode_yuyue_price);
        time = (TextView) itemView.findViewById(R.id.wode_yuyue_time);
        touxiang = (ImageView) itemView.findViewById(R.id.wode_yuyue_touxiang);
        jingyan = (TextView) itemView.findViewById(R.id.wode_yuyue_jingyan);
        name = (TextView) itemView.findViewById(R.id.wode_yuyue_name);
        diyu = (TextView) itemView.findViewById(R.id.wode_yuyue_diyu);
        techang = (TextView) itemView.findViewById(R.id.wode_yuyue_techang);
        danwei = (TextView) itemView.findViewById(R.id.wode_yuyue_danwei);
        queren = (Button) itemView.findViewById(R.id.wode_yuyue_queren);
    }
}
