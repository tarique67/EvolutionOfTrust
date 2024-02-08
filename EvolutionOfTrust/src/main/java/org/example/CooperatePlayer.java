package org.example;

public class CooperatePlayer extends Player{

    public CooperatePlayer() {
        super();
    }
    @Override
    public Choice choice(){
        return Choice.COOPERATE;
    }

    @Override
    public Player clone() {
        return new CooperatePlayer();
    }
}
