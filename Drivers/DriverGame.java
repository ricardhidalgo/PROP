import Logic.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DriverGame {


    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Esta provando la clase Game");
            while (true) {
                System.out.println();
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Instanciar game vacío");
                System.out.println("2. Instanciar game con configuración de inicio de partida");
                System.out.println("3. Instanciar game con configuración de partida en curso");
                System.out.println("4. Set codigo secreto de la partida");
                System.out.println("5. Hacer una jugada");
                System.out.println("6. Get usuario jugando a la partida");
                System.out.println("7. Get rol del usuario");
                System.out.println("8. Get codigo secreto");
                System.out.println("9. Get listado de jugadas");
                System.out.println("10. Get configuracion de dificultad");
                System.out.println("11. Salir");
                int op = sc.nextInt();
                int i = 0, size = 0, size2 = 0;
                User user;
                AI ai;
                Difficulty difficulty = new Difficulty();
                Combination secret = new Combination();
                Combination combination = new Combination();
                ArrayList<Byte> ab = new ArrayList<>();
                ArrayList<Play> plays = new ArrayList<>();
                switch (op) {
                    case 1:
                        game = new Game();
                        break;
                    case 2:
                        System.out.println("Tipe User username and password: ");
                        user = new User(sc.next(), sc.next());
                        System.out.println("Select difficulty (1 for easy, 2 for medium, 3 for hard: ");
                        op = sc.nextInt();
                        switch (op){
                            case 1:
                                difficulty.setEasy(true);
                                break;
                            case 2:
                                difficulty.setMedium(true);
                                break;
                            case 3:
                                difficulty.setHard(true);
                                break;
                            default:
                                difficulty.setMedium(true);
                                break;
                        }
                        ai = new AI_Genetic(difficulty);

                        System.out.println("Selecciona el rol del usuario(true para CodeBreaker, false para CodeMaster: ");

                        game = new Game(user, ai, sc.nextBoolean(), difficulty);
                        break;
                    case 3:
                        System.out.println("Pon un username i un password para generar al jugador de la partida: ");
                        user = new User(sc.next(), sc.next());
                        System.out.println("Selecciona dificultad (1 para facil, 2 para normal, 3 para dificil: ");
                        op = sc.nextInt();
                        switch (op){
                            case 1:
                                difficulty.setEasy(true);
                                break;
                            case 2:
                                difficulty.setMedium(true);
                                break;
                            case 3:
                                difficulty.setHard(true);
                                break;
                            default:
                                difficulty.setMedium(true);
                                break;
                        }
                        ai = new AI_Genetic(difficulty);

                        System.out.println("Escriba el tamaño de la combinación: ");
                        size = sc.nextInt();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int j = 0; j<size; ++j) {
                            ab.add(sc.nextByte());
                        }
                        secret = new Combination(ab);

                        System.out.println("Escriba el numero de jugadas que desea introducir:");

                        size2 = sc.nextInt();

                        System.out.println("Escriba las combinaciones de las jugadas (del tamaño de la combinación secreta: ");
                        System.out.println("(Tenga en cuenta que esta constructora no contempla la posibilidad de una partida acabada. Si se introduce la combinación secreta en una de las jugadas, esta sera ignorada)");
                        for(int k = 0; k<size2; ++k) {
                            System.out.println("Escriba la combinación de bytes: ");
                            for (int j = 0; j < size; ++j) {
                                ab.add(sc.nextByte());
                            }
                            combination = new Combination(ab);
                            Play play = new Play();
                            play.processPlay(combination, secret);
                            plays.add(play);

                        }

                        System.out.println("Selecciona el rol del usuario(true para CodeBreaker, false para CodeMaster: ");

                        game = new Game(user, ai, sc.nextBoolean(), secret, plays, difficulty);
                        break;
                    case 4:
                        System.out.println("Escriba el tamaño de la combinación secreta: ");
                        size = sc.nextInt();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int j = 0; j<size; ++j) {
                            ab.add(sc.nextByte());
                        }
                        secret = new Combination(ab);
                        game.setSecretCode(secret);
                        break;
                    case 5:
                        System.out.println("Escriba el tamaño de la combinación secreta: ");
                        size = sc.nextInt();
                        System.out.println("Escriba la combinación de bytes: ");
                        for(int j = 0; j<size; ++j) {
                            ab.add(sc.nextByte());
                        }
                        combination = new Combination(ab);
                        game.makePlay(combination);
                        break;
                    case 6:

                        System.out.println(game.getUser());
                        break;

                    case 7:

                        System.out.println(game.isUserBreaker());
                        break;
                    case 8:

                        System.out.println(game.getSecretCode());
                        break;
                    case 9:

                        System.out.println(game.getPlays());
                        break;

                    case 10:

                        System.out.println(game.getDifficulty());
                        break;

                    case 11:
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
