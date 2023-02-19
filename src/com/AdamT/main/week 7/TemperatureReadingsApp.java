// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.*;

/**
 * This class contains methods for entering, displaying, and converting temperature readings.
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-11-11T18:00:00Z
 */
public class TemperatureReadingsApp {
    private static Scanner input = new Scanner(System.in);
    private static String inp;

    /**
     * The main method for the TemperatureReadingsApp.
     * @param args The command line arguments.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T18:00:00Z
     */
    public static void main(String[] args) {
        double[] temperature = new double[7];
        enterTemps(temperature);
        displayTemps(temperature);
        wasHot(temperature);
        hottestTemp(temperature);
        for (int i = 0; i < temperature.length; i++) {temperature[i] = convertToFarenheit(temperature[i]);}
    }

    /**
    * Allows the user to input temperatures
    * @param temperatureIn The empty array of temperatures.
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-11-11T18:00:00Z
    */
    private static void enterTemps(double[] temperatureIn) {
        for (int i = 0; i < temperatureIn.length; i++) {
            System.out.print("enter max temperature for day " + (i+1) + ": ");
            temperatureIn[i] = inpDouble();
        }
    }

    /**
    * Displays all of the entered temperatures.
    * @param temperatureIn The array of temperatures.
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-11-11T18:00:00Z
    */
    private static void displayTemps(double[] temperatureIn) {
        System.out.println();
        System.out.println("***TEMPERATURES ENTERED***");
        for (int i = 0; i < temperatureIn.length; i++) {System.out.println("day "+(i+1)+" "+ temperatureIn[i]);}
    }

    /**
    * Displays all of the temperatures that are above 18C.
    * @param temperatureIn The array of temperatures.
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-11-11T18:05:00Z
    */
    private static void wasHot(double[] temperatureIn) {
        System.out.println();
        System.out.println("***HOT TEMPERATURES ENTERED***");
        for (int i = 0; i < temperatureIn.length; i++) {if (temperatureIn[i]>=18) System.out.println("day "+(i+1)+" "+ temperatureIn[i]);}
    }

    /**
    * Displays the hottest temperature in the array
    * @param temperatureIn
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-11-11T18:30:00Z
    */
    private static void hottestTemp(double[] temperatureIn) {
        // Initialize the max variable to the smallest possible value
        double max = Double.MIN_VALUE;
        System.out.println();
        System.out.println("***HOTTEST TEMPERATURE ENTERED***");
        for (int i = 0; i < temperatureIn.length; i++) {if (temperatureIn[i] > max) max = temperatureIn[i];}
        System.out.println(max + "Degrees Celsius.");
    }

    /**
    * Converts the input from C to F.
    * @param temperatureIn The temperature in C.
    * @return The temperature in F.
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-11-11T18:15:00Z
    */
    private static double convertToFarenheit(double temperatureIn) {
        // Use floating-point division or multiplication to calculate the conversion factor
        return((temperatureIn * 1.8) + 32);
    }

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
    * Verifies the inputted string is a valid double and prompts the user to enter a valid value if necessary.
    * @return The inputted temperature as a double.
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-10-10T12:00:00Z
    */
    private static double inpDouble() {
        valid = false;
        do {
            System.out.print("\nEnter temperature: ");
            inp = input.nextLine();
            if (isNotDouble(inp)) System.out.println("\nERROR!\nInput not a number!");
            else valid = true;
        } while (!valid)
        return(Double.parseDouble(inp));
    }
}
