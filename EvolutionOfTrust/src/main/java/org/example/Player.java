package org.example;

import java.util.Random;

public class Player {

    private final String name;

    private int score;

    public Player(String name) {
        if(name.isEmpty())
            throw new IllegalArgumentException();
        this.name = name;
        this.score = 0;
    }

    private void addScore(int score) {
        if(score != -1 && score != 3 )
            throw new IllegalArgumentException();
        this.score += score;
    }

    public Choice choice(){
        return new Random().nextInt(2) == 0 ? Choice.COOPERATE : Choice.CHEAT;
    }

    public int score(){
        return this.score;
    }

    public void invest() {
        addScore(-1);
    }

    public void gain() {
        addScore(3);
    }
}
