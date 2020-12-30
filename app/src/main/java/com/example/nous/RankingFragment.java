package com.example.nous;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RankingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankingFragment extends Fragment {

    RecyclerView recyclerView;
    private RankingAdapter rankingAdapter;
    private ArrayList<Ranking> rankingArrayList;


    public RankingFragment() {
        // Required empty public constructor
    }

//    public static RankingFragment newInstance(String param1, String param2) {
//        RankingFragment fragment = new RankingFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        loadRankings();
//        sortArrayList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_ranking, container, false);

        recyclerView = view.findViewById(R.id.ranking_recycler_view);

        loadRankings();

        rankingAdapter = new RankingAdapter(recyclerView.getContext(), rankingArrayList);
        recyclerView.setAdapter(rankingAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        sortArrayList();
        return view;
    }

    public void sortArrayList(){

        Collections.sort(rankingArrayList);
        int counter = 1;
        for (Ranking i : rankingArrayList) {
            i.ranking = counter;
            counter++;
        }

        rankingAdapter.notifyDataSetChanged();
    }

    public void loadRankings(){

        rankingArrayList = new ArrayList<>();

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314528,
                rankingArrayList.size()+1));

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314524,
                rankingArrayList.size()+1));

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314530,
                rankingArrayList.size()+1));

        rankingArrayList.add(new Ranking(
                "Jasper",
                1314556,
                rankingArrayList.size()+1));

        //rankingAdapter = new RankingAdapter(recyclerView.getContext(), rankingArrayList);
        //set adapter to recyclerView
        //recyclerView.setAdapter(rankingAdapter);
    }
}