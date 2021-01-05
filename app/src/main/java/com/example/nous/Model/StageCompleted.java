package com.example.nous.Model;

public class StageCompleted {
    public int Stage1, Stage2, Stage3, Stage4, Stage5;

    public StageCompleted(){}

    public StageCompleted(int stage1, int stage2, int stage3, int stage4, int stage5) {
        Stage1 = stage1;
        Stage2 = stage2;
        Stage3 = stage3;
        Stage4 = stage4;
        Stage5 = stage5;
    }

    public int getStage(int num)
    {
        if (num==1)
            return Stage1;
        else if (num==2)
            return Stage2;
        else if (num==3)
            return Stage3;
        else if (num==4)
            return Stage4;
        else if (num==5)
            return Stage5;
        else
            return 0;
    }

    public void addStage(int num)
    {
        if (num==1)
            Stage1++;
        else if (num==2)
            Stage2++;
        else if (num==3)
            Stage3++;
        else if (num==4)
            Stage4++;
        else if (num==5)
            Stage5++;
    }

}
