package com.example.nous;

public class Badge {

    private  String name, description;
    private int img, isAchieved;

    public int getIsAchieved() {
        return isAchieved;
    }

    public void setIsAchieved(int isAchieved) {
        this.isAchieved = isAchieved;
    }

    public Badge(String name, String description, int img, int isAchieved) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.isAchieved = isAchieved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
