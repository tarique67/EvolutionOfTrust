package org.example;

public class CopyKittenPlayer extends Player {
    public CopyKittenPlayer(String name) {
        super(name);
    }

    @Override
    public Choice choice(){
        return Choice.COOPERATE;
    }
}
