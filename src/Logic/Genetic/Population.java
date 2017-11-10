package Logic.Genetic;
import java.util.ArrayList;
public class Population {
    private ArrayList<Individual> populationMembers;

    public Population(int index, boolean elitist){

    }

    public int numIndividuals(){return populationMembers.size(); }

    public Individual getIndividual(int index){ return populationMembers.get(index); }

    public void setIndividual(int index, Individual ind){ populationMembers.add(index,ind); }

    public Individual bestIndividual(FitnessCalculus FC){

    }

    public Individual selectIndividual(FitnessCalculus FC, int index){

    }

    public Population evolvePopulation(FitnessCalculus FC, boolean elitist, int numTournaments, double recombinationUmbral, double mutationRatio){

    }
}
