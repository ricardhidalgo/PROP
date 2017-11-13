package Logic.Genetic;
public class FitnessCalculus {
    private Solution solutions[];
    private int lastIndex = 0;

    public FitnessCalculus(int solNum){
        solutions = new Solution[solNum];
        for(int i=0; i<solutions.length; i++){
            Individual ind = new Individual();
            Solution s = new Solution(0.0, ind);
            solutions[i] = s;
        }
    }

    public void randomSolution(){
        Individual ind = new Individual();
        ind.initializeIndividual();
        Solution sol = new Solution(15,ind);
        solutions[0] = sol;
    }

    //  public String stringSolution(){ return solution.toString(); }

    // public Individual getSolution(){return solution;}

    /*public double maxFitness(){

    }*/

    public double fitnessIndividual(Individual ind){
        double fitness = 0.0;
        for(int k=0; k<solutions.length; k++) {
            for (int i = 0; i < ind.numGenes(); i++) {
                if (ind.getGen(i) == solutions[k].getIndividual().getGen(i)) fitness += 1.0;
                else {
                    for (int j = 0; j < solutions[k].getIndividual().numGenes(); j++) {
                        if (ind.getGen(i) == solutions[k].getIndividual().getGen(j)) {
                            fitness += 0.5;
                            break;
                        }
                    }
                }
            }
            fitness *=solutions[k].getPuntuation();
        }
        return fitness;

    }

    public void addSolution(Individual ind, double puntuation){
        Solution sol = new Solution(puntuation,ind);
        solutions[lastIndex] = sol;
        lastIndex++;
    }


}
