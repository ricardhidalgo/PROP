package Logic.Genetic;

import Logic.Combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * @author albert.ortiz
 */

public class GeneticBase {
    //Tweaking this parameters we can affect the overall ai's performance.
    private int maxGenerations = 200;
    private int nIndividualsPopulation =300;
    private boolean elitism = true;  //never change this
    private int numTournaments = 5;
    private double recombinationUmbral = 0.5;
    private double mutationRatio = 0.03;
    private double permutationRatio = 0.03;
    private boolean repeated = true;
    private double inversionRatio = 0.02;
    private int maxSolutions = 120;
    private int turn = 1;
    private FitnessCalculus FC;

    public GeneticBase(int maxGenerations, int nIndividualsPopulation, double recombinationUmbral,
                       double mutationRatio, double permutationRatio, double inversionRatio, int maxSolutions, boolean rep){
        this.repeated = rep;
        FC = new FitnessCalculus();
        this.maxGenerations = maxGenerations;
        this.nIndividualsPopulation = nIndividualsPopulation;
        this.recombinationUmbral = recombinationUmbral;
        this.mutationRatio = mutationRatio;
        this.permutationRatio = permutationRatio;
        this.inversionRatio = inversionRatio;
        this.maxGenerations = maxSolutions;
    }

    public void addSolution(int x, int y, ArrayList<Byte> comb){
        Individual ind = new Individual();
        for(int i=0; i<comb.size(); i++) ind.setGen(i,comb.get(i));
        Solution s = new Solution(x, y, ind);
        FC.addSolution(s);
    }


    public Combination play(){

    }

}

