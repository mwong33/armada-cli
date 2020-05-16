import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * This class represents rolling a pool of Dice.
 */
public class DiceSim {
    /**
     * Represenation Invariant:
     * hitCount, critCount and accuracyCount must always be >= 0.
     */

    private HashMap<Dice, Integer> dicePool;
    private int hitCountSum;
    private int critCountSum;
    private int accuracyCountSum;
    public int rollCount;
    private Random rng;

    /**
    * Constructs a DiceSim object, with the pool of dice represented as an array of Dice.
    * @param dicePool - An array of Dice.
    */
    public DiceSim(Dice[] dicePool) {
        
        for (int i = 0; i < dicePool.length; i++) {
            if (this.dicePool.containsKey(dicePool[i])) {
                this.dicePool.put(dicePool[i], this.dicePool.get(dicePool[i]) + 1);
            } else {
                this.dicePool.put(dicePool[i], 1);
            }
        }

        hitCountSum = 0;
        critCountSum = 0;
        accuracyCountSum = 0;
        rollCount = 0;
        rng = new Random();
    }

    /**
     * Simulates the roll of a dice pool.
     * @param simCount - The number of times you wish to roll your dice pool.
     */
    public void simulate(int simCount) {

        for (int roll = 1; roll <= simCount; roll++) {

            Iterator<HashMap.Entry<Dice, Integer>> iter = dicePool.entrySet().iterator();
            
            while(iter.hasNext()) {

                HashMap.Entry<Dice, Integer> dieSet = iter.next();

                for(int dieNumber = 0; dieNumber < dieSet.getValue(); dieNumber++) {

                    //Roll the die
                    int dieResult = rng.nextInt(dieSet.getKey().getNumberOfSides());

                    hitCountSum += dieSet.getKey().getSide(dieResult).getSideHitCount();
                    critCountSum += dieSet.getKey().getSide(dieResult).getSideCritCount();
                    accuracyCountSum += dieSet.getKey().getSide(dieResult).getSideAccuracyCount();

                }

            }
            
            rollCount++;

        }

    }

    /**
    * Resets the diceSim stats to 0.
    */
    public void reset() {
        hitCountSum = 0;
        critCountSum = 0;
        accuracyCountSum = 0;
        rollCount = 0;
    }

    /**
     * 
     */
    public void printStats() {
        System.out.println("Number of Rolls: " + rollCount);
        System.out.println("Number of Hits: " + hitCountSum);
        System.out.println("Number of Crits: " + critCountSum);
        System.out.println("Number of Accuracies: " + accuracyCountSum);

        double averageDamage = ((double) hitCountSum + critCountSum) / rollCount;
        double averageAccuracy = ((double) accuracyCountSum) / rollCount;

        System.out.println("Average Damage: " + averageDamage);
        System.out.println("Average number of Accuracies: " + averageAccuracy);
    }

    /**
     * With the given dicePool, calculates the chance to get 1 or more crits for each die colour and returns
     * this data as a TreeMap<String, Double>.
     */
    public TreeMap<String, Integer> chanceToCrit() {
        TreeMap<String, Integer> pass = new TreeMap<String, Integer>();
        return pass;
    }

}