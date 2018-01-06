package Drivers;

import java.util.Scanner;
import Logic.FiveGuess;

public class FiveGuessDriver {
    public static void main(String[] args) {
        System.out.println("Indica función a comprobar en la clase Five Guess (escribe 'end' para acabar");
        System.out.println("1. Crea la primera opción.");
        System.out.println("2. Crea todo el set de posibilidades.");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (!input.equals("end")) {
            switch (input) {

                case "1":
                    System.out.println("Introduce tamaño de cada combinación ");
                    FiveGuess fg = new FiveGuess(Integer.valueOf(scanner.next()), 5);
                    System.out.println("La primera opción es: " + fg.FirstGuess());
                    break;

                case "2":
                    System.out.println("Introduce tamaño de cada combinación ");
                    FiveGuess fg2 = new FiveGuess(Integer.valueOf(scanner.next()), 3);
                    String c = "";
                    fg2.CreateSet(0, c);
                    System.out.println("El set de posibilidades es: ");
                    for (int i = 0; i < fg2.PosibilitiesSize(); i++) {
                        System.out.println("La opción " + i + " es " + fg2.getPosibilities().get(i));
                    }

                    break;
/*
                case "3":
                    System.out.println("Indroduce nuevo nickname");
                    System.out.println("OK");
                    break;

                case "4":
                    System.out.println("Indroduce nuevo score");
                    p2.Modifyvalue(scanner.nextInt());
                    System.out.println("OK");
                    break;*/
            }
            input = scanner.next();
        }
    }
}
