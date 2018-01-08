package Presentation;

import Logic.*;

import java.util.ArrayList;

public class ControladorPresentacion {

    Controlador cont;
    Combination answer = new Combination();
    Combination later = new Combination();

    public ControladorPresentacion() {

    }

    public boolean exists(String name) {
        return cont.ExistsName(name);
    }

    public void registrar (String nick, String pw) {
        cont.Register(nick, pw);
    }

    public boolean checkPW(String nick, String pw) {
        return cont.CorrectPSS(nick, pw);
    }

    public void setUs (String nick, String pw) {
        cont.setUser(nick, pw);
    }

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

    public void setAnswer (String answer2) {
        byte[] valuesDefault = answer2.getBytes();
        ArrayList<Byte> sol = new ArrayList<Byte>();
        for (int i = 0; i < valuesDefault.length; i++) {
            sol.add(valuesDefault[i]);
        }
        cont.setCorrect(sol);
        answer = cont.getcorrect();
    }

    public void begin() {
        cont.start();
    }

    public String FirstGuess () {
        String FG = "";
        Combination comb = cont.FirstGues();
        ArrayList<Byte> combination = comb.getComb();
        later = comb;
        for (int i = 0; i < combination.size(); i++)
            FG += combination.get(i);
        return FG;
    }

    public void checkAnswer() {
        cont.correctColorsPositions(answer, later);
    }

    public String NextGuess() {
        Play jugada = new Play();
        jugada.modifyPosition(cont.getCC());
        jugada.modifyColor(cont.getCP());
        String NG = "";
        Combination comb = cont.GenerateGuess(jugada);
        later = comb;
        ArrayList<Byte> combination = comb.getComb();
        for (int i = 0; i < combination.size(); i++)
            NG += combination.get(i);
        return NG;
    }

    public int getCorrectColors() {
        return cont.getCC();
    }

    public int getCorrectPosition() {
        return cont.getCP();
    }

    public String RandomSolution () {
        String RS = "";
        Combination comb = cont.generateCombi();
        ArrayList<Byte> combination = comb.getComb();
        for (int i = 0; i < combination.size(); i++)
            RS += combination.get(i);
        return RS;
    }

    public void s () {}


}



/*
    public void setCorrect (ArrayList<Byte> solution) {
        correct = new Combination(solution);
    }

    public void setPlays (ArrayList<Play> play) {
        plays = play;
    }

    public void Start () {
        if (breaker) game = new Game(usuario, ia, breaker, difficulty);
        else game = new Game(usuario, ia, breaker, correct, plays, difficulty);
    }

    public boolean CorrectCombination (Combination combi) {
        return game.getSecretCode() == combi;
    }

    /* se tiene que hacer un bucle con todas las puntuaciones del mismo usuario y hacer esta funcion en
    todas, de esta forma al final unicamente quedaran las 10 mejores almacenadas.
     */
/*

    public Combination FirstGues (AI ia) {
        return ia.generateSecret();
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
    }*/