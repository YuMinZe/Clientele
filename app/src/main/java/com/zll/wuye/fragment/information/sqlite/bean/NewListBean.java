package com.zll.wuye.fragment.information.sqlite.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zll.wuye.fragment.information.sqlite.dao.SqliteOpenhelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/30 14:07
 */
public class NewListBean {

    private final SqliteOpenhelper helper;

    public NewListBean(Context context) {
        helper = new SqliteOpenhelper(context);

    }

    public void add(String cntn,String listid,String type,String time,String read){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cntn",cntn);
        values.put("listid",listid);
        values.put("type",type);
        values.put("time",time);
        values.put("read",read);
        db.insert("newlist",null,values);
        db.close();
    }
    public void updata(String time){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("read", "2");
        db.update("newlist",values,"time=?",new String[]{time});
        db.close();
    }
    public List<MessBean> select(){
        SQLiteDatabase db = helper.getWritableDatabase();
        List<MessBean> list = new ArrayList<>();
        Cursor cursor = db.query("newlist", null, null, null, null, null, null);

        while(cursor.moveToNext()){
            String cntn = cursor.getString(cursor.getColumnIndex("cntn"));
            String listid = cursor.getString(cursor.getColumnIndex("listid"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            String read = cursor.getString(cursor.getColumnIndex("read"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            MessBean bean = new MessBean(cntn, listid, type,time,read);
            list.add(bean);
        }

        db.close();

        return list;
    }
}
