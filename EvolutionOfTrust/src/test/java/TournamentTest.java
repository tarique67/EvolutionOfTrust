import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TournamentTest {

    @Test
    void expectExceptionForTournamentWith0NumberOfPlayers() {
        assertThrows(IllegalArgumentException.class, ()-> new Tournament(3));
    }

    @Test
    void expectNoExceptionForTournamentWithValidNumberOfPlayers() {
        assertDoesNotThrow(()-> new Tournament(10));
    }

    @Test
    void expectExceptionIfPassingLessThan5PlayersList() {
        Tournament tournament = new Tournament(10);
        List<Player> players = new ArrayList<>();
        players.add(new CooperatePlayer("CVD"));
        players.add(new CooperatePlayer("GFD"));
        players.add(new CooperatePlayer("HGD"));

        assertThrows(IllegalArgumentException.class,()-> tournament.add(players));
    }

    @Test
    void expectNoExceptionIfPassingMoreThan5PlayersList() {
        Tournament tournament = new Tournament(6);
        List<Player> players = new ArrayList<>();
        players.add(new CooperatePlayer("CVD"));
        players.add(new CopyCatPlayer("GFD"));
        players.add(new CheatPlayer("HGD"));
        players.add(new DetectivePlayer("saa"));
        players.add(new CopyKittenPlayer("dew"));
        players.add(new GrudgePlayer("ews"));

        assertDoesNotThrow(()-> tournament.add(players));
    }

    @Test
    void expectPlayersPlay5RoundsEachWhen6PlayersEnrolled() {
        Tournament tournament = new Tournament(5);
        List<Player> players = new ArrayList<>();
        Player player1 = spy(new CooperatePlayer("CVD"));
        Player player2 = spy(new CheatPlayer("GFD"));
        Player player3 = spy(new CheatPlayer("HGD"));
        Player player4 = spy(new CheatPlayer("saa"));
        Player player5 = spy(new CheatPlayer("dew"));
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        tournament.add(players);

        tournament.start(1);

        verify(player1, times(4)).invest();
        verify(player2, times(1)).gain();
        verify(player3, times(1)).gain();
        verify(player4, times(1)).gain();
        verify(player5, times(1)).gain();
    }

    @Test
    void expectAllPlayersSameInTournament() {
        Tournament tournament = new Tournament(6);
        List<Player> players = new ArrayList<>();
        players.add(new CooperatePlayer("CVD"));
        players.add(new CooperatePlayer("GFD"));
        players.add(new CooperatePlayer("HGD"));
        players.add(new CooperatePlayer("saa"));
        players.add(new CooperatePlayer("dew"));
        players.add(new CooperatePlayer("ews"));

        tournament.add(players);

        assertTrue(tournament.allPlayersSame());
    }


}
