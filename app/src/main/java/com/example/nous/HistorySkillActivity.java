package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HistorySkillActivity extends AppCompatActivity {

    private ViewPager viewPagerAnimals;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_skill);

        List<Fragment> list = new ArrayList<>();
        list.add(new History1Fragment());
        list.add(new History2Fragment());

        viewPagerAnimals = findViewById(R.id.viewPagerHistory);
        pagerAdapter = new AnimalSkillsAdapter(getSupportFragmentManager(), list);

        viewPagerAnimals.setAdapter(pagerAdapter);
    }
}