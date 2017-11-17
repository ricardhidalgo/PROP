package Logic;

import java.util.ArrayList;

/**
 * Estructura de datos de una partida acabada. Subclase de Game.
 *
 * @author ricard.hidalgo
 */

public class FinishedGame extends Game {

    private int puntuation;

    /**
     * Constructora con todos los datos finales de una partida.
     * @param user nick del usuario que ha hecho la partida.
     * @param isUserBreaker indica si el usuario ha sido CB o CM.
     * @param secretCode combinación correcta.
     * @param plays número total de rondas.
     * @param difficulty nível de dificultad.
     * @param puntuation puntuación final.
     */
    public FinishedGame(User user, AI ai, boolean isUserBreaker, Combination secretCode, ArrayList<Play> plays, Difficulty difficulty, int puntuation) {
        super(user, ai, isUserBreaker, secretCode, plays, difficulty);
        this.puntuation = puntuation;
    }

    /**
     * Retorna la puntuación final.
     * @return retorna un integer con la puntuación final.
     */
    public int getPuntuation() {
        return puntuation;
    }

    /**
     * Modifica la puntuación de una partida.
     * @param puntuation puntuación de la partida.
     */
    public void setPuntuation(int puntuation) {
        this.puntuation = puntuation;
    }
}
