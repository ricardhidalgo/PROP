package JUnit;

import org.junit.Test;
import Logic.*;
import java.util.*;
import com.sun.org.apache.xpath.internal.operations.Equals;
import static org.junit.Assert.*;

public class TestDifficulty {

    @Test
    public void setEasy() {
        Difficulty diff = new Difficulty();
        boolean pista = true;
        diff.setEasy(pista);
        assertEquals(4, diff.getNumBallsInCombination(), 0);
    }

    @Test
    public void setMedium() {
        Difficulty diff = new Difficulty();
        boolean pista = true;
        diff.setMedium(pista);
        assertEquals(6, diff.getNumBallsInCombination(), 0);
    }

    @Test
    public void setHard() {
        Difficulty diff = new Difficulty();
        boolean pista = true;
        diff.setHard(pista);
        assertEquals(8, diff.getNumBallsInCombination(), 0);
    }

    @Test
    public void setCustom() {
        Difficulty diff = new Difficulty();
        int numB = 5;
        boolean repeat = true;
        boolean pista = true;
        diff.setCustom(numB, repeat, pista);
        assertEquals(5, diff.getNumBallsInCombination(), 0);
    }

    @Test
    public void getNumballsInCombination() {
        Difficulty diff = new Difficulty(4, true, 5, true);
        int rta = diff.getNumBallsInCombination();
        assertEquals(4, rta, 0);
    }

    @Test
    public void isCanRepeat() {
        Difficulty diff = new Difficulty(4, true, 5, true);
        boolean rta = diff.isCanRepeat();
        assertTrue(rta);
    }

    @Test
    public void getDificultyCode() {
        Difficulty diff = new Difficulty(4, true, 5, true);
        int rta = diff.getDificultyCode();
        assertEquals(5, rta, 0);
    }

    @Test
    public void isHasTips() {
        Difficulty diff = new Difficulty(4, true, 5, true);
        boolean rta = diff.isHasTips();
        assertTrue(rta);
    }


}
