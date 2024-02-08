package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Tournament {

    private List<Player> players;

    public Tournament() {
        this.players = new ArrayList<>();
    }


    public void add(List<Player> players) {
        if(players.size()<5)
            throw new IllegalArgumentException();

        this.players.addAll(players);
    }

    public List<Player> startRound(int noOfRounds) {
        for(int i=0; i< players.size(); i++){
            for(int j=i+1; j<players.size(); j++){
                TrustTransaction machine = new TrustTransaction(players.get(i), players.get(j));
                machine.transact(noOfRounds);
            }
        }
        this.players.sort(Comparator.comparing(Player::score).reversed());
        removeBottom5();
        cloneTopFive();
        return players;
    }

    private void removeBottom5() {
        for(int i=5; i<players.size(); i++){
            players.remove(players.get(i));
        }
    }

    private List<Player> cloneTopFive() {
        for(int i=0; i<5; i++){
            this.players.add(players.get(i).clone());
        }
        return players;
    }

    public boolean allPlayersSame() {
        for(int i=0; i<players.size()-2; i++){
            if(players.get(i).getClass() != players.get(i+1).getClass()) return false;
        }
        return true;
    }

}
