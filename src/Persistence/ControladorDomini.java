package Persistence;

import java.util.ArrayList;

public class ControladorDomini {

    dataGestor dg = new dataGestor();

    public ControladorDomini() {

    }

    public ArrayList<String> getMatch(String user, int i) {
        ArrayList<String> arr = dg.retrieveAll(user, false);
        ArrayList<String> partida = new ArrayList<>();
        String[] out;
        if (arr.size() > i) {
            out = arr.get(i).split("");
            for (int j = 0; j < out.length; j++) partida.add(out[j]);
        } else partida.add("-1");
        return partida;
    }

    public boolean TryName(String name) {
        if (dg.findUser(name).get(0) != "NULL") return true;
        else return false;
    }

    public boolean CorrectPW(String name, String pw) {

        return (TryName(name) && dg.findUser(name).get(1) == pw);
    }

    public void create(String nickname, String pw) {
        if (!TryName(nickname)) dg.createUser(nickname, pw);
    }

    public void savepuntuation(String nickname, ArrayList<String> info, boolean score) {
        dg.save(nickname, info, score);
    }

    public ArrayList<String> allscores(String nickname, boolean score) {
        return dg.retrieveAll(nickname, score);
    }

}
