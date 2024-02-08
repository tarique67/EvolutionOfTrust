import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void expectPlayerScore3IfGained() {
        Player player = new Player();

        player.gain();

        assertEquals(3, player.score());
    }

    @Test
    void expectPlayerScoreNeg1IfInvest() {
        Player player = new Player();

        player.invest();

        assertEquals(-1, player.score());
    }
}
