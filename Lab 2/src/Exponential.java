//This program asks for input n, and generates 2^n binary numbers, and displays the execution time

import java.util.Scanner;

public class Exponential 
{
	public static void main (String[] args)
	{
		//gets inputs
		Scanner input = new Scanner(System.in);
		int n;
		System.out.println("Enter the value of n: ");
		n = input.nextInt();
		
		//string sb to store binary numbers generated
		String sb;
		
		//starts measuring time
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		//creates integers from 0 to 2^n-1, converts them to binary numbers and stores them in string sb
		for (int i=0; i<((int)Math.pow(2.0, n)-1); i++)
			sb = Integer.toBinaryString(i);
		
		//finishes measuring time
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		 
		//prints result
		System.out.println("Execution time to generate 2^" + n + " binary numbers: " + executionTime + " millisecs");
	}
}
