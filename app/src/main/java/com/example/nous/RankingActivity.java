package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RankingAdapter rankingAdapter;
    private ArrayList<Ranking> rankingArrayList;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private ImageView back_btn;
    private TextView badges_btn, profile_btn, forum_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        back_btn = findViewById(R.id.back);
        badges_btn = findViewById(R.id.badgesTab);
        profile_btn = findViewById(R.id.profileTab);
        forum_btn = findViewById(R.id.forumTab);

        badges_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RankingActivity.this, BadgesActivity.class);
                startActivity(intent);
            }
        });

        forum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RankingActivity.this, ForumActivity.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RankingActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        List<Fragment> list = new ArrayList();
        list.add(new RankingFragment());
        list.add(new masterboardFragment());

        pager = findViewById(R.id.rankingPager);
        pagerAdapter = new RankingPageAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);

//        recyclerView = findViewById(R.id.ranking_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        loadRankings();
//        sortArrayList();
    }

    public void sortArrayList(){

        Collections.sort(rankingArrayList);
        int counter = 1;
        for (Ranking i : rankingArrayList) {
            i.ranking = counter;
            counter++;
        }

        rankingAdapter.notifyDataSetChanged();
    }

    public void loadRankings(){

        rankingArrayList = new ArrayList<>();

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314528,
                rankingArrayList.size()+1));

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314524,
                rankingArrayList.size()+1));

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314530,
                rankingArrayList.size()+1));

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314556,
                rankingArrayList.size()+1));

        rankingAdapter = new RankingAdapter(this, rankingArrayList);
        //set adapter to recyclerView
        recyclerView.setAdapter(rankingAdapter);
    }
}