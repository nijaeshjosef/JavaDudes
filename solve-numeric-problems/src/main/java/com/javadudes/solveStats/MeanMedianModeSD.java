package com.javadudes.solveStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class MeanMedianModeSD {

	List<Integer> inputIntArray = new ArrayList<Integer>();
	double mean;
	double median;

	public MeanMedianModeSD(String[] inputStrArray) {
		this.mean = 0;
		this.median = 0;

		for (String inputStr : inputStrArray)
			this.inputIntArray.add(Integer.parseInt(inputStr));

	}

	public List<Integer> sortValues(List<Integer> intValueArray) {
		for (int i = 0; i < intValueArray.size() - 1; i++) {
			for (int j = i + 1; j < intValueArray.size(); j++) {
				if (intValueArray.get(j) < intValueArray.get(i)) {
					int temp = intValueArray.get(i);
					intValueArray.set(i, intValueArray.get(j));
					intValueArray.set(j, temp);
				}
			}
		}

		return intValueArray;
	}

	public void calculateMean() {
		double sum = 0;

		for (int inputArray : this.inputIntArray)
			sum += inputArray;

		this.mean = sum / inputIntArray.size();

	}

	public void calculateMedian() {
		List<Integer> sortedIntArray = new ArrayList<Integer>();
		sortedIntArray = sortValues(this.inputIntArray);
		int arrayLen = sortedIntArray.size();

		if (arrayLen % 2 == 0) {
			int midArray = arrayLen / 2;
			this.median = (double) (sortedIntArray.get(midArray) + sortedIntArray.get(midArray - 1)) / 2;
		} else {
			int midArray = (int) java.lang.Math.ceil(arrayLen / 2);
			this.median = sortedIntArray.get(midArray);
		}
	}
	
	public void calculateMode() {

		HashMap<Integer, Integer> countValue = new HashMap<Integer, Integer>();
		HashSet<Integer> mode = new HashSet<Integer>();
		int prevVal = 0;
		boolean firstRun = true;
		
		for(int i = 0; i < this.inputIntArray.size(); i++)
		{
			int key = inputIntArray.get(i);
			if(countValue.containsKey(key))
			{
				countValue.put(key, countValue.get(key)+1);
			} else {
				countValue.put(key, 1);
			}
		}
	
		for(Entry<Integer, Integer> countValEntry : countValue.entrySet())
		{
			if(firstRun)
				prevVal = countValEntry.getValue();
			else
			{
				if(prevVal < countValEntry.getValue())
				{
					mode.clear();
					mode.add(countValEntry.getKey());
					prevVal = countValEntry.getValue();
				}
				else if(prevVal == countValEntry.getValue() && !mode.isEmpty())
					mode.add(countValEntry.getKey());
			}
			
			firstRun = false;
		}
		
		if(!mode.isEmpty())
		{
			System.out.println("Mode -");
			for(int indvMode : mode)
				System.out.print(indvMode + " | ");
		} else {
			System.out.println("No Mode");
		}
	}
	
	public void calculateStandardDeviation()
	{
		int sum = 0;
		for(int i = 0; i < this.inputIntArray.size(); i++)
		{
			int deviation = this.inputIntArray.get(i) - (int)this.mean;
			int squareDeviation = deviation * deviation;
			
			sum = sum + squareDeviation;
		}
		
		double avg = sum / (this.inputIntArray.size() - 1);
		
		double standardDeviation = java.lang.Math.sqrt(avg);
		System.out.println("standard Deviation : "+standardDeviation);
	}

	public static void main(String args[]) {
		String[] inputStrArray = { "22", "76", "43", "12", "44"};
		MeanMedianModeSD MeanMedianModeSD = new MeanMedianModeSD(inputStrArray);
		MeanMedianModeSD.calculateMean();
		System.out.println("Mean -" + MeanMedianModeSD.mean);
		MeanMedianModeSD.calculateMedian();
		System.out.println("Median -" + MeanMedianModeSD.median);
		MeanMedianModeSD.calculateMode();
		MeanMedianModeSD.calculateStandardDeviation();
		
	}
}
