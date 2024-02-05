package org.example;

public class TrustTransaction {

    private final Player playerOne;

    private final Player playerTwo;

    public TrustTransaction(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    private void transactRound() {
        Choice playerOneChoice = playerOne.choice();
        Choice playerTwoChoice = playerTwo.choice();

        if(playerOneChoice == Choice.COOPERATE){
            this.playerOne.invest();
            this.playerTwo.gain();
        }
        if(playerTwoChoice == Choice.COOPERATE){
            this.playerTwo.invest();
            this.playerOne.gain();
        }
    }

    public void transact(int noOfRounds) {
        while(noOfRounds-- != 0) {
            transactRound();
        }
    }
}
