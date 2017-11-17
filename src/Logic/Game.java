package Logic;

import java.util.ArrayList;


/**
 * @author ricard.hidalgo
 */


public class Game {

    private User user;
    private boolean isUserBreaker;
    private Combination secretCode;
    private ArrayList<Play> plays;
    private Difficulty difficulty;
    private AI ai;

    /**
     * Constructora vacía.
     */
    public Game(){


    }

    /**
     * Constructora con valores predefinidos.
     * @param user usuario de la partida.
     * @param ai IA de la partida.
     * @param isUserBreaker indica si el usuario es CB o CM.
     * @param difficulty indica el nível de dificultad.
     */
    public Game(User user, AI ai, boolean isUserBreaker, Difficulty difficulty) {
        this.user = user;
        this.ai = ai;
        this.isUserBreaker = isUserBreaker;
        this.difficulty = difficulty;
        this.plays = new ArrayList<>();
    }

    /**
     * Constructora con valores predefinidos.
     * @param user usuario de la partida.
     * @param ai IA de la partida.
     * @param isUserBreaker indica si el usuario es CB o CM.
     * @param secretCode combinación correcta (respuesta).
     * @param plays cantidad de rondas jugadas.
     * @param difficulty nível de dificultad.
     */
    public Game(User user, AI ai, boolean isUserBreaker, Combination secretCode, ArrayList<Play> plays, Difficulty difficulty) {
        this.user = user;
        this.isUserBreaker = isUserBreaker;
        this.secretCode = secretCode;
        this.plays = plays;
        this.difficulty = difficulty;
    }

    /**
     * Indica cual es la combinación correcta o respuesta
     * @param comb Combinación correcta.
     */
    public void setSecretCode(Combination comb) {
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            System.out.printf("Wrong parameters");
        } else {
            this.secretCode = comb;
        }
    }

    /**
     * Realiza una jugada.
     * @param comb combinación correcta.
     * @return returna una jugada.
     */
    public Play makePlay(Combination comb) {
        Play np = new Play();
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            System.out.printf("Wrong parameters");
        } else {
            np.processPlay(comb, secretCode);
            plays.add(np);
        }
        return np;
    }

    /**
     * Retorna el usuario que está jugando.
     * @return retorna el usuario que juega.
     */
    public User getUser() {
        return user;
    }

    /**
     * Indica que rol tiene el usuario.
     * @return retorna true si el usuario es CB false si es CM.
     */
    public boolean isUserBreaker() {
        return isUserBreaker;
    }

    /**
     * Retorna la combinación correcta.
     * @return retorna la respuesta correcta.
     */
    public Combination getSecretCode() {
        return secretCode;
    }

    /**
     * Retorna una array con las jugadas.
     * @return retorna las jugadas.
     */
    public ArrayList<Play> getPlays() {
        return plays;
    }

    /**
     * Retorna la dificultad establecida.
     * @return retorna el nível de dificultad.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }
}
