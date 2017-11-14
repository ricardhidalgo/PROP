package Logic;

import Logic.Genetic.GeneticBase;

import java.util.*;

public class AI_Genetic extends AI {
    private GeneticBase genBase;
    private Difficulty dif = new Difficulty();
    public AI_Genetic(){
        //Podem modificar els parametres del genetic en funcio de la dificultat.(Bastant recomanable per millorar eficiencia)
        genBase = new GeneticBase(100,150,0.5,0.015,0.03,0.02,60);
    }

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

            //RICARD
        return new Combination();
    }

    private void giveResult(int x, int y, Combination c){
        genBase.addSolution(x,y,c.getComb());
    }

    public Combination generateFirstCombination() {
        int i = dif.getDificultyCode();
        ArrayList<Byte> sol1 = new ArrayList<Byte>((Arrays.asList((byte)1, (byte)1, (byte)2, (byte)2)));
        ArrayList<Byte> sol2 = new ArrayList<Byte>((Arrays.asList((byte)1,(byte) 1, (byte)2,(byte) 3,(byte) 4)));
        ArrayList<Byte> sol3 = new ArrayList<Byte>((Arrays.asList((byte)1, (byte)1,(byte) 2,(byte) 2,(byte) 3,(byte) 4)));
        ArrayList<Byte> sol4 = new ArrayList<Byte>(Arrays.asList((byte)1,(byte) 1, (byte)2,(byte) 2, (byte)3,(byte) 3,(byte) 4,(byte) 5));
        Combination comb = new Combination();
        switch(i) {
            case 1: comb.setCombination(sol2);
            case 2: comb.setCombination(sol3);
            case 3: comb.setCombination(sol4);
            default: comb.setCombination(sol1);
        }
        return comb;
    }

    public Combination generateNextCombination(Play result){
        int x = result.getNumCorrectPositions();
        int y = result.getNumCorrectColors();
        giveResult(x,y,result.getCombination());
        String s =  genBase.play();
        char[]a = s.toCharArray();
        ArrayList<Byte> arrI = new ArrayList<Byte>();
        for(int i=0; i<s.length(); i++) {
            arrI.add((byte)a[i]);
        }
        return new Combination(arrI);
    }
}
