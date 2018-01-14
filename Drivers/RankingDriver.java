
import java.util.*;
import Logic.Ranking;

public class RankingDriver {
    public static void main(String[] args) {
        System.out.println("Indica función a comprobar en la clase Ranking (escribe 'end' para acabar");
        System.out.println("1. Insertar nick-score partida");
        System.out.println("2. Escribir y sobreescribir en un .txt");
        System.out.println("Escribe end para acabar");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        /*Ranking persona = new Ranking();
        while (!input.equals("end")) {
            switch (input) {

                case "1":
                    System.out.println("Indica nick jugador y puntuacion");
                    persona.modifynick(scanner.next());
                    persona.modifyscore(scanner.nextInt());
                    persona.InsertRanking();
                    for (int i = 0; i < persona.getsize(); i++) {
                        int j = i+1;
                        System.out.println("La dupla " + j + " es " + persona.getranking().get(i).getkey() + " --- " + persona.getranking().get(i).getvalue() + ".");
                    }
                    break;
            }
            input = scanner.next();
        }*/
    }
}