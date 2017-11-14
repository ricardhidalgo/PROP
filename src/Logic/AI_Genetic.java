package Logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AI_Genetic extends AI {


    public Combination generateSecret(Difficulty dif){
        Random random = new Random();

        if(dif.isCanRepeat()) {
            ArrayList<Integer> comb = new ArrayList<>();
            for (int i = 0; i < dif.getNumBallsInCombination(); ++i) {
                comb.add(random.nextInt(8));
            }

        } else {

            Set<Integer> hcomb = new HashSet<>();
            while(hcomb.size() < dif.getNumBallsInCombination()) {
                hcomb.add(random.nextInt(8));
            }

        }

    }

    public Combination generateFirstCombination() {

    }

    public Combination generateNextCombination(Play result) {

    }
}
