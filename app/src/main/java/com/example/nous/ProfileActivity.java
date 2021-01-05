package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ProfilePagerAdapter profilePagerAdapter;
    private ImageView back_btn;
    private TextView badges_btn, forum_btn, leadership_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        badges_btn = findViewById(R.id.badgesTab);
        forum_btn = findViewById(R.id.forumTab);
        leadership_btn = findViewById(R.id.rankingTab);
        back_btn = findViewById(R.id.back);

        forum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ForumActivity.class);
                startActivity(intent);
            }
        });

        badges_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, BadgesActivity.class);
                startActivity(intent);
            }
        });

        leadership_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        List<Fragment> list = new ArrayList();
        list.add(new ProfileFragment());

        viewPager = findViewById(R.id.viewPager);
        profilePagerAdapter = new ProfilePagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(profilePagerAdapter);
    }
}
