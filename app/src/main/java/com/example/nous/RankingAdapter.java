package com.example.nous;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankingAdapter extends RecyclerView.Adapter<RankingHolder> {

    Context c;
    ArrayList<Ranking> rankings;

    public RankingAdapter(Context c, ArrayList<Ranking> rankings) {
        this.c = c;
        this.rankings = rankings;
    }

    @NonNull
    @Override
    public RankingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_row, null);

        return new RankingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingHolder holder, int position) {


        holder.mUsername.setText(rankings.get(position).getUsername());
        holder.mExp.setText(""+rankings.get(position).getPoint());
        holder.mRanking.setText(""+rankings.get(position).getRanking());

    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }
}
