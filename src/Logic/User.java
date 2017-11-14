package Logic;

/**
 * @author albert.ortiz
 */

public class User {
    private String password;
    private String nickname;

    /**
     * Constructora con un nick y pw preestablecidos.
     * @param nick nombre del usuario.
     * @param pwd contraseña dek mismo.
     */
    public User(String nick, String pwd) {
        this.password = pwd;
        this.nickname = nick;

    }

    /**
     * Retorna el nombre de usuario.
     * @return Nombre de usuario.
     */
    public String getNickname(){
        return this.nickname;
    }

    /**
     * Comprueba que la contraseña del parámetro coincida con la correcta.
     * @param pwd contraseña correcta de un usuario.
     * @return retorna si la contraseña del parámetro es igual a la correcta o no.
     */
    public boolean validateUser(String pwd) {
        if(this.password==pwd) return true;
        return false;

    }
}
