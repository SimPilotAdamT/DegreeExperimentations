// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.*;

/**
 * This class represents an application that prompts the user to enter exam marks
 * and then displays each mark along with a PASS or FAIL grade.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-11-11T18:10:00Z
 */
public class MarksApp {
    /**
     * The main method for the MarksApp application.
     *
     * @param args command line arguments (not used)
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T18:10:00Z
     */
    public static void main(String[] args) {
        // Declare an array to store the exam marks
        int[] marks;
        // Get the exam marks from the user
        marks = getExamMarks();
        // Display the exam marks
        displayMarks(marks);
    }

    /**
     * Prompts the user to enter the number of exam marks and then reads each exam mark from the user.
     *
     * @return an array containing the exam marks entered by the user
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T18:10:00Z
     */
    private static int[] getExamMarks() {
        // Prompt the user to enter the number of exam marks
        System.out.println("Enter the number of exam marks: ");
        int numMarks = input.nextInt();

        // Create an array to store the exam marks
        int[] marks = new int[numMarks];

        // Prompt the user to enter each exam mark
        for (int i = 0; i < numMarks; i++) {
            System.out.println("Enter exam mark " + (i + 1) + ": ");
            int mark = input.nextInt();

            // Validate the entered mark to make sure it is a valid percentage
            if (mark >= 0 && mark <= 100) marks[i] = mark;
            else {
                System.out.println("Invalid exam mark. Please enter a valid percentage (0-100).");
                i--;
            }
        }
        return marks;
    }

    /**
     * Loops through the array of marks and displays each mark, along with a PASS or FAIL grade.
     *
     * @param marks the array of exam marks to be displayed
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-11T18:10:00Z
     */
    private static void displayMarks(int[] marks) {
        // Loop through the array of marks
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 40) System.out.println("Exam mark " + (i + 1) + ": " + marks[i] + " - PASS"); // Exam mark is 40 or greater, display a PASS grade
            else System.out.println("Exam mark " + (i + 1) + ": " + marks[i] + " - FAIL"); // Exam mark is less than 40, display a FAIL grade
        }
    }
}
