package com.example.nous.Model;

import java.util.HashMap;

public class User {
    private String name,email,phone,profilePictureUrl;
    private Integer animalMasteryPoint, historyMasteryPoint, scienceMasteryPoint, experientPoint;
    private HashMap<String, StageCompleted> stageCompletedCounter;
    private HashMap<String, Integer> badgeCompletedCounter;

    public User(){}

    public User(String name, String email, String phone, String profilePictureUrl, Integer animalMasteryPoint, Integer historyMasteryPoint, Integer scienceMasteryPoint,Integer experientPoint,  HashMap<String, StageCompleted> stageCompletedCounter, HashMap<String, Integer> badgeCompletedCounter) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profilePictureUrl = profilePictureUrl;
        this.animalMasteryPoint = animalMasteryPoint;
        this.historyMasteryPoint = historyMasteryPoint;
        this.scienceMasteryPoint = scienceMasteryPoint;
        this.experientPoint = experientPoint;
        this.stageCompletedCounter = stageCompletedCounter;
        this.badgeCompletedCounter = badgeCompletedCounter;

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

    public HashMap<String, Integer> getBadgeCompletedCounter() {
        return badgeCompletedCounter;
    }
}
