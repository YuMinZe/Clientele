package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zll.wuye.R;
import com.zll.wuye.bean.CourseBean;
import com.zll.wuye.fragment.homepage.activity.CourseXQActivity;
import com.zll.wuye.fragment.homepage.activity.MyVideoXQ;
import com.zll.wuye.fragment.homepage.viewholder.CourseViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 11:02
 */
public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {
    private final Context context;
    private final ArrayList<CourseBean.BodyBean> list;
    private final String token;

    public CourseAdapter(Context context, ArrayList<CourseBean.BodyBean> list, String token) {
        this.context = context;
        this.list = list;
        this.token=token;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.course_nimage, null);
        CourseViewHolder holder = new CourseViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.jianjie.setText(list.get(position).getIntro());
        String time = getStrTime(list.get(position).getCreatTm() + "");
        holder.time.setText(time+"");
       ;
//       if(list.get(position).getImgUrl().length()>0){
//            Glide.with(context).load(list.get(position).getImgUrl()).into(holder.image);
//       }
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyVideoXQ.class);
                intent.putExtra("name","课程详情");
                intent.putExtra("url","http://wuye.kylinlaw.com/artcl/show.html?id=" + list.get(position).getId() + "&token=" + token);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}
