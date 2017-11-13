package Logic;

import java.util.ArrayList;

public class FinishedGame extends Game {

    private int puntuation;

    public FinishedGame(User user, boolean isUserBreaker, Combination secretCode, ArrayList<Play> plays, Difficulty difficulty, int puntuation) {
        super(user, isUserBreaker, secretCode, plays, difficulty);
        this.puntuation = puntuation;
    }

    public int getPuntuation() {
        return puntuation;
    }

    public void setPuntuation(int puntuation) {
        this.puntuation = puntuation;
    }
}
