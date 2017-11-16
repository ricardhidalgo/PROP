import Logic.Combination;

import java.util.Scanner;


public class DriverCombination {

    public static void main(String[] args) {
        Combination cont = new Combination();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Estas provando la clase Combination");
            while (true) {
                System.out.println();
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Instanciar contenido vacío");
                System.out.println("2. Instanciar contenido con un String");
                System.out.println("3. Get contenidoOriginal");
                System.out.println("4. Set contenidoOriginal con un String");
                System.out.println("5. Get contenidoReducido");
                System.out.println("6. Calcular distancia respecto a otro contenido");
                System.out.println("7. Salir");
                int op = sc.nextInt();
                switch (op) {


                    default:
                        System.out.println("Operación incorrecta");
                        break;
                }
                System.out.println("¿Desea realizar otra operación? (s/n)");
                String resp = sc.next();
                if (resp.equals("n")) return;
                sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

