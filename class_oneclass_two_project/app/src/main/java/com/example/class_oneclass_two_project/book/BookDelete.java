package com.example.class_oneclass_two_project.book;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.class_oneclass_two_project.R;
import com.example.class_oneclass_two_project.util.EditTextClearTools;
import com.example.class_oneclass_two_project.util.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class BookDelete extends AppCompatActivity implements View.OnClickListener{
    EditText search_by_book_name;
    ImageView search_button_image;
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
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_go:
                EditText editText1 = (EditText)findViewById(R.id.search_by_book_name);
                String book_name = editText1.getText().toString();
                //Toast.makeText(BookDelete.this,book_name,Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //select null1 from tableName where null2=null3 group by null4 having null5 order by null6
                Cursor c = db.query("book",null,null,null,null,null,null);
                while(c.moveToNext()){
                    String book_name1 = c.getString(c.getColumnIndex("book_name"));
                    Toast.makeText(BookDelete.this,book_name1,Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void init() {
        // TODO Auto-generated method stub
        search_by_book_name = (EditText) findViewById(R.id.search_by_book_name);
        search_button_image = (ImageView) findViewById(R.id.search_button_image);
        // 添加清楚监听器大气
        EditTextClearTools.addclerListener(search_by_book_name, search_button_image);

    }
}
