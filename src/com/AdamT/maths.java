package com.AdamT;

import  java.lang.*;

class maths {
	public static String sum(double x, double y) {
		try {
			double z = x + y;
			return("\nSum of x+y = " + z + "\n");
		} catch (Exception  ignored) {return("\nERROR!\nThere was an internal error with the calculation.\n");}
	}
	public static String CircCalc(double rad) { // Topic 3
		try {
			if (rad <= 0) return ("\nERROR!\nThere was an internal error with the calculation.\nMaybe you accidentally put a negative number?\n");
			final double PI = 3.1415936535897932;
			double area = PI * rad * rad;
			double circ = PI * rad * 2;
			double diam = rad * 2;
			return("\nThe diameter of your circle of radius " + rad + " = " + diam + ".\nThe area of the circle = " + area + ".\nThe circumference of the circle = " + circ + ".\nThe value of pi used = " + PI + ".\n");
		} catch (Exception  ignored) {return("\nERROR!\nThere was an internal error with the calculation.\n");}
	}
}