package org.example;

public class CooperatePlayer extends Player{

    public CooperatePlayer(String name) {
        super(name);
    }

    @Override
    public Choice choice(){
        return Choice.COOPERATE;
    }
}
