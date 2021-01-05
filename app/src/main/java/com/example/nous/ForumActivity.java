package com.example.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.base.MoreObjects;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ForumActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter postAdapter;

    ImageView back_btn;
    TextView badges_button, forum_btn, profile_btn, ranking_btn;

    ArrayList<PostModel> postArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        back_btn = findViewById(R.id.back);
        badges_button = findViewById(R.id.badgesTab);
        ranking_btn = findViewById(R.id.rankingTab);
        profile_btn = findViewById(R.id.profileTab);
        forum_btn = findViewById(R.id.forumTab);
        recyclerView = findViewById(R.id.recyclerPost);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Post");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postArrayList = new ArrayList<>();
                for (DataSnapshot postsnap: dataSnapshot.getChildren()) {
                    PostModel post = postsnap.getValue(PostModel.class);
                    postArrayList.add(post) ;
                }

                postAdapter = new PostAdapter(ForumActivity.this, postArrayList);
                recyclerView.setAdapter(postAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        badges_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, BadgesActivity.class);
                startActivity(intent);
            }
        });

        ranking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addPost(View view)
    {
        AddPostFragment addPost = new AddPostFragment();
        addPost.show(getSupportFragmentManager(),"AddPost");
    }
}