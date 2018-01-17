package Logic;

import Persistence.ControladorPersistencia;

import java.util.ArrayList;

public class ControladorLogic {

    private Difficulty difficulty;
    private Game game;
    private User usuario;
    private boolean breaker;
    private AI ia;
    private Combination correct = new Combination();
    private Combination later = new Combination();
    private ArrayList<Play> plays;
    private ControladorPersistencia cd;
    private Play jugada = new Play();
    private Ranking ranking;


    /**
     * Constructora por defecto
     */
    public ControladorLogic() {
        cd = new ControladorPersistencia();
    }


    /**
     * Combrueba que el nombre de usuario dado existe en el registro de usuarios.
     *
     * @param nick Nombre de usuario.
     * @return True si existe, false en caso contrario.
     * @deprecated Ya incluida en register y loginUser.
     */
    @Deprecated
    public boolean existsName(String nick) {
        return cd.tryName(nick);
    }

    /**
     * Da de alta un nuevo usuario en el registro de usuarios e inicia sesión con el.
     *
     * @param nick Nombre del usuario.
     * @param pw   Contraseña de acceso del usuario.
     * @return True si la operación se ha relizado con éxito. False en caso contrario (Usuario ya existe).
     */
    public boolean register(String nick, String pw) {
        if (cd.tryName(nick)) {
            return false;
        } else {
            cd.create(nick, pw);
            usuario = new User(nick, pw);
            return true;
        }
    }

    /**
     * Comprueba si el usuario y la contraseña concuerdan en el registro de usuario.
     *
     * @param nick Nombre de usuario.
     * @param pw   Contraseña del usuario.
     * @return True si concuerdan. False en caso contrario.
     * @deprecated Ya incluida por defecto en loginUser.
     */
    @Deprecated
    public boolean checkPassword(String nick, String pw) {
        return cd.correctPW(nick, pw);
    }

    /**
     * Intenta iniciar sesión con el nombre de usuario y la contraseña dados.
     *
     * @param nick Nombre de usuario
     * @param pw   Contraseña
     * @return True si se ha podido iniciar sesión con éxito. False en caso contrario (Usuario o contraseña incorrecto).
     */
    public boolean loginUser(String nick, String pw) {
        if (cd.tryName(nick) && cd.correctPW(nick, pw)) {
            usuario = new User(nick, pw);
            return true;
        } else return false;

    }

    /**
     * Crea un nuevo objeto Difficulty y le assigna un valor de dificultad.
     * @param diff Dificultad asignada.
     * @param tips Determina si se han pedido pistas.
     */
    public void setDiff(String diff, boolean tips) {
        difficulty = new Difficulty();
        if (diff == "easy") difficulty.setEasy(tips);
        else if (diff == "medium") difficulty.setMedium(tips);
        else if (diff == "hard") difficulty.setHard(tips);
        else if (diff == "custom") difficulty.setCustom(tips);
    }


    /**
     * Configura la dificultad custom con los parámetros restantes.
     *
     * @param numB Número de bolas en una combinación.
     * @param rep  Especifica si se permiten repetidos.
     */
    public void configureCustom(int numB, boolean rep) {
        difficulty.configureCustom(numB, rep);
    }

    public ArrayList<String> getMatch(String user, int index) {
        return cd.getMatch(user, index);
    }

    /**
     * Especifica el rol del jugador en la partida
     *
     * @param breaking True si el jugador es CodeBreaker. False si es CodeMaster.
     */
    public void setType(boolean breaking) {
        breaker = breaking;
    }


    /*public void setPlays(ArrayList<Play> play) {
        plays = play;
    }*/

    /**
     * Inicializa la IA con los parámetros de dificultad establecidos e inicializa el ArrayList de jugadas con un ArrayList vacio
     */
    public void initialize() {
        ia = new AI_Genetic(difficulty);
        plays = new ArrayList<>();
        if (!breaker) game = new Game(usuario, ia, breaker, difficulty);
        else game = new Game(usuario, ia, breaker, correct, plays, difficulty);
    }

    /**
     * Retorna el número de colores correctos en posicion incorrecta de la última jugada.
     * @return Número de colores correctos en posicion incorrecta de la última jugada.
     */
    public int getCC() {
        return jugada.getNumCorrectColors();
    }

    /**
     * Retorna el número de colores correctos en posicion correcta de la última jugada.
     * @return Número de colores correctos en posicion correcta de la última jugada.
     */
    public int getCP() {
        return jugada.getNumCorrectPositions();
    }

    public void correctColorsPositions(Combination comb1, Combination comb2) {
        jugada.processPlay(comb1, comb2);
    }

    /* se tiene que hacer un bucle con todas las puntuaciones del mismo usuario y hacer esta funcion en
    todas, de esta forma al final unicamente quedaran las 10 mejores almacenadas.
     */

    public Combination generateIASecret() {
        ia = new AI_Genetic(difficulty);
        return ia.generateSecret();
    }

    public Combination firstGuess() {
        ia = new AI_Genetic(difficulty);
        return ia.generateFirstCombination();
    }

    public void checkAnswer() {
        correctColorsPositions(correct, later);
    }

    /**
     * Getter del tamaño de las combinaciones.
     *
     * @return Tamaño de las combinaciones de la dificultad establecida.
     */
    public int getCombinationSize() {
        return difficulty.getNumBallsInCombination();
    }

    /**
     * Getter de si se permiten repeticiones en las combinaciones.
     *
     * @return True si se permiten repeticiones. False en caso contrario.
     */
    public boolean isCanRepeat() {
        return difficulty.isCanRepeat();
    }

    /**
     * Provoca que la IA genere una combinación secreta que siga los parametros de dificultad establecidos.
     */
    public void setAnswerCB() {
        ia = new AI_Genetic(difficulty);
        correct = ia.generateSecret();
    }

    /**
     * Recoge y almacena el codigo secreto establecido por el usuario.
     *
     * @param answer2 Codigo secreto del usuario.
     */
    public void setAnswerCM(String answer2) {

        ArrayList<Byte> sol = new ArrayList<>();
        for (int i = 0; i < answer2.length(); i++) {
            if (answer2.charAt(i) == 'R') sol.add((byte) 0);
            else if (answer2.charAt(i) == 'Y') sol.add((byte) 1);
            else if (answer2.charAt(i) == 'G') sol.add((byte) 2);
            else if (answer2.charAt(i) == 'B') sol.add((byte) 3);
            else if (answer2.charAt(i) == 'O') sol.add((byte) 4);
            else if (answer2.charAt(i) == 'P') sol.add((byte) 5);
        }
        correct = new Combination(sol);
    }

    /**
     * Genera una nueva jugada con la combinación introducida por el usuario.
     *
     * @param guess Combinación introducida por el usuario.
     */
    public void setGuess(String guess) {
        ArrayList<Byte> sol = new ArrayList<Byte>();
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == 'R') sol.add((byte) 0);
            else if (guess.charAt(i) == 'Y') sol.add((byte) 1);
            else if (guess.charAt(i) == 'G') sol.add((byte) 2);
            else if (guess.charAt(i) == 'B') sol.add((byte) 3);
            else if (guess.charAt(i) == 'O') sol.add((byte) 4);
            else if (guess.charAt(i) == 'P') sol.add((byte) 5);
        }
        later = new Combination(sol);
        game.makePlay(new Combination(sol));
        checkAnswer();
    }

    public String RandomSolution() {
        String RS = "";
        Combination comb = generateIASecret();
        ArrayList<Byte> combination = comb.getComb();
        for (int i = 0; i < combination.size(); i++)
            RS += combination.get(i);
        return RS;
    }

    public String NextGuess() {
        Play jugada = new Play();
        jugada.modifyPosition(getCC());
        jugada.modifyColor(getCP());
        String NG = "";
        Combination comb = ia.generateNextCombination(jugada);
        later = comb;
        ArrayList<Byte> combination = comb.getComb();
        for (int i = 0; i < combination.size(); i++)
            NG += combination.get(i);
        return NG;
    }

    public String FirstGuess() {
        String FG = "";
        Combination comb = firstGuess();
        ArrayList<Byte> combination = comb.getComb();
        later = comb;
        for (int i = 0; i < combination.size(); i++)
            FG += combination.get(i);
        return FG;
    }

    public ArrayList<String> score(String nickname, boolean score) {
        return cd.allscores(nickname, score);
    }

    /*public void CreateRanking(Ranking ranking, String usuario) {
        ArrayList<String> puntuacion = cd.allscores(usuario, true);
        for (int i = 0; i < puntuacion.size(); i++) {
            insert1puntuation(ranking, usuario, Integer.parseInt(puntuacion.get(i)));
        }
    }*/

    /*public void convertranking() {
        CreateRanking(ranking, usuario);
    }*/

    public void saveScore(String name, ArrayList<String> punctuation, boolean score) {
        cd.savepuntuation(name, punctuation, score);
    }

    public int getGameScore() {
        return game.getScore();
    }

    public void loadMatch(ArrayList<String> info) {
        User us = new User();
        Combination secret = new Combination(info.get(0));
        correct = secret;
        System.out.println(secret.toString());
        Difficulty dif = new Difficulty();
        int numB = Integer.parseInt(info.get(1));
        boolean b = false;
        boolean tips = false;
        if (info.get(2) == "true") b = true;
        if (info.get(3) == "true") tips = true;
        ArrayList<Combination> guesses = new ArrayList<>();
        for (int i = 4; i < info.size(); i++) guesses.add(new Combination(info.get(i)));
        dif.setCustom(tips);
        dif.configureCustom(numB, b);
        difficulty = dif;
        Game g = new Game(usuario, secret, dif, guesses);
        game = g;
    }

    public ArrayList<String> getRanking() {
        ArrayList<String> rank = new ArrayList<>();
        ArrayList<MyPair> arrP = ranking.getRanking();
        for (int i = 0; i < arrP.size(); i++) rank.add(arrP.get(i).getkey() + ":    " + arrP.get(i).getvalue());
        return rank;
    }

    public void generateRanking() {
        ArrayList<String> users = cd.getUsers();
        ArrayList<MyPair> rank = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            ArrayList<String> score = cd.allscores(users.get(i), true);
            for (int j = 0; j < score.size(); j++) {
                MyPair p = new MyPair(users.get(i), Integer.parseInt(score.get(j)));
                rank.add(p);
            }
        }
        ranking = new Ranking(rank);
    }

    public void saveMatch() {
        cd.savepuntuation(usuario.getNickname(), game.retrieveMatch(), false);
    }

}
