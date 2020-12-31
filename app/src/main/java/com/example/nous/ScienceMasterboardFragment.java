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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScienceMasterboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScienceMasterboardFragment extends Fragment {

    RecyclerView recyclerView;
    private RankingAdapter rankingAdapter;
    private ArrayList<Ranking> scienceMasterboardArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScienceMasterboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScienceMasterboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScienceMasterboardFragment newInstance(String param1, String param2) {
        ScienceMasterboardFragment fragment = new ScienceMasterboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_science_masterboard, container, false);
        recyclerView = view.findViewById(R.id.masterboard_recycler_view);

        loadRankings();

        rankingAdapter = new RankingAdapter(recyclerView.getContext(), scienceMasterboardArrayList);
        recyclerView.setAdapter(rankingAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        sortArrayList();
        return view;
    }

    public void sortArrayList(){

        Collections.sort(scienceMasterboardArrayList);
        int counter = 1;
        for (Ranking i : scienceMasterboardArrayList) {
            i.ranking = counter;
            counter++;
        }

        rankingAdapter.notifyDataSetChanged();
    }

    public void loadRankings(){

        scienceMasterboardArrayList = new ArrayList<>();

        scienceMasterboardArrayList.add(new Ranking(
                "Jasper",
                100,
                scienceMasterboardArrayList.size()+1));

        scienceMasterboardArrayList.add(new Ranking(
                "Koo Wei Chong",
                130,
                scienceMasterboardArrayList.size()+1));

        scienceMasterboardArrayList.add(new Ranking(
                "Tan Yue Bing",
                85,
                scienceMasterboardArrayList.size()+1));

        scienceMasterboardArrayList.add(new Ranking(
                "Ng Jing Jie",
                120,
                scienceMasterboardArrayList.size()+1));

        //rankingAdapter = new RankingAdapter(recyclerView.getContext(), scienceMasterboardArrayList);
        //set adapter to recyclerView
        //recyclerView.setAdapter(rankingAdapter);
    }
}