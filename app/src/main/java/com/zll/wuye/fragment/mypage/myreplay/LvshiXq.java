package com.zll.wuye.fragment.mypage.myreplay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.MyWeiTuoxqBean;
import com.zll.wuye.bean.TwoFukuanBean;
import com.zll.wuye.fragment.homepage.activity.PaymentActivity;

import okhttp3.Call;
import okhttp3.Response;

public class LvshiXq extends AppCompatActivity{

    private String token;
    private String id;
    private ImageView wode_lvshixinxi_zuo;
    private ImageView lvshixinxi_touxiang;
    private TextView wode_lvshixinxi_name;
    private TextView wode_lvshixinxi_techang;
    private TextView wode_lvshixinxi_zhiyezheng;
    private TextView wode_lvshixinxi_zhiyelvsuo;
    private TextView wode_lvshixinxi_gongzuonianxian;
    private TextView wode_lvshixinxi_suozaidi;
    private TextView wode_lvshixinxi_baojia;
    private Button wode_lvshixinxi_zhiding;
    private int mPosition;
    private TextView wode_lvshixinxi_ziwojieshao;
    private int p;
    private String id2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvshi_xq);
        initView();
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        id = intent.getStringExtra("id");
        id2 = intent.getStringExtra("id2");
        mPosition = Integer.parseInt(intent.getStringExtra("position"));
        p = Integer.parseInt(intent.getStringExtra("p"));
        jiexi();
        initdata();
    }

    private void initdata() {
        wode_lvshixinxi_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        wode_lvshixinxi_zhiding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p==0){
                    zhiding();
                }else if(p==1){
                    final AlertDialog alertDialog = new AlertDialog.Builder(LvshiXq.this).create();
                    alertDialog.setMessage(
                            "您确定您的委托完成了吗?请谨慎选择");
                    alertDialog.setButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            queding();
                        }
                    });

                    alertDialog.setButton2("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.show();

                }
            }
        });
    }

    private void queding() {
        OkGo.get("https://wuye.kylinlaw.com/case/user/finish?token=" + token + "&caseId=" + id)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });

        finish();
        Toast.makeText(LvshiXq.this,"咨询完毕",Toast.LENGTH_SHORT).show();
    }

    private void zhiding() {
        OkGo.get("https://wuye.kylinlaw.com/case/user/sure/mark?token=" + token + "&caseRecId=" + id2)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = new Gson();
                        TwoFukuanBean bean = gson.fromJson(s, TwoFukuanBean.class);
                        TwoFukuanBean.BodyBean body = bean.getBody();
                        Intent intent = new Intent(LvshiXq.this, PaymentActivity.class);
                        intent.putExtra("token",token);
                        intent.putExtra("indent",body.getOrderNo());
                        intent.putExtra("leixing",body.getTitle());
                        intent.putExtra("price",body.getTotalPrice());
                        startActivity(intent);

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });

    }

    private void jiexi() {
        OkGo.get("https://wuye.kylinlaw.com/case/user/show?token=" + token + "&caseId=" + id)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        MyWeiTuoxqBean myWeituoXq = gson.fromJson(s, MyWeiTuoxqBean.class);
                        MyWeiTuoxqBean.BodyBean body = myWeituoXq.getBody();
                        Glide.with(LvshiXq.this)
                                .load(body.getList().get(mPosition).getLawyer().getHeadUrl())
                                .bitmapTransform(new RoundedCornersTransformation(LvshiXq.this, 30, 0, RoundedCornersTransformation.CornerType.ALL))
                                .crossFade(1000)
                                .into(lvshixinxi_touxiang);
                        wode_lvshixinxi_name.setText(body.getList().get(mPosition).getLawyer().getName());
                        wode_lvshixinxi_techang.setText(body.getList().get(mPosition).getLawyer().getTypeName());
                        wode_lvshixinxi_zhiyezheng.setText(body.getList().get(mPosition).getLawyer().getLawyerNo());
                        wode_lvshixinxi_zhiyelvsuo.setText(body.getList().get(mPosition).getLawyer().getLawName());
                        wode_lvshixinxi_gongzuonianxian.setText(body.getList().get(mPosition).getLawyer().getPeriod()+"年");
                        wode_lvshixinxi_suozaidi.setText(""+body.getList().get(mPosition).getLawyer().getAddress());
                        wode_lvshixinxi_baojia.setText("服务报价:"+body.getList().get(mPosition).getPrice());
                        wode_lvshixinxi_ziwojieshao.setText(""+body.getList().get(mPosition).getCntn());
                        if(p==0){
                            wode_lvshixinxi_zhiding.setText("指定TA");
                        }else if(p==1){
                            wode_lvshixinxi_zhiding.setText("确认完成");
                        }
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initView() {
        wode_lvshixinxi_zuo = (ImageView) findViewById(R.id.wode_lvshixinxi_zuo);
        lvshixinxi_touxiang = (ImageView) findViewById(R.id.lvshixinxi_touxiang);
        wode_lvshixinxi_name = (TextView) findViewById(R.id.wode_lvshixinxi_name);
        wode_lvshixinxi_techang = (TextView) findViewById(R.id.wode_lvshixinxi_techang);
        wode_lvshixinxi_zhiyezheng = (TextView) findViewById(R.id.wode_lvshixinxi_zhiyezheng);
        wode_lvshixinxi_zhiyelvsuo = (TextView) findViewById(R.id.wode_lvshixinxi_zhiyelvsuo);
        wode_lvshixinxi_gongzuonianxian = (TextView) findViewById(R.id.wode_lvshixinxi_gongzuonianxian);
        wode_lvshixinxi_suozaidi = (TextView) findViewById(R.id.wode_lvshixinxi_suozaidi);
        wode_lvshixinxi_ziwojieshao = (TextView) findViewById(R.id.wode_lvshixinxi_ziwojieshao);
        wode_lvshixinxi_baojia = (TextView) findViewById(R.id.wode_lvshixinxi_baojia);
        wode_lvshixinxi_zhiding = (Button) findViewById(R.id.wode_lvshixinxi_zhiding);

    }
}
