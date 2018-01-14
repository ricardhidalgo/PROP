package Presentation;

import Logic.ControladorLogic;
import Logic.MyPair;

import java.util.ArrayList;

public class ControladorPresentacion {

    ControladorLogic cont;

    /**
     * Constructora por defecto.
     */
    public ControladorPresentacion() {
        cont = new ControladorLogic();
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
        return cont.existsName(name);
    }

    /**
     * Da de alta un nuevo usuario en el registro de usuarios.
     *
     * @param nick Nombre del usuario.
     * @param pw   Contraseña de acceso del usuario.
     * @return True si se ha podido realizar el registro. False en caso contrario (Usuario ya existe).
     */
    public boolean registerUser(String nick, String pw) {
        return cont.register(nick, pw);
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
        return cont.checkPassword(nick, pw);
    }

    /**
     * Intenta iniciar sesión con el usuario y la contraseña dadas.
     *
     * @param nick Nombre de usuario
     * @param pw   Contraseña
     * @return True si la operación se ha realizado exitosamente. False en caso contrario (Usuario o contraseña incorrecto).
     */
    public boolean loginUser(String nick, String pw) {

        return cont.loginUser(nick, pw);
    }

    /**
     * Establece el codigo de dificultad de la partida.
     *
     * @param diff Dificultad de la partida. Possibles entradas: "easy", "medium", "hard", "custom"
     */
    public void setDifficult(String diff, boolean tips) {
        cont.setDiff(diff, tips);
    }

    public boolean isEnd(int pos) {
        return pos == cont.getNumB();
    }

    public void setnumB(int num) {
        cont.setnumB(num);
    }

    public void setrepeat(boolean repeat) {
        cont.setrep(repeat);
    }

    public void breaker(boolean type) {
        cont.setType(type);
    }

    public void begin() {
        cont.start();
    }

    public void setAnswerCM(String answer2) {
        cont.setAnswerCM(answer2);
    }

    public String FirstGuess() {
        return cont.FirstGuess();
    }

    public void checkAnswer() {
        cont.checkAnswer();
    }

    public String NextGuess() {
        return cont.NextGuess();
    }

    public int getCorrectColors() {
        return cont.getCC();
    }

    public int getCorrectPosition() {
        return cont.getCP();
    }

    public String RandomSolution() {
        return cont.RandomSolution();
    }

    public void setAnswerCB() {
        cont.setAnswerCB();
    }

    public void setGuess(String guess) {
        cont.setGuess(guess);
    }

    public void saveScore(String usr) {
        int a = cont.getScore();
        ArrayList<String> info = new ArrayList<String>();
        info.add(String.valueOf(a));
        cont.guardarpuntuacion(usr, info, true);
    }

    public void generateRanking() {
        cont.generateRanking();
    }

    public ArrayList<String> getRanking(){
        return cont.getRanking();
    }

    /*public void convertranking(String user) {
        cont.convertranking(user);
    }*/

    public ArrayList<String> loadMatch(String user, int index) {
        return cont.getMatch(user, index);
    }

    public void saveMatch() {
        cont.saveMatch();
    }
}