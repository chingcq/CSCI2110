// This program asks user for a positive integer n, and finds which integer between 1 and n inclusive has the longest Collatz sequence
// and prints the starting number and the length of that sequence and the execution time of the code snippet

import java.util.Scanner;

public class CollatzSequence 
{
	public static void main (String[] args)
	{

		//The following gets n from user, the execution time is insignificant compared to the finding part, so its time is not measured
		//int size is enough for n = 10,000,000
		int n;
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter N: ");
		n = input.nextInt();
		
		//sequenceLength measures the longest sequence length
		int sequenceLength = 1;
		//the starting number for a sequence
		int startNum = 1;
		//the currentNum is the current number in the sequence, if it's even, it will divide by 2, else multiply by 3 and add 1
		long currentNum;
		
		//starts measuring time
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		//1 is skipped since it's the shortest sequence, starts with 2, and find sequence for every integer to n inclusive, with the for loop
		for (int i=2; i<=n; i++)
		{
			//length is the current length for the current sequence, starts at 1 since the first number is included in length
			int length = 1;
			//currentNum is the current number in the current sequence, in each loop, it is assigned the starting integer value
			currentNum = i;
			
			//as long as currentNum is not 1, the Collatz sequence continues
			while (currentNum != 1)
			{
				//if even, then /2
				if (currentNum % 2 == 0)
				{
					currentNum /= 2;
					//after operation, currentNum changes to next number in sequence, length increases
					length++;
				}
				//else off, then *3+1
				else
				{
					currentNum = currentNum*3 + 1;
					//length increases after operation
					length++;
				}
			}
			
			//after while loop finishes, which means currentNum is now 1 and Collatz sequence for i finished
			//if the length for sequence of i is larger than sequenceLength (the longest at the moment),
			//sequenceLength is updated, startingNum also updates to i
			if (length > sequenceLength)
			{
				sequenceLength = length;
				startNum = i;
			}
		}
		//after the for loop, every integers from 2 to n is looked at, the longest sequence is found
		
		//finish time measurement
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		
		
		//displays result
		System.out.println("For integers between 1 and N = " + n + ":\nThe longest Collatz sequence's starting number is " 
		                   + startNum + " and the length is " + sequenceLength + ".\nThe execution time is "
				           + executionTime + " ms.");
	}	
}