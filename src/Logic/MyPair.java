package Logic;

import java.util.*;


/**
 * @author pol.gil
 */

public class MyPair {
    private String key;
    private int value;

    public MyPair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public void Modifykey(String key) {
        this.key = key;
    }

    public void Modifyvalue(int value) {
        this.value = value;
    }

    public String getkey() {
        return key;
    }

    public int getvalue() {
        return value;
    }

}