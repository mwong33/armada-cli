/**
 * This class represents the black dice in Fantasy Flight Games' Star Wars Armada.
 */
public class BlackDice extends Dice {

    /**
     * Representation Invariant:
     * critChance should be >= 0.0. diceSidesArray.length must be >= 1.
     */

    /**
     * Constructs a Black Dice.
    */
    public BlackDice() {
        super(makeBlackDieArrayHelper(), "black");
    }

    /**
     * Helper function for creating a black die array.
     * @return A Side array for the black die
     */
    private static Side[] makeBlackDieArrayHelper() {

        Side[] blackDiceArray = new Side[8];
        blackDiceArray[0] = new Side(1, 0, 0);
        blackDiceArray[1] = new Side(1, 0, 0);
        blackDiceArray[2] = new Side(1, 0, 0);
        blackDiceArray[3] = new Side(1, 0, 0);
        blackDiceArray[4] = new Side(1, 1, 0);
        blackDiceArray[5] = new Side(1, 1, 0);
        blackDiceArray[6] = new Side(0, 0, 0);
        blackDiceArray[7] = new Side(0, 0, 0);

        return blackDiceArray;

    }
    
}