package Presentation;

import Logic.ControladorLogic;

import java.awt.*;
import java.util.ArrayList;

public class ControladorPresentacion {

    public static final char[] PINCOLORLETTERS = new char[]{'R', 'G', 'B', 'O', 'Y', 'P'};
    public static final Color[] PINCOLORS = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.PINK, new Color(150, 0, 255)};

    private ControladorLogic contLogic;

    /**
     * Constructora por defecto.
     */
    public ControladorPresentacion() {
        contLogic = new ControladorLogic();
    }

    /**
     * Comprueba si el nombre dado existe en el registro de usuarios.
     *
     * @param name Nombre que debe comprobarse.
     * @return True si el nombre se encuentra entre el registro de usuarios. False en caso contrario.
     * @deprecated Ya incluida
     */
    @Deprecated
    public boolean exists(String name) {
        return contLogic.existsName(name);
    }

    /**
     * Da de alta un nuevo usuario en el registro de usuarios.
     *
     * @param nick Nombre del usuario.
     * @param pw   Contraseña de acceso del usuario.
     * @return True si se ha podido realizar el registro. False en caso contrario (Usuario ya existe).
     */
    public boolean registerUser(String nick, String pw) {
        return contLogic.register(nick, pw);
    }

    /**
     * Comprueba si el usuario y la contraseña concuerdan en el registro de usuario.
     * @param nick Nombre de usuario.
     * @param pw Contraseña del usuario.
     * @return True si concuerdan. False en caso contrario.
     * @deprecated
     */
    @Deprecated
    public boolean checkPW(String nick, String pw) {
        return contLogic.checkPassword(nick, pw);
    }

    /**
     * Intenta iniciar sesión con el usuario y la contraseña dadas.
     *
     * @param nick Nombre de usuario
     * @param pw   Contraseña
     * @return True si la operación se ha realizado exitosamente. False en caso contrario (Usuario o contraseña incorrecto).
     */
    public boolean loginUser(String nick, String pw) {

        return contLogic.loginUser(nick, pw);
    }

    /**
     * Establece el codigo de dificultad de la partida.
     *
     * @param diff Dificultad de la partida. Possibles entradas: "easy", "medium", "hard", "custom"
     */
    public void setDifficult(String diff, boolean tips) {
        contLogic.setDiff(diff, tips);
    }

    /**
     * Configura la dificultad custom con los parámetros restantes.
     *
     * @param numB Número de bolas en una combinación.
     * @param rep  Especifica si se permiten repetidos.
     */
    public void configureCustom(int numB, boolean rep) {
        contLogic.configureCustom(numB, rep);
    }

    /**
     * Getter del tamaño de las combinaciones.
     *
     * @return Tamaño de las combinaciones de la dificultad establecida.
     */
    public int getCombinationSize() {
        return contLogic.getCombinationSize();
    }

    /**
     * Getter de si se permiten repeticiones en las combinaciones.
     *
     * @return True si se permiten repeticiones. False en caso contrario.
     */
    public boolean isCanRepeat() {
        return contLogic.isCanRepeat();
    }

    /**
     * Comprueba el estado de la partida, si es finalizado.
     *
     * @param pos       numero de posiciones correctas.
     * @return pos == numBolasCombinacion
     */
    public boolean isEnd(int pos) {
        return pos == contLogic.getCombinationSize();
    }

    /**
     * Especifica el rol del jugador en la partida.
     *
     * @param breaking True si el jugador es CodeBreaker. False si es CodeMaster.
     */
    public void breaker(boolean breaking) {
        contLogic.setType(breaking);
    }

    public void startNewGame() {
        contLogic.startNewGame();
    }

    public void setAnswerCM(String answer2) {
        contLogic.setAnswerCM(answer2);
    }

    public String firstGuess() {
        return contLogic.firstGuess();
    }

    /*public void checkAnswer() {
        contLogic.checkAnswer();
    }*/

    public String nextGuess() {
        return contLogic.nextGuess();
    }

    public int getCorrectColors() {
        return contLogic.getCC();
    }

    public int getCorrectPosition() {
        return contLogic.getCP();
    }

    public String RandomSolution() {
        return contLogic.RandomSolution();
    }

    public void setAnswerCB() {
        contLogic.setAnswerCB();
    }

    public void setGuess(String guess) {
        contLogic.setGuess(guess);
    }

    /**
     * Guarda una nueva puntuacion para el usuario usr.
     *
     * @param usr   usuario de la partida..
     */
    public void saveScore(String usr) {
        int a = contLogic.getGameScore();
        ArrayList<String> info = new ArrayList<String>();
        info.add(String.valueOf(a));
        contLogic.saveScore(usr, info);
    }

    /**
     * Genera y obtiene el ranking general del sistema con las 10 mejores puntuaciones.
     *
     *@return ArrayList de tamano maximo 10 con las mejores puntuaciones y sus usuarios
     */

    public ArrayList<String> getRanking() {
        contLogic.generateRanking();
        return contLogic.getRanking();
    }

    /*public void convertranking(String user) {
        contLogic.convertranking(user);
    }*/

    /**
     * Carga la partida index del usuario user
     *
     * @param user usuario conectado
     * @param index indice de la partida a buscar.
     * @return True si encontrada, False si no
     */

    public void loadMatch(String user, int index) {
        contLogic.loadMatch(contLogic.getMatch(user, index));
    }

    /**
     * Guarda una nueva partida en el sistema
     *
     */

    public void saveMatch() {
        contLogic.saveMatch();
    }

    /**
     * Checks if the match exists in the system.
     *
     * @param user The user we want to look.
     * @param index The index of the match we want to check

     */

    public boolean existsMatch(String user, int index){
        return contLogic.existsMatch(user, index);
    }
}