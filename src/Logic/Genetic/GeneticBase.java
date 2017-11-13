package Genetic;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Iterator;
import java.util.Vector;

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
    private Vector<Individual> set;

    public GeneticBase(){
        sol[0] = (byte)(50);
        sol[1] = (byte)(51);
        sol[2] = (byte)(56);
        sol[3] = (byte)(54);
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
        /*for(int j=inds.length-1; j>=0; j--){
            boolean equal = false;
            for(int i=0; i<fc.getSolutionSize(); i++){
                if(inds[j].toString().equals(fc.getSolution(i).toString())) equal = true;
            }
            if(!equal) return  inds[j];
        }*/
        //ind.initializeIndividual();
        return ind;

    }

    public void geneticAlgorithm() {
        FitnessCalculus FC = new FitnessCalculus();
        Individual ind = new Individual();
        ind.initializeIndividual();
        Pair  peir = checkSol(ind);
        Solution so = new Solution(peir, ind);
        //FC.addSolution(so);
        double punt = 0.0;
        int turn = 1;
        while(punt != 4.0){
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

    public Pair checkSol(Individual ind){
        System.out.println(ind.toString());
        double punt = 0.0;
        Pair p = new Pair(0,0);
        for (int i = 0; i < ind.numGenes(); i++) {
            if (ind.getGen(i) == sol[i]) p.x += 1;
            else {
                for (int j = 0; j < sol.length; j++) {
                    if (ind.getGen(i) == sol[j]) {
                        p.y += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(p.x + " "+ p.y);
        return p;
    }

}

