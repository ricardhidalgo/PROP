package Logic.Genetic;

import java.util.concurrent.ThreadLocalRandom;
/**
 * @author albert.ortiz
 */

public class Individual {
    private int defaultGenNum = 4;
    private byte genes[];
    private double fitness = 0.0;

    public Individual(){
        genes = new byte[defaultGenNum];
    }

    public void copy(Individual ind){
        for(int i=0; i<ind.numGenes(); i++)  genes[i] = ind.getGen(i);
    }

    public int numGenes(){ return genes.length; }

    public byte getGen(int pos){ return genes[pos]; }

    public void setGen(int pos, byte gen){ genes[pos] = gen; }

    public void initializeIndividual(){
        for(int i=0; i<genes.length; i++){
            genes[i]= (byte)ThreadLocalRandom.current().nextInt(50, 58);

        }

    }

    public double fitnessIndividual(FitnessCalculus FC){
        fitness = FC.fitnessIndividual(this);
        return fitness;

    }

    Individual recombinateIndividual(Individual ind, double recombinationUmbral){
        Individual indu = new Individual();
        indu.copy(this);
        for(int i=0; i<genes.length; i++)
            if(ThreadLocalRandom.current().nextDouble(0,1.0) <= recombinationUmbral) indu.setGen(i,ind.getGen(i));
        return indu;

    }

    public void mutateIndividual(double mutationRatio){
        for(int i=0; i<genes.length; i++)
            if(ThreadLocalRandom.current().nextDouble(0,1.0) <= mutationRatio) genes[i] = (byte)ThreadLocalRandom.current().nextInt(50,58);

    }

    public void permutateIndividual(double permutationRatio){
        for(int i=0; i<genes.length; i++) {
            if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= permutationRatio){
                byte s = genes[i];
                int a = i;
                while(i==a) a = ThreadLocalRandom.current().nextInt(0, genes.length);
                genes[i] = genes[a];
                genes[a] = s;
            }
        }
    }

    public void invertIndividual(){
        int i0 = ThreadLocalRandom.current().nextInt(0,numGenes());
        int i1 = ThreadLocalRandom.current().nextInt(0,numGenes());
        if(i1<i0) {
            int aux = i0;
            i0 = i1;
            i1 = aux;
        }
            for(int i=i0; i<=(i1-i0)/2; i++){
                byte aux = genes[i];
                genes[i] = genes[i1-i];
                genes[i1-i] = aux;
            }

    }

    @Override
    public boolean equals(Object ob) {
        Individual that = (Individual) ob;
        return this.genes.equals(that.genes);
    }

    @Override
    public int hashCode() {
        return genes.toString().hashCode();
    }



}
