import org.example.Choice;
import org.example.DetectivePlayer;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetectivePlayerTest {

    @Test
    void expectDetectivePlayerCreated() {
        assertDoesNotThrow(()->new DetectivePlayer());
    }

    @Test
    void expectFirstChoiceToBeCooperate() {
        Player player = new DetectivePlayer();

        assertEquals(Choice.COOPERATE, player.choice());
    }

    @Test
    void expectSecondChoiceToCheat() {
        Player player = new DetectivePlayer();

        player.choice();

        assertEquals(Choice.CHEAT, player.choice());
    }

    @Test
    void expectChoiceCheatAfterTwoGainAndOneInvests() {
        Player player = new DetectivePlayer();
        player.choice();
        player.choice();

        player.gain();
        player.invest();
        player.gain();

        assertEquals(Choice.CHEAT, player.choice());
    }

    @Test
    void expectChoiceCooperateAfterTwoGainAndTwoInvests() {
        Player player = new DetectivePlayer();
        player.choice();
        player.choice();

        player.invest();
        player.gain();
        player.invest();
        player.gain();

        assertEquals(Choice.CHEAT, player.choice());
    }
}
