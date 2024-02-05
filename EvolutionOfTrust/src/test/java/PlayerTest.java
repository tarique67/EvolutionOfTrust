import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void expectExceptionIfPlayerCreatedWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void expectNoExceptionIfPlayerCreatedWithName() {
        assertDoesNotThrow(() -> new Player("James"));
    }

    @Test
    void expectPlayerScore3IfGained() {
        Player player = new Player("ABC");

        player.gain();

        assertEquals(3, player.score());
    }

    @Test
    void expectPlayerScoreNeg1IfInvest() {
        Player player = new Player("ABC");

        player.invest();

        assertEquals(-1, player.score());
    }
}
