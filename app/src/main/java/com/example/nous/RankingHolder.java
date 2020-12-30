package com.example.nous;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RankingHolder extends RecyclerView.ViewHolder {

    TextView mUsername, mExp, mRanking;

    public RankingHolder(@NonNull View itemView) {
        super(itemView);

        this.mUsername = itemView.findViewById(R.id.username_tv);
        this.mExp = itemView.findViewById(R.id.experience_tv);
        this.mRanking = itemView.findViewById(R.id.ranking_tv);
    }
}
