package Logic;

import java.util.*;


/**
 * @author pol.gil
 */

public class MyPair {
    private String key;
    private int value;


    /**
     * Constructora vacía.
     */
    public MyPair() {

    }

    /**
     * Constructora con key y value preestablecidos.
     * @param key será el nickname de la dupla.
     * @param value será el score de la dupla.
     */
    public MyPair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Modifica la key que tenga la instancia.
     * @param key nuevo nick de la instancia.
     */
    public void Modifykey(String key) {
        this.key = key;
    }

    /**
     * Modifica el value que tenga la instancia.
     * @param value nuevo score del nick.
     */
    public void Modifyvalue(int value) {
        this.value = value;
    }

    /**
     * Retorna el nick de la instancia.
     * @return nick del usuario.
     */
    public String getkey() {
        return key;
    }

    /**
     * Retorna el score de la instancia.
     * @return score del usuario.
     */
    public int getvalue() {
        return value;
    }
}