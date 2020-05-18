import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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

            Iterator<Map.Entry<Dice, Integer>> iter = dicePool.entrySet().iterator();
            
            while(iter.hasNext()) {

                Map.Entry<Dice, Integer> dieSet = iter.next();

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
     * Prints statistics of the simulation.
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
     * @return A TreeMap<String, Double> of the chance for each dice type to get 1 or more crits where the key
     * is the colour of each dice and it's corresponding chance as a double.
     */
    public TreeMap<String, Double> chanceToCrit() {
        
        TreeMap<String, Double> critDiceMap = new TreeMap<String, Double>();

        // Iterate through each dice colour in the dicePool
        Iterator<Map.Entry<Dice, Integer>> iter = dicePool.entrySet().iterator();

        while (iter.hasNext()) {

            Map.Entry<Dice, Integer> diceSet = iter.next();

            double dieChanceToNotCrit = 1 - diceSet.getKey().getCritChance();
            double diceSetChanceToCrit = 1 - (Math.pow(dieChanceToNotCrit, (double) diceSet.getValue()));

            critDiceMap.put(diceSet.getKey().getColour(), diceSetChanceToCrit);

        }

        return critDiceMap;
    }

    /**
     * Prints out the chance to crit with each colour in the dicePool.
     */
    public void displayChanceToCrit() {

        TreeMap<String, Double> critDiceMap = chanceToCrit();

        Iterator<Map.Entry<String, Double>> iter = critDiceMap.entrySet().iterator();

        while(iter.hasNext()) {

            Map.Entry<String, Double> dieCritChance = iter.next();

            System.out.println("Chance for a " + dieCritChance.getKey() + " crit: " + dieCritChance.getValue());
        }

    }

}