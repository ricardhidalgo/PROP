package JUnit;

import Logic.*;
import java.util.*;

import com.sun.javafx.PlatformUtil;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPlay {

    @Test
    public void getCombination() {
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb2 = new Combination(combi);
        Play jugada = new Play();
        jugada.modifyComb(comb2);
        Combination comb = jugada.getCombination();
        assertEquals(combi, comb, 0);
    }

    @Test
    public void getNumCorrectPositions() {
        Play jugada = new Play();
        jugada.modifyPosition(3);
        int cpositions = jugada.getNumCorrectPositions();
        assertEquals(3, cpositions, 0);
    }

    @Test
    public void getNumCorrectColors() {
        Play jugada = new Play();
        jugada.modifyColor(2);
        int correctc = jugada.getNumCorrectColors();
        assertEquals(2, correctc, 0);
    }

}
