package org.example;

public class CheatPlayer extends Player{

    public CheatPlayer(String name) {
        super(name);
    }

    public Choice choice(){
        return Choice.CHEAT;
    }
}
