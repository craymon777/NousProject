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

    private OnPostListener onPostListener;

    public PostAdapter(Context context, ArrayList<PostModel> modelArrayList, OnPostListener onPostListener) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.onPostListener = onPostListener;
    }

    @NonNull
    @Override
    public PostModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.forum_post, parent, false);

        return new PostModelHolder(view, onPostListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PostModelHolder holder, int position) {

        //set data
        holder.tvPostTitle.setText(modelArrayList.get(position).getPostTitle());
        holder.tvPostDate.setText(modelArrayList.get(position).getPostDate());
        holder.tvUser.setText(modelArrayList.get(position).getPostUser());
        holder.ivPostImg.setImageResource(modelArrayList.get(position).getPostImg());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public interface OnPostListener{
        void onPostClick(int position);
    }
}
