package org.example;

import java.util.Objects;

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

    public void addScore(int score) {
        if(score != 0 && score != -1 && score != 3 && score != 2)
            throw new IllegalArgumentException();
        this.score += score;
    }

}
