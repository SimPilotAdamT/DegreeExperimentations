// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Scanner;

/**
 * This program prints a multiplication table of a number between 2 and 100, specified by the user.
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-10-30T23:30:30Z
 */
public class TimesTableApp {
    /**
     * The main method that is executed when the program runs.
     * @param args The command line arguments passed to the program.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-30T23:30:30Z
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String exit = "n";
        do {
            int num = inpInteger(input);
            for (int i = 1; i < 13; i++) {System.out.println(i + "×" + num + "=" + (i * num));}
            System.out.print("Exit? [y/N] ");
            exit = input.nextLine();
            while (!exit.equalsIgnoreCase("y") && !exit.equalsIgnoreCase("n")) {
                System.out.println("\nERROR!\nInvalid input. Please enter either 'y' or 'n'.");
                System.out.print("Exit? [y/N] ");
                exit = input.nextLine();
            }
        } while (!exit.equalsIgnoreCase("y"));
    }

    /**
     * Asks the user for input of a String, then verifies that it is a valid number between 2 and 100.
     * @param input The Scanner object used to get input from the user.
     * @return A positive integer value that is between 2 and 100.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-30T23:30:30Z
     */
    private static int inpInteger(Scanner input) {
        String inp = "";
        while (true) {
            System.out.print("\nEnter a number between 2 and 100: ");
            inp = input.nextLine();
            try {
                int num = Integer.parseInt(inp);
                if (num > 100 || num < 2) System.out.println("\nERROR!\nInput invalid!");
                else return num;
            } catch (NumberFormatException e) {System.out.println("\nERROR!\nInput not a number!");}
        }
    }
}
