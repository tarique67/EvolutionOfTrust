import org.example.CheatPlayer;
import org.example.Choice;
import org.example.CooperatePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CooperatePlayerTest {

    @Test
    void expectExceptionIfPlayerCreatedWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new CooperatePlayer(""));
    }

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(()->new CooperatePlayer("ABC"));
    }

    @Test
    void expectCooperateAsChoice() {
        CooperatePlayer player = new CooperatePlayer("James");

        assertEquals(Choice.COOPERATE, player.choice());
    }
}
