package com.example.nous;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostModelHolder extends RecyclerView.ViewHolder {

    TextView tvPostTitle, tvPostDate, tvUser;
    ImageView ivPostImg;
    Context context;
    ArrayList<PostModel> modelArrayList;

    public PostModelHolder(@NonNull View itemView) {
        super(itemView);

        tvPostTitle = itemView.findViewById(R.id.tvPostTitle);
        tvPostDate = itemView.findViewById(R.id.tvPostDate);
        tvUser = itemView.findViewById(R.id.tvUser);

        ivPostImg = itemView.findViewById(R.id.ivPostImg);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostActivity.class);
                int position = getAdapterPosition();
                intent.putExtra("title",modelArrayList.get(position).getPostTitle());
                intent.putExtra("content",modelArrayList.get(position).getPostContent());
                intent.putExtra("user",modelArrayList.get(position).getPostUser());
                intent.putExtra("image",modelArrayList.get(position).getPostImg());
                intent.putExtra("postKey",modelArrayList.get(position).getPostKey());
                long timestamp = (long) modelArrayList.get(position).getTimeStamp();
                intent.putExtra("postTimeStamp",timestamp);
                context.startActivity(intent);
            }
        });
    }
}
