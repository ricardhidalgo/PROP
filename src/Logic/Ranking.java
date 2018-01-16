package Logic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author albert.ortiz
 */

public class Ranking extends MyPair{


    private String nickname;
    private int score;
    private ArrayList<MyPair> ranking = new ArrayList<MyPair>();

    /**
     * Constructora preestablecida.
     * @param rank todas las puntuaciones del sistema
     */
    public Ranking(ArrayList<MyPair> rank) {
        rank.sort(new rankComparator());
        while (rank.size() > 10) {
            int i = rank.size() - 1;
            rank.remove(i);
        }
        this.ranking = rank;
    }

    public void reload(ArrayList<MyPair> rank) {
        Ranking r = new Ranking(rank);
        this.ranking = r.getRanking();
    }

    public ArrayList<MyPair> getRanking() {
        return ranking;
    }

    /**
     * retorna el nickname del usuario.
     * @return nickname del usuario.
     */
    public String getnick() {
        return nickname;
    }

    /**
     * Retorna el tamañano del arraylist ranking.
     * @return retorna el total de duplas nick-score que hay inscritas.
     */
    public int getsize() {
        return ranking.size();
    }

    /**
     * Devuelve el usuario en la posicion index.
     * @return devuelve el nickname.
     */
    public String getUser(int index) {
        return ranking.get(index).getkey();
    }

    /**
     * Devuelve el score en la posicion index.
     * @return devuelve el score
     */
    public int getScore(int index) {
        return ranking.get(index).getvalue();
    }

}

class rankComparator implements Comparator<MyPair> {
    @Override
    public int compare(MyPair a, MyPair b) {
        return a.getvalue() > b.getvalue() ? -1 : a.getvalue() == b.getvalue() ? 0 : 1;
    }
}