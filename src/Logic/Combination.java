package Logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ricard.hidalgo
 */

public class Combination {

    //private Integer id;
    private ArrayList<Ball> comb;
    private Difficulty difficulty;

    public Combination(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Combination(Combination combination) {
        this.comb = combination.comb;
        this.difficulty = combination.difficulty;
    }

    public ArrayList<Ball> getComb() {
        return comb;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setCombination(ArrayList<Ball> combination, Difficulty dif) /* throws */ {
        //try{

        if (combination.size() == dif.getNumBallsInCombination() || hasRepeat(combination) != dif.isCanRepeat()) {
            System.out.printf("Dificulty not matching combination"); //Aqui va una excepcio
        } else {

            this.difficulty = dif;
            this.comb.addAll(combination);
        }


        //}

    }

    public ArrayList<Integer> compareCombinations(Combination combination) {

        ArrayList<Integer> tips = new ArrayList<>();
        boolean correct = true;


        if (!this.difficulty.equals(combination.difficulty)) {
            System.out.printf("Dificulties not matching");
        }

        for (int i = 0; i < this.comb.size(); ++i) {
            if (this.comb.get(i).equals(combination.comb.get(i))) {
                tips.add(2);
            } else {
                tips.add(0);
                correct = false;

            }

        }

        if (correct) {
            return tips;
        } else {
            return tips; //Completar

        }
    }

    private boolean hasRepeat(ArrayList<Ball> combination) {
        Set<Ball> hcomb = new HashSet<Ball>(combination);
        return combination.size() > hcomb.size();
    }
}
