package com.zll.wuye.fragment.information;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.base.BaseFragment;
import com.zll.wuye.fragment.information.Jpush.ExampleUtil;
import com.zll.wuye.fragment.information.Jpush.LocalBroadcastManager;
import com.zll.wuye.fragment.information.sqlite.bean.MessBean;
import com.zll.wuye.fragment.information.sqlite.bean.NewListBean;

import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 14:44
 */
public class InfformaTionFragment extends BaseFragment {
    public static boolean isForeground = false;
    private View mView;
    private RecyclerView mRecycler;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.infformationfragment, null);
        return mView;

    }

    @Override
    public void initdata() {
        registerMessageReceiver();  // used for receive msg
        init();

        mRecycler = (RecyclerView) mView.findViewById(R.id.infor_recycle);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setStackFromEnd(true);
        manager.setReverseLayout(true);
        mRecycler.setLayoutManager(manager);
        NewListBean listBean = new NewListBean(getActivity());
        List<MessBean> select = listBean.select();
        if(select!=null){
            mRecycler.setAdapter(new InforAdapter(getActivity(),select));
        }
    }






    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init(){
        JPushInterface.init(getActivity().getApplicationContext());
    }


    @Override
    public void onResume() {
        initdata();
        isForeground = true;
        super.onResume();
    }

    @Override
    public void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    public void onDestroy() {
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }


    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(KEY_MESSAGE);
                    String extras = intent.getStringExtra(KEY_EXTRAS);
                    StringBuilder showMsg = new StringBuilder();
                    showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                    if (!ExampleUtil.isEmpty(extras)) {
                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                    }

//                    SimpleDateFormat sDateFormat  =  new SimpleDateFormat("yyyy-MM-dd hh:mm");
//                    String time = sDateFormat.format(new java.util.Date());
//                    Gson gson = new Gson();
//                    JpushBean bean = gson.fromJson(messge, JpushBean.class);
//                    NewListBean listBean = new NewListBean(context);
//                    listBean.add(bean.getCntn(),bean.getParam().getId(),bean.getType(),time,"1");

                    initdata();
                }
            } catch (Exception e){
            }
        }
    }


}
