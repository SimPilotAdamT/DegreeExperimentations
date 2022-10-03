package com.AdamT;

import  java.lang.*;
import java.util.*;

public class experiments {
    static Scanner input = new Scanner(System.in);
    static String inp;
    static boolean valid;
    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Welcome to AdamT's collection of programs written for UEL!\n");
        while (!exit) {
            menu();
            inp = input.nextLine();
            valid = false;
            while (!valid){
                if (isNotInteger(inp)) {
                    System.out.println("\nERROR!\nInput not an integer!\n");
                    System.out.print("Try again: ");
                    inp = input.nextLine();
                }
                else if (Integer.parseInt(inp) == 1) {
                    System.out.println("\nWelcome to AdamT's summation program!");
                    System.out.println(maths.sum(inpDouble(),inpDouble()));
                    valid = true;
                }
                else if (Integer.parseInt(inp) == 2) {
                    System.out.println("\nAdam Tazul\nDOB: 2004-05-01\nZodiac: Taurus\n"); // Topic 2
                    valid = true;
                }
                else if (Integer.parseInt(inp)==3) { // Topic 3
                    System.out.println("\nWelcome to AdamT's circle calculator!");
                    System.out.println(maths.CircCalc(inpDouble()));
                    valid = true;
                }
                else if (Integer.parseInt(inp) == 4) {
                    exit = true;
                    valid = true;
                }
                else {
                    System.out.println("\nERROR!\nInvalid input!\n");
                    menu();
                    inp = input.nextLine();
                }
            }
        }
        input.close();
        System.out.println("Bye!");
    }
    private static void menu() {
        System.out.println("Choose from the following programs:");
        System.out.println("1: Sum (adds 2 numbers from STDIN)");
        System.out.println("2: About me (prints some info about me)");
        System.out.println("3: Circle dimension calculator (prints the area and circumference of a given circle's radius)");
        System.out.println("4: Exit (exit this program)");
        System.out.print("\nPlease input the corresponding number to your desired option: ");
    }
    private static boolean isNotInteger(String input){try{Integer.parseInt(input);return false;}catch(Exception ignored){return true;}}
    private static boolean isNotDouble(String input){try{Double.parseDouble(input);return false;}catch(Exception ignored){return true;}}
    private static double inpDouble() {
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