package com.zll.wuye.fragment.homepage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zll.wuye.R;
import com.zll.wuye.bean.ProvinceBean;
import com.zll.wuye.bean.RegionBean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 10:40
 */
public class Provincelv2Adapter extends BaseAdapter {
    private final Context context;
    private final List<RegionBean.BodyBean> body;
    private final int num;
    private int mData;

    public Provincelv2Adapter(Context context, List<RegionBean.BodyBean> body, int num) {
        this.context = context;
        this.body = body;
        this.num = num;
    }

    @Override
    public int getCount() {
        return body.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = View.inflate(context, R.layout.provincelvtest, null);
        TextView shengfen = (TextView) inflate.findViewById(R.id.diqu_shengfen_text);
        shengfen.setText(body.get(position).getName());
        if(mData==position){
            shengfen.setTextColor(context.getResources().getColor(R.color.text_color));
        }else{
            shengfen.setTextColor(context.getResources().getColor(R.color.text_color2));
        }
        return inflate;
    }

    public void setdata(int data) {
        this.mData = data;
    }
}
