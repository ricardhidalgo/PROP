package Logic;

import java.util.ArrayList;


/**
 * Estructura de datos de una jugada.
 *
 * @author ricard.hidalgo
 */

public class Play {

    private ArrayList<Byte> correctColors;
    private Combination combination;
    private int numCorrectColors;
    private int numCorrectPositions;

    /**
     * Constructora vacia
     */
    public Play() {
        correctColors = new ArrayList<Byte>();
    }

    /**
     * Retorna el análisis de la combinación de la jugada al compararla con la combinación secreta de la partida.
     * @return Retorna, para cada posición de la combinación, 2 si ésta es igual que la combinación secreta, 1 si és un color de la combinación secreta pero en una posición incorrecta, o 0 ningun de las anteriores.
     */
    public ArrayList<Byte> getCorrectColors() {
        return correctColors;
    }

    /**
     * modifica el atributo combination por el nuevo comb
     * @param comb nueva combinación
     */
    public void modifyComb(Combination comb) { this.combination = comb; }

    /**
     * Retorna la combinación de la jugada
     * @return Combinación de la jugada
     */
    public Combination getCombination() {
        return combination;
    }

    /**
     * modifica el atributo numCorrectPositions por el nuevo position.
     * @param position numero de posiciones correctas.
     */
    public void modifyPosition(int position) { this.numCorrectPositions = position; }

    /**
     * Retorna el número de colores en posiciones correctas
     * @return Número de posiciones correctas
     */
    public int getNumCorrectPositions() {
        return numCorrectPositions;
    }

    /**
     * modifica el número de colores corectos.
     * @param color numero de colores correctos.
     */
    public void modifyColor(int color) { this.numCorrectColors = color; }

    /**
     * Retorna el número de colores correctos pero en posiciones incorrectas
     * @return Número de colores correctos
     */
    public int getNumCorrectColors() {
        return numCorrectColors;
    }



    /**
     * Comb pasa a ser la combinación de la jugada. Se compara comb con secret y se modifican los parámetros correctColors,
     * numCorrectPositions y numCorrectColors con los resultados de esa comparación.
     * @param comb Combinación de la jugada.
     * @param secret Combinación secreta con la que se compara la combinación de la jugada.
     */
    public void processPlay(Combination comb, Combination secret) {
        this.combination = comb;/*
        correctColors = secret.compareCombinations(combination);*/

        numCorrectColors = 0;
        numCorrectPositions = 0;
        for (int i = 0; i < correctColors.size(); ++i) {
            if (correctColors.get(i) == 1) ++numCorrectColors;
            else if (correctColors.get(i) == 2) ++numCorrectPositions;
        }

    }

}
