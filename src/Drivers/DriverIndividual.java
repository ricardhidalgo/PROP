package Drivers;
/**
 * @author albert.ortiz
 */

import Logic.Genetic.Individual;

import java.util.Scanner;

public class DriverIndividual {

    public void testConstructor() {
        Individual ind = new Individual();
        System.out.println("Individual generated successfully.");
    }

    public void testCopy() {
        Individual ind = readIndividual();
        Individual ind2 = new Individual();
        ind2.copy(ind);
        System.out.println("The following individual must be a copy of the one you have introduced:");
        printIndividual(ind2);
    }

    public void testNumGenes(){
        Individual ind = new Individual();
        System.out.println("The individual size is: "+ ind.numGenes());
    }

    public void testGetGen(){
        Individual ind = readIndividual();
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insert the index of the gen you want to check. -1 to exit");
            int x = scan.nextInt();
            if(x<0) break;
            if(x>=ind.numGenes()){
                System.err.println("Error: you inserted an index higher than the individual's size!");
                continue;
            }
            System.out.println("The individual's gen " + x +" is: "+ind.getGen(x));
        }
    }

    public void testSetGen(){

    }

    public void testInitializeIndividual(){

    }

    public void testFitnessIndividual(){

    }

    public void testRecombinateIndividual(){

    }

    public void testMutateIndividual(){

    }

    public void testPermutateIndividual(){

    }

    public void testInvertIndividual(){

    }

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

    public void showOptions(){
        System.out.println("Select an option: \n ");
        System.out.println("1: Test Constructor ");
        System.out.println("2: Test Copy");
        System.out.println("3: Test NumGenes");
        System.out.println("4: Test GetGen");
        System.out.println("5: Test SetGen");
        System.out.println("6: Test InitializeIndividual");
        System.out.println("7: Test FitnessIndividual");
        System.out.println("8: Test RecombinateIndividual");
        System.out.println("9: Test MutateIndividual");
        System.out.println("10: Test PermutateIndividual");
        System.out.println("11: Test InvertIndividual");
        System.out.println("0: Exit ");
    }
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Individual driver: \n");
        boolean b = true;
        DriverIndividual DFC = new DriverIndividual();
        while(b) {
            int x = 0;
            DFC.showOptions();
            x = scan.nextInt();
            switch(x){
                case 0:
                    b = false;
                    break;
                case 1:
                    System.out.println("Usage: Generates an empty individual");
                    DFC.testConstructor();
                    break;
                case 2:
                    System.out.println("Usage: Copies the introduced individual into an empty one. Introduce four digits separated by a space each one in order to generate the individual.");
                    DFC.testCopy();
                    break;
                case 3:
                    System.out.println("Usage: Outputs the size of the individuals.");
                    DFC.testNumGenes();
                    break;
                case 4:
                    System.out.println("Usage: Outputs the desired gen of the individual. Introduce four digits separated by a space each one in order to generate the individual. " +
                            "Then insert the index of the gen you want to get");
                    DFC.testGetGen();
                    break;
                case 5:
                    System.out.println("Usage: Inserts the specified gen in the desired location of the individual.");
                default: System.err.println("Wrong option code. ");
            }
            System.out.println();


        }
    }
}

