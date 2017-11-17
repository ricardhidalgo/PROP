package Logic;

/**
 * @author ricard.hidalgo
 */

public class Difficulty {

    private int numBallsInCombination;
    private boolean canRepeat;
    private int dificultyCode;
    private boolean hasTips;

    /**
     * Constructora vacía.
     */
    public Difficulty() {
        this.dificultyCode = 0;
    }

    /**
     * Constructora con valores preestablecidos
     * @param numBalls numero de bolas
     * @param repeat si hay repetidas
     * @param code codigo de dificultad
     * @param tips si hay pistas
     */
    public Difficulty(int numBalls, boolean repeat, int code, boolean tips) {
        this.numBallsInCombination = numBalls;
        this.canRepeat = repeat;
        this.dificultyCode = code;
        this.hasTips = tips;
    }


    /**
     * Dificultad fácil.
     * @param tips si se han pedido pistas o no.
     */
    public void setEasy(boolean tips) {
        this.numBallsInCombination = 4;
        this.canRepeat = false;
        this.dificultyCode = 1;
        this.hasTips = tips;

    }

    /**
     * Dificultad media.
     * @param tips si se han pedido pistas o no.
     */
    public void setMedium(boolean tips) {
        this.numBallsInCombination = 6;
        this.canRepeat = false;
        this.dificultyCode = 2;
        this.hasTips = tips;

    }

    /**
     * Dificultad alta.
     * @param tips si se han pedido pistas o no.
     */
    public void setHard(boolean tips) {
        this.numBallsInCombination = 8;
        this.canRepeat = true;
        this.dificultyCode = 3;
        this.hasTips = tips;

    }

    /**
     * Dificultad personalizada.
     * @param numBalls número de bolas que hay en la combinación.
     * @param canRep indica si hay colores repetidos o no en la combinación.
     * @param tips si se han pedido pistas o no.
     */
    public void setCustom(int numBalls, boolean canRep, boolean tips) {
        this.numBallsInCombination = numBalls;
        this.canRepeat = canRep;
        this.dificultyCode = 4;
        this.hasTips = tips;

    }


    /**
     * Retorna el numero de bolas total de la combinación.
     * @return retorna el número total de bolas en la combinación.
     */
    public Integer getNumBallsInCombination() {
        return numBallsInCombination;
    }

    /**
     * Retorna si el color de la bola se puede.
     * @return retorna si el color se puede repetir en la combinación.
     */
    public boolean isCanRepeat() {
        return canRepeat;
    }

    /**
     * Retorna el nível de dificultad.
     * @return retorna un int con el nivel de dificultad (1..4).
     */
    public int getDificultyCode() {
        return dificultyCode;
    }

    /**
     * Retorna si se han pedido pistas o no.
     * @return retornará un boleano true si se han pedido pistas, false en caso contrario.
     */
    public boolean isHasTips() {
        return hasTips;
    }
}
