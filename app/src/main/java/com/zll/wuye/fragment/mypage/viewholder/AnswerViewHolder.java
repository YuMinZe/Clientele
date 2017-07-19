package com.zll.wuye.fragment.mypage.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.R;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/20 11:04
 */
public class AnswerViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mTouxiang;
    public final TextView mName;
    public final TextView mTime;
    public final TextView mMessage;
    public final TextView mRen;
    public final AutoLinearLayout mLl;

    public AnswerViewHolder(View itemView) {
        super(itemView);
        mTouxiang = (ImageView) itemView.findViewById(R.id.myanswer_touxiang);
        mName = (TextView) itemView.findViewById(R.id.myanswer_name);
        mTime = (TextView) itemView.findViewById(R.id.myanswer_time);
        mMessage = (TextView) itemView.findViewById(R.id.myanswer_message);
        mRen = (TextView) itemView.findViewById(R.id.myanswer_ren);
        mLl = (AutoLinearLayout) itemView.findViewById(R.id.myanswer_ll);
    }
}
