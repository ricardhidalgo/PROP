package Logic.Genetic;
import java.util.ArrayList;
import java.lang.Math;

public class FitnessCalculus {
    private ArrayList<Solution> solutions = new ArrayList<Solution>();
    private int lastIndex = 0;
    private int turn = 0;

  public void incrementTurn(){ this.turn++; }

    public int getTurn(){ return turn; }

    public double fitnessIndividual(Individual ind){
       /* System.out.println("SOLUTIONS");
        for(int i=0; i<solutions.size(); i++){
            System.out.println(solutions.get(i).getIndividual().toString());
        }
        System.out.println("END SOLUTIONS");*/
        double fitness = 0.0;
        for(int k=0; k<solutions.size(); k++) {
            int black = 0;
            int white = 0;
            for (int i = 0; i < ind.numGenes(); i++) {
                if (ind.getGen(i) == solutions.get(k).getIndividual().getGen(i)) ++black;
                else {
                    for (int j = 0; j < solutions.get(k).getIndividual().numGenes(); j++) {
                        if (ind.getGen(i) == solutions.get(k).getIndividual().getGen(j)) {
                            ++white;
                            break;
                        }
                    }
                }
            }
            fitness += 2*Math.abs(black-solutions.get(k).getBlack()) + Math.abs(white-solutions.get(k).getWhite());
        }
        return fitness+2*ind.numGenes()*(turn);

    }

    public Solution getSolution(int index){
        return solutions.get(index);
    }

    public void addSolution(Solution s){
        solutions.add(s);
    }

    public int getSolutionSize(){
        return solutions.size();
    }

}
