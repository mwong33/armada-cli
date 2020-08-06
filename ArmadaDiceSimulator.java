import java.util.Scanner;

// The main class that runs this program
public class ArmadaDiceSimulator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Introduction prompt
        System.out.println("Welcome to Armada Dice Simulator!");
        System.out.println("Let's create your dice pool");
        System.out.println();

        // Setting up the dice pool
        System.out.println("How many RED dice are in your pool? Enter as an Integer");

        int redDiceCount = 0;
        if (in.hasNextInt()) {
            redDiceCount = in.nextInt();
        }

        System.out.println();
        System.out.println("How many BLUE dice are in your pool? Enter as an Integer");

        int blueDiceCount = 0;
        if (in.hasNextInt()) {
            blueDiceCount = in.nextInt();
        }

        System.out.println();
        System.out.println("How many BLACK dice are in your pool? Enter as an Integer");

        int blackDiceCount = 0;
        if (in.hasNextInt()) {
            blackDiceCount = in.nextInt();
        }

        // Create the Dice Pool
        Dice[] dicePoolArray = createDicePoolArray(redDiceCount, blueDiceCount, blackDiceCount);

        DiceSim theDiceSim = new DiceSim(dicePoolArray);

        // Give Crit Stats
        System.out.println();
        System.out.println("You created a dice pool with " + redDiceCount + " red die, " + blueDiceCount + " blue die, and " + blackDiceCount + " black dice");
        System.out.println();
        System.out.println("Here are the chance to crit stats of your dice pool: ");
        theDiceSim.displayChanceToCrit();

        // Give the instructions to simulate and run the simulation
        boolean continueSim = true;

        while (continueSim) {
            System.out.println();
            System.out.println("Enter an Integer to simulate your dice pool");
            System.out.println("Quit the simulation at any time by typing 'quit'");
            System.out.println("To reset the simulation type 'reset'");
            System.out.println();
            
            if (in.hasNextInt()) {
                int simCount = in.nextInt();
                System.out.println();
                System.out.println("Simulation Results:");
                theDiceSim.simulate(simCount);
                theDiceSim.printStats();
            } else if (in.hasNext()) {
                String command = in.next();
                if (command.equals("quit")) {
                    continueSim = false;
                } else if (command.equals("reset")) {
                    theDiceSim.reset();
                    System.out.println();
                    System.out.println("Simulation has been reset:");
                    theDiceSim.printStats();
                }
            }
        }

        in.close();
        
    }

    /**
     * Helper function for creating a Dice array with either standard Blue, Red or Black dice.
     * @param redCount - The number of red dice in the returned Dice array.
     * @param blueCount - The number of blue dice in the returned Dice array.
     * @param blackCount - The number of black dice int he returned Dice array.
     * @return A Dice array with the given number of red, blue and black dice according to the provided parameters.
     */
    private static Dice[] createDicePoolArray(int redDiceCount, int blueDiceCount, int blackDiceCount) {
        
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