package com.javadudes.solveprimes;

import java.util.logging.Logger;

import com.javadudes.generics.LogHandler;
import com.javadudes.generics.Utils;

public class PrimeOrNot {

	/**
	 * Start - Variable Declaration
	 */
	// Creating a Logger Instance
	private final static Logger logger = LogHandler.getLogger(Logger.getLogger(PrimeOrNot.class.getName()),
			PrimeOrNot.class.getName());

	/**
	 * Method to compute the range of values to be considered for computing the divisors
	 * 
	 * @param numSqrt
	 * @return List of Double values used in computing divisors at specific ranges
	 */
	static java.util.List<Double> addSplitLargeNumbers(double numSqrt) {

		// Declarations
		double d = numSqrt;
		java.util.List<Double> sqrtRange = new java.util.ArrayList<Double>();
		// Adding the initially computed square root to the list
		sqrtRange.add(d);

		// Computing the square root in a cyclic way
		while (Utils.computeLength(d) > 3) {

			try {
				d = java.lang.Math.ceil(java.lang.Math.sqrt(d));
			} catch (Exception e) {
				logger.severe("Error while computing ranges for large numbers in addSplitLargeNumbers method");
				logger.severe("Class : com.javadudes.solveprimes.PrimeOrNot");
				logger.severe("Last Computed Number - " + d);
			}
			sqrtRange.add(d);
		}

		logger.info((sqrtRange.size() > 0 ) ? "Computed ranges - " : "Computed ranges - None");
		
		for (double range : sqrtRange)
				logger.info(" [ " + range + " ] ");

		return sqrtRange;

	}

	static Boolean[] calculatePrimes(int upperLimit, int lowerLimit) {

		Boolean[] primeNumberArray = new Boolean[upperLimit + 1];
		boolean firstRun = true;

		// System.out.println("Range >" + (upperLimit - lowerLimit));

		while (lowerLimit <= upperLimit) {
			int count = 0;
			for (int i = lowerLimit; i <= upperLimit; i++) {

				// FirstRun
				// Marking the entire array as true
				if (firstRun) {
					primeNumberArray[i] = true;
					++count;
				} else if (!primeNumberArray[lowerLimit]) {
					break;
				}

				if (i % lowerLimit == 0 && primeNumberArray[i] && count > 1) {
					primeNumberArray[i] = false;
					++count;
					System.out.println("The following element was marked false : "+i+" by the following factor : "+lowerLimit);
				} else if (i % lowerLimit == 0 && primeNumberArray[i]) {
					++count;
				}
			}
			

			System.out.println("  lowerLimit - "+lowerLimit+" count : "+count);
			
			firstRun = false;
			++lowerLimit;

		}

		return primeNumberArray;
	}
	
	public static boolean checkPrime(java.util.List<Integer> primeList, int inputNum) {
		
		boolean isPrime = true; 
		
		for(int prime : primeList)
		{
			if(inputNum % prime == 0)
				isPrime = false;
		}
		
		return isPrime;
	}
	

	// Generate Prime Numbers within each Range
	static java.util.List<Integer> generatePrimeWithinRange(java.util.List<Double> rList) {

		java.util.List<Integer> primeList = new java.util.ArrayList<Integer>();
		
		for (int i = rList.size() - 1; i >= 0; i--) {
			int lowerLimit = (i == rList.size() - 1) ? Integer.parseInt("2") : new Double(rList.get(i + 1)).intValue();
			int upperLimit = new Double(rList.get(i)).intValue();

			Boolean[] primeIndexes = new Boolean[upperLimit];
			primeIndexes = calculatePrimes(upperLimit, lowerLimit);

			System.out.println("Prime Numbers : ");
			for (int j = lowerLimit; j < primeIndexes.length; j++) {

				 if(primeIndexes[j])
					 primeList.add(j);
			}
		}
		
		return primeList;
	}

	public static void main(String[] args) {

		if (args.length < 1) {
			logger.warning("####################################################");
			logger.warning("## Failed to execute because of missing parameter ##");
			logger.warning("## Supply the parameter <number> while calling    ##");
			logger.warning("####################################################");
			System.exit(0);
		} else {
			
			//Section 1 - Obtaining Input number
			//For appending to log file
			StringBuffer strbuf = new StringBuffer("");
			strbuf.append("######################################################\n");
			strbuf.append("# 	Input Number :: " + args[0]+"\n");
			strbuf.append("\n");
			strbuf.append("######################################################\n");

			//Section 2 - Obtaining square root
			strbuf.append("\n");
			strbuf.append("\n");
			double numSqrt = Utils.getSqrt(args[0]);
			strbuf.append("# Square root of the number " + args[0] + " - " + numSqrt+"\n");
			strbuf.append("\n");
			strbuf.append("#############################################################\n");
			logger.info(strbuf.toString());

			java.util.List<Double> rangeList = addSplitLargeNumbers(numSqrt);
			logger.info("Ranges are computed [Large numbers are broken down to their square roots]");
			
			java.util.List<Integer> primeList = generatePrimeWithinRange(rangeList);
			boolean primeOrNot = checkPrime(primeList, Integer.parseInt(args[0]));
			
			System.out.println("The number "+ args[0]+ " is prime : "+primeOrNot);
		}

	}
}