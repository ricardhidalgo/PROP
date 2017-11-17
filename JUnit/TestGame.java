package JUnit;

import Logic.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestGame {

    @Test
    public void setSecretCode() {
        User aux = new User();
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb = new Combination(combi);
        ArrayList<Play> plays = new ArrayList<Play>();
        Difficulty difficulty = new Difficulty();
        AI_Genetic ia = new AI_Genetic(difficulty);
        ArrayList<Byte> combi2 = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb2 = new Combination(combi2);
        Game play = new Game(aux, ia, true, comb, plays, difficulty);
        play.setSecretCode(comb2);
        assertEquals(comb2, play.getSecretCode());
    }

    @Test
    public void getUser() {
        User usuario = new User("Pol","45");
        Game play = new Game();
        User rta = new User();
        rta = play.getUser();
        assertEquals(usuario, rta);
    }




}
