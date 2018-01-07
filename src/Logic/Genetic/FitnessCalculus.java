package Logic.Genetic;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author albert.ortiz
 */

public class FitnessCalculus {
    private HashSet<Solution> solutions = new HashSet<>();

    public double fitnessIndividual(Individual ind){
        /**
         * Genera
         * @param result resultado de la respuesta anterior.
         * @return devuelve la combinacion a jugar.
         */
        double fitness = 0.0;
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
            fitness += Math.abs(black-s.getBlack()) + Math.abs(white-s.getWhite());
        }
        return fitness;//+2*ind.numGenes()*(turn);

    }

    public Solution getSolution(int index){
        int counter = 0;
        Solution sol = new Solution(0, 0, new Individual());
        for(Solution s : solutions){
            if(counter == index) sol = s;
            ++counter;
        }
        return sol;
    }

    public void addSolution(Solution s){
        solutions.add(s);
    }

    public int getSolutionSize(){
        return solutions.size();
    }

}
