import org.example.CheatPlayer;
import org.example.Choice;
import org.example.CooperatePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CooperatePlayerTest {

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(CooperatePlayer::new);
    }

    @Test
    void expectCooperateAsChoice() {
        CooperatePlayer player = new CooperatePlayer();

        assertEquals(Choice.COOPERATE, player.choice());
    }
}
