import java.util.Arrays;

/**
 * This class represents the dice in Fantasy Flight Games' Star Wars Armada.
 */
public class Dice {

    /**
     * Representation Invariant:
     * 
     */

    private Side[] diceSidesArray;
    private String colour;

    /**
     * @param diceSidesArray
     */
    public Dice(Side[] diceSidesArray, String colour) {
        diceSidesArray = Arrays.copyOf(diceSidesArray, diceSidesArray.length);
        this.colour = colour;
    }

    /**
     * Returns the number of sides the dice has.
     * @return Returns the number of sides of the dice.
     */
    public int getNumberOfSides() {
        return diceSidesArray.length;
    }

    /**
     * Returns the side of the die based on a sideIndex (0 based).
     * @param sideIndex - The index of the side of the die you wish to return.
     * PRE: sideIndex must be >= 0 and < diceSidesArray.length.
     */
    public Side getSide(int sideIndex) {
        return diceSidesArray[sideIndex];
    }

    /**
     * Returns the colour of the die.
     */
    public String getColour() {
        return colour;
    }

}
