package Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Coordinador {

    private ArrayList<Byte> comb;
    private int numBallsInCombination;
    private boolean canRepeat;
    private int dificultyCode;
    private boolean hasTips;
    private int puntuation;
    private User user;
    private boolean isUserBreaker;
    private Combination secretCode;
    private ArrayList<Play> plays;
    private Difficulty difficulty;
    private AI ai;
    private String key;
    private int value;
    private ArrayList<Byte> correctColors;
    private Combination combination;
    private int numCorrectColors;
    private int numCorrectPositions;
    private String password;
    private String nickname;
    private String nickname2;
    private int score;
    private ArrayList<MyPair> ranking = new ArrayList<MyPair>();


    public ArrayList<Byte> getComb() {
        return this.comb;
    }

    public void setCombination(ArrayList<Byte> combination) {

        this.comb = combination;

    }

    public ArrayList<Byte> compareCombinations(Combination combination) {

        ArrayList<Byte> tips = new ArrayList<Byte>();
        boolean correct = true;

        for (int i = 0; i < this.comb.size(); ++i) {
            if (this.comb.get(i).equals(combination.getComb().get(i))) {
                tips.add((byte)2);
            } else {
                tips.add((byte)0);
                correct = false;
            }
        }

        if (correct) {
            return tips;
        } else {
            ArrayList<Byte> tips2 = new ArrayList<>(tips);
            for (int i = 0; i < tips.size(); ++i) {
                if (tips.get(i) == 0) {
                    for (int j = 0; j < tips.size(); ++j) {
                        if (this.comb.get(j).equals(combination.getComb().get(i)) && tips2.get(j) == 0) {
                            tips.set(i, (byte)1);
                            tips2.set(j, (byte)1);

                            j = tips.size();
                        }
                    }
                }
            }
            return tips;

        }
    }

    public boolean hasRepeat() {
        Set<Byte> hcomb = new HashSet<Byte>(this.comb);
        return comb.size() > hcomb.size();
    }

    public void setEasy(boolean tips) {
        this.numBallsInCombination = 4;
        this.canRepeat = false;
        this.dificultyCode = 1;
        this.hasTips = tips;

    }

    public void setMedium(boolean tips) {
        this.numBallsInCombination = 6;
        this.canRepeat = false;
        this.dificultyCode = 2;
        this.hasTips = tips;

    }

    public void setHard(boolean tips) {
        this.numBallsInCombination = 8;
        this.canRepeat = true;
        this.dificultyCode = 3;
        this.hasTips = tips;

    }

    public void setCustom(int numBalls, boolean canRep, boolean tips) {
        this.numBallsInCombination = numBalls;
        this.canRepeat = canRep;
        this.dificultyCode = 4;
        this.hasTips = tips;

    }

    public Integer getNumBallsInCombination() {
        return numBallsInCombination;
    }

    public boolean isCanRepeat() {
        return canRepeat;
    }

    public int getDificultyCode() {
        return dificultyCode;
    }

    public boolean isHasTips() {
        return hasTips;
    }

    public int getPuntuation() {
        return puntuation;
    }

    public void setPuntuation(int puntuation) {
        this.puntuation = puntuation;
    }

    public void setSecretCode(Combination comb) {
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            System.err.println("Wrong parameters 1");
        } else {
            this.secretCode = comb;
        }
    }

    public Play makePlay(Combination comb) {
        Play np = new Play();
        if (comb.getComb().size() != difficulty.getNumBallsInCombination() || (comb.hasRepeat() && !difficulty.isCanRepeat())) {
            System.err.printf("Wrong parameters 2");
        } else {
            np.processPlay(comb, secretCode);
            plays.add(np);
        }
        return np;
    }

    public User getUser() {
        return user;
    }

    public boolean isUserBreaker() {
        return isUserBreaker;
    }

    public Combination getSecretCode() {
        return secretCode;
    }

    public ArrayList<Play> getPlays() { return plays; }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public AI getAi() {
        return ai;
    }

    public void Modifykey(String key) {
        this.key = key;
    }

    public void Modifyvalue(int value) {
        this.value = value;
    }

    public String getkey() {
        return key;
    }

    public int getvalue() {
        return value;
    }

    public ArrayList<Byte> getCorrectColors() {
        return correctColors;
    }

    public void modifyComb(Combination comb) { this.combination = comb; }

    public Combination getCombination() {
        return combination;
    }

    public void modifyPosition(int position) { this.numCorrectPositions = position; }

    public int getNumCorrectPositions() {
        return numCorrectPositions;
    }

    public void modifyColor(int color) { this.numCorrectColors = color; }

    public int getNumCorrectColors() {
        return numCorrectColors;
    }

    public void processPlay(Combination comb, Combination secret) {
        this.combination = comb;
        correctColors = secret.compareCombinations(combination);

        numCorrectColors = 0;
        numCorrectPositions = 0;
        for (int i = 0; i < correctColors.size(); ++i) {
            if (correctColors.get(i) == 1) ++numCorrectColors;
            else if (correctColors.get(i) == 2) ++numCorrectPositions;
        }

    }

    public String getNickname(){ return this.nickname; }

    public boolean validateUser(String pwd) {
        if(this.password==pwd) return true;
        return false;

    }

    public String getnick() {
        return nickname2;
    }

    public int getscore() {
        return score;
    }

    public void modifynick(String nick) {
        nickname2 = nick;
    }

    public void modifyscore(int score) {
        this.score = score;
    }

    public void modifyranking(ArrayList<MyPair> rank) { this.ranking = rank; }

    public int getsize() {
        return ranking.size();
    }

    public ArrayList<MyPair> getranking() {
        return ranking;
    }

    public void InsertRanking () {
        MyPair ID = new MyPair(nickname2, score);
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

    public void escribirtxt() {

        try {

            File archivo = new File("ranking.txt");
            if (!archivo.exists()) {
                if (!archivo.createNewFile()) {
                    System.out.println("Error");
                }
            }
            archivo.delete();
            archivo = new File("ranking.txt");

            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo, true));
            for (int i = 0; i < ranking.size(); i++) {
                bw.write(ranking.get(i).getkey() + " - " + ranking.get(i).getvalue() + "\n");
            }
            bw.close();
        }

        catch (IOException errorDeFichero) {
            System.out.println("Error al escribir el ranking" + errorDeFichero.getMessage());
        }
    }
}

