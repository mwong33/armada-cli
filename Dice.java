import java.util.Arrays;
import java.util.Random;

/**
 * This class represents the dice in Fantasy Flight Games' Star Wars Armada.
 */
public class Dice {

    /**
     * Representation Invariant.
     */

    private Random randomNumberGenerator;
    private Side[] diceSidesArray;
    private int simulationCount;
    private int hitCount;
    private int critCount;
    private int accuracyCount;

    /**
     * @param diceSidesArray
     */
    public Dice(Side[] diceSidesArray) {
        diceSidesArray = Arrays.copyOf(diceSidesArray, diceSidesArray.length);
        randomNumberGenerator = new Random();
        simulationCount = 0;
        hitCount = 0;
        critCount = 0;
        accuracyCount = 0;
    }
    
    /**
     * 
     * @param simCount
     */
    public void roll(int simCount) {
        for (int i = 0; i < simCount; i++) {

            int rollNumber = randomNumberGenerator.nextInt(diceSidesArray.length);
            
            hitCount += diceSidesArray[rollNumber].getSideHitCount();
            critCount += diceSidesArray[rollNumber].getSideCritCount();
            accuracyCount += diceSidesArray[rollNumber].getSideAccuracyCount();

            simulationCount++;

        }
    }

    /**
     * 
     */
    public void statistics() {
        int averageDamage = (hitCount + critCount) / simulationCount;
        int averageAccuracyCount;
        int chanceToCrit;
    }

    /**
     * 
     */
    public void reset() {
        simulationCount = 0;
        hitCount = 0;
        critCount = 0;
        accuracyCount = 0;
    }

}

/**
 * This class represents possible side of a die in Fantasy Flight Games' Star Wars Armada.
 */
class Side {

    /**
     * Represenation Invariant
     * sideCritCount, sideHitCount, and sideAccuracyCount must always be >= 0.
     */

    private int sideCritCount;
    private int sideHitCount;
    private int sideAccuracyCount;

    /**
    * Constructs a side of a Star Wars Armada Die.
    * @param critCount - The number of critical icons on the side.
    * @param hitCount - The number of hit icons on the side.
    * @param accuracyCount - The number of accuracy icons on the side.
    * PRE: critCOunt, hitCount and accuracyCount MUST be >= 0. 
    */
    public Side(int critCount, int hitCount, int accuracyCount) {
        this.sideCritCount = critCount;
        this.sideHitCount = hitCount;
        this.sideAccuracyCount = accuracyCount;
    }

    /**
    * Returns the number of critical icons on the side.
    * @return The number of critical icons on the side.
    */
    public int getSideCritCount() {
        return sideCritCount;
    }

    /**
    * Returns the number of hit icons on the side.
    * @return The number of hit icons on the side.
    */
    public int getSideHitCount() {
        return sideHitCount;
    }

    /**
    * Returns the number of accuracy icons on the side.
    * @return The number of accuracy icons on the side.
    */
    public int getSideAccuracyCount() {
        return sideAccuracyCount;
    }

}
