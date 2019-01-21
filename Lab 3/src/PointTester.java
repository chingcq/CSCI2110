/**
 * @author david2
 *
 */

import java.util.Scanner;

public class PointTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//creates scanner object
		Scanner input = new Scanner (System.in);
		
		//gets integers from user
		int int1, int2;
		System.out.println("Provide 2 integers, separated by enter: ");
		int1 = input.nextInt();
		int2 = input.nextInt();
		
		//creates Point object with integer inputs
		Point<Integer> point1 = new Point<Integer>(int1,int2);
		
		//gets doubles from user
		double db1, db2;
		System.out.println("Provide 2 doubles, separated by enter: ");
		db1 = input.nextDouble();
		db2 = input.nextDouble();
		
		//creates Point object with double inputs
		Point<Double> point2 = new Point<Double>(db1,db2);
		
		//gets strings from user
		String str1, str2;
		System.out.println("Provide 2 strings, separated by enter: ");
		//remove the newline char
		input.nextLine();
		str1 = input.nextLine();
		str2 = input.nextLine();
		
		//creates Point object with string inputs
		Point<String> point3 = new Point<String>(str1,str2);
		
		//displays toString result
		System.out.println(point1);
		System.out.println(point2);
		System.out.println(point3);
	}

}
