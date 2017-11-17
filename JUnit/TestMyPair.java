package JUnit;



import Logic.MyPair;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMyPair {
    @Test
    public void getkey() {
        MyPair persona = new MyPair("Pol", 21);
        String nickname = persona.getkey();
        assertEquals ("Pol", nickname);
    }

    @Test
    public void getvalue() {
        MyPair persona = new MyPair("Pol", 21);
        int score = persona.getvalue();
        assertEquals (21, score, 0);
    }

    @Test
    public void Modifykey() {
        MyPair persona = new MyPair("Pol", 20);
        persona.Modifykey("Paula");
        assertEquals("Paula", persona.getkey());
    }

    @Test
    public void Modifyvalue() {
        MyPair persona = new MyPair("Pol", 20);
        persona.Modifyvalue(21);
        assertEquals(21, persona.getvalue(), 0);
    }
}
