package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ProgressBar expBar;

    private ViewPager viewPager;

    private ArrayList<HomeCardModel> modelArrayList;
    private HomeCardAdapter homeCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setExpBar();

        viewPager = findViewById(R.id.viewPagerHome);
        loadCards();

        //viewPager on change listener
        /*viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //when view page is scroll to another view page
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
    }

    public void setExpBar()
    {
        expBar = findViewById(R.id.expBar);

        expBar.setProgress(50);
    }

    public void loadCards()
    {
        modelArrayList = new ArrayList<>();

        //add item to the list
        modelArrayList.add(new HomeCardModel(
                "Welcome Back! Explorer!",
                "Select your Skills",
                "Swipe left to explore more skill and become master of Explorer!",
                R.drawable.ic_narrator));

        modelArrayList.add(new HomeCardModel(
                "Meow.... meowwwwww....",
                "Animals",
                "Welcome to the planet of Animals! Be prepared....",
                R.drawable.ic_animal));

        modelArrayList.add(new HomeCardModel(
                "Thinking...thinking..Thinking",
                "Science",
                "Shhhh.... Something 'explosive' is happening, do you hear it?",
                R.drawable.ic_science));

        modelArrayList.add(new HomeCardModel(
                "History.. is....wisdom..",
                "History",
                "When is now? Now is when? Where is this? Where are you?",
                R.drawable.ic_history));

        //set up adapter
        homeCardAdapter = new HomeCardAdapter(this, modelArrayList);
        //set adapter to viewpager
        viewPager.setAdapter(homeCardAdapter);

        viewPager.setPadding(125,0,155,0);
    }
}