package com.zll.wuye.fragment.homepage.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.HetongLeixing;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class MianfeiZixun extends AutoLayoutActivity implements View.OnClickListener {

    private EditText shouye_mianfeizixun_wenti;

    private Button shouye_mianfeizixun_fabu;
    private AutoLinearLayout mLl;
    private PopupWindow popwnd;
    private String token;
    private String trim;
    private int mm=1;
    private int nn=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mianfei_zixun);
        initView();
        initview();
        initdata();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
    }

    private void initdata() {

    }

    private void initview() {
        ImageView imageView = (ImageView) findViewById(R.id.shouye_mianfei_zuo);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        shouye_mianfeizixun_wenti = (EditText) findViewById(R.id.shouye_mianfeizixun_wenti);
        shouye_mianfeizixun_fabu = (Button) findViewById(R.id.shouye_mianfeizixun_fabu);

        mLl = (AutoLinearLayout) findViewById(R.id.popwindeo_ll);

        shouye_mianfeizixun_fabu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouye_mianfeizixun_fabu:
                String trim = shouye_mianfeizixun_wenti.getText().toString().trim();
                if(trim.length()>0){
                    fabushuju(trim);
                    shouye_mianfeizixun_fabu.setEnabled(false);
                }else{
                    Toast.makeText(MianfeiZixun.this,"请输入您想咨询的问题",Toast.LENGTH_SHORT).show();
                }

               break;
        }
    }
    public void fabushuju(String quest){
        HashMap<String, Object> params = new HashMap<>();
        params.put("quest", quest);
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("https://wuye.kylinlaw.com/ask/create?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        shouye_mianfeizixun_fabu.setEnabled(true);
                        Toast.makeText(MianfeiZixun.this,"发布成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }
}
