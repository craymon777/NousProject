package com.example.nous;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Science1Fragment extends Fragment implements StageAdapter.OnStageListener {

    RecyclerView recyclerView;
    StageAdapter stageAdapter;
    private ArrayList<StageModel> arrayList;

    public Science1Fragment() {
        // Required empty public constructor
    }


    public static Science1Fragment newInstance(String param1, String param2) {
        Science1Fragment fragment = new Science1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_science1, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //set up recycleView
        recyclerView = view.findViewById(R.id.recyclerScience1);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //fill adapter with data
        stageAdapter = new StageAdapter(view.getContext(), getArrayList(),  this);

        //set adapter to recyclerView
        recyclerView.setAdapter(stageAdapter);

        recyclerView.setPadding(70,0,70,0);
    }

    private ArrayList<StageModel> getArrayList()
    {
        arrayList = new ArrayList<>();

        arrayList.add(new StageModel(
                "Stage 1",
                R.drawable.ic_human1));

        arrayList.add(new StageModel(
                "Stage 2",
                R.drawable.ic_human2));

        arrayList.add(new StageModel(
                "Stage 3",
                R.drawable.ic_human3));

        arrayList.add(new StageModel(
                "Stage 4",
                R.drawable.ic_human4));

        arrayList.add(new StageModel(
                "Stage 5",
                R.drawable.ic_human5));




        return arrayList;
    }

    @Override
    public void onStageClick(int position) {
        Intent intent;
        String skill = "science";
        int tree = 1;

        intent = new Intent(this.getContext(), LearningAnimalActivity.class);
        intent.putExtra("skill", skill);
        intent.putExtra("tree", tree);
        intent.putExtra("stage",position+1);
        startActivity(intent);
    }
}