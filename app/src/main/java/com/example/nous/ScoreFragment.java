package com.example.nous;

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

    TextView textView;
    ProgressBar pbCorrectAnswer;

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

        textView = view.findViewById(R.id.tvCorrectAnswer);
        textView.setText(numOfCorrectAns + "/" + totalQuestion);


        //the information here is used to check which stage is done
        //skill is "animal", "science" and "history".
        //tree is 1 or 2
        //stage is 1 to 5
        skill = getActivity().getIntent().getStringExtra("skill");
        tree = getActivity().getIntent().getIntExtra("tree",0);
        stage = getActivity().getIntent().getIntExtra("stage",0);


        //set onclickListener on the button to nav to badge fragment
        btnStageComplete = view.findViewById(R.id.btnStageComplete);
        btnStageComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.navToBadge);

                //return to Homeactivity
            }
        });
    }
}