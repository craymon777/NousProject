package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ForumActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        recyclerView = findViewById(R.id.recyclerPost);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postAdapter = new PostAdapter(this, getPostList());

        recyclerView.setAdapter(postAdapter);

    }

    private ArrayList<PostModel> getPostList()
    {
        ArrayList<PostModel> postArrayList = new ArrayList<>();
        PostModel m;

        m = new PostModel();
        m.setPostTitle("How ARre you?");
        m.setPostDate("20/4/2020");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);

        m = new PostModel();
        m.setPostTitle("How ARe you?");
        m.setPostDate("20/4/2020");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);

        m = new PostModel();
        m.setPostTitle("How ARe you?");
        m.setPostDate("20/4/2020");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);

        m = new PostModel();
        m.setPostTitle("How ARe you?");
        m.setPostDate("20/4/2020");
        m.setPostImg(R.drawable.ic_explorer);
        postArrayList.add(m);


        return postArrayList;
    }
}