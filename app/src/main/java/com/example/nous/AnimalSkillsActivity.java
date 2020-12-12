package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AnimalSkillsActivity extends AppCompatActivity {

    private ViewPager viewPagerAnimals;
    private PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_skills);

        List<Fragment> list = new ArrayList<>();
        list.add(new Animal1Fragment());
        list.add(new Animal2Fragment());

        viewPagerAnimals = findViewById(R.id.viewPagerAnimals);
        pagerAdapter = new AnimalSkillsAdapter(getSupportFragmentManager(), list);

        viewPagerAnimals.setAdapter(pagerAdapter);
    }
}