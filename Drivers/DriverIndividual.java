package Logic.Genetic;

import java.util.Scanner;

public class DriverIndividual {

    public void testConstructor() {
    }

    public void testCopy() {
    }

    public void testNumGenes(){

    }

    public void testGetGen(){

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
                    DFC.testGetSolution(scan.nextInt());
                    break;
                case 4:
                    System.out.println("Usage: Checks fitness function. Insert the number of solutions to add and its number of white/black balls. The number of a solution must consist of 4 numbers from 0 to 9 separed by a space. Then insert the individuals you want to check.");
                    DFC.testFitnessIndividual();
                default: System.err.println("Wrong option code. ");
            }


        }
    }
}

