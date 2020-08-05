/**
 * Unit tests for DiceSim.java
 */
public class TestDiceSim {
    
    public static void main(String[] args) {

        // Create a Kuat Firing Arc
        DiceSim kuatFrontArc = new DiceSim(makeStandardFiringArc(3, 2, 3));
        System.out.println("Creating a Kuat Front Arc Dice Sim!");
        System.out.println();

        // Print the Stats
        System.out.println("Printing some initial stats: ");
        kuatFrontArc.printStats();
        System.out.println();

        // Calculate the chance to crit
        kuatFrontArc.displayChanceToCrit();
        System.out.println();

        System.out.println("Expected Black crit: 0.578125");
        System.out.println("Expected Blue crit: 0.4375");
        System.out.println("Expected Red crit: 0.578125");
        System.out.println();

        // Print the Stats after 1000 rolls
        kuatFrontArc.simulate(1000);
        kuatFrontArc.printStats();
        System.out.println();

        // Reset the Simulation
        System.out.println("Reseting the Simulation: ");
        kuatFrontArc.reset();
        kuatFrontArc.printStats();
        System.out.println();

    }

    /**
     * Helper function for creating a Dice array with either standard Blue, Red or Black dice.
     * @param redCount - The number of red dice in the returned Dice array.
     * @param blueCount - The number of blue dice in the returned Dice array.
     * @param blackCount - The number of black dice int he returned Dice array.
     * @return A Dice array with the given number of red, blue and black dice according to the provided parameters.
     */
    public static Dice[] makeStandardFiringArc(int redCount, int blueCount, int blackCount) {

        Dice[] theDiceArray = new Dice[redCount + blueCount + blackCount];
        int index = 0;

        // Add the red dice
        while (index < redCount) {
            theDiceArray[index] = new RedDice();
            index++;
        }

        // Add the blue dice
        int blueUpperLimit = index + blueCount;

        while(index < blueUpperLimit) {
            theDiceArray[index] = new BlueDice();
            index++;
        }

        // Add the black dice
        int blackUpperLimit = index + blackCount;

        while(index < blackUpperLimit) {
            theDiceArray[index] = new BlackDice();
            index++;
        }

        return theDiceArray;

    }

}