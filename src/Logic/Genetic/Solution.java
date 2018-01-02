package Logic.Genetic;
/**
 * @author albert.ortiz
 */

public class Solution {
    private int x;
    private int y;
    private Individual ind;

    public Solution(int x, int y, Individual individual){
        ind = individual;
        this.x = x;
        this.y = y;

    }

    public Individual getIndividual(){return ind;}

    public int getBlack(){return x;}

    public int getWhite(){return y;}

    @Override
    public int hashCode() {
        return ind.hashCode();
    }
}
