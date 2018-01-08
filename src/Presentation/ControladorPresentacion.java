package Presentation;

import Logic.Controlador;

import java.util.ArrayList;

public class ControladorPresentacion {

    Controlador cont;

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
        cont.NextGuess();
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

    public void saveScore(String name, String score, boolean punt) {

    }

    public void convertranking(String user) {
        cont.convertranking(user);
    }



}


/*
    public ArrayList<MyPair> seeranking (Ranking ranking) {
        return ranking.getranking();
    }

    public void guardarpuntuacion (String name, ArrayList<String> puntuacion, boolean score) {
        cd.savepuntuation(name, puntuacion, score);
    }*/