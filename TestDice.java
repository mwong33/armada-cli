/**
 * Unit tests for Dice.java
 */
public class TestDice {
    
    public static void main(String[] args) {

        int passCount = 0;
        int failCount = 0;

        // TEST ONE - RED DICE
        if (testDiceHelper(1, makeRedDieArrayHelper(), "red")) {
            passCount++;
        } else {
            failCount++;
        }

        // TEST TWO - BLUE DICE
        if (testDiceHelper(2, makeBlueDieArrayHelper(), "blue")) {
            passCount++;
        } else {
            failCount++;
        }

        // TEST THREE - BLACK DICE
        if (testDiceHelper(3, makeBlackDieArrayHelper(), "black")) {
            passCount++;
        } else {
            failCount++;
        }

        System.out.println("Ran " + (passCount + failCount) + " Tests. " + passCount + " Passed. " + failCount + " Failed.");

    }

    /**
     * Helper function for writing tests for Dice.java.
     * @param testNumber - The Test Number to the test.
     * @param testDiceSides - The array of Side 
     * @param testColour - 
     * @return - true iff the test passes and false if not.
     */
    public static boolean testDiceHelper(int testNumber, Side[] testDiceSides, String testColour) {

        System.out.println("--TEST " + testNumber + "--");

        System.out.println("Creating a test die.");

        Dice testDice = new Dice(testDiceSides, testColour);

        boolean result = true;

        System.out.println("Expected colour (" + testColour + "): " + testDice.getColour());
        System.out.println("Expected number of sides (" + testDiceSides.length + "): " + testDice.getNumberOfSides());

        // Test the sides of the dice
        for (int i = 0; i < testDiceSides.length; i++) {

            if (!testDiceSides[i].equals(testDice.getSide(i))) {
                System.out.println("Side at index " + i + " is NOT equal!");
                result = false;
            } else {
                System.out.println("Side at index " + i + " is equal!");
            }

        }

        if (testColour != testDice.getColour()) {
            result = false;
        } else if (testDiceSides.length != testDice.getNumberOfSides()) {
            result = false;
        }

        return result;
    }

    /**
     * Helper function for creating a red die array.
     * @return A Side array for the red die
     */
    public static Side[] makeRedDieArrayHelper() {

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

    /**
     * Helper function for creating a black die array.
     * @return A Side array for the black die
     */
    public static Side[] makeBlackDieArrayHelper() {

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