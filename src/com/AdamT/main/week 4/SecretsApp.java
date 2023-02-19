// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Scanner;

/**
 * The SecretsApp class is a program that allows the user to input their security clearance level and receive information based on their level.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-10-10T12:40:00Z
 */
public class SecretsApp {
    private static Scanner input = new Scanner(System.in);
    private static boolean valid;
    private static String inp;

    /**
     * The main method is the entry point of the program.
     * It prompts the user to input their security clearance level, verifies the input is valid, and outputs information based on the input.
     *
     * @param args The command line arguments passed to the program.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-10T12:40:00Z
     */
    public static void main(String[] args) {
        valid = false;
        do {
            System.out.print("Enter your security clearance level: ");
            inp = input.nextLine();
            if (isNotInteger(inp)) System.out.println("\nERROR! Input is not an integer!");
            else if (Integer.parseInt(inp) < 1 || Integer.parseInt(inp) > 3) System.out.println("\nERROR! NO SUCH LEVEL!");
            else valid = true;
        } while (!valid);
        switch (Integer.parseInt(inp)) {
            case 1:
                System.out.println("\nAccess granted to level 1 secrets");
                System.out.println("The security guard is a robot");
                break;
            case 2:
                System.out.println("\nAccess granted to levels 1 and 2 secrets");
                System.out.println("The security guard is a robot and there is a secret room in the basement");
                break;
            case 3:
                System.out.println("\nAccess granted to all secrets");
                System.out.println("The security guard is a robot, there is a secret room in the basement and the cook is an alien");
                break;
            default: throw new UnknownError();
        }
    }

    /**
     * Verifies the inputted string is a valid integer.
     *
     * @param input The string inputted by the user.
     * @return A boolean value depending on whether or not the inputted string is an integer.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-10T12:40:00Z
     */
    private static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (Exception ignored) {return true;}
    }
}
