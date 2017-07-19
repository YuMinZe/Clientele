package com.zll.wuye.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 16:53
 */
public class MorePjViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView time;
    public final TextView message;
    public final TextView huida;

    public MorePjViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.shouye_more_touxiang);
        name = (TextView) itemView.findViewById(R.id.shouye_more_name);
        time = (TextView) itemView.findViewById(R.id.shouye_more_time);
        message = (TextView) itemView.findViewById(R.id.shouye_more_message);
        huida = (TextView) itemView.findViewById(R.id.shouye_more_huida);

    }
}
