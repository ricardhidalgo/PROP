package JUnit;

import Logic.*;
import java.util.*;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFinishedGame {

    @Test
    public void getPuntuation() {
        User user = new User();
        Combination comb = new Combination();
        ArrayList<Play> plays = new ArrayList<Play>();
        Difficulty diff = new Difficulty();
        FinishedGame endgame = new FinishedGame(user, true, comb, plays, diff, 5);
        int rta = endgame.getPuntuation();
        assertEquals(5, rta, 0);
    }

    @Test
    public void setPuntuation() {
        User user = new User();
        Combination comb = new Combination();
        ArrayList<Play> plays = new ArrayList<Play>();
        Difficulty diff = new Difficulty();
        FinishedGame endgame = new FinishedGame(user, true, comb, plays, diff, 18);
        endgame.setPuntuation(5);
        assertEquals(5, endgame.getPuntuation(), 0);
    }
}
