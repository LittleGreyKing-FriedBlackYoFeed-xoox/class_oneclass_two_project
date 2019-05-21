package com.example.class_oneclass_two_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String user_table = "create table user_base(" +
                    "id integer primary key autoincrement," +
                    "username text," +
                    "password text)";
    private Context mContext;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(user_table);
        Toast.makeText(mContext,"create table user successed!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
