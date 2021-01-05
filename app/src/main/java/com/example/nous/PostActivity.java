package com.example.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class PostActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CommentAdapter commentAdapter;

    TextView tvPostTitle, tvPostContent, tvPostDate, tvUser;
    ImageView ivPostImg;
    String postKey;

    ArrayList<CommentModel> commentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        tvPostTitle = findViewById(R.id.tvPostTitle);
        tvPostContent = findViewById(R.id.tvPostContent);
        tvPostDate = findViewById(R.id.tvPostDate);
        tvUser = findViewById(R.id.tvUser);
        ivPostImg = findViewById(R.id.ivPostImg);

        String postTitle = getIntent().getExtras().getString("title");
        tvPostTitle.setText(postTitle);

        String postContent = getIntent().getExtras().getString("content");
        tvPostContent.setText(postContent);

        String postUser = getIntent().getExtras().getString("user");
        tvUser.setText(postUser);

        String postImage = getIntent().getExtras().getString("image");
        Glide.with(this).load(postImage).into(ivPostImg);

        String postDate = timestampToString(getIntent().getExtras().getLong("postTimeStamp"));
        tvPostDate.setText(postDate);

        postKey = getIntent().getExtras().getString("postKey");
        //set content

        recyclerView = findViewById(R.id.recyclerComment);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        DatabaseReference commentRef = FirebaseDatabase.getInstance().getReference("Comment").child(postKey);

        commentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                commentArrayList = new ArrayList<>();
                for (DataSnapshot snap:dataSnapshot.getChildren()) {
                    CommentModel comment = snap.getValue(CommentModel.class);
                    commentArrayList.add(comment) ;
                }

                commentAdapter = new CommentAdapter(getApplicationContext(), commentArrayList);
                recyclerView.setAdapter(commentAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }


    public void addComment(View view)
    {
        AddCommentFragment addCommentFragment = new AddCommentFragment();

        //pass post ID or information to AddCommentFragment.java
        String postID = postKey;
        Bundle b = new Bundle();
        b.putString("PostID", postID);
        addCommentFragment.setArguments(b);

        addCommentFragment.show(getSupportFragmentManager(),"AddComment");
    }

    private String timestampToString(long time) {

        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("dd-MM-yyyy",calendar).toString();
        return date;


    }

}