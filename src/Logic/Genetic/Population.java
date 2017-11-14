package Logic.Genetic;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author albert.ortiz
 */

public class Population {
    private Individual populationMembers[];

    public Population(int populationSize, boolean elitist) {
        populationMembers = new Individual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            Individual ind = new Individual();
            ind.initializeIndividual();
            populationMembers[i] = ind;
        }
    }

    public void copy(Population pop) {
        for (int i = 0; i < populationMembers.length; i++) populationMembers[i] = pop.getIndividual(i);
    }

    public int numIndividuals() {
        return populationMembers.length;
    }

    public Individual getIndividual(int index) {
        return populationMembers[index];
    }

    public void setIndividual(int index, Individual ind) {
        populationMembers[index] = ind;
    }

    public Individual bestIndividual(FitnessCalculus FC) {
        double max = 1000000000;
        Individual ind = new Individual();
        for (Individual i : populationMembers) {
            if (i.fitnessIndividual(FC) < max) {
                max = i.fitnessIndividual(FC);
                ind = i;
            }
        }
        return ind;

    }

    public Individual startTournament(int numTournaments, FitnessCalculus FC) {
        double max = 0.0;
        Individual ind = new Individual();
        for (int i = 0; i < numTournaments; i++) {
            Individual ind2 = getIndividual(ThreadLocalRandom.current().nextInt(0, populationMembers.length));
            if (max < ind2.fitnessIndividual(FC)) {
                max = ind2.fitnessIndividual(FC);
                ind = ind2;
            }
        }
        return ind;
    }

    public Population evolvePopulation(FitnessCalculus FC, boolean elitist, int numTournaments, double recombinationUmbral, double mutationRatio, double permutationRatio, double inversionRatio) {
        //SUSCEPTIBLE BUGS
        Population p = new Population(populationMembers.length, elitist);
        p.copy(this);
        Individual bind = p.bestIndividual(FC);
        for (int i = 0; i < populationMembers.length; i++) {
            Individual ind = populationMembers[i];
            if (!elitist | ind != bind) {
                Individual ind1 = startTournament(numTournaments, FC);
                Individual ind2 = startTournament(numTournaments, FC);
                Individual ind3 = new Individual();
                ind3.copy(ind1);
                ind3.recombinateIndividual(ind2, recombinationUmbral);
                ind3.mutateIndividual(mutationRatio);
                ind3.permutateIndividual(mutationRatio);
                // ind3.invertIndividual(mutationRatio);
                p.setIndividual(i, ind3);
            }
        }
        return p;
    }
}
