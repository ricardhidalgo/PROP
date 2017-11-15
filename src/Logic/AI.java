package Logic;

/**
 * @author ricard.hidalgo
 */

public interface AI {


    Combination generateSecret();

    Combination generateFirstCombination();

    Combination generateNextCombination(Play result);
}
