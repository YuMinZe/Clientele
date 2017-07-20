package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.zhy.autolayout.AutoRelativeLayout;
import com.zll.wuye.R;
import com.zll.wuye.bean.HetongLeixing;
import com.zll.wuye.bean.IndentBean;
import com.zll.wuye.bean.KeFuBean;
import com.zll.wuye.bean.PhotoBeanfore;
import com.zll.wuye.bean.ProvinceBean;
import com.zll.wuye.bean.RegionBean;
import com.zll.wuye.fragment.homepage.adapter.Provincelv1Adapter;
import com.zll.wuye.fragment.homepage.adapter.Provincelv2Adapter;
import com.zll.wuye.fragment.mypage.adapter.WeiTuoXqAdapter;
import com.zll.wuye.http.HttpOkGo;
import com.zll.wuye.local.ImgFileListActivity;

import org.json.JSONObject;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

import static android.support.v7.widget.StaggeredGridLayoutManager.HORIZONTAL;

public class Anjianweituo_tuo extends AutoLayoutActivity implements View.OnClickListener {

    private ImageView shouye_weituo_zuo;
    private EditText weituoxiangqing_title;
    private EditText weituoxiangqing_message;
    private TextView weituoxiangqing_didiantv;
    private AutoLinearLayout weituoxiangqing_didian;
    private TextView weituoxiangqing_leixingtv;
    private AutoLinearLayout weituoxiangqing_leixing;
    private AutoRelativeLayout weituoxiangqing_shangchuan;
    private EditText weituoxiangqing_xiao;
    private EditText weituoxiangqing_da;
    private EditText weituoxiangqing_name;
    private EditText weituoxiangqing_photo;
    private Button weituoxiangqing_tijiao;
    private ListView lvsheng;
    private ListView lvshi;
    private PopupWindow popWnd;
    private  int  num=0;
    private PopupWindow popwnd;
    ArrayList<String> listfile=new ArrayList<String>();
    private String token;
    private String zongurl="";
    private String title;
    private String message;
    private String didiantv;
    private String leixingtv;
    private String xiao;
    private String da;
    private String name;
    private String photo;
    private String parid;
    private String parId;
    private SharedPreferences sp;
    private boolean isff = true;
    private int sum=0;
    private RecyclerView scdtp;
    private double wtprice;
    private KeFuBean.BodyBean bodyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anjianweituo_tuo);
        sp = getSharedPreferences("token", MODE_PRIVATE);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        initView();
        initdata();
        kefu();
    }

    private void initdata() {
        shouye_weituo_zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        weituoxiangqing_didian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow();
            }
        });
        weituoxiangqing_leixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popuswindio();
            }
        });
        weituoxiangqing_shangchuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anjianweituo_tuo.this,ImgFileListActivity.class);
                startActivity(intent);
            }
        });
        scdtp .setLayoutManager(new StaggeredGridLayoutManager(1,
                HORIZONTAL));
        jieshou();

        weituoxiangqing_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dedaoshuju();
                int xiaoint = Integer.parseInt(xiao);
                int daint = Integer.parseInt(da);
                if(title.equals("")||title.length()<1){
                    Toast.makeText(Anjianweituo_tuo.this,"请输入标题",Toast.LENGTH_SHORT).show();
                }else if(message.equals("")||message.length()<0){
                    Toast.makeText(Anjianweituo_tuo.this,"请描述案件",Toast.LENGTH_SHORT).show();
                }else if(didiantv.equals("诉讼地点")){
                    Toast.makeText(Anjianweituo_tuo.this,"请选择地点",Toast.LENGTH_SHORT).show();
                }else if(leixingtv.equals("案例类型")){
                    Toast.makeText(Anjianweituo_tuo.this,"请描述案件",Toast.LENGTH_SHORT).show();
                }else if(xiao.equals("")||xiao.length()<0){
                    Toast.makeText(Anjianweituo_tuo.this,"请输入最小报价",Toast.LENGTH_SHORT).show();
                }else if(da.equals("")||da.length()<0){
                    Toast.makeText(Anjianweituo_tuo.this,"请输入最大报价",Toast.LENGTH_SHORT).show();
                }else if(name.equals("")||name.length()<0){
                    Toast.makeText(Anjianweituo_tuo.this,"请输入您的姓名",Toast.LENGTH_SHORT).show();
                }else if(photo.equals("")||photo.length()<0){
                    Toast.makeText(Anjianweituo_tuo.this,"请输入您的手机号码",Toast.LENGTH_SHORT).show();
                }else if(!isPhoneNum(photo)){
                    Toast.makeText(Anjianweituo_tuo.this,"您输入的手机号不合法",Toast.LENGTH_SHORT).show();
                }else if(bodyBean.getCasePrice()>xiaoint){
                    Toast.makeText(Anjianweituo_tuo.this,"您输入的最小报价不能小于委托的报价",Toast.LENGTH_SHORT).show();
                }else if(daint<xiaoint){
                    Toast.makeText(Anjianweituo_tuo.this,"最大报价不能小于最小报价",Toast.LENGTH_SHORT).show();
                }else{
                   leixing(leixingtv);

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

    private void jieshou() {
        Bundle bundle= getIntent().getExtras();

        if (bundle!=null) {
            if (bundle.getStringArrayList("files")!=null) {
                listfile= bundle.getStringArrayList("files");
            }
        }

            if(listfile!=null&&listfile.size()>=1){
                if(isff){
                    weituoxiangqing_tijiao.setEnabled(false);
                    String s = listfile.get(sum);
                    photomath(s, sum);
                }
            }


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        jieshou();
    }

    private void shangchuan(int id) {
        weituoxiangqing_tijiao.setEnabled(false);

        HashMap<String, Object> params = new HashMap<>();
        params.put("type","case");
        params.put("typeId",0);
        params.put("title","案件委托");
        params.put("price",wtprice);
        params.put("num",1);

        Map<String,Object> map = new HashMap<>();
        map.put("type",0);
        map.put("typeId",id);
        map.put("tel",photo);
        map.put("name",name);
        map.put("title",title);
        map.put("offerstrt",xiao);
        map.put("offerEnd",da);
        map.put("earnest",wtprice);
        map.put("prvcId",parid);
        map.put("cityId",parId);
        map.put("distId",0);
        map.put("cntn",message);
        if(!zongurl.equals("")){
            map.put("fileUrls",zongurl);
        }
        map.put("caseStatus",1);

        params.put("attr",map);

        JSONObject jsonObject = new JSONObject(params);
        OkGo.post("https://wuye.kylinlaw.com/order/create?token="+token)
                .tag(this)//
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        weituoxiangqing_tijiao.setEnabled(true);
                        Gson gson= new Gson();
                        IndentBean bean = gson.fromJson(s, IndentBean.class);
                        IndentBean.BodyBean body = bean.getBody();
                        if(bean.getMessage().equals("请求成功")){
                            weituoxiangqing_tijiao.setEnabled(true);
                            Intent intent = new Intent(Anjianweituo_tuo.this,PaymentActivity.class);
                            intent.putExtra("token",token);
                            intent.putExtra("indent",body.getOrderNo()+"");
                            intent.putExtra("leixing","委托保证金");
                            intent.putExtra("price",wtprice+"");
                            startActivity(intent);
                        }else{
                            Toast.makeText(Anjianweituo_tuo.this,"登录过期请重新登录",Toast.LENGTH_SHORT).show();
                            sp.edit().clear().commit();
                            finish();
                        }


                    }
                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    private void dedaoshuju() {
        title = weituoxiangqing_title.getText().toString().trim();
        message = weituoxiangqing_message.getText().toString().trim();
        didiantv = weituoxiangqing_didiantv.getText().toString().trim();
        leixingtv = weituoxiangqing_leixingtv.getText().toString().trim();
        xiao = weituoxiangqing_xiao.getText().toString().trim();
        da = weituoxiangqing_da.getText().toString().trim();
        name = weituoxiangqing_name.getText().toString().trim();
        photo = weituoxiangqing_photo.getText().toString().trim();
    }

    private void photomath(final String url, final int i) {
        weituoxiangqing_tijiao.setEnabled(false);
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
                        List<PhotoBeanfore.BodyBean> body = json.getBody();
                        if(i==listfile.size()-1){
                            zongurl=zongurl+body.get(0).getPath();
                            isff=false;
                            weituoxiangqing_tijiao.setEnabled(true);
                            String[] split = zongurl.split("[,]");
                            scdtp.setAdapter(new WeiTuoXqAdapter(split,Anjianweituo_tuo.this));
                        }else{
                            zongurl=zongurl+body.get(0).getPath()+",";
                            sum++;
                            jieshou();
                        }
                    }


                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                    }
                });
    }

    private void initView() {
        shouye_weituo_zuo = (ImageView) findViewById(R.id.shouye_weituoxiangqing_zuo);
        weituoxiangqing_title = (EditText) findViewById(R.id.weituoxiangqing_title);
        weituoxiangqing_message = (EditText) findViewById(R.id.weituoxiangqing_message);
        weituoxiangqing_didiantv = (TextView) findViewById(R.id.weituoxiangqing_didiantv);
        weituoxiangqing_didian = (AutoLinearLayout) findViewById(R.id.weituoxiangqing_didian);
        weituoxiangqing_leixingtv = (TextView) findViewById(R.id.weituoxiangqing_leixingtv);
        weituoxiangqing_leixing = (AutoLinearLayout) findViewById(R.id.weituoxiangqing_leixing);
        weituoxiangqing_shangchuan = (AutoRelativeLayout) findViewById(R.id.weituoxiangqing_shangchuan);
        weituoxiangqing_xiao = (EditText) findViewById(R.id.weituoxiangqing_xiao);
        weituoxiangqing_da = (EditText) findViewById(R.id.weituoxiangqing_da);
        weituoxiangqing_name = (EditText) findViewById(R.id.weituoxiangqing_name);
        weituoxiangqing_photo = (EditText) findViewById(R.id.weituoxiangqing_photo);
        weituoxiangqing_tijiao = (Button) findViewById(R.id.weituoxiangqing_tijiao);
        scdtp = (RecyclerView) findViewById(R.id.weituoxiangqing_scdtp);
    }

    private void popupwindow() {
        View contentView = LayoutInflater.from(Anjianweituo_tuo.this).inflate(R.layout.popuplayoutdiqu, null);
        popWnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);

        popWnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.showAsDropDown(weituoxiangqing_didiantv);

        lvsheng = (ListView) contentView.findViewById(R.id.diqu_lv_sheng);
        lvshi = (ListView) contentView.findViewById(R.id.diqu_lv_shi);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.guanbipop);

        diyu();
        //显示PopupWindow
        View rootview = LayoutInflater.from(Anjianweituo_tuo.this).inflate(R.layout.activity_main, null);
        popWnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWnd.dismiss();
            }
        });
    }

    private void diyu() {
        OkGo.get("https://wuye.kylinlaw.com/dict/parId/list?parId=100000&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        final ProvinceBean provinceBean = gson.fromJson(s, ProvinceBean.class);
                        final Provincelv1Adapter adapter = new Provincelv1Adapter(Anjianweituo_tuo.this, provinceBean, num);
                        lvsheng.setAdapter(adapter);
                        lvsheng.setSelection(0);
                        lvsheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                parid = String.valueOf(provinceBean.getBody().get(position).getId());
                                diyuqu("http://101.200.133.150:8080/wy-api/dict/parId/list?parId=" + parid+"&token="+token);
                                weituoxiangqing_didiantv.setText(provinceBean.getBody().get(position).getName());

                                adapter.setdata(position);
                                adapter.notifyDataSetChanged();
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
                        lvshi.setAdapter(new Provincelv2Adapter(Anjianweituo_tuo.this, body,num));
                        lvshi.setSelection(0);
                        lvshi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                popWnd.dismiss();
                                String trim = weituoxiangqing_didiantv.getText().toString().trim();
                                weituoxiangqing_didiantv.setText(trim + "/" + body.get(position).getName());
                                parId = String.valueOf(body.get(position).getId());
                            }
                        });

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    public void popuswindio() {

        View contentView = LayoutInflater.from(Anjianweituo_tuo.this).inflate(R.layout.popuplayout, null);
        popwnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        popwnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popwnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popwnd.showAsDropDown(weituoxiangqing_leixingtv);
        TextView hetong = (TextView) contentView.findViewById(R.id.popupwindow_hetong);
        TextView laodong = (TextView) contentView.findViewById(R.id.popupwindow_laodong);
        TextView qinquan = (TextView) contentView.findViewById(R.id.popupwindow_qinquan);
        TextView wuquan = (TextView) contentView.findViewById(R.id.popupwindow_wuquan);
        TextView qita = (TextView) contentView.findViewById(R.id.popupwindow_qita);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.guanbipop1);
        hetong.setOnClickListener(this);
        laodong.setOnClickListener(this);
        qinquan.setOnClickListener(this);
        wuquan.setOnClickListener(this);
        qita.setOnClickListener(this);

        //显示PopupWindow
        View rootview = LayoutInflater.from(Anjianweituo_tuo.this).inflate(R.layout.activity_main, null);
        popwnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);


        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popwnd.dismiss();
            }
        });

    }
    public void leixing(final String panduan){
        OkGo.get("https://wuye.kylinlaw.com/dict/code/list?code=askType&token="+token)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        HetongLeixing leixing = gson.fromJson(s, HetongLeixing.class);
                        List<HetongLeixing.BodyBean> body = leixing.getBody();
                        int size = body.size();
                        for (int i = 0; i < size; i++) {
                            if(body.get(i).getName().equals(panduan)){
                                int mId = body.get(i).getId();
                                shangchuan(mId);
                            }
                        }

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.popupwindow_hetong:
                weituoxiangqing_leixingtv.setText("合同纠纷");
                popwnd.dismiss();
                break;
            case R.id.popupwindow_laodong:
                weituoxiangqing_leixingtv.setText("劳动纠纷");
                popwnd.dismiss();
                break;
            case R.id.popupwindow_wuquan:
                weituoxiangqing_leixingtv.setText("物权纠纷");
                popwnd.dismiss();
                break;
            case R.id.popupwindow_qinquan:
                weituoxiangqing_leixingtv.setText("侵权纠纷");
                popwnd.dismiss();
                break;
            case R.id.popupwindow_qita:
                weituoxiangqing_leixingtv.setText("其他");
                popwnd.dismiss();
                break;

        }
    }

    public void kefu(){
        String url = "https://wuye.kylinlaw.com/config";
        HttpOkGo.okgoget(url, KeFuBean.class, new HttpOkGo.okget<KeFuBean>() {
            @Override
            public void shuju(ArrayList<KeFuBean> list) {
                bodyBean = list.get(0).getBody();
                wtprice = list.get(0).getBody().getCasePrice();

            }
        });
    }
}
