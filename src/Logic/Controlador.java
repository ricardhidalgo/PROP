package Logic;

import Logic.*;

import java.util.ArrayList;
import Persistence.ControladorDomini;

public class Controlador {

    Difficulty difficulty;
    boolean tips = false;
    int numB;
    boolean rep;
    Game game;
    User usuario;
    boolean breaker;
    AI ia = new AI_Genetic(difficulty);
    Combination correct;
    ArrayList<Play> plays;
    ControladorDomini cd;
    Play jugada = new Play();

    /* Contructora vacía */

    public Controlador () {

    }

    public boolean ExistsName(String nick) {
        return cd.TryName(nick);
    }

    public void Register (String nick, String pw) {
        cd.create(nick, pw);
    }

    public boolean CorrectPSS(String nick, String pw) {
        return cd.CorrectPW(nick, pw);
    }

    public void setUser (String nick, String pw) {
        usuario = new User(nick, pw);
    }

    public void setDiff (String diff) {
        if (diff == "easy") difficulty.setEasy(tips);
        else if (diff == "medium") difficulty.setMedium(tips);
        else if (diff == "hard") difficulty.setHard(tips);
        else if (diff == "custom") difficulty.setCustom(numB, rep, tips);
    }

    public void setnumB (int num) {
        this.numB = num;
    }

    public void setrep (boolean repeat) {
        this.rep = repeat;
    }



    /* true == CodeBreaker */
    public void setType (boolean breaking) {
        breaker = breaking;
    }

    public void setTips (boolean tip) {
        this.tips = tip;
    }

    public void setCorrect (ArrayList<Byte> solution) {
        correct = new Combination(solution);
    }

    public Combination getcorrect() {
        return correct;
    }

    public void setPlays (ArrayList<Play> play) {
        plays = play;
    }

    public void start () {
        if (breaker) game = new Game(usuario, ia, breaker, difficulty);
        else game = new Game(usuario, ia, breaker, correct, plays, difficulty);
    }

    public int getCC() {
        return jugada.getNumCorrectColors();
    }

    public int getCP() {
        return jugada.getNumCorrectPositions();
    }

    public void correctColorsPositions (Combination comb1, Combination comb2) {
        jugada.processPlay(comb1, comb2);
    }

    /* se tiene que hacer un bucle con todas las puntuaciones del mismo usuario y hacer esta funcion en
    todas, de esta forma al final unicamente quedaran las 10 mejores almacenadas.
     */

    public Combination generateCombi () {
        return ia.generateSecret();
    }

    public Combination FirstGues () {
        return ia.generateFirstCombination();
    }

    public void setNumCC(int CC) {
        jugada.modifyColor(CC);
    }

    public void setNumCP (int CP) {
        jugada.modifyPosition(CP);
    }

    public Combination GenerateGuess(Play jugada) {
        return ia.generateNextCombination(jugada);
    }

    public void insert1puntuation (Ranking ranking, String nickname, int score) {
        ranking.modifynick(nickname);
        ranking.modifyscore(score);
        ranking.InsertRanking();
    }

    public void CreateRanking (Ranking ranking, String usuario, boolean score) {
        ArrayList<String> puntuacion = cd.allscores(usuario, score);
        for (int i = 0; i < puntuacion.size(); i++) {
            insert1puntuation(ranking, usuario, Integer.parseInt(puntuacion.get(i)));
        }
    }

    public ArrayList<MyPair> seeranking (Ranking ranking) {
        return ranking.getranking();
    }

    public void guardarpuntuacion (String name, ArrayList<String> puntuacion, boolean score) {
        cd.savepuntuation(name, puntuacion, score);
    }

}
