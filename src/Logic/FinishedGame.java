package Logic;

import java.util.ArrayList;

/**
 * Estructura de datos de una partida acabada. Subclase de Game.
 *
 * @author ricard.hidalgo
 */

public class FinishedGame extends Game {

    private int puntuation;

    public FinishedGame(User user, boolean isUserBreaker, Combination secretCode, ArrayList<Play> plays, Difficulty difficulty, int puntuation) {
        super(user, isUserBreaker, secretCode, plays, difficulty);
        this.puntuation = puntuation;
    }

    public FinishedGame(int puntuation) {
        this.puntuation = puntuation;
    }

    public int getPuntuation() {
        return puntuation;
    }

    public void setPuntuation(int puntuation) {
        this.puntuation = puntuation;
    }
}
