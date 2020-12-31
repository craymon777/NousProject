package com.example.nous;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentModelHolder> {

    Context context;
    ArrayList<CommentModel> modelArrayList;

    public CommentAdapter(Context context, ArrayList<CommentModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public CommentModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.post_comment, parent, false);


        return new CommentModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentModelHolder holder, int position) {

        //set data
        holder.tvUsername.setText(modelArrayList.get(position).getUsername());
        holder.tvComment.setText(modelArrayList.get(position).getComment());
        holder.tvCommentDate.setText(modelArrayList.get(position).getCommentDate());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
