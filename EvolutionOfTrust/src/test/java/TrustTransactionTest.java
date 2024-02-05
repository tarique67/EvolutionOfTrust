import org.example.CheatPlayer;
import org.example.Choice;
import org.example.TrustTransaction;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrustTransactionTest {

    @Test
    void expectNoExceptionIfEotMachineCreatedWithTwoPlayers() {
        Player firstPlayer = new Player("James");
        Player secondPlayer = new Player("Abc");

        assertDoesNotThrow(()-> new TrustTransaction(firstPlayer, secondPlayer));
    }

    @Test
    void expectScore2ForEachPlayerIfBothCooperate() {
        Player firstPlayer = new Player("James");
        Player secondPlayer = new Player("James");
        TrustTransaction machine = new TrustTransaction(firstPlayer, secondPlayer);

        machine.transact(Choice.COOPERATE, Choice.COOPERATE);

        assertEquals(2,firstPlayer.score());
        assertEquals(2,secondPlayer.score());
    }

    @Test
    void expectScore3_Neg1ForEachPlayerIfOneCheatsOtherCooperates() {
        Player firstPlayer = new Player("James");
        Player secondPlayer = new Player("James");
        TrustTransaction machine = new TrustTransaction(firstPlayer, secondPlayer);

        machine.transact(Choice.COOPERATE, Choice.CHEAT);

        assertEquals(-1, firstPlayer.score());
        assertEquals(3, secondPlayer.score());
    }

    @Test
    void expectScore0_0ForBothCheatPlayersForARoundOf5() {
        CheatPlayer firstCheatPlayer = new CheatPlayer("James");
        CheatPlayer secondCheatPlayer = new CheatPlayer("James");
        TrustTransaction machine = new TrustTransaction(firstCheatPlayer, secondCheatPlayer);

        machine.transact(5);

        assertEquals(0, firstCheatPlayer.score());
        assertEquals(0, secondCheatPlayer.score());
    }
}
