import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrudgePlayerTest {

    @Test
    void expectExceptionIfPlayerCreatedWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new GrudgePlayer(""));
    }

    @Test
    void expectCooperatePlayerCreated() {
        assertDoesNotThrow(()->new GrudgePlayer("ABC"));
    }

    @Test
    void expectCooperateAsChoice() {
        Player player = new GrudgePlayer("James");

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectCooperateAsChoiceAfterOneGainAndInvest() {
        Player player = new GrudgePlayer("James");

        player.gain();
        player.invest();

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectCheatAsChoiceAfterOneInvest() {
        Player player = new GrudgePlayer("James");

        player.invest();

        assertEquals(Choice.CHEAT, player.choice());
    }

}
