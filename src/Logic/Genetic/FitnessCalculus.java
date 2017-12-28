package Logic.Genetic;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author albert.ortiz
 */

public class FitnessCalculus {
    private ArrayList<Solution> solutions = new ArrayList<Solution>();
    double b = 2.0;
    double a = 1.0;
    private int turn = 1;

    public FitnessCalculus(double a, double b){
        this.b = b;
        this.a = a;
    }

    public double fitnessIndividual(Individual ind){
        double blackSum = 0.0;
        double whiteSum = 0.0;
        for(Solution s : solutions) {
            int black = 0;
            int white = 0;
            for (int i = 0; i < ind.numGenes(); i++) {
                if (ind.getGen(i) == s.getIndividual().getGen(i)) ++black;
                else {
                    for (int j = 0; j < ind.numGenes(); j++) {
                        if (ind.getGen(i) == s.getIndividual().getGen(j)) {
                            ++white;
                            break;
                        }
                    }
                }
            }
            blackSum += Math.abs(black-s.getBlack());
            whiteSum += Math.abs(white-s.getWhite());
        }
        return a*blackSum + whiteSum +(turn-1)*b;

    }

    public Solution getSolution(int index){
        return solutions.get(index);
    }

    public void addSolution(Solution s){
        solutions.add(s);
        ++turn;
    }

    public int getSolutionSize(){
        return solutions.size();
    }

    public int getTurn(){ return turn; }

}
