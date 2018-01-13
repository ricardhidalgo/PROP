import Logic.Difficulty;

import java.util.Scanner;

/**
 * @author ricard.hidalgo
 */

public class DriverDifficulty {

    public static void main(String[] args) {
        Difficulty diff = new Difficulty();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Esta provando la clase Difficulty");
            while (true) {
                System.out.println();
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Instanciar difficulty vacío");
                System.out.println("2. Poner dificultad a nivel facil");
                System.out.println("3. Poner dificultad a nivel medio");
                System.out.println("4. Poner dificultad a nivel dificil");
                System.out.println("5. Poner parámetros personalizados de dificultad");
                System.out.println("6. Get numero de bolas por combinación");
                System.out.println("7. Get si se pueden repetir colores");
                System.out.println("8. Get codigo de dificultad");
                System.out.println("9. Get si se han activado los tips");
                System.out.println("10. Salir");
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        diff = new Difficulty();
                        break;

                    case 2:
                        System.out.println("Indique si quiere habilitar los tips (true/false): ");
                        diff.setEasy(sc.nextBoolean());
                        break;
                    case 3:
                        System.out.println("Indique si quiere habilitar los tips (true/false): ");
                        diff.setMedium(sc.nextBoolean());
                        break;
                    case 4:
                        System.out.println("Indique si quiere habilitar los tips (true/false): ");
                        diff.setHard(sc.nextBoolean());
                        break;
                    case 5:
                        System.out.println("Indique número de bolas por combinación: ");
                        System.out.println("Indique si esta permitido repetir colores en las combinaciones(true/false): ");
                        System.out.println("Indique si quiere habilitar los tips (true/false): ");
                        diff.setCustom(sc.nextInt(), sc.nextBoolean(), sc.nextBoolean());
                        break;
                    case 6:
                        System.out.println(diff.getNumBallsInCombination());
                        break;

                    case 7:
                        System.out.println(diff.isCanRepeat());
                        break;


                    case 8:
                        System.out.println(diff.getDifficultyCode());
                        break;

                    case 9:
                        System.out.println(diff.isHasTips());
                        break;

                    case 10:
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
