package Logic;

import java.util.*;
import Logic.Combination;
import Logic.Difficulty;

/**
 * @author pol.gil
 */


public class Five_Guess {




    private ArrayList<String> possibleComb = new ArrayList<String>();
    private ArrayList<String> ListComb = new ArrayList<String>();
    private ArrayList<Combination> Answer = new ArrayList<Combination>();

    private String combination = "";
    private String code = "";
    private int totalGuesses = 0;
    private String Guess;
    boolean inicio;

    public int nc; //# colors
    public static int n; //# balls


    public Five_Guess(int nc, int n) {
        this.nc = nc;
        this.n = n;
        generate();
        code = generateInitialGuess();
        StringtoCombination(code);
        getplay();
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

    public void generate() {
        if (combination.length() == n) {
            possibleComb.add(combination);
            ListComb.add(combination);
        }

        else {
            for (int i = 0; i < nc; i++) {
                String oldcomb = combination;
                combination += i;
                generate();
                combination = oldcomb;
            }
        }
    }

    public boolean checkIfPossible(String answer, String randomGuess, Outcome outcome) {  // Checks if the outcome of a randomly given combination, with previously guessed code as the answer, is the same as the the outcome that the user just returned.
        if ((calculatePins(randomGuess, answer).equals(outcome))) {
            return true;
        } else {
            return false;
        }

    }

    public void createScoreList() { // Creates a list of all best guesses.
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
        int minimum = Integer.MAX_VALUE;
        int min;
        for (Outcome outcome : possibleOutcomes) {
            min = 0;
            for (String combination : combList) {
                if (!checkIfPossible(solution, combination, outcome)) {
                    min++;
                }
            }
            if(minimum > min) {
                minimum = min;
            }
        }
        return min;
    }




// IMPLEMENTAR LA RESPUESTA EN LA FUNCION gettry() (la respuesta es una combinacion)

}
