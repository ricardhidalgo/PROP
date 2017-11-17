package Drivers;

import Logic.Genetic.GeneticBase;
import Logic.Genetic.Individual;
import Logic.Genetic.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author albert.ortiz
 */

public class DriverGeneticBase {

    private Individual readIndividual(){
        Scanner scan = new Scanner(System.in);
        Individual ind = new Individual();
        for(int i=0; i<ind.numGenes(); i++) ind.setGen(i,scan.nextByte());
        return ind;
    }

    private void printIndividual(Individual ind){
        for(int i=0; i<ind.numGenes(); i++) System.out.print(ind.getGen(i));
        System.out.print("\n");
    }

    public void testConstructor(){
        Scanner scan = new Scanner(System.in);
        GeneticBase gb = new GeneticBase(scan.nextInt(), scan.nextInt(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), scan.nextInt());
        System.out.println("Genetic base generated without problems!");
    }

    public void testAddSolution(){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        ArrayList<Byte> arr = new ArrayList<Byte>();
        for(int i=0; i<4; i++) arr.add(scan.nextByte());
        GeneticBase gb = new GeneticBase(4,3,0.4,0.4,0.4,0.4,4);
        gb.addSolution(x,y,arr);
        System.out.println("Inserted successfully");
    }

    public void testPlay(){
        Scanner scan = new Scanner(System.in);
    }

    public void showOptions(){
        System.out.println("Select an option: \n ");
        System.out.println("1: Test Constructor ");
        System.out.println("2: Test AddSolution ");
        System.out.println("3: Test Play ");
        System.out.println("0: Exit ");
    }

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Individual driver: \n");
        Individual ind = new Individual();
        Solution s = new Solution(2,3, ind);
        boolean b = true;
        DriverGeneticBase DFC = new DriverGeneticBase();
        while(b) {
            int x = 0;
            DFC.showOptions();
            x = scan.nextInt();
            switch(x){
                case 0:
                    b = false;
                    break;
                case 1:
                    System.out.println("Usage: Generates the base of the AI. Insert: maxGenerations, nIndividualsPopulation, recombinationUmbral, mutationRatio, permutationRatio, inversionRatio, maxSolutions");
                    DFC.testConstructor();
                    break;
                case 2:
                    System.out.println("Usage: adds a solution in the fitness calculus attribute. Insert blacks, whites and the individual.");
                    DFC.testAddSolution();
                    break;
                case 3:
                    System.out.println("Usage: Plays a combination");
                    DFC.testPlay();
                    break;
                default: System.err.println("Wrong option code. ");
            }
            System.out.println();

        }
    }
}
