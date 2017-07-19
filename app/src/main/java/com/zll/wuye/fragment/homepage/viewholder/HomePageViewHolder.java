package com.zll.wuye.fragment.homepage.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.zll.wuye.R;
import com.zll.wuye.fragment.homepage.MyImageloder;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 16:01
 */
public class HomePageViewHolder extends RecyclerView.ViewHolder {

    public final Banner mBanner;
    private Context mData;
    List<Integer> list = new ArrayList<>();
    public HomePageViewHolder(View itemView) {
        super(itemView);
        mBanner = (Banner) itemView.findViewById(R.id.zhu_banner);
        initview();
    }

    private void initview() {
        if(list!=null){
            list.clear();
        }
        list.add(R.drawable.a);
        list.add(R.drawable.b);

    }


    public void setdata(Context data) {
        mData = data;
//banner加载图片
        mBanner.setImages(list)
                .setImageLoader(new MyImageloder())
                //banner的动画效果
                .setBannerAnimation(Transformer.Accordion)
                .start();
    }
}
