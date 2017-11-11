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
        String pegs = makeplay(Guess);
        // int npi = colores bien en posicion incorrecta, npc colores y posicion correcta
        int npi = 2;
        int npc = 2;




        decreaseAuxC(AuxC, npi, npc);
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

    public void createScoreList() {
        ArrayList<String> bestGuesses = new ArrayList<String>();
        int maxMinimum = 0;
        for (String guess : combList) {
            for (String solution : combList) {
                int minimum = calculateScore(solution);
                if (minimum > maxMinimum) {
                    maxMinimum = minimum;
                    bestGuesses.clear();
                    bestGuesses.add(guess);
                }
                if (minimum == maxMinimum) {
                    bestGuesses.add(guess);
                }

            }

        }
        for (String guess : bestGuesses) {
            if (possibleCombList.contains(guess)) {
                code = guess;
            }
            else {
                code = bestGuesses.get(0);
            }
        }
        System.out.println(bestGuesses.size());
    }

    public int calculateScore(String solution) {
        ArrayList<Integer> minimum = new ArrayList<Integer>();
        for (Outcome outcome : possibleOutcomes) {
            int min = 0;
            for (String combination : combList) {
                if (!checkIfPossible(solution, combination, outcome)) {
                    min++;
                }
            }
            minimum.add(min);
        }

        return  Collections.min(minimum);
    }




// IMPLEMENTAR LA RESPUESTA EN LA FUNCION gettry() (la respuesta es una combinacion)

}
