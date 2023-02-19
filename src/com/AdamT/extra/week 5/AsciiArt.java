// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

/**
 * This class prints an ASCII art diamond, L shape, and half diamond to the console.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-10-30T23:45:00Z
 */
public class AsciiArt {
    /**
     * The main method that prints the ASCII art.
     *
     * @param args The command line arguments (not used in this program).
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-10-30T23:45:00Z
     */
    public static void main(String[] args) {
        // First half of the diamond
        for (int row = 1; row <= 6; row++) {
            for (int col = 1; col <= row; col++) {System.out.print("*");}
            System.out.println();
        }

        // Second half of the diamond
        for (int row = 5; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {System.out.print("*");}
            System.out.println();
        }

        // The L shape
        for (int row = 1; row <= 5; row++) {
            if (row <= 2) System.out.print("**");
            else if (row > 2) System.out.print("****");
            System.out.println();
        }
    }
}
