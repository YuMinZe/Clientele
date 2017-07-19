package com.zll.wuye.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 15:09
 */
public class VideoViewHolder extends RecyclerView.ViewHolder {

    public final ImageView image;
    public final TextView title;
    public final TextView jianjie;
    public final TextView price;
    public final TextView time;
    public final LinearLayout ll;

    public VideoViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.video_recycle_image);
        title = (TextView) itemView.findViewById(R.id.video_recycle_title);
        jianjie = (TextView) itemView.findViewById(R.id.video_recycle_jianjie);
        price = (TextView) itemView.findViewById(R.id.video_recycle_price);
        time = (TextView) itemView.findViewById(R.id.video_recycle_time);
        ll = (LinearLayout) itemView.findViewById(R.id.video_recycle_ll);
    }
}
