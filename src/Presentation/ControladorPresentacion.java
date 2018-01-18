package Presentation;

import Logic.ControladorLogic;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author ricard.hidalgo
 */

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

    /**
     * Inicializa la IA con los parámetros de dificultad establecidos e inicializa la partida con la constructora para partidas nuevas.
     */
    public void startNewGame() {
        contLogic.startNewGame();
    }

    /**
     * Recoge y almacena el codigo secreto establecido por el user.
     *
     * @param answer2 Codigo secreto del user.
     */
    public void setAnswerCM(String answer2) {
        contLogic.setAnswerCM(answer2);
    }

    /**
     * Provoca que la IA genere una combinación secreta que siga los parametros de dificultad establecidos.
     */
    public void setAnswerCB() {
        contLogic.setAnswerCB();
    }

    /**
     * Genera la primera combinación de la IA.
     *
     * @return La combinación generada.
     */
    public String firstGuess() {
        return contLogic.firstGuess();
    }

    /**
     * Genera la siguiente combinación de la IA
     *
     * @return La combinación generada.
     */
    public String nextGuess() {
        return contLogic.nextGuess();
    }

    /**
     * Retorna el número de colores correctos en posicion incorrecta de la última jugada.
     *
     * @return Número de colores correctos en posicion incorrecta de la última jugada.
     */
    public int getCorrectColors() {
        return contLogic.getCC();
    }

    /**
     * Retorna el número de colores correctos en posicion correcta de la última jugada.
     *
     * @return Número de colores correctos en posicion correcta de la última jugada.
     */
    public int getCorrectPosition() {
        return contLogic.getCP();
    }

    /**
     * Genera una solucion aleatoria.
     *
     * @return la combinacion solucion
     * @deprecated No se usa.
     */
    @Deprecated
    public String RandomSolution() {
        return contLogic.RandomSolution();
    }


    /**
     * Genera la siguiente jugada con la combinación dada.
     *
     * @param guess Combinación de la jugada.
     */
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

    public int getGameScore() {
        return contLogic.getGameScore();
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
     * Comprueba si la partida existe en el sistema.
     *
     * @param user El usuario sobre el que queremos consultar la partida.
     * @param index El índice del espacio de guardado que deseamos consultar.
     */
    public boolean existsMatch(String user, int index){
        return contLogic.existsMatch(user, index);
    }
}