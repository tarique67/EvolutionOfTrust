import org.example.CheatPlayer;
import org.example.CopyKittenPlayer;
import org.example.Player;
import org.example.TrustTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyKittenPlayerTest {

    @Test
    void expectCopyKittenPlayerToTrustInFirstRound() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        machine.transact(1);

        assertEquals(-1, copyKittenPlayer.score());
    }
}
