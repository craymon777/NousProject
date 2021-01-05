package com.example.nous;

public class Ranking implements Comparable<Ranking>{
    int point;
    String username;
    int ranking;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Ranking(String username, int exp_point, int ranking) {
        this.username = username;
        this.point = exp_point;
        this.ranking = ranking;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int exp_point) {
        this.point = exp_point;
    }

    @Override
    public int compareTo(Ranking compare_rank) {
        int compare_exp=((Ranking)compare_rank).getPoint();
        return compare_exp-this.point;
    }

}
