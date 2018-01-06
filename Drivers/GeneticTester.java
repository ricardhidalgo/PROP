import Logic.AI_Genetic;
import Logic.Combination;
import Logic.Difficulty;
import Logic.Genetic.Individual;
import Logic.Play;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author albert.ortiz
 */

public class GeneticTester {
    private Combination readCombination(int a){
        Scanner scan = new Scanner(System.in);
        ArrayList<Byte> ind = new ArrayList<Byte>();
        for(int i=0; i<a; i++) ind.add(scan.nextByte());
        Combination c = new Combination();
        c.setCombination(ind);
        return c;
    }

    private void printIndividual(Individual ind){
        for(int i=0; i<ind.numGenes(); i++) System.out.print(ind.getGen(i));
        System.out.print("\n");
    }

    public static void main(String args[]) {
        System.out.println(".............................................");
        System.out.println();
        System.out.println(".........TEST DE LA IA DE MASTERMIND.........");
        System.out.println();
        System.out.println(".............................................");
        System.out.println();
        System.out.println();
        Scanner scan = new Scanner(System.in);
        GeneticTester gt = new GeneticTester();
        while(true){
            System.out.println("Insert the secret combination (numbers 0-7): ");
            Difficulty dif = new Difficulty();
            dif.setEasy(true);
            Combination secret = gt.readCombination(dif.getNumBallsInCombination());
            AI_Genetic gb = new AI_Genetic(dif);
            Play play = new Play();
            int guessCounter = 0;
            Combination c = gb.generateFirstCombination();
            while(play.getNumCorrectPositions() != dif.getNumBallsInCombination()) {
                play.processPlay(c, secret);
                c = gb.generateNextCombination(play);
                play.processPlay(c, secret);
                System.out.println("AI GENERATED: " + c.getComb() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                guessCounter ++;
            }
            System.out.println("AI WON THE GAME IN "+guessCounter+" GUESSES!");
        }

    }
}
