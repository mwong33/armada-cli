import java.util.Scanner;

// The main class that runs this program
public class ArmadaDiceSimulator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Introduction prompt
        System.out.println("Welcome to Armada Dice Simulator!");
        System.out.println("Let's create your dice pool");
        
        // Setting up the dice pool
        System.out.println("How many RED dice are in your pool? Enter as an Integer");

        int redDiceCount = 0;
        if (in.hasNextInt()) {
            redDiceCount = in.nextInt();
        }

        System.out.println("How many BLUE dice are in your pool? Enter as an Integer");

        int blueDiceCount = 0;
        if (in.hasNextInt()) {
            blueDiceCount = in.nextInt();
        }

        System.out.println("How many BLACK dice are in your pool? Enter as an Integer");

        int blackDiceCount = 0;
        if (in.hasNextInt()) {
            blackDiceCount = in.nextInt();
        }

        // Create the Dice Pool
       
        in.close();
        
    }

    /**
     * Helper function for creating a Dice array with either standard Blue, Red or Black dice.
     * @param redCount - The number of red dice in the returned Dice array.
     * @param blueCount - The number of blue dice in the returned Dice array.
     * @param blackCount - The number of black dice int he returned Dice array.
     * @return A Dice array with the given number of red, blue and black dice according to the provided parameters.
     */
    private static Dice[] createDicePool(int redDiceCount, int blueDiceCount, int blackDiceCount) {
        
        Dice[] theDiceArray = new Dice[redDiceCount + blueDiceCount + blackDiceCount];

        RedDice redDice = new RedDice();
        BlueDice blueDice = new BlueDice();
        BlackDice blackDice = new BlackDice();

        int index = 0;

        // Add the red dice
        while (index < redDiceCount) {
            theDiceArray[index] = redDice;
            index++;
        }

        // Add the blue dice
        int blueUpperLimit = index + blueDiceCount;

        while(index < blueUpperLimit) {
            theDiceArray[index] = blueDice;
            index++;
        }

        // Add the black dice
        int blackUpperLimit = index + blackDiceCount;

        while(index < blackUpperLimit) {
            theDiceArray[index] = blackDice;
            index++;
        }

        return theDiceArray;

    }

}