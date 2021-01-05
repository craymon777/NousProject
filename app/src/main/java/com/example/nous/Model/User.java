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

    public void addStageCompletedCounter(String skill, int stage) {
        StageCompleted temp=stageCompletedCounter.get(skill);
        temp.addStage(stage);
        stageCompletedCounter.put(skill,temp);
    }

    public HashMap<String, Integer> getBadgeCompletedCounter() {
        return badgeCompletedCounter;
    }

    public boolean getBadge(String skill) {
        StageCompleted check=stageCompletedCounter.get(skill);
        if (check.Stage1>0 && check.Stage2>0 && check.Stage3>0 && check.Stage4>0 && check.Stage5>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
