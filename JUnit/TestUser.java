package JUnit;

import Logic.*;
import java.util.*;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestUser {

    @Test
    public void getNickname() {
        User usuario = new User("Pol", "1234");
        String nombre = usuario.getNickname();
        assertEquals("Pol", nombre, 0);
    }

    @Test
    public void validateUser() {
        User usuario = new User("Pol", "1234");
        boolean valido = usuario.validateUser();
        assertEquals(true, valido, 0);

    }
}
