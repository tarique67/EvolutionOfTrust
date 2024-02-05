import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyCatPlayerTest {

    @Test
    void expectCopyCatPlayerToCheatInFirstRound() {
        Player copyCatPlayer = new CopyCatPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("GFd");
        TrustTransaction machine = new TrustTransaction(copyCatPlayer, cheatPlayer);

        machine.transact(1);

        assertEquals(0, copyCatPlayer.score());
    }

    @Test
    void expectCopyCatPlayerToTrustInSecondRoundWithCooperatePlayer() {
        Player copyCatPlayer = new CopyCatPlayer("ABC");
        Player cooperatePlayer = new CooperatePlayer("GFd");
        TrustTransaction machine = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        machine.transact(2);

        assertEquals(5, copyCatPlayer.score());
    }

    @Test
    void expectCopyCatPlayerToCheatInSecondRoundWithCheatPlayer() {
        Player copyCatPlayer = new CopyCatPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("GFd");
        TrustTransaction machine = new TrustTransaction(copyCatPlayer, cheatPlayer);

        machine.transact(2);

        assertEquals(0, copyCatPlayer.score());
    }
}
