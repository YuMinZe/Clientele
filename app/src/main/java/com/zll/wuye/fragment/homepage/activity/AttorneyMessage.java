package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.application.CropCircleTransformation;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.BasicBean;
import com.zll.wuye.bean.MoreEvaluateBean;
import com.zll.wuye.fragment.homepage.adapter.MorePjAdapter;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

//律师详情
public class AttorneyMessage extends AutoLayoutActivity{

    private Long attorneyid;
    private ImageView shouye_lvshixinxi_zuo;
    private ImageView lvshixinxi_touxiang;
    private TextView lvshixinxi_name;
    private TextView lvshixinxi_techang;
    private RadioButton lvshixinxi_guanzhu;
    private RadioButton lvshixinxi_fuwu;
    private RadioButton lvshixinxi_dongtai;
    private RadioButton lvshixinxi_zan;
    private RadioGroup lvshixinxi_rg;
    private TextView lvshixinxi_zhiyezheng;
    private TextView lvshixinxi_zhiyelvsuo;
    private TextView lvshixinxi_gongzuonianxian;
    private TextView lvshixinxi_suozaidi;
    private TextView lvshixinxi_ziwojieshao;
    private TextView dianhua;
    private TextView yuyue;
    private LinearLayout dianhuall;
    private LinearLayout yuyuell;
    private SharedPreferences sp;
    private String token;
    private LinearLayout gengduo;
    private BasicBean.BodyBean body;
    private RecyclerView pingjia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attorney_message);
        sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token","");
        initView();
        Intent intent = getIntent();
        attorneyid = Long.valueOf(intent.getStringExtra("attorney"));
        message();
        initview();
        initdata();
    }

    private void initdata() {

        gengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttorneyMessage.this,MoreEvaluate.class);
                intent.putExtra("lvshiid",attorneyid+"");

                startActivity(intent);
            }
        });

        lvshixinxi_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(token==null||token.length()<1){
                    Toast.makeText(AttorneyMessage.this,"请先登录",Toast.LENGTH_SHORT).show();
                }else{
                    if(body.isIsFlw()){

                    }else {
                        guanzhu();
                        lvshixinxi_guanzhu.setText("已关注");
                    }
                }
            }
        });
        pingjia.setLayoutManager(new LinearLayoutManager(AttorneyMessage.this));

    }

    private void pingjiajiexi() {
        String url = "https://wuye.kylinlaw.com/lawyer/commt/list?lawyerId="+attorneyid+"&token="+token;
        HttpOkGo.okgoget(url, MoreEvaluateBean.class, new HttpOkGo.okget<MoreEvaluateBean>() {
            @Override
            public void shuju(ArrayList<MoreEvaluateBean> list) {
                List<MoreEvaluateBean.BodyBean> body = list.get(0).getBody();
                if(body.size()>0){
                    pingjia.setAdapter(new MorePjAdapter(AttorneyMessage.this,body));
                }
            }
        });
    }

    private void initview() {
        shouye_lvshixinxi_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void message() {
        OkGo.get("https://wuye.kylinlaw.com/lawyer/show?lawyerId=" + attorneyid+"&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        BasicBean basicBean = gson.fromJson(s, BasicBean.class);
                        body = basicBean.getBody();
                        pingjiajiexi();
                        if(body !=null){
                            Glide.with(AttorneyMessage.this).load(body.getLawyer().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(AttorneyMessage.this, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(lvshixinxi_touxiang);

                        }
                        if(body.isIsFlw()){
                            lvshixinxi_guanzhu.setText("已关注("+body.getLawyerBus().getCareCnt()+")");
                        }else{
                            lvshixinxi_guanzhu.setText("关注("+body.getLawyerBus().getCareCnt()+")");
                        }
                        int fuwushu = body.getLawyerBus().getAskCnt() + body.getLawyerBus().getMeetCnt() + body.getLawyerBus().getCaseCnt();
                        lvshixinxi_fuwu.setText("服务("+fuwushu+")");
                        lvshixinxi_dongtai.setText("评论("+body.getLawyerBus().getCommtCnt()+")");
                        lvshixinxi_zan.setText("赞("+body.getLawyerBus().getLikeCnt()+")");
                        lvshixinxi_zhiyezheng.setText(body.getLawyer().getLawyerNo());
                        lvshixinxi_name.setText(body.getLawyer().getName());
                        lvshixinxi_techang.setText(body.getLawyer().getTypeName());
                        lvshixinxi_zhiyelvsuo.setText(body.getLawyer().getLawName());
                        lvshixinxi_gongzuonianxian.setText(body.getLawyer().getPeriod()+"");
                        lvshixinxi_suozaidi.setText(body.getLawyer().getAddress());
                        lvshixinxi_ziwojieshao.setText(body.getLawyer().getCntn());

                        if(body.getLawyerBus()==null || body.getLawyerBus().equals("")){
                            Toast.makeText(AttorneyMessage.this,"暂不支持咨询", Toast.LENGTH_SHORT).show();
                        }else {
                            int isMeet = body.getLawyerBus().getIsMeet();
                            if (isMeet == 0) {
                                yuyue.setText("不支持约谈");
                            } else if (isMeet == 1) {
                                yuyue.setText("预约见面:￥" + body.getLawyerBus().getMeetPrice());
                            }
                            int isAsk = body.getLawyerBus().getIsAsk();
                            if (isAsk == 0) {
                                dianhua.setText("不支持电话咨询");
                            } else if (isAsk == 1) {
                                dianhua.setText("电话咨询:￥" + body.getLawyerBus().getAskPrice());
                            }
                            final int like = body.getLawyerBus().getLikeCnt();
                            lvshixinxi_zan.setText("赞(" + like + ")");
                            lvshixinxi_zan.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(token==null||token.length()<1){
                                        Toast.makeText(AttorneyMessage.this,"请先登录",Toast.LENGTH_SHORT).show();
                                    }else{
                                        dianzan();
                                        lvshixinxi_zan.setText("赞(" + (like + 1) + ")");
                                    }
                                }
                            });
                        }
                        lvshixinxi_dongtai.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AttorneyMessage.this,MoreEvaluate.class);
                                intent.putExtra("lvshiid",attorneyid+"");

                                startActivity(intent);
                            }
                        });

                        dianhuall.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (body.getLawyerBus().getIsMeet() == 0) {
                                    Toast.makeText(AttorneyMessage.this,"律师暂时不支持电话咨询",Toast.LENGTH_SHORT).show();
                                }else {
                                    Intent intent = new Intent(AttorneyMessage.this, FilinMessage.class);
                                    intent.putExtra("lvshiid", attorneyid + "");
                                    intent.putExtra("token", token + "");
                                    intent.putExtra("price", body.getLawyerBus().getAskPrice() + "");
                                    startActivity(intent);
                                }
                            }
                        });

                        yuyuell.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (body.getLawyerBus().getIsMeet() == 0) {
                                    Toast.makeText(AttorneyMessage.this,"律师暂时不支持预约见面",Toast.LENGTH_SHORT).show();
                                }else {
                                    Intent intent = new Intent(AttorneyMessage.this, MakeActivity.class);
                                    intent.putExtra("lvshiid", attorneyid + "");
                                    intent.putExtra("token", token + "");
                                    intent.putExtra("price", body.getLawyerBus().getMeetPrice() + "");
                                    startActivity(intent);
                                }
                            }
                        });
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initView() {
        shouye_lvshixinxi_zuo = (ImageView) findViewById(R.id.shouye_lvshixinxi_zuo);
        lvshixinxi_touxiang = (ImageView) findViewById(R.id.lvshixinxi_touxiang);
        lvshixinxi_name = (TextView) findViewById(R.id.lvshixinxi_name);
        lvshixinxi_techang = (TextView) findViewById(R.id.lvshixinxi_techang);
        lvshixinxi_guanzhu = (RadioButton) findViewById(R.id.lvshixinxi_guanzhu);
        lvshixinxi_fuwu = (RadioButton) findViewById(R.id.lvshixinxi_fuwu);
        lvshixinxi_dongtai = (RadioButton) findViewById(R.id.lvshixinxi_dongtai);
        lvshixinxi_zan = (RadioButton) findViewById(R.id.lvshixinxi_zan);
        lvshixinxi_rg = (RadioGroup) findViewById(R.id.lvshixinxi_rg);
        lvshixinxi_zhiyezheng = (TextView) findViewById(R.id.lvshixinxi_zhiyezheng);
        lvshixinxi_zhiyelvsuo = (TextView) findViewById(R.id.lvshixinxi_zhiyelvsuo);
        lvshixinxi_gongzuonianxian = (TextView) findViewById(R.id.lvshixinxi_gongzuonianxian);
        lvshixinxi_suozaidi = (TextView) findViewById(R.id.lvshixinxi_suozaidi);
        lvshixinxi_ziwojieshao = (TextView) findViewById(R.id.lvshixinxi_ziwojieshao);
        dianhua = (TextView) findViewById(R.id.lvshixinxi_dianhua);
        yuyue = (TextView) findViewById(R.id.lvshixinxi_yuyue);
        dianhuall = (LinearLayout) findViewById(R.id.lvshixinxi_dianhuall);
        yuyuell = (LinearLayout) findViewById(R.id.lvshixinxi_yuyuell);
        gengduo = (LinearLayout) findViewById(R.id.lvshixinxi_gengduo);
        pingjia = (RecyclerView) findViewById(R.id.lvshixiangqing_pingjia);
    }

    public void dianzan(){
        OkGo.get("https://wuye.kylinlaw.com/lawyer/like?lawyerId="+attorneyid+"&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }
    public void guanzhu(){
        OkGo.get("https://wuye.kylinlaw.com/lawyer/flw?lawyerId="+attorneyid+"&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }


    private void quxiaoguanzhu(int id) {
        OkGo.get("https://wuye.kylinlaw.com/lawyer/del/flw?token=" + token+"&flwId="+id)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

}
