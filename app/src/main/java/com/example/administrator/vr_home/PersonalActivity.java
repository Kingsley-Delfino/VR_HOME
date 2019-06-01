package com.example.administrator.vr_home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PersonalActivity extends AppCompatActivity {
    ImageView imageView2;
    LinearLayout home, collection, personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        home = (LinearLayout) findViewById(R.id.home);
        collection = (LinearLayout) findViewById(R.id.collection);
        personal = (LinearLayout) findViewById(R.id.personal);
        imageView2.setClickable(true);
        home.setClickable(true);
        collection.setClickable(true);
        personal.setClickable(true);
        imageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(PersonalActivity.this,SearchActivity.class);
                startActivity(intent);
                PersonalActivity.this.overridePendingTransition(0, 0);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(PersonalActivity.this,HomeActivity.class);
                startActivity(intent);
                PersonalActivity.this.overridePendingTransition(0, 0);
            }
        });
        collection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(PersonalActivity.this,CollectionActivity.class);
                startActivity(intent);
                PersonalActivity.this.overridePendingTransition(0, 0);
            }
        });
        personal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(PersonalActivity.this,PersonalActivity.class);
                startActivity(intent);
                PersonalActivity.this.overridePendingTransition(0, 0);
            }
        });
    }
}
