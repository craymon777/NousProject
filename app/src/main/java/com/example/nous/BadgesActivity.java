package com.example.nous;

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

import java.util.ArrayList;

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

        badgeArrayList.add(new Badge(
           "Jungle King",
            "Obtain by complete Animal skill",
                R.drawable.lion, 0));

        badgeArrayList.add(new Badge(
                "Science Freak",
                "Obtain by complete Science skill",
                R.drawable.einstein, 0));

        badgeArrayList.add(new Badge(
                "Historian",
                "Obtain by complete History skill",
                R.drawable.ic_explorer, 1));

        badgeArrayList.add(new Badge(
                "Bolt",
                "Complete a stage within a minute",
                R.drawable.ic_streak, 1));

        badgeArrayList.add(new Badge(
                "Blower",
                "Use fan trice in a stage",
                R.drawable.fan, 1));

        badgeArrayList.add(new Badge(
                "God of knowledge",
                "Complete all skills",
                R.drawable.ra, 0));

        badgeArrayList.add(new Badge(
                "Unstoppable",
                "20 win streaks",
                R.drawable.ic_badge, 1));

        badgeAdapter = new BadgeAdapter(this, badgeArrayList);
        //set adapter to recyclerView
        recyclerView.setAdapter(badgeAdapter);


    }

}