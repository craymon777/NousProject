package com.example.nous;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostModelHolder extends RecyclerView.ViewHolder {

    TextView tvPostTitle, tvPostDate;
    ImageView ivPostImg;


    public PostModelHolder(@NonNull View itemView) {
        super(itemView);

        tvPostTitle = itemView.findViewById(R.id.tvPostTitle);
        tvPostDate = itemView.findViewById(R.id.tvPostDate);

        ivPostImg = itemView.findViewById(R.id.ivPostImg);
    }
}
