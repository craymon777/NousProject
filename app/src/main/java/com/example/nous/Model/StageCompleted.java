package com.example.nous.Model;

public class StageCompleted {
    int Stage1, Stage2, Stage3, Stage4, Stage5;

    public StageCompleted(){}

    public StageCompleted(int stage1, int stage2, int stage3, int stage4, int stage5) {
        Stage1 = stage1;
        Stage2 = stage2;
        Stage3 = stage3;
        Stage4 = stage4;
        Stage5 = stage5;
    }

    public int getStage1() {
        return Stage1;
    }

    public int getStage2() {
        return Stage2;
    }

    public int getStage3() {
        return Stage3;
    }

    public int getStage4() {
        return Stage4;
    }

    public int getStage5() {
        return Stage5;
    }
}
