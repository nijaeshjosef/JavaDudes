package com.javadudes.solvefactors;

public class Factorial {

	int inputNum = 0;
	int factorial = 0;
	
	public Factorial(String inputStr) {

		this.inputNum = Integer.parseInt(inputStr);
	}
	
	public int recursiveFactorial(int n) {
		
		if(n == 0 || n == 1)
			return 1;
		else
			return n * recursiveFactorial(n-1);
	}
	
	public void iterativeFactorial(int n)
	{
		int factorial = 1;
		while(n >= 0)
		{
			int num = (n == 0) ? 1 : n;
 			factorial = factorial * num;
			--n;
		}
		
		this.factorial = factorial;
		System.out.println("Factorial - Iterative : "+ factorial);
	}
	
	public void trailZerosFact()
	{
		int count = 0;
		int fact = this.factorial;
		while(fact % 10 == 0)
		{
			++count;
			fact = fact/10;
		}
		
		System.out.println("Trailing zeroes of n! : "+count);
	}
	
	public void lastNonZeroDigit()
	{
		int nonZeroNum = 0;
		int fact = this.factorial;
		while(fact % 10 == 0)
		{
			fact = fact/10;
		}
		
		nonZeroNum = fact%10;
		System.out.println("Last Non Zero Digit : "+nonZeroNum);
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Factorial fact = new Factorial(args[0]);
		int recursiveFact = fact.recursiveFactorial(fact.inputNum);
		System.out.println("Factorial - Recursive : "+ recursiveFact);
		fact.iterativeFactorial(fact.inputNum);
		fact.trailZerosFact();
		fact.lastNonZeroDigit();
		
	}

}
