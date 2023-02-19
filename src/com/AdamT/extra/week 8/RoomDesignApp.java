// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Scanner;

/**
 * This class represents an application that calculates the area of a rectangular room.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-11-15T09:33:47Z
 */
public class RoomDesignApp {
    /**
     * The main method for the application.
     *
     * @param args the command-line arguments
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter the length of the rectangular room: ");
            double length = input.nextDouble();
            while (length <= 0) {
                System.out.println("Invalid value! The length must be greater than zero.");
                System.out.print("Enter the length of the rectangular room: ");
                length = input.nextDouble();
            }

            System.out.print("Enter the height of the rectangular room: ");
            double height = input.nextDouble();
            while (height <= 0) {
                System.out.println("Invalid value! The height must be greater than zero.");
                System.out.print("Enter the height of the rectangular room: ");
                height = input.nextDouble();
            }

            Rectangle room = new Rectangle(length, height);

            System.out.println("The area of the rectangular room is: " + room.calculateArea());

            System.out.print("\nWould you like to find the area of another rectangular room? (y/n): ");
            choice = input.next();
        }

        input.close();
    }
}


/**
 * This class represents a rectangle.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-11-15T09:33:47Z
 */
class Rectangle {
    private double length;
    private double height;

    /**
     * The constructor for the class.
     *
     * @param lengthIn the length of the rectangle
     * @param heightIn the height of the rectangle
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public Rectangle(double lengthIn, double heightIn) {
        this.length = lengthIn;
        this.height = heightIn;
    }

    /**
     * This method allows us to read the length attribute.
     *
     * @return the length of the rectangle
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public double getLength() {return this.length;}

    /**
     * This method allows us to read the height attribute.
     *
     * @return the height of the rectangle
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public double getHeight() {return this.height;}

    /**
     * This method allows us to write to the length attribute.
     *
     * @param lengthIn the new length of the rectangle
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public void setLength(double lengthIn) {this.length = lengthIn;}

    /**
     * This method allows us to write to the height attribute.
     *
     * @param heightIn the new height of the rectangle
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public void setHeight(double heightIn) {this.height = heightIn;}

    /**
     * This method returns the area of the rectangle.
     *
     * @return the area of the rectangle
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public double calculateArea() {return this.length * this.height;}

    /**
     * This method returns the perimeter of the rectangle.
     *
     * @return the perimeter of the rectangle
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:33:47Z
     */
    public double calculatePerimeter() {return 2 * (this.length + this.height);}
}
