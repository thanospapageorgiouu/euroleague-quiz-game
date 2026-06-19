package com.ath.euroquiz.models;

public class Player {
    private String name;
    private int score;

    public Player(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void resetScore(){
        this.score = 0;
    }
    public void incrementScore(){
        this.score += 1;
    }
}
