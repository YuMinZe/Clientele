package com.zll.wuye.fragment.homepage.viewholder;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.bean.PhotoBean;
import com.zll.wuye.fragment.homepage.adapter.PhotozixunAdapter2;
import com.zll.wuye.http.DividerItemDecoration;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/6 15:59
 */
public class RankLvshiViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView mRecyclerView;
    private Context context;
    private String token;

    public RankLvshiViewHolder(View itemView) {
        super(itemView);
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.rank_recycle);
    }

    public void setdata(Context context) {
        this.context = context;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL_LIST));
        SharedPreferences sp = context.getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        qingqiu();
    }

    public void qingqiu(){
        OkGo.get("https://wuye.kylinlaw.com/lawyer/index/list?token="+token)
            .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = new Gson();
                        PhotoBean photoBean = gson.fromJson(s, PhotoBean.class);
                        List<PhotoBean.BodyBean> body = photoBean.getBody();
                        if(body!=null){
                            mRecyclerView.setAdapter(new PhotozixunAdapter2(body,context,token));
                        }

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        super.upProgress(currentSize, totalSize, progress, networkSpeed);
                    }
                });
    }

}
