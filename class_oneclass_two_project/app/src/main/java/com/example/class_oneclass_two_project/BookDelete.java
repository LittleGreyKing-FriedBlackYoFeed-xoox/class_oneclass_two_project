package com.example.class_oneclass_two_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookDelete extends AppCompatActivity implements View.OnClickListener{
    private MyDatabaseHelper dbHelper;
    List<BookEntity> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_delete);
        dbHelper = new MyDatabaseHelper(this,"User.db",null,2);
        bookList = new ArrayList<BookEntity>();
        //点击查询
        Button select_go = (Button)findViewById(R.id.search_go);
        select_go.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_go:
                EditText editText1 = (EditText)findViewById(R.id.search_username);
                String book_name = editText1.getText().toString();
                //Toast.makeText(BookDelete.this,book_name,Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //select null1 from tableName where null2=null3 group by null4 having null5 order by null6
                Cursor c = db.query("book",new String[]{"book_name,press,price,pages,writer"},"book_name = " + book_name,null,null,null,null);
                while(c.moveToNext()){
                    int id = c.getInt(c.getColumnIndex("book_name"));
                    Toast.makeText(BookDelete.this,id,Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
