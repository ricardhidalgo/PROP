package Logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ricard.hidalgo
 */

public class Combination {

    //private Integer id;
    private ArrayList<Integer> comb;

    public Combination() {
    }

    public Combination(Combination combination) {
        this.comb = combination.comb;
    }

    public ArrayList<Integer> getComb() {
        return comb;
    }


    public void setCombination(ArrayList<Integer> combination) {

        this.comb = combination;

    }

    public ArrayList<Integer> compareCombinations(Combination combination) {

        ArrayList<Integer> tips = new ArrayList<>();
        boolean correct = true;



        for (int i = 0; i < this.comb.size(); ++i) {
            if (this.comb.equals(combination.comb.get(i))) {
                tips.add(2);
            } else {
                tips.add(0);
                correct = false;

            }

        }

        if (correct) {
            return tips;
        } else {
            return tips; //Completar

        }
    }

    private boolean hasRepeat(ArrayList<Integer> combination) {
        Set<Integer> hcomb = new HashSet<Integer>(combination);
        return combination.size() > hcomb.size();
    }
}
