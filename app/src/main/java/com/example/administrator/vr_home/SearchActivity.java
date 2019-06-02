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

    public class SearchActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

            recyclerView.setLayoutManager(new GridLayoutManager(this,1));
            List<Member> memberList = new ArrayList<>();
            memberList.add(new Member(137, "apartment1.png", 198));
            memberList.add(new Member(103, "apartment2.png", 234));
            memberList.add(new Member(234, "apartment3.png", 209));
            memberList.add(new Member(305, "apartment4.png", 121));
            memberList.add(new Member(203, "apartment5.png", 690));
            memberList.add(new Member(785, "apartment6.png", 190));
            memberList.add(new Member(615, "apartment7.png", 764));
            recyclerView.setAdapter(new MemberAdapter(this, memberList));
        }

        public class Member{
            int id;
            String image;
            int aid;
            public Member(int id, String image, int aid){
                this.id=id;
                this.image=image;
                this.aid=aid;
            }

            public int getId() {
                return id;
            }

            public String getImage() {
                return image;
            }

            public int getAid() {
                return aid;
            }
        }
        private class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
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
            public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                View itemView = layoutInflater.inflate(R.layout.grid_layout_manager, viewGroup, false);
                return new MemberAdapter.ViewHolder(itemView);
            }

            @Override
            public void onBindViewHolder(MemberAdapter.ViewHolder viewHolder, final int position) {
                final Member member = memberList.get(position);
                Glide.with(context).load("file:///android_asset/" + member.getImage()).into(viewHolder.ivImage);
                viewHolder.tvId.setText(String.valueOf(member.getId()));
                viewHolder.tvName.setText(member.getAid());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(SearchActivity.this,ShowActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }