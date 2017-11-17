package Drivers;

import Logic.Genetic.FitnessCalculus;
import Logic.Genetic.Individual;
import Logic.Genetic.Population;
import Logic.Genetic.Solution;

import java.util.Scanner;

/**
 * @author albert.ortiz
 */


public class DriverPopulation {

    private FitnessCalculus fc = new FitnessCalculus();


    public void setSolution(Solution s){
        fc.addSolution(s);
    }

    private void printIndividual(Individual ind){
        for(int i=0; i<ind.numGenes(); i++) System.out.print(ind.getGen(i));
        System.out.print("  Fitness: "+ fc.fitnessIndividual(ind));
        System.out.print("\n");
    }

    private void printPopulation(Population p){
        System.out.println("The content of the population is:");
        for(int i=0; i<p.numIndividuals(); i++) printIndividual(p.getIndividual(i));

    }

    private Individual readIndividual(){
        Scanner scan = new Scanner(System.in);
        Individual ind = new Individual();
        for(int i=0; i<ind.numGenes(); i++) ind.setGen(i,scan.nextByte());
        return ind;
    }

    public void testConstructor(){
        Scanner scan = new Scanner(System.in);
        Population pop = new Population(scan.nextInt(), true);
        printPopulation(pop);

    }

    public void testCopy(){
        Scanner scan = new Scanner(System.in);
        Population pop = new Population(scan.nextInt(), true);
        printPopulation(pop);
        Population pop2 = new Population(pop.numIndividuals(), true);
        pop2.copy(pop);
        System.out.println("The following population must be a copy of the one you have introduced:");
        printPopulation(pop2);
    }

    public void testNumIndividuals(){
        Scanner scan = new Scanner(System.in);
        Population pop = new Population(scan.nextInt(),true);
        printPopulation(pop);
        System.out.println("The following number must correspond with the number of individuals: " + pop.numIndividuals());
    }

    public void testGetIndividual(){
        Scanner scan = new Scanner(System.in);
        Population pop = new Population(scan.nextInt(), true);
        printPopulation(pop);
        while(true){
            System.out.println("Insert the index of the individual you want to check. -1 to exit");
            int x = scan.nextInt();
            if(x<0) break;
            System.out.println("The individual " + x +" is: "+pop.getIndividual(x));
        }
    }

    public void testSetIndividual(){
        Scanner scan = new Scanner(System.in);
        Population pop = new Population(scan.nextInt(), true);
        printPopulation(pop);
        while(true){
            System.out.println("Introduce four digits each one separated by a space in order to generate the individual. Insert the index where you want it. -1 to exit");
            Individual ind = readIndividual();
            int x = scan.nextInt();
            if(x<0) break;
            pop.setIndividual(x,ind);
            printPopulation(pop);
        }
    }

    public void testBestIndividual(){
        Scanner scan = new Scanner(System.in);
        Population pop = new Population(scan.nextInt(), true);
        printPopulation(pop);
        FitnessCalculus fc = new FitnessCalculus();
        //System.out.println("The best member of this population is: " + pop.bestIndividual(fc));

    }

    public void testStartTournament(){

    }

    public void testEvolvePopulation(){

    }

    public void showOptions(){
        System.out.println("Select an option: \n ");
        System.out.println("1: Test Constructor ");
        System.out.println("2: Test Copy ");
        System.out.println("3: Test NumIndividuals ");
        System.out.println("4: Test GetIndividual ");
        System.out.println("5: Test SetIndividual");
        System.out.println("6: Test BestIndividual");
        System.out.println("7: Test StartTournament");
        System.out.println("0: Exit ");
    }
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Individual driver: \n");
        Individual ind = new Individual();
        Solution s = new Solution(2,3, ind);
        boolean b = true;
        DriverPopulation DFC = new DriverPopulation();
        DFC.setSolution(s);
        while(b) {
            int x = 0;
            DFC.showOptions();
            x = scan.nextInt();
            switch(x){
                case 0:
                    b = false;
                    break;
                case 1:
                    System.out.println("Usage: Generates a population with random individuals. Write the population's size.");
                    DFC.testConstructor();
                    break;
                case 2:
                    System.out.println("Usage: Copies a population into another. Write the first population size.");
                    DFC.testCopy();
                    break;
                case 3:
                    System.out.println("Usage: Displays the number of individuals that a population holds. Write the population's size.");
                    DFC.testNumIndividuals();
                    break;
                default: System.err.println("Wrong option code. ");
            }
            System.out.println();

        }
    }
}
