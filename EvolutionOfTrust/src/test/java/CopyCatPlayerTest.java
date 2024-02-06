import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyCatPlayerTest {

    @Test
    void expectExceptionIfPlayerCreatedWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new CopyCatPlayer(""));
    }

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(()->new CopyCatPlayer("ABC"));
    }

    @Test
    void expectCheatAsChoice() {
        Player player = new CopyCatPlayer("James");

        assertEquals(Choice.CHEAT, player.choice());
    }

    @Test
    void expectCooperateAsChoiceAfterOneGain() {
        Player player = new CopyCatPlayer("James");

        player.gain();

        assertEquals(Choice.COOPERATE, player.choice());
    }

}
