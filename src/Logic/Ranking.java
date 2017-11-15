package Logic;

import java.util.*;

/**
 * @author pol.gil
 */

public class Ranking {

    private String nickname;
    private int score;
    private ArrayList<MyPair> ranking;

    public Ranking (String nick, int score) {
        this.nickname = nick;
        this.score = score;
    }

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
}
