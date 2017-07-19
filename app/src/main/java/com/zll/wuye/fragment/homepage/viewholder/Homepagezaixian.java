package com.zll.wuye.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/25 11:06
 */
public class Homepagezaixian extends RecyclerView.ViewHolder {

    public final LinearLayout mLinearLayout;
    public final LinearLayout mAnjianweituo;
    public final LinearLayout zhaolvshi;
    public final LinearLayout falvshihan;

    public Homepagezaixian(View itemView) {
        super(itemView);
        mLinearLayout = (LinearLayout) itemView.findViewById(R.id.shouye_zaixianzixun);
        mAnjianweituo = (LinearLayout) itemView.findViewById(R.id.shouye_anjianweituo);
        zhaolvshi = (LinearLayout) itemView.findViewById(R.id.shouye_zhaolvshi);
        falvshihan = (LinearLayout) itemView.findViewById(R.id.shouye_falvshihan);
    }
}
