import org.example.CheatPlayer;
import org.example.Choice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheatPlayerTest {

    @Test
    void expectCheatPlayerCreated() {
        assertDoesNotThrow(() -> new CheatPlayer());
    }

    @Test
    void expectCheatAsChoice() {
        CheatPlayer player = new CheatPlayer();

        assertEquals(Choice.CHEAT, player.choice());
    }

}
