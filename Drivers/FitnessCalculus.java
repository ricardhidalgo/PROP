import Logic.Genetic.Individual;
import java.util.concurrent.ThreadLocalRandom;
//STUB SIMPLE
public class FitnessCalculus {
    public double fitnessIndividual(Individual ind) {
        return ThreadLocalRandom.current().nextDouble(0,100.0);
    }
}
