package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 11:12
 */
public class MyGuanzhuViewHolder extends RecyclerView.ViewHolder {

    public final ImageView touxiang;
    public final TextView name;
    public final TextView jingyan;
    public final TextView diyu;
    public final TextView techang;
    public final TextView danwei;
    public final TextView guanzhu;

    public MyGuanzhuViewHolder(View itemView) {
        super(itemView);
        touxiang = (ImageView) itemView.findViewById(R.id.wode_guanzhu_img);
        name = (TextView) itemView.findViewById(R.id.wode_guanzhu_name);
        jingyan = (TextView) itemView.findViewById(R.id.wode_guanzhu_jingyan);
        diyu = (TextView) itemView.findViewById(R.id.wode_guanzhu_diyu);
        techang = (TextView) itemView.findViewById(R.id.wode_guanzhu_techang);
        danwei = (TextView) itemView.findViewById(R.id.wode_guanzhu_danwei);
        guanzhu = (TextView) itemView.findViewById(R.id.wode_guanzhu_guanzhu);


    }
}
