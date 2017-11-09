package Data;

import java.util.Vector;
import Data.BackEnd;

public class CtrlDataUser {
    BackEnd bck = new BackEnd();
    public CtrlDataUser(){
    }
    public boolean GetUser(String id){
        return false;
    }
    public void InsertUser(Vector<String> v){
        if(v.size()<2){ System.err.println("Error inserting user: too few arguments."); return;}

    }
}
