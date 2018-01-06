package Logic.Genetic;

import java.util.HashSet;

/**
 * @author albert.ortiz
 */

public class FitnessCalculus {
    private HashSet<Solution> solutions = new HashSet<>();
    private int lastIndex = 0;
    private int turn = 0;

  public void incrementTurn(){ this.turn++; }

    public int getTurn(){ return turn; }

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
/*
    public Solution getSolution(int index){
        return solutions.get(index);
    }*/

    public void addSolution(Solution s){
        solutions.add(s);
    }

    public int getSolutionSize(){
        return solutions.size();
    }

}
