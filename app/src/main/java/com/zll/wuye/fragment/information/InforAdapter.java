package com.zll.wuye.fragment.information;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.fragment.information.sqlite.InforActivity;
import com.zll.wuye.fragment.information.sqlite.bean.MessBean;
import com.zll.wuye.fragment.information.sqlite.bean.NewListBean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/30 14:44
 */
public class InforAdapter extends RecyclerView.Adapter<InforViewHolder> {

    private final Context context;
    private final List<MessBean> select;

    public InforAdapter(Context context, List<MessBean> select) {
        this.context = context;
        this.select = select;
    }

    @Override
    public InforViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.information_recycle, null);
        InforViewHolder holder = new InforViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final InforViewHolder holder, final int position) {
        holder.message.setText(select.get(position).getCntn());
        holder.time.setText(select.get(position).getTime());
        if(select.get(position).getRead().equals("1")){
            holder.touxiang.showCirclePointBadge();
        }else{
            holder.touxiang.hiddenBadge();
        }

        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewListBean listBean = new NewListBean(context);
                listBean.updata(select.get(position).getTime());
                holder.touxiang.hiddenBadge();
            }
        });
    }

    @Override
    public int getItemCount() {
        return select.size();
    }
}
