import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrudgePlayerTest {

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(()->new GrudgePlayer());
    }

    @Test
    void expectCooperateAsChoice() {
        Player player = new GrudgePlayer();

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectCooperateAsChoiceAfterOneGainAndInvest() {
        Player player = new GrudgePlayer();

        player.gain();
        player.invest();

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectCheatAsChoiceAfterOneInvest() {
        Player player = new GrudgePlayer();

        player.invest();

        assertEquals(Choice.CHEAT, player.choice());
    }

}
