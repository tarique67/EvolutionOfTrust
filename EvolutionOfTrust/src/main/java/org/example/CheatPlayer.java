package org.example;

public class CheatPlayer extends Player{

    public CheatPlayer() {
        super();
    }

    @Override
    public Choice choice(){
        return Choice.CHEAT;
    }

}
