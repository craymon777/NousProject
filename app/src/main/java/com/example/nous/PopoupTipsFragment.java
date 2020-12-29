package com.example.nous;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PopoupTipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PopoupTipsFragment extends DialogFragment {


    public PopoupTipsFragment() {
        // Required empty public constructor
    }


    public static PopoupTipsFragment newInstance(String param1, String param2) {
        PopoupTipsFragment fragment = new PopoupTipsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextView tvTips;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popoup_tips, container, false);

        String tips = getArguments().getString("TipsValue");

        tvTips = view.findViewById(R.id.tvTips);
        tvTips.setText("Hi Explorer, " + tips);

        return view;
    }
}