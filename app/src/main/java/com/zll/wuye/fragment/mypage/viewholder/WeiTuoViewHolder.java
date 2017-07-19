package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 13:29
 */
public class WeiTuoViewHolder extends RecyclerView.ViewHolder {

    public final TextView baojia;
    public final TextView name;
    public final TextView message;
    public final TextView leixing;
    public final TextView time;
    public final ImageView touxiang;
    public final LinearLayout mWeituo_item;
    public final TextView panduan;

    public WeiTuoViewHolder(View itemView) {
        super(itemView);
        panduan = (TextView) itemView.findViewById(R.id.panduan_zhuangtai);
        baojia = (TextView) itemView.findViewById(R.id.wode_weituo_baojia);
        name = (TextView) itemView.findViewById(R.id.wode_weituo_name);
        message = (TextView) itemView.findViewById(R.id.wode_weituo_message);
        leixing = (TextView) itemView.findViewById(R.id.wode_weituo_leixing);
        time = (TextView) itemView.findViewById(R.id.wode_weituo_time);
        touxiang = (ImageView) itemView.findViewById(R.id.wode_weituo_touxiang);
        mWeituo_item = (LinearLayout) itemView.findViewById(R.id.wode_weituo_item);
    }
}
