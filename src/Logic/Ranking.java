package Logic;

import java.util.ArrayList;

/**
 * @author pol.gil
 */

public class Ranking extends MyPair{


    private String nickname;
    private int score;
    private ArrayList<MyPair> ranking = new ArrayList<MyPair>();


    /**
     * Constructora vacía.
     */
    public Ranking() {
        MyPair ID = new MyPair("NONE", 9999999);
        this.ranking.add(ID);
    }

    /**
     * Constructora preestablecida.
     * @param nick el nick que querremos poner en el ranking.
     * @param score la puntuación que corresponde a la partida de dicho nick.
     */
    public Ranking (String nick, int score) {
        this.nickname = nick;
        this.score = score;
        MyPair ID = new MyPair("NONE", 9999999);
        this.ranking.add(ID);
    }

    /**
     * retorna el nickname del usuario.
     * @return nickname del usuario.
     */
    public String getnick() {
        return nickname;
    }

    /**
     * retorna el score del usuario.
     * @return score del usuario.
     */
    public int getscore() {
        return score;
    }

    /**
     * cambia el atributo nickname por la variable nick.
     * @param nick nuevo nickname del usuario.
     */
    public void modifynick(String nick) {
        nickname = nick;
    }

    /**
     * cambia el atributo score por la variable score.
     * @param score nuevo score del usuario.
     */
    public void modifyscore(int score) {
        this.score = score;
    }

    public void modifyranking(ArrayList<MyPair> rank) { this.ranking = rank; }


    /**
     * Retorna el tamañano del arraylist ranking.
     * @return retorna el total de duplas nick-score que hay inscritas.
     */
    public int getsize() {
        return ranking.size();
    }

    /**
     * Retorna el array con el ranking.
     * @return retorna el ranking.
     */
    public ArrayList<MyPair> getranking() {
        return ranking;
    }

    /**
     * Inserta una combinación nick-score en el caso que el score de esta partida sea mayor a alguno
     * de los puestos anteriormente.
     */
    public void InsertRanking () {
        MyPair ID = new MyPair(nickname, score);
        boolean found = false;
        boolean used = false;

        if (ranking.size() >= 1) {
             for (int i = 0; i < ranking.size() && !found; i++) {
                 if (ranking.get(i).getvalue() >= ID.getvalue()) {
                     MyPair aux = new MyPair();
                     for (int j = i; j < ranking.size(); j++) {
                         aux.Modifykey(ranking.get(j).getkey());
                         aux.Modifyvalue(ranking.get(j).getvalue());
                         ranking.get(j).Modifykey(ID.getkey());
                         ranking.get(j).Modifyvalue(ID.getvalue());
                         ID.Modifykey(aux.getkey());
                         ID.Modifyvalue(aux.getvalue());
                     }
                     if (ID.getvalue() < 9999999 && ranking.size() < 10) {
                         found = true;
                         used = true;
                         ranking.add(ID);
                     }
                 }
             }
             if (ID.getvalue() < 9999999 && ranking.size() < 10 && !used) ranking.add(ID);
        }
    }

}
