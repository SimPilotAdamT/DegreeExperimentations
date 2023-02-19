// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Arrays;
import java.util.Scanner;

/**
 * A class to represent a magic word square.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-12-10T00:45:49Z
 */
public class MagicSquareApp {

    /**
     * The main method.
     *
     * @param args The command-line arguments
     * @throws IllegalArgumentException if the row or column number is invalid
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-10T00:45:49Z
     */
    public static void main(String[] args) throws IllegalArgumentException {
        char[][] magicSquare = {
            {'p', 'r', 'e', 'y'},
            {'l', 'a', 'v', 'a'},
            {'o', 'v', 'e', 'r'},
            {'t', 'e', 'n', 'd'}
        };

        displaySquare(magicSquare);
        displayRow(magicSquare, 2);
        displayColumn(magicSquare, 4);

        // infinite loop to display menu until user exits
        boolean exit = false;
        while (!exit) {
            // display menu options
            System.out.println();
            System.out.println("1) Display Magic Square");
            System.out.println("2) Display Row");
            System.out.println("3) Display Column");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");

            // read user input
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            // handle user choice
            switch (choice) {
                case 1:
                    displaySquare(magicSquare);
                    break;
                case 2:
                    // infinite loop to read and validate row number
                    while (true) {
                        System.out.print("Enter row number: ");
                        int row = scanner.nextInt();
                        try {
                            displayRow(magicSquare, row);
                            break; // exit loop if row number is valid
                        } catch (IllegalArgumentException e) {System.out.println("Invalid row number: " + row);}
                    }
                    break;
                case 3:
                    // infinite loop to read and validate column number
                    while (true) {
                        System.out.print("Enter column number: ");
                        int column = scanner.nextInt();
                        try {
                            displayColumn(magicSquare, column);
                            break; // exit loop if column number is valid
                        } catch (IllegalArgumentException e) {System.out.println("Invalid column number: " + column);}
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default: System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Displays the magic word square.
     *
     * @param square The 2D array representing the magic word square
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-10T00:45:49Z
     */
    private static void displaySquare(char[][] square) {for (char[] row : square) {System.out.println(Arrays.toString(row));}}

    /**
     * Displays the word in the specified row of the magic word square.
     *
     * @param square The 2D array representing the magic word square
     * @param row The row number (1-based index)
     * @throws IllegalArgumentException if the row number is invalid
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-10T00:45:49Z
     */
    private static void displayRow(char[][] square, int row) throws IllegalArgumentException {
        if (row < 1 || row > square.length) throw new IllegalArgumentException("Invalid row number: " + row);
        System.out.println(Arrays.toString(square[row - 1]));
    }

    /**
     * Displays the word in the specified column of the magic word square.
     *
     * @param square The 2D array representing the magic word square
     * @param column The column number (1-based index)
     * @throws IllegalArgumentException if the column number is invalid
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-10T00:45:49Z
     */
    private static void displayColumn(char[][] square, int column) throws IllegalArgumentException {
        if (column < 1 || column > square[0].length) throw new IllegalArgumentException("Invalid column number: " + column);
        for (char[] row : square) {System.out.println(row[column - 1]);}
    }
}
