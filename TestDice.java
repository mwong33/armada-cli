public class TestDice {
    
    public static void main(String[] args) {

        

    }

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
                System.out.println("Side at index " + i + "do NOT equal!");
                result = false;
            } else {
                System.out.println("Side at index " + i + "equal!");
            }

        }

        if (testColour != testDice.getColour()) {
            result = false;
        } else if (testDiceSides.length != testDice.getNumberOfSides()) {
            result = false;
        }

        return result;
    }

}