import java.util.Scanner;

//multiples method and main method for exercise 4
public class Exercise4 {
	
	//finds first m multiples of integer n
	public static void multiples(int n, int m) {
		//base
		if(m==1)
			System.out.print(n + " ");
		//recursive, calls multiples with n and m-1
		//so, m, m-1, m-2, m-3, ... , 1 will used to call method
		//and in each call, n*m is printed
		else {
			multiples(n,m-1);
			System.out.print(n*m + " ");
		}
			
	}

	public static void main(String[] args) {
		//get n and m from users
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter n, the integer, and m, the number of multiples, separated by space: ");
		int n = keyboard.nextInt();
		int m = keyboard.nextInt();
		
		//calls recursive method
		multiples(n,m);
	}

}
