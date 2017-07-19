package com.zll.wuye.fragment.information.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zll.wuye.R;
import com.zll.wuye.fragment.information.sqlite.bean.MessBean;
import com.zll.wuye.fragment.information.sqlite.bean.NewListBean;

import java.util.List;

public class InforActivity extends AppCompatActivity {

    private TextView infor_xq_message;
    private TextView infor_xq_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        initView();
        Intent intent = getIntent();
        int position = Integer.parseInt(intent.getStringExtra("id"));
        NewListBean listBean = new NewListBean(InforActivity.this);
        List<MessBean> select = listBean.select();
        MessBean bean = select.get(position);
        infor_xq_message.setText(bean.getCntn()+"");
        infor_xq_time.setText(bean.getTime()+"");
    }

    private void initView() {
        infor_xq_message = (TextView) findViewById(R.id.infor_xq_message);
        infor_xq_time = (TextView) findViewById(R.id.infor_xq_time);
    }
}
