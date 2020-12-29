package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ScienceSkillActivity extends AppCompatActivity {

    private ViewPager viewPagerScience;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_skill);

        List<Fragment> list = new ArrayList<>();
        list.add(new Science1Fragment());
        list.add(new Science2Fragment());

        viewPagerScience = findViewById(R.id.viewPagerScience);
        pagerAdapter = new AnimalSkillsAdapter(getSupportFragmentManager(), list);

        viewPagerScience.setAdapter(pagerAdapter);
    }
}