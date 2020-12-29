package com.example.nous;

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


public class History1Fragment extends Fragment implements StageAdapter.OnStageListener {

    RecyclerView recyclerView;
    StageAdapter stageAdapter;
    private ArrayList<StageModel> arrayList;

    public History1Fragment() {
        // Required empty public constructor
    }


    public static History1Fragment newInstance(String param1, String param2) {
        History1Fragment fragment = new History1Fragment();
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
        return inflater.inflate(R.layout.fragment_history1, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //set up recycleView
        recyclerView = view.findViewById(R.id.recyclerHistory1);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //fill adapter with data
        stageAdapter = new StageAdapter(view.getContext(), getArrayList(),this);

        //set adapter to recyclerView
        recyclerView.setAdapter(stageAdapter);

        recyclerView.setPadding(70,0,70,0);


        //set onclickListener here


    }

    private ArrayList<StageModel> getArrayList()
    {
        arrayList = new ArrayList<>();

        arrayList.add(new StageModel(
                "Stage 1",
                R.drawable.ic_ocean1));

        arrayList.add(new StageModel(
                "Stage 2",
                R.drawable.ic_ocean2));

        arrayList.add(new StageModel(
                "Stage 3",
                R.drawable.ic_ocean3));

        arrayList.add(new StageModel(
                "Stage 4",
                R.drawable.ic_ocean4));

        arrayList.add(new StageModel(
                "Stage 5",
                R.drawable.ic_ocean5));




        return arrayList;
    }

    @Override
    public void onStageClick(int position) {

    }
}