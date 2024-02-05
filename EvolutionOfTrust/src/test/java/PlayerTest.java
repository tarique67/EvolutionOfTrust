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
    void expectScore2Added() {
        Player firstPlayer = new Player("James");
        Player secondPlayer = new Player("James");
        assertEquals(firstPlayer,secondPlayer);

        firstPlayer.addScore(2);

        assertNotEquals(firstPlayer,secondPlayer);
    }

    @Test
    void expectScore0Added() {
        Player firstPlayer = new Player("James");
        Player secondPlayer = new Player("James");
        assertEquals(firstPlayer,secondPlayer);

        firstPlayer.addScore(0);

        assertEquals(firstPlayer,secondPlayer);
    }

    @Test
    void expectExceptionWhenAddingScore5() {
        Player player = new Player("James");

        assertThrows(IllegalArgumentException.class, ()-> player.addScore(5));
    }

    @Test
    void expectExceptionWhenAddingScoreNeg2() {
        Player player = new Player("James");

        assertThrows(IllegalArgumentException.class, ()-> player.addScore(-2));
    }

    @Test
    void expectNoExceptionWhenAddingScoreNeg1() {
        Player player = new Player("James");

        assertDoesNotThrow(()-> player.addScore(-1));
    }
}
