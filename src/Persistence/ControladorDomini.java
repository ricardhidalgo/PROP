package Persistence;

import java.util.ArrayList;

public class ControladorDomini {

    dataGestor dg = new dataGestor();

    public ControladorDomini() {

    }

    public boolean TryName(String name) {
        if (dg.findUser(name) != null) return true;
        else return false;
    }

    public boolean CorrectPW (String name, String pw) {
        return (TryName(name) && dg.findUser(name).get(1) == pw);
    }

    public void create (String nickname, String pw) {
        if (!TryName(nickname)) dg.createUser(nickname, pw);
    }

    public void savepuntuation(String nickname, ArrayList<String> info, boolean score) {
        dg.save(nickname, info, score);
    }

    public ArrayList<String> allscores(String nickname, boolean score) {
        return dg.retrieveAll(nickname, score);
    }

}
