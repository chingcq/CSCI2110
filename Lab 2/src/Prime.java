// This program asks user for a positive integer n, and displays the nth prime number, and the execution time of the code snippet.

import java.util.Scanner;

public class Prime 
{
	public static void main (String[] args)
	{

		//The following gets n from user, the execution time is insignificant compared to the finding part, so its time is not measured
		long n;
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter n: ");
		n = input.nextInt();

		//Starts measuring execution time
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		//Calls nthPrime method to find nth prime number
		long prime = nthPrime(n);
		
		//Ends measuring execution time
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		
		//Display nth prime number
		System.out.println(n + "th prime number is: " + prime);
		
		//Display executionTime
		System.out.println("Execution time in millisecs is: " + executionTime);
	}

	/**The method finds the nth prime number by using a while loop
	 * While primeCount (how many prime numbers found) did not reach n, the loop will increment number by 2, and test the number
	 * Firstly, number 3 will be tested, which means the prime 2 is skipped, so primeCount starts with 1 (2 is already found)
	 * number is incremented 2 each loop because all even numbers except 2 are not prime
	 * @param n the nth prime number is to be found
	 * @return return the nth prime number
	 */
	public static long nthPrime (long n)
	{
		long primeCount = 1;               //This counts how many prime number we found, start with 1 because prime number 2 is skipped
		long number = 1;                   //number is the number to test if prime or not, it will increment in each loop
		
		while (primeCount < n)             //The loop terminates when primeCount = n, so found nth prime
		{
			//The first number to test is 3, which is the 2nd prime number
			//This is why primeCount starts with 1
			//number will increment by 2, because all even numbers other 2 are not prime
			number += 2;
			//If number is prime, primeCount will increment
			if (isPrime (number))
				primeCount++;
		}
		
		//This is added for the special case if n is 1, the 1st prime number should be 2
		if (n == 1)
			return 2;
		else
			return number;
	}
	
	/**The method checks if a number is prime by dividing the number by integers from 3 to sqrt of the number (rounded down)
	 * Divisor starts from 3 because all numbers modulo 1 is 0, and based on my program, number is always odd, so no need to divide by 2
	 * Divisor will increment by 2 because if the number is divisible by even numbers greater than 2, then it should also be divisible by 2,
	 * since the numbers are all odd in this case, they will not be divisible by even numbers, and they can be skipped
	 * Only divisors up to sqrt of the number are tested, because the divisors lower than sqrt of the number are complement to the divisors higher
	 * @param number number is to test if it's prime
	 * @return return true if number is prime
	 */

	public static boolean isPrime (long number)
	{
		for (int i = 3; i*i <= number; i+=2)
		{
			//If number modulo i is zero, it means number is not prime
			if (number % i == 0)
				return false;
		}
		//If number is not divisible by the divisors from 3 to sqrt of number, it is prime
		return true;
	}

}
