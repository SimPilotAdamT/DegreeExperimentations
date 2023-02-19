// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Scanner;

/**
 * A class that tests the Circle class.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-12-09T20:57:55Z
 */
public class CircleTester {
    /**
    * The main method of the CircleTester class.
    *
    * @param args command-line arguments
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T20:57:55Z
    */
     public static void main(String[] args) {
        // create a new Circle object with a radius of 4.5
        Circle c1 = new Circle(4.5);

        // display the circle's information
        displayCircleInformation(c1);

        // a flag variable to indicate whether the user's input is valid
        boolean valid = false;

        // keep prompting the user to enter a new radius until a valid value is entered
        while (!valid) {
            // prompt the user to enter a new radius for the circle
            System.out.println();
            System.out.print("Enter a new radius for the circle: ");

            // read the user's input
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // try to parse the user's input as a double
            try {
                double newRadius = Double.parseDouble(input);

                // ensure the new radius is within the range of the double data type
                if (Double.isFinite(newRadius)) {
                    // set the radius of c1 to the new radius
                    c1.setRadius(newRadius);

                    // the user's input is valid
                    valid = true;
                } else System.out.println("Invalid input: the number you entered is too large or too small to be represented by the double data type."); // the new radius is not within the range of the double data type
            } catch (NumberFormatException e) {System.out.println("Invalid input: the value you entered is not a valid number.");} // the user's input could not be parsed as a double
        }

        // print a line of whitespace
        System.out.println();

        // display the circle's information
        displayCircleInformation(c1);
    }

    /**
    * Displays the information of the given Circle object.
    *
    * @param circle the Circle object whose information should be displayed
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T23:30:00Z
    */
    public static void displayCircleInformation(Circle circle) {
        // display the radius of the Circle object
        System.out.println("Radius: " + circle.getRadius());

        // display the diameter of the Circle Object
        System.out.println("Diameter: " + circle.calculateDiameter());

        // display the area of the Circle object
        System.out.println("Area: " + circle.calculateArea());

        // display the circumference of the Circle object
        System.out.println("Circumference: " + circle.calculateCircumference());
    }
}

/**
 * A class that represents a circle.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-12-09T20:57:55Z
 */
public class Circle {
    // attribute to hold the radius of the circle
    private double radius;

    /**
    * Constructs a new Circle object with the given radius.
    *
    * @param radius the radius of the circle
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T20:57:55Z
    */
    public Circle(double radius) {this.radius = radius;}

    /**
    * Returns the radius of this Circle object.
    *
    * @return the radius of this Circle object
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T20:57:55Z
    */
    public double getRadius() {return this.radius;}

    /**
    * Sets the radius of this Circle object to the given value.
    *
    * @param radius the new radius of this Circle object
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T20:57:55Z
    */
    public void setRadius(double radius) {this.radius = radius;}

    /**
    * Calculates and returns the area of this Circle object.
    *
    * @return the area of this Circle object
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T20:57:55Z
    */
    public double calculateArea() {return Math.PI * Math.pow(this.radius, 2);}

    /**
    * Calculates and returns the circumference of this Circle object.
    *
    * @return the circumference of this Circle object
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T20:57:55Z
    */
    public double calculateCircumference() {return 2 * Math.PI * this.radius;}

    /**
    * Calculates and returns the diameter of this Circle object.
    *
    * @return the diameter of this Circle object
    * @author Adam Tazul - 2274640 - SimPilotAdamT
    * @since 2022-12-09T21:06:24Z
    */
    public double calculateDiameter() {return 2 * this.radius;}
}
