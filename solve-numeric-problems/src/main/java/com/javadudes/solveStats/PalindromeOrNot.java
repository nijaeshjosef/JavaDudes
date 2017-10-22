package com.javadudes.solveStats;

public class PalindromeOrNot {
	
	int inputNum = 0;
	
	public PalindromeOrNot(String inputStr) {

		this.inputNum = Integer.parseInt(inputStr);
	}
	
	public void checkForPalindrome() {
		
		String num = String.valueOf(this.inputNum);
		StringBuffer strbuf = new StringBuffer("");
		
		for(int i = num.length()-1; i >= 0; i--)
			strbuf.append(num.charAt(i));
		
		if(strbuf.toString().equalsIgnoreCase(num))
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");
	}
		

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		PalindromeOrNot palindromeOrNot = new PalindromeOrNot("12321");
		palindromeOrNot.checkForPalindrome();
		
		
	}

}
