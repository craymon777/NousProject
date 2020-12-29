package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LearningAnimalActivity extends AppCompatActivity {

    String skill;
    int tree;
    int stage;

    ImageButton btnExit;

    TextView tvStageNum;
    LinearLayout layout1;
    TextView tvContentTitle1, tvContentTitle2, tvContentTitle3, tvContentTitle4, tvContentTitle5;
    TextView tvContent1, tvContent2, tvContent3, tvContent4, tvContent5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_animal);

        skill = getIntent().getStringExtra("skill");
        tree = getIntent().getIntExtra("tree",0);
        stage = getIntent().getIntExtra("stage",0);

        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tvStageNum = findViewById(R.id.tvStageNum);

        layout1 = findViewById(R.id.linLayContent1);

        tvContentTitle1 = findViewById(R.id.tvContentTitle1);
        tvContentTitle2 = findViewById(R.id.tvContentTitle2);
        tvContentTitle3 = findViewById(R.id.tvContentTitle3);
        tvContentTitle4 = findViewById(R.id.tvContentTitle4);
        tvContentTitle5 = findViewById(R.id.tvContentTitle5);

        tvContent1 = findViewById(R.id.tvContent1);
        tvContent2 = findViewById(R.id.tvContent2);
        tvContent3 = findViewById(R.id.tvContent3);
        tvContent4 = findViewById(R.id.tvContent4);
        tvContent5 = findViewById(R.id.tvContent5);

        setStageTitle();
    }

    private void setStageTitle() {
        if (skill.equals("animal") && tree == 1)
        {
            switch (stage)
            {
                case 1:
                    tvStageNum.setText("Chapter 1: First Step into Ocean");
                    break;
                case 2:
                    tvStageNum.setText("Chapter 2: Ocean is Fun");

                    tvContentTitle1.setText("Angelfish Mate for Life");
                    tvContent1.setText("When angelfish choose a partner, it’s for life! If one of them dies, the other one won’t breed with any other mate in their entire lifetime.");

                    tvContentTitle2.setText("Blue Whale’s Tongue");
                    tvContent2.setText("As the largest animal on earth, the full-grown blue whale is so heavy, just its tongue can weigh more than an entire elephant- that means that it can be heavier than 7,000 kilograms!");

                    tvContentTitle3.setText("Shark Teeth");
                    tvContent3.setText("Shark teeth are not really teeth, but scales. Because of this, if they ever lose a tooth, it will just grow back.");

                    tvContentTitle4.setText("Smallest Whale");
                    tvContent4.setText("The Harbor Porpoise is one of the smallest at ~5 feet when grown up.");

                    tvContentTitle5.setText("Seahorses");
                    tvContent5.setText("Seahorses are among the only species in which the male gives birth and takes care of the young.");

                    break;

                case 3:
                    tvStageNum.setText("Chapter 3: RUN!!");

                    tvContentTitle1.setText("Titan Triggerfish");
                    tvContent1.setText("Found in coral reefs everywhere from Australia to Thailand, the creatures will bite through divers' fins and flesh, and often even when they haven't been provoked.");

                    tvContentTitle2.setText("Flower Urchin");
                    tvContent2.setText("Don't let this sea urchin's beauty fool you. Each of its \"flowers\" is actually a tentacle with a little jaw (called a pedicellaria) that can inject toxic venoms and potentially kill you. ");

                    tvContentTitle3.setText("Electric Eel");
                    tvContent3.setText("Its body contains organs filled with nearly 6,000 electrolytes that store electricity like small batteries. When something gets close, the not-actually-an-eel will discharge volts of electricity and shock the intruder, sometimes to death.");

                    tvContentTitle4.setText("Blue-Ringed Octopus");
                    tvContent4.setText("This small sea creature has venom 1,000 times more powerful than cyanide, and at any given time it's carrying enough to kill 26 humans in just minutes.");

                    tvContentTitle5.setText("Pufferfish");
                    tvContent5.setText("Pufferfish, or blowfish, possess venom that's 1,200 times more poisonous than cyanide, making these little guys one of the most toxic animals in the world. ");

                    break;

                case 4:
                    tvStageNum.setText("Chapter 4: New World");

                    tvContentTitle1.setText("Sea Turtles");
                    tvContent1.setText("Sea turtles usually return to same beach used by their mothers to lay their eggs.");

                    tvContentTitle2.setText("Beluga Whales");
                    tvContent2.setText("Beluga whales have an adorable language of chirps and squeaks that have earned them the nickname \"canaries of the sea.\"");

                    tvContentTitle3.setText("Loudest Sound");
                    tvContent3.setText("At 188 decibels, the calls of blue whales is the loudest sound made by any animal on the planet.");

                    tvContentTitle4.setText("Oysters");
                    tvContent4.setText("Oysters can change from one gender to another and back again depending on which is best for mating.");

                    tvContentTitle5.setText("Sea Sponges");
                    tvContent5.setText("Sea sponges have no head, mouth, eyes, feelers, bones, heart, lungs, or brain, yet they are alive.");

                    break;

                case 5:
                    tvStageNum.setText("Chapter 5: Back to Origin");

                    tvContentTitle1.setText("Turtles");
                    tvContent1.setText("Turtles live on every continent except Antarctica.");

                    tvContentTitle2.setText("Japanese Spider Crab");
                    tvContent2.setText("The Japanese Spider Crab is the oldest crab of the world and is also believed to be the most deep-living crab as well as the one with the longest lifespan. It has a walking leg span of 3 to 4 m, which can go to 8 m when outstretched.");

                    tvContentTitle3.setText("Rock Bottom");
                    tvContent3.setText("The deepest part of the ocean is called Challenger Deep, and it is within the Mariana Trench, which is said to have a depth of around 36,000 feet, lying about a few hundred miles to the southwest of Guam.");

                    tvContentTitle4.setText("Boxfish");
                    tvContent4.setText("Boxfish are made out of bone box with holes only for eyes mouth and fins.");

                    tvContentTitle5.setText("Parasitic Isopods");
                    tvContent5.setText("Some types of parasitic isopods can enter fish through the gills and attach themselves to the tongue. The parasite causes the tongue of the fish to fall off and then serves as tongue-replacement.");

                    break;



            }
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnStartExplore:
                Intent intent = new Intent(this,Animal1Stage1Activity.class);
                intent.putExtra("skill", skill);
                intent.putExtra("tree", tree);
                intent.putExtra("stage", stage);
                startActivity(intent);
                break;

        }
    }
}