import Logic.Combination;
import Logic.Play;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ricard.hidalgo
 */


public class DriverPlay {

    public static void main(String[] args) {
        Play play = new Play();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Estas provando la clase Play");
            while (true) {
                System.out.println();
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Instanciar play vacío");
                System.out.println("2. Get Array de colores correctos (ayudas)");
                System.out.println("3. Get Combinacion de la jugada");
                System.out.println("4. Get numero de colores correctos en posicion correcta");
                System.out.println("5. Get numero de colores correctos en posicion incorrecta");
                System.out.println("6. Procesar jugada");
                System.out.println("7. Salir");
                int op = sc.nextInt();
                Combination secret;
                Combination py;
                int size;
                ArrayList<Byte> ab;

                switch (op) {
                    case 1:
                        play = new Play();
                        break;
                    case 2:
                        System.out.println(play.getCorrectColors());
                        break;
                    case 3:
                        System.out.println("Referencia a la combinación: ");
                        System.out.println(play.getCombination());
                        System.out.println("Contenido de la combinación: ");
                        System.out.println(play.getCombination().getComb());
                        break;
                    case 4:

                        System.out.println(play.getNumCorrectPositions());
                        break;
                    case 5:
                        System.out.println(play.getNumCorrectColors());
                        break;
                    case 6:
                        System.out.println("Escriba el tamaño de la combinación secreta: ");
                        size = sc.nextInt();
                        ab = new ArrayList<>();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int i = 0; i<size; ++i) {
                            ab.add(sc.nextByte());
                        }
                        secret = new Combination(ab);

                        System.out.println("Escriba el tamaño de la combinación de la jugada: ");
                        size = sc.nextInt();
                        ab = new ArrayList<>();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int i = 0; i<size; ++i) {
                            ab.add(sc.nextByte());
                        }
                        py = new Combination(ab);

                        play.processPlay(py, secret);

                        System.out.println("Operación finalizada");

                        break;


                    case 7:
                        System.out.println("Salir");
                        return;


                    default:
                        System.out.println("Operación incorrecta");
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
