package JUnit;

import Logic.*;
import java.util.*;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestRanking {

    @Test
    public void getnick() {
        Ranking aux = new Ranking("Paula", 20);
        String rta = aux.getnick();
        assertEquals("Paula", rta);
    }

    @Test
    public void getscore() {
        Ranking aux = new Ranking("Pol", 21);
        int rta = aux.getscore();
        assertEquals(21, rta, 0);
    }

    @Test
    public void modifynick() {
        Ranking aux = new Ranking("Pol", 20);
        aux.modifynick("Paula");
        assertEquals("Paula", aux.getnick());
    }

    @Test
    public void modifyvalue() {
        Ranking aux = new Ranking("Pol", 20);
        aux.modifyscore(21);
        assertEquals(21, aux.getscore(), 0);
    }

    @Test
    public void getsize() {
        Ranking aux = new Ranking("Pol", 21);
        int size = aux.getsize();
        assertEquals(1, size, 0);
    }

    @Test
    public void getranking() {
        Ranking aux = new Ranking("Pol", 21);
        MyPair aux2 = new MyPair("Pol", 21);
        ArrayList<MyPair> auxi = new ArrayList<MyPair>();
        auxi.add(aux2);
        ArrayList<MyPair> rta = aux.getranking();
        assertEquals(auxi, rta);
    }

    @Test
    public void InsertRanking() {
        Ranking aux = new Ranking("Pol", 21);
        aux.InsertRanking();
        MyPair aux2 = new MyPair("Pol", 21);
        ArrayList<MyPair> auxi = new ArrayList<MyPair>();
        auxi.add(aux2);
        assertSame(auxi, aux.getranking());
    }

}
