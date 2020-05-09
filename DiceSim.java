import java.util.Random;

/**
 * This class represents rolling a pool of Dice.
 */
public class DiceSim {
    /**
     * Represenation Invariant:
     * hitCount, critCount and accuracyCount must always be >= 0.
     */

    private Dice[] dicePool;
    private int hitCountSum;
    private int critCountSum;
    private int accuracyCountSum;
    public int simCount;
    private Random rng;

    /**
    * Constructs a DiceSim object, with the pool of dice represented as an array of Dice.
    * @param dicePool - An array of Dice.
    */
    public DiceSim(Dice[] dicePool) {
        this.dicePool = dicePool;
        hitCountSum = 0;
        critCountSum = 0;
        accuracyCountSum = 0;
        simCount = 0;
        rng = new Random();
    }

    /**
     * Simulates the roll of a dice pool.
     * @param simCount - The number of times you wish to roll your dice pool.
     */
    public void simulate(int simCount) {

        for (int roll = 1; roll <= simCount; roll++) {

            for(int dieNumber = 1; dieNumber <= dicePool.length; dieNumber++) {

                int dieResult = rng.nextInt(dicePool[dieNumber].getNumberOfSides());

                hitCountSum += dicePool[dieNumber].getSide(dieResult).getSideHitCount();
                critCountSum += dicePool[dieNumber].getSide(dieResult).getSideCritCount();
                accuracyCountSum += dicePool[dieNumber].getSide(dieResult).getSideAccuracyCount();

            }
            
            simCount++;

        }

    }

    /**
    * Resets the diceSim stats to 0.
    */
    public void reset() {
        hitCountSum = 0;
        critCountSum = 0;
        accuracyCountSum = 0;
        simCount = 0;
    }

    /**
     * With the given dicePool, calculates the chance to get 1 or more crits for each die colour.
     */
    public void chanceToCrit() {
        
    }

}