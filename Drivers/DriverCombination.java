import Logic.Combination;

import java.util.ArrayList;
import java.util.Scanner;


public class DriverCombination {

    public static void main(String[] args) {
        Combination comb = new Combination();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Estas provando la clase Combination");
            while (true) {
                System.out.println();
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Instanciar combination vacío");
                System.out.println("2. Instanciar combination con un Array de Bytes");
                System.out.println("3. Get Combinacion");
                System.out.println("4. Set Combinacion con un Array de Bytes");
                System.out.println("5. Comparar combinacion");
                System.out.println("6. Comprobar si la combinación tiene repetidos");
                System.out.println("7. Salir");
                int op = sc.nextInt();
                int size = 0;
                Combination aux = new Combination();
                ArrayList<Byte> ab = new ArrayList<>();
                switch (op) {
                    case 1:
                        comb = new Combination();
                        break;
                    case 2:
                        System.out.println("Escriba el tamaño de la combinación: ");
                        size = sc.nextInt();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int i = 0; i<size; ++i) {
                            ab.add(sc.nextByte());
                        }
                        comb = new Combination(ab);
                        break;
                    case 3:
                        System.out.println("La combinación es: ");
                        System.out.println(comb.getComb());
                        break;
                    case 4:
                        System.out.println("Escriba el tamaño de la combinación: ");
                        size = sc.nextInt();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int i = 0; i<size; ++i) {
                            ab.add(sc.nextByte());
                        }
                        comb.setCombination(ab);
                        System.out.println("Combinación actualizada");
                        break;
                    case 5:
                        System.out.println("Se comparará la combinación actualmente guardada con la que se introduzca");
                        System.out.println("Escriba el tamaño de la combinación: ");
                        size = sc.nextInt();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int i = 0; i<size; ++i) {
                            ab.add(sc.nextByte());
                        }
                        aux.setCombination(ab);
                        System.out.println("El resultado de la comparación se expresa en un ArrayList de Bytes que sera procesado en la clase play y guardado para proporcionar ayudas en caso de ser necesario");
                        System.out.println(comb.compareCombinations(aux));


                        break;
                    case 6:

                        System.out.println("Se Comprobará si la combinación tiene repetidos:");
                        System.out.println(comb.hasRepeat());
                        break;


                    case 7:
                        System.out.println("Salir");
                        return;


                    default:
                        System.out.println("Operación incorrecta");
                        break;
                }
                System.out.println("¿Desea realizar otra operación? (s/n)");
                String resp = sc.next();
                if (resp.equals("n")) return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

