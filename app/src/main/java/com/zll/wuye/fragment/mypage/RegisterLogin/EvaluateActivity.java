package com.zll.wuye.fragment.mypage.RegisterLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.fragment.mypage.myreplay.Myorder;
import com.zll.wuye.http.HttpOkGo;

import java.util.HashMap;

public class EvaluateActivity extends AppCompatActivity implements View.OnClickListener {

    private String token;
    private String indent;
    private ImageView pingjia_zuo;
    private EditText pingjia_et;
    private RadioButton pingjia_rb1;
    private RadioButton pingjia_rb2;
    private RadioButton pingjia_rb3;
    private RadioGroup pingjia_rg;
    private Button pingjia_tj;
    private int p=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        indent = intent.getStringExtra("indent");

        initdata();

    }

    private void initdata() {
        pingjia_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pingjia_tj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String neirong = pingjia_et.getText().toString().trim();
                if(neirong.equals("")||neirong.length()<1){
                    Toast.makeText(EvaluateActivity.this,"请输入评价内容",Toast.LENGTH_SHORT).show();
                }else if(p ==-1){
                    Toast.makeText(EvaluateActivity.this,"请选择评价内容",Toast.LENGTH_SHORT).show();
                }else {
                    tj(neirong);
                }
            }
        });

    }

    public void tj(String neirong){
        String url = "https://wuye.kylinlaw.com/lawyer/commt?token="+token;
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("orderNo",indent);
        map.put("score",p);
        map.put("cntn",neirong);
        HttpOkGo.okgopost(url, map, new HttpOkGo.okpost() {
            @Override
            public void fanhui(String s) {
                Toast.makeText(EvaluateActivity.this,"评价成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EvaluateActivity.this, Myorder.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        pingjia_zuo = (ImageView) findViewById(R.id.pingjia_zuo);
        pingjia_et = (EditText) findViewById(R.id.pingjia_et);
        pingjia_rb1 = (RadioButton) findViewById(R.id.pingjia_rb1);
        pingjia_rb2 = (RadioButton) findViewById(R.id.pingjia_rb2);
        pingjia_rb3 = (RadioButton) findViewById(R.id.pingjia_rb3);
        pingjia_rg = (RadioGroup) findViewById(R.id.pingjia_rg);
        pingjia_tj = (Button) findViewById(R.id.pingjia_tj);
        pingjia_rb1.setOnClickListener(this);
        pingjia_rb2.setOnClickListener(this);
        pingjia_rb3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pingjia_rb1:
                p=0;
                break;
            case R.id.pingjia_rb2:
                p=1;
                break;
            case R.id.pingjia_rb3:
                p=2;
                break;
        }
    }
}
