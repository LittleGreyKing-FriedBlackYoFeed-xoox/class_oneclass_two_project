package com.example.class_oneclass_two_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookList extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    List<BookEntity> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);
        dbHelper = new MyDatabaseHelper(this,"User.db",null,2);
        bookList = new ArrayList<BookEntity>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query("book",null,null,null,null,null,null);
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String book_name = c.getString(c.getColumnIndex("book_name"));
            String press = c.getString(c.getColumnIndex("press"));
            double price = c.getDouble(c.getColumnIndex("price"));
            int pages = c.getInt(c.getColumnIndex("pages"));
            String writer = c.getString(c.getColumnIndex("writer"));
            BookEntity be = new BookEntity(id,book_name,press,price,pages,writer);
            bookList.add(be);
        }
        LinearLayout ll = (LinearLayout)findViewById(R.id.book_list);
        //显示到界面上
        for (BookEntity u : bookList){
            //1.集合中每有一条数据，就new一个TextView
            TextView tv = new TextView(this);
            //2.把用户信息添加到里面
            tv.setText(u.toString());
            tv.setTextSize(18);
            ll.addView(tv);
        }
    }
}
