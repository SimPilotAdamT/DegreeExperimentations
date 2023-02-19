// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Scanner;

/**
 * The main class for the CompareApp program.
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-10-25T13:22:37Z
 */
public class CompareApp {
    private static Scanner input = new Scanner(System.in);

    /**
     * The main method for the CompareApp program.
     * Prompts the user for two integer inputs, then calls the comparison method in the Maths class to compare the numbers.
     * @param args The command line arguments (not used in this program).
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:22:37Z
     */
    public static void main(String[] args){System.out.println(Maths.comparison(getValidIntegerInput(), getValidIntegerInput()) + "\nEND OF PROGRAM");}

    /**
     * Asks the user for input of a String, then verifies that it is a valid integer using a regular expression.
     * @return A valid integer value.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:22:37Z
     */
    private static int getValidIntegerInput() {
        do {
            System.out.print("\nEnter an integer: ");
            String inputString = input.nextLine();
            if (inputString.matches("^\\d+$")) return Integer.parseInt(inputString);
            else System.out.println("\nERROR!\nInput not an integer!");
        } while (true);
    }
}

/**
 * A class containing mathematical methods.
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-10-25T13:22:37Z
 */
class Maths {
    /**
     * Compares two or more integers and determines which is the greatest.
     * @param numbers The integers to compare.
     * @return A string indicating the greatest number, or that the numbers are all equal.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:22:37Z
     */
    public static String comparison(int... numbers) {
        int greatest = Integer.MIN_VALUE;  // The lowest possible integer value
        for (int num : numbers) {if (num > greatest) greatest = num;}
        if (greatest == Integer.MIN_VALUE) return "\nAll numbers are equal or zero";
        else return "\nThe greatest number is: " + greatest;
    }
}
