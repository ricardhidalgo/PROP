package Logic;

import java.util.*;
import Logic.Combination;
import Logic.Difficulty;

/**
 * @author pol.gil
 */


public class Five_Guess {




    public ArrayList<Combination> Comb = new ArrayList<Combination>();
    public ArrayList<Combination> AuxC;
    public Combination Answer;
    public int nc; //# colors
    public static int n; //# balls
    public Difficulty diff;
    public String Guess;
    public Boolean Finished;


    public Five_Guess(int nc, int n) {
        this.nc = nc;
        this.n = n;
        Finished = false;
        diff = new Difficulty();
        Answer = new Combination(diff);
        Answer.getDifficulty().ModifyNumBallsInCombination(n);
        generate(0, "");
        Guess = generateInitialGuess();
        // NECESITO FUNCION EN COMBINACION QUE ME AÑADA EL VALOR EN STRING DE ESA COMBINACION
        Answer.setValor(Guess);
        AuxC = new ArrayList<Combination> (Comb);
    }


    public String generateInitialGuess() {
        String c = "";
        int count = 0;
        for (int i = 0; i < n; i++) {
            c += count;
            if(i%2 == 1) ++count;
        }
        return c;
    }

    public void generate(int aux, String c) {
        if (aux == n) {
            diff = new Difficulty();
            Answer = new Combination(diff);
            Answer.getDifficulty().ModifyNumBallsInCombination(aux);
            //ME FALTA PONER UNA FUNCION QUE SEA EL VALOR DE LA COMBINATION ANSWER
            Comb.add(Answer);
        }
        else {
            for (int i = 0; i < nc; i++) {
                generate(aux+1, c+i);
            }
        }
    }

    public String Pegs(String Solution, String Guess) {
        String Auxpegs = "";
        String Aux = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /*
                    ESTE BUCLE VA A RECORRER LA RESPUESTA Y LA OPCION POSIBLE
                    Y VA A DEVOLVER 0 SI NO COINCIDE NINGUN NUMERO, 1 SI COINCIDE
                    ALGUN COLOR O 2 SI COINCIDE COLOR Y POSICION.
                */
            }
        }
    }

    public boolean Used(String str1, char ch1) {
        for (int i = 0; i < n; ++i) {
            /*
                VA A EVITAR QUE SE CUENTE DOS VECES EL MISMO COLOR CUANDO SOLO
                HAYA UN EJEMPLAR DE ESE COLOR EN LA RESPUESTA
             */
        }
    }

/*
    public void no_named(String Solution) {
        for (int i = 0; i < Comb.size(); i++) {
            // LA FUNCION GET VALOR ME DARA EL VALOR DEL STRING DE SU COMBINACION
            if (!AreEqual(Comb.get(i).GetValor(), Solution)) Comb.remove(i);
        }
    }

    public boolean AreEqual(String Combination, String Solution) {
        boolean fin = false;
        for (int i = 0; i < n && !fin; i++) {
            for (int j = 0; j < n && !fin; j++) {
                fin = (Combination.getBytes(i) == Solution.getBytes(j));
            }
        }
        return fin;
    }
*/


}
