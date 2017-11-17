package Logic;

import Logic.Genetic.GeneticBase;
import Logic.Genetic.Individual;

import java.util.*;

/**
 * @author ricard.hidalgo
 * @author albert.ortiz
 */


public class AI_Genetic implements AI{


    private GeneticBase genBase;
    private Difficulty dif = new Difficulty();


    public AI_Genetic(Difficulty difficulty){
        //Podem modificar els parametres del genetic en funcio de la dificultat.(Bastant recomanable per millorar eficiencia)
        genBase = new GeneticBase(100,150,0.5,0.015,0.03,0.02,60, difficulty.isCanRepeat());
        Individual.setDefaultGenNum(difficulty.getNumBallsInCombination());
        //ALBERT
        this.dif = difficulty;
    }

    public Combination generateSecret(){
        /**
         * Genera una combinacion aleatoria.
         * @param dif nivel de dificultad.
         * @return devuelve Combinacion aleatoria.
         */
        Random random = new Random();
        Combination combination = new Combination();

        if(dif.isCanRepeat()) {
            ArrayList<Byte> comb = new ArrayList<>();
            for (int i = 0; i < dif.getNumBallsInCombination(); ++i) {
                comb.add((byte)random.nextInt(8));
            }
            combination.setCombination(comb);

        } else {

            Set<Byte> hcomb = new HashSet<>();
            while(hcomb.size() < dif.getNumBallsInCombination()) {
                hcomb.add((byte)random.nextInt(8));
            }
            ArrayList<Byte> comb2 = new ArrayList<Byte>(hcomb);
            combination.setCombination(comb2);


        }
        return combination;
            //RICARD
    }

    public Combination generateFirstCombination() {
        /**
         * Genera una combinacion inicial preestablecida.
         * @return devuelve la combinacion inicial.
         */
        int i = dif.getDificultyCode();
        ArrayList<Byte> sol1 = new ArrayList<Byte>((Arrays.asList((byte)5, (byte)1, (byte)2, (byte)3)));
      //  ArrayList<Byte> sol2 = new ArrayList<Byte>((Arrays.asList((byte)1,(byte) 1, (byte)2,(byte) 3,(byte) 4)));
        ArrayList<Byte> sol2 = new ArrayList<Byte>((Arrays.asList((byte)1, (byte)1,(byte) 2,(byte) 2,(byte) 3,(byte) 4)));
        ArrayList<Byte> sol3 = new ArrayList<Byte>(Arrays.asList((byte)1,(byte) 1, (byte)2,(byte) 2, (byte)3,(byte) 3,(byte) 4,(byte) 5));
        Combination comb = new Combination();
        switch(i) {
            case 1: comb.setCombination(sol1);break;
            case 2: comb.setCombination(sol2);break;
            case 3: comb.setCombination(sol3);break;
            default: comb.setCombination(sol1);
        }
            //ALBERT
        return comb;
    }

    public Combination generateNextCombination(Play result){
        /**
         * Genera una combinacion basada en las respuestas anteriores y sus respectivos resultados.
         * @param result resultado de la respuesta anterior.
         * @return devuelve la combinacion a jugar.
         */
        int x = result.getNumCorrectPositions();
        int y = result.getNumCorrectColors();
        genBase.addSolution(x, y, result.getCombination().getComb());
        Combination c =  genBase.play();
        return c;
        //ALBERT
    }
}
