package Logic.Genetic;

import Logic.Combination;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author albert.ortiz
 */

public class Individual {
    private static int defaultGenNum = 4;
    private Byte genes[];
    private double fitness = 0.0;

    public Individual(){
        genes = new Byte[defaultGenNum];
    }

    public Individual(ArrayList<Byte> arrb){
        genes = new Byte[defaultGenNum];
        for(int i=0; i<defaultGenNum; i++) this.genes[i] = arrb.get(i);
    }

    public static void setDefaultGenNum(int value){
        defaultGenNum = value;
    }

    public void copy(Individual ind){
        for(int i=0; i<ind.numGenes(); i++)  this.genes[i] = ind.getGen(i);
    }

    public int numGenes(){ return genes.length; }

    public Combination toCombination(){
        Combination c = new Combination();
        ArrayList<Byte> arrB = new ArrayList<Byte>();
        for(int i=0; i<numGenes(); i++) arrB.add(getGen(i));
        c.setCombination(arrB);
        return c;
    }

    public byte getGen(int pos){ return genes[pos]; }

    public void setGen(int pos, byte gen){ genes[pos] = gen; }

    public void initializeIndividual(){
        for(int i=0; i<genes.length; i++)
            genes[i]= (byte)ThreadLocalRandom.current().nextInt(0, 5);

    }

    public double fitnessIndividual(FitnessCalculus FC){
        fitness = FC.fitnessIndividual(this);
        return fitness;

    }

    public Individual recombinateIndividual(Individual ind, double recombinationUmbral){
        Individual indu = new Individual();
        indu.copy(this);
        for(int i=0; i<genes.length; i++)
            if(ThreadLocalRandom.current().nextDouble(0,1.0) < recombinationUmbral) indu.setGen(i,ind.getGen(i));
        return indu;
    }

    public void mutateIndividual(double mutationRatio){
        if(ThreadLocalRandom.current().nextDouble(0,1.0) > mutationRatio){
            int i = ThreadLocalRandom.current().nextInt(0,this.genes.length);
            genes[i] = (byte)ThreadLocalRandom.current().nextInt(0,5);
        }
    }

    public void permutateIndividual(double permutationRatio){
            if (ThreadLocalRandom.current().nextDouble(0, 1.0) < permutationRatio){
                int a;
                a = ThreadLocalRandom.current().nextInt(0,genes.length);
                byte s = genes[a];
                int b = a;
                while(b==a) a = ThreadLocalRandom.current().nextInt(0, genes.length);
                genes[b] = genes[a];
                genes[a] = s;
            }
    }

    public void invertIndividual(){
        int i0 = ThreadLocalRandom.current().nextInt(0,numGenes());
        int i1 = ThreadLocalRandom.current().nextInt(0,numGenes());
        while(i1 == i0) i1 = ThreadLocalRandom.current().nextInt(0,numGenes());
        if(i1<i0) {
            int aux = i0;
            i0 = i1;
            i1 = aux;
        }
        for(int i=0; i<=(i1-i0)/2; i++){
            byte aux = genes[i0+i];
            genes[i0+i] = genes[i1-i];
            genes[i1-i] = aux;
        }
    }

    public void printIndividual(){
        System.out.print("[");
        for(int i=0; i<genes.length; i++)
            System.out.print(genes[i]+", ");
        System.out.println("]");
    }

    @Override
    public int hashCode() {
        int res =0;
        for(int i=0; i<numGenes(); i++) res += getGen(i)*i;
        return res;
    }

    @Override
    public boolean equals(Object ob) {
        Individual that = (Individual) ob;
        for(int i=0; i<that.numGenes(); i++)
            if(this.getGen(i) != that.getGen(i)) return false;

        return true;
    }


}
