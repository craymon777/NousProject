package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CommentAdapter commentAdapter;

    TextView tvPostTitle, tvPostContent, tvPostDate, tvUser;
    ImageView ivPostImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        tvPostTitle = findViewById(R.id.tvPostTitle);
        tvPostContent = findViewById(R.id.tvPostContent);
        tvPostDate = findViewById(R.id.tvPostDate);
        tvUser = findViewById(R.id.tvUser);

        //set content

        recyclerView = findViewById(R.id.recyclerComment);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        commentAdapter = new CommentAdapter(this, getCommentList());

        recyclerView.setAdapter(commentAdapter);
    }

    private ArrayList<CommentModel> getCommentList() {

        ArrayList<CommentModel> commentArrayList = new ArrayList<>();
        CommentModel m;

        m = new CommentModel();
        m.setUsername("Jay");
        m.setComment("I agree");
        m.setCommentDate("20/4/2020");
        commentArrayList.add(m);

        m = new CommentModel();
        m.setUsername("Jay");
        m.setComment("I agree");
        m.setCommentDate("20/4/2020");
        commentArrayList.add(m);

        m = new CommentModel();
        m.setUsername("Jay");
        m.setComment("I agree");
        m.setCommentDate("20/4/2020");
        commentArrayList.add(m);

        m = new CommentModel();
        m.setUsername("Jay");
        m.setComment("I agree");
        m.setCommentDate("20/4/2020");
        commentArrayList.add(m);




        return commentArrayList;
    }

    public void addComment(View view)
    {
        AddCommentFragment addCommentFragment = new AddCommentFragment();

        //pass post ID or information to AddCommentFragment.java
        String postID = "";
        Bundle b = new Bundle();
        b.putString("PostID", postID);
        addCommentFragment.setArguments(b);

        addCommentFragment.show(getSupportFragmentManager(),"AddComment");
    }
}