
/**
 * Unit tests for Side.java
 */
public class SideTest {
    
    public static void main(String[] args) {

        // TEST ONE
        sideTestHelper(1, 1, 2, 3);

        // TEST TWO
        sideTestHelper(2, 1, 1, 1);

        // TEST THREE
        sideTestHelper(3, 1, 0, 0);

        // TEST FOUR
        sideTestHelper(4, 0, 1, 0);

        // TEST FIVE
        sideTestHelper(5, 0, 0, 1);
    }

    private static void sideTestHelper(int testNumber, int hitCount, int critCount, int accuracyCount) {

        System.out.println("--TEST " + testNumber + "--");

        System.out.println("Creating a Side with " +  hitCount + " Hit, " + critCount + " Crits, and " 
        + accuracyCount + " Accuracies");

        Side testSide = new Side(hitCount, critCount, accuracyCount);

        System.out.println("Expected number of Hits (" + hitCount + "): " + testSide.getSideHitCount());
        System.out.println("Expected number of Crits (" + critCount + "): " + testSide.getSideCritCount());
        System.out.println("Expected number of Accuracies (" + accuracyCount + "): " + testSide.getSideAccuracyCount());
        System.out.println();

    }

}