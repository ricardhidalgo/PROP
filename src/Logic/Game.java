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
    private int guesses;
    private int score;

    /**
     * Realiza una jugada.
     *
     * @param comb combinación correcta.
     * @return returna una jugada.
     */
    public Play makePlay(Combination comb)/*throws ExcepcioGame*/ {
        Play np = new Play();
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            //throw new ExcepcioGame("Bad parameters");
        } else {
            np.processPlay(comb, secretCode);
            plays.add(np);
        }
        guesses++;
        score = (100000 * difficulty.getNumBallsInCombination()) / guesses;
        return np;
    }

    /**
     * Retorna el usuario que está jugando.
     *
     * @return retorna el usuario que juega.
     */
    public User getUser() {
        return user;
    }

    /**
     * Retorna la puntuacion obtenida.
     *
     * @return retorna la puntuacion de la partida.
     */
    public int getScore() {
        return score;
    }


    /**
     * Indica que rol tiene el usuario.
     *
     * @return retorna true si el usuario es CB false si es CM.
     */
    public boolean isUserBreaker() {
        return isUserBreaker;
    }

    /**
     * Retorna la combinación correcta.
     *
     * @return retorna la respuesta correcta.
     */
    public Combination getSecretCode() {
        return secretCode;
    }

    /**
     * Retorna una array con las jugadas.
     *
     * @return retorna las jugadas.
     */
    public ArrayList<Play> getPlays() {
        return plays;
    }

    public Play getLastPlay() {
        return plays.get(guesses - 1);
    }

    /**
     * Retorna la dificultad establecida.
     *
     * @return retorna el nível de dificultad.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Retorna la IA que esta jugando a la partida
     *
     * @return Referencia a la IA
     */
    public AI getAi() {
        return ai;
    }

    private AI ai;

    /**
     * Constructora vacía.
     */
    public Game() {

    }

    /**
     * Constructora con valores predefinidos. Pensada para crear una nueva partida
     *
     * @param user          usuario de la partida.
     * @param ai            IA de la partida.
     * @param isUserBreaker indica si el usuario es CB o CM.
     * @param difficulty    indica el nível de dificultad.
     */
    public Game(User user, AI ai, boolean isUserBreaker, Difficulty difficulty) {
        this.user = user;
        this.ai = ai;
        this.isUserBreaker = isUserBreaker;
        this.difficulty = difficulty;
        plays = new ArrayList<>();
        guesses = 0;
        score = 0;
    }

    /**
     * Constructora con valores predefinidos. Pensada para cargar una partida
     *
     * @param user       usuario de la partida.
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
        score = 0;
    }

    /**
     * Constructora con valores predefinidos. Pensada para cargar una partida
     *
     * @param user       usuario de la partida.
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
     *
     * @param comb Combinación correcta.
     */
    public void setSecretCode(Combination comb) /*throws ExcepcioGame*/ {
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            //throw new ExcepcioGame("Bad parameters");
        } else {
            this.secretCode = comb;
        }
    }

    /**
     * Funcion usada para generar un game a partir de unos guesses y un secretCode
     *
     * @param plays jugadas guardadas
     */
    public void initializeGame(ArrayList<Combination> plays) {
        //try {
        for (int i = 0; i < plays.size(); i++) this.makePlay(plays.get(i));
        //}
        //catch (ExcepcioGame g){
        //                                                   AQUI RICARD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //}
    }


    /**
     * Funcion usada para obtener una partida
     *
     * @return devuelve ArrayList con todos los elementos de la partida
     */
    public ArrayList<String> retrieveMatch() {
        //order: Code, Difficulty, guesses
        ArrayList<String> out = new ArrayList<>();
        out.add(secretCode.toString());
        out.add(difficulty.getNumBallsInCombination().toString());
        out.add(String.valueOf(difficulty.isCanRepeat()));
        out.add(String.valueOf(difficulty.isHasTips()));
        // for(int i=0; i<plays.size(); i++) out.add(plays.get(i).getCombination().toString());
        for (int i = 0; i < plays.size(); i++) out.add(plays.get(i).getCombination().toString());
        return out;
    }
}

/*class ExcepcioGame extends Exception{

    ExcepcioGame(String str){
        super(str);
    }
}*/
