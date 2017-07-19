package com.zll.wuye.fragment.mypage.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.fragment.mypage.myreplay.MyWeituoXq;
import com.zll.wuye.fragment.mypage.viewholder.WeiTuoXqViewHolder;
import com.zll.wuye.image.ImageBDInfo;
import com.zll.wuye.image.ImageInfo;
import com.zll.wuye.image.PreviewImage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 15:38
 */
public class WeiTuoXqAdapter extends RecyclerView.Adapter<WeiTuoXqViewHolder> {
    private final Context context;
    private final String[] image;
    private ArrayList<ImageInfo> data = new ArrayList<>();
    private ImageBDInfo bdInfo;

    public WeiTuoXqAdapter(String[] split, Context context) {
        this.image = split;
        this.context = context;
    }

    @Override
    public WeiTuoXqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wode_weituoxq_recycle_ziliao, null);
        WeiTuoXqViewHolder viewHolder = new WeiTuoXqViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final WeiTuoXqViewHolder holder, final int position) {
        Glide.with(context).load(image[position]).into(holder.ziliao);
        bdInfo = new ImageBDInfo();
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.width = 1280;
        imageInfo.height = 720;
            imageInfo.url=image[position];
            data.add(imageInfo);
        holder.ziliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdInfo.x = holder.ziliao.getLeft();
                bdInfo.y = holder.ziliao.getTop();
                bdInfo.width = holder.ziliao.getLayoutParams().width;
                bdInfo.height = holder.ziliao.getLayoutParams().height;
                Intent intent = new Intent(context, PreviewImage.class);
                intent.putExtra("data", (Serializable) data);
                intent.putExtra("bdinfo", bdInfo);
                intent.putExtra("index",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }


}
