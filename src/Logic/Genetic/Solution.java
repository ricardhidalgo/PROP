package Logic.Genetic;

public class Solution {
    private double puntuation = 0.0;
    private Individual ind;

    public Solution(double punt, Individual individual){
        ind = individual;
        puntuation = punt;

    }

    public Individual getIndividual(){return ind;}

    public double getPuntuation(){return puntuation;}

}
