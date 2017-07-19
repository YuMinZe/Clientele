package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 15:38
 */
public class WeiTuoXqViewHolder extends RecyclerView.ViewHolder {

    public final ImageView ziliao;

    public WeiTuoXqViewHolder(View itemView) {
        super(itemView);
        ziliao = (ImageView) itemView.findViewById(R.id.wode_weituoxq_ziliao);
    }
}
