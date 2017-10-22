package com.javadudes.solvefactors;

public class Fibonnaci {

	int inputNum = 0;
	
	public Fibonnaci(String inputStr) {

		this.inputNum = Integer.parseInt(inputStr);
	}
	
	public int recursiveFibonnaci(int n) {
		
		if(n <= 1)
			return n;
		else
			return recursiveFibonnaci(n-2) + recursiveFibonnaci(n-1);
	}
	
	public void iterativeFibonnaci(int n)
	{
		int initVal = 0;
		int fib = 1;
		for(int i = 2; i <= n; i++)
		{
			int temp = fib;
			fib = initVal + fib;
			initVal = temp;
		}
		
		System.out.println("Fibonnaci - Iterative : "+ fib);
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Fibonnaci fib = new Fibonnaci(args[0]);
		int recursiveFib = fib.recursiveFibonnaci(fib.inputNum);
		System.out.println("Fibonnaci - Recursive : "+ recursiveFib);
		fib.iterativeFibonnaci(fib.inputNum);
		
	}

}
