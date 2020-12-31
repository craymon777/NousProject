package com.example.nous;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentModelHolder extends RecyclerView.ViewHolder {

    TextView tvUsername, tvComment, tvCommentDate;

    public CommentModelHolder(@NonNull View itemView) {
        super(itemView);

        tvUsername = itemView.findViewById(R.id.tvUsername);
        tvComment = itemView.findViewById(R.id.tvComment);
        tvCommentDate = itemView.findViewById(R.id.tvCommentDate);
    }
}
