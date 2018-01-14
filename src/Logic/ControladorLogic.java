package Logic;

import Persistence.ControladorPersistencia;

import java.util.ArrayList;

public class ControladorLogic {

    Difficulty difficulty;
    int numB;
    boolean rep;
    Game game;
    User usuario;
    boolean breaker;
    AI ia;
    Combination correct = new Combination();
    Combination later = new Combination();
    ArrayList<Play> plays;
    ControladorPersistencia cd;
    Play jugada = new Play();
    Ranking ranking;


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
     * @param diff
     */
    public void setDiff(String diff, boolean tips) {
        difficulty = new Difficulty();
        if (diff == "easy") difficulty.setEasy(tips);
        else if (diff == "medium") difficulty.setMedium(tips);
        else if (diff == "hard") difficulty.setHard(tips);
        else if (diff == "custom") difficulty.setCustom(numB, rep, tips);
    }

    public void setnumB(int num) {
        this.numB = num;
    }

    public void setrep(boolean repeat) {
        this.rep = repeat;
    }

    public ArrayList<String> getMatch(String user, int index) {
        return cd.getMatch(user, index);
    }

    /* true == CodeBreaker */
    public void setType(boolean breaking) {
        breaker = breaking;
    }


    public void setCorrect(ArrayList<Byte> solution) {
        correct = new Combination(solution);
    }

    public Combination getCorrect() {
        return correct;
    }

    public void setPlays(ArrayList<Play> play) {
        plays = play;
    }

    public void start() {
        ia = new AI_Genetic(difficulty);
        plays = new ArrayList<>();
        if (!breaker) game = new Game(usuario, ia, breaker, difficulty);
        else game = new Game(usuario, ia, breaker, correct, plays, difficulty);
    }

    public int getCC() {
        return jugada.getNumCorrectColors();
    }

    public int getCP() {
        return jugada.getNumCorrectPositions();
    }

    public void correctColorsPositions(Combination comb1, Combination comb2) {
        jugada.processPlay(comb1, comb2);
    }

    /* se tiene que hacer un bucle con todas las puntuaciones del mismo usuario y hacer esta funcion en
    todas, de esta forma al final unicamente quedaran las 10 mejores almacenadas.
     */

    public Combination generateCombi() {
        ia = new AI_Genetic(difficulty);
        return ia.generateSecret();
    }

    public Combination FirstGues() {
        ia = new AI_Genetic(difficulty);
        return ia.generateFirstCombination();
    }

    public void setNumCC(int CC) {
        jugada.modifyColor(CC);
    }

    public void setNumCP(int CP) {
        jugada.modifyPosition(CP);
    }

    public void checkAnswer() {
        correctColorsPositions(correct, later);
    }

    public int getNumB(){
        return difficulty.getNumBallsInCombination();
    }

    public void setAnswerCB() {
        ia = new AI_Genetic(difficulty);
        correct = ia.generateSecret();
    }

    public void setAnswerCM(String answer2) {
        ArrayList<Byte> sol = new ArrayList<Byte>();
        for (int i = 0; i < answer2.length(); i++) {
            if (answer2.charAt(i) == 'R') sol.add((byte) 0);
            else if (answer2.charAt(i) == 'Y') sol.add((byte) 1);
            else if (answer2.charAt(i) == 'G') sol.add((byte) 2);
            else if (answer2.charAt(i) == 'B') sol.add((byte) 3);
            else if (answer2.charAt(i) == 'O') sol.add((byte) 4);
            else if (answer2.charAt(i) == 'P') sol.add((byte) 5);
        }
        setCorrect(sol);
        correct = getCorrect();
    }

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
        Combination comb = generateCombi();
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
        Combination comb = GenerateGuess(jugada);
        later = comb;
        ArrayList<Byte> combination = comb.getComb();
        for (int i = 0; i < combination.size(); i++)
            NG += combination.get(i);
        return NG;
    }


    public Combination GenerateGuess(Play jugada) {
        ia = new AI_Genetic(difficulty);
        return ia.generateNextCombination(jugada);
    }

    public String FirstGuess() {
        String FG = "";
        Combination comb = FirstGues();
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

    public ArrayList<MyPair> seeranking(Ranking ranking) {
        return ranking.getRanking();
    }

    public void guardarpuntuacion(String name, ArrayList<String> puntuacion, boolean score) {
        cd.savepuntuation(name, puntuacion, score);
    }

    public int getScore(){
        return game.getScore();
    }

    public Game loadMatch(ArrayList<String> info){
        User us = new User();
        Combination secret = new Combination(info.get(0));
        Difficulty dif = new Difficulty();
        switch(info.get(1)){
            case "Easy":
                dif.setEasy(true);
                break;
            case "Medium":
                dif.setMedium(true);
                break;
            case "Hard":
                dif.setHard(true);
                break;
        }
        ArrayList<Combination> guesses = new ArrayList<>();
        for(int i=2; i<info.size(); i++) guesses.add(new Combination(info.get(i)));
        Game g = new Game(usuario, secret, dif, guesses);
        return g;
    }

    public ArrayList<MyPair> getRanking(){
        return ranking.getRanking();
    }

    public void generateRanking(){
        ArrayList<String> users = cd.getUsers();
        ArrayList<MyPair> rank = new ArrayList<>();
        for(int i=0; i<users.size(); i++){
            ArrayList<String> score = cd.allscores(users.get(i),true);
            for(int j=0; j<score.size(); j++){
                MyPair p = new MyPair(users.get(i), Integer.parseInt(score.get(j)));
                System.out.println(score.get(j));
                rank.add(p);
            }
        }
        ranking = new Ranking(rank);
    }

    public void saveMatch(){
        cd.savepuntuation(usuario.getNickname(), game.retrieveMatch(), false);
    }

}
