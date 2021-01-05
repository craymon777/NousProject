package com.example.nous;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nous.Model.StageCompleted;
import com.example.nous.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class ScoreFragment extends Fragment {


    public ScoreFragment() {
        // Required empty public constructor
    }

    public static ScoreFragment newInstance(String param1, String param2) {
        ScoreFragment fragment = new ScoreFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_score, container, false);


        return view;
    }

    TextView textView, textView1, textView2;
    ProgressBar pbCorrectAnswer, pbMastery, pbExp;
    User currentUser;

    Button btnStageComplete;

    String skill;
    int tree;
    int stage;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //get intent from the parent activity
        int numOfCorrectAns = getActivity().getIntent().getIntExtra("correct",0);
        int totalQuestion = getActivity().getIntent().getIntExtra("totalQuestion", 0);

        pbCorrectAnswer = view.findViewById(R.id.pbCorrectAnswer);
        pbCorrectAnswer.setMax(totalQuestion);
        pbCorrectAnswer.setProgress(numOfCorrectAns);
        pbMastery = view.findViewById(R.id.pbMasteryAdd);
        pbMastery.setMax(totalQuestion*20);
        pbMastery.setProgress(numOfCorrectAns*20);
        pbExp = view.findViewById(R.id.pbExpAdd);
        pbExp.setMax(totalQuestion*20);
        pbExp.setMax(numOfCorrectAns*20);

        textView = view.findViewById(R.id.tvCorrectAnswer);
        textView.setText(numOfCorrectAns + "/" + totalQuestion);
        textView1 = view.findViewById(R.id.tvMasteryAdd);
        textView1.setText(numOfCorrectAns*20 + "/" + totalQuestion*20);
        textView2 = view.findViewById(R.id.tvExpAdd);
        textView2.setText(numOfCorrectAns*20 + "/" + totalQuestion*20);



        //the information here is used to check which stage is done
        //skill is "animal", "science" and "history".
        //tree is 1 or 2
        //stage is 1 to 5
        skill = getActivity().getIntent().getStringExtra("skill");
        tree = getActivity().getIntent().getIntExtra("tree",0);
        stage = getActivity().getIntent().getIntExtra("stage",0);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                currentUser = snapshot.getValue(User.class);
                Integer xp=currentUser.getExperientPoint();
                reference.child("experientPoint").setValue(xp+numOfCorrectAns*20);
                if(skill.equals("animal"))
                {
                    Integer mastery=currentUser.getAnimalMasteryPoint();
                    reference.child("animalMasteryPoint").setValue(mastery+numOfCorrectAns*20);
                }if(skill.equals("science"))
                {
                    Integer mastery=currentUser.getScienceMasteryPoint();
                    reference.child("scienceMasteryPoint").setValue(mastery+numOfCorrectAns*20);
                }if(skill.equals("history"))
                {
                    Integer mastery=currentUser.getHistoryMasteryPoint();
                    reference.child("historyMasteryPoint").setValue(mastery+numOfCorrectAns*20);
                }
                HashMap<String, StageCompleted> stageCounter=currentUser.getStageCompletedCounter();
                reference.child("stageCompletedCounter").child(skill).child("Stage"+stage).setValue(stageCounter.get(skill).getStage(stage)+1);
                currentUser.addStageCompletedCounter(skill,stage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //set onclickListener on the button to nav to badge fragment
        btnStageComplete = view.findViewById(R.id.btnStageComplete);
        btnStageComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentUser.getBadge(skill))
                {
                    if(skill.equals("animal") && currentUser.getBadgeCompletedCounter().get("badge1")==0)
                    {
                        reference.child("badgeCompletedCounter").child("badge1").setValue(1);
                    }
                    else if(skill.equals("science") && currentUser.getBadgeCompletedCounter().get("badge2")==0)
                    {
                        reference.child("badgeCompletedCounter").child("badge2").setValue(1);
                    }
                    else if(skill.equals("history") && currentUser.getBadgeCompletedCounter().get("badge3")==0)
                    {
                        reference.child("badgeCompletedCounter").child("badge3").setValue(1);
                    }
                    else if(currentUser.getBadgeCompletedCounter().get("badge4")==0 && currentUser.getBadgeCompletedCounter().get("badge1")==1 && currentUser.getBadgeCompletedCounter().get("badge2")==1 && currentUser.getBadgeCompletedCounter().get("badge3")==1)
                    {
                        reference.child("badgeCompletedCounter").child("badge4").setValue(1);
                    }
                    else
                    {
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);
                    }
                    Navigation.findNavController(view).navigate(R.id.navToBadge);
                }
                else
                {
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}