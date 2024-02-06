import org.example.Choice;
import org.example.DetectivePlayer;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetectivePlayerTest {

    @Test
    void expectExceptionIfPlayerCreatedWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new DetectivePlayer(""));
    }

    @Test
    void expectDetectivePlayerCreated() {
        assertDoesNotThrow(()->new DetectivePlayer("ABC"));
    }

    @Test
    void expectFirstChoiceToBeCooperate() {
        Player player = new DetectivePlayer("ABC");

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectSecondChoiceToCheat() {
        Player player = new DetectivePlayer("ABC");

        player.choice();

        assertEquals(Choice.CHEAT, player.choice());
    }

    @Test
    void expectChoiceCheatAfterTwoGainAndOneInvests() {
        Player player = new DetectivePlayer("ABC");
        player.choice();
        player.choice();

        player.gain();
        player.invest();
        player.gain();

        assertEquals(Choice.CHEAT, player.choice());
    }

    @Test
    void expectChoiceCooperateAfterTwoGainAndTwoInvests() {
        Player player = new DetectivePlayer("ABC");
        player.choice();
        player.choice();

        player.invest();
        player.gain();
        player.invest();
        player.gain();

        assertEquals(Choice.CHEAT, player.choice());
    }
}
