package Presentation;

import Logic.ControladorLogic;

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
     */
    public boolean exists(String name) {
        return cont.ExistsName(name);
    }

    /**
     * Da de alta un nuevo usuario en el registro de usuarios.
     *
     * @param nick Nombre del usuario.
     * @param pw   Contraseña de acceso del usuario.
     */
    public void registerUser(String nick, String pw) {
        cont.Register(nick, pw);
    }

    /**
     * Comprueba si el usuario y la contraseña concuerdan en el registro.
     * @param nick Nombre de usuario.
     * @param pw Contrasenya del usuario
     * @return True si concuerdan. False en caso contrario.
     */
    public boolean checkPW(String nick, String pw) {
        return cont.CorrectPSS(nick, pw);
    }

    public void setUs (String nick, String pw) {
        cont.setUser(nick, pw);
    }

    /**
     * Establece el codigo de dificultad de la partida.
     * @param diff Dificultad de la partida. Possibles entradas: "easy", "medium", "hard", "custom"
     */
    public void setDifficult (String diff) {
        cont.setDiff(diff);
    }

    public void setnumB (int num) {
        cont.setnumB(num);
    }

    public void setrepeat (boolean repeat) {
        cont.setrep(repeat);
    }

    public void setTps (boolean tips) {
        cont.setTips(tips);
    }

    public void breaker (boolean type) {
        cont.setType(type);
    }

    public void begin() {
        cont.start();
    }

    public void setAnswerCM (String answer2) {
        cont.setAnswerCM(answer2);
    }

    public String FirstGuess () {
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

    public void saveScore(String name, int score, boolean punt) {
        ArrayList<String> info = new ArrayList<String>();
        info.add(String.valueOf(score));
        cont.guardarpuntuacion(name, info, punt);
    }

    public void convertranking(String user) {
        cont.convertranking(user);
    }

    public ArrayList<String> loadMatch(String user, int index) {
        return cont.getMatch(user, index);
    }

    public void saveMatch(String username, ArrayList<String> match) {
        cont.saveMatch(username, match);
    }
}