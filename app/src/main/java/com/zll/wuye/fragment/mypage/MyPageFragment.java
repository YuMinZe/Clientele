package com.zll.wuye.fragment.mypage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.base.BaseFragment;
import com.zll.wuye.bean.BasicMessageBean;
import com.zll.wuye.fragment.mypage.myreplay.MCuiShou;
import com.zll.wuye.fragment.mypage.myreplay.MyGuanZhu;
import com.zll.wuye.fragment.mypage.myreplay.MyVideo;
import com.zll.wuye.fragment.mypage.myreplay.Mylvshihan;
import com.zll.wuye.fragment.mypage.myreplay.Myorder;
import com.zll.wuye.fragment.mypage.RegisterLogin.BasicMessage;
import com.zll.wuye.fragment.mypage.RegisterLogin.Register;
import com.zll.wuye.fragment.mypage.myreplay.MyWeiTuo;
import com.zll.wuye.fragment.mypage.myreplay.Myreplay;
import com.zll.wuye.fragment.mypage.myreplay.Mysubscribe;
import com.zll.wuye.fragment.mypage.myreplay.SettingUp;
import com.zll.wuye.http.Panduan;
import com.zll.wuye.local.Util;

import okhttp3.Call;

/**
 * 1. 我的页面
 * 2. @author $Yuminze
 * 3. @date 2017/5/23 14:44
 */
public class MyPageFragment extends BaseFragment {

    private View mView;
    private LinearLayout mLinearLayout;
    private TextView mWode_name;
    private TextView mWode_xinxi;
    private String name;
    private String token;
    private SharedPreferences tokensp;
    private LinearLayout wodezixun;
    private LinearLayout wodedingdan;
    private ImageView touxiang;
    private LinearLayout shipin;
    private LinearLayout wodeweituo;
    private LinearLayout wodeyuyue;
    private LinearLayout wodecuishou;
    private LinearLayout guanzhu;
    private LinearLayout lvshihan;
    private BasicMessageBean bean;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.mypagefragment, null);
        return mView;
    }

    @Override
    public void initdata() {
        boolean b = Panduan.isNetworkConnected(getActivity());
        if(!b){
            Toast.makeText(getActivity(),"请检查网络",Toast.LENGTH_SHORT).show();
        }
        tokensp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        mWode_name = (TextView) mView.findViewById(R.id.wode_name);
        mWode_xinxi = (TextView) mView.findViewById(R.id.wode_xinxi);
        touxiang = (ImageView) mView.findViewById(R.id.wode_touxiang);
        wodedingdan = (LinearLayout) mView.findViewById(R.id.wode_dingdan);
        wodeweituo = (LinearLayout) mView.findViewById(R.id.wode_weituo);
        wodezixun = (LinearLayout) mView.findViewById(R.id.wode_zixun);
        wodeyuyue = (LinearLayout) mView.findViewById(R.id.wode_yuyue);
        wodecuishou = (LinearLayout) mView.findViewById(R.id.wode_cuishou);
        guanzhu = (LinearLayout) mView.findViewById(R.id.wode_guanzhu);
        shipin = (LinearLayout) mView.findViewById(R.id.wode_shipin);
        lvshihan = (LinearLayout) mView.findViewById(R.id.wode_lvshihan);

        token =tokensp.getString("token",null);
        if(token==null || token.length()<1){
            mWode_name.setText( "登录/注册");
            mWode_xinxi.setText("");
        }else{
            dedaomessage();
        }
        mLinearLayout = (LinearLayout) mView.findViewById(R.id.wode_denglu);
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token == null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), BasicMessage.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
            }
        });

        wodezixun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null || token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(),Myreplay.class);
                    startActivity(intent);
                }

            }
        });
        wodedingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), Myorder.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
            }
        });

        wodeyuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), Mysubscribe.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
            }
        });

        LinearLayout wodeshezhi = (LinearLayout) mView.findViewById(R.id.wode_shezhi);
        wodeshezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SettingUp.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });

        wodeweituo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), MyWeiTuo.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
            }
        });
        wodecuishou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), MCuiShou.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
            }
        });

        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), MyGuanZhu.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
            }
        });

        lvshihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), Mylvshihan.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
            }
        });
        shipin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Intent intent = new Intent(getActivity(),Register.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), MyVideo.class);
                    intent.putExtra("token",token);

                    startActivity(intent);
                }
            }
        });

    }

    public void dedaomessage(){
        wodedingdan.setEnabled(false);
        wodeweituo.setEnabled(false);
        wodezixun.setEnabled(false);
        wodeyuyue.setEnabled(false);
        wodecuishou.setEnabled(false);
        guanzhu.setEnabled(false);
        shipin.setEnabled(false);
        lvshihan.setEnabled(false);
            OkGo.get("https://wuye.kylinlaw.com/user/show?token=" + token)//
                    .tag(this)//
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, okhttp3.Response response) {
                            //上传成功
                            Gson gson = new Gson();
                            bean = gson.fromJson(s, BasicMessageBean.class);
                            String ncknm = bean.getBody().getRname();
                            mWode_name.setText(ncknm + "");
                            mWode_xinxi.setText("个人信息");
                            if(bean.getBody().getHeadUrl().length()>1){
                                Glide.with(getActivity()).load(bean.getBody().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(getActivity(), 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(touxiang);
                            }
                            wodedingdan.setEnabled(true);
                            wodeweituo.setEnabled(true);
                            wodezixun.setEnabled(true);
                            wodeyuyue.setEnabled(true);
                            wodecuishou.setEnabled(true);
                            guanzhu.setEnabled(true);
                            shipin.setEnabled(true);
                            lvshihan.setEnabled(true);
                        }

                        @Override
                        public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                        }
                    });

    }

    @Override
    public void onResume() {
        super.onResume();
        if(token==null || token.length()<1){
            mWode_name.setText( "登录/注册");
            mWode_xinxi.setText("");
        }else{
            dedaomessage();
        }
    }
}
