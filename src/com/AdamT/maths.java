package com.AdamT;

import  java.lang.*;

class maths {
	public static String sum(int x, int y) {
		try {
			int z = x + y;
			return("\nSum of x+y = " + z + "\n");
		} catch (Exception  ignored) {
			return("\nERROR!\nThere was an internal error with the calculation.\n");
		}
	}
}