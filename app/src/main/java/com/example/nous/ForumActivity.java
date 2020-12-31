package com.example.nous;

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

import java.util.ArrayList;

public class ForumActivity extends AppCompatActivity implements PostAdapter.OnPostListener {

    RecyclerView recyclerView;
    PostAdapter postAdapter;

    ImageView back_btn;
    TextView badges_button, forum_btn, profile_btn, ranking_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        back_btn = findViewById(R.id.back);
        badges_button = findViewById(R.id.badgesTab);
        ranking_btn = findViewById(R.id.rankingTab);
        profile_btn = findViewById(R.id.profileTab);
        forum_btn = findViewById(R.id.forumTab);

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


        recyclerView = findViewById(R.id.recyclerPost);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postAdapter = new PostAdapter(this, getPostList(),this);

        recyclerView.setAdapter(postAdapter);

    }

    private ArrayList<PostModel> getPostList()
    {
        ArrayList<PostModel> postArrayList = new ArrayList<>();
        PostModel m;

        m = new PostModel();
        m.setPostTitle("How ARre you?");
        m.setPostDate("20/4/2020");
        m.setPostUser("Jay");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);

        m = new PostModel();
        m.setPostTitle("How ARe you?");
        m.setPostDate("20/4/2020");
        m.setPostUser("Bryant");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);

        m = new PostModel();
        m.setPostTitle("How ARe you?");
        m.setPostDate("20/4/2020");
        m.setPostUser("Jordan");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);

        m = new PostModel();
        m.setPostTitle("How ARe you?");
        m.setPostDate("20/4/2020");
        m.setPostUser("Allen");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);


        return postArrayList;
    }

    @Override
    public void onPostClick(int position) {
        Toast.makeText(this,"" + position, Toast.LENGTH_LONG).show();

        //get post id here

        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);

    }

    public void addPost(View view)
    {
        AddPostFragment addPost = new AddPostFragment();

        addPost.show(getSupportFragmentManager(),"AddPost");
    }
}