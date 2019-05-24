package com.example.class_oneclass_two_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Book extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);
        Button back_finish = (Button)findViewById(R.id.back_finish);
        back_finish.setOnClickListener(this);
        //查询列表
        RelativeLayout onclick_select = (RelativeLayout)findViewById(R.id.onclick_select);
        onclick_select.setOnClickListener(this);
        //添加
        RelativeLayout onclick_add = (RelativeLayout)findViewById(R.id.click_add);
        onclick_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_finish:
                finish();
                break;
            // 查询跳转
            case R.id.onclick_select:
                //Toast.makeText(Book.this,"被点击",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Book.this,BookList.class);
                startActivity(i);
                break;
            // 添加跳转
            case R.id.click_add:
                Intent i2 = new Intent(Book.this,BookAdd.class);
                startActivity(i2);
                break;
        }
    }
}
