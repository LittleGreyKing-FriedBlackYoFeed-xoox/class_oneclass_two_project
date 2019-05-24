package com.example.class_oneclass_two_project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(this);
        dbHelper = new MyDatabaseHelper(this,"User.db",null,2);
        Button sign = (Button)findViewById(R.id.Sign);
        sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
                break;
            case R.id.Sign:
                EditText editText1 = (EditText)findViewById(R.id.username);
                EditText editText2 = (EditText)findViewById(R.id.password);
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("username",username);
                values.put("password",password);
                long insertResult = db.insert("user_base",null,values);
                values.clear();
                if (insertResult > 0){
                    Intent i2 = new Intent(Register.this,Login.class);
                    startActivity(i2);
                }
                //Toast.makeText(Register.this,insertResult + "",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
