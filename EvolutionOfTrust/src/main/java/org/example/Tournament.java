package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tournament {

    private List<Player> players;

    private int maxRounds = 100;

    public Tournament() {
        this.players = new ArrayList<>();
    }


    public void add(List<Player> players) {
        if(players.size()<5)
            throw new IllegalArgumentException();

        this.players.addAll(players);
    }

    public List<Player> play(int noOfRounds){
        while(maxRounds-- >0 && !allPlayersSame()){
            startRound(noOfRounds);
        }
        return players;
    }

    public void startRound(int noOfRounds) {
        for(int i=0; i< players.size(); i++){
            for(int j=i+1; j<players.size(); j++){
                TrustTransaction machine = new TrustTransaction(players.get(i), players.get(j));
                machine.transact(noOfRounds);
            }
        }
        this.players.sort(Comparator.comparing(Player::score).reversed());
        eliminateBottomFive();
        cloneAllPlayers();
    }

    private void cloneAllPlayers() {
        for(int i=0; i<players.size(); i++){
            players.set(i, players.get(i).clone());
        }
    }

    private void eliminateBottomFive() {
        int i = 0;
        int j = 5;
        while(i<5 && j<players.size()){
            players.set(j, players.get(i).clone());
            i++;
            j++;
        }
    }

    public boolean allPlayersSame() {
        Player player = players.getFirst();
        for(int i=1; i<players.size(); i++){
            if(players.get(i).getClass() != player.getClass()) return false;
        }
        return true;
    }

}
