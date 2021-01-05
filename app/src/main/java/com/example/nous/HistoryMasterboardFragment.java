package com.example.nous;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryMasterboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryMasterboardFragment extends Fragment {

    RecyclerView recyclerView;
    private RankingAdapter rankingAdapter;
    private ArrayList<Ranking> historyMasterboardArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryMasterboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment masterboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryMasterboardFragment newInstance(String param1, String param2) {
        HistoryMasterboardFragment fragment = new HistoryMasterboardFragment();
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
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_history_masterboard, container, false);
        recyclerView = view.findViewById(R.id.masterboard_recycler_view);
        historyMasterboardArrayList = new ArrayList<>();
        rankingAdapter = new RankingAdapter(recyclerView.getContext(), historyMasterboardArrayList);
        recyclerView.setAdapter(rankingAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User");
        reference.orderByChild("historyMasteryPoint").limitToLast(100);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                historyMasterboardArrayList = new ArrayList<>();
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    historyMasterboardArrayList.add(new Ranking(
                            dataSnapshot.child("name").getValue(String.class),
                            dataSnapshot.child("historyMasteryPoint").getValue(Integer.class),
                            historyMasterboardArrayList.size()+1));
                    Collections.sort(historyMasterboardArrayList);
                    int counter = 1;
                    for (Ranking i : historyMasterboardArrayList) {
                        i.ranking = counter;
                        counter++;
                    }

                }
                rankingAdapter = new RankingAdapter(recyclerView.getContext(), historyMasterboardArrayList);
                recyclerView.setAdapter(rankingAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }

}