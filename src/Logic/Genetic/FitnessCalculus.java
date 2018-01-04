package Logic.Genetic;

import Logic.Combination;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author albert.ortiz
 */

public class FitnessCalculus {
    private ArrayList<Solution> solutions = new ArrayList<Solution>();
    private int turn = 1;

    public double fitnessIndividual(Individual ind){
        double blackSum = 0.0;
        double whiteSum = 0.0;
        double result = -1.0;
        for(Solution s : solutions) {
            int black = 0;
            int white = 0;
            Combination c = s.getIndividual().toCombination();
            Combination c1 = ind.toCombination();
            ArrayList<Byte> correctColors;
            correctColors = c.compareCombinations(c1);
            for (int i = 0; i < correctColors.size(); ++i) {
                if (correctColors.get(i) == 1) ++white;
                else if (correctColors.get(i) == 2) ++black;
            }
            blackSum += Math.abs(black-s.getBlack());
            whiteSum += Math.abs(white-s.getWhite());
            result += 1.0;
        }
        return blackSum + whiteSum;

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
