// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.*;

/**
 * This class contains the main method for the conversion app, as well as helper methods for user input and verification.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-10-25T13:20:38Z
 */
public class ConversionApp {

    /**
     * Scanner used for user input.
     *
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:20:38Z
     */
    private static Scanner input = new Scanner(System.in);

    /**
     * Main method for the conversion app.
     *
     * @param args command line arguments
     *
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:20:38Z
     */
    public static void main(String[] args){
        double weightKg = inpDouble();
        if (weightKg >= 0) {
            String weightLbs = Maths.kg2lbs(weightKg);
            System.out.println(weightLbs);
            System.out.println("END OF PROGRAM");
        } else System.out.println("Invalid weight: " + weightKg);
    }

    /**
     * Verifies that the input is a valid double.
     *
     * @param input the input to verify
     * @return true if the input is not a double, false if it is a double
     *
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:20:38Z
     */
    private static boolean isNotDouble(String input){
        try {
            Double.parseDouble(input);
            return false;
        } catch(NumberFormatException ignored) {return true;}
    }

    /**
     * Prompts the user for input and verifies that it is a valid double.
     *
     * @return the valid double input by the user
     *
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:20:38Z
     */
    private static double inpDouble() {
        while (true) {
            System.out.print("Enter weight: ");
            String inp = input.nextLine();
            if (isNotDouble(inp)) System.out.println("ERROR! Input not a number!");
            else {
                double weight = Double.parseDouble(inp);
                if (weight >= 0) return weight;
                else System.out.println("ERROR! Input not a valid weight!");
            }
        }
    }

    /**
     * Contains helper methods for mathematical operations.
     *
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-25T13:20:38Z
     */
    static class Maths {

        /**
        * Converts a value in kilograms to pounds.
        *
        * @param val the value in kilograms
        * @return the converted value in pounds
        *
        * @author Adam Tazul - 2274640 - SimPilotAdamT
        * @since 2022-10-25T13:20:38Z
        */
        public static String kg2lbs(double val){return "\n" + val + "kg in lbs is " + (val/0.45359237) + "lbs.";}
    }
}
