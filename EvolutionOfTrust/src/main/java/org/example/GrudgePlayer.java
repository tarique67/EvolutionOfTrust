package org.example;

public class GrudgePlayer extends Player{
    public GrudgePlayer(String name) {
        super(name);
    }

    @Override
    public  Choice choice(){
        return Choice.COOPERATE;
    }
}
