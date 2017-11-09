package Logic;

/**
 * @author ricard.hidalgo
 */

public class Difficulty {

    private Integer numBallsInCombination;
    private boolean canRepeat;
    private Integer dificultyCode;
    private boolean hasTips;


    public Difficulty() {
        this.dificultyCode = 0;
    }

    public void setEasy(boolean tips) {
        this.numBallsInCombination = 4;
        this.canRepeat = false;
        this.dificultyCode = 1;
        this.hasTips = tips;

    }


    public void setMedium(boolean tips) {
        this.numBallsInCombination = 6;
        this.canRepeat = false;
        this.dificultyCode = 2;
        this.hasTips = tips;

    }


    public void setHard(boolean tips) {
        this.numBallsInCombination = 8;
        this.canRepeat = true;
        this.dificultyCode = 3;
        this.hasTips = tips;

    }

    public void setCustom(Integer numBalls, boolean canRep, boolean tips) {
        this.numBallsInCombination = numBalls;
        this.canRepeat = canRep;
        this.dificultyCode = 4;
        this.hasTips = tips;

    }


    public Integer getNumBallsInCombination() {
        return numBallsInCombination;
    }

    public void ModifyNumBallsInCombination(int n) { //@ author: pol.gil
        this.numBallsInCombination = n;
    }

    public boolean isCanRepeat() {
        return canRepeat;
    }

    public Integer getDificultyCode() {
        return dificultyCode;
    }

    public boolean isHasTips() {
        return hasTips;
    }
}
