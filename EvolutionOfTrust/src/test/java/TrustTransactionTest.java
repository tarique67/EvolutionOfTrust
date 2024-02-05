import org.example.*;
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
        Player firstPlayer = new CooperatePlayer("James");
        Player secondPlayer = new CooperatePlayer("James");
        TrustTransaction machine = new TrustTransaction(firstPlayer, secondPlayer);

        machine.transact(1);

        assertEquals(2,firstPlayer.score());
        assertEquals(2,secondPlayer.score());
    }

    @Test
    void expectScore3_Neg1ForEachPlayerIfOneCheatsOtherCooperates() {
        Player firstPlayer = new CooperatePlayer("James");
        Player secondPlayer = new CheatPlayer("James");
        TrustTransaction machine = new TrustTransaction(firstPlayer, secondPlayer);

        machine.transact(1);

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

    @Test
    void expectScore10_10ForBothCooperatePlayersForARoundOf5() {
        CooperatePlayer firstCooperatePlayer = new CooperatePlayer("ABC");
        CooperatePlayer secondCooperatePlayer = new CooperatePlayer("DF");
        TrustTransaction machine = new TrustTransaction(firstCooperatePlayer, secondCooperatePlayer);

        machine.transact(5);

        assertEquals(10, firstCooperatePlayer.score());
        assertEquals(10, secondCooperatePlayer.score());
    }

    @Test
    void expectScoreNeg5_15ForCooperatePlayerAndCheatPlayer() {
        CooperatePlayer cooperatePlayer = new CooperatePlayer("ABD");
        CheatPlayer cheatPlayer = new CheatPlayer("BVC");
        TrustTransaction machine = new TrustTransaction(cooperatePlayer, cheatPlayer);

        machine.transact(5);

        assertEquals(-5, cooperatePlayer.score());
        assertEquals(15, cheatPlayer.score());
    }
}
