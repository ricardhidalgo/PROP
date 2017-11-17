package JUnit;

import Logic.*;
import java.util.*;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCombination {

    @Test
    public void getComb() {
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb2 = new Combination(combi);
        ArrayList<Byte> rta = comb2.getComb();
        assertEquals(combi, rta);
    }

    @Test
    public void setCombination() {
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb2 = new Combination(combi);
        comb2.setCombination(combi);
        assertEquals(combi, comb2.getComb());
    }

    @Test
    public void compareCombinations() {
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb2 = new Combination(combi);
        ArrayList<Byte> combi2 = new ArrayList<Byte>();
        combi2.add((byte)2);
        Combination comb3 = new Combination(combi2);
        ArrayList<Byte> rta = comb2.compareCombinations(comb3);
        assertEquals(combi, rta);
    }
}
