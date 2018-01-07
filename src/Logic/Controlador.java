/*
package Logic;

import Presentation.Screen;
import Logic.Difficulty;
import Logic.Combination;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

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

    /* Contructora vacía */

    public Controlador () {

    }


/*
    public void iniciar() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Screen miVentanaPrincipal = new Screen(screenSize.width, screenSize.height); // Autoajusta la pantalla
    }
*/

    public void setUser (String nick, String pw) {
        usuario = new User(nick, pw);
    }

    public void setDiff (String diff) {
        if (diff == "easy") difficulty.setEasy(tips);
        else if (diff == "medium") difficulty.setMedium(tips);
        else if (diff == "hard") difficulty.setHard(tips);
        else if (diff == "custom") difficulty.setCustom(numB, rep, tips);
    }

    public void setnumB (int num) { this.numB = num; }

    public void setrep (boolean repeat) { this.rep = repeat; }

    public void setType (String type) {
        breaker = (type == "CodeBreaker");
    }

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

    public void insertpuntuation (Ranking ranking, String nickname, int score) {
        ranking.modifynick(nickname);
        ranking.modifyscore(score);
        ranking.InsertRanking();
    }

    public void seeranking (Ranking ranking) {

        ranking.escribirtxt();
    }

}
*/