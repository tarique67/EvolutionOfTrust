import org.example.CheatPlayer;
import org.example.Choice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheatPlayerTest {

    @Test
    void expectExceptionIfPlayerCreatedWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new CheatPlayer(""));
    }

    @Test
    void expectCheatPlayerCreated() {
        assertDoesNotThrow(() -> new CheatPlayer("James"));
    }

    @Test
    void expectCheatAsChoice() {
        CheatPlayer player = new CheatPlayer("James");

        assertEquals(Choice.CHEAT, player.choice());
    }

}
