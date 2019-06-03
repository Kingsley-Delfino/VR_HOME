package com.example.administrator.vr_home;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {
    Button button1;
    TextView textView3, textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button1 = (Button) findViewById(R.id.button1);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView3.setClickable(true);
        textView3.setOnClickListener(arg0 -> {
            Intent intent =new Intent(LoginActivity.this,AgreementActivity.class);
            startActivity(intent);
        });
        textView7.setClickable(true);
        textView7.setOnClickListener(arg0 -> {
            Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
