/**
 * Unit tests for DiceSim.java
 */
public class TestDiceSim {
    
    public static void main(String[] args) {

        // Create a Kuat Firing Arc
        DiceSim kuatFrontArc = new DiceSim(makeStandardFiringArc(3, 2, 3));
        System.out.println("Creating a Kuat Front Arc Dice Sim!");

        // Print the Stats
        System.out.println("Printing some initial stats: ");
        kuatFrontArc.printStats();

        // Calculate the chance to crit
        


    }

    /**
     * Helper function for creating a Dice array with either standard Blue, Red or Black dice.
     * @param redCount - The number of red dice in the returned Dice array.
     * @param blueCount - The number of blue dice in the returned Dice array.
     * @param blackCount - The number of black dice int he returned Dice array.
     * @return A Dice array with the given number of red, blue and black dice according to the provided parameters.
     */
    public static Dice[] makeStandardFiringArc(int redCount, int blueCount, int blackCount) {

        Dice redDie = new Dice(makeRedDieArrayHelper(), "red");
        Dice blueDie = new Dice(makeBlueDieArrayHelper(), "blue");
        Dice blackDie = new Dice(makeBlackDieArrayHelper(), "black");

        Dice[] theDiceArray = new Dice[redCount + blueCount + blackCount];

        int index = 0;

        // Add the red dice
        while (index < redCount) {
            theDiceArray[index] = redDie;
            index++;
        }

        // Add the blue dice
        int blueUpperLimit = index + blueCount;

        while(index < blueUpperLimit) {
            theDiceArray[index] = blueDie;
            index++;
        }

        // Add the black dice
        int blackUpperLimit = index + blackCount;

        while(index < blackUpperLimit) {
            theDiceArray[index] = blackDie;
            index++;
        }

        return theDiceArray;

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