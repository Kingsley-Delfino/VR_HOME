package com.example.administrator.vr_home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;

public class CollectionActivity extends AppCompatActivity {
    ImageView imageView2;
    LinearLayout home, collection, personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

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
                Intent intent =new Intent(CollectionActivity.this,SearchActivity.class);
                startActivity(intent);
                CollectionActivity.this.overridePendingTransition(0, 0);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(CollectionActivity.this,HomeActivity.class);
                startActivity(intent);
                CollectionActivity.this.overridePendingTransition(0, 0);
            }
        });
        collection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(CollectionActivity.this,CollectionActivity.class);
                startActivity(intent);
                CollectionActivity.this.overridePendingTransition(0, 0);
            }
        });
        personal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =new Intent(CollectionActivity.this,PersonalActivity.class);
                startActivity(intent);
                CollectionActivity.this.overridePendingTransition(0, 0);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member(92, "I-100.jpg", "James"));
        memberList.add(new Member(103, "I-100.jpg", "David"));
        memberList.add(new Member(234, "I-100.png", "Jerry"));
        memberList.add(new Member(35, "I-100.jpg", "Maggie"));
        memberList.add(new Member(23, "I-100.jpg", "John"));
        memberList.add(new Member(75, "I-100.png", "Jack"));
        memberList.add(new Member(65, "I-100.jpg", "Mark"));
        memberList.add(new Member(12, "I-100.png", "Ben"));
        memberList.add(new Member(45, "I-100.png", "Ken"));
        memberList.add(new Member(78, "I-100.jpg", "Ron"));
        memberList.add(new Member(57, "I-100.png", "Sue"));
        recyclerView.setAdapter(new MemberAdapter(this, memberList));
    }

    public class Member{
        int id;
        String image;
        String name;
        public Member(int id, String image, String name){
            this.id=id;
            this.image=image;
            this.name=name;
        }

        public int getId() {
            return id;
        }

        public String getImage() {
            return image;
        }

        public String getName() {
            return name;
        }
    }
    public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
        private Context context;
        private LayoutInflater layoutInflater;
        private List<Member> memberList;

        public MemberAdapter(Context context, List<Member> memberList) {
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
            this.memberList = memberList;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivImage;
            TextView tvId, tvName;
            View itemView;

            public ViewHolder(View itemView) {
                super(itemView);
                this.itemView = itemView;
                ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
                tvId = (TextView) itemView.findViewById(R.id.tvId);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
            }
        }

        @Override
        public int getItemCount() {
            return memberList.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View itemView = layoutInflater.inflate(R.layout.grid_layout_manager, viewGroup, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            final Member member = memberList.get(position);
            Glide.with(context).load("file:///android_asset/" + member.getImage()).into(viewHolder.ivImage);
            viewHolder.tvId.setText(String.valueOf(member.getId()));
            viewHolder.tvName.setText(member.getName());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(CollectionActivity.this,ChooseActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}