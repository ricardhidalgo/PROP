import Logic.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ricard.hidalgo
 */


public class IATest {

    public static void main(String args[]) {
        System.out.println(".............................................");
        System.out.println();
        System.out.println(".........TEST DE LA IA DE MASTERMIND.........");
        System.out.println();
        System.out.println(".............................................");
        System.out.println();
        System.out.println();
        try {
            Scanner sc = new Scanner(System.in);
            User user;
            AI ai;
            Combination secret;
            Combination py;
            int size;
            ArrayList<Byte> ab;
            int op;
            Difficulty difficulty = new Difficulty();

            System.out.println("Pon un username y un password para generar al jugador de la partida: ");
            user = new User(sc.next(), sc.next());
            System.out.println("Selecciona dificultad (1 para facil, 2 para normal, 3 para dificil: ");
            op = sc.nextInt();
            switch (op) {
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

            Game game = new Game(user, ai, sc.nextBoolean(), difficulty);

            System.out.println("¡Juego creado con exito!");
            boolean gameRunning = true;

            if(game.isUserBreaker()){
                game.setSecretCode(game.getAi().generateSecret());
                System.out.println("La IA ha generado la combinación secreta. Te toca jugar: ");
                while (gameRunning){
                    System.out.printf("Inserta una combinación. Recuerda, las combinaciones son de %d, y %b se puede repetir: ",game.getDifficulty().getNumBallsInCombination(), game.getDifficulty().isCanRepeat() ? "si" : "no");
                    ab = new ArrayList<>();
                    System.out.println("Escriba la combinación de bytes: ");
                    for(int i = 0; i<game.getDifficulty().getNumBallsInCombination(); ++i) {
                        ab.add(sc.nextByte());
                    }
                    py = new Combination(ab);
                    Play play = game.makePlay(py);
                    if(play.getNumCorrectPositions() == game.getDifficulty().getNumBallsInCombination()){
                        System.out.println("¡Felicidades, has ganado!");
                        gameRunning = false;
                    } else {
                        System.out.println("Colores correctos en posiciones correctas: ");
                        System.out.println(play.getNumCorrectPositions());
                        System.out.println("Colores correctos en posiciones incorrectas: ");
                        System.out.println(play.getNumCorrectColors());
                        System.out.println();
                    }

                }


            } else {
                System.out.println("Eres el CodeMaster. Genera una combinación y la IA intentará adivinarla: ");
                System.out.printf("Inserta una combinación. Recuerda, las combinaciones son de %d, y %b se puede repetir: \n", game.getDifficulty().getNumBallsInCombination(), game.getDifficulty().isCanRepeat() ? "si" : "no");
                ab = new ArrayList<>();
                System.out.println("Escribe la combinación de bytes: ");
                for(int i = 0; i<game.getDifficulty().getNumBallsInCombination(); ++i) {
                    ab.add(sc.nextByte());
                }
                System.out.println("\nLa combinacion secreta es: "+ab+"\n");
                py = new Combination(ab);
                game.setSecretCode(py);
                int iteracion = 1;

                System.out.printf("Ronda: %d: \n", iteracion);
                Combination c = game.getAi().generateFirstCombination();
                System.out.println("Primera combinacion de la IA: "+ c.getComb());
                Play play = game.makePlay(c);
                if(play.getNumCorrectPositions() == game.getDifficulty().getNumBallsInCombination()){
                    System.out.println("¡La IA ha adivinado la combinación!");
                    gameRunning = false;
                } else {
                    ++iteracion;
                }
                System.out.println("Colores correctos en posiciones correctas: ");
                System.out.println(play.getNumCorrectPositions());
                System.out.println("Colores correctos en posiciones incorrectas: ");
                System.out.println(play.getNumCorrectColors());
                System.out.println();




                while (gameRunning){
                    System.out.printf("Ronda: %d: \n", iteracion);
                    Combination comb = game.getAi().generateNextCombination(play);
                    System.out.println("Combinacion de la IA: "+ comb.getComb());
                    play = game.makePlay(comb);
                    if(play.getNumCorrectPositions() == game.getDifficulty().getNumBallsInCombination()){
                        System.out.println("¡La IA ha adivinado la combinación!");
                        gameRunning = false;
                    }
                        System.out.println("Colores correctos en posiciones correctas: ");
                        System.out.println(play.getNumCorrectPositions());
                        System.out.println("Colores correctos en posiciones incorrectas: ");
                        System.out.println(play.getNumCorrectColors());
                        System.out.println();
                    ++iteracion;

                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
