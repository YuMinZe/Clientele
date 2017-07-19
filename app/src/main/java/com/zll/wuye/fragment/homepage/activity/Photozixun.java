package com.zll.wuye.fragment.homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.bean.PhotoBean;
import com.zll.wuye.bean.ProvinceBean;
import com.zll.wuye.bean.RegionBean;
import com.zll.wuye.fragment.homepage.adapter.PhotozixunAdapter;
import com.zll.wuye.fragment.homepage.adapter.Provincelv1Adapter;
import com.zll.wuye.fragment.homepage.adapter.Provincelv2Adapter;
import com.zll.wuye.http.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class Photozixun extends AutoLayoutActivity implements View.OnClickListener {

    private RecyclerView recycleview;
    private ImageView fanhui;
    private LinearLayout diqu;
    private ListView lvsheng;
    private ListView lvshi;
    private PopupWindow popWnd;
    private TextView diqu_text;
    private PopupWindow popwnd;
    private PopupWindow popwnd1;
    private TextView leixing_text;
    private LinearLayout leixing;
    private LinearLayout nianxian;
    private TextView nianxian_text;
    private  int  num=0;
    private String name;
    private String token;
    private TextView gainame;
    private int sum=10;
    ArrayList<PhotoBean.BodyBean> list= new ArrayList<>();
    private MaterialRefreshLayout mRefreshLayout;
    private boolean isLoadMore = true;
    private PhotozixunAdapter adapter;
    private int size;
    private int p=1;
    private int n=1;
    private int m=1;
    private TextView shangla;
    private ImageView leixingimage;
    private ImageView diquimage;
    private ImageView nianxianimage;
    private TextView quanguo;
    private TextView buxian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photozixun);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        token = sp.getString("token", "");
        if(token.length()<1){
            Toast.makeText(Photozixun.this,"未登录",Toast.LENGTH_SHORT).show();
        }
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        initview();
        initdata();

    }

    private void initdata() {

        jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&pageSize=10&token="+token);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview.setLayoutManager(layoutManager);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);

        shuaxin();

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        diqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow();

            }
        });
        leixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popuswindio();
            }
        });

        nianxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leixingpopus();
            }
        });

    }

    private void shuaxin() {
        /**
         * 设置是否上拉加载更多，默认是false，要手动改为true，要不然不会出现上拉加载
         */
        recycleview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRefreshLayout.setLoadMore(isLoadMore);

        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                shangla.setVisibility(View.GONE);
                mRefreshLayout.finishRefresh();
            }


            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {

                if(list.size()>=1){
                    size = list.size();
                    jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&pageSize=10&token="+token+"&lastId="+(list.get(size-1).getId()));
                }else{
                    shangla.setVisibility(View.VISIBLE);
                }
                mRefreshLayout.finishRefreshLoadMore();
            }
        });
    }

    private void initview() {
        recycleview = (RecyclerView) findViewById(R.id.shouye_dianhuazixun);
        fanhui = (ImageView) findViewById(R.id.shouye_dianhuazixun_zuo);
        diqu = (LinearLayout) findViewById(R.id.shouye_photo_diqu);
        leixing = (LinearLayout) findViewById(R.id.shouye_photo_leixing);
        nianxian = (LinearLayout) findViewById(R.id.shouye_photo_nianxian);
        diqu_text = (TextView) findViewById(R.id.shouye_photo_diqu_text);
        leixing_text = (TextView) findViewById(R.id.shouye_photo_leixing_text);
        nianxian_text = (TextView) findViewById(R.id.shouye_photo_nianxian_text);
        gainame = (TextView) findViewById(R.id.lvshiliebiao_name);
        gainame.setText(name);
        shangla = (TextView) findViewById(R.id.dianhua_shangla);

        leixingimage = (ImageView) findViewById(R.id.shouye_leixing_image);
        diquimage = (ImageView) findViewById(R.id.shouye_diqu_image);
        nianxianimage = (ImageView) findViewById(R.id.shouye_nianxian_image);

    }

    private void jiexi(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        n=1;
                        Gson gson = new Gson();
                        PhotoBean photoBean = gson.fromJson(s, PhotoBean.class);
                        List<PhotoBean.BodyBean> body = photoBean.getBody();
                        if(body!=null&&body.size()>=1){
                            if(p==1){
                                shangla.setVisibility(View.GONE);
                                list.addAll(body);
                                adapter = new PhotozixunAdapter(list, Photozixun.this);
                                recycleview.setAdapter(adapter);
                                p++;
                            }else{
                                if(body.size()>=10){
                                    list.addAll(body);
                                    adapter.notifyItemRangeChanged(size-1,list.size()-1);
                                }else{
                                    shangla.setVisibility(View.VISIBLE);
                                }
                            }
                        }else{
                            shangla.setVisibility(View.VISIBLE);
                        }
                        mRefreshLayout.finishRefreshLoadMore();
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    public void diyu(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        final ProvinceBean provinceBean = gson.fromJson(s, ProvinceBean.class);
                        final Provincelv1Adapter adapte = new Provincelv1Adapter(Photozixun.this, provinceBean, num);
                        lvsheng.setAdapter(adapte);
                        if(n==1){
                            diqu_text.setText(provinceBean.getBody().get(0).getName());
                            diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+provinceBean.getBody().get(0).getId()+"&token="+token,provinceBean.getBody().get(0).getId());
                            n++;
                        }
                        lvsheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String parid = String.valueOf(provinceBean.getBody().get(position).getId());
                                diyuqu("https://wuye.kylinlaw.com/dict/parId/list?parId="+parid+"&token="+token,provinceBean.getBody().get(position).getId());
                                diqu_text.setText(provinceBean.getBody().get(position).getName());
                                adapte.setdata(position);
                                adapte.notifyDataSetChanged();
                                n=1;
                    }
                });
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    private void popupwindow() {
        diqu_text.setText("地区");
        View contentView = LayoutInflater.from(Photozixun.this).inflate(R.layout.popuplayoutdiqu, null);
        popWnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);

        popWnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.showAsDropDown(diqu);

        diqu_text.setTextColor(R.color.pop_yes);
        diquimage.setImageResource(R.mipmap.shang);

        lvsheng = (ListView) contentView.findViewById(R.id.diqu_lv_sheng);
        lvshi = (ListView) contentView.findViewById(R.id.diqu_lv_shi);
        quanguo = (TextView) contentView.findViewById(R.id.diqu_lv_quanguo);
        buxian = (TextView) contentView.findViewById(R.id.diqu_lv_buxian);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.guanbipop);

        diyu("https://wuye.kylinlaw.com/dict/parId/list?parId=100000&token="+token);
        //显示PopupWindow
        View rootview = LayoutInflater.from(Photozixun.this).inflate(R.layout.activity_main, null);
        popWnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWnd.dismiss();
                n=1;
                diqu_text.setTextColor(Color.BLACK);
                diquimage.setImageResource(R.mipmap.shouye_xia);
            }
        });
        quanguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diqu_text.setText("全国");
                popWnd.dismiss();
                n=1;
                diqu_text.setTextColor(Color.BLACK);
                diquimage.setImageResource(R.mipmap.shouye_xia);
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&pageSize=10&token="+token);
            }
        });

    }


    public void diyuqu(String url, final int ppid) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, okhttp3.Response response) {
                        //上传成功
                        Gson gson = new Gson();
                        RegionBean regionBean = gson.fromJson(s, RegionBean.class);
                        final List<RegionBean.BodyBean> body = regionBean.getBody();
                        final Provincelv2Adapter adapte2 = new Provincelv2Adapter(Photozixun.this, body, num);
                        lvshi.setAdapter(adapte2);
                        if(m==1){
                            adapte2.setdata(0);
                            adapte2.notifyDataSetChanged();
                            m++;
                        }
                        lvshi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                popWnd.dismiss();
                                String trim = diqu_text.getText().toString().trim();
                                diqu_text.setText(trim + "/" + body.get(position).getName());
                                adapte2.setdata(position);
                                adapte2.notifyDataSetChanged();
                                list.clear();
                                adapter.notifyDataSetChanged();
                                diqu_text.setTextColor(Color.BLACK);
                                diquimage.setImageResource(R.mipmap.shouye_xia);
                                p=1;
                                n=1;
                                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&pageSize=10&token="+token+"&cityId="+body.get(position).getId());
                            }
                        });
                        buxian.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                diqu_text.setText("不限");
                                popWnd.dismiss();
                                n=1;
                                diqu_text.setTextColor(Color.BLACK);
                                diquimage.setImageResource(R.mipmap.shouye_xia);
                                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&pageSize=10&token="+token+"&prvcId="+ppid);
                            }
                        });

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                });
    }

    public void popuswindio() {

        View contentView = LayoutInflater.from(Photozixun.this).inflate(R.layout.popuplayout, null);
        popwnd = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        popwnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popwnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popwnd.showAsDropDown(leixing_text);
        leixing_text.setTextColor(R.color.pop_yes);
        leixingimage.setImageResource(R.mipmap.shang);
        TextView quanbu = (TextView) contentView.findViewById(R.id.popupwindow_quanbu);
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
        quanbu.setOnClickListener(this);
        //显示PopupWindow
        View rootview = LayoutInflater.from(Photozixun.this).inflate(R.layout.activity_main, null);
        popwnd.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               popwnd.dismiss();
                leixing_text.setTextColor(Color.BLACK);
                leixingimage.setImageResource(R.mipmap.shouye_xia);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.popupwindow_quanbu:
                leixing_text.setText("全部");
                list.clear();
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token);
                p=1;
                adapter.notifyDataSetChanged();
                leixing_text.setTextColor(Color.BLACK);
                leixingimage.setImageResource(R.mipmap.shouye_xia);
                popwnd.dismiss();
                break;
            case R.id.popupwindow_hetong:
                leixing_text.setText("合同纠纷");
                list.clear();
                p=1;
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token+"&typeId="+10001);
                adapter.notifyDataSetChanged();
                leixing_text.setTextColor(Color.BLACK);
                leixingimage.setImageResource(R.mipmap.shouye_xia);
                popwnd.dismiss();
                break;
            case R.id.popupwindow_laodong:
                leixing_text.setText("劳动纠纷");
                list.clear();
                p=1;
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token+"&typeId="+10002);
                adapter.notifyDataSetChanged();
                leixing_text.setTextColor(Color.BLACK);
                leixingimage.setImageResource(R.mipmap.shouye_xia);
                popwnd.dismiss();
                break;
            case R.id.popupwindow_wuquan:
                leixing_text.setText("物权纠纷");
                list.clear();
                p=1;
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token+"&typeId="+10003);
                adapter.notifyDataSetChanged();
                leixing_text.setTextColor(Color.BLACK);
                leixingimage.setImageResource(R.mipmap.shouye_xia);
                popwnd.dismiss();
                break;
            case R.id.popupwindow_qinquan:
                leixing_text.setText("侵权纠纷");
                list.clear();
                p=1;
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token+"&typeId="+10004);
                list.clear();
                adapter.notifyDataSetChanged();
                leixing_text.setTextColor(Color.BLACK);
                leixingimage.setImageResource(R.mipmap.shouye_xia);
                popwnd.dismiss();
                break;
            case R.id.popupwindow_qita:
                leixing_text.setText("其他");
                list.clear();
                p=1;
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token+"&typeId="+10005);
                adapter.notifyDataSetChanged();
                leixing_text.setTextColor(Color.BLACK);
                leixingimage.setImageResource(R.mipmap.shouye_xia);
                popwnd.dismiss();
                break;
            case R.id.popupwindow_haoping:
                nianxian_text.setText("好评");
                nianxian_text.setTextColor(Color.BLACK);
                nianxianimage.setImageResource(R.mipmap.shouye_xia);
                list.clear();
                p=1;
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token+"&sortColumns=grade");
                adapter.notifyDataSetChanged();
                popwnd1.dismiss();
                break;
            case R.id.popupwindow_nianxian:
                nianxian_text.setText("执业年限");
                nianxian_text.setTextColor(Color.BLACK);
                nianxianimage.setImageResource(R.mipmap.shouye_xia);
                list.clear();
                p=1;
                jiexi("https://wuye.kylinlaw.com/lawyer/list?type=0&token="+token+"&sortColumns=period");
                adapter.notifyDataSetChanged();
                popwnd1.dismiss();
                break;
        }
    }


    public void leixingpopus(){
        View contentView = LayoutInflater.from(Photozixun.this).inflate(R.layout.popuplayoutnianxian, null);
        popwnd1 = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        popwnd1.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popwnd1.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popwnd1.showAsDropDown(nianxian_text);
        nianxian_text.setTextColor(R.color.pop_yes);

        nianxianimage.setImageResource(R.mipmap.shang);
        TextView haoping = (TextView) contentView.findViewById(R.id.popupwindow_haoping);
        TextView zhiye = (TextView) contentView.findViewById(R.id.popupwindow_nianxian);
        LinearLayout ll = (LinearLayout) contentView.findViewById(R.id.guanbipop2);
        haoping.setOnClickListener(this);
        zhiye.setOnClickListener(this);

        //显示PopupWindow
        View rootview = LayoutInflater.from(Photozixun.this).inflate(R.layout.activity_main, null);
        popwnd1.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);


        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popwnd1.dismiss();
                nianxian_text.setTextColor(Color.BLACK);
                nianxianimage.setImageResource(R.mipmap.shouye_xia);
            }
        });
    }

}