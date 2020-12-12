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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Animal2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Animal2Fragment extends Fragment implements StageAdapter.OnStageListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerView;
    StageAdapter stageAdapter;
    ArrayList<StageModel> arrayList;

    public Animal2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Animal2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Animal2Fragment newInstance(String param1, String param2) {
        Animal2Fragment fragment = new Animal2Fragment();
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
        return inflater.inflate(R.layout.fragment_animal2, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerAnimal2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        stageAdapter = new StageAdapter(view.getContext(), getArrayList(), this);

        recyclerView.setAdapter(stageAdapter);
        recyclerView.setPadding(70,0,70,0);


    }

    private ArrayList<StageModel> getArrayList()
    {
        arrayList = new ArrayList<>();

        arrayList.add(new StageModel(
                "Stage 1",
                R.drawable.ic_tiger));

        arrayList.add(new StageModel(
                "Stage 2",
                R.drawable.ic_tiger));

        arrayList.add(new StageModel(
                "Stage 3",
                R.drawable.ic_tiger));

        arrayList.add(new StageModel(
                "Stage 4",
                R.drawable.ic_tiger));

        arrayList.add(new StageModel(
                "Stage 5",
                R.drawable.ic_tiger));




        return arrayList;
    }

    @Override
    public void onStageClick(int position) {

    }
}