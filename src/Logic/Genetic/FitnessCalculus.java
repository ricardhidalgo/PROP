package Logic.Genetic;
public class FitnessCalculus {
    private Individual solution;

    public void randomSolution(){
        solution = new Individual();
        solution.initializeIndividual();
    }

    public String stringSolution(){
        return solution.toString();
    }

   // public Individual getSolution(){return solution;}

    public double maxFitness(){
        return  fitnessIndividual(solution);
    }

    public double fitnessIndividual(Individual ind){
        double fitness = 0.0;
        for(int i=0; i<ind.numGenes(); i++){
            if(ind.getGen(i)==solution.getGen(i)) fitness += 1.0;
            else{
                for(int j=0; j<solution.numGenes(); j++){
                    if(ind.getGen(i)==solution.getGen(j)){
                        fitness +=0.5;
                        break;
                    }
                }
            }
        }
        return fitness;

    }


}
