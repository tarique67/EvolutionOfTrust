package org.example;

public class CopyCatPlayer extends Player{

    private boolean gainedLastRound = false;

    public CopyCatPlayer() {
        super();
    }

    @Override
    public Choice choice(){
        Choice choice = Choice.CHEAT;
        if(gainedLastRound)
            choice = Choice.COOPERATE;

        gainedLastRound = false;
        return choice;
    }

    @Override
    public void gain(){
        this.gainedLastRound = true;
        super.gain();
    }
}
