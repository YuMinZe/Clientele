package com.zll.wuye.fragment.information;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zhy.autolayout.AutoRelativeLayout;
import com.zll.wuye.R;
import com.zll.wuye.fragment.information.dian.BGABadgeImageView;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/30 14:43
 */
public class InforViewHolder extends RecyclerView.ViewHolder {

    public final TextView message;
    public final TextView time;
    public final AutoRelativeLayout rl;
    public final BGABadgeImageView touxiang;

    public InforViewHolder(View itemView) {
        super(itemView);
        message = (TextView) itemView.findViewById(R.id.infor_recyc_message);
        touxiang = (BGABadgeImageView) itemView.findViewById(R.id.infor_recyc_touxiang);
        time = (TextView) itemView.findViewById(R.id.infor_recyc_time);
        rl = (AutoRelativeLayout) itemView.findViewById(R.id.infor_recyc_ll);
    }
}
