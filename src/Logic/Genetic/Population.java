package Logic.Genetic;
/**
 * @author albert.ortiz
 */

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Population {
    private Individual populationMembers[];
    private boolean repeated = false;

    public Population(int populationSize, boolean elitist, FitnessCalculus FC, boolean repeated){
        populationMembers = new Individual[populationSize];
        this.repeated = repeated;
        for(int i=0; i<populationSize; i++){
            Individual ind = new Individual();
            ind.initializeIndividual();
            while(!checkPolulation(ind,i) || !checkSolution(FC, ind) || !checkDifferent(ind)) ind.initializeIndividual();
            populationMembers[i] = ind;
        }
    }

    boolean checkDifferent(Individual ind){
        if (repeated) return true;
        for(int i=0; i<ind.numGenes(); i++)
            for(int j=i+1; j<ind.numGenes(); j++)
                if(ind.getGen(i) == ind.getGen(j)) return false;
        return true;
    }

    public void copy(Population pop){
        for(int i=0; i<populationMembers.length; i++) populationMembers[i] = pop.getIndividual(i);
    }

    public int numIndividuals(){return populationMembers.length; }

    public Individual getIndividual(int index){ return populationMembers[index]; }

    public void setIndividual(int index, Individual ind){ populationMembers[index] = ind; }

    public ArrayList<Individual> bestIndividual(FitnessCalculus FC){
        ArrayList<Individual> ind = new ArrayList<Individual>();
        for(Individual i : populationMembers){
            if(i.fitnessIndividual(FC) == 0)
                ind.add(i);
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

    boolean checkPolulation (Individual ind, int index){
        for(int i=0; i<index; i++)
            if(ind.equals(getIndividual(i))) return false;
        return true;
    }

    public Population evolvePopulation(FitnessCalculus FC, boolean elitist, int numTournaments, double recombinationUmbral, double mutationRatio, double permutationRatio, double inversionRatio){
        Population p = new Population(populationMembers.length, elitist, FC, repeated);
        p.copy(this);
        int index = 0;
        if(elitist && bestIndividual(FC).size()!=0 && checkSolution(FC,bestIndividual(FC).get(0))) {
            p.setIndividual(0, p.bestIndividual(FC).get(0));
            ++index;
        }
        Individual best = new Individual();
        double max = 99999.0;
        for(int i=index; i < populationMembers.length; i++){
            Individual ind1 = startTournament(numTournaments, FC);
            Individual ind2 = startTournament(numTournaments, FC);
            Individual ind3 = ind1.recombinateIndividual(ind2, recombinationUmbral);
            ind3.mutateIndividual(mutationRatio);
            ind3.permutateIndividual(permutationRatio);
            if(ThreadLocalRandom.current().nextDouble(0,1.0) < inversionRatio) ind3.invertIndividual();
            while(!checkSolution(FC,ind3) || !checkPolulation(ind3,i) || !checkDifferent(ind3)) ind3.initializeIndividual();
            p.setIndividual(i, ind3);
            if(ind3.fitnessIndividual(FC)< max){best = ind3; max = best.fitnessIndividual(FC);}
        }
        return p;
    }
}
