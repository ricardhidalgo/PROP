package Drivers;

import java.util.Scanner;

/**
 * @author albert.ortiz
 */

public class DriverPopulation {
    public void testConstructor(){

    }

    public void testCopy(){

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
                    System.out.println("Usage: Generates an empty individual");
                    DFC.testConstructor();
                    break;
                case 2:

                default: System.err.println("Wrong option code. ");
            }
            System.out.println();


        }
    }
}
