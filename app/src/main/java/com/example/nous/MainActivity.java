package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpTest;

    private ArrayList<HomeCardModel> modelArrayList;
    private HomeCardAdapter homeCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpTest = findViewById(R.id.vpTest);
    }
}