// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.*;

/**
 * This class implements a simple guessing game where the user is asked to guess the sum of two numbers.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-10-10T12:40:00Z
 */
public class GuessGame {
    private static Scanner input = new Scanner(System.in);
    private static boolean valid;
    private static String inp;

    /**
     * Main method to run the guessing game.
     *
     * @param args Command line arguments (not used in this program).
     * @since 2022-10-10T12:40:00Z
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the guessing game!");
        double num1 = inpDouble();
        double num2 = inpDouble();
        double sum = num1 + num2;
        double guess;
        for (int i = 0; i < 3; i++) {
            guess = inpDouble();
            if (guess == sum) {
                System.out.println("\nCorrect!");
                break;
            } else if (guess != sum && i == 2) System.out.println("\nYou have used up all your guesses, and guessed wrong. Try again next time!\nThe answer was " + sum);
            else if (guess != sum) System.out.println("\nWrong!");
            else throw new UnknownError("There was an error in the program");
        }
        System.out.println("\nThanks for playing!");
    }

    /**
     * Verifies the inputted string is a valid double. This method will return `true` if the input
     * is not a double, and `false` if the input is a valid double.
     *
     * @param input The string inputted by the user.
     * @return A boolean value depending on whether or not the inputted string is a double.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-10T12:40:00Z
     */
    private static boolean isNotDouble(String input) {
        try {
            Double.parseDouble(input);
            return false;
        } catch (Exception ignored) {return true;}
    }

    /**
     * Asks the user for input of a String, then verifies that it is a valid number. If the user
     * input is not a valid number, the method will continue to prompt the user for input until
     * a valid number is provided.
     *
     * @return A positive double value that is larger than 0.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:16:16Z
     */
    private static double inpDouble() {
        valid = false;
        do {
            System.out.print("\nEnter number: ");
            inp = input.nextLine();
            if (isNotDouble(inp)) System.out.println("\nERROR!\nInput not a number!");
            else valid = true;
        } while (!valid);
        return Double.parseDouble(inp);
    }
}
