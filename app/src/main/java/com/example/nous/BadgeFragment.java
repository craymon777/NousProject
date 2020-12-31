package com.example.nous;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BadgeFragment extends Fragment {


    public BadgeFragment() {
        // Required empty public constructor
    }


    public static BadgeFragment newInstance(String param1, String param2) {
        BadgeFragment fragment = new BadgeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Button btnContinue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_badge, container, false);

        btnContinue = view.findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(),HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return view;
    }

    String skill;
    int tree;
    int stage;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //the information here is used to check which stage is done
        //skill is "animal", "science" and "history".
        //tree is 1 or 2
        //stage is 1 to 5
        skill = getActivity().getIntent().getStringExtra("skill");
        tree = getActivity().getIntent().getIntExtra("tree",0);
        stage = getActivity().getIntent().getIntExtra("stage",0);
    }
}