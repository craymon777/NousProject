package com.example.nous;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.bumptech.glide.Glide;
import com.example.nous.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link masterboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class masterboardFragment extends Fragment {

    RecyclerView recyclerView;
    private RankingAdapter rankingAdapter;
    public ArrayList<Ranking> masterboardArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public masterboardFragment() {
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
    public static masterboardFragment newInstance(String param1, String param2) {
        masterboardFragment fragment = new masterboardFragment();
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
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_masterboard, container, false);
        recyclerView = view.findViewById(R.id.masterboard_recycler_view);
        masterboardArrayList = new ArrayList<>();
        rankingAdapter = new RankingAdapter(recyclerView.getContext(), masterboardArrayList);
        recyclerView.setAdapter(rankingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User");
        reference.orderByChild("animalMasteryPoint").limitToLast(100);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                masterboardArrayList = new ArrayList<>();
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    masterboardArrayList.add(new Ranking(
                            dataSnapshot.child("name").getValue(String.class),
                            dataSnapshot.child("animalMasteryPoint").getValue(Integer.class),
                            masterboardArrayList.size()+1));
                    Collections.sort(masterboardArrayList);
                    int counter = 1;
                    for (Ranking i : masterboardArrayList) {
                        i.ranking = counter;
                        counter++;
                    }

                }
                rankingAdapter = new RankingAdapter(recyclerView.getContext(), masterboardArrayList);
                recyclerView.setAdapter(rankingAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;
    }


}