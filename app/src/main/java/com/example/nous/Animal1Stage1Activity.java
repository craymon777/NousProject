package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal1Stage1Activity extends AppCompatActivity {

    FirebaseFirestore database;

    String skill;
    int tree;
    int stage;

    ProgressBar questProgress;

    //timer and freezer
    CountDownTimer timer;
    TextView tvTimer;
    private long timerDuration = 3000; //milliseconds
    ImageView ivFreeze;
    ImageButton imgBtnFreezer;


    TextView tvQuestion, tvOption1, tvOption2, tvOption3, tvOption4;
    ImageView ivQuestion;

    Button btnCheck;

    ArrayList<Question> questionsArray;
    Question question;
    int index = 0;
    int numOfCorrectAns = 0;

    TextView selected = null;
    String selectedAnswer = "";

    ImageView ivCloud;

    ImageButton imgBtnTips;
    ArrayList<String> tipsArray;
    String currentTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal1_stage1);

        tvTimer = findViewById(R.id.tvTimer);
        tvTimer.setText("50");
        ivFreeze = findViewById(R.id.ivFreeze);
        imgBtnFreezer = findViewById(R.id.imgBtnFreezer);

        questionsArray = new ArrayList<>();

        questProgress = findViewById(R.id.questProgress);
        questProgress.setProgress(index);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvOption1 = findViewById(R.id.tvOption1);
        tvOption2 = findViewById(R.id.tvOption2);
        tvOption3 = findViewById(R.id.tvOption3);
        tvOption4 = findViewById(R.id.tvOption4);
        ivQuestion = findViewById(R.id.ivQuestion);

        btnCheck = findViewById(R.id.btnCheck);

        ivCloud = findViewById(R.id.ivCloud);

        imgBtnTips = findViewById(R.id.imgBtnTips);
        tipsArray = new ArrayList<>();

        populateQuestions();
        questProgress.setMax(questionsArray.size());

        setNextQuestion();
    }



    void resetTimer()
    {
        if (timer!=null)
            timer.cancel();

        timer = new CountDownTimer(timerDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // set timer text here
                int secondsLeft = (int) millisUntilFinished / 1000;

                String timerText = "" + secondsLeft;

                tvTimer.setText(timerText);
            }

            @Override
            public void onFinish() {
                timeUp();
            }
        }.start();
    }

    private void timeUp()
    {
        showCorrectAnswer();
        Toast.makeText(this,"Times UP!",Toast.LENGTH_SHORT).show();
        btnCheck.setText("Continue");
        btnCheck.setBackground(getDrawable(R.drawable.bg_continue));
    }

    private void populateQuestions() {

        skill = getIntent().getStringExtra("skill");
        tree = getIntent().getIntExtra("tree",0);
        stage = getIntent().getIntExtra("stage",0);

        if (skill.equals("animal") && tree == 1 && stage == 1)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("animal") && tree == 1 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("animal") && tree == 1 && stage == 3)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("animal") && tree == 1 && stage == 4)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("animal") && tree == 1 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("animal") && tree == 2 && stage == 1)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 3)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 4)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("science") && tree == 1 && stage == 1)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("science") && tree == 1 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("science") && tree == 1 && stage == 3)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("science") && tree == 1 && stage == 4)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("science") && tree == 1 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("science") && tree == 2 && stage == 1)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("science") && tree == 2 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("science") && tree == 2 && stage == 3)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("science") && tree == 2 && stage == 4)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("science") && tree == 2 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("history") && tree == 1 && stage == 1)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("history") && tree == 1 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("history") && tree == 1 && stage == 3)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("history") && tree == 1 && stage == 4)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("history") && tree == 1 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");
        }
        else if (skill.equals("history") && tree == 2 && stage == 1)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("history") && tree == 2 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("history") && tree == 2 && stage == 3)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("history") && tree == 2 && stage == 4)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else if (skill.equals("history") && tree == 2 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What is the percentage of salt water on Earth?",
                    "1%",
                    "50%",
                    "72%",
                    "27%",
                    "72%",
                    R.drawable.ic_earth));
            tipsArray.add("With over 72% of the Earth’s surface covered by salt water, the Earth’s oceans are home to 230,000 known species.");

            questionsArray.add(new Question(
                    "How many years has been Jellyfish existed?",
                    "1 year",
                    "200 year",
                    "650 year",
                    "650 million year",
                    "650 million year",
                    R.drawable.ic_jellyfish));
            tipsArray.add("650 million year");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("Blue");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("Whale Shark");

        }
        else
        {
            questionsArray.add(new Question(
                    "Default",
                    "Bee",
                    "Bee Humingbird",
                    "swallow",
                    "jhin",
                    "Bee",
                    R.drawable.q_bird));

            questionsArray.add(new Question(
                    "Default",
                    "Orstrict",
                    "Bee Humingbird",
                    "swallow",
                    "eagle",
                    "Orstrict",
                    R.drawable.ic_tiger));

            questionsArray.add(new Question(
                    "Default",
                    "Orstrict",
                    "Bee Humingbird",
                    "swallow",
                    "eagle",
                    "Orstrict",
                    R.drawable.ic_tiger));

            questionsArray.add(new Question(
                    "Default",
                    "Orstrict",
                    "Bee Humingbird",
                    "swallow",
                    "eagle",
                    "Orstrict",
                    R.drawable.ic_tiger));

            questionsArray.add(new Question(
                    "Default",
                    "Orstrict",
                    "Bee Humingbird",
                    "swallow",
                    "eagle",
                    "Orstrict",
                    R.drawable.ic_tiger));

        }


    }



    void setNextQuestion()
    {
        if (index < questionsArray.size())
        {
            resetQuestionBackground();
            question = questionsArray.get(index);
            currentTips = tipsArray.get(index);

            tvQuestion.setText(question.getQuestion());
            tvOption1.setText(question.getOption1());
            tvOption2.setText(question.getOption2());
            tvOption3.setText(question.getOption3());
            tvOption4.setText(question.getOption4());

            ivQuestion.setImageResource(question.getQuestImage());

            questProgress.setProgress(index);
            index++;

            //hide tips button
            imgBtnTips.setVisibility(View.GONE);

            //remove freezing and freezer button
            removeFreeze();

            //probability for cloud coming
            if (generateRandom(5))
                resetCloud();

            if (generateRandom(1))
                imgBtnFreezer.setVisibility(View.VISIBLE);

            resetTimer();

        }
        else
        {
            quizFinish();
        }
    }

    private void resetQuestionBackground() {
        tvOption1.setBackground(getDrawable(R.drawable.option_unselect));
        tvOption2.setBackground(getDrawable(R.drawable.option_unselect));
        tvOption3.setBackground(getDrawable(R.drawable.option_unselect));
        tvOption4.setBackground(getDrawable(R.drawable.option_unselect));
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnExit:
                finish();
                break;

            case R.id.btnSkip:
                if (index < questionsArray.size())
                {
                    if (btnCheck.getText().toString().equals("Continue"))
                    {
                        break;
                    }
                    setNextQuestion();
                }
                else
                {
                    Toast.makeText(this, "Last Question",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.tvOption1:
            case R.id.tvOption2:
            case R.id.tvOption3:
            case R.id.tvOption4:
                if (btnCheck.getText().toString().equals("Continue"))
                    break;

                selected = (TextView) view;
                selectedAnswer = selected.getText().toString();

                resetQuestionBackground();

                selected.setBackground(getDrawable(R.drawable.option_selected));
                break;

            case R.id.btnCheck:
                if (btnCheck.getText().toString().equals("Continue"))
                {
                    selected = null;
                    selectedAnswer = "";
                    setNextQuestion();
                    btnCheck.setText("Check");
                    btnCheck.setBackground(getDrawable(R.drawable.trees_button));
                    break;
                }
                if (selected == null) {
                    Toast.makeText(this,"No Answer is Selected!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    checkAnswer();
                    Toast.makeText(this,"checked",Toast.LENGTH_SHORT).show();
                    btnCheck.setText("Continue");
                    btnCheck.setBackground(getDrawable(R.drawable.bg_continue));
                }
                break;

        }


    }

    private void checkAnswer() {

        if (timer!=null)
            timer.cancel();

        if (selectedAnswer.equals(question.getAnswer()))
        {
            selected.setBackground(getDrawable(R.drawable.option_correct));
            numOfCorrectAns++;
        }
        else
        {
            selected.setBackground(getDrawable(R.drawable.option_wrong));
            showCorrectAnswer();
        }
    }

    private void showCorrectAnswer() {
        String correctAnswer = question.getAnswer();
        if (tvOption1.getText().toString().equals(correctAnswer))
            tvOption1.setBackground(getDrawable(R.drawable.option_correct));

        else if (tvOption2.getText().toString().equals(correctAnswer))
            tvOption2.setBackground(getDrawable(R.drawable.option_correct));

        else if (tvOption3.getText().toString().equals(correctAnswer))
            tvOption3.setBackground(getDrawable(R.drawable.option_correct));

        else if (tvOption4.getText().toString().equals(correctAnswer))
            tvOption4.setBackground(getDrawable(R.drawable.option_correct));


        imgBtnTips.setVisibility(View.VISIBLE);
    }

    long animationDuration = 1500;

    public void blowCloudHandler(View view)
    {
        //animator for position
        ObjectAnimator animatorTranslate = ObjectAnimator.ofFloat(ivCloud, "x", -1500f);
        animatorTranslate.setDuration(animationDuration);

        //animator for alpha
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(ivCloud,View.ALPHA,1.0f, 0.0f);
        alphaAnimator.setDuration(animationDuration);

        AnimatorSet cloudBlow = new AnimatorSet();
        cloudBlow.playTogether(animatorTranslate, alphaAnimator);
        cloudBlow.start();

    }

    private boolean generateRandom(int probability)
    {
        int random = new Random().nextInt(10);
        int res = probability - random;

        if (res>0)
            return true;
        else
            return false;

    }

    private void resetCloud()
    {
        ivCloud.setVisibility(View.VISIBLE);
        ObjectAnimator animatorTranslate = ObjectAnimator.ofFloat(ivCloud, "x", 0);
        animatorTranslate.setDuration(animationDuration);

        //animator for alpha
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(ivCloud,View.ALPHA,0.0f, 1.0f);
        alphaAnimator.setDuration(animationDuration);

        AnimatorSet cloudBlow = new AnimatorSet();
        cloudBlow.playTogether(animatorTranslate, alphaAnimator);
        cloudBlow.start();
    }

    public void freezing(View view)
    {
        if (timer != null)
            timer.cancel();

        ivFreeze.setVisibility(View.VISIBLE);

        //animator for alpha
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(ivFreeze,View.ALPHA,0.0f, 0.7f);
        alphaAnimator.setDuration(animationDuration);

        AnimatorSet freezingAnimator = new AnimatorSet();
        freezingAnimator.play(alphaAnimator);
        freezingAnimator.start();
    }

    private void removeFreeze()
    {
        ivFreeze.setVisibility(View.GONE);
        imgBtnFreezer.setVisibility(View.GONE);
    }

    public void showTips(View view)
    {
        Toast.makeText(this,"Tips!",Toast.LENGTH_SHORT).show();

        //create an instance of tips fragment
        PopoupTipsFragment tipsFragment = new PopoupTipsFragment();

        //send current tips to the tips fragment
        Bundle b = new Bundle();
        b.putString("TipsValue", currentTips);
        tipsFragment.setArguments(b);

        //show the tips fragment
        tipsFragment.show(getSupportFragmentManager(),"TipsFragment");

    }

    public void quizFinish()
    {
        Intent intent = new Intent(this, SkillCompletedActivity.class);
        intent.putExtra("correct", numOfCorrectAns);
        intent.putExtra("totalQuestion", questionsArray.size());
        intent.putExtra("skill", skill);
        intent.putExtra("tree", tree);
        intent.putExtra("stage", stage);
        startActivity(intent);
        finish();
    }
}