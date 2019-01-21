import java.util.Scanner;

//squares method and main method for exercise 6
public class Exercise6 {
	
	//display the value of sum of squares of all integers up to n
	public static int squares(int n) {
		//base case, when n is 1, 1^2 is 1, and there is no smaller integers, just return 1
		if(n==1)
			return 1;
		//recursive case, calls method again with n-1, and return n^2 with the value returned by method
		//therefore, the final value returned will be n^2 + (n-1)^2 + (n-2)^2 + ... + 1^2
		else {
			return n*n+squares(n-1);
		}
	}

	public static void main(String[] args) {
		//get positive integer n from user
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter positive integer n: ");
		int n = keyboard.nextInt();
		//display value of sum of squares of all integers up to n
		System.out.println("Value of sum of squares is: " + squares(n));
	}

}
