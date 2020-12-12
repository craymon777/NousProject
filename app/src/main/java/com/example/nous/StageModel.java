package com.example.nous;

public class StageModel {
    private String stageNumber;
    private int stageImage;

    public StageModel(String stageNumber, int stageImage) {
        this.stageNumber = stageNumber;
        this.stageImage = stageImage;
    }

    public String getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(String stageNumber) {
        this.stageNumber = stageNumber;
    }

    public int getStageImage() {
        return stageImage;
    }

    public void setStageImage(int stageImage) {
        this.stageImage = stageImage;
    }
}
