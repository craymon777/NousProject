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
    private long timerDuration = 45000; //milliseconds
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
            tipsArray.add("Jellyfish have been around for more than 650 million years, which means that they outdate both dinosaurs and sharks.");

            questionsArray.add(new Question(
                    "What is the color of octopus's blood?",
                    "Blue",
                    "Red",
                    "Yellow",
                    "Black",
                    "Blue",
                    R.drawable.ic_octopus));
            tipsArray.add("An Octopus has three hearts and the color of its blood is blue.");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_dolphin));
            tipsArray.add("Dolphins sleep with only half of their brain and with one eye open so they can watch for predators.");

            questionsArray.add(new Question(
                    "What is the largest fish in ocean?",
                    "Whale Shark",
                    "Blue Whale",
                    "Gold Fish",
                    "Protected by human",
                    "Whale Shark",
                    R.drawable.whale));
            tipsArray.add("The biggest fish in the ocean is the whale shark. Whale sharks may grow up to 40 feet and weigh as much as 40 tons by some estimates.");
        }

        else if (skill.equals("animal") && tree == 1 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What will an angelfish do when its partner dies?",
                    "Wont breed with another mate",
                    "Find another mate",
                    "Pray for it",
                    "None of above",
                    "Wont breed with another mate",
                    R.drawable.ic_angelfish));
            tipsArray.add("When angelfish choose a partner, it’s for life! If one of them dies, the other one won’t breed with any other mate in their entire lifetime.");

            questionsArray.add(new Question(
                    "What is the weight of Blue Whale’s tongue?",
                    "10 kg",
                    "1000 kg",
                    "7000 kg",
                    "700 kg",
                    "7000 kg",
                    R.drawable.ic_bluewhale));
            tipsArray.add("Its tongue can weigh more than an entire elephant- that means that it can be heavier than 7,000 kilograms!");

            questionsArray.add(new Question(
                    "What will shark do when it lose a tooth?",
                    "It will grow back",
                    "It will find a replacement",
                    "It cannot bite anymore",
                    "It lost forever",
                    "It will grow back",
                    R.drawable.ic_shark));
            tipsArray.add("Shark teeth are not really teeth, but scales. Because of this, if they ever lose a tooth, it will just grow back.");

            questionsArray.add(new Question(
                    "What is the length of smallest whale?",
                    "100 feet",
                    "1 feet",
                    "20 feet",
                    "5 feet",
                    "5 feet",
                    R.drawable.ic_smallwhale));
            tipsArray.add("The Harbor Porpoise is one of the smallest at ~5 feet when grown up.");

            questionsArray.add(new Question(
                    "What is the only species with male take care of young?",
                    "Whale Shark",
                    "Blue Whale",
                    "Seahorse",
                    "Gold Fish",
                    "Seahorse",
                    R.drawable.ic_takecare));
            tipsArray.add("Seahorses are among the only species in which the male gives birth and takes care of the young.");
        }
        else if (skill.equals("animal") && tree == 1 && stage == 3)
        {
            questionsArray.add(new Question(
                    "What will Titan Triggerfish do with divers?",
                    "Play with human",
                    "Bite through divers' fins and flesh",
                    "Run away from divers",
                    "Do not do anything",
                    "Bite through divers' fins and flesh",
                    R.drawable.ic_triggerfish));
            tipsArray.add("Titan Triggerfish will bite through divers' fins and flesh, and often even when they haven't been provoked.");

            questionsArray.add(new Question(
                    "What does tentacle of Flower Urchin contain",
                    "Poison",
                    "Flower",
                    "Food",
                    "Sea Water",
                    "Poison",
                    R.drawable.ic_urchin));
            tipsArray.add("Don't let this sea urchin's beauty fool you. Its tentacle with a little jaw can inject toxic venoms and potentially kill you.");

            questionsArray.add(new Question(
                    "How many electrolytes in an Electric Eel?",
                    "50",
                    "600",
                    "6000",
                    "600000",
                    "6000",
                    R.drawable.ic_eel));
            tipsArray.add("Its body contains organs filled with nearly 6,000 electrolytes that will discharge volts of electricity and shock the intruder");

            questionsArray.add(new Question(
                    "How many human can a Blue-Ringed Octopus kill instantly?",
                    "1",
                    "0",
                    "62",
                    "26",
                    "26",
                    R.drawable.ic_blueoctopus));
            tipsArray.add("Blue-Ringed Octopus has venom 1,000 times more powerful than cyanide, it can kill 26 humans in just minutes.");

            questionsArray.add(new Question(
                    "How many times a Pufferfish more poisonous than cyanide?",
                    "12",
                    "120",
                    "1200",
                    "12000",
                    "1200",
                    R.drawable.ic_pufferfish));
            tipsArray.add("Pufferfish, or blowfish, possess venom that's 1,200 times more poisonous than cyanide.");
        }
        else if (skill.equals("animal") && tree == 1 && stage == 4)
        {
            questionsArray.add(new Question(
                    "Where will Sea Turtles lay their eggs?",
                    "South Beach",
                    "North beach",
                    "Any beach",
                    "Same beach used by their mothers",
                    "Same beach used by their mothers",
                    R.drawable.ic_seaturtle));
            tipsArray.add("Sea turtles usually return to same beach used by their mothers to lay their eggs.");

            questionsArray.add(new Question(
                    "What is the nickname for Beluga Whales?",
                    "Baby of the sea",
                    "Canaries of the sea",
                    "Adult of the sea",
                    "Music of the sea",
                    "Canaries of the sea",
                    R.drawable.ic_smallwhale));
            tipsArray.add("Beluga whales have an adorable language of chirps and squeaks that have earned them the nickname \"canaries of the sea.\"");

            questionsArray.add(new Question(
                    "What do Sea Sponges missing?",
                    "Head",
                    "Mouth",
                    "Eyes",
                    "All of above",
                    "All of above",
                    R.drawable.ic_bluewhale));
            tipsArray.add("At 188 decibels, the calls of blue whales is the loudest sound made by any animal on the planet.");

            questionsArray.add(new Question(
                    "How does dolphin stay away from threats when sleeping?",
                    "Does not sleep",
                    "Sleep with half of brain",
                    "Look for Shelter",
                    "Protected by human",
                    "Sleep with half of brain",
                    R.drawable.ic_seasponge));
            tipsArray.add("Sleep with half of brain");

            questionsArray.add(new Question(
                    "What can an Oyster do?",
                    "Do not need oxygen",
                    "Eat infinitely",
                    "Change from one gender to another",
                    "Have two genders at same time",
                    "Change from one gender to another",
                    R.drawable.ic_oyster));
            tipsArray.add("Oysters can change from one gender to another and back again depending on which is best for mating.");
        }
        else if (skill.equals("animal") && tree == 1 && stage == 5)
        {
            questionsArray.add(new Question(
                    "Turtles do not live in which continent?",
                    "Africa",
                    "Americas",
                    "Antarctica",
                    "Australia",
                    "Antarctica",
                    R.drawable.ic_seaturtle));
            tipsArray.add("Turtles live on every continent except Antarctica.");

            questionsArray.add(new Question(
                    "What is the oldest crab in the world?",
                    "Japanese Spider Crab",
                    "Americas Spider Crab",
                    "Australia Spider Crab",
                    "Africa Spider Crab",
                    "Japanese Spider Crab",
                    R.drawable.ic_crab));
            tipsArray.add("The Japanese Spider Crab is the oldest crab of the world.");

            questionsArray.add(new Question(
                    "What is the deepest part of the ocean?",
                    "Mountain Deep",
                    "Challenger Deep",
                    "Not that Deep",
                    "Fighting Deep",
                    "Challenger Deep",
                    R.drawable.ic_deepsea));
            tipsArray.add("The deepest part of the ocean is called Challenger Deep, and it is within the Mariana Trench, which have a depth of around 36,000 feet.");

            questionsArray.add(new Question(
                    "How do Parasitic Isopods enter a fish?",
                    "Through the gills",
                    "Through the mouth",
                    "Through the eyes",
                    "Through the nose",
                    "Through the gills",
                    R.drawable.ic_parasite));
            tipsArray.add("Some types of parasitic isopods can enter fish through the gills and attach themselves to the tongue.");

            questionsArray.add(new Question(
                    "What will Parasitic Isopods do to fish tongue?",
                    "Clean the tongue",
                    "Do nothing",
                    "Cause it to fall off",
                    "Bring nutrients",
                    "Cause it to fall off",
                    R.drawable.ic_parasite));
            tipsArray.add("The parasite causes the tongue of the fish to fall off and then serves as tongue-replacement.");
        }
        else if (skill.equals("animal") && tree == 2 && stage == 1)
        {
            questionsArray.add(new Question(
                    "What can Flying Squirrels do?",
                    "Fly",
                    "Glide",
                    "Swim",
                    "None of above",
                    "Glide",
                    R.drawable.ic_flyingsquirrel));
            tipsArray.add("Although most animals (other than birds) don't actually fly, they glide, including Flying Squirrels.");

            questionsArray.add(new Question(
                    "What is the only Flying Mammal?",
                    "Flying Squirrels",
                    "Flying Fish",
                    "Flying Lizards",
                    "Flying Foxes",
                    "Flying Foxes",
                    R.drawable.ic_fly));
            tipsArray.add("Flying foxes are actually fruit bats, and yes, they can fly. Bats are the only mammal that can do so.");

            questionsArray.add(new Question(
                    "What is the fastest flying speed of bat?",
                    "50mph",
                    "1mph",
                    "100mph",
                    "10mph",
                    "100mph",
                    R.drawable.ic_bat));
            tipsArray.add("How fast a bat flies depends on the species, but they can reach speeds over 100 miles per hour according to new research.");

            questionsArray.add(new Question(
                    "What is the world largest bat?",
                    "Egyptian Fruit Bat",
                    "Flying Foxes",
                    "Honduran White Bat",
                    "Hoary Bat",
                    "Flying Foxes",
                    R.drawable.ic_bat1));
            tipsArray.add("The world’s largest bat is the flying fox that lives on islands in the South Pacific. It has a wingspan of up to 6 feet.");

            questionsArray.add(new Question(
                    "What is the world smallest bat?",
                    "Egyptian Fruit Bat",
                    "Honduran White Bat",
                    "Bumble Bee Bat",
                    "Hoary Bat",
                    "Bumble Bee Bat",
                    R.drawable.ic_bat2));
            tipsArray.add("The world’s smallest bat is the bumble bee bat of Thailand, which is smaller than a thumbnail and weighs less than a penny.");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is the smallest bird in the world?",
                    "Parrots",
                    "Bee Hummingbird",
                    "Swallow",
                    "Eagle",
                    "Bee Hummingbird",
                    R.drawable.ic_hummingbird));
            tipsArray.add("The smallest bird is the bee hummingbird (Mellisuga helenae) of Cuba and the Isle of Youth. Males measure 57 mm (2.24 in) in total length.");

            questionsArray.add(new Question(
                    "What is the largest bird in the world?",
                    "Ostrich",
                    "Eagle",
                    "Wandering Albatross",
                    "Falcon",
                    "Ostrich",
                    R.drawable.ic_bigbird));
            tipsArray.add("The common ostrich is the biggest bird in the world.It’s both the tallest and heaviest, with an average height of over 2 meters.");

            questionsArray.add(new Question(
                    "What is the slowest flying bird in the world?",
                    "Wandering Albatross",
                    "Falcon",
                    "American Woodcock",
                    "Swallow",
                    "American Woodcock",
                    R.drawable.ic_bigbird));
            tipsArray.add("The American woodcock (Scolopax minor) and the Eurasian woodcock (S. Rusticola) have both been timed lying at 5 mph.");

            questionsArray.add(new Question(
                    "What is the fastest flying bird in the world?",
                    "Ostrich",
                    "Peregrine Falcon",
                    "Wandering Albatross",
                    "Eagle",
                    "Peregrine Falcon",
                    R.drawable.ic_bigbird));
            tipsArray.add("The peregrine falcon (Falco peregrinus) is the fastest living creature, reaching speeds of at least 124 mph and possibly as much as 168.");

            questionsArray.add(new Question(
                    "What is the largest flying bird in the world?",
                    "Peregrine Falcon",
                    "Ostrich",
                    "Eagle",
                    "Wandering Albatross",
                    "Wandering Albatross",
                    R.drawable.ic_bigbird));
            tipsArray.add("There are 23 species of albatrosses, though the largest is the Wandering Albatross. This bird has a 11-foot (3.4 meter) wingspan.");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 3)
        {
            questionsArray.add(new Question(
                    "How many species of bird in the world?",
                    "950",
                    "9,500",
                    "5",
                    "95",
                    "9,500",
                    R.drawable.ic_bird));
            tipsArray.add("There are over 9,500 species of birds in the world. Scientists typically group them into 30 categories.");

            questionsArray.add(new Question(
                    "Where does 2/3 of bird species found?",
                    "Tropical Rain Forests",
                    "Pond",
                    "Dessert",
                    "River Bank",
                    "Tropical Rain Forests",
                    R.drawable.ic_bird1));
            tipsArray.add("Approximately 2/3 of all the bird species are found in tropical rain forests.");

            questionsArray.add(new Question(
                    "How much do lungs of birds take up of their body?",
                    "1/10",
                    "1/2",
                    "1/5",
                    "1/3",
                    "1/5",
                    R.drawable.ic_bird2));
            tipsArray.add("A bird’s lungs are much more complicated and efficient and take up more space than those of mammals, such as humans. A bird’s takes up 1/5.");

            questionsArray.add(new Question(
                    "What is the most talkative bird?",
                    "Ostrich",
                    "Swallow",
                    "Eagle",
                    "African Gray Parrot",
                    "African Gray Parrot",
                    R.drawable.ic_bird3));
            tipsArray.add("The most talkative bird in the world is the African Gray Parrot. One parrot could say over 800 words.");

            questionsArray.add(new Question(
                    "How long an Emu Chick take to hatch an egg?",
                    "60 days",
                    "6 days",
                    "10 days",
                    "100 days",
                    "60 days",
                    R.drawable.ic_egg));
            tipsArray.add("Emu Chicks take 60 days to hatch. Small songbirds take just 2 weeks.");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 4)
        {
            questionsArray.add(new Question(
                    "How many feathers does Whistling Swan have?",
                    "1",
                    "25000",
                    "250",
                    "25",
                    "25000",
                    R.drawable.ic_swan));
            tipsArray.add("The bird with the most feathers is the Whistling Swan, with up to 25,000 feathers.");

            questionsArray.add(new Question(
                    "How many feathers do Hummingbirds have",
                    "1000",
                    "500000",
                    "100000",
                    "50",
                    "1000",
                    R.drawable.ic_hummingbird));
            tipsArray.add("Hummingbirds are so small that they have fewer than 1,000.");

            questionsArray.add(new Question(
                    "How fast can Gentoo Penguins swim?",
                    "2 mph",
                    "12 mph",
                    "102 mph",
                    "22 mph",
                    "22 mph",
                    R.drawable.ic_octopus));
            tipsArray.add("Gentoo Penguins are the fastest swimming birds, reaching speeds of 22 mph (36 kph).");

            questionsArray.add(new Question(
                    "How long can a Wandering Albatross live?",
                    "8 years",
                    "800 years",
                    "80 years",
                    "1 year",
                    "80 years",
                    R.drawable.ic_albatross));
            tipsArray.add("The larger the bird, the more likely it is to live longer. The large Wandering Albatross can live for up to 80 years.");

            questionsArray.add(new Question(
                    "When will Emperor Penguin lay egg?",
                    "Start of Winter",
                    "Middle of Winter",
                    "End of Winter",
                    "Middle of Summer",
                    "Middle of Winter",
                    R.drawable.ic_penguin));
            tipsArray.add("The Emperor Penguin is the only bird that lays its eggs in the middle of winter. By laying its eggs so early, it gives its young a head start.");

        }
        else if (skill.equals("animal") && tree == 2 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What do Oilbirds eat?",
                    "Oil Palm Fruits",
                    "Orange",
                    "Apple",
                    "Coconut",
                    "Oil Palm Fruits",
                    R.drawable.ic_bird1));
            tipsArray.add("Oilbirds eat oil palm fruits, which make the birds oily too.");

            questionsArray.add(new Question(
                    "What will lighthouse cause to bird?",
                    "Does not do anything",
                    "Give signal",
                    "Attract birds and kill them",
                    "Show direction",
                    "Attract birds and kill them",
                    R.drawable.ic_lighthouse));
            tipsArray.add("Lighthouses are dangerous for birds. The beams attract birds, many are killed when they fly into the glass.");

            questionsArray.add(new Question(
                    "How many people in the team that develop Angry Bird?",
                    "10",
                    "40",
                    "1",
                    "4",
                    "4",
                    R.drawable.ic_angrybird));
            tipsArray.add("The game Angry Birds has sold more than 7 million copies on Apple’s iPhone. The game was made by a team of just four people.");

            questionsArray.add(new Question(
                    "What can a pigeon do?",
                    "Recognise Individual Human Faces",
                    "Learn Words",
                    "Both of Above",
                    "None of Above",
                    "Both of Above",
                    R.drawable.ic_pigeon));
            tipsArray.add("Pigeons Can Recognise Individual Human Faces And Learn Words.");

            questionsArray.add(new Question(
                    "What nutrition do birds contribute the most to human?",
                    "Carbohydrate",
                    "Protein",
                    "Fats",
                    "Calcium",
                    "Protein",
                    R.drawable.ic_nutrition));
            tipsArray.add("Birds that are raised for meat and eggs (poultry) are the largest source of protein eaten by humans.");

        }

        else if (skill.equals("science") && tree == 1 && stage == 1)
        {
            questionsArray.add(new Question(
                    "How many bones in adult human body?",
                    "206",
                    "250",
                    "300",
                    "200",
                    "206",
                    R.drawable.ic_skeleton));
            tipsArray.add("Adults have 206 bones in their bodies.");

            questionsArray.add(new Question(
                    "How many bones in baby human body?",
                    "206",
                    "250",
                    "300",
                    "200",
                    "300",
                    R.drawable.ic_xrays));
            tipsArray.add("A baby is born with about 300 bones");

            questionsArray.add(new Question(
                    "What is the longest bone in human body?",
                    "Femur",
                    "Scapula",
                    "Ulna",
                    "Humerus",
                    "Femur",
                    R.drawable.ic_bigbone));
            tipsArray.add("The femur, which runs from your hip to your knee, is the longest and largest bone in your body.");

            questionsArray.add(new Question(
                    "What is the smallest bone in human body?",
                    "Stapes",
                    "Scapula",
                    "Ulna",
                    "Humerus",
                    "Stapes",
                    R.drawable.ic_smallbones));
            tipsArray.add("The stapes, a bone in your inner ear, is the smallest of all your bones.");

            questionsArray.add(new Question(
                    "What is the largest joint in human body?",
                    "Wrist Joint",
                    "Finger Joint",
                    "Elbow Joint",
                    "Knee Joint",
                    "Knee Joint",
                    R.drawable.ic_joint));
            tipsArray.add("At the knee joint, three bones connect: your femur, tibia, and patella. Those three large bones require an equally large joint to connect them.");
        }
        else if (skill.equals("science") && tree == 1 && stage == 2)
        {
            questionsArray.add(new Question(
                    "What is correct about hair?",
                    "Second fastest growing tissue",
                    "Strongest tissue",
                    "Fastest Growing tissue",
                    "None of above",
                    "Second fastest growing tissue",
                    R.drawable.ic_hair));
            tipsArray.add("Hair is the second fastest growing tissue in the body after bone marrow.");

            questionsArray.add(new Question(
                    "How many layers does skin have?",
                    "4",
                    "3",
                    "1",
                    "2",
                    "3",
                    R.drawable.ic_skin));
            tipsArray.add("Skin is considered an organ in its own right. It's comprised of three layers. ");

            questionsArray.add(new Question(
                    "What is the largest organ of human body?",
                    "Skin",
                    "Stomach",
                    "Lung",
                    "Kidney",
                    "Skin",
                    R.drawable.ic_skeleton));
            tipsArray.add("An average adult's skin spans 21 square feet. It's your body's largest organ.");

            questionsArray.add(new Question(
                    "How many people have problem of acne?",
                    "1%",
                    "100%",
                    "85%",
                    "5%",
                    "85%",
                    R.drawable.ic_acne));
            tipsArray.add("Nearly 85 percent of people have acne at some point in their lives. ");

            questionsArray.add(new Question(
                    "What is the function of sweating?",
                    "No function",
                    "Run faster",
                    "Increase strength",
                    "Regulate body temperature",
                    "Regulate body temperature",
                    R.drawable.ic_sweating));
            tipsArray.add("Sweating is a bodily function that helps regulate your body temperature.");
        }
        else if (skill.equals("science") && tree == 1 && stage == 3)
        {
            questionsArray.add(new Question(
                    "How much blood does a normal adult have?",
                    "50mL",
                    "500mL",
                    "5000mL",
                    "50000mL",
                    "5000mL",
                    R.drawable.ic_blooddrop));
            tipsArray.add("The average adult weighing 150 to 180 pounds should have about 4,500 to 5,700 mL of blood in their body.");

            questionsArray.add(new Question(
                    "What is the percentage of plasma in human blood?",
                    "85%",
                    "15%",
                    "5%",
                    "55%",
                    "55%",
                    R.drawable.ic_blood));
            tipsArray.add("Blood is composed of about 55 percent plasma, 40 percent red blood cells, 4 percent platelets, 1 percent white blood cells.");

            questionsArray.add(new Question(
                    "What is the percentage of white blood cell in human blood?",
                    "85%",
                    "15%",
                    "1%",
                    "55%",
                    "55%",
                    R.drawable.ic_whitebloodcell));
            tipsArray.add("Blood is composed of about 55 percent plasma, 40 percent red blood cells, 4 percent platelets, 1 percent white blood cells.");

            questionsArray.add(new Question(
                    "What is necessary for pregnancy to occur?",
                    "Platelet",
                    "White blood cells",
                    "Plasma",
                    "Red blood cells",
                    "White blood cells",
                    R.drawable.ic_blooddrop));
            tipsArray.add("Certain white blood cells called macrophages assist in the development of blood vessel networks in the ovary");

            questionsArray.add(new Question(
                    "What is the lifespan of Red Blood Cells?",
                    "4 months",
                    "1 months",
                    "4 days",
                    "4 years",
                    "4 months",
                    R.drawable.ic_blood));
            tipsArray.add("Red blood cells circulate in the body for about 4 months");
        }
        else if (skill.equals("science") && tree == 1 && stage == 4)
        {
            questionsArray.add(new Question(
                    "How much oxygen you body takes for each inhale?",
                    "1%",
                    "5%",
                    "72%",
                    "27%",
                    "5%",
                    R.drawable.ic_breath));
            tipsArray.add("When you breathe, your body uses just 5% of the oxygen you’ve inhaled. The rest is exhaled and the cycle repeats.");

            questionsArray.add(new Question(
                    "What will be expelled when exhaling?",
                    "carbon-dioxide waste",
                    "water",
                    "All of above",
                    "None of above",
                    "All of above",
                    R.drawable.ic_breath));
            tipsArray.add("Breathing allows you to take in the oxygen your cells need and expel carbon-dioxide waste and a lot of water.");

            questionsArray.add(new Question(
                    "What is the capacity of human lungs?",
                    "5 liters",
                    "1 liters",
                    "10 liters",
                    "15 liters",
                    "5 liters",
                    R.drawable.ic_lungs));
            tipsArray.add("The lung capacity of an adult is approximately 4 to 6 liters of air.");

            questionsArray.add(new Question(
                    "Which side of human lung is smaller?",
                    "Left",
                    "Right",
                    "Top",
                    "Bottom",
                    "Left",
                    R.drawable.ic_lungs));
            tipsArray.add("The left lung tends to be smaller than the right lung in people to accommodate for the heart.");

            questionsArray.add(new Question(
                    "At least how much air will remain in your lungs when u exhale?",
                    "No air",
                    "5 liters",
                    "10 liters",
                    "1 liters",
                    "1 liters",
                    R.drawable.ic_breath));
            tipsArray.add("Even if you exhale really hard, a residual volume of 1 to 1.2 liters of air remains in your lungs");
        }
        else if (skill.equals("science") && tree == 1 && stage == 5)
        {
            questionsArray.add(new Question(
                    "How many times will human heart beat in a day?",
                    "10",
                    "1000",
                    "10000",
                    "100000",
                    "100000",
                    R.drawable.ic_heartbeat));
            tipsArray.add("Your heart beats about 100,000 times in one day and about 35 million times in a year.");

            questionsArray.add(new Question(
                    "What is the function of Wisdom Teeth",
                    "No function",
                    "Increase Wisdom",
                    "Decrease Wisdom",
                    "Bite Stronger",
                    "No function",
                    R.drawable.ic_wisdomtooth));
            tipsArray.add("Wisdom teeth serve no purpose. They’re left over from hundreds of thousands of years ago.");

            questionsArray.add(new Question(
                    "What makes the sound of cracking your knuckles?",
                    "Cracking of skin",
                    "Cracking of joint",
                    "Gas bubbles bursting in joints",
                    "Cracking of bone",
                    "Gas bubbles bursting in joints",
                    R.drawable.ic_finger));
            tipsArray.add("The satisfying sound of cracking your knuckles comes from gas bubbles bursting in your joints.");

            questionsArray.add(new Question(
                    "How many muscles in tongue?",
                    "7",
                    "8",
                    "9",
                    "10",
                    "8",
                    R.drawable.ic_tongue1));
            tipsArray.add("Your tongue is made up of eight interwoven muscles, similar in structure to an elephant’s trunk or an octopus’s tentacle.");

            questionsArray.add(new Question(
                    "How many taste zone does tongue have",
                    "2",
                    "3",
                    "4",
                    "5",
                    "4",
                    R.drawable.ic_tongue2));
            tipsArray.add("The four taste zones on your tongue are bitter (back), sour (back sides), salty (front sides), and sweet (front).");
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
                    "Who is the oldest president in America?",
                    "Donald Trump",
                    "Abraham Lincoln",
                    "Joe Biden",
                    "Barack Obama",
                    "Joe Biden",
                    R.drawable.ic_president));
            tipsArray.add("Joe Biden, who turned 78 on Nov. 20, has defeated Donald Trump and will become the oldest president in American history, a title previously held by Ronald Reagan.");

            questionsArray.add(new Question(
                    "Who is the first president in America?",
                    "George Washington",
                    "Abraham Lincoln",
                    "Joe Biden",
                    "Barack Obama",
                    "George Washington",
                    R.drawable.ic_president));
            tipsArray.add("On April 30, 1789, George Washington, standing on the balcony of Federal Hall on Wall Street in New York, took his oath of office as the first President of the United States.");

            questionsArray.add(new Question(
                    "Who is the longest serving president in America?",
                    "George Washington",
                    "Abraham Lincoln",
                    "Franklin Delano Roosevelt",
                    "Barack Obama",
                    "Franklin Delano Roosevelt",
                    R.drawable.ic_president));
            tipsArray.add("Franklin Delano Roosevelt is America’s longest serving president, having served from 1933 until his death in 1945 as a Democrat.");

            questionsArray.add(new Question(
                    "Who is the shortest serving president in America?",
                    "George Washington",
                    "Abraham Lincoln",
                    "Franklin Delano Roosevelt",
                    "William Henry Harrison",
                    "William Henry Harrison",
                    R.drawable.ic_president));
            tipsArray.add("William Henry Harrison died of either typhoid, pneumonia, or paratyphoid fever 31 days into his term, becoming the shortest-serving U.S. president in history.");

            questionsArray.add(new Question(
                    "Who is the youngest president in America?",
                    "John F. Kennedy",
                    "Abraham Lincoln",
                    "Franklin Delano Roosevelt",
                    "William Henry Harrison",
                    "John F. Kennedy",
                    R.drawable.ic_president));
            tipsArray.add("The youngest to become president by election was John F. Kennedy, who was 43 years, 236 days, at his inauguration.");
        }
        else if (skill.equals("history") && tree == 1 && stage == 2)
        {
            questionsArray.add(new Question(
                    "How many pyramids have been discovered in Egypt?",
                    "130",
                    "50",
                    "72",
                    "27",
                    "130",
                    R.drawable.ic_earth));
            tipsArray.add("To date, over 130 pyramids have been discovered in Egypt.");

            questionsArray.add(new Question(
                    "Why Egyptians preserving a dead person’s body?",
                    "To pay respect",
                    "Protect from enemy",
                    "For fun",
                    "Their soul would live forever",
                    "Their soul would live forever",
                    R.drawable.ic_jellyfish));
            tipsArray.add("The afterlife was incredibly important to the Egyptians. They believed that by preserving a dead person’s body, their soul would live on in the after-life forever.");

            questionsArray.add(new Question(
                    "What is the largest Pyramid in Egypt?",
                    "Pyramid of Khafre",
                    "Pyramids of Giza",
                    "Pyramid of Khufu",
                    "Pyramid of Menkaure",
                    "Pyramid of Khufu",
                    R.drawable.ic_octopus));
            tipsArray.add("The Pyramid of Khufu at Giza is the largest Egyptian pyramid. This incredible structure weighs as much as 16 Empire State buildings!");

            questionsArray.add(new Question(
                    "What is the colour of Eye-paint of Egyptian?",
                    "Blue or red",
                    "Green or black",
                    "Yellow or red",
                    "Blue or yellow",
                    "Green or black",
                    R.drawable.ic_dolphin));
            tipsArray.add("Both Egyptian men and women wore make-up. The eye-paint was usually green (made from copper) or black (made from lead).");

            questionsArray.add(new Question(
                    "How long could an unwrapped bandages of an Ancient Egyptian?",
                    "16.6km",
                    "10.6km",
                    "0.6km",
                    "1.6km",
                    "1.6km",
                    R.drawable.whale));
            tipsArray.add("Unwrapped, the bandages of an Ancient Egyptian mummy could stretch for 1.6km. Yikes!");
        }
        else if (skill.equals("history") && tree == 1 && stage == 3)
        {
            questionsArray.add(new Question(
                    "How much deities do Ancient Egyptians have?",
                    "300",
                    "20",
                    "2",
                    "2000",
                    "2000",
                    R.drawable.ic_earth));
            tipsArray.add("Ancient Egyptians believed in more than 2,000 deities! They had gods for everything, from dangers to chores!");

            questionsArray.add(new Question(
                    "What animal do Ancient Egyptians will bring good luck?",
                    "Cat",
                    "Dog",
                    "Turtle",
                    "Lion",
                    "Cat",
                    R.drawable.ic_jellyfish));
            tipsArray.add("Cats were considered to be a sacred animal by the Ancient Egyptians. They believed would bring the household good luck to keep it as pet!");

            questionsArray.add(new Question(
                    "How long ago since the first Egyptian?",
                    "80 years ago",
                    "800 years ago",
                    "8000 years ago",
                    "80000 years ago",
                    "8000 years ago",
                    R.drawable.ic_octopus));
            tipsArray.add("The first people to live on the banks of the Nile were hunters and fishermen, who settled there over 8,000 years ago.");

            questionsArray.add(new Question(
                    "What is the percentage of Muslim Egyptians?",
                    "7%",
                    "90%",
                    "2%",
                    "50%",
                    "90%",
                    R.drawable.ic_dolphin));
            tipsArray.add("About 90 percent of Egyptians are Muslim, which means they are followers of the Islam religion.");

            questionsArray.add(new Question(
                    "Who invaded Egypt in 1880s?",
                    "British",
                    "Portugal",
                    "Germany",
                    "Italy",
                    "British",
                    R.drawable.whale));
            tipsArray.add("In 1882, the British invaded and occupied Egypt.");
        }
        else if (skill.equals("history") && tree == 1 && stage == 4)
        {
            questionsArray.add(new Question(
                    "In which year did World War I start?",
                    "1912",
                    "1913",
                    "1914",
                    "1924",
                    "1914",
                    R.drawable.ic_earth));
            tipsArray.add("World War I, also known as the Great War, began in 1914 after the assassination of Archduke Franz Ferdinand of Austria");

            questionsArray.add(new Question(
                    "How many years did World War I last for?",
                    "1 year",
                    "2",
                    "3",
                    "4",
                    "4",
                    R.drawable.ic_jellyfish));
            tipsArray.add("World War I lasted exactly four years, three months and 14 days, which began on 28th July 1914 and lasted until 11th November 1918.");

            questionsArray.add(new Question(
                    "How many country took part in World War I?",
                    "135",
                    "13",
                    "5",
                    "15",
                    "135",
                    R.drawable.ic_octopus));
            tipsArray.add("135 countries took part in World War I, and more than 15 million people died.");

            questionsArray.add(new Question(
                    "In which year did World War II start?",
                    "1938",
                    "1939",
                    "1940",
                    "1941",
                    "1939",
                    R.drawable.ic_dolphin));
            tipsArray.add("World War II, also called Second World War, conflict that involved virtually every part of the world during the years 1939–45.");

            questionsArray.add(new Question(
                    "Which country remained ‘neutral’ in World War II?",
                    "Italy",
                    "Russia",
                    "Spain",
                    "Germany",
                    "Spain",
                    R.drawable.whale));
            tipsArray.add("Some countries remained ‘neutral’ in World War 2. Such countries were Spain, Sweden and Switzerland – who chose not to join either side.");
        }
        else if (skill.equals("history") && tree == 1 && stage == 5)
        {
            questionsArray.add(new Question(
                    "What did Chai Lun invented?",
                    "Method of housemaking",
                    "Method of war tactic",
                    "Method of moneymaking",
                    "Method of papermaking",
                    "Method of papermaking",
                    R.drawable.ic_earth));
            tipsArray.add("The Han dynasty Chinese court official Cai Lun (c. 50–121 CE) is credited as the inventor of a method of papermaking.");

            questionsArray.add(new Question(
                    "Who invented the modern car?",
                    "Karl Benz",
                    "Karl Malone",
                    "Jordan Benz",
                    "Jordan Malone",
                    "Karl Benz",
                    R.drawable.ic_jellyfish));
            tipsArray.add("The year 1886 is regarded as the birth year of the modern car when German inventor Karl Benz patented his Benz Patent-Motorwagen.");

            questionsArray.add(new Question(
                    "In which year the first powered aircraft was invented?",
                    "1903",
                    "1904",
                    "1905",
                    "1906",
                    "1903",
                    R.drawable.ic_octopus));
            tipsArray.add("On December 17, 1903, Wilbur and Orville Wright made four brief flights at Kitty Hawk with their first powered aircraft.");

            questionsArray.add(new Question(
                    "What did James Naismith invented?",
                    "Tennis",
                    "Table Tennis",
                    "Football",
                    "Basketball",
                    "Basketball",
                    R.drawable.ic_dolphin));
            tipsArray.add("The history of basketball began with its invention in 1891 in Springfield, Massachusetts by Canadian physical education instructor James Naismith.");

            questionsArray.add(new Question(
                    "What invented the first smartphone?",
                    "Samsung",
                    "Intel",
                    "IBM",
                    "Apple",
                    "IBM",
                    R.drawable.whale));
            tipsArray.add("The tech company IBM is widely credited with developing the world's first smartphone – the bulky but rather cutely named Simon.");
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

            if (generateRandom(4))
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