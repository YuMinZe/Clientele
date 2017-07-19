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
 * 3. @date 2017/6/21 15:30
 */
public class MyReplayViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView photo;
    public final TextView time;
    public final Button queren;

    public MyReplayViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.myreplay_touxiang);
        name = (TextView) itemView.findViewById(R.id.myreplay_name);
        photo = (TextView) itemView.findViewById(R.id.myreplay_photo);
        time = (TextView) itemView.findViewById(R.id.myreplay_time);
        queren = (Button) itemView.findViewById(R.id.myreplay_queren);
    }
}
