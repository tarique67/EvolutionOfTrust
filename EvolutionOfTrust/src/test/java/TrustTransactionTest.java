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

        assertEquals(firstPlayer, secondPlayer);
    }

    @Test
    void expectScore3_Neg1ForEachPlayerIfOneCheatsOtherCooperates() {
        Player firstPlayer = new Player("James");
        Player secondPlayer = new Player("James");
        TrustTransaction machine = new TrustTransaction(firstPlayer, secondPlayer);

        machine.transact(Choice.COOPERATE, Choice.CHEAT);

        assertNotEquals(firstPlayer, secondPlayer);
    }
}
