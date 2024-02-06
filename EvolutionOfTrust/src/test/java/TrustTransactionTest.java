import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TrustTransactionTest {

    @Test
    void expectNoExceptionIfEotMachineCreatedWithTwoPlayers() {
        Player firstPlayer = new Player("James");
        Player secondPlayer = new Player("Abc");

        assertDoesNotThrow(()-> new TrustTransaction(firstPlayer, secondPlayer));
    }

    @Test
    void expectScore2ForEachPlayerIfBothCooperate() {
        Player firstPlayer = new CooperatePlayer("James");
        Player secondPlayer = new CooperatePlayer("James");
        TrustTransaction machine = new TrustTransaction(firstPlayer, secondPlayer);

        machine.transact(1);

        assertEquals(2,firstPlayer.score());
        assertEquals(2,secondPlayer.score());
    }

    @Test
    void expectScore3_Neg1ForEachPlayerIfOneCheatsOtherCooperates() {
        Player firstPlayer = new CooperatePlayer("James");
        Player secondPlayer = new CheatPlayer("James");
        TrustTransaction machine = new TrustTransaction(firstPlayer, secondPlayer);

        machine.transact(1);

        assertEquals(-1, firstPlayer.score());
        assertEquals(3, secondPlayer.score());
    }

    @Test
    void expectScore0_0ForBothCheatPlayersForARoundOf5() {
        CheatPlayer firstCheatPlayer = new CheatPlayer("James");
        CheatPlayer secondCheatPlayer = new CheatPlayer("James");
        TrustTransaction machine = new TrustTransaction(firstCheatPlayer, secondCheatPlayer);

        machine.transact(5);

        assertEquals(0, firstCheatPlayer.score());
        assertEquals(0, secondCheatPlayer.score());
    }

    @Test
    void expectScore10_10ForBothCooperatePlayersForARoundOf5() {
        CooperatePlayer firstCooperatePlayer = new CooperatePlayer("ABC");
        CooperatePlayer secondCooperatePlayer = new CooperatePlayer("DF");
        TrustTransaction machine = new TrustTransaction(firstCooperatePlayer, secondCooperatePlayer);

        machine.transact(5);

        assertEquals(10, firstCooperatePlayer.score());
        assertEquals(10, secondCooperatePlayer.score());
    }

    @Test
    void expectScoreNeg5_15ForCooperatePlayerAndCheatPlayer() {
        CooperatePlayer cooperatePlayer = new CooperatePlayer("ABD");
        CheatPlayer cheatPlayer = new CheatPlayer("BVC");
        TrustTransaction machine = new TrustTransaction(cooperatePlayer, cheatPlayer);

        machine.transact(5);

        assertEquals(-5, cooperatePlayer.score());
        assertEquals(15, cheatPlayer.score());
    }

    @Test
    void expectCopyCatPlayerToCheatInFirstRound() {
        Player copyCatPlayer = new CopyCatPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("GFd");
        TrustTransaction machine = new TrustTransaction(copyCatPlayer, cheatPlayer);

        machine.transact(1);

        assertEquals(0, copyCatPlayer.score());
    }

    @Test
    void expectCopyCatPlayerToTrustInSecondRoundWithCooperatePlayer() {
        Player copyCatPlayer = new CopyCatPlayer("ABC");
        Player cooperatePlayer = new CooperatePlayer("GFd");
        TrustTransaction machine = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        machine.transact(2);

        assertEquals(5, copyCatPlayer.score());
    }

    @Test
    void expectCopyCatPlayerToCheatInSecondRoundWithCheatPlayer() {
        Player copyCatPlayer = new CopyCatPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("GFd");
        TrustTransaction machine = new TrustTransaction(copyCatPlayer, cheatPlayer);

        machine.transact(2);

        assertEquals(0, copyCatPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToTrustInFirstRound() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        machine.transact(1);

        assertEquals(-1, copyKittenPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToCheatInSecondRound() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        machine.transact(2);

        assertEquals(-1, copyKittenPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToTrustInSecondRound() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cooperatePlayer = new CooperatePlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        machine.transact(2);

        assertEquals(4, copyKittenPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToTrustFor3Rounds() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cooperatePlayer = new CooperatePlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        machine.transact(3);

        assertEquals(6, copyKittenPlayer.score());
    }

    @Test
    void expectCopyKittenPlayerToCheatFor2_3Rounds() {
        Player copyKittenPlayer = new CopyKittenPlayer("ABC");
        Player cheatPlayer = new CheatPlayer("JHG");
        TrustTransaction machine = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        machine.transact(3);

        assertEquals(-1, copyKittenPlayer.score());
        assertEquals(3, cheatPlayer.score());
    }

    @Test
    void expectGrudgePlayerToTrustInRound1() {
        Player grudgePlayer = new GrudgePlayer("BGF");
        Player cheatPlayer = new CheatPlayer("CHE");
        TrustTransaction machine = new TrustTransaction(grudgePlayer, cheatPlayer);

        machine.transact(1);

        assertEquals(-1, grudgePlayer.score());
    }

    @Test
    void expectGrudgePlayerToCheatInRound2() {
        Player grudgePlayer = new GrudgePlayer("BNV");
        Player cheatPlayer = new CheatPlayer("BVX");
        TrustTransaction machine = new TrustTransaction(grudgePlayer, cheatPlayer);

        machine.transact(2);

        assertEquals(-1, grudgePlayer.score());
    }

    @Test
    void expectGrudgePlayerToCooperateInRound2() {
        Player grudgePlayer = new GrudgePlayer("BNV");
        Player cooperatePlayer = new CooperatePlayer("BVX");
        TrustTransaction machine = new TrustTransaction(grudgePlayer, cooperatePlayer);

        machine.transact(2);

        assertEquals(4, grudgePlayer.score());
    }

    @Test
    void expectGrudgePlayerToCheatInRound2_3() {
        Player grudgePlayer = new GrudgePlayer("BNV");
        Player copyCatPlayer = new CopyCatPlayer("BVX");
        TrustTransaction machine = new TrustTransaction(grudgePlayer, copyCatPlayer);

        machine.transact(3);

        assertEquals(2, grudgePlayer.score());
    }

    @Test
    void expectGrudgePlayerToCooperateInRound2_3() {
        Player grudgePlayer = new GrudgePlayer("BNV");
        Player cooperatePlayer = new CooperatePlayer("BVX");
        TrustTransaction machine = new TrustTransaction(grudgePlayer, cooperatePlayer);

        machine.transact(3);

        assertEquals(6, grudgePlayer.score());
    }

    @Test
    void expectDetectivePlayerToCheatInRound3() {
        Player detectivePlayer = new DetectivePlayer("ABC");
        Player cooperatePlayer = new CooperatePlayer("JHG");
        TrustTransaction machine = new TrustTransaction(detectivePlayer, cooperatePlayer);

        machine.transact(3);

        assertEquals(8, detectivePlayer.score());
        assertEquals(0, cooperatePlayer.score());
    }

    @Test
    void expectDetectivePlayerToCheatInRound3WithCheatPlayer() {
        Player detectivePlayer = spy( new DetectivePlayer("ABC"));
        Player cheatPlayer = spy(new CheatPlayer("JHG"));
        TrustTransaction machine = new TrustTransaction(detectivePlayer, cheatPlayer);

        machine.transact(3);

        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(0)).gain();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    void expectDetectivePlayerToCheatInRound4WithCopyCatPlayer() {
        Player detectivePlayer = spy( new DetectivePlayer("ABC"));
        Player copyCatPlayer = spy(new CopyCatPlayer("JHG"));
        TrustTransaction machine = new TrustTransaction(detectivePlayer, copyCatPlayer);

        machine.transact(4);

        verify(detectivePlayer, times(2)).invest();
        verify(detectivePlayer, times(2)).gain();
        verify(copyCatPlayer, times(2)).invest();
        verify(copyCatPlayer, times(2)).gain();
    }

    @Test
    public void detectivePlayerTransactionWithCopyKittenPlayer() {
        Player detectivePlayer = spy(new DetectivePlayer("ABC"));
        Player copyKitten = spy(new CopyKittenPlayer("HJG"));
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, copyKitten);

        transaction.transact(4);

        verify(detectivePlayer, times(2)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(copyKitten, times(2)).invest();
        verify(copyKitten, times(1)).gain();
    }

}
