package com.zll.wuye.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.bean.BanBen;
import com.zll.wuye.fragment.consult.ConsultFragment;
import com.zll.wuye.fragment.homepage.HomePageFragment;
import com.zll.wuye.fragment.information.InfformaTionFragment;
import com.zll.wuye.fragment.information.dian.BGABadgeImageView;
import com.zll.wuye.fragment.information.sqlite.bean.MessBean;
import com.zll.wuye.fragment.information.sqlite.bean.NewListBean;
import com.zll.wuye.fragment.mypage.MyPageFragment;
import com.zll.wuye.http.HttpOkGo;
import com.zll.wuye.http.Panduan;
import com.zll.wuye.versions.DownLoadService;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AutoLayoutActivity implements View.OnClickListener {

    private AutoFrameLayout zhu_fragment;
    private ImageView shouye;
    private ImageView zixun;
    private BGABadgeImageView xiaoxi;
    private ImageView wode;
    private RadioGroup radiogroup;
    private FragmentManager mFragmentManager;
    private int p=0;
    private int mm=0;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        initView();
        panduan();
        boolean b = Panduan.isNetworkConnected(MainActivity.this);
        if(!b){
            Toast.makeText(MainActivity.this,"请检查网络",Toast.LENGTH_SHORT).show();
        }else{
            huoqu();
        }
    }
    public void panduan() {
        mm=0;
        NewListBean listBean = new NewListBean(MainActivity.this);
        List<MessBean> select = listBean.select();
        for (int i = 0; i < select.size(); i++) {
            if(select.get(i).getRead().equals("1")){
                mm=1;
            }
        }
        if(mm==1){
            xiaoxi.showCirclePointBadge();
        }else{
            xiaoxi.hiddenBadge();
        }
    }

    private void initView() {
        zhu_fragment = (AutoFrameLayout) findViewById(R.id.zhu_fragment);
        shouye = (ImageView) findViewById(R.id.shouye);
        zixun = (ImageView) findViewById(R.id.zixun);
        xiaoxi = (BGABadgeImageView) findViewById(R.id.xiaoxi);
        wode = (ImageView) findViewById(R.id.wode);
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        shouye.setOnClickListener(this);
        zixun.setOnClickListener(this);
        xiaoxi.setOnClickListener(this);
        wode.setOnClickListener(this);
        HomePageFragment homePage = new HomePageFragment();
        mFragmentManager.beginTransaction().replace(R.id.zhu_fragment,homePage).commit();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shouye:
                panduan();
                HomePageFragment homePage = new HomePageFragment();
                mFragmentManager.beginTransaction().replace(R.id.zhu_fragment,homePage).commit();

                shouye.setImageResource(R.mipmap.yes_shouye);
                zixun.setImageResource(R.mipmap.no_zixun);
                xiaoxi.setImageResource(R.mipmap.no_xiaoxi);
                wode.setImageResource(R.mipmap.no_wode);
                break;

            case R.id.zixun:
                panduan();
                ConsultFragment consultFragment = new ConsultFragment();
                mFragmentManager.beginTransaction().replace(R.id.zhu_fragment,consultFragment).commit();

                shouye.setImageResource(R.mipmap.no_shouye);
                zixun.setImageResource(R.mipmap.yes_zixun);
                xiaoxi.setImageResource(R.mipmap.no_xiaoxi);
                wode.setImageResource(R.mipmap.no_wode);
                break;

            case R.id.xiaoxi:
                panduan();
                InfformaTionFragment infformaTionFragment = new InfformaTionFragment();
                mFragmentManager.beginTransaction().replace(R.id.zhu_fragment,infformaTionFragment).commit();

                shouye.setImageResource(R.mipmap.no_shouye);
                zixun.setImageResource(R.mipmap.no_zixun);
                xiaoxi.setImageResource(R.mipmap.yes_xiaoxi);
                wode.setImageResource(R.mipmap.no_wode);
                break;

            case R.id.wode:
                panduan();
                MyPageFragment myPageFragment = new MyPageFragment();
                mFragmentManager.beginTransaction().replace(R.id.zhu_fragment,myPageFragment).commit();

                shouye.setImageResource(R.mipmap.no_shouye);
                zixun.setImageResource(R.mipmap.no_zixun);
                xiaoxi.setImageResource(R.mipmap.no_xiaoxi);
                wode.setImageResource(R.mipmap.yes_wode);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(p==1){
            MyPageFragment myPageFragment =  new MyPageFragment();
            mFragmentManager.beginTransaction().replace(R.id.zhu_fragment,myPageFragment).commit();
            shouye.setImageResource(R.mipmap.no_shouye);
            zixun.setImageResource(R.mipmap.no_zixun);
            xiaoxi.setImageResource(R.mipmap.no_xiaoxi);
            wode.setImageResource(R.mipmap.yes_wode);
            p=0;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        p=1;
    }

    private void huoqu() {
        String url="https://wuye.kylinlaw.com/index/version?type=android-u";
        HttpOkGo.okgoget(url, BanBen.class, new HttpOkGo.okget<BanBen>() {
            @Override
            public void shuju(ArrayList<BanBen> list) {
                final BanBen.BodyBean body = list.get(0).getBody();
                try {
                    String name = getVersionName();
                    if(!name.equals(body.getV())){
                        dialog = new AlertDialog.Builder(MainActivity.this).create();
                        dialog.show();
                        Window window = dialog.getWindow();
                        window.setContentView(R.layout.version_update_dialog);
                        Button cancle = (Button) window.findViewById(R.id.btn_update_id_cancel);
                        Button ok = (Button) window.findViewById(R.id.btn_update_id_ok);
                        cancle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String path = body.getPath();
                                Intent intentService = new Intent(MainActivity.this, DownLoadService.class);
                                intentService.putExtra("url",path+"");
                                startService(intentService);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }

}
