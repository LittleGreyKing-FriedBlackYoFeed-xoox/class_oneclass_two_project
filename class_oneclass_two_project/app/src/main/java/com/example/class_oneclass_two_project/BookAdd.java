package com.example.class_oneclass_two_project;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.Buffer;

public class BookAdd extends AppCompatActivity implements View.OnClickListener{
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new MyDatabaseHelper(this,"User.db",null,2);
        setContentView(R.layout.book_add);
        Button a = (Button)findViewById(R.id.add_book);
        a.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_book:
                EditText editText1 = (EditText)findViewById(R.id.book_name);
                String book_name = editText1.getText().toString();
                EditText editText2 = (EditText)findViewById(R.id.press);
                String press = editText2.getText().toString();
                EditText editText3 = (EditText)findViewById(R.id.price);
                double price = Double.valueOf(editText3.getText().toString());
                EditText editText4 = (EditText)findViewById(R.id.pages);
                int pages = Integer.valueOf(editText4.getText().toString());
                EditText editText5 = (EditText)findViewById(R.id.writer);
                String writer = editText5.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //封装数据
                values.put("book_name",book_name);
                values.put("press",press);
                values.put("pages",pages);
                values.put("writer",writer);
                long count = db.insert("book",null,values);
                if (count > 0){
                    Toast.makeText(BookAdd.this,"Add Successed!",Toast.LENGTH_SHORT).show();
                }
                values.clear();
                break;
        }
    }
}
