// Name of the class - GreatestLeastCommonDivisors
// Version - 1.0	Developer - Nijaesh
// Description - To find the GCD & LCM of a given set of numbers


package com.javadudes.solvefactors;

import java.util.ArrayList;
import java.util.List;


public class GreatestLeastCommonDivisors {

	List<Integer> inputNumbers = new ArrayList<Integer>();
	List<Integer> commonDivisors = new ArrayList<Integer>();
	int leastNumber = 0;

	/**
	 ** - Getters and setters for Input Numbers
	 **/
	public void setInputNumbers(String[] args) {

		for (String arg : args)
			this.inputNumbers.add(Integer.parseInt(arg));
	}

	public List<Integer> getInputNumbers() {

		return this.inputNumbers;
	}

	/**
	 * Method to get the Least number from the list of numbers supplied 
	 * Input  - [12 32 31 44 15] 
	 * Output - [12]
	 **/
	public void getLeastNumber() {

		int prevNumber = this.inputNumbers.get(0);

		for (int inputNumber : this.inputNumbers) {
			if (inputNumber <= prevNumber) {

				this.leastNumber = inputNumber;
				prevNumber = inputNumber;
			}
		}

	}

	/**
	 * Method to get all the common divisors for the numbers supplied 
	 * Input  - [6, 18] 
	 * Output - [2, 3, 6]
	 */
	public void getAllDivisors() {

		for (int i = 2; i <= this.leastNumber; i++) {

			int count = 0;
			for (int inputNumber : this.inputNumbers) {

				if (inputNumber % i != 0)
					break;
				else
					++count;

				if (count == inputNumbers.size() - 1)
					this.commonDivisors.add(i);
			}
		}
	}

	/**
	 * Method returns the Greatest Common Divisor (GCD) in the list of numbers passed 
	 * Returns the Max (CommonDivisors) 
	 * Input  - [6, 18] 
	 * Output - [6]
	 **/
	public int getGCDivisor() {

		int length = this.commonDivisors.size();
		System.out.println("Length >" + length);
		return (length > 0) ? this.commonDivisors.get(length - 1) : 1;
	}

	/**
	 * Method returns the Least Common Multiple (LCM) in the list of numbers passed
	 * Returns the Min (CommonDivisors) 
	 * Input - [6, 18] 
	 * Output - [2]
	 **/
	public int getLCMultiple() {

		return (this.commonDivisors.size() > 0) ? this.commonDivisors.get(0) : 1;
	}

	public boolean checkCOPrime() {

		return (this.commonDivisors.size() > 0) ? false : true;
	}

	/**
	 * Main method - Starting point of invocation - 
	 * Arguments to the program is obtained at run time
	 **/
	public static void main(String[] args) {

		String ab[] = new String[] { "999", "247" };
		// List<String> inputNumbers = new ArrayList<String>(Arrays.asList(ab));

		GreatestLeastCommonDivisors greatestLeastCommonDivisors = new GreatestLeastCommonDivisors();
		greatestLeastCommonDivisors.setInputNumbers(ab);
		greatestLeastCommonDivisors.getLeastNumber();
		greatestLeastCommonDivisors.getAllDivisors();

		for (int inputNumber : greatestLeastCommonDivisors.getInputNumbers())
			System.out.print(inputNumber + " | ");

		System.out.println("Least Number - " + greatestLeastCommonDivisors.leastNumber);

		System.out.println("GCD -" + greatestLeastCommonDivisors.getGCDivisor());
		System.out.println("LCM -" + greatestLeastCommonDivisors.getLCMultiple());
		System.out.println("Co Primes -" + greatestLeastCommonDivisors.checkCOPrime());

	}
}
