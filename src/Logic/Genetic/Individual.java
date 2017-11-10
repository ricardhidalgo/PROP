package Logic.Genetic;
import java.util.ArrayList;
public class Individual {
    private int defaultGenNum = 15;
    private ArrayList<Byte> genes;
    private double fitness = 0.0;

    public Individual(){

    }

    public int numGenes(){ return genes.size(); }

    public byte getGen(int pos){ return genes.get(pos); }

    public void setGen(int pos, byte gen){ genes.add(pos,gen); }

    public void initializeIndividual(){
                                                                //MOOOORE SHIT!
    }

    public String toString(){
        return new String();                                    //SHIT AGAIN!
    }

    public double fitnessIndividual(FitnessCalculus FC){
        return FC.fitnessIndividual(this);                                           //DO SHIT!
    }

    Individual recombinateIndividual(Individual ind, double recombinationUmbral){
        return ind;                                             //DO MORE SHIT!
    }

    void mutateIndividual(double mutationRatio){
                                                                //AND MORE SHIT MOTHAFUCKA!
    }

}
