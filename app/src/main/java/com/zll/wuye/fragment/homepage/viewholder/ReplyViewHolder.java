package com.zll.wuye.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.R;
import com.zll.wuye.fragment.homepage.TextView.LeanTextView;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/27 10:04
 */
public class ReplyViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView timer;
    public final TextView message;
    public final TextView caina;
    public final TextView zhaota;
    public final TextView tv;

    public ReplyViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.shouye_zixunhuifu_touxiang);
        name = (TextView) itemView.findViewById(R.id.shouye_zixunhuifu_name);
        timer = (TextView) itemView.findViewById(R.id.shouye_zixunhuifu_timer);
        message = (TextView) itemView.findViewById(R.id.shouye_zixunhuifu_message);
        caina = (TextView) itemView.findViewById(R.id.shouye_zixunhuifu_caina);
        zhaota = (TextView) itemView.findViewById(R.id.shouye_zixunhuifu_zhaota);
        tv = (TextView) itemView.findViewById(R.id.zixun_yicaina);
    }
}
