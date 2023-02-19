// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Scanner;

/**
* This class contains the main method for the Circle App. It prompts the user for a radius value and then passes it to the Maths class to calculate the diameter, area, and circumference of the circle.
* @author Adam Tazul - 2274640 - SimPilotAdamT
* @since 2022-10-10T12:40:00Z
*/
public class CircleApp {
    private static Scanner input = new Scanner(System.in);

    /**
    * The main method that runs the Circle App. It prints the results of the calculations performed by the Maths class.
    * @param args The command line arguments.
    */
    public static void main(String[] args){
        System.out.println("*** CIRCLE APP ***\n" + Maths.calculateCircleMeasurements(inputDouble()) + "\nEND OF PROGRAM");
    }

    /**
    * Asks the user for input of a String, then verifies that it is a valid radius.
    * @return A positive double value that is larger than 0. If an exception is thrown when parsing the input, returns 0.
    * @since 2022-10-25T13:16:16Z
    */
    private static double inputDouble() {
        double radius;
        boolean valid;
        while (!valid) {
            System.out.print("\nEnter radius: ");
            try {
                radius = Double.parseDouble(input.nextLine());
                if (radius <= 0) System.out.println("\nERROR!\nInput not a valid radius!");
                else return radius;
            } catch (Exception e) {System.out.println("\nERROR!\nInput not a number!");}
        }
    }
}

/**
* This class contains the method for calculating the diameter, area, and circumference of a circle given its radius.
* @author Adam Tazul - 2274640 - SimPilotAdamT
* @since 2022-10-10T12:40:00Z
*/
class Maths{
    /**
    * Calculates and returns the diameter, area, and circumfrence of a given circle, using only the radius as the input.
    * @param rad The radius of the circle.
    * @return A string showing the circle's measurements.
    * @since 2022-10-10T12:40:00Z
    */
    public static String calculateCircleMeasurements(double rad){
        return("\nThe diameter of your circle of radius " + rad + " = " + (rad * 2)
               + "\nThe area of the circle = " + (Math.PI * rad * rad)
               + "\nThe circumference of the circle = " + (Math.PI * rad * 2)
               + "\nThe value of pi used = Math.PI\n");
    }
}
