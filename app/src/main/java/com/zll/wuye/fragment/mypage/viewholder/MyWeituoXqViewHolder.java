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
 * 3. @date 2017/6/27 10:54
 */
public class MyWeituoXqViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView diyu;
    public final TextView techang;
    public final TextView danwei;
    public final TextView canjia;
    public final LinearLayout mLl;

    public MyWeituoXqViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.myweituo_touxiang);
        name = (TextView) itemView.findViewById(R.id.myweituo_name);
        diyu = (TextView) itemView.findViewById(R.id.myweituo_diyu);
        techang = (TextView) itemView.findViewById(R.id.myweituo_techang);
        danwei = (TextView) itemView.findViewById(R.id.myweituo_danwei);
        canjia = (TextView) itemView.findViewById(R.id.myweituo_canjia);
        mLl = (LinearLayout) itemView.findViewById(R.id.myweituo_ll);
    }
}
