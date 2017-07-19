package com.zll.wuye.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/25 11:31
 */
public class Homepagewuyefei extends RecyclerView.ViewHolder {

    public final LinearLayout wuyefei;
    public final LinearLayout gongkaike;

    public Homepagewuyefei(View itemView) {
        super(itemView);
        wuyefei = (LinearLayout) itemView.findViewById(R.id.shouye_wuyemei);
        gongkaike = (LinearLayout) itemView.findViewById(R.id.gongkaike);
    }
}
