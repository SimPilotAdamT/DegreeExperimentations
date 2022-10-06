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
import java.util.concurrent.*;
import java.math.*;

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
					valid = true;
					System.out.println("\nWelcome to AdamT's summation program!");
					System.out.println(maths.sum(inpDouble(), inpDouble()));
				}
				else if (Integer.parseInt(inp) == 2) { // Topic 2
					valid = true;
					System.out.println("\nAdam Tazul\nDOB: 2004-05-01\nZodiac: Taurus\n");
				}
				else if (Integer.parseInt(inp) == 3) { // Topic 3
					valid = true;
					System.out.println("\nWelcome to AdamT's circle calculator!");
					System.out.println(maths.CircCalc(inpDouble()));
				}
				else if (Integer.parseInt(inp) == 4) { // From chapter 2 of Dr Aaron Kans' book
					valid = true;
					System.out.println("\nWelcome to AdamT's Tax-Cost Calculator!");
					double taxRate;
					double price;
					
					System.out.print("\nEnter the original price (cannot be £0 or below, include the decimal point): £");
					inp = input.nextLine();
					valid = false;
					while (!valid) {
						if (isNotDouble(inp)) {
							System.out.println("\nERROR!\nInput not a number!\n");
							System.out.print("Try again: £");
							inp = input.nextLine();
						}
						else if (Double.parseDouble(inp) <= 0) {
							System.out.println("\nERROR!\nInvalid input!\nPrices are not allowed to be £0 or below!\n");
							System.out.print("Try again: £");
							inp = input.nextLine();
						}
						else if (!inp.contains(".")) {
							System.out.println("\nERROR!\nInvalid input!\nPrices need to include the decimal point!\n");
							System.out.print("Try again: £");
							inp = input.nextLine();
						}
						else if (inp.length() - inp.indexOf(".") - 1 != 2) {
							System.out.println("\nERROR!\nInvalid input!\nPrices need to have 2 decimal places!\n");
							System.out.print("Try again: £");
							inp = input.nextLine();
						}
						else valid = true;
					}
					price = Double.parseDouble(inp);
					
					System.out.print("\nEnter the tax rate (cannot be below 0%): ");
					inp = input.nextLine();
					valid = false;
					while (!valid) {
						if (isNotDouble(inp)) {
							System.out.println("\nERROR!\nInput not a number!\n");
							System.out.print("Try again: ");
							inp = input.nextLine();
						}
						else if (Double.parseDouble(inp) < 0) {
							System.out.println("\nERROR!\nInvalid input!\nTax rates are not allowed to be less than 0%!\n");
							System.out.print("Try again: ");
							inp = input.nextLine();
						}
						else valid = true;
					}
					taxRate = Double.parseDouble(inp);
					System.out.println(maths.findCost3(price, taxRate));
				}
				else if (Integer.parseInt(inp) == 5) { // Topic 3's extra task, expanded on very elaborately
					boolean ex = false;
					while (!ex) {
						String str1;
						String str2;
						double num;
						valid = true;
						convMenu();
						inp = input.nextLine();
						valid = false;
						while (!valid) {
							if (isNotInteger(inp)) { // The input has to be an integer
								System.out.println("\nERROR!\nInput not an integer!\n");
								System.out.print("Try again: ");
								inp = input.nextLine();
							}
							else if (Integer.parseInt(inp) == 1) {
								valid = true;
								System.out.println("\nYou selected weight.");
								boolean ex1 = false;
								while (!ex1) {
									System.out.println("\nWhich unit do you want to convert from?");
									System.out.println("For example, if you want kilograms, type kg, for pounds, lbs");
									System.out.println("NB: This program only supports kg's and lbs's for now. More weight units will be added later.");
									System.out.print("Enter your choice here: ");
									str1 = input.nextLine();
									System.out.println("\nWhich unit do you want to convert to?");
									System.out.println("For example, f you want kilograms, type kg, for pounds, lbs");
									System.out.println("NB: This program only supports kg's and lbs's for now. More weight units will be added later.");
									System.out.print("Enter your choice here: ");
									str2 = input.nextLine();
									System.out.println("\nWhat is the amount of " + str1 + " you want to convert from?");
									System.out.print("Enter here: ");
									num = inpDouble();
									try {
										System.out.println(maths.conversionCalc(str1, str2, num));
										ex1 = true;
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
							else if (Integer.parseInt(inp) == 4) {
								valid = true;
								ex = true;
								System.out.println("\nExiting...\n");
								try {TimeUnit.MILLISECONDS.sleep(500);}catch(Exception ignored){}
							}
							else { // So the user can change their option if they input an integer that is not on the list
								System.out.println("\nERROR!\nInvalid input!\n");
								convMenu();
								inp = input.nextLine();
							}
						}
					}
				}
				else if (Integer.parseInt(inp) == 6) { // To ensure this isn't an infinite loop
					valid = true;
					exit = true;
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
		System.out.println("4: Tax-Cost calculator (calculates the true price of something after tax, with the original price and the tax rate provided via STDIN)");
		System.out.println("5: Conversion calculator (various conversions between units)");
		System.out.println("6: Exit (exit this program)");
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
	
	private static void convMenu() { // Topic 3's extra task, expanded on very elaborately
		System.out.println("\nWelcome to AdamT's conversion program!");
		System.out.println("Please choose an option from the following:");
		System.out.println("1: weight");
		System.out.println("2: temperature");
		System.out.println("3: length");
		System.out.println("4: back to the main menu");
		System.out.print("\nPlease input the corresponding number to your desired option: ");
	}
}

// The following class with have all the calculation-related stuff
class maths {
	private static double round(double value, int places) {
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return(bd.doubleValue());
	}
	
	public static String sum(double x, double y) { // Example shown in Topic 2, enhanced slightly
		double z = x + y;
		return("\nSum of x+y = " + z + "\n");
	}
	
	public static String CircCalc(double rad) { // Topic 3
		if (rad <= 0) return ("\nERROR!\nThere was an internal error with the calculation.\nMaybe you accidentally put a negative number?\n");
		final double PI = 3.1415936535897932;
		double area = PI * rad * rad;
		double circ = PI * rad * 2;
		double diam = rad * 2;
		return("\nThe diameter of your circle of radius " + rad + " = " + diam + "\nThe area of the circle = " + area + "\nThe circumference of the circle = " + circ + "\nThe value of pi used = " + PI + "\n");
	}
	
	public static String findCost3(double price, double taxRate) { // More from Dr Kans' book
		double finalPrice = price * (1 + taxRate/100);
		return("\nThe final price of the product, assuming an original price of £" + price + " and a tax rate of " + taxRate + "%, = £" + round(finalPrice, 2) + "\n");
	}
	
	public static String conversionCalc(String from, String to, double val)  throws InvalidUnitsException { // Topic 3's extra task, expanded on very elaborately
		double result;
		switch (to) {
			case "M":
			case "m":
				switch (from) {
					case "IN":
					case "in":
						result = val * 39.37007874015748;
						break;
					case "FT":
					case "ft":
						result = (val / 3.2808398950131236) * 12;
						break;
					default:
						throw new InvalidUnitsException("Given units incompatible");
				}
				return("\nConverting " + val + from + " into m gives " + result + "m.");
			case "IN":
			case "in":
				switch (from) {
					case "FT":
					case "ft":
						result = val * 12;
						break;
					case "M":
					case "m":
						result = val / 39.37007874015748;
						break;
					default:
						throw new InvalidUnitsException("Given units incompatible");
				}
				return("\nConverting " + val + from + " into in gives " + result + "in.");
			case "TN":
			case "tn":
				switch (from) {
					case "KG":
					case "kg":
						result = val * 1000;
						break;
					case "TN":
					case "tn":
						result = val * 2204.6226218487758;
						break;
					default:
						throw new InvalidUnitsException("Given units incompatible");
				}
				return("\nConverting " + val + from + " into tn gives " + result + "tn.");
			case "KG":
			case "kg":
				switch (from) {
					case "TN":
					case "tn":
						result = val / 1000;
						break;
					case "LBS":
					case "lbs":
						result = val * 2.2046226218487758;
						break;
					default:
						throw new InvalidUnitsException("Given units incompatible");
				}
				return("\nConverting " + val + from + " into kg gives " + result + "kg.");
			case "LBS":
			case "lbs":
				switch (from) {
					case "TN":
					case "tn":
						result = val / 2204.6226218487758;
								break;
					case "KG":
					case "kg":
						result = val / 2.2046226218487758;
						break;
					default:
						throw new InvalidUnitsException("Given units incompatible");
				}
				return("\nConverting " + val + from + " into lbs gives " + result + "lbs.");
			default:
				throw new InvalidUnitsException(to + " is an invalid unit");
		}
	}
}

class InvalidUnitsException extends Exception{public InvalidUnitsException(String message){super(message);}} // Topic 3's extra task, expanded on very elaborately