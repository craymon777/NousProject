package com.example.nous;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LearningAnimalActivity extends AppCompatActivity {

    String skill;
    int tree;
    int stage;

    ImageButton btnExit;

    TextView tvTree;
    TextView tvStageNum;
    ImageView imgStageLearning;
    LinearLayout layout1;
    TextView tvContentTitle0, tvContentTitle1, tvContentTitle2, tvContentTitle3, tvContentTitle4, tvContentTitle5;
    TextView tvContent0, tvContent1, tvContent2, tvContent3, tvContent4, tvContent5;



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

        tvTree = findViewById(R.id.tvTree);

        tvStageNum = findViewById(R.id.tvStageNum);

        imgStageLearning = findViewById(R.id.imgStageLearning);

        layout1 = findViewById(R.id.linLayContent1);

        tvContentTitle0 = findViewById(R.id.tvContentTitle0);
        tvContentTitle1 = findViewById(R.id.tvContentTitle1);
        tvContentTitle2 = findViewById(R.id.tvContentTitle2);
        tvContentTitle3 = findViewById(R.id.tvContentTitle3);
        tvContentTitle4 = findViewById(R.id.tvContentTitle4);
        tvContentTitle5 = findViewById(R.id.tvContentTitle5);

        tvContent0 = findViewById(R.id.tvContent0);
        tvContent1 = findViewById(R.id.tvContent1);
        tvContent2 = findViewById(R.id.tvContent2);
        tvContent3 = findViewById(R.id.tvContent3);
        tvContent4 = findViewById(R.id.tvContent4);
        tvContent5 = findViewById(R.id.tvContent5);

        setStageLearningContent();
    }

    private void setStageLearningContent() {
        if (skill.equals("animal") && tree == 1)
        {
            switch (stage)
            {
                case 1:
                    tvStageNum.setText("Chapter 1: First Step into Ocean");
                    break;
                case 2:
                    tvStageNum.setText("Chapter 2: Ocean is Fun");

                    imgStageLearning.setImageResource(R.drawable.bg_ocean2);

                    tvContent0.setText("Greetings, Explorer! What is your experience from the last journey? Is the ocean kingdom fun? Now, You will have more chances to look for interesting things!... Do not forget to read the script below....");

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

                    imgStageLearning.setImageResource(R.drawable.bg_ocean3);

                    tvContent0.setText("Greetings, Explorer! I am sure that you have seen the interesting part in Ocean Kingdom. However, there may be something else at the same time! You ask me what are something else? Something....is something...maybe you can find it somewhere....");

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

                    imgStageLearning.setImageResource(R.drawable.bg_ocean4);

                    tvContent0.setText("Greetings, Explorer! You are here, that means you are safe from the last exploration, Congratulation! Now, Continue your journey......");

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

                    imgStageLearning.setImageResource(R.drawable.bg_ocean5);

                    tvContent0.setText("Greetings, Explorer! Congratulation, you have come to this point, there are only not much left! If you have not explore the previous stage, beware for the huge challenge! Now, good luck to you!");

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

        else if (skill.equals("animal") && tree == 2)
        {
            tvTree.setText("Flying Kingdom");
            switch (stage)
            {
                case 1:
                    tvStageNum.setText("Chapter 1: Sky is Fun");

                    imgStageLearning.setImageResource(R.drawable.bg_sky2);

                    tvContent0.setText("Greetings, Explorer! Welcome to the Flying Kingdom. Yes, here is the entrance to the exiting Flying Kingdom. Are you ready?.......Wait, you should take a look on the script, it may help you.....");

                    tvContentTitle1.setText("Dou you know?");
                    tvContent1.setText("Sure, you know that birds fly, but did you know that there is also one mammal that can truly fly? That is bat. Although most animals (other than birds) don't actually fly, they glide, we think of many creatures as being able to fly.");

                    tvContentTitle2.setText("The only Flying Mammal");
                    tvContent2.setText("Flying foxes are actually fruit bats, and yes, they can fly. Bats are the only mammal that can do so. Flying squirrels, flying lizards and flying fish can't fly, but they sure look like they do.");

                    tvContentTitle3.setText("Bat Flying Fast");
                    tvContent3.setText("Bats may be small, but they’re fast little creatures. How fast a bat flies depends on the species, but they can reach speeds over 100 miles per hour according to new research. ");

                    tvContentTitle4.setText("Largest Bat");
                    tvContent4.setText("The world’s largest bat is the flying fox that lives on islands in the South Pacific. It has a wingspan of up to 6 feet.");

                    tvContentTitle5.setText("Smallest Bat");
                    tvContent5.setText("The world’s smallest bat is the bumble bee bat of Thailand, which is smaller than a thumbnail and weighs less than a penny.");

                    break;


                case 2:
                    tvStageNum.setText("Chapter 2: Explore the Sky");

                    imgStageLearning.setImageResource(R.drawable.bg_sky3);

                    tvContent0.setText("Flying fox...largest bat.... Owh! Greetings, Explorer! How do you do? Flying Kingdom is fun, is'nt it? Do not hesitate, continue you journey!");

                    tvContentTitle1.setText("Smallest Bird");
                    tvContent1.setText("The smallest bird is the bee hummingbird (Mellisuga helenae) of Cuba and the Isle of Youth. Males measure 57 mm (2.24 in) in total length, half of which is taken up by the bill and tail, and weigh 1.6 g (0.056 oz) Females are slightly larger.");

                    tvContentTitle2.setText("Largest Bird");
                    tvContent2.setText("The common ostrich is the biggest bird in the world.It’s both the tallest and heaviest, with an average height of over 2 meters (sometimes as tall as 2.8 meters) and a weight of up to 160 kg.");

                    tvContentTitle3.setText("Slowest-Flying Birds");
                    tvContent3.setText("The American woodcock (Scolopax minor) and the Eurasian woodcock (S. Rusticola) have both been timed lying at 5 mph with out stalling during courtship displays.");

                    tvContentTitle4.setText("Fastest Flying Bird");
                    tvContent4.setText("The peregrine falcon (Falco peregrinus) is the fastest living creature, reaching speeds of at least 124 mph and possibly as much as 168 mph when swooping from great heights during territorial displays or while catching pry birds in midair.");

                    tvContentTitle5.setText("Largest Flying Bird");
                    tvContent5.setText("There are 23 species of albatrosses, though arguably the most famous is the Wandering Albatross (Diomedea exulans), which is the largest flying bird in the world. This bird has a 11-foot (3.4 meter) wingspan.");

                    break;

                case 3:
                    tvStageNum.setText("Chapter 3: Fun Fact");

                    imgStageLearning.setImageResource(R.drawable.bg_sky1);

                    tvContent0.setText("Greetings, Explorer! We need a smart and brave explorer to explore more on this area? Let me see.... You are the right person! Would you help us out for the task?");
                    tvContentTitle1.setText("Bird Species");
                    tvContent1.setText("There are over 9,500 species of birds in the world. Scientists typically group them into 30 categories. Birds are the most widespread of all animals around the world.");

                    tvContentTitle2.setText("Bird Habitat");
                    tvContent2.setText("Approximately 2/3 of all the bird species are found in tropical rain forests.");

                    tvContentTitle3.setText("Lung of Bird");
                    tvContent3.setText("A bird’s lungs are much more complicated and efficient and take up more space than those of mammals, such as humans. A human’s lungs compose about 1/20 of its body, but a bird’s takes up 1/5.");

                    tvContentTitle4.setText("Talkative Bird");
                    tvContent4.setText("The most talkative bird in the world is the African gray parrot. One parrot could say over 800 words. Most species of parrots can learn only 50.");

                    tvContentTitle5.setText("Emu Chicks");
                    tvContent5.setText("The chicks of large bird species often take the longest to hatch. Emu chicks, for example, take 60 days to hatch. Small songbirds take just 2 weeks.");

                    break;

                case 4:
                    tvStageNum.setText("Chapter 4: Around the Sky");

                    imgStageLearning.setImageResource(R.drawable.bg_sky4);

                    tvContent0.setText("Greetings, Explorer! You have collected a lot of information about the Flying Kingdom! Good job! Continue you journey here.......");

                    tvContentTitle1.setText("Most Feathers");
                    tvContent1.setText("The bird with the most feathers is the whistling swan, with up to 25,000 feathers.");

                    tvContentTitle2.setText("Least Feathers");
                    tvContent2.setText("Hummingbirds, on the other hand, are so small that they have fewer than 1,000.");

                    tvContentTitle3.setText("Gentoo Penguins");
                    tvContent3.setText("Gentoo Penguins are the fastest swimming birds, reaching speeds of 22 mph (36 kph). Emperor Penguins can stay under water for up to 18 minutes.");

                    tvContentTitle4.setText("Lifespan");
                    tvContent4.setText("Approximately 75% of wild birds live for less than a year. The larger the bird, the more likely it is to live longer. The large wandering albatross, for example, can live for up to 80 years.");

                    tvContentTitle5.setText("Emperor Penguin");
                    tvContent5.setText("The Emperor Penguin is the only bird that lays its eggs in the middle of winter. By laying its eggs so early, it gives its young a head start. The babies need all spring, summer, and fall to grow big enough to survive the next winter.");

                    break;

                case 5:
                    tvStageNum.setText("Chapter 5: Master the Sky");

                    imgStageLearning.setImageResource(R.drawable.bg_sky5);

                    tvContent0.setText("Greetings, Explorer! One more steps....and there is the conquer of Flying Kingdom!");

                    tvContentTitle1.setText("Oilbirds");
                    tvContent1.setText("Oilbirds eat oil palm fruits, which make the birds oily too. People near the caves where the oilbirds lived used to trap the oilbirds and boil them down for the oil.");

                    tvContentTitle2.setText("Danger to Bird");
                    tvContent2.setText("Lighthouses are dangerous for birds. The beams attract birds, especially in misty conditions, and many are killed when they fly into the glass.");

                    tvContentTitle3.setText("Angry Bird");
                    tvContent3.setText("The game Angry Birds has sold more than 7 million copies on Apple’s iPhone. The game was made by a team of just four people. It was such a low priority for the company that it took over 8 months to finish.");

                    tvContentTitle4.setText("Pigeons");
                    tvContent4.setText("Pigeons Can Recognise Individual Human Faces And Learn Words. A Recent Study Established That Pigeons Can Learn To Recognise Up To 50 Words And Can Distinguish Words From Other Vocalisations.");

                    tvContentTitle5.setText("Protein");
                    tvContent5.setText("Birds that are raised for meat and eggs (poultry) are the largest source of protein eaten by humans.");

                    break;



            }
        }

        else if (skill.equals("science") && tree == 1)
        {
            tvTree.setText("Human Science Kingdom");

            switch (stage)
            {
                case 1:
                    tvStageNum.setText("Chapter 1: Human Bone");

                    imgStageLearning.setImageResource(R.drawable.bg_science1);

                    tvContent0.setText("Greetings, Explorer! We need an explorer who is brave and smart to explore the realm in Human Body. Are you willing to accept the challenge?");

                    tvContentTitle1.setText("Do you know?");
                    tvContent1.setText("Adults have 206 bones in their bodies, but a baby is born with about 300 bones and cartilage. The soft and flexible cartilage fuses together to form larger bones through a process called ossification, thereby reducing the overall number of bones by adulthood.");

                    tvContentTitle2.setText("Smallest Bone");
                    tvContent2.setText("The stapes, a bone in your inner ear, is the smallest of all your bones. This bone is also sometimes called the stirrup because of its Y shape. Together with the anvil and hammer bones, the stapes helps translate sounds you hear into waves your brain can understand.");

                    tvContentTitle3.setText("Longest Bone");
                    tvContent3.setText("The femur, which runs from your hip to your knee, is the longest and largest bone in your body. It’s also the strongest. Just think of all the weight that bone handles in a day. No wonder it’s so strong!");

                    tvContentTitle4.setText("Stronger Bones");
                    tvContent4.setText("Bones lose strength over time. Keeping them strong requires eating calcium-rich foods like dairy products, broccoli, and some fish. Exercise, especially weight-bearing exercise, helps keep bones strong, too.");

                    tvContentTitle5.setText("Largest Joint");
                    tvContent5.setText("At the knee joint, three bones connect: your femur, tibia, and patella. Those three large bones require an equally large joint to connect them. That’s why your knee is the largest joint in your body.");

                    break;


                case 2:
                    tvStageNum.setText("Chapter 2: Explore the Skin");

                    imgStageLearning.setImageResource(R.drawable.bg_science2);

                    tvContent0.setText("Greetings, Explorer! Skin is the organ that protect human body. Explore more about it will help our research project. Take the script below and begin your journey!");

                    tvContentTitle1.setText("Hair");
                    tvContent1.setText("Hair is the second fastest growing tissue in the body after bone marrow.");


                    tvContentTitle2.setText("Skin Layer");
                    tvContent2.setText("Skin is considered an organ in its own right. It's comprised of three layers: the waterproof top layer, the epidermis; a middle layer of tougher connective tissue, hair follicles, and glands called the dermis; and the inner layer, the hypodermis, which is mostly fat and connective tissue that supports the skin's structure and attaches it to muscles.");

                    tvContentTitle3.setText("Largest Organ");
                    tvContent3.setText("An average adult's skin spans 21 square feet, weighs nine pounds, and contains more than 11 miles of blood vessels. It's your body's largest organ.");

                    tvContentTitle4.setText("Acne");
                    tvContent4.setText("Nearly 85 percent of people have acne at some point in their lives.  It usually starts in puberty but can affect people in their 20s, 30s, 40s and even 50s.");

                    tvContentTitle5.setText("Sweating");
                    tvContent5.setText("Sweating is a bodily function that helps regulate your body temperature. In fact, your skin likely has anywhere between two and four million sweat glands.");

                    break;

                case 3:
                    tvStageNum.setText("Chapter 3: Look At Blood");

                    imgStageLearning.setImageResource(R.drawable.bg_science3);

                    tvContent0.setText("Greetings, Explorer! Do you know, when you hurt your body, you will......you will.....BLEED! Red bleeding........");

                    tvContentTitle1.setText("Blood Volume");
                    tvContent1.setText("The average adult weighing 150 to 180 pounds should have about 4,500 to 5,700 mL of blood in their body. Blood makes up about 7 to 8 percent of a person's total body weight.");

                    tvContentTitle2.setText("Red Blood Cell");
                    tvContent2.setText("Blood circulating in your body is composed of about 55 percent plasma, 40 percent red blood cells, 4 percent platelets, and 1 percent white blood cells.");

                    tvContentTitle3.setText("White Blood Cell");
                    tvContent3.setText("What is less known is that certain white blood cells called macrophages are necessary for pregnancy to occur. Macrophages assist in the development of blood vessel networks in the ovary, which is vital for the production of the hormone progesterone.");

                    tvContentTitle4.setText("Blood Lifespan");
                    tvContent4.setText("Matured human blood cells have varying life cycles. Red blood cells circulate in the body for about 4 months, platelets for about 9 days, and white blood cells range from a few hours to several days.");

                    tvContentTitle5.setVisibility(View.GONE);
                    tvContent5.setVisibility(View.GONE);

                    break;

                case 4:
                    tvStageNum.setText("Chapter 4: Lungs");

                    imgStageLearning.setImageResource(R.drawable.bg_science4);

                    tvContent0.setText("Greetings, Explorer! Congratulation, you have few more step to conquer the exploration journey. Take a breathe.....breathe....and continue your journey! Good luck!");

                    tvContentTitle1.setText("Breathe");
                    tvContent1.setText("When you breathe, your body uses just 5% of the oxygen you’ve inhaled. The rest is exhaled and the cycle repeats.");

                    tvContentTitle2.setText("Exhale Water");
                    tvContent2.setText("Breathing allows you to take in the oxygen your cells need and expel carbon-dioxide waste. But when you exhale, you also breathe out a lot of water.");

                    tvContentTitle3.setText("Lung Capacity");
                    tvContent3.setText("The lung capacity of an adult is approximately 4 to 6 liters of air. Males tend to have larger lung capacity than females. We only breathe in about 0.5 liters with each breath.");

                    tvContentTitle4.setText("Lung");
                    tvContent4.setText("Even if you exhale really hard, a residual volume of 1 to 1.2 liters of air remains in your lungs.");

                    tvContentTitle5.setText("Unequal Size");
                    tvContent5.setText("The left lung tends to be smaller than the right lung in people to accommodate for the heart, which is located on the left side of the body.");

                    break;

                case 5:
                    tvStageNum.setText("Chapter 5: Master the Organ");

                    imgStageLearning.setImageResource(R.drawable.bg_science5);

                    tvContent0.setText("Greetings, Explorer! Human Body is fun and complicated at the same time, is'nt it? The more you explore about human body, the more you will feel excited!");

                    tvContentTitle1.setText("Heartbeat");
                    tvContent1.setText("Your heart beats about 100,000 times in one day and about 35 million times in a year. During an average lifetime, the human heart will beat more than 2.5 billion times.");

                    tvContentTitle2.setText("Wisdom Teeth");
                    tvContent2.setText("Wisdom teeth serve no purpose. They’re left over from hundreds of thousands of years ago. As early humans’ brains grew bigger, it reduced space in the mouth, crowding out this third set of molars.");

                    tvContentTitle3.setText("Satisfying Sound");
                    tvContent3.setText("The satisfying sound of cracking your knuckles comes from gas bubbles bursting in your joints.");

                    tvContentTitle4.setText("Tongue");
                    tvContent4.setText("Your tongue is made up of eight interwoven muscles, similar in structure to an elephant’s trunk or an octopus’s tentacle.");

                    tvContentTitle5.setText("Taste Zone");
                    tvContent5.setText("The four taste zones on your tongue are bitter (back), sour (back sides), salty (front sides), and sweet (front).");

                    break;

            }
        }

        else if (skill.equals("science") && tree == 2)
        {
            tvTree.setText("Earth Science Kingdom");

            switch (stage)
            {
                case 1:
                    tvStageNum.setText("Chapter 1: Mountains");

                    imgStageLearning.setImageResource(R.drawable.bg_earth1);

                    tvContent0.setText("Greetings, Explorer! You are requested to explore the unknown mountain in front of you. Before you begin, please take the script below.....it may help you....");

                    tvContentTitle1.setText("Do you know?");
                    tvContent1.setText("Mountains make up about one-fifth of the world's landscape, and provide homes to at least one-tenth of the world's people.");

                    tvContentTitle2.setText("Mountains Height");
                    tvContent2.setText("Heights of mountains are generally given as heights above sea level.");

                    tvContentTitle3.setText("Highest Mountain");
                    tvContent3.setText("The world's highest peak on land is Mount Everest in the Himalayas. It is 8,850.1728 m (29,036 ft) tall.");

                    tvContentTitle4.setText("Mountain in Ocean");
                    tvContent4.setText("Mountains occur more often in oceans than on land; some islands are the peaks of mountains coming out of the water. Undersea mountains were formed as a result of volcanic activity under the sea. ");

                    tvContentTitle5.setText("Shortest Mountain");
                    tvContent5.setText("Not every continent has tall mountains. Mount Wycheproof in Australia is officially the smallest mountain in the world. To most of the world Mount Wycheproof would barely be considered a hill. The mountain measures in at a staggering 486 ft above sea level.");

                    break;


                case 2:
                    tvStageNum.setText("Chapter 2: Rain");

                    imgStageLearning.setImageResource(R.drawable.bg_earth2);

                    tvContent0.setText("Greetings, Explorer! Beware, the journey in front is shrouded with heavy rain! Before starting your jouney, we have a script for you below.....");

                    tvContentTitle1.setText("Dry Rain");
                    tvContent1.setText("In dry, hot places, rain sometimes evaporates before it hits the ground. You see curtains of rain dangling in the sky while the living things wither below for want of water.");


                    tvContentTitle2.setText("Least Rainy Place");
                    tvContent2.setText("The least rainy place on earth isn’t in the desert. Antarctica gets only 6.5 inches of rain or snow per year, making it the continent with the lowest annual rainfall by far.");

                    tvContentTitle3.setText("Thundery Place");
                    tvContent3.setText("The most thundery place on Earth is believed to be Tororo, Uganda, where it thunders 251 days a year.");

                    tvContentTitle4.setText("Cloud Weight");
                    tvContent4.setText("Clouds look like they weigh little more than a tuft of cotton, but they’re heavier than they look. Your average cumulus (fair weather) cloud can weigh more than a million pounds.");

                    tvContentTitle5.setText("Colour of Cloud");
                    tvContent5.setText("Clouds are white because they reflect light from the sun. Gray clouds become so filled with water that they don’t reflect light. Masses of clouds form shadows, which can also cause the clouds to look gray.");

                    break;

                case 3:
                    tvStageNum.setText("Chapter 3: Forest");

                    imgStageLearning.setImageResource(R.drawable.bg_earth3);

                    tvContent0.setText("Greetings, Explorer! The forest in front has a lot of unknown issues! Are you willing to explore it?");

                    tvContentTitle1.setText("Forest Coverage");
                    tvContent1.setText("Forests cover around 4 billion hectares or 30 percent of Earth’s land surface. That represents about eight percent of its total surface area.");

                    tvContentTitle2.setText("Forest in Country");
                    tvContent2.setText("Ten countries hold about two-thirds the world’s forest cover, led by Russia (7.8 million square kilometers), Brazil (4.8m sq km), Canada (3.1m sq km), the United States (3m sq km), China (1.8m sq km) and Democratic Republic of the Congo (1.8m sq km).");

                    tvContentTitle3.setText("Forest Lost");
                    tvContent3.setText("Most forest loss is the result of human activities. The biggest drivers of deforestation are agriculture and livestock production, logging, and forest fires.");

                    tvContentTitle4.setText("Source of Medicine");
                    tvContent4.setText("A quarter of all modern medicines come from tropical forest plants, including two-thirds of all cancer-fighting drugs. As well as saving people’s lives, these medicinal plants are worth a staggering US$108 billion a year.");

                    tvContentTitle5.setText("Carbon Sink");
                    tvContent5.setText("Trees are a great carbon sink, with the world’s forests removing an estimated 2.1 Gigatonnes of carbon dioxide annually – that’s 2.1 billion tonnes!");

                    break;

                case 4:
                    tvStageNum.setText("Chapter 4: The Great Waterfall");

                    imgStageLearning.setImageResource(R.drawable.bg_earth4);

                    tvContent0.setText("Greetings, Explorer! I believe you have encountered a lot of challenge during exploration! But have you encounter waterfall? Waterfall is a beautiful creature by natural........");

                    tvContentTitle1.setText("Highest Uninterrupted Waterfall");
                    tvContent1.setText("Angel Falls in Venezuela is the world’s highest uninterrupted uninterrupted, with a height of 979 meters (3,212 ft) and a plunge of 807 meters (2,648 ft). It is so high that at warmer times of the year, the water turns into mist before it reaches the stream below.");

                    tvContentTitle2.setText("Largest Waterfall");
                    tvContent2.setText("Victoria Falls is classified as the largest, based on its combined width of 1,708 meters (5,604 ft) and height of 108 meters (354 ft), resulting in the world’s largest sheet of falling water.");

                    tvContentTitle3.setText("Marmore’s Falls");
                    tvContent3.setText("The Cascata delle Marmore (Marmore’s Falls) is a man-made waterfall created by the ancient Romans. Its total height is 165 meters (541 feet), making it the tallest man-made waterfall in the world.");

                    tvContentTitle4.setText("Yosemite Falls");
                    tvContent4.setText("Yosemite Falls in California is the tallest waterfall in the United States. It is located in Yosemite National Park and has a vertical drop of 739 meters (2425 feet). ");

                    tvContentTitle5.setText("Type of Waterfall");
                    tvContent5.setText("Waterfalls are classified into 10 different types depending on the way they descend.");
                    break;

                case 5:
                    tvStageNum.setText("Chapter 5: Feel The Heat");

                    imgStageLearning.setImageResource(R.drawable.bg_earth5);

                    tvContent0.setText("Greetings, Explorer! The hardest challenge is in front of you. Could you listen the sound?.....Vrooom.....VROOM..... Take care.....Explorer!");

                    tvContentTitle1.setText("Eruption");
                    tvContent1.setText("A volcano is a mountain that opens downward to a pool of molten rock below the surface of the earth. When pressure builds up, eruptions occur.");

                    tvContentTitle2.setText("Danger Area");
                    tvContent2.setText("The danger area around a volcano covers about a 20-mile radius.");

                    tvContentTitle3.setText("Active Volcano");
                    tvContent3.setText("There are more than 500 active volcanoes in the world. More than half of these volcanoes are part of the Ring of Fire, a region that encircles the Pacific Ocean.");

                    tvContentTitle4.setText("Type of Volcano");
                    tvContent4.setText("An active volcano is one that has had an eruption in historical times (in the last few thousand years). A dormant volcano is one that has erupted in historical times and has the potential to erupt again, it just hasn’t erupted recently. An extinct volcano is one that scientists think probably won’t erupt again.");

                    tvContentTitle5.setText("Greatest Volcano");
                    tvContent5.setText("The tallest volcano on Earth is Hawaii’s Mauna Kea, with an elevation of 4,207 meters. It’s only a little bigger than the largest volcano on Earth, Mauna Loa with an elevation of only 4,169 meters.");

                    break;

            }
        }

        else if (skill.equals("history") && tree == 1)
        {
            tvTree.setText("World History");

            switch (stage)
            {
                case 1:
                    tvStageNum.setText("Chapter 1: America President");

                    imgStageLearning.setImageResource(R.drawable.bg_world1);

                    tvContent0.setText("Greetings, Explorer! Shhhhh..... We are testing a time machine.... Would you like to be our first tester? We are not sure when and where you will be sent to.....");

                    tvContentTitle1.setText("Do you know?");
                    tvContent1.setText("Joe Biden, who turned 78 on Nov. 20, has defeated Donald Trump and will become the oldest president in American history, a title previously held by Ronald Reagan.");

                    tvContentTitle2.setText("America First President");
                    tvContent2.setText("On April 30, 1789, George Washington, standing on the balcony of Federal Hall on Wall Street in New York, took his oath of office as the first President of the United States.");

                    tvContentTitle3.setText("Franklin Delano Roosevelt");
                    tvContent3.setText("Franklin Delano Roosevelt is America’s longest serving president, having served from 1933 until his death in 1945 as a Democrat.");

                    tvContentTitle4.setText("William Henry Harrison");
                    tvContent4.setText("William Henry Harrison died of either typhoid, pneumonia, or paratyphoid fever 31 days into his term, becoming the first president to die in office and the shortest-serving U.S. president in history.");

                    tvContentTitle5.setText("John F. Kennedy");
                    tvContent5.setText("The youngest to become president by election was John F. Kennedy, who was 43 years, 236 days, at his inauguration.");

                    break;


                case 2:
                    tvStageNum.setText("Chapter 2: Egypt");

                    imgStageLearning.setImageResource(R.drawable.bg_world2);

                    tvContent0.setText("Greetings, Explorer! Could you listen my voice? Yes? Great! Now, take the script by your side, we could locate your current location, which is Egypt! Tell us what you explore.......");
                    tvContentTitle1.setText("Pyramid");
                    tvContent1.setText("Most Ancient Egyptian pyramids were built as tombs for pharaohs (rulers of Ancient Egypt) and their families. To date, over 130 pyramids have been discovered in Egypt.");

                    tvContentTitle2.setText("Afterlife");
                    tvContent2.setText("The afterlife was incredibly important to the Egyptians. They believed that by preserving a dead person’s body – which they did through the process of mummification – their soul would live on in the after-life forever.");

                    tvContentTitle3.setText("Largest Pyramid");
                    tvContent3.setText("The Pyramid of Khufu at Giza is the largest Egyptian pyramid. This incredible structure weighs as much as 16 Empire State buildings!");

                    tvContentTitle4.setText("Eye-paint of Egyptian");
                    tvContent4.setText("Both Egyptian men and women wore make-up. The eye-paint was usually green (made from copper) or black (made from lead). ");

                    tvContentTitle5.setText("Bandages");
                    tvContent5.setText("Unwrapped, the bandages of an Ancient Egyptian mummy could stretch for 1.6km. Yikes!");

                    break;

                case 3:
                    tvStageNum.setText("Chapter 3: Continue For Pyramid");

                    imgStageLearning.setImageResource(R.drawable.bg_world3);

                    tvContent0.setText("Greetings, Explorer! Well done! Your information is helpful for our research! Continue you journey.... Take care!");

                    tvContentTitle1.setText("Deities");
                    tvContent1.setText("Ancient Egyptians believed in more than 2,000 deities! They had gods for everything, from dangers to chores! Each had different responsibilities and needed to be worshipped so that life could be kept in balance.");

                    tvContentTitle2.setText("Cats");
                    tvContent2.setText("Cats were considered to be a sacred animal by the Ancient Egyptians. It’s thought that most families kept a cat as a pet, which they believed would bring the household good luck!");

                    tvContentTitle3.setText("First Egyptian");
                    tvContent3.setText("The first people to live on the banks of the Nile were hunters and fishermen, who settled there over 8,000 years ago. ");

                    tvContentTitle4.setText("Religion");
                    tvContent4.setText("About 90 percent of Egyptians are Muslim, which means they are followers of the Islam religion. ");

                    tvContentTitle5.setText("Invader");
                    tvContent5.setText("In 1882, the British invaded and occupied Egypt. The British wanted control of the Suez Canal, which linked the Mediterranean Sea with the Red Sea and greatly shortened the sailing trip from Asia to Europe. The British stayed until Egypt declared independence in 1952.");

                    break;

                case 4:
                    tvStageNum.setText("Chapter 4: World War");

                    imgStageLearning.setImageResource(R.drawable.bg_world4);

                    tvContent0.setText("Greetings, Explorer! We have accelerated the time machine....We have send the script to you, hopefully it helps....");

                    tvContentTitle1.setText("World War I");
                    tvContent1.setText("World War I, also known as the Great War, began in 1914 after the assassination of Archduke Franz Ferdinand of Austria.");

                    tvContentTitle2.setText("Duration");
                    tvContent2.setText("World War I lasted exactly four years, three months and 14 days, which began on 28th July 1914 and lasted until 11th November 1918.");

                    tvContentTitle3.setText("Countries Involved");
                    tvContent3.setText("135 countries took part in World War I, and more than 15 million people died.");

                    tvContentTitle4.setText("World War II");
                    tvContent4.setText("World War II, also called Second World War, conflict that involved virtually every part of the world during the years 1939–45.");

                    tvContentTitle5.setText("Neutral Country");
                    tvContent5.setText("Some countries remained ‘neutral’ in World War 2. Such countries were Spain, Sweden and Switzerland – who chose not to join either side.");
                    break;

                case 5:
                    tvStageNum.setText("Chapter 5: Find the First");

                    imgStageLearning.setImageResource(R.drawable.bg_world5);

                    tvContent0.setText("Greetings, Explorer! You have survived the time exploration, Congratulation! Now, you will view the history through passing each big issues......");

                    tvContentTitle1.setText("Paper");
                    tvContent1.setText("The Han dynasty Chinese court official Cai Lun (c. 50–121 CE) is credited as the inventor of a method of papermaking (inspired by wasps and bees) using rags and other plant fibers in 105 CE.");

                    tvContentTitle2.setText("Car");
                    tvContent2.setText("The year 1886 is regarded as the birth year of the modern car when German inventor Karl Benz patented his Benz Patent-Motorwagen.");

                    tvContentTitle3.setText("Airplane");
                    tvContent3.setText("On December 17, 1903, Wilbur and Orville Wright made four brief flights at Kitty Hawk with their first powered aircraft. The Wright brothers had invented the first successful airplane.");

                    tvContentTitle4.setText("Basketball");
                    tvContent4.setText("The history of basketball began with its invention in 1891 in Springfield, Massachusetts by Canadian physical education instructor James Naismith");

                    tvContentTitle5.setText("Smartphone");
                    tvContent5.setText("The tech company IBM is widely credited with developing the world's first smartphone – the bulky but rather cutely named Simon. It went on sale in 1994 and featured a touchscreen, email capability and a handful of built-in apps, including a calculator and a sketch pad.");

                    break;

            }
        }

        else if (skill.equals("history") && tree == 2)
        {
            tvTree.setText("Fact Kingdom");

            switch (stage)
            {
                case 1:
                    tvStageNum.setText("Chapter 1: The Moon");

                    imgStageLearning.setImageResource(R.drawable.bg_fact1);

                    tvContent0.setText("Greetings, Explorer! You are the first explorer to reach here! Hurry up, we gonna use the time machine to explore history of moon!");

                    tvContentTitle1.setText("Do you know?");
                    tvContent1.setText("On July 20, 1969, Neil Armstrong became the first human to step on the moon. He and Aldrin walked around for three hours. They did experiments. They picked up bits of moon dirt and rocks.");

                    tvContentTitle2.setText("The Rocket");
                    tvContent2.setText("Apollo 11 blasted off on July 16, 1969. Neil Armstrong, Edwin Buzz Aldrin and Michael Collins were the astronauts on Apollo 11.");

                    tvContentTitle3.setText("First Artificial Satellite");
                    tvContent3.setText("In 1957 the first artificial satellite, Sputnik 1, was launched into space by Russia.");

                    tvContentTitle4.setText("William Henry Harrison");
                    tvContent4.setText("William Henry Harrison died of either typhoid, pneumonia, or paratyphoid fever 31 days into his term, becoming the first president to die in office and the shortest-serving U.S. president in history.");

                    tvContentTitle5.setText("Last Landing on Moon");
                    tvContent5.setText("Landing 12 people on the moon remains one of NASA's greatest achievements, if not the greatest. More than 45 years after the most recent crewed moon landing — Apollo 17 in December 1972.");

                    break;


                case 2:
                    tvStageNum.setText("Chapter 2: Olympic");

                    imgStageLearning.setImageResource(R.drawable.bg_fact2);

                    tvContent0.setText("Greetings, Explorer! Our time machine is working fine! Let's explore the great Olympic!");

                    tvContentTitle1.setText("First Olympic");
                    tvContent1.setText("The first Olympic Games took place in the 8th century B.C. in Olympia, Greece. They were held every four years for 12 centuries. Then, in the 4th century A.D., all pagan festivals were banned by Emperor Theodosius I and the Olympics were no more.");

                    tvContentTitle2.setText("Modern Olympic");
                    tvContent2.setText("However, the athletic tradition was resurrected about 1500 years later: The first modern Olympics were held in 1896 in Greece.");

                    tvContentTitle3.setText("The Only");
                    tvContent3.setText("Only four athletes have won medals in both the Winter and the Summer Olympics. Only one of them, Christa Ludinger-Rothenburger, won medals in the same year.");

                    tvContentTitle4.setText("Official Languages");
                    tvContent4.setText("The official languages of the games are English and French, complemented by the official language of the host country.");

                    tvContentTitle5.setText("Medals");
                    tvContent5.setText("Michael Phelps has 28 Olympic medals (23 gold, three silver, two bronze) in swimming from four Games (Athens 2004 through to Rio 2016).");

                    break;

                case 3:
                    tvStageNum.setText("Chapter 3: Internet");

                    imgStageLearning.setImageResource(R.drawable.bg_fact3);

                    tvContent0.setText("Greetings, Explorer! Does the script helps? It must be helping....if not, you may not be able to reach here! But, do you know how we connecting each other?");

                    tvContentTitle1.setText("ARPANET");
                    tvContent1.setText("The first workable prototype of the Internet came in the late 1960s with the creation of ARPANET,on January 1, 1983.");

                    tvContentTitle2.setText("Webcam");
                    tvContent2.setText("Beginning in 1991, Cambridge University successfully implemented the first webcam on its own local network. Its sole purpose was to monitor a coffee pot to see how much coffee was left.");

                    tvContentTitle3.setText("First Youtube Video");
                    tvContent3.setText("The first ever YouTube video was uploaded on April 23, 2005. YouTube co-founder Jawed Karim posted the 18-second video, titled \"Me at the zoo.\" ");

                    tvContentTitle4.setText("First Email");
                    tvContent4.setText("The first email that was ever sent was by Ray Tomlinson to himself. Ray Tomlinson was the inventor of the email program on the ARPANET system.");

                    tvContentTitle5.setText("Mobile Internet");
                    tvContent5.setText("Much of the Internet we use right now is using our mobile phones. But the first mobile phone that had Internet connectivity was a Nokia model. The Nokia 9000 Communicator was the first phone with Internet enabled and launched in Finland in 1996. ");

                    break;

                case 4:
                    tvStageNum.setText("Chapter 4: Watch The Building!");

                    imgStageLearning.setImageResource(R.drawable.bg_fact4);

                    tvContent0.setText("Greetings, Explorer! Continue explore the world of building! There are a lot of interesting fact for you to find out more....");

                    tvContentTitle1.setText("Giza");
                    tvContent1.setText("The Great Pyramid of Giza was the tallest structure in the world for over 3,800 years. At 455 feet tall, it was the tallest building in the world from the time of its completion around 2560 BC to 1311 AD.");

                    tvContentTitle2.setText("Concrete");
                    tvContent2.setText("Concrete has been the most popular building material throughout history. In fact, the Ancient Romans created their own special concrete that we’re barely learning the ingredients.");

                    tvContentTitle3.setText("Shortest Skyscraper");
                    tvContent3.setText("The Newby-McMahon Building is the World’s Smallest Skyscraper (40 feet tall)");

                    tvContentTitle4.setText("Eiffel Tower");
                    tvContent4.setText("Eiffel Tower was built as an entrance to the 1889 World Fair in the 100th anniversary of the French revolution, the all-steel structure seemed to rise oddly in an all classic Paris.");

                    tvContentTitle5.setText("Cholula");
                    tvContent5.setText("Mexico's Great Pyramid of Cholula is the largest monument ever constructed on earth, having nearly twice the volume of the Great Pyramid of Giza. A pre-classical masterpiece, it was found to be part of a vast complex of interwoven rooms and temples. Excavations are ongoing.");
                    break;

                case 5:
                    tvStageNum.setText("Chapter 5: Meet The Transport");

                    imgStageLearning.setImageResource(R.drawable.bg_fact5);

                    tvContent0.setText("Greetings, Explorer! We have a research on building the fastest train in the world. However, we are lack of information about train! Would you like to use the time machine to explore the entire journey of train history?");

                    tvContentTitle1.setText("First Steam Train");
                    tvContent1.setText("On September 27, 1825, Locomotion No. 1 became the world's first steam locomotive to carry passengers on a public line, the Stockton and Darlington Railway, in North East England.");

                    tvContentTitle2.setText("Bullet Train");
                    tvContent2.setText("The first high-speed rail system began operations in Japan in 1964, and is known as the Shinkansen, or \"bullet train.\"");

                    tvContentTitle3.setText("Race");
                    tvContent3.setText("America’s first steam locomotive lost a race to a horse.");

                    tvContentTitle4.setText("Longest Route");
                    tvContent4.setText("The Trans-Siberian Railway is a single train line that crosses nearly the entire length of Russia, from Moscow to Vladivostok. It covers a total of 5,772 miles, stretching across a huge swath of Europe and parts of Asia.");

                    tvContentTitle5.setText("Fastest Train");
                    tvContent5.setText("The current world speed record for a commercial train on steel wheels is held by the French TGV at 574.8 km/h (357.2 mph), achieved on 3 April 2007 on the new LGV Est.");

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