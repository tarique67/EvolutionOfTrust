import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyKittenPlayerTest {

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(()->new CopyKittenPlayer());
    }

    @Test
    void expectCooperateAsChoice() {
        Player player = new CopyKittenPlayer();

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectCheatAsChoiceAfterOneGain() {
        Player player = new CopyKittenPlayer();

        player.gain();

        assertEquals(Choice.COOPERATE, player.choice());
    }

}
