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
    private double critChance;

    /**
     * @param diceSidesArray
     */
    public Dice(Side[] diceSidesArray, String colour) {
        this.diceSidesArray = Arrays.copyOf(diceSidesArray, diceSidesArray.length);
        this.colour = colour;

        int critCount = 0;

        for (int i = 0; i < diceSidesArray.length; i++) {
            if (diceSidesArray[i].getSideCritCount() > 0) {
                critCount++;
            }
        }

        critChance = (double) critCount / diceSidesArray.length;

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

    /**
     * Returns the percentage chance that this dice will crit (in the form of a double).
     * @return Returns the percentage chance that this dice will crit (in the form of a double).
     */
    public double getCritChance() {
        return critChance;
    }

}
