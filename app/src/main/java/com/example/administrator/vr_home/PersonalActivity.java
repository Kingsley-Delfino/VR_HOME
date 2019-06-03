package com.example.administrator.vr_home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PersonalActivity extends AppCompatActivity {
    LinearLayout home, collection, personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        home = (LinearLayout) findViewById(R.id.home);
        collection = (LinearLayout) findViewById(R.id.collection);
        personal = (LinearLayout) findViewById(R.id.personal);
        home.setClickable(true);
        collection.setClickable(true);
        personal.setClickable(true);
        home.setOnClickListener(arg0 -> {
            Intent intent =new Intent(PersonalActivity.this,HomeActivity.class);
            startActivity(intent);
            PersonalActivity.this.overridePendingTransition(0, 0);
        });
        collection.setOnClickListener(arg0 -> {
            Intent intent =new Intent(PersonalActivity.this,CollectionActivity.class);
            startActivity(intent);
            PersonalActivity.this.overridePendingTransition(0, 0);
        });
        personal.setOnClickListener(arg0 -> {
            Intent intent =new Intent(PersonalActivity.this,PersonalActivity.class);
            startActivity(intent);
            PersonalActivity.this.overridePendingTransition(0, 0);
        });
    }
}
