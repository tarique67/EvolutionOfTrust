package org.example;

public class CopyKittenPlayer extends Player {

    private boolean gainedLastRound = true;
    public CopyKittenPlayer() {
        super();
    }

    @Override
    public Choice choice(){
        Choice choice = Choice.CHEAT;
        if(gainedLastRound)
            choice = Choice.COOPERATE;
        this.gainedLastRound = false;
        return choice;
    }

    @Override
    public void gain() {
        this.gainedLastRound = true;
        super.gain();
    }
}
