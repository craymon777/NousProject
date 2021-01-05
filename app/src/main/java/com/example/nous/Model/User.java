package com.example.nous.Model;

import java.util.HashMap;

public class User {
    private String name,email,phone,profilePictureUrl;
    private Integer animalMasteryPoint, historyMasteryPoint, scienceMasteryPoint, experientPoint;
    public HashMap<String, StageCompleted> stageCompletedCounter;
    private HashMap<String, Integer> badgeCompletedCounter;

    public User(){}

    public User(String name, String email, String phone, String profilePictureUrl, Integer animalMasteryPoint, Integer historyMasteryPoint, Integer scienceMasteryPoint, HashMap<String, StageCompleted> stageCompletedCounter, HashMap<String, Integer> badgeCompletedCounter, Integer experientPoint) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profilePictureUrl = profilePictureUrl;
        this.animalMasteryPoint = animalMasteryPoint;
        this.historyMasteryPoint = historyMasteryPoint;
        this.scienceMasteryPoint = scienceMasteryPoint;
        this.stageCompletedCounter = stageCompletedCounter;
        this.badgeCompletedCounter = badgeCompletedCounter;
        this.experientPoint =experientPoint;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public Integer getAnimalMasteryPoint() {
        return animalMasteryPoint;
    }

    public Integer getHistoryMasteryPoint() {
        return historyMasteryPoint;
    }

    public Integer getScienceMasteryPoint() {
        return scienceMasteryPoint;
    }

    public Integer getExperientPoint() {
        return experientPoint;
    }

    public HashMap<String, StageCompleted> getStageCompletedCounter() {
        return stageCompletedCounter;
    }

    public void addStageCompletedCounter(String skill,int tree, int stage) {
        StageCompleted temp=stageCompletedCounter.get(skill+tree);
        temp.addStage(stage);
        stageCompletedCounter.put(skill+tree,temp);
    }

    public HashMap<String, Integer> getBadgeCompletedCounter() {
        return badgeCompletedCounter;
    }

    public boolean getBadge(String skill, Integer tree) {
        StageCompleted check=stageCompletedCounter.get(skill+tree);
        if (check.stage1>0 && check.stage2>0 && check.stage3>0 && check.stage4>0 && check.stage5>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
