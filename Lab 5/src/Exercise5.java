import java.util.Scanner;

//writeVertical method and main method for exercise 5
public class Exercise5 {
	
	//display n's digits one digit per line, starting from left to right
	public static void writeVertical(int n) {
		//base case, if n is less than 10, just print n
		if(n<10)
			System.out.println(n);
		//recursive case, use /10 to reduce n, and use %10 to get each digit
		else {
			//calling writeVertical with n/10 first make sure print is from left to right of n
			//which means will start print at first digit on left, by diving n by 10 until it is less than 10
			writeVertical(n/10);
			//n modulo 10 gives the digit
			System.out.println(n%10);
		}
	}

	public static void main(String[] args) {
		//get n from user
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter positive integer n: ");
		int n = keyboard.nextInt();
		//calls method
		writeVertical(n);
	}

}
