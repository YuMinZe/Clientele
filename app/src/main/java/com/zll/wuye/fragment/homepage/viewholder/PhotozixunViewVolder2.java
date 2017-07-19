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
 * 3. @date 2017/5/31 16:55
 */
public class PhotozixunViewVolder2 extends RecyclerView.ViewHolder {

    public final ImageView img;
    public final TextView name;
    public final TextView jingyan;
    public final TextView diyu;
    public final TextView techang;
    public final TextView danwei;
    public final LinearLayout xiangqing;

    public PhotozixunViewVolder2(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.home_dianhuazixun_img);
        name = (TextView) itemView.findViewById(R.id.home_dianhuazixun_name);
        jingyan = (TextView) itemView.findViewById(R.id.home_dianhuazixun_jingyan);
        diyu = (TextView) itemView.findViewById(R.id.home_dianhuazixun_diyu);
        techang = (TextView) itemView.findViewById(R.id.home_dianhuazixun_techang);
        danwei = (TextView) itemView.findViewById(R.id.home_dianhuazixun_danwei);
        xiangqing = (LinearLayout) itemView.findViewById(R.id.home_dianhuazixun_lvshixiangqing);
    }
}
