package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 10:17
 */
public class DingdanViewHolder extends RecyclerView.ViewHolder {

    public final TextView jine;
    public final Button pingjia;
    public final TextView bianhao;
    public final TextView neirong;
    public final TextView fangshi;
    public final TextView zhuangtai;
    public final TextView timer;

    public DingdanViewHolder(View itemView) {
        super(itemView);
        jine = (TextView) itemView.findViewById(R.id.wode_dingdan_jine);
        pingjia = (Button) itemView.findViewById(R.id.wode_dingdan_lijipingjia);
        bianhao = (TextView) itemView.findViewById(R.id.wode_dingdan_bianhao);
        neirong = (TextView) itemView.findViewById(R.id.wode_dingdan_neirong);
        fangshi = (TextView) itemView.findViewById(R.id.wode_dingdan_fangshi);
        zhuangtai = (TextView) itemView.findViewById(R.id.wode_dingdan_zhuangtai);
        timer = (TextView) itemView.findViewById(R.id.wode_dingdan_timer);


    }
}
