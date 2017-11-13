package Logic;

import java.util.ArrayList;


/**
 * @author ricard.hidalgo
 */

public class Play {

    private ArrayList<Integer> correctColors;
    private Combination combination;
    private int numCorrectColors;
    private int numCorrectPositions;

    public Play() {
        correctColors = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getCorrectColors() {
        return correctColors;
    }

    public Combination getCombination() {
        return combination;
    }

    public int getNumCorrectPositions() {
        return numCorrectPositions;
    }

    public int getNumCorrectColors() {
        return numCorrectColors;
    }

    public void setNumCorrectPositions(int numCorrectPositions) {
        this.numCorrectPositions = numCorrectPositions;
    }

    public void processPlay(Combination comb, Combination secret) {
        this.combination = comb;
        correctColors = secret.compareCombinations(combination);

        numCorrectColors = 0;
        numCorrectPositions = 0;
        for (int i = 0; i < correctColors.size(); ++i) {
            if (correctColors.get(i) == 1) ++numCorrectColors;
            else if (correctColors.get(i) == 2) ++numCorrectPositions;
        }

    }

}
