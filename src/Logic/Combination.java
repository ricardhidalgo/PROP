package Logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Estructura de datos de una combinación.
 *
 * @author ricard.hidalgo
 */

public class Combination {

    //private Integer id;
    private ArrayList<Integer> comb;

    /**
     * Constructora vacia
     */
    public Combination() {
        this.comb = new ArrayList<>();
    }

    /**
     * Constructora con combinación preestablecida.
     *
     * @param comb La combinación con la que se quiere inicializar el objeto
     */
    public Combination(ArrayList<Integer> comb) {
        this.comb = comb;
    }

    /**
     * Retorna la combinación
     *
     * @return Combinación de colores en forma de ArrayList de Integers.
     */
    public ArrayList<Integer> getComb() {
        return this.comb;
    }


    /**
     * Modifica la combinación
     *
     * @param combination Nueva combinación
     */
    public void setCombination(ArrayList<Integer> combination) {

        this.comb = combination;

    }

    /**
     * Compara la combinación própia con la combinación pasada por parámetro.
     *
     * @param combination Combinación a comparar
     * @return Un ArrayList de Integers. Para cada posición, 0 representa que es un color incorrecto. 1 que es un color correcto, pero en una posición incorrecta. 2 que es un color correcto en una posición correcta
     */
    public ArrayList<Integer> compareCombinations(Combination combination) {

        ArrayList<Integer> tips = new ArrayList<>();
        boolean correct = true;

        for (int i = 0; i < this.comb.size(); ++i) {
            if (this.comb.get(i).equals(combination.comb.get(i))) {
                tips.add(2);
            } else {
                tips.add(0);
                correct = false;
            }
        }

        if (correct) {
            return tips;
        } else {
            for (int i = 0; i < tips.size(); ++i) {
                if (tips.get(i) == 0) {
                    for (int j = i + 1; j < tips.size(); ++j) {
                        if (this.comb.get(i).equals(combination.comb.get(j)) && tips.get(j) != 2) {
                            tips.set(i, 1);
                            j = tips.size();
                        }
                    }
                }
            }
            return tips;

        }
    }

    /**
     * Comprueba si la combinación tiene repeticiones
     * @return True si tiene dos valores repetidos en la combinación. False en caso contrario.
     */
    public boolean hasRepeat() {
        Set<Integer> hcomb = new HashSet<Integer>(this.comb);
        return comb.size() > hcomb.size();
    }

    //private String combinationToString(){}

}
