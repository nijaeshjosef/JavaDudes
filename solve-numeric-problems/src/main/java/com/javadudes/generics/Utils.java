package com.javadudes.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Utils {

	/**
	 * Start - Variable Declaration
	 */
	// Creating a Logger Instance
	private final static Logger logger = Logger.getLogger(Utils.class.getName());

	/**
	 * Method to compute the length of an integer
	 * 
	 * @param d
	 * @return
	 */
	public static int computeLength(double d) {

		int length = 1;
		double val = d;

		try {
			while (val > 9) {
				val = val / 10;
				++length;
			}
		} catch (Exception e) {

			logger.severe("Method computeLength of javadudes.generic.Utils class failed with the exception - " + e
					+ " : Number passed - " + d);
		}

		return length;
	}

	/**
	 * Method which returns the square root of the number passed
	 * 
	 * @param num
	 * @return square root of num
	 */
	public static double getSqrt(String num) {

		double nSqrt = 0.0;

		try {
			nSqrt = java.lang.Math.sqrt(Double.parseDouble(num));
		} catch (Exception e) {
			logger.severe("Execution failed while trying to get the square root of the number - " + num
					+ " with the Exception : " + e);
		}

		return java.lang.Math.ceil(nSqrt);
	}
	
	public static Map<Character, Integer> assignCharacterVal()
	{
		HashMap<Character, Integer> charIntValues = new HashMap<Character, Integer>();
		charIntValues.put('a', 1);
		charIntValues.put('b', 2);
		charIntValues.put('c', 3);
		charIntValues.put('d', 4);
		charIntValues.put('e', 5);
		charIntValues.put('f', 6);
		charIntValues.put('g', 7);
		charIntValues.put('h', 8);
		charIntValues.put('i', 9);
		charIntValues.put('j', 10);
		charIntValues.put('k', 11);
		charIntValues.put('l', 12);
		charIntValues.put('m', 13);
		charIntValues.put('n', 14);
		charIntValues.put('o', 15);
		charIntValues.put('p', 16);
		charIntValues.put('q', 17);
		charIntValues.put('r', 18);
		charIntValues.put('s', 19);
		charIntValues.put('t', 20);
		charIntValues.put('u', 21);
		charIntValues.put('v', 22);
		charIntValues.put('w', 23);
		charIntValues.put('x', 24);
		charIntValues.put('y', 25);
		charIntValues.put('z', 26);
		
		return charIntValues;
	}

}
