import java.util.Scanner;

//countDown and main method for exercise 2
public class Exercise2 {
	
	//countDown from n, 0 is BlastOff
	public static void countDown(int n) {
		//base, BlastOff! when n reach 0
		if(n==0)
			System.out.print("BlastOff!");
		//recursive, print n and call again with n-1, n will eventually be 0
		else {
			System.out.print(n + " ");
			countDown(n-1);
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
