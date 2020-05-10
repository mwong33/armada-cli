/**
 * This class represents possible side of a die in Fantasy Flight Games' Star Wars Armada.
 */
public class Side {

    /**
     * Represenation Invariant:
     * sideCritCount, sideHitCount, and sideAccuracyCount must always be >= 0.
     */

    private int sideHitCount;
    private int sideCritCount;
    private int sideAccuracyCount;

    /**
    * Constructs a side of a Star Wars Armada Die.
    * @param hitCount - The number of hit icons on the side.
    * @param critCount - The number of critical icons on the side.
    * @param accuracyCount - The number of accuracy icons on the side.
    * PRE: critCOunt, hitCount and accuracyCount MUST be >= 0. 
    */
    public Side(int hitCount, int critCount, int accuracyCount) {
        this.sideHitCount = hitCount;
        this.sideCritCount = critCount;
        this.sideAccuracyCount = accuracyCount;
    }

    /**
    * Returns the number of hit icons on the side.
    * @return The number of hit icons on the side.
    */
    public int getSideHitCount() {
        return sideHitCount;
    }

    /**
    * Returns the number of critical icons on the side.
    * @return The number of critical icons on the side.
    */
    public int getSideCritCount() {
        return sideCritCount;
    }

    /**
    * Returns the number of accuracy icons on the side.
    * @return The number of accuracy icons on the side.
    */
    public int getSideAccuracyCount() {
        return sideAccuracyCount;
    }

    /**
     * Indicates whether two objects of the Side class are equal based on their
     * sideHitCount, sideCritCount and sideAccuracyCount.
     * @return true iff the two sides have the same sideHitCount, sideCritCount and sideAccuracyCount.
     */
    public boolean equals(Side aSide) {

        if (sideHitCount != aSide.sideHitCount) {
            return false;
        }

        if (sideCritCount != aSide.sideCritCount) {
            return false;
        }

        if (sideAccuracyCount != aSide.sideAccuracyCount) {
            return false;
        }

        return true;
    }

}