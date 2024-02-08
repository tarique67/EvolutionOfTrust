package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private final int noOfPlayers;
    private List<Player> players;

    public Tournament(int noOfPlayers) {
        if(noOfPlayers<5)
            throw new IllegalArgumentException();
        this.noOfPlayers = noOfPlayers;
        this.players = new ArrayList<>();
    }


    public void add(List<Player> players) {
        if(players.size()<noOfPlayers)
            throw new IllegalArgumentException();

        this.players.addAll(players);
    }

    public void start(int noOfRounds) {
        for(int i=0; i< players.size(); i++){
            for(int j=i+1; j<players.size(); j++){
                TrustTransaction machine = new TrustTransaction(players.get(i), players.get(j));
                machine.transact(noOfRounds);
            }
        }
    }

    public boolean allPlayersSame() {
        for(int i=0; i<players.size()-2; i++){
            if(players.get(i).getClass() != players.get(i+1).getClass()) return false;
        }
        return true;
    }

}
