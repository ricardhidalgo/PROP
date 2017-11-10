package Logic.Genetic;

public class GeneticBase {
    //Tweaking this parameters we can affect the overall AI's performance.
    private int maxGenerations = 100;
    private int nIndividualsPopulation = 50;
    private boolean elitism = false;
    private int numTournaments = 5;
    private double recombinationUmbral = 0.5;
    private double mutationRatio = 0.015;

    public void geneticAlgorithm(){
        FitnessCalculus FC = new FitnessCalculus();
    }
}
