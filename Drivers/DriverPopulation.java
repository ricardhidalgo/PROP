package Drivers;
import Logic.Genetic.Individual;
import Logic.Genetic.Population;
import java.util.Scanner;

/**
 * @author albert.ortiz
 */

public class DriverPopulation {

    private void printIndividual(Individual ind){
        for(int i=0; i<ind.numGenes(); i++) System.out.print(ind.getGen(i));
        System.out.print("\n");
    }

    private void printPopulation(Population p){
        System.out.println("The content of the population is:");
        for(int i=0; i<p.numIndividuals(); i++) printIndividual(p.getIndividual(i));

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

    }

    public void testGetIndividual(){

    }

    public void testGetIndividuals(){

    }

    public void testSetIndividual(){

    }

    public void testBestIndividual(){

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
        System.out.println("5: Test GetIndividuals ");
        System.out.println("6: Test SetIndividual");
        System.out.println("7: Test BestIndividual");
        System.out.println("8: Test StartTournament");
        System.out.println("0: Exit ");
    }
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Individual driver: \n");
        boolean b = true;
        DriverPopulation DFC = new DriverPopulation();
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
                default: System.err.println("Wrong option code. ");
            }
            System.out.println();

        }
    }
}
