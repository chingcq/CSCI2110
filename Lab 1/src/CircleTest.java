/** This test program asks input from user to create two Circle objects, c1 and c2.
 * Then, tests whether one circle contains the other circle. The program will display Contains:true if one circle
 * contains the other, it doesn't matter if c1 contains c2 or c2 contains c1.
 * Then, tests whether circles touch each other and displays result.
 * @author David Cui
 */

import java.util.Scanner;

public class CircleTest 
{
	public static void main (String[] args)
	{
		double x, y, radius;
		Scanner input = new Scanner(System.in);
		
		//Asks for x, y, radius for first circle, c1
		System.out.println("Please enter x, y and radius for one circle (with only spaces in between): ");
		x = input.nextDouble();
		y = input.nextDouble();
		radius = input.nextDouble();
		
		//Creates Circle object c1
		Circle c1 = new Circle (x, y, radius);
		
		//Asks for inputs for c2
		System.out.println("Please enter x, y and radius for another circle (with only spaces in between): ");
		x = input.nextDouble();
		y = input.nextDouble();
		radius = input.nextDouble();
		
		//Creates object c2
		Circle c2 = new Circle (x, y, radius);
		
		//Tests if c1 contains c2 or c2 contains c1 and prints result
		if (c1.contains(c2) || c2.contains(c1))
			System.out.println("Contains: True");
		else
			System.out.println("Contains: False");
		
		//Tests if the circles touch, only need to test 1 time, since if c1 touches c2, then c2 touches c1
		if (c1.touches(c2))
			System.out.println("Touches: True");
		else
			System.out.println("Touches: False");
	}

}
