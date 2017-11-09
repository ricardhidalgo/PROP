package Logic;
import Logic.User;
import Data.CtrlDataUser;
import java.util.Vector;
import java.util.ArrayList;
public class CtrlDominioMantUser {

    private CtrlDataUser data = new CtrlDataUser();

    public boolean registerUser(String nick, String pwd){
        if(nick.length()<0 && pwd.length()<0 && !data.GetUser(nick)) {
            Vector<String> ve = new Vector<String>(2);
            ve.insertElementAt(nick,0);
            ve.insertElementAt(pwd,1);
            data.InsertUser(ve);
            return true;                                                             //EXECUTION OK
        }
        return false;                                                                //USER ALREADY EXISTS!
    }

    public ArrayList<User> GetUsers(){
        Vector<Vector<String> > v = data.GetUsers();
        ArrayList<User> au = new ArrayList<User>();
        for (int i=0; i<v.size(); i++){
            User u = new User(v.elementAt(i).elementAt(0),v.elementAt(i).elementAt(1));
            au.Add(u);
        }
        return au;
    }
}
