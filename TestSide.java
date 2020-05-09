/**
 * Unit tests for Side.java
 */
public class TestSide {
    
    public static void main(String[] args) {

        int passCount = 0;
        int failCount = 0;

        // TEST ONE
        if (testSideHelper(1, 1, 2, 3)) {
            passCount++;
        } else {
            failCount++;
        }

        // TEST TWO
        if (testSideHelper(2, 1, 1, 1)) {
            passCount++;
        } else {
            failCount++;
        }

        // TEST THREE
        if (testSideHelper(3, 1, 0, 0)) {
            passCount++;
        } else {
            failCount++;
        }

        // TEST FOUR
        if (testSideHelper(4, 0, 1, 0)) {
            passCount++;
        } else {
            failCount++;
        }

        // TEST FIVE
        if (testSideHelper(5, 0, 0, 1)) {
            passCount++;
        } else {
            failCount++;
        }

        System.out.println("Ran " + (passCount + failCount) + " Tests. " + passCount + " Passed. " + failCount + " Failed.");

    }

    /**
     * Helper function for writing tests for Side.java.
     * @param testNumber - The Test Number of the test.
     * @param hitCount - The number of hits on the Side you are testing.
     * @param critCount - The number of crits on the Side you are testing.
     * @param accuracyCount - The number of accuracies on the Side you are testing.
     * @return - true iff the test passes and false if not.
     */
    private static boolean testSideHelper(int testNumber, int hitCount, int critCount, int accuracyCount) {

        System.out.println("--TEST " + testNumber + "--");

        System.out.println("Creating a Side with " +  hitCount + " Hit, " + critCount + " Crits, and " 
        + accuracyCount + " Accuracies");

        Side testSide = new Side(hitCount, critCount, accuracyCount);

        System.out.println("Expected number of Hits (" + hitCount + "): " + testSide.getSideHitCount());
        System.out.println("Expected number of Crits (" + critCount + "): " + testSide.getSideCritCount());
        System.out.println("Expected number of Accuracies (" + accuracyCount + "): " + testSide.getSideAccuracyCount());
        System.out.println();

        boolean result = true;

        if (hitCount != testSide.getSideHitCount()) { 
            result = false;
        } else if (critCount != testSide.getSideCritCount()) { 
            result = false;
        } else if (accuracyCount != testSide.getSideAccuracyCount()) { 
            result = false;
        }

        if (result) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        System.out.println();

        return result;

    }

}