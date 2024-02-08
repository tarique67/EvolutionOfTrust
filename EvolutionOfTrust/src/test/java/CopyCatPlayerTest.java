import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyCatPlayerTest {

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(()->new CopyCatPlayer());
    }

    @Test
    void expectCheatAsChoice() {
        Player player = new CopyCatPlayer();

        assertEquals(Choice.CHEAT, player.choice());
    }

    @Test
    void expectCooperateAsChoiceAfterOneGain() {
        Player player = new CopyCatPlayer();

        player.gain();

        assertEquals(Choice.COOPERATE, player.choice());
    }

}
