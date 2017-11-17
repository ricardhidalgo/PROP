
import java.util.Scanner;
import Logic.MyPair;

public class MyPairDriver {
    public static void main(String[] args) {
        System.out.println("Indica función a comprobar en la clase Pair (escribe 'end' para acabar");
            System.out.println("1. Comprobar el nick");
            System.out.println("2. Comprobar el score");
            System.out.println("3. Modificar el nick");
            System.out.println("4. Modificar el score");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            MyPair p2 = new MyPair("p", 0);
            while (!input.equals("end")) {
            switch (input) {

                case "1":
                    System.out.println("El nickname es: " + p2.getkey());
                    break;

                case "2":
                    System.out.println("El score es: " + p2.getvalue());
                    break;

                case "3":
                    System.out.println("Indroduce nuevo nickname");
                    p2.Modifykey(scanner.next());
                    System.out.println("OK");
                    break;

                case "4":
                    System.out.println("Indroduce nuevo score");
                    p2.Modifyvalue(scanner.nextInt());
                    System.out.println("OK");
                    break;
            }
            input = scanner.next();
        }
    }
}
