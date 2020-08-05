/**
 * This class represents the blue dice in Fantasy Flight Games' Star Wars Armada.
 */
public class BlueDice extends Dice {

    /**
     * Representation Invariant:
     * critChance should be >= 0.0. diceSidesArray.length must be >= 1.
     */

    /**
     * Constructs a Blue Dice.
    */
    public BlueDice() {
        super(makeBlueDieArrayHelper(), "blue");
    }

    /**
     * Helper function for creating a blue die array.
     * @return A Side array for the blue die
     */
    public static Side[] makeBlueDieArrayHelper() {

        Side[] blueDiceArray = new Side[8];
        blueDiceArray[0] = new Side(1, 0, 0);
        blueDiceArray[1] = new Side(1, 0, 0);
        blueDiceArray[2] = new Side(1, 0, 0);
        blueDiceArray[3] = new Side(1, 0, 0);
        blueDiceArray[4] = new Side(0, 1, 0);
        blueDiceArray[5] = new Side(0, 1, 0);
        blueDiceArray[6] = new Side(0, 0, 1);
        blueDiceArray[7] = new Side(0, 0, 1);

        return blueDiceArray;

    }
    
}