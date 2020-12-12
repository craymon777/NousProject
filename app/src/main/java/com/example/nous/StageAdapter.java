package com.example.nous;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StageAdapter extends RecyclerView.Adapter<StageModelHolder> {

    Context context;
    private ArrayList<StageModel> arrayList; // List that contain variable parameters (example: stageNum)

    private OnStageListener onStageListener;

    public StageAdapter(Context context, ArrayList<StageModel> arrayList, OnStageListener onStageListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.onStageListener = onStageListener;
    }

    @NonNull
    @Override
    public StageModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.stage_item, null);

        return new StageModelHolder(view, onStageListener); //return the layout view to the holder class.
    }

    @Override
    public void onBindViewHolder(@NonNull StageModelHolder holder, int position) {

        //set data
        holder.tvStageNum.setText(arrayList.get(position).getStageNumber());
        holder.ivStages.setImageResource(arrayList.get(position).getStageImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public interface OnStageListener{
        void onStageClick(int position);
    }

}
