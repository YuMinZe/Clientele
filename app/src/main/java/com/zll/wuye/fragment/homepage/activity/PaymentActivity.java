package com.zll.wuye.fragment.homepage.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tencent.mm.sdk.constants.Build;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.PaymentBean;
import com.zll.wuye.bean.WeixinPayBean;
import com.zll.wuye.fragment.homepage.PaymentSuccess;
import com.zll.wuye.fragment.homepage.payment.zhifubao.PayResult;
import com.zll.wuye.http.HttpOkGo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Response;

public class PaymentActivity extends AutoLayoutActivity {

    private String token;
    private String indent;
    private String leixing;
    private ImageView zhifuyimian_guanbi;
    private TextView zhifuyimian_name;
    private TextView zhifuyimian_price;
    private ImageView zhifuyimian_zhibubao;
    private ImageView zhifuyimian_weixin;
    private Button zhifuyimian_queren;
    private String price;
    private int num = 0;
    private LinearLayout zhifubaoll;
    private LinearLayout weixinll;
    private IWXAPI mIwxapi;
    private WeixinPayBean.BodyBean mBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initView();

        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        indent = intent.getStringExtra("indent");
        leixing = intent.getStringExtra("leixing");
        price = intent.getStringExtra("price");

        initdata();
    }

    private void initdata() {


        zhifuyimian_guanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        zhifuyimian_name.setText(leixing);
        zhifuyimian_price.setText("￥"+price+"元");

        zhifubaoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhifuyimian_zhibubao.setImageResource(R.mipmap.xuanzhongyuan);
                zhifuyimian_weixin.setImageResource(R.mipmap.kongyuan);
                num=1;
            }
        });
        weixinll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhifuyimian_weixin.setImageResource(R.mipmap.xuanzhongyuan);
                zhifuyimian_zhibubao.setImageResource(R.mipmap.kongyuan);
                num=2;
            }
        });

        zhifuyimian_queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num==0){
                    Toast.makeText(PaymentActivity.this,"请选择支付方式", Toast.LENGTH_SHORT).show();
                }else if(num==1){
                    //支付宝支付
                    zhifubaojiekou();

                }else if(num==2){
                    mIwxapi = WXAPIFactory.createWXAPI(PaymentActivity.this,null);
                    mIwxapi.registerApp("wx221bc5c1e6f8865a");
                    //微信支付
                    boolean isPaySupported = mIwxapi.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
                    if(isPaySupported){
                        zhifuyimian_queren.setEnabled(false);
                        weixinpay();
                        Toast.makeText(PaymentActivity.this,"获取订单中...",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(PaymentActivity.this,"请先安装微信",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void weixinpay() {
        String url = "https://wuye.kylinlaw.com/weixin/pay?orderNo="+indent+"&token="+token;
        HttpOkGo.okgoget(url, WeixinPayBean.class, new HttpOkGo.okget<WeixinPayBean>() {
            @Override
            public void shuju(ArrayList<WeixinPayBean> list) {
                mBody = list.get(0).getBody();
                PayReq payReq = new PayReq();
                payReq.appId = mBody.getAppid();
                payReq.sign = mBody.getSign();
                payReq.partnerId = mBody.getPartnerid();
                payReq.prepayId = mBody.getPrepayid();
                payReq.packageValue = mBody.getPackageX();
                payReq.nonceStr = mBody.getNoncestr();
                payReq.timeStamp = mBody.getTimestamp();
                mIwxapi.sendReq(payReq);
                zhifuyimian_queren.setEnabled(true);
            }
        });
    }



    private void initView() {
        zhifuyimian_guanbi = (ImageView) findViewById(R.id.zhifuyimian_guanbi);
        zhifuyimian_name = (TextView) findViewById(R.id.zhifuyimian_name);
        zhifuyimian_price = (TextView) findViewById(R.id.zhifuyimian_price);
        zhifuyimian_zhibubao = (ImageView) findViewById(R.id.zhifuyimian_zhibubao);
        zhifuyimian_weixin = (ImageView) findViewById(R.id.zhifuyimian_weixin);
        zhifuyimian_queren = (Button) findViewById(R.id.zhifuyimian_queren);
        zhifubaoll = (LinearLayout) findViewById(R.id.zhifuyimian_zhifubaoll);
        weixinll = (LinearLayout) findViewById(R.id.zhifuyimian_weixinll);
    }

    public void zhifubaojiekou(){
        OkGo.get("https://wuye.kylinlaw.com/alipay/pay?orderNo="+indent+"&token="+token)
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        PaymentBean paymentBean = gson.fromJson(s, PaymentBean.class);
                        String gongyao = paymentBean.getBody();
                        aplipay(gongyao);

                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    private void aplipay(final String payinfo){
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(PaymentActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payinfo, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private static final int SDK_PAY_FLAG = 1;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(PaymentActivity.this, "支付成功", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(PaymentActivity.this, PaymentSuccess.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(PaymentActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(PaymentActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }


    };



    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    private String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }
}
