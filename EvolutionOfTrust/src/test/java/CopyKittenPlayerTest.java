import org.example.*;
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

    @Test
    void expectCopyKittenPlayerToCheatInSecondRound() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        machine.transact(2);

        assertEquals(-1, copyKittenPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToTrustInSecondRound() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cooperatePlayer = new CooperatePlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        machine.transact(2);

        assertEquals(4, copyKittenPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToTrustFor3Rounds() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cooperatePlayer = new CooperatePlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        machine.transact(3);

        assertEquals(6, copyKittenPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToCheatFor2_3Rounds() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        machine.transact(3);

        assertEquals(-1, copyKittenPlayer.score());
        assertEquals(3, cheatPlayer.score());
    }
}
