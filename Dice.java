import java.util.Arrays;

/**
 * This class represents the dice in Fantasy Flight Games' Star Wars Armada.
 */
public class Dice {

    /**
     * Representation Invariant:
     * critChance should be >= 0.0. diceSidesArray.length must be >= 1.
     */

    private Side[] diceSidesArray;
    private String colour;
    private double critChance;

    /**
     * Contructs a Dice.
     * @param diceSidesArray - An array of the Side class.
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
     * Overwritten method to determine if two Dice are equal. Dice are equal iff they have the same
     * colour and diceSidesArray.
     * @param obj - The other Dice that is to be compared
     * @return true iff the two Dice have the same colour and diecSidesArray.
     */
    @Override
    public boolean equals(Object obj) {

        Dice otherDice = (Dice) obj;
        
        if (!colour.equals(otherDice.colour)) {
            return false;
        }

        if (!Arrays.equals(diceSidesArray, otherDice.diceSidesArray)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + colour.hashCode();
        result = 31 * result + Arrays.hashCode(diceSidesArray);
        return result;
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
