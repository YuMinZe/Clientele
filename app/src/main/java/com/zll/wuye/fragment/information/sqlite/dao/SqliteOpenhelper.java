package com.zll.wuye.fragment.information.sqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/30 13:58
 */
public class SqliteOpenhelper extends SQLiteOpenHelper{
    public SqliteOpenhelper(Context context) {
        super(context,"news", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table newlist(_id integer primary key autoincrement,cntn varchar(100),listid varchar(20),type varchar(20),time varchar(20),read varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
