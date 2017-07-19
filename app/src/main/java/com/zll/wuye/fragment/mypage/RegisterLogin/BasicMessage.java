package com.zll.wuye.fragment.mypage.RegisterLogin;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zll.wuye.R;
import com.zll.wuye.bean.BasicMessageBean;
import com.zll.wuye.bean.PhotoBeanfore;
import com.zll.wuye.bean.ProvinceBean;
import com.zll.wuye.bean.RegionBean;
import com.zll.wuye.fragment.homepage.adapter.Provincelv1Adapter;
import com.zll.wuye.fragment.homepage.adapter.Provincelv2Adapter;
import com.zll.wuye.fragment.mypage.RegisterLogin.change.Personage_name;
import com.zll.wuye.fragment.mypage.RegisterLogin.change.Personage_sex;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

//基本信息
public class BasicMessage extends AutoLayoutActivity {

    private ImageView wode_xinxi_fanhui;
    private ImageView wode_xinxi_touxiang;
    private AutoLinearLayout wode_xinxi_touxiangxiugai;
    private TextView wode_xinxi_nicheng;
    private AutoLinearLayout wode_xinxi_nichengxiugai;
    private TextView wode_xinxi_xingbie;
    private AutoLinearLayout wode_xinxi_xingbiexiugai;
    private TextView wode_xinxi_dizhi;
    private AutoLinearLayout wode_xinxi_dizhixiugai;
    private AutoLinearLayout wode_xinxi_xiugaimima;
    private String token;
    private SharedPreferences sp;
    private PopupWindow popWnd;
    private ListView lvsheng;
    private ListView lvshi;
    private  int  num=0;
    private  int m=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_message);
        sp = getSharedPreferences("token", MODE_PRIVATE);
        Intent intent = getIntent();
        this.token = intent.getStringExtra("token");
        initView();
        dedaomessage();
        initdata();

    }

    private void initdata() {
        wode_xinxi_touxiangxiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                /* 开启Pictures画面Type设定为image */
                intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                startActivityForResult(intent, 1);
            }
        });
        wode_xinxi_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wode_xinxi_nichengxiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicMessage.this, Personage_name.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });

        wode_xinxi_xingbiexiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BasicMessage.this, Personage_sex.class);
                in.putExtra("token",token);
                startActivity(in);
            }
        });

        wode_xinxi_xiugaimima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BasicMessage.this, ForgetMe.class);
                in.putExtra("token",token);
                startActivity(in);
            }
        });

        wode_xinxi_dizhixiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow();
            }
        });

    }

    private void popupwindow() {
        View contentView = LayoutInflater.from(BasicMessage.this).inflate(R.layout.popuplayoutdiqu, null);
        popWnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);

        popWnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.showAsDropDown(wode_xinxi_dizhixiugai);

        lvsheng = (ListView) contentView.findViewById(R.id.diqu_lv_sheng);
        lvshi = (ListView) contentView.findViewById(R.id.diqu_lv_shi);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.guanbipop);

        diyu();
        //显示PopupWindow
        View rootview = LayoutInflater.from(BasicMessage.this).inflate(R.layout.activity_main, null);
        popWnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWnd.dismiss();
            }
        });
    }

    public void diyu() {
        OkGo.get("https://wuye.kylinlaw.com/dict/parId/list?parId=100000&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        final ProvinceBean provinceBean = gson.fromJson(s, ProvinceBean.class);
                        lvsheng.setAdapter(new Provincelv1Adapter(BasicMessage.this, provinceBean,num));
                        lvsheng.setSelection(0);
                        diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+110000+"&token="+token);


                        lvsheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String parid = String.valueOf(provinceBean.getBody().get(position).getId());
                                diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+parid+"&token="+token);
                                wode_xinxi_dizhi.setText(provinceBean.getBody().get(position).getName());
                            }
                        });
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    public void diyuqu(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        RegionBean regionBean = gson.fromJson(s, RegionBean.class);
                        final List<RegionBean.BodyBean> body = regionBean.getBody();
                        lvshi.setAdapter(new Provincelv2Adapter(BasicMessage.this, body,num));
                        lvshi.setSelection(0);

                        lvshi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                popWnd.dismiss();
                                String trim = wode_xinxi_dizhi.getText().toString().trim();
                                wode_xinxi_dizhi.setText(trim + "/" + body.get(position).getName());
                                chuan(body.get(position).getId());
                            }
                        });

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void chuan(int id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("fields", id);
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("https://wuye.kylinlaw.com/user/update?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        Toast.makeText(BasicMessage.this,"修改地址成功",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void initView() {
        wode_xinxi_fanhui = (ImageView) findViewById(R.id.wode_xinxi_fanhui);
        wode_xinxi_touxiang = (ImageView) findViewById(R.id.wode_xinxi_touxiang);
        wode_xinxi_touxiangxiugai = (AutoLinearLayout) findViewById(R.id.wode_xinxi_touxiangxiugai);
        wode_xinxi_nicheng = (TextView) findViewById(R.id.wode_xinxi_nicheng);
        wode_xinxi_nichengxiugai = (AutoLinearLayout) findViewById(R.id.wode_xinxi_nichengxiugai);
        wode_xinxi_xingbie = (TextView) findViewById(R.id.wode_xinxi_xingbie);
        wode_xinxi_xingbiexiugai = (AutoLinearLayout) findViewById(R.id.wode_xinxi_xingbiexiugai);
        wode_xinxi_dizhi = (TextView) findViewById(R.id.wode_xinxi_dizhi);
        wode_xinxi_dizhixiugai = (AutoLinearLayout) findViewById(R.id.wode_xinxi_dizhixiugai);
        wode_xinxi_xiugaimima = (AutoLinearLayout) findViewById(R.id.wode_xinxi_xiugaimima);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            String path = Lujing.getPath(BasicMessage.this, uri);
            photomath(path);
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                /* 将Bitmap设定到ImageView */
                wode_xinxi_touxiang.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void photomath(String url) {

        OkGo.post("https://wuye.kylinlaw.com/file/upload?token="+token)//
                .tag(this)//
                .isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params("headUrl", new File(url)) 	// 支持多文件同时添加上传
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        PhotoBeanfore json = gson.fromJson(s, PhotoBeanfore.class);
                        String path = json.getBody().get(0).getPath();
                        shangchuantouxiang("headUrl",path);
                    }


                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    public void shangchuantouxiang(String name,String url){
        HashMap<String, Object> params = new HashMap<>();
        params.put(name, url);
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("https://wuye.kylinlaw.com/user/update?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {

                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    public void dedaomessage(){
        HashMap<String, Object> params = new HashMap<>();
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post("https://wuye.kylinlaw.com/user/show?token="+token)//
                .tag(this)//
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        Gson gson = new Gson();
                        BasicMessageBean bean = gson.fromJson(s, BasicMessageBean.class);
                        if(bean.getMessage().equals("请求成功")){
                            ImageLoader.getInstance().displayImage(bean.getBody().getHeadUrl(),wode_xinxi_touxiang);
                            wode_xinxi_nicheng.setText(bean.getBody().getRname());
                            int sex = bean.getBody().getSex();
                            if(sex==0){
                                wode_xinxi_xingbie.setText("女");
                            }else if(sex == 1){
                                wode_xinxi_xingbie.setText("男");
                            }else{
                                wode_xinxi_xingbie.setText("未填写");
                            }
                        }else{
                            Toast.makeText(BasicMessage.this,"登录过期请重新登录",Toast.LENGTH_SHORT).show();
                            sp.edit().clear().commit();
                            finish();
                        }


                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        dedaomessage();
        initdata();
    }
}
