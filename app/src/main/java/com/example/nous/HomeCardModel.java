package com.example.nous;

public class HomeCardModel {
    String dialog, skill, description;
    int imageSkill;

    public HomeCardModel(String dialog, String skill, String description, int imageSkill) {
        this.dialog = dialog;
        this.skill = skill;
        this.description = description;
        this.imageSkill = imageSkill;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getImageSkill() {
        return imageSkill;
    }

    public void setImageSKill(int image) {
        this.imageSkill = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
