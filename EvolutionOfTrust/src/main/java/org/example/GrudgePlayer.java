package org.example;

public class GrudgePlayer extends Player{

    private boolean cheat = false;
    private int cheatCount = 0;

    public GrudgePlayer() {
        super();
    }

    @Override
    public  Choice choice(){
        if(cheatCount==1){
            cheat = true;
        }
        Choice choice = Choice.COOPERATE;
        if(cheat)
            choice = Choice.CHEAT;

        return choice;
    }

    @Override
    public void invest() {
        cheatCount++;
        super.invest();
    }

    @Override
    public void gain() {
        cheatCount--;
        super.gain();
    }
}
