package Logic;

public class User {
    private String password;
    private String nickname;

    public User(String nick, String pwd) {
        this.password = pwd;
        this.nickname = nick;

    }

    public String getNickname(){
        return this.nickname;
    }

    public boolean validateUser(String pwd) {
        if(this.password==pwd) return true;
        return false;

    }
}
