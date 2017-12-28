package Logic.Genetic;
/**
 * @author albert.ortiz
 */

import java.util.concurrent.ThreadLocalRandom;
public class Population {
    private Individual populationMembers[];

    public Population(int populationSize, boolean elitist){
        populationMembers = new Individual[populationSize];
        for(int i=0; i<populationSize; i++){
            Individual ind = new Individual();
            ind.initializeIndividual();
            //while(!checkPolulation(ind,i)) ind.initializeIndividual();
            populationMembers[i] = ind;
        }
    }

    public void copy(Population pop){
        for(int i=0; i<populationMembers.length; i++) populationMembers[i] = pop.getIndividual(i);
    }

    public int numIndividuals(){return populationMembers.length; }

    public Individual getIndividual(int index){ return populationMembers[index]; }

    public void setIndividual(int index, Individual ind){ populationMembers[index] = ind; }

    public Individual bestIndividual(FitnessCalculus FC){
        double max = 1000000000;
        Individual ind = new Individual();
        for(Individual i : populationMembers){
            if(i.fitnessIndividual(FC) < max){
                max = i.fitnessIndividual(FC);
                ind = i;
            }
        }
        return ind;

    }

    public Individual startTournament(int numTournaments,FitnessCalculus FC){
        double max = 1000000000;
        Individual ind = new Individual();
        for(int i=0; i<numTournaments; i++){
            Individual ind2 = getIndividual(ThreadLocalRandom.current().nextInt(0,populationMembers.length));
            if(max > ind2.fitnessIndividual(FC)){
                max = ind2.fitnessIndividual(FC);
                ind = ind2;
            }
        }
        return ind;
    }

    boolean checkSolution (FitnessCalculus FC, Individual ind){
        for(int i=0; i<FC.getSolutionSize(); i++)
            if(ind.equals(FC.getSolution(i).getIndividual())) return false;
        return true;
    }
/*
    boolean checkPolulation (Individual ind, int index){
        for(int i=0; i<index; i++)
            if(ind.equals(getIndividual(index))) return false;
        return true;
    }*/

    public Population evolvePopulation(FitnessCalculus FC, boolean elitist, int numTournaments, double recombinationUmbral, double mutationRatio, double permutationRatio, double inversionRatio){
        Population p = new Population(populationMembers.length, elitist);
        p.copy(this);
        int index = 0;
        if(elitist && checkSolution(FC,bestIndividual(FC))) {
            p.setIndividual(0, p.bestIndividual(FC));
            ++index;
        }
        for(int i=index; i<populationMembers.length; i++){
            Individual ind1 = startTournament(numTournaments, FC);
            Individual ind2 = startTournament(numTournaments, FC);
            Individual ind3 = ind1.recombinateIndividual(ind2, recombinationUmbral);
            ind3.mutateIndividual(mutationRatio);
            ind3.permutateIndividual(permutationRatio);
            if(ThreadLocalRandom.current().nextDouble(0,1.0) < inversionRatio) ind3.invertIndividual();
            for(int j=0; j<p.numIndividuals(); j++) if(p.getIndividual(j).equals(ind3)) ind3.initializeIndividual();
            while(!checkSolution(FC,ind3)) ind3.mutateIndividual(mutationRatio);
            p.setIndividual(i, ind3);
        }
        return p;
    }
}
