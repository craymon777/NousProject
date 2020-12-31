package com.example.nous;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostModelHolder extends RecyclerView.ViewHolder {

    TextView tvPostTitle, tvPostDate, tvUser;
    ImageView ivPostImg;

    PostAdapter.OnPostListener onPostListener;


    public PostModelHolder(@NonNull View itemView, PostAdapter.OnPostListener onPostListener) {
        super(itemView);

        tvPostTitle = itemView.findViewById(R.id.tvPostTitle);
        tvPostDate = itemView.findViewById(R.id.tvPostDate);
        tvUser = itemView.findViewById(R.id.tvUser);

        ivPostImg = itemView.findViewById(R.id.ivPostImg);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPostListener.onPostClick(getAdapterPosition());
            }
        });
    }
}
