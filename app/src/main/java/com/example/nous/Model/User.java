package com.example.nous.Model;

public class User {
    private String Name,Email,Phone, AnimalScore,HistoryScore,ScienceScore, Profilepic;

    public User() { }

    public User(String Name, String Email, String Phone, String AnimalScore, String HistoryScore, String ScienceScore, String Profilepic) {
        this.Name = Name;
        this.Email = Email;
        this.Phone = Phone;
        this.AnimalScore = AnimalScore;
        this.HistoryScore = HistoryScore;
        this.ScienceScore = ScienceScore;
        this.Profilepic = Profilepic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAnimalScore() {
        return AnimalScore;
    }

    public void setAnimalScore(String animalScore) {
        AnimalScore = animalScore;
    }

    public String getHistoryScore() {
        return HistoryScore;
    }

    public void setHistoryScore(String historyScore) {
        HistoryScore = historyScore;
    }

    public String getScienceScore() {
        return ScienceScore;
    }

    public void setScienceScore(String scienceScore) {
        ScienceScore = scienceScore;
    }

    public String getProfilepic() {
        return Profilepic;
    }

    public void setProfilepic(String profilepic) {
        Profilepic = profilepic;
    }
}
