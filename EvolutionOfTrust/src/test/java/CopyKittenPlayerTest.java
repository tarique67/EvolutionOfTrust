import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyKittenPlayerTest {

    @Test
    void expectExceptionIfPlayerCreatedWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new CopyKittenPlayer(""));
    }

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(()->new CopyKittenPlayer("ABC"));
    }

    @Test
    void expectCooperateAsChoice() {
        Player player = new CopyKittenPlayer("James");

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectCheatAsChoiceAfterOneGain() {
        Player player = new CopyKittenPlayer("James");

        player.gain();

        assertEquals(Choice.COOPERATE, player.choice());
    }

}
