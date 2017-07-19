package com.zll.wuye.fragment.mypage.myreplay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.fragment.mypage.RegisterLogin.Register;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

//设置
public class SettingUp extends AutoLayoutActivity {

    private static final String TAG = "Jpush";
    private ImageView fanhui;
    private String token;
    private Button tuichu;
    private SharedPreferences sp;
    private LinearLayout guanyu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_up);
        sp = getSharedPreferences("token", MODE_PRIVATE);

        Intent intent = getIntent();
        this.token = intent.getStringExtra("token");
        initview();
        initdata();

    }

    private void initdata() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null || token.length()<1){
                    Intent intent = new Intent(SettingUp.this, Register.class);
                    startActivity(intent);
                    finish();
                }else{
                    sp.edit().clear().commit();
                    finish();
                    JPushInterface.setAliasAndTags(getApplicationContext(),
                            "", null, mAliasCallback);                }
            }
        });
        guanyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingUp.this,RegardMy.class);

                startActivity(intent);
            }
        });

    }

    private void initview() {
        fanhui = (ImageView) findViewById(R.id.shouye_wodeshezhi_zuo);
        tuichu = (Button) findViewById(R.id.wode_shezhi_tuichu);
        guanyu = (LinearLayout) findViewById(R.id.wode_shezhi_guanyu);
    }

    private Handler mHandler1;
    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success极光推送别名设置成功";
                    Log.i(TAG, logs);
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.极光推送别名设置失败，60秒后重试";
                    Log.i(TAG, logs);
                    break;
                default:
                    logs = "极光推送设置失败，Failed with errorCode = " + code;
                    Log.e(TAG, logs);
                    break;
            }
        }
    };
}
