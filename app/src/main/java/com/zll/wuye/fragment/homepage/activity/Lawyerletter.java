package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.KeFuBean;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;

//发律师函
public class Lawyerletter extends AutoLayoutActivity {

    private ImageView shouye_lvshihan_zuo;
    private Button lvshihan_zixunkefu;
    private Button lvshihan_tianxiexinxin;
    private String token;
    private KeFuBean.BodyBean body;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyerletter);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        initView();
        initdata();
    }

    private void initdata() {
        kefu3();
        shouye_lvshihan_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lvshihan_tianxiexinxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null){
                    Toast.makeText(Lawyerletter.this,"请先登录",Toast.LENGTH_SHORT).show();
                }else {
                    kefu();
                }
            }
        });
        lvshihan_zixunkefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Alot().dadianhua(Lawyerletter.this);
            }
        });
    }

    private void initView() {
        shouye_lvshihan_zuo = (ImageView) findViewById(R.id.shouye_lvshihan_zuo);

        lvshihan_zixunkefu = (Button) findViewById(R.id.lvshihan_zixunkefu);
        lvshihan_tianxiexinxin = (Button) findViewById(R.id.lvshihan_tianxiexinxin);
        price = (TextView) findViewById(R.id.lvshihan_price);

    }
    public void kefu(){
        String url = "https://wuye.kylinlaw.com/config";
        HttpOkGo.okgoget(url, KeFuBean.class, new HttpOkGo.okget<KeFuBean>() {
            @Override
            public void shuju(ArrayList<KeFuBean> list) {
                body = list.get(0).getBody();
                Intent intent = new Intent(Lawyerletter.this, Writelawyer.class);
                intent.putExtra("token",token);
                intent.putExtra("price",body.getLetterPrice()+"");
                startActivity(intent);
            }
        });
    }

    public void kefu3(){
        String url = "https://wuye.kylinlaw.com/config";
        HttpOkGo.okgoget(url, KeFuBean.class, new HttpOkGo.okget<KeFuBean>() {
            @Override
            public void shuju(ArrayList<KeFuBean> list) {
                KeFuBean.BodyBean body = list.get(0).getBody();
                price.setText(body.getCasePrice()+"");
            }
        });
    }
}
