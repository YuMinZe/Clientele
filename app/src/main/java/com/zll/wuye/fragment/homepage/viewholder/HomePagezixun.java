package com.zll.wuye.fragment.homepage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 在线咨询
 * 2. @author $Yuminze
 * 3. @date 2017/5/26 15:39
 */
public class HomePagezixun  extends RecyclerView.ViewHolder{

    public final LinearLayout ll;
    public final ImageView touxiang;
    public final TextView name;
    public final TextView timer;
    public final TextView message;
    public final TextView huida;

    public HomePagezixun(View itemView) {
        super(itemView);
        ll = (LinearLayout) itemView.findViewById(R.id.shouye_zaixianzixun_zong);
        touxiang = (ImageView) itemView.findViewById(R.id.shouye_zaixianzixun_touxiang);
        name = (TextView) itemView.findViewById(R.id.shouye_zaixianzixun_name);
        timer = (TextView) itemView.findViewById(R.id.shouye_zaixianzixun_time);
        message = (TextView) itemView.findViewById(R.id.shouye_zaixianzixun_message);
        huida = (TextView) itemView.findViewById(R.id.shouye_zaixianzixun_huida);
    }
}
