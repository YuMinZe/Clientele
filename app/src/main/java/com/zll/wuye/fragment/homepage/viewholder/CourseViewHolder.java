package com.zll.wuye.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 10:59
 */
public class CourseViewHolder extends RecyclerView.ViewHolder {

    public final TextView title;
    public final TextView jianjie;
    public final TextView time;
    public final ImageView image;
    public final AutoLinearLayout ll;

    public CourseViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.kecheng_recycle_title);
        jianjie = (TextView) itemView.findViewById(R.id.kecheng_recycle_jianjie);
        time = (TextView) itemView.findViewById(R.id.kecheng_recycle_time);
        image = (ImageView) itemView.findViewById(R.id.kecheng_recycle_image);
        ll = (AutoLinearLayout) itemView.findViewById(R.id.kecheng_recycle_ll);
    }
}
