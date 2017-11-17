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
        int out = 0;
        for(int i=0; i<ind.numGenes(); i++) out += ind.getGen(i)*i;
        return out;
    }
}
