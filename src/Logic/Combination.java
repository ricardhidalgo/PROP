package Logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Estructura de datos de una combinación.
 *
 * @author ricard.hidalgo
 */

public class Combination {

    //private Byte id;
    private ArrayList<Byte> comb;

    /**
     * Constructora vacia
     */
    public Combination() {
        this.comb = new ArrayList<Byte>();
    }

    /**
     * Constructora con combinación preestablecida.
     *
     * @param comb La combinación con la que se quiere inicializar el objeto
     */
    public Combination(ArrayList<Byte> comb) {
        this.comb = comb;
    }

    /**
     * Retorna la combinación
     *
     * @return Combinación de colores en forma de ArrayList de Bytes.
     */
    public ArrayList<Byte> getComb() {
        return this.comb;
    }


    /**
     * Modifica la combinación
     *
     * @param combination Nueva combinación
     */
    public void setCombination(ArrayList<Byte> combination) {

        this.comb = combination;

    }

    /**
     * Compara la combinación própia con la combinación pasada por parámetro.
     *
     * @param combination Combinación a comparar
     * @return Un ArrayList de Bytes. Para cada posición, 0 representa que es un color incorrecto. 1 que es un color correcto, pero en una posición incorrecta. 2 que es un color correcto en una posición correcta
     */
    public ArrayList<Byte> compareCombinations(Combination combination) {

        ArrayList<Byte> tips = new ArrayList<Byte>();
        boolean correct = true;

        for (int i = 0; i < this.comb.size(); ++i) {
            if (this.comb.get(i).equals(combination.comb.get(i))) {
                tips.add((byte)2);
            } else {
                tips.add((byte)0);
                correct = false;
            }
        }

        if (correct) {
            return tips;
        } else {
            ArrayList<Byte> tips2 = new ArrayList<>(tips);
            for (int i = 0; i < tips.size(); ++i) {
                if (tips.get(i) == 0) {
                    for (int j = 0; j < tips.size(); ++j) {
                        if (this.comb.get(j).equals(combination.comb.get(i)) && tips2.get(j) == 0) {
                            tips.set(i, (byte)1);
                            tips2.set(j, (byte)1);
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
        Set<Byte> hcomb = new HashSet<Byte>(this.comb);
        return comb.size() > hcomb.size();
    }

}
