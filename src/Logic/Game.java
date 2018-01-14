package Logic;

import java.util.ArrayList;


/**
 * @author ricard.hidalgo
 * @author albert.ortiz
 */


public class Game {

    private User user;
    private boolean isUserBreaker;
    private Combination secretCode;
    private ArrayList<Play> plays;
    private Difficulty difficulty;
    private int guesses = 0;
    private int score = 0;
    /**
     * Realiza una jugada.
     * @param comb combinación correcta.
     * @return returna una jugada.
     */
    public Play makePlay(Combination comb) {
        Play np = new Play();
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            System.err.println("Wrong parameters 2");
            System.err.println(comb.getComb().size());
            System.err.println(difficulty.getNumBallsInCombination());
            System.err.println(comb.hasRepeat());
            System.err.println(difficulty.isCanRepeat());
            System.err.println(comb.toString());
        } else {
            np.processPlay(comb, secretCode);
            plays.add(np);
        }
        guesses++;
        score = (100000*difficulty.getNumBallsInCombination())/guesses;
        System.out.println(score);
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
     * Retorna la puntuacion obtenida.
     * @return retorna la puntuacion de la partida.
     */
    public int getScore() {
        return score;
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

    /**
     * Retorna la IA que esta jugando a la partida
     * @return Referencia a la IA
     */
    public AI getAi() {
        return ai;
    }

    private AI ai;

    /**
     * Constructora vacía.
     */
    public Game(){


    }

    /**
     * Constructora con valores predefinidos. Pensada para crear una nueva partida
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
        plays = new ArrayList<>();
    }

    /**
     * Constructora con valores predefinidos. Pensada para cargar una partida
     * @param user usuario de la partida.
     * @param secretCode combinación correcta (respuesta).
     * @param difficulty nível de dificultad.
     */
    public Game(User user, Combination secretCode, Difficulty difficulty, ArrayList<Combination> guesses) {
        plays = new ArrayList<>();
        this.user = user;
        this.isUserBreaker = true;
        this.secretCode = secretCode;
        this.difficulty = difficulty;
        this.initializeGame(guesses);
    }

    /**
     * Constructora con valores predefinidos. Pensada para cargar una partida
     * @param user usuario de la partida.
     * @param secretCode combinación correcta (respuesta).
     * @param difficulty nível de dificultad.
     */
    public Game(User user, AI ia, boolean breaker, Combination secretCode, ArrayList<Play> p, Difficulty difficulty) {
        this.user = user;
        this.ai = ia;
        this.isUserBreaker = true;
        this.secretCode = secretCode;
        this.difficulty = difficulty;
        this.plays = p;
    }

    /**
     * Indica cual es la combinación correcta o respuesta
     * @param comb Combinación correcta.
     */
    public void setSecretCode(Combination comb) {
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            System.err.println("Wrong parameters 1");
        } else {
            this.secretCode = comb;
        }
    }

    /**
     * Funcion usada para generar un game a partir de unos guesses y un secretCode
     * @param plays jugadas guardadas
     */
    public void initializeGame(ArrayList<Combination> plays){ for(int i=0; i<plays.size(); i++) this.makePlay(plays.get(i)); }


    /**
     * Funcion usada para obtener una partida
     * @return devuelve ArrayList con todos los elementos de la partida
     */
    public ArrayList<String> retrieveMatch(){
        //order: Code, Difficulty, guesses
        ArrayList<String> out = new ArrayList<>();
        out.add(secretCode.toString());
        out.add(difficulty.getNumBallsInCombination().toString());
        out.add(String.valueOf(difficulty.isCanRepeat()));
        out.add(String.valueOf(difficulty.isHasTips()));
        // for(int i=0; i<plays.size(); i++) out.add(plays.get(i).getCombination().toString());
        for(int i=0; i<plays.size(); i++) out.add(plays.get(i).getCombination().toString());
        return out;
    }
}
