/*
 * This is a collection of  programs I have written to help get my degree in computer science
 *  The degree is still in progress, so you can expect updates fairly quickly as I progress
 *  Everything is licenced under the GNU GPK v3 licence
 *  Everything will be uploaded to the git repo on https://github.com/SimPilotAdamT/DegreeExperimentations
 */

package com.AdamT; // Specifies the directory the files are in

// IMPORTS
import  java.lang.*;
import java.util.*;

public class experiments { // Main class
    // VARIABLES
    static Scanner input = new Scanner(System.in);
    static String inp;
    static boolean valid;
    public static void main(String[] args) { // Main method
        boolean exit = false; // So we can do multiple things at once
        System.out.println("Welcome to AdamT's collection of programs written for UEL!\n");
        while (!exit) {
            menu();
            inp = input.nextLine();
            valid = false;
            while (!valid) {
                /*
                 * The following is an if statement instead of a switch statement because making it a switch statement
                 * will force me to split up the if statement, elongating everything because that will force me to use
                 * an unnecessary try-catch statement.
                 */
                if (isNotInteger(inp)) { // The input has to be an integer
                    System.out.println("\nERROR!\nInput not an integer!\n");
                    System.out.print("Try again: ");
                    inp = input.nextLine();
                }
                else if (Integer.parseInt(inp) == 1) { // Example shown in Topic 2, enhanced slightly
                    System.out.println("\nWelcome to AdamT's summation program!");
                    System.out.println(maths.sum(inpDouble(),inpDouble()));
                    valid = true;
                }
                else if (Integer.parseInt(inp) == 2) { // Topic 2
                    System.out.println("\nAdam Tazul\nDOB: 2004-05-01\nZodiac: Taurus\n");
                    valid = true;
                }
                else if (Integer.parseInt(inp)==3) { // Topic 3
                    System.out.println("\nWelcome to AdamT's circle calculator!");
                    System.out.println(maths.CircCalc(inpDouble()));
                    valid = true;
                }
                else if (Integer.parseInt(inp) == 4) { // To ensure this isn't an infinite loop'
                    exit = true;
                    valid = true;
                }
                else { // So the user can change their option if they input an integer that is not on the list
                    System.out.println("\nERROR!\nInvalid input!\n");
                    menu();
                    inp = input.nextLine();
                }
            }
        }
        input.close(); // Best practice
        System.out.println("\nBye!");
    }
    private static void menu() { // Avoiding repetitive code
        System.out.println("Choose from the following programs:");
        System.out.println("1: Sum (adds 2 numbers from STDIN)");
        System.out.println("2: About me (prints some info about me)");
        System.out.println("3: Circle dimension calculator (prints the area and circumference of a given circle's radius)");
        System.out.println("4: Exit (exit this program)");
        System.out.print("\nPlease input the corresponding number to your desired option: ");
    }

    // The following 2 methods help with validation of user-inputted numbers
    private static boolean isNotInteger(String input){try{Integer.parseInt(input);return false;}catch(Exception ignored){return true;}}
    private static boolean isNotDouble(String input){try{Double.parseDouble(input);return false;}catch(Exception ignored){return true;}}

    private static double inpDouble() { // Avoiding repetitive code
        System.out.print("\nEnter a number: ");
        inp = input.nextLine();
        valid = false;
        while (!valid) {
            if (isNotDouble(inp)) {
                System.out.println("\nERROR!\nInput not a number!\n");
                System.out.print("Try again: ");
                inp = input.nextLine();
            }
            else valid = true;
        }
        return(Double.parseDouble(inp));
    }
}

// The following class with have all of the calculation-related stuff
class maths {
    public static String sum(double x, double y) { // Example shown in Topic 2, enhanced slightly
        try { // Try-catch used here in case of any random error
            double z = x + y;
            return("\nSum of x+y = " + z + "\n");
        } catch (Exception  ignored) {return("\nERROR!\nThere was an internal error with the calculation.\n");}
    }

    public static String CircCalc(double rad) { // Topic 3
        try { // Try-catch used here in case of any random error
            if (rad <= 0) return ("\nERROR!\nThere was an internal error with the calculation.\nMaybe you accidentally put a negative number?\n");
            final double PI = 3.1415936535897932;
            double area = PI * rad * rad;
            double circ = PI * rad * 2;
            double diam = rad * 2;
            return("\nThe diameter of your circle of radius " + rad + " = " + diam + "\nThe area of the circle = " + area + "\nThe circumference of the circle = " + circ + "\nThe value of pi used = " + PI + "\n");
        } catch (Exception  ignored) {return("\nERROR!\nThere was an internal error with the calculation.\n");}
    }
}
