package Logic.Genetic;

/**
 * @author albert.ortiz
 */

public class Solution {
    private Pair puntuation = new Pair(0, 0);
    private Individual ind;

    public Solution(Pair punt, Individual individual) {
        ind = individual;
        puntuation = punt;

    }

    public Individual getIndividual() {
        return ind;
    }

    public Pair getPuntuation() {
        return puntuation;
    }

}
