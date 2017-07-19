package com.zll.wuye.fragment.homepage.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.zll.wuye.R;
import com.zll.wuye.bean.KeFuBean;
import com.zll.wuye.http.HttpOkGo;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/10 14:29
 */
public class Alot {

    private TextView teltv;
    private Button hujiao;

    public void dadianhua(final Context context){

        final android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(context).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.alot);
        teltv = (TextView) window.findViewById(R.id.alot_tel);
        hujiao = (Button) window.findViewById(R.id.alot_queding);
        Button quxiao = (Button) window.findViewById(R.id.alot_quxiao);
        String url = "https://wuye.kylinlaw.com/config";
        HttpOkGo.okgoget(url, KeFuBean.class, new HttpOkGo.okget<KeFuBean>() {
            @Override
            public void shuju(ArrayList<KeFuBean> list) {
                final String tel = list.get(0).getBody().getTel();
                teltv.setText(tel+"");
                hujiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent dialIntent =  new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel));
                        context.startActivity(dialIntent);
                        dialog.dismiss();
                    }
                });
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}
