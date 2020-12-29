package com.example.nous;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostModelHolder> {

    Context context;
    ArrayList<PostModel> modelArrayList;

    public PostAdapter(Context context, ArrayList<PostModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public PostModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.forum_post, parent, false);

        return new PostModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostModelHolder holder, int position) {

        //set data
        holder.tvPostTitle.setText(modelArrayList.get(position).getPostTitle());
        holder.tvPostDate.setText(modelArrayList.get(position).getPostDate());
        holder.ivPostImg.setImageResource(modelArrayList.get(position).getPostImg());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
