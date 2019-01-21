/** This test program asks input from user to create two Rectangle objects, r1 and r2.
 * Then, tests whether one rectangle contains the other rectangle. The program will display Contains:true if one rectangle
 * contains the other, it doesn't matter if r1 contains r2 or r2 contains r1.
 * Then, tests whether rectangles touch each other and displays result.
 * @author David Cui
 */

import java.util.Scanner;

public class RectangleTest 
{
	public static void main (String[] args)
	{
		//Variable declaration.
		double xpos, ypos, width, height;
		Scanner input = new Scanner (System.in);
		
		//Asks for xpos, ypos, width, height for r1.
		System.out.println("Please enter xpos, ypos, width, and height for one rectangle (with only spaces in between): ");
		xpos = input.nextDouble();
		ypos = input.nextDouble();
		width = input.nextDouble();
		height = input.nextDouble();
		
		//Create Rectangle object r1 with inputs.
	    Rectangle r1 = new Rectangle (xpos, ypos, width, height);
	    
	    //Asks for xpos, ypos, width, height for r2.
		System.out.println("Please enter xpos, ypos, width, and height for another rectangle (with only spaces in between): ");
		xpos = input.nextDouble();
		ypos = input.nextDouble();
		width = input.nextDouble();
		height = input.nextDouble();
		
		//Creates Rectangle object r2 with inputs.
		Rectangle r2 = new Rectangle (xpos, ypos, width, height);

		//Tests if r2 is inside r1 or if r1 is inside r2 and prints result.
		if (r1.contains(r2) || r2.contains(r1))
			System.out.println("Contains: True");
		else
			System.out.println("Contains: False");
		
		//Tests if r1 touches r2, which is the same as if r2 touches r1, and prints result. 
		if(r1.touches(r2))
			System.out.println("Touches: True");
		else
			System.out.println("Touches: False");
	}
}
