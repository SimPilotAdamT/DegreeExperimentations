// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.*;

/**
 * This class provides a simple application for calculating the final price of a product after tax.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-11-11T17:16:16Z
 */
public class FindCostApp {
    private static Scanner input = new Scanner(System.in);
    private static String inp;
    private static boolean valid;

    /**
     * The main method of the class. It uses the other methods to get the initial price and tax rate
     * from the user, calculates the final price, and displays the result to the user.
     *
     * @param args The command line arguments passed to the program.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T17:16:16Z
     */
    public static void main(String[ ] args ) {
        displayTitle();
        displayPrice(calculateFinalPrice(setPrice(), setTax()));
    }

    /**
     * Displays the title of the program to the user.
     *
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T17:16:16Z
     */
    private static void displayTitle() {System.out.println("*** Product Price Check ***");}

    /**
     * Prompts the user to enter the initial price of the product, and returns the entered value.
     *
     * @return A positive double value representing the initial price of the product.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T17:16:16Z
     */
    private static double setPrice() {
        System.out.print("\nEnter initial price in £");
        return inpDouble();
    }

    /**
     * Prompts the user to enter the tax rate for the product, and returns the entered value.
     *
     * @return A positive double value representing the tax rate for the product.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T17:16:16Z
     */
    private static double setTax() {
        System.out.print("\nEnter tax rate in %");
        return inpDouble();
    }

    /**
     * Calculates the final price of the product after tax.
     *
     * @param price The initial price of the product.
     * @param tax The tax rate for the product.
     * @return A double value representing the final price of the product after tax.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T17:16:16Z
     */
    private static double calculateFinalPrice(double price, double tax) {return price * (1 + tax/100);}

    /**
    * Prints the final price
    * @param price The price to be printed
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-11-11T17:16:16Z
    */
    private static void displayPrice(double price) {System.out.println("\nCost after tax = £" + String.format("%.2f", price));}

    /**
    * Verifies the inputted string is a valid double.
    * @param input The string inputted by the user.
    * @return A boolean value depending on whether or not the inputted string is a double.
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-10-10T12:40:00Z
    */
    private static boolean isNotDouble(String input){
        try {
            Double.parseDouble(input);
            return false;
        } catch (NumberFormatException ignored) {return true;}
    }

    /**
    * Asks the user for input of a String, then verifies that it is a valid number.
    * @return A positive double value that is larger than 0.
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-11-11T17:16:16Z
    */
    private static double inpDouble() {
        valid = false;
        do {
            inp = input.nextLine();
            if (isNotDouble(inp)) System.out.println("\nERROR!\nInput not a number!");
            else valid = true;
        } while (!valid);
        return Double.parseDouble(inp);
    }
}
