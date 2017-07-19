package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.fragment.homepage.activity.Anjianweituo;
import com.zll.wuye.fragment.homepage.activity.Consult;
import com.zll.wuye.fragment.homepage.activity.Lawyerletter;
import com.zll.wuye.fragment.homepage.activity.OpenClassActivity;
import com.zll.wuye.fragment.homepage.activity.Photozixun;
import com.zll.wuye.fragment.homepage.activity.Propertyfee;
import com.zll.wuye.fragment.homepage.activity.Wuyefeijieshao;
import com.zll.wuye.fragment.homepage.viewholder.HomePageViewHolder;
import com.zll.wuye.fragment.homepage.viewholder.HomePagezixun;
import com.zll.wuye.fragment.homepage.viewholder.Homepagewuyefei;
import com.zll.wuye.fragment.homepage.viewholder.Homepagezaixian;
import com.zll.wuye.fragment.homepage.viewholder.RankLvshiViewHolder;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 15:49
 */
public class HomepagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE0 = 0;
    private static final int ITEM_TYPE1 = 1;
    private static final int ITEM_TYPE2 = 2;
    private static final int ITEM_TYPE3 = 3;
    private static final int ITEM_TYPE4 = 4;
    private final Context context;
    private int type;

    public HomepagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.home_banner, parent, false);
                viewHolder = new HomePageViewHolder(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.home_zaixian, parent, false);
                viewHolder = new Homepagezaixian(view1);
                break;
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.home_wuyefei, parent, false);
                viewHolder = new Homepagewuyefei(view2);
                break;
            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.ranklvshi, parent, false);
                viewHolder = new RankLvshiViewHolder(view3);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position){
            case 0:
                HomePageViewHolder homePageViewHolder = (HomePageViewHolder) holder;
                homePageViewHolder.setdata(context);
                homePageViewHolder.mBanner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                       if(position==1){
                           Intent intent = new Intent(context, Wuyefeijieshao.class);
                           context.startActivity(intent);
                       }
                    }
                });
                break;
            case 1:
                Homepagezaixian homepagezaixian = (Homepagezaixian) holder;
                homepagezaixian.mLinearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(context, Consult.class);
                        context.startActivity(in);
                    }
                });
                homepagezaixian.mAnjianweituo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(context, Anjianweituo.class);
                        context.startActivity(in);
                    }
                });
                homepagezaixian.zhaolvshi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(context, Photozixun.class);
                        in.putExtra("name","找律师");
                        context.startActivity(in);
                    }
                });
                homepagezaixian.falvshihan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Lawyerletter.class);
                        context.startActivity(intent);
                    }
                });

                break;

            case 2:
                Homepagewuyefei homepagewuyefei = (Homepagewuyefei) holder;
                homepagewuyefei.wuyefei.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Wuyefeijieshao.class);
                        context.startActivity(intent);
                    }
                });

                homepagewuyefei.gongkaike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, OpenClassActivity.class);
                        context.startActivity(intent);
                    }
                });

                break;

            case 3:
                RankLvshiViewHolder rankLvshiViewHolder = (RankLvshiViewHolder) holder;
                rankLvshiViewHolder.setdata(context);

                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                type = ITEM_TYPE0;
                break;
            case 1:
                type = ITEM_TYPE1;
                break;

            case 2:
                type = ITEM_TYPE2;
                break;
            case 3:
                type = ITEM_TYPE3;
                break;

        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
