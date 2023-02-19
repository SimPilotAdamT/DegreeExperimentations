// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

/**
 * Program to process a 2D Array
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-12-14T17:18:55Z
 */
public class TwoDArray {
    /**
     * Main method of the class
     *
     * @param args
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-14T17:18:55Z
     */
    public static void main(String[] args) {
        // initialise 2D array
        char[][] a2DArray = {
                                {'X', 'X', 'O'},
                                {'O', 'X', 'O'},
                                {'X', 'O', 'X'}
                            };
        // display grid
        displayGrid(a2DArray);
        // check row 1
        System.out.print("Row 1: X total = ");
        System.out.println(checkRow1(a2DArray, 'X'));
        // check left diagonal
        System.out.print("Left Diagonal: X total = ");
        System.out.println(checkLeftD(a2DArray, 'X'));
    }

    /**
     * Method to display a grid
     *
     * @param grid The grid to be displayed
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-14T17:18:55Z
     */
    static void displayGrid ( char[][] grid ) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {System.out.print(grid[row][col]);}
            System.out.println();
        }
    }

    /**
     * Method to check a row for a symbol
     *
     * @param grid The grid to be checked
     * @param symbol The symbol to be checked for
     * @return The number of times the symbol appears in the row
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-14T17:18:55Z
     */
    static int checkRow1 (char[][] grid , char symbol ) {
        int count = 0;
        for (int col = 0; col < grid[0].length; col++) {if (grid[0][col] == symbol) count++;}
        return count;
    }

    /**
     * Method to check a left diagonal for a symbol
     *
     * @param grid The grid to be checked
     * @param symbol The symbol to be checked for
     * @return The number of times the symbol appears in the left diagonal
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-12-14T17:18:55Z
     */
    static int checkLeftD( char[][] grid, char symbol ) {
        int count = 0;
        for (int num = 0; num < grid.length; num++) {if (grid[num][num] == symbol) count++;}
        return count;
    }
}
