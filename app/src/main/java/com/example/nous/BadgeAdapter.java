package com.example.nous;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BadgeAdapter extends RecyclerView.Adapter<BadgeHolder> {

    Context c;
    ArrayList<Badge> badges; //this array list create a list of array which parameters define in our badge class

    public BadgeAdapter(Context c, ArrayList<Badge> badges) {
        this.c = c;
        this.badges = badges;
    }

    @NonNull
    @Override
    public BadgeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new BadgeHolder(view); //this will return our view to BadgeHolder class
    }

    @Override
    public void onBindViewHolder(@NonNull BadgeHolder holder, int position) {

        holder.mName.setText(badges.get(position).getName());
        holder.mDes.setText(badges.get(position).getDescription());
        holder.mImageView.setImageResource(badges.get(position).getImg());
        if (badges.get(position).getIsAchieved() == 0) {
            holder.mImageView.setImageResource(R.drawable.question);
        }

        if (badges.get(position).getIsAchieved() == 1) {
            holder.mDes.setText("You have achieved the badge!");
        }

    }

    @Override
    public int getItemCount() {
        return badges.size();
    }
}
