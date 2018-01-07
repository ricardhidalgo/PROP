package Logic;

import Presentation.Screen;
import Logic.Difficulty;

import java.awt.*;

public class Controlador {

    Difficulty difficulty;
    boolean tips = false;
    int numB;
    boolean rep;
    Game game;
    User usuario;
    boolean breaker;
    AI ia = new AI_Genetic(difficulty);



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

    public void Start () {
        if (breaker) game = new Game(usuario, ia, breaker, difficulty);
        else game = new Game(usuario, ia, breaker, comb, plays, difficulty);
    }

}
