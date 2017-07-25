package com.zll.wuye.fragment.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;

public class PaymentSuccess extends AppCompatActivity{

    private ImageView zhifuchenggong_fanhui;
    private Button zhifuchenggong_shouye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        initView();
        initdata();
    }

    private void initdata() {
        zhifuchenggong_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        zhifuchenggong_shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentSuccess.this,MainActivity.class);
                intent.putExtra("alipay","alipay");
                startActivity(intent);

            }
        });
    }

    private void initView() {
        zhifuchenggong_fanhui = (ImageView) findViewById(R.id.zhifuchenggong_fanhui);
        zhifuchenggong_shouye = (Button) findViewById(R.id.zhifuchenggong_shouye);
    }
}
