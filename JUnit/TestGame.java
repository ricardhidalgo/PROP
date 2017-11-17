package JUnit;

import Logic.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
        ArrayList<Byte> combi = new ArrayList<Byte>();
        Combination comb = new Combination(combi);
        ArrayList<Play> plays = new ArrayList<Play>();
        Difficulty difficulty = new Difficulty();
        AI_Genetic ia = new AI_Genetic(difficulty);
        ArrayList<Byte> combi2 = new ArrayList<Byte>();
        Combination comb2 = new Combination(combi2);
        Game play = new Game(usuario, ia, true, comb, plays, difficulty);
        User rta = play.getUser();
        assertEquals(usuario, rta);
    }

    @Test
    public void isUserBreaker() {
        User usuario = new User();
        ArrayList<Byte> combi = new ArrayList<Byte>();
        Combination comb = new Combination(combi);
        ArrayList<Play> plays = new ArrayList<Play>();
        Difficulty difficulty = new Difficulty();
        AI_Genetic ia = new AI_Genetic(difficulty);
        ArrayList<Byte> combi2 = new ArrayList<Byte>();
        Combination comb2 = new Combination(combi2);
        Game play = new Game(usuario, ia, true, comb, plays, difficulty);
        boolean rta = play.isUserBreaker();
        assertTrue(rta);
    }

    @Test
    public void getSecretCode() {
        User aux = new User();
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb = new Combination(combi);
        ArrayList<Play> plays = new ArrayList<Play>();
        Difficulty difficulty = new Difficulty();
        AI_Genetic ia = new AI_Genetic(difficulty);
        Game play = new Game(aux, ia, true, comb, plays, difficulty);
        Combination auxi = play.getSecretCode();
        assertEquals(comb, auxi);
    }

    @Test
    public void getPlays() {
        User aux = new User();
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb = new Combination(combi);
        ArrayList<Play> plays = new ArrayList<Play>();
        Play jugada = new Play();
        plays.add(jugada);
        Difficulty difficulty = new Difficulty();
        AI_Genetic ia = new AI_Genetic(difficulty);
        Game play = new Game(aux, ia, true, comb, plays, difficulty);
        ArrayList<Play> rta = play.getPlays();
        assertEquals(plays, rta);
    }

    @Test
    public void getDifficulty() {
        User aux = new User();
        ArrayList<Byte> combi = new ArrayList<Byte>();
        combi.add((byte)2);
        Combination comb = new Combination(combi);
        ArrayList<Play> plays = new ArrayList<Play>();
        Difficulty difficulty = new Difficulty(4, true, 1, true);
        AI_Genetic ia = new AI_Genetic(difficulty);
        Game play = new Game(aux, ia, true, comb, plays, difficulty);
        Difficulty rta = play.getDifficulty();
        assertEquals(difficulty, rta);
    }

}
