package Logic;

import java.util.Scanner;

public class MyPairDriver {
    public static void main(String[] args) {
        System.out.println("Indica función a comprobar en la clase Ranking");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        MyPair p2 = new MyPair("p", 0);
        while (!input.equals("EXIT")) {
            System.out.println("Función: " + input);
            switch (input) {

                case "getkey":
                    System.out.println("El nickname es: " + p2.getkey());
                    break;

                case "getvalue":
                    System.out.println("El score es: " + p2.getvalue());
                    break;

                case "Modifykey":
                    System.out.println("Indroduce nuevo nickname");
                    p2.Modifykey(scanner.next());
                    System.out.println("OK");
                    break;

                case "Modifyvalue":
                    System.out.println("Indroduce nuevo score");
                    p2.Modifyvalue(scanner.nextInt());
                    System.out.println("OK");
                    break;
            }
        }
    }
}
