package Logic;

import java.io.*;
import java.util.*;

/**
 * @author pol.gil.hernandez
 */

public class FiveGuess {

    private int numBalls;
    private int ballsDiff;
    private ArrayList<String> posibilities = new ArrayList<String>();

    /**
     * Constructora vacía.
     */
    public FiveGuess() {

    }

    public FiveGuess(int numB, int diff) {
        this.numBalls = numB;
        this.ballsDiff = diff;
    }

    public int PosibilitiesSize() {
        return posibilities.size();
    }

    public ArrayList<String> getPosibilities() {
        return posibilities;
    }

    public String FirstGuess() {
        String c = "";
        int count = 0;
        for (int i = 0; i < numBalls; i++) {
            c += count;
            if (i % 2 == 1) ++count;
        }
        return c;
    }

    public void CreateSet(int indice, String c) {
        if (indice == numBalls) posibilities.add(c);
        else {
            String aux;
            for (int i = 0; i < ballsDiff; i++) {
                aux = c;
                c += i;
                CreateSet(indice+1, c);
                c = aux;
            }
        }
    }

    public void Use5G() {
        String x = "";
        CreateSet(0, x);
        FirstGuess();

    }
}
