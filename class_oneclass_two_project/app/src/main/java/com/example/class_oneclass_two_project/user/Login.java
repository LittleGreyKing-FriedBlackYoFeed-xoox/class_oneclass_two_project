package com.example.class_oneclass_two_project.user;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.class_oneclass_two_project.book.Book;
import com.example.class_oneclass_two_project.R;
import com.example.class_oneclass_two_project.util.MyDatabaseHelper;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //透明状态栏          
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //实例化数据库
        dbHelper = new MyDatabaseHelper(this, "User.db", null, 2);
        //创建数据库成功且执行了创建user表操作
        dbHelper.getWritableDatabase();
        //Toast.makeText(Login.this,"create database successed!",Toast.LENGTH_LONG).show();
        //监听按钮事件
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        //注册
        Button r = (Button) findViewById(R.id.Sign_in);
        r.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //注册跳转
            case R.id.Sign_in:
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
                break;
            case R.id.login:
                //1、获取页面信息
                EditText editText1 = (EditText) findViewById(R.id.username);
                String username = editText1.getText().toString();
                EditText editText2 = (EditText) findViewById(R.id.password);
                String password = editText2.getText().toString();
                //Toast.makeText(Login.this,username + password,Toast.LENGTH_SHORT).show();
                if (!username.equals("") && !password.equals("")) {
                    //Toast.makeText(Login.this, "不為空", Toast.LENGTH_SHORT).show();
                    //2、查询数据库存储的信息
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    Cursor c = db.query("user_base", null, null, null, null, null, null);
                    if (c.moveToFirst()) {
                        do {
                            String usernamefordatabases = c.getString(c.getColumnIndex("username"));
                            String passwordfordatabases = c.getString(c.getColumnIndex("password"));
                            //Toast.makeText(Login.this,usernamefordatabases+passwordfordatabases,Toast.LENGTH_SHORT).show();
                            //3、用户填写的用户名和密码与数据库用户名密码进行比较
                            if (username.equals(usernamefordatabases)) {
                                if (password.equals(passwordfordatabases)) {
                                    //4、跳转到书目列表
                                    Intent b = new Intent(Login.this, Book.class);
                                    startActivity(b);
                                    //Toast.makeText(Login.this,"Login successed!",Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Login.this, "password error,please check try again latter!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Login.this, "username error,please check and try again latter!", Toast.LENGTH_SHORT).show();
                            }
                        } while (c.moveToNext());
                    }
                } else {
                    Toast.makeText(Login.this, "username or password can't empty!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
