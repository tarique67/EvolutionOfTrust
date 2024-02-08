package org.example;

public class DetectivePlayer extends Player{

    private int roundNo = 0;
    private boolean investedLastRound = false;
    private boolean gainedLastRound = false;
    private boolean isCopyCat = false;

    public DetectivePlayer() {
        super();
    }

    @Override
    public Choice choice() {
        roundNo++;
        Choice choice = Choice.CHEAT;
        if(roundNo==1)
            choice = Choice.COOPERATE;
        else if(roundNo==2)
            choice = Choice.CHEAT;

        if (investedLastRound && !this.isCopyCat) {
            this.isCopyCat = true;
        }
        if (this.isCopyCat && this.roundNo > 2) {
            if (gainedLastRound) {
                choice = Choice.COOPERATE;
            }
            gainedLastRound = false;
        }

        return choice;
    }

    @Override
    public void invest() {
        investedLastRound = true;
        super.invest();
    }

    @Override
    public void gain() {
        gainedLastRound = true;
        if (investedLastRound)
            investedLastRound = false;

        super.gain();
    }
}
