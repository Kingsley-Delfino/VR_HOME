package com.example.administrator.vr_home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {
    CardView cardView, cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        cardView = (CardView) findViewById(R.id.cardView);
        cardView1 = (CardView) findViewById(R.id.cardView1);
        cardView2 = (CardView) findViewById(R.id.cardView2);
        cardView3 = (CardView) findViewById(R.id.cardView3);
        cardView4 = (CardView) findViewById(R.id.cardView4);
        cardView5 = (CardView) findViewById(R.id.cardView5);
        cardView6 = (CardView) findViewById(R.id.cardView6);
        cardView7 = (CardView) findViewById(R.id.cardView7);
        cardView8 = (CardView) findViewById(R.id.cardView8);
        cardView9 = (CardView) findViewById(R.id.cardView9);
        cardView.setClickable(true);
        cardView1.setClickable(true);
        cardView2.setClickable(true);
        cardView3.setClickable(true);
        cardView4.setClickable(true);
        cardView5.setClickable(true);
        cardView6.setClickable(true);
        cardView7.setClickable(true);
        cardView8.setClickable(true);
        cardView9.setClickable(true);
        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        cardView9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(ChooseActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
    }
}
