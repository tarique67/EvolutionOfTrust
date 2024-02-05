import org.example.CheatPlayer;
import org.example.GrudgePlayer;
import org.example.Player;
import org.example.TrustTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrudgePlayerTest {

    @Test
    void expectGrudgePlayerToTrustInRound1() {
        Player grudgePlayer = new GrudgePlayer("BGF");
        Player cheatPlayer = new CheatPlayer("CHE");
        TrustTransaction machine = new TrustTransaction(grudgePlayer, cheatPlayer);

        machine.transact(1);

        assertEquals(-1, grudgePlayer.score());
    }
}
