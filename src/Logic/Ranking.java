package Logic;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author pol.gil
 */

public class Ranking {


    private String nickname;
    private int score;
    private ArrayList<MyPair> ranking = new ArrayList<MyPair>();

    /**
     * Constructora vacía.
     * @param nick el nick que querremos poner en el ranking.
     * @param score la puntuación que corresponde a la partida de dicho nick.
     */
    public Ranking (String nick, int score) {
        this.nickname = nick;
        this.score = score;
    }

    /**
     * Inserta una combinación nick-score en el caso que el score de esta partida sea mayor a alguno
     * de los puestos anteriormente.
     */
    public void InsertRanking () {
        MyPair ID = new MyPair(nickname, score);
        boolean found = false;
        if (ranking.size() == 0) ranking.add(ID);
        else {
            for (int i = 0; i < ranking.size() && !found; i++) {
                if (ranking.get(i).getvalue() > ID.getvalue()) {
                    MyPair aux = new MyPair("",0);
                    for (int j = i; j < ranking.size(); j++) {
                        aux = ranking.get(j);
                        ranking.get(j).Modifykey(ID.getkey());
                        ranking.get(j).Modifyvalue(ID.getvalue());
                    }
                    if (ranking.size() < 11) ranking.add(aux);
                    found = true;
                }
            }
        }
    }

    public void escribir_pantalla() {

        try {
            File archivo = new File("ranking.txt");
            BufferedWriter bw;
            if (!archivo.exists()) {
                if (!archivo.createNewFile()) {
                    System.out.println("Error");
                }
            }
            bw = new BufferedWriter(new FileWriter(archivo, true));
            for (int i = 0; i < ranking.size(); i++) {
                bw.write(ranking.get(i).getkey() + " - " + ranking.get(i).getvalue());
            }
            bw.close();
        }

        catch (IOException errorDeFichero) {
            System.out.println("Error al escribir el ranking" + errorDeFichero.getMessage());
        }
    }

}
