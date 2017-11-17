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

    private boolean repeated(Individual ind){
        for(int i=0; i<ind.numGenes(); i++)
            for(int j=i+1; j<ind.numGenes(); j++)
                if(ind.getGen(i) == ind.getGen(j)) return true;

        return false;
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

    Individual getGuessNoRepeated(Set<Individual> inds){
        for(Individual ind : inds){
            if(!repeated(ind)) return ind;
        }
        Individual ind = new Individual();
        while(repeated(ind)) ind.initializeIndividual();
        return ind;
    }

    public void addSolution(int x, int y, ArrayList<Byte> comb){
        Individual ind = new Individual();
        for(int i=0; i<comb.size(); i++) ind.setGen(i,comb.get(i));
        Solution s = new Solution(x, y, ind);
        FC.addSolution(s);
    }


    public Combination play(){
        Set<Individual> set = new HashSet<>();
        Population p = new Population(nIndividualsPopulation, elitism);
        int counter = 0;
        Individual bestInd = new Individual();
        boolean found = false;
        while(counter<maxGenerations && set.size()<maxSolutions){
            Population p2 = p.evolvePopulation(FC, elitism, numTournaments, recombinationUmbral, mutationRatio, permutationRatio, inversionRatio);
            p = p2;
            set.add(p2.bestIndividual(FC)); //Canviar a la linea comentada si falla.
            if(p2.bestIndividual(FC).fitnessIndividual(FC) == 0){
                bestInd = p2.bestIndividual(FC);
                found = true;
            }
            counter++;
        }
        if(!found) bestInd = getGuess(set, FC);
        if(!repeated) bestInd = getGuessNoRepeated(set);
        FC.incrementTurn();
        turn++;
        String s = "";
        ArrayList<Byte> arrB = new ArrayList<Byte>();
        for(int i=0; i<bestInd.numGenes(); i++) arrB.add(bestInd.getGen(i));
        Combination c = new Combination();
        c.setCombination(arrB);
        return c;
    }

}

