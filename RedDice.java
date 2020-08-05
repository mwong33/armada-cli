/**
 * This class represents the red dice in Fantasy Flight Games' Star Wars Armada.
 */
public class RedDice extends Dice {

    /**
     * Representation Invariant:
     * critChance should be >= 0.0. diceSidesArray.length must be >= 1.
     */

    /**
     * Constructs a Red Dice.
    */
    public RedDice() {
        super(makeRedDieArrayHelper(), "red");
    }

    /**
     * Helper function for creating a red die array.
     * @return A Side array for the red die
     */
    private static Side[] makeRedDieArrayHelper() {

        Side[] redDiceArray = new Side[8];
        redDiceArray[0] = new Side(1, 0, 0);
        redDiceArray[1] = new Side(1, 0, 0);
        redDiceArray[2] = new Side(2, 0, 0);
        redDiceArray[3] = new Side(0, 1, 0);
        redDiceArray[4] = new Side(0, 1, 0);
        redDiceArray[5] = new Side(0, 0, 1);
        redDiceArray[6] = new Side(0, 0, 0);
        redDiceArray[7] = new Side(0, 0, 0);

        return redDiceArray;
    }
    
}