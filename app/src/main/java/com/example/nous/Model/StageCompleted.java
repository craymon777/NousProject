package com.example.nous.Model;

public class StageCompleted {
    public int stage1, stage2, stage3, stage4, stage5;

    public StageCompleted(){}

    public StageCompleted(int Stage1, int Stage2, int Stage3, int Stage4, int Stage5) {
        stage1 = Stage1;
        stage2 = Stage2;
        stage3 = Stage3;
        stage4 = Stage4;
        stage5 = Stage5;
    }

    public int getStage(int num)
    {
        if (num==1)
            return stage1;
        else if (num==2)
            return stage2;
        else if (num==3)
            return stage3;
        else if (num==4)
            return stage4;
        else if (num==5)
            return stage5;
        else
            return 0;
    }

    public void addStage(int num)
    {
        if (num==1)
            stage1++;
        else if (num==2)
            stage2++;
        else if (num==3)
            stage3++;
        else if (num==4)
            stage4++;
        else if (num==5)
            stage5++;
    }

}
