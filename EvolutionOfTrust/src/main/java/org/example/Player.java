package org.example;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
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
