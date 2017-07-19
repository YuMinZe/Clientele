package com.zll.wuye.fragment.mypage.myreplay;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zll.wuye.R;


public class RegardMy extends AppCompatActivity {

    private ImageView guanyuwomen_zuo;
    private TextView guanyuwomen_banben;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regard_my);
        initView();
        try {
            initdata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initdata() throws Exception {
        guanyuwomen_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String name = getVersionName();
        guanyuwomen_banben.setText("-"+name+"-");
    }


    private String getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }

    private void initView() {
        guanyuwomen_zuo = (ImageView) findViewById(R.id.guanyuwomen_zuo);
        guanyuwomen_banben = (TextView) findViewById(R.id.guanyuwomen_banben);
    }
}
