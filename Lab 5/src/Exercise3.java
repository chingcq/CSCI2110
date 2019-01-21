import java.util.Scanner;

//modified countDown method and main method for exercise 3
public class Exercise3 {
	
	//countDown from n to 0 which is BlastOff
	//if n is even, only even numbers will be displayed, same for odd n
	public static void countDown(int n) {
		//base, changed from == to <=
		//because n might be -1
		if(n<=0)
			System.out.print("BlastOff!");
		//recursive, print n and call again with n-2, so even n leads to even n, odd leads to odd
		else {
			System.out.print(n + " ");
			//changed from n-1 to n-2
			countDown(n-2);
		}
	}

	public static void main(String[] args) {
		//get positive integer n
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter positive integer n: ");
		int n = keyboard.nextInt();
		//call countDown
		countDown(n);
	}

}
