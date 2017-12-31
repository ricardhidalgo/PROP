package Logic.Genetic;

import Logic.Combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author albert.ortiz
 */

public class GeneticBase {
    //Tweaking this parameters we can affect the overall ai's performance.
    private int maxGenerations = 500;
    private int nIndividualsPopulation =500;
    private boolean elitism = true;  //never change this
    private int numTournaments = 10;
    private double recombinationUmbral = 0.5;
    private double mutationRatio = 0.03;
    private double permutationRatio = 0.03;
    private boolean repeated = true;
    private double inversionRatio = 0.02;
    private int maxSize = 200;
    private int turn = 1;
    //Fitness function parameters "a" is the blackpin weight
    private double a = 2.0;
    private double b = 1.0;
    private FitnessCalculus FC;

    public GeneticBase(int maxGenerations,         int nIndividualsPopulation,
                       double recombinationUmbral, double mutationRatio,
                       double permutationRatio,    double inversionRatio,
                       int maxSolutions,           boolean rep){

        this.repeated = rep;
        FC = new FitnessCalculus(a,b);
        this.maxGenerations = maxGenerations;
        this.nIndividualsPopulation = nIndividualsPopulation;
        this.recombinationUmbral = recombinationUmbral;
        this.mutationRatio = mutationRatio;
        this.permutationRatio = permutationRatio;
        this.inversionRatio = inversionRatio;
        this.maxGenerations = maxSolutions;
    }

    public void addSolution(int black, int white, ArrayList<Byte> comb){
        Individual ind = new Individual();
        for(int i=0; i<comb.size(); i++) ind.setGen(i,comb.get(i));
        Solution s = new Solution(black, white, ind);
        FC.addSolution(s);
    }

    Individual getRandomFromSet(Set<Individual> s){
        int i = 0;
        int counter = 0;
        Individual indio = new Individual();
        i = ThreadLocalRandom.current().nextInt(0, s.size());
        for (Iterator<Individual> it = s.iterator(); it.hasNext();) {
            Individual ind = it.next();
            if(i == counter) indio = ind;
            ++counter;
        }
        return indio;
    }

    Individual getBestFromSet(Set<Individual> s, FitnessCalculus FC) {
        int max = 99999999;
        Individual best = new Individual();
        for (Iterator<Individual> it = s.iterator(); it.hasNext();) {
            Individual ind = it.next();
            if(ind.fitnessIndividual(FC)<max) best = ind;
        }
        return best;
    }

    public Combination play(){
        int height = 1;
        Set<Individual> E = new HashSet<>();
        Population p = new Population(nIndividualsPopulation, elitism);
        while(maxGenerations >= height && E.size() < maxSize){
            p.evolvePopulation(FC,elitism,numTournaments,
                                recombinationUmbral,mutationRatio,
                                permutationRatio,inversionRatio);
            E.add(p.bestIndividual(FC));
            ++height;
        }
        Combination c = new Combination();
        Individual i = getBestFromSet(E,FC);
        return i.toCombination();
    }

    public static void main(String[] args) {
        Set<Individual> s = new HashSet<>();
        Individual ind = new Individual();
        ind.initializeIndividual();
        Individual ind2 = new Individual();
        ind2.initializeIndividual();
        if(ind.equals(ind2)) System.out.println("Iguales");
        s.add(ind);
        s.add(ind2);
        System.out.println(s.size());
    }

}

