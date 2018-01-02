package Drivers;
import Logic.Genetic.FitnessCalculus;
import Logic.Genetic.Individual;
import Logic.Genetic.Solution;

import java.util.Scanner;
/**
 * @author albert.ortiz
 */
/*
public class DriverFitnessCalculus {

    public void testGetTurn(int param){
        System.out.println("Testing Get/Set turn:");
        FitnessCalculus fc = new FitnessCalculus(0.5, 1);
        for(int i=0; i<param; i++){
            System.out.println("Turn is: " + fc.getTurn());
        }
        System.out.println("Turn should be "+param + " and it's " + fc.getTurn()+"\n");

    }

    public void testFitnessIndividual(){
        FitnessCalculus fc = new FitnessCalculus(0.5, 1);
        Scanner scan = new Scanner(System.in);
        int solutionN = scan.nextInt();
        for(int i=0; i<solutionN; i++){
            Individual ind = new Individual();
            for(int j=0; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            int a = scan.nextInt();
            int b = scan.nextInt();
            Solution sol = new Solution(a, b, ind);
            fc.addSolution(sol);
        }
        while(true) {
            System.out.println("Insert the individual you want to test. -1 To exit.");
            Individual ind = new Individual();
            byte a = scan.nextByte();
            if(a<0) break;
            else ind.setGen(0, a);
            for(int j=1; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            System.out.println("Individual is: ");
            printIndividual(ind);
            System.out.println("And it's fitness is: " + fc.fitnessIndividual(ind));
        }

    }

    /*public void testGetSolution(int solutionN){
        FitnessCalculus fc = new FitnessCalculus();
        Scanner scan = new Scanner(System.in);
        for(int i=0; i<solutionN; i++){
            Individual ind = new Individual();
            for(int j=0; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            int a = scan.nextInt();
            int b = scan.nextInt();
            Solution sol = new Solution(a, b, ind);
            fc.addSolution(sol);
        }
        boolean a = true;
        while(a) {
            System.out.println("Insert the solution index you want to see. -1 To exit.");
            int i = scan.nextInt();
            if(i>=fc.getSolutionSize()){
                System.err.println("Error: index bigger than solutions stored.");
                continue;
            }else if(i<0) break;
            System.out.println("Solution " + i + " is: ");
            printIndividual(fc.getSolution(i).getIndividual());
            System.out.println("And it's score: " + fc.getSolution(i).getBlack() + " "+ fc.getSolution(i).getWhite());
        }
    }

    private void printIndividual(Individual ind){
        for(int i=0; i<ind.numGenes(); i++) System.out.print(ind.getGen(i));
        System.out.print("\n");
    }

    public void testGetSolutionSize(int solutionN){
        FitnessCalculus fc = new FitnessCalculus(0.5, 1);
        Scanner scan = new Scanner(System.in);
        for(int i=0; i<solutionN; i++){
            Individual ind = new Individual();
            for(int j=0; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            int a = scan.nextInt();
            int b = scan.nextInt();
            Solution sol = new Solution(a, b, ind);
            fc.addSolution(sol);
        }
        System.out.println("The number of solutions stored is: "+ fc.getSolutionSize());
    }

    public void showOptions(){
        System.out.println("Select an option: \n ");
        System.out.println("1: Test GetTurn ");
        System.out.println("2: Test GetSolutionSize");
        System.out.println("3: Test GetSolution");
        System.out.println("4: Test FitnessIndividual");
        System.out.println("0: Exit ");
    }
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("FitnessCalculus driver: \n");
        boolean b = true;
        DriverFitnessCalculus DFC = new DriverFitnessCalculus();
        while(b) {
            int x = 0;
            DFC.showOptions();
            x = scan.nextInt();
            switch(x){
                case 0:
                    b = false;
                    break;
                case 1:
                    System.out.println("Usage: Insert the number of turns to test. ");
                    DFC.testGetTurn(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Usage: Insert the number of solutions to add and its number of white/black balls. The number of a solution must consist of 4 numbers from 0 to 9 separed by a space. After that, you will get the number of solutions stored.");
                    DFC.testGetSolutionSize(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Usage: Insert the number of solutions to add and its number of white/black balls. The number of a solution must consist of 4 numbers from 0 to 9 separed by a space.");
                   // DFC.testGetSolution(scan.nextInt());
                    break;
                case 4:
                    System.out.println("Usage: Checks fitness function. Insert the number of solutions to add and its number of white/black balls. The number of a solution must consist of 4 numbers from 0 to 9 separed by a space. Then insert the individuals you want to check.");
                    DFC.testFitnessIndividual();
                default: System.err.println("Wrong option code. ");
            }
            System.out.println();

        }
    }
}
*/