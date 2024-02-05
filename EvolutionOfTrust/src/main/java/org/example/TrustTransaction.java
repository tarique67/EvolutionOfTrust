package org.example;

public class TrustTransaction {

    private final Player playerOne;

    private final Player playerTwo;


    public TrustTransaction(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void transact(Choice playerOneChoice, Choice playerTwoChoice) {
        if(playerOneChoice == Choice.COOPERATE && playerTwoChoice == Choice.COOPERATE){
            this.playerOne.addScore(2);
            this.playerTwo.addScore(2);
        }
        if(playerOneChoice == Choice.CHEAT && playerTwoChoice == Choice.COOPERATE) {
            this.playerOne.addScore(3);
            this.playerTwo.addScore(-1);
        }
        if(playerOneChoice == Choice.COOPERATE && playerTwoChoice == Choice.CHEAT) {
            this.playerOne.addScore(-1);
            this.playerTwo.addScore(3);
        }
    }
}
