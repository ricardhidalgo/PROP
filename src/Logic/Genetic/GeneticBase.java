package Logic.Genetic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * @author albert.ortiz
 */

public class GeneticBase {
    //Tweaking this parameters we can affect the overall AI's performance.
    private int maxGenerations = 100;
    private int nIndividualsPopulation =150;
    private boolean elitism = true;  //never change this
    private int numTournaments = 5;
    private double recombinationUmbral = 0.5;
    private double mutationRatio = 0.015;
    private double permutationRatio = 0.03;
    private double inversionRatio = 0.02;
    private byte sol[] = new byte[4];
    private int maxSolutions = 60;
    private FitnessCalculus FC;
    private Vector<Individual> set;

    public GeneticBase(){
        FC = new FitnessCalculus();
    }

    Individual getGuess(Set<Individual> s, FitnessCalculus fc){
        Iterator iterator = s.iterator();
        Individual inds[] = s.toArray(new Individual[s.size()]);
        double max = 100000;
        Individual ind = new Individual();
        for(int i=0; i<inds.length; i++){
            Individual ind2 = inds[i];
            if(max > ind2.fitnessIndividual(fc)){
                max = ind2.fitnessIndividual(fc);
                ind = ind2;
            }
        }
        return ind;
    }

    void addSolution(int x, int y, byte comb[]){

    }

    void play(){
        Set<Individual> set = new HashSet<Individual>();
        Population p = new Population(nIndividualsPopulation, elitism);
        int counter=0;
        while(counter<maxGenerations && set.size()<maxSolutions){
            Population p2 = p.evolvePopulation(FC, elitism, numTournaments, recombinationUmbral, mutationRatio, permutationRatio, inversionRatio);
            p = p2;
            if(counter>maxGenerations/2) set.add(p2.bestIndividual(FC));
            counter++;
        }
        Individual bestInd = new Individual();
        bestInd = getGuess(set,FC);
        Pair pair = checkSol(bestInd);
        punt = pair.x;
        Solution s = new Solution(pair, bestInd);
        FC.addSolution(s);
        turn++;
        FC.setTurn(turn);
    }

}

