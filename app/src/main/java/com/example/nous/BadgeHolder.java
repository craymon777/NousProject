package com.example.nous;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BadgeHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mName, mDes;

    public BadgeHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.imgBadge);
        this.mName = itemView.findViewById(R.id.badgeName);
        this.mDes = itemView.findViewById(R.id.badgeDesc);
    }
}
