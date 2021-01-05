package com.example.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nous.Model.StageCompleted;
import com.example.nous.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class BadgesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private BadgeAdapter badgeAdapter;
    private ArrayList<Badge> badgeArrayList;
    private ImageView back_btn;
    private TextView forum_btn, profile_btn, ranking_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);

        back_btn = findViewById(R.id.back);
        ranking_btn = findViewById(R.id.rankingTab);
        profile_btn = findViewById(R.id.profileTab);
        forum_btn = findViewById(R.id.forumTab);


        forum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BadgesActivity.this, ForumActivity.class);
                startActivity(intent);
            }
        });

        ranking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BadgesActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BadgesActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadBadges();
    }


    public void loadBadges()
    {
        badgeArrayList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User currentUser = snapshot.getValue(User.class);
                if(currentUser.getBadgeCompletedCounter().get("badge1")==1)
                {
                    badgeArrayList.add(new Badge(
                            "Jungle King",
                            "Obtain by complete Animal skill",
                            R.drawable.lion, 1));
                }
                else
                {
                    badgeArrayList.add(new Badge(
                            "Jungle King",
                            "Obtain by complete Animal skill",
                            R.drawable.lion, 0));
                }
                if(currentUser.getBadgeCompletedCounter().get("badge2")==1)
                {
                    badgeArrayList.add(new Badge(
                            "Science Freak",
                            "Obtain by complete Science skill",
                            R.drawable.einstein, 1));
                }
                else
                {
                    badgeArrayList.add(new Badge(
                            "Science Freak",
                            "Obtain by complete Science skill",
                            R.drawable.einstein, 0));
                }
                if(currentUser.getBadgeCompletedCounter().get("badge3")==1)
                {
                    badgeArrayList.add(new Badge(
                            "Historian",
                            "Obtain by complete History skill",
                            R.drawable.ic_explorer, 1));
                }
                else
                {
                    badgeArrayList.add(new Badge(
                            "Historian",
                            "Obtain by complete History skill",
                            R.drawable.ic_explorer, 0));
                }
                if(currentUser.getBadgeCompletedCounter().get("badge4")==1)
                {
                    badgeArrayList.add(new Badge(
                            "God of knowledge",
                            "Complete all skills",
                            R.drawable.ra, 1));
                }
                else
                {
                    badgeArrayList.add(new Badge(
                            "God of knowledge",
                            "Complete all skills",
                            R.drawable.ra, 0));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        badgeAdapter = new BadgeAdapter(this, badgeArrayList);
        //set adapter to recyclerView
        recyclerView.setAdapter(badgeAdapter);


    }

}