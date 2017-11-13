package Logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ricard.hidalgo
 */

public class Combination {

    //private Integer id;
    private ArrayList<Integer> comb;

    /**
     * Constructora vacia
     *
     */
    public Combination() {
    }

    /**
     * Constructora con combinación preestablecida
     * @param combination La combinación con la que se quiere inicializar el objeto
     */
    public Combination(Combination combination) {
        this.comb = combination.comb;
    }

    /**
     * Retorna la combinación
     * @return Combinación
     */
    public ArrayList<Integer> getComb() {
        return this.comb;
    }


    /**
     * Modifica la combinacion
     * @param combination
     */
    public void setCombination(ArrayList<Integer> combination) {

        this.comb = combination;

    }

    /**
     * Compara la combinación de la clase con la combinación pasada por parámetro
     * @param combination
     * @return
     */
    public ArrayList<Integer> compareCombinations(Combination combination) {

        ArrayList<Integer> tips = new ArrayList<>();
        boolean correct = true;


        for (int i = 0; i < this.comb.size(); ++i) {
            if (this.comb.equals(combination.comb.get(i))) {
                tips.add(2);
            } else {
                tips.add(0);
                correct = false;

            }

        }

        if (correct) {
            return tips;
        } else {
            return tips; //Completar

        }
    }

    public boolean hasRepeat() {
        Set<Integer> hcomb = new HashSet<Integer>(this.comb);
        return comb.size() > hcomb.size();
    }

    //private String combinationToString(){}

}
