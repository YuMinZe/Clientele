package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.application.RoundedCornersTransformation;
import com.zll.wuye.bean.BasicBean;
import com.zll.wuye.bean.IndentBean;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

//预约律师
public class MakeActivity extends AutoLayoutActivity {

    private ImageView yuyuelvshi_guanbi;
    private ImageView yuyuelvshi_touxiang;
    private TextView yuyuelvshi_name;
    private TextView yuyuelvshi_shiwusuo;
    private TextView yuyuelvshi_suozaidi;
    private EditText yuyuelvshi_neirong;
    private EditText yuyuelvshi_khname;
    private EditText yuyuelvshi_khphoto;
    private String id;
    private Button tijiao;
    private String price;
    private String token;
    private TextView fuwufei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);
        Intent intent = getIntent();
        id = intent.getStringExtra("lvshiid");
        price = intent.getStringExtra("price");
        token = intent.getStringExtra("token");
        xiangqing();
        initView();
        initdata();
    }

    private void initdata() {
        yuyuelvshi_guanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yuyuelvshi_neirong.getText().toString().trim().equals("")){
                    Toast.makeText(MakeActivity.this,"请输入你要咨询的内容", Toast.LENGTH_SHORT).show();
                }else if(yuyuelvshi_khname.getText().toString().trim().equals("")){
                    Toast.makeText(MakeActivity.this,"请输入你的名字", Toast.LENGTH_SHORT).show();
                }else if(yuyuelvshi_khphoto.getText().toString().trim().equals("")){
                    Toast.makeText(MakeActivity.this,"请输入你的手机号", Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(yuyuelvshi_khphoto.getText().toString().trim())){
                    Toast.makeText(MakeActivity.this,"您输入的手机号不合法", Toast.LENGTH_SHORT).show();
                }else{
                    chuanshuju();
                }

            }
        });

    }

    public static boolean isPhoneNum(String phone_num) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(14[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone_num);
        return m.matches();
    }

    private void initView() {
        yuyuelvshi_guanbi = (ImageView) findViewById(R.id.yuyuelvshi_guanbi);
        yuyuelvshi_touxiang = (ImageView) findViewById(R.id.yuyuelvshi_touxiang);
        yuyuelvshi_name = (TextView) findViewById(R.id.yuyuelvshi_name);
        yuyuelvshi_shiwusuo = (TextView) findViewById(R.id.yuyuelvshi_shiwusuo);
        yuyuelvshi_suozaidi = (TextView) findViewById(R.id.yuyuelvshi_suozaidi);
        fuwufei = (TextView) findViewById(R.id.yuyuelvshi_fuwufei);
        yuyuelvshi_neirong = (EditText) findViewById(R.id.yuyuelvshi_neirong);
        yuyuelvshi_khname = (EditText) findViewById(R.id.yuyuelvshi_khname);
        yuyuelvshi_khphoto = (EditText) findViewById(R.id.yuyuelvshi_khphoto);
        tijiao = (Button) findViewById(R.id.yuyuelvshi_tijiao);
    }

    public void chuanshuju(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("type","mentLawyer");
        params.put("typeId",id);
        params.put("title","预约律师");
        params.put("price",price);
        params.put("num",1);

        Map<String,String> map =new HashMap<>();
        map.put("tel",yuyuelvshi_khphoto.getText().toString().trim());
        map.put("name",yuyuelvshi_khname.getText().toString().trim());
        map.put("cntn",yuyuelvshi_neirong.getText().toString().trim());
        params.put("attr",map);


        JSONObject jsonObject = new JSONObject(params);
        OkGo.post("https://wuye.kylinlaw.com/order/create?token="+token)
                .tag(this)//
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson= new Gson();
                        IndentBean bean = gson.fromJson(s, IndentBean.class);
                        IndentBean.BodyBean body = bean.getBody();
                        Intent intent = new Intent(MakeActivity.this,PaymentActivity.class);
                        intent.putExtra("token",token);
                        intent.putExtra("indent",body.getOrderNo()+"");
                        intent.putExtra("leixing","预约律师");
                        intent.putExtra("price",price+"");
                        startActivity(intent);
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    public void xiangqing(){
        OkGo.get("https://wuye.kylinlaw.com/lawyer/show?lawyerId="+id+"&token="+token)
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson= new Gson();
                        BasicBean basicBean = gson.fromJson(s, BasicBean.class);
                        BasicBean.BodyBean body = basicBean.getBody();
                        if(body!=null){
                            Glide.with(MakeActivity.this).load(body.getLawyer().getHeadUrl()).bitmapTransform(new RoundedCornersTransformation(MakeActivity.this, 30, 0, RoundedCornersTransformation.CornerType.ALL)).crossFade(1000).into(yuyuelvshi_touxiang);
                            yuyuelvshi_name.setText(body.getLawyer().getName());
                            yuyuelvshi_shiwusuo.setText(body.getLawyer().getLawName());
                            yuyuelvshi_suozaidi.setText(body.getLawyer().getAddress());
                            fuwufei.setText("服务价格:￥"+price+"/次");
                        }


                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

}
