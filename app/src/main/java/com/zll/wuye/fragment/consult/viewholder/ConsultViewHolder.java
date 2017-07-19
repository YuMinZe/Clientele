package com.zll.wuye.fragment.consult.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/5 12:58
 */
public class ConsultViewHolder extends RecyclerView.ViewHolder {

    public final ImageView image;
    public final TextView title;
    public final TextView message;
    public final TextView nian;
    public final TextView shi;
    public final LinearLayout ll;

    public ConsultViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.zixun_recycle_image);
        title = (TextView) itemView.findViewById(R.id.zixun_recycle_title);
        message = (TextView) itemView.findViewById(R.id.zixun_recycle_message);
        nian = (TextView) itemView.findViewById(R.id.zixun_recycle_nian);
        shi = (TextView) itemView.findViewById(R.id.zixun_recycle_shi);
        ll = (LinearLayout) itemView.findViewById(R.id.zixun_recycle_ll);
    }
}
