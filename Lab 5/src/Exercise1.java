import java.util.Scanner;

//methods and main method for problems in exercise 1
public class Exercise1 {
	//find nth Fibonacci number
	public static int fib(int n){
		//base case
		if(n==0)
			return 0;
		//base case
		else if(n==1)
			return 1;
		//recursive case
		else
			return fib(n-1)+fib(n-2);
	}
	
	
	//finds n factorial
	public static int factorial(int n) {
		//base
		if(n==0)
			return 1;
		//recursive
		else
			return n*factorial(n-1);
	}
	
	//finds value of x to the power of n
	public static int power(int x, int n) {
		//base
		if(n==0)
			return 1;
		//recursive
		else
			return x*power(x,n-1);
	}
	
	//main method
	public static void main(String[] args) {
		//Print first 20 Fibonacci numbers
		System.out.print("First 20 Fibonacci Numbers: ");
		for(int i=0;i<20;i++)
			System.out.print(fib(i) + " ");
		
		//print factorial of 1 to 10
		System.out.print("\nFactorials of 1 to 10: ");
		for(int i=1;i<=10;i++)
			System.out.print(factorial(i) + " ");
		
		//get x, n from user and print x^n
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\nEnter x and n, separated by space: ");
		int x = keyboard.nextInt();
		int n = keyboard.nextInt();
		System.out.println(x + " to the power of " + n + " is: " + power(x,n));
	}

}
