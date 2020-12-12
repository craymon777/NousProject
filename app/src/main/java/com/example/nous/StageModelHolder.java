package com.example.nous;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StageModelHolder extends RecyclerView.ViewHolder {

    TextView tvStageNum;
    ImageView ivStages;

    StageAdapter.OnStageListener onStageListener;

    public StageModelHolder(@NonNull View itemView, StageAdapter.OnStageListener onStageListener) {
        super(itemView);

        this.tvStageNum = itemView.findViewById(R.id.tvStageNum);
        this.ivStages = itemView.findViewById(R.id.ivStages);
        this.onStageListener = onStageListener;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStageListener.onStageClick(getAdapterPosition());
            }
        });

    }
}
