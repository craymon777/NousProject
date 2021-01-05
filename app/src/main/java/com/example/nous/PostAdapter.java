package com.example.nous;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

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
        holder.tvPostDate.setText(timestampToString((Long)modelArrayList.get(position).getTimeStamp()));
        holder.tvUser.setText(modelArrayList.get(position).getPostUser());
        Glide.with(context).load(modelArrayList.get(position).getPostImg()).into(holder.ivPostImg);
        holder.context = this.context;
        holder.modelArrayList = this.modelArrayList;
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public interface OnPostListener{
        void onPostClick(int position);
    }

    private String timestampToString(long time) {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("dd-MM-yyyy",calendar).toString();
        return date;
    }
}
