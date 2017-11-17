
import java.util.*;
import Logic.Ranking;

public class RankingDriver {
    public static void main(String[] args) {
        System.out.println("Indica función a comprobar en la clase Ranking (escribe 'end' para acabar");
        System.out.println("1. Insertar nick-score partida");
        System.out.println("2. Escribir y sobreescribir en un .txt");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Ranking persona;
        while (!input.equals("end")) {
            switch (input) {

                case "1":
                    System.out.println("Indica nick jugadr y puntuacion");
                    persona = new Ranking(scanner.next(), scanner.nextInt());
                    persona.InsertRanking();
                    for (int i = 0; i < persona.getsize(); i++) {
                        System.out.println("La dupla " + i + " es " + persona.getranking().get(i).getkey() + " --- " + persona.getranking().get(i).getvalue());
                    }
                    break;
/*
                case "2":

                    System.out.println("El score es: " + p2.getvalue());
                    break;*/

            }
            input = scanner.next();
        }
    }
}