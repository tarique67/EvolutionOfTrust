import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TournamentTest {

    @Test
    void expectExceptionIfPassingLessThan5PlayersList() {
        Tournament tournament = new Tournament();
        List<Player> players = new ArrayList<>();
        players.add(new CooperatePlayer());
        players.add(new CooperatePlayer());
        players.add(new CooperatePlayer());

        assertThrows(IllegalArgumentException.class,()-> tournament.add(players));
    }

    @Test
    void expectNoExceptionIfPassingMoreThan5PlayersList() {
        Tournament tournament = new Tournament();
        List<Player> players = new ArrayList<>();
        players.add(new CooperatePlayer());
        players.add(new CopyCatPlayer());
        players.add(new CheatPlayer());
        players.add(new DetectivePlayer());
        players.add(new CopyKittenPlayer());
        players.add(new GrudgePlayer());

        assertDoesNotThrow(()-> tournament.add(players));
    }

    @Test
    void expectPlayersPlay4RoundsEachWhen5PlayersAddedInTournament() {
        Tournament tournament = new Tournament();
        List<Player> players = new ArrayList<>();
        Player player1 = spy(new CooperatePlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CheatPlayer());
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        tournament.add(players);

        tournament.startRound(1);

        verify(player1, times(4)).invest();
        verify(player2, times(1)).gain();
        verify(player3, times(1)).gain();
        verify(player4, times(1)).gain();
        verify(player5, times(1)).gain();
    }

    @Test
    void expectAllPlayersSameInTournament() {
        Tournament tournament = new Tournament();
        List<Player> players = new ArrayList<>();
        players.add(new CooperatePlayer());
        players.add(new CooperatePlayer());
        players.add(new CooperatePlayer());
        players.add(new CooperatePlayer());
        players.add(new CooperatePlayer());
        players.add(new CooperatePlayer());

        tournament.add(players);

        assertTrue(tournament.allPlayersSame());
    }

    @Test
    void expectAllPlayersSameAfterOneRound() {
        Tournament tournament = new Tournament();
        List<Player> players = new ArrayList<>();
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        Player player3 = new CheatPlayer();
        Player player4 = new CheatPlayer();
        Player player5 = new CheatPlayer();
        Player player6 = new CooperatePlayer();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        tournament.add(players);

        tournament.startRound(1);

        assertTrue(tournament.allPlayersSame());
    }

    @Test
    void expectOnlyCheatPlayerRemainInTournament() {
        Tournament tournament = new Tournament();
        List<Player> players = new ArrayList<>();
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        Player player3 = new CheatPlayer();
        Player player4 = new CheatPlayer();
        Player player5 = new CheatPlayer();
        Player player6 = new CooperatePlayer();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        tournament.add(players);

        List<Player> returnedPlayers = tournament.play(5);
        int cheatPlayerCount = 0;
        for(Player player : returnedPlayers){
            if(player.getClass() == CheatPlayer.class) cheatPlayerCount++;
        }

        assertEquals(players.size(), cheatPlayerCount);
    }

    @Test
    void expectOnlyCheatPlayerRemainInTournamentOf1CheatAnd5CooperatePlayers() {
        Tournament tournament = new Tournament();
        List<Player> players = new ArrayList<>();
        Player player1 = new CheatPlayer();
        Player player2 = new CooperatePlayer();
        Player player3 = new CooperatePlayer();
        Player player4 = new CooperatePlayer();
        Player player5 = new CooperatePlayer();
        Player player6 = new CooperatePlayer();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        tournament.add(players);

        List<Player> returnedPlayers = tournament.play(5);
        int cheatPlayerCount = 0;
        for(Player player : returnedPlayers){
            if(player.getClass() == CheatPlayer.class) cheatPlayerCount++;
        }

        assertEquals(players.size(), cheatPlayerCount);
    }

    @Test
    void expectTotalRoundRunsMaxTimes() {
        Tournament tournament = spy(new Tournament());
        List<Player> players = new ArrayList<>();
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        Player player3 = new CheatPlayer();
        Player player4 = new CheatPlayer();
        Player player5 = new CopyCatPlayer();
        Player player6 = new CopyCatPlayer();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        tournament.add(players);

        tournament.play(5);

        verify(tournament,times(100)).startRound(5);
    }
}
