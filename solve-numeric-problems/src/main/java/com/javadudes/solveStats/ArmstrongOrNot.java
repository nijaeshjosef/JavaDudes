package com.javadudes.solveStats;

public class ArmstrongOrNot {
	
	int inputNum = 0;
	
	public ArmstrongOrNot(String inputStr) {

		this.inputNum = Integer.parseInt(inputStr);
	}
	
	public void checkArmStrongNumOrNot() {
		
		int num = this.inputNum;
		int digitSum = 0;
		while(num > 0)
		{
			int rem = num%10;
			System.out.println("rem : "+rem);
			digitSum = digitSum + (rem * rem * rem);
			num = num / 10;
		}
		System.out.println("digitSum : "+digitSum);
		
		if(digitSum == this.inputNum)
			System.out.println("ArmStrong Number");
		else 
			System.out.println("Not an ArmStrong Number");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArmstrongOrNot armstrongOrNot = new ArmstrongOrNot("153");
		armstrongOrNot.checkArmStrongNumOrNot();
	}

}
