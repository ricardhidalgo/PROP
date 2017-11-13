package Logic;

import java.util.ArrayList;


/**
 * @author ricard.hidalgo
 */


public class Game {

    private User user;
    private boolean isUserBreaker;
    private Combination secretCode;
    private ArrayList<Play> plays;
    private Difficulty difficulty;

    public Game(){

    }


    public Game(User user, boolean isUserBreaker, Difficulty difficulty) {
        this.user = user;
        this.isUserBreaker = isUserBreaker;
        this.difficulty = difficulty;
        this.plays = new ArrayList<>();
    }

    public Game(User user, boolean isUserBreaker, Combination secretCode, ArrayList<Play> plays, Difficulty difficulty) {
        this.user = user;
        this.isUserBreaker = isUserBreaker;
        this.secretCode = secretCode;
        this.plays = plays;
        this.difficulty = difficulty;
    }

    public void setSecretCode(Combination comb) {
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || comb.hasRepeat() != difficulty.isCanRepeat()) {
            System.out.printf("Wrong parameters");
        } else {
            this.secretCode = comb;
        }
    }

    public Play makePlay(Combination comb) {
        Play np = new Play();
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || comb.hasRepeat() != difficulty.isCanRepeat()) {
            System.out.printf("Wrong parameters");
        } else {
            np.processPlay(comb, secretCode);
            plays.add(np);
        }
        return np;
    }

    public User getUser() {
        return user;
    }

    public boolean isUserBreaker() {
        return isUserBreaker;
    }

    public Combination getSecretCode() {
        return secretCode;
    }

    public ArrayList<Play> getPlays() {
        return plays;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
