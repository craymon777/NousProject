package com.example.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nous.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Button btnLogout;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    ProgressBar expBar;

    private ViewPager viewPager;
    private ImageView lBoard_btn;
    private ImageView badges_btn;
    private ImageView forum_btn;
    private ImageView profile_btn;
    private ImageView profile_pic;
    private TextView username;
    private TextView userLevel;
    private TextView tvExperience;
    private ArrayList<HomeCardModel> modelArrayList;
    private HomeCardAdapter homeCardAdapter;
    private Integer experiencePoint;
    private Integer uLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //---------log out section-----------
        auth = FirebaseAuth.getInstance();

        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });
        //---------log out section-----------

        username = findViewById(R.id.tvUsername);
        userLevel = findViewById(R.id.tvUserLevel);
        profile_pic = findViewById(R.id.ProfilePicture);
        tvExperience = findViewById(R.id.tvExperience);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User currentUser = snapshot.getValue(User.class);
                username.setText(currentUser.getName());
                experiencePoint = currentUser.getExperientPoint();
                uLevel = experiencePoint/100;
                Integer expMod = mod(experiencePoint,100);
                userLevel.setText("Level:" + uLevel.toString());
                tvExperience.setText(expMod.toString());
                setExpBar(expMod);
                if(currentUser.getProfilePictureUrl().isEmpty())
                {
                    Glide.with(HomeActivity.this).load(R.drawable.ic_explorer).into(profile_pic);
                }
                else
                {
                    Glide.with(HomeActivity.this).load(currentUser.getProfilePictureUrl()).into(profile_pic);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lBoard_btn = findViewById(R.id.imgLeaderboard);
        lBoard_btn.setClickable(true);

        badges_btn = findViewById(R.id.imgBadge);
        badges_btn.setClickable(true);

        profile_btn = findViewById(R.id.imgProfile);
        profile_btn.setClickable(true);

        forum_btn = findViewById(R.id.imgForum);
        forum_btn.setClickable(true);

        viewPager = findViewById(R.id.viewPagerHome);
        loadCards();

        lBoard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });

        badges_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BadgesActivity.class);
                startActivity(intent);
            }
        });

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        forum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ForumActivity.class);
                startActivity(intent);
            }
        });


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

    public Integer mod(Integer x, Integer y)
    {
        Integer result = x % y;
        if (result < 0)
            result = result + y;
        return result;
    }

    public void setExpBar(Integer exp)
    {
        expBar = findViewById(R.id.expBar);

        expBar.setProgress(exp);
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