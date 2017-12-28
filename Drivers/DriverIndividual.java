package Drivers;
/**
 * @author albert.ortiz
 */
/*
import Logic.Genetic.FitnessCalculus;
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
        Individual ind = readIndividual();
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insert the index and the value. The value must be a digit between 0 and 7. -1 to exit");
            int x = scan.nextInt();
            byte y = scan.nextByte();
            if(x<0) break;
            if(x>=ind.numGenes()){
                System.err.println("Error: you inserted an index higher than the individual's size!");
                continue;
            }
            if(y>7 || y<0){
                System.err.println("Error: you inserted an invalid value!");
                continue;
            }
            ind.setGen(x,y);
            System.out.println("The individual state after the insertion is: ");
            printIndividual(ind);
        }
    }

    public void testInitializeIndividual(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insert any number to generate a new individual. -1 to exit");
            int x = scan.nextInt();
            if(x<0) break;
            Individual ind = new Individual();
            ind.initializeIndividual();
            printIndividual(ind);
            System.out.println("The output should be a 4-digit random number.");
        }
    }

    public void testFitnessIndividual(){
        Scanner scan = new Scanner(System.in);
        FitnessCalculus fc = new FitnessCalculus();
        while(true){
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

    public void testRecombinateIndividual(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insert the individuals. -1 To exit.");
            Individual ind = new Individual();
            byte a = scan.nextByte();
            if(a<0) break;
            else ind.setGen(0, a);
            for(int j=1; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            Individual ind2 = new Individual();
            for(int j=0; j<ind.numGenes(); j++) ind2.setGen(j, scan.nextByte());
            System.out.println("Insert the recombination umbral:");
            double umb = scan.nextDouble();
            Individual ind3 = ind.recombinateIndividual(ind2, umb);
            System.out.println("Individual 1 and 2 after recombinating each one leads to:");
            printIndividual(ind3);
        }
    }

    public void testMutateIndividual(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insert the individual. -1 To exit.");
            Individual ind = new Individual();
            byte a = scan.nextByte();
            if(a<0) break;
            else ind.setGen(0, a);
            for(int j=1; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            System.out.println("Insert the mutation ratio.");
            ind.mutateIndividual(scan.nextDouble());
            System.out.println("Individual after mutation:");
            printIndividual(ind);
        }
    }

    public void testPermutateIndividual(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insert the individual. -1 To exit.");
            Individual ind = new Individual();
            byte a = scan.nextByte();
            if(a<0) break;
            else ind.setGen(0, a);
            for(int j=1; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            System.out.println("Insert the permutation ratio.");
            ind.permutateIndividual(scan.nextDouble());
            System.out.println("Individual after permutation:");
            printIndividual(ind);
        }
    }

    public void testInvertIndividual(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insert the individual. -1 To exit.");
            Individual ind = new Individual();
            byte a = scan.nextByte();
            if(a<0) break;
            else ind.setGen(0, a);
            for(int j=1; j<ind.numGenes(); j++) ind.setGen(j, scan.nextByte());
            ind.invertIndividual();
            System.out.println("Individual after being inverted:");
            printIndividual(ind);
        }
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
                    System.out.println("Usage: Copies the introduced individual into an empty one. Introduce four digits each one separated by a space in order to generate the individual.");
                    DFC.testCopy();
                    break;
                case 3:
                    System.out.println("Usage: Outputs the size of the individuals.");
                    DFC.testNumGenes();
                    break;
                case 4:
                    System.out.println("Usage: Outputs the desired gen of the individual. Introduce four digits each one separated by a space in order to generate the individual. " +
                            "Then insert the index of the gen you want to get");
                    DFC.testGetGen();
                    break;
                case 5:
                    System.out.println("Usage: Inserts the specified gen in the desired location of the individual."+
                            "Introduce four digits each one separated by a space in order to generate the individual. " + "Then insert the index where you want to put the gen followed by its value.");
                    DFC.testSetGen();
                    break;
                case 6:
                    System.out.println("Usage: Generates a random individual.");
                    DFC.testInitializeIndividual();
                    break;
                case 7:
                    System.out.println("Usage: Outputs the individual's fitness."+
                            "Introduce four digits each one separated by a space in order to generate the individual. The FitnessCalculusDriver checks that the value is correct.");
                    DFC.testFitnessIndividual();
                    break;
                case 8:
                    System.out.println("Usage: recombinates two given individuals by the specified umbral and outputs the result. Introduce four digits each one separated by a space in order to generate each individual."
                    +"Then, specify the umbral. ");
                    DFC.testRecombinateIndividual();
                    break;
                case 9:
                    System.out.println("Usage: mutates an individual accordingly to the specified ratio." + "Introduce four digits each one separated by a space in order to generate the individual.");
                    DFC.testMutateIndividual();
                    break;
                case 10:
                    System.out.println("Usage: permutates an individual accordingly to the specified ratio." + "Introduce four digits each one separated by a space in order to generate the individual.");
                    DFC.testPermutateIndividual();
                    break;
                case 11:
                    System.out.println("Usage: inverts a random range of the individual's DNA");
                    DFC.testInvertIndividual();
                    break;
                default: System.err.println("Wrong option code. ");
            }
            System.out.println();


        }
    }
}
*/