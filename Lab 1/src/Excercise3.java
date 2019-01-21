/**This program asks the user for 5 points on a x-y plane, stores the x, y coordinates in a 2D array.
 * Then, passes the 2D array to a getRectangle method which returns the bounding rectangle for the 
 * points. Then, the center, width and height of the bounding rectangle is displayed.
 * @author David Cui
 */

import java.util.Scanner;

public class Excercise3 
{
	public static void main (String[] args)
	{
		double[][] points = new double[5][2];
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter " + points.length + " points: ");
		for (int i=0; i<points.length;i++)
		{
			points[i][0]=input.nextDouble();
			points[i][1]=input.nextDouble();
		}
		
		Rectangle boundingRectangle = getRectangle(points);
		
		//Calculates the boundingRectangle's center
		double xCenter = boundingRectangle.getXpos() + boundingRectangle.getWidth()/2;
		double yCenter = boundingRectangle.getYpos() + boundingRectangle.getHeight()/2;
		
		//Display center, width and height of boundingRectangle
		System.out.println("The bounding rectangle's center (" + xCenter + ", " + yCenter 
				                        + "), width " + boundingRectangle.getWidth() + ", height "
				           				+ boundingRectangle.getHeight() );
	}
	
	/**This method finds the xpos, ypos, width and height of the bounding rectangle for 
	 * the points stored in the 2D array points, constructs the rectangle and returns it
	 * @param points the 2D array storing 5 input points
	 * @return returns the bounding rectangle constructed
	 */
	public static Rectangle getRectangle(double[][] points)
	{
		//xposSmall, yposSmall are the smallest x and y, so they represent the top left corner of
		//the bounding rectangle.
		//xposLarge, yposLarge are the largest x and y, so they represent the bottom right corner.
		double xposSmall, yposSmall, xposLarge, yposLarge;
		
		//Initialize xposSmall and xposLarge as the x value for the first point
		//and initialize yposSmall and yposLarge as y value for the first point
		xposSmall = points[0][0];
		xposLarge = points[0][0];
		yposSmall = points[0][1];
		yposLarge = points[0][1];
		
		//The program loops from second point to last point, by changing the first index 
		//since the first index indicates which number we are working with
		//During each cycle, the program compares the x value of that number with xposSmall and xposLarge
		//and also compares y value for that number with yposSmall and yposLarge
		for (int i=1;i<points.length;i++)
		{
			//If the x value is smaller or larger, it becomes the new xposSmall or xposLarge, respectively
			if (points[i][0]<xposSmall)
				xposSmall = points[i][0];
			if (points[i][0]>xposLarge)
				xposLarge = points[i][0];	
			
			//If the y value is smaller or larger, it becomes the new yposSmall or yposLarge
			if(points[i][1]<yposSmall)
				yposSmall = points[i][1];
			if(points[i][1]>yposLarge)
				yposLarge = points[i][1];
		}
		//After the above loop, xposSmall contains smallest x value, xposLarge contains largest x,
		//yposSmall contains smallest y value, yposLarge contains largest y value
		

		//The boundingRectangle is created with xposSmall and yposSmall being the top left corner,
		//and the width is xposLarge - xposSmall, and height is yposLarge - yposSmall.
		Rectangle boundingRectangle = new Rectangle (xposSmall, yposSmall, xposLarge-xposSmall, yposLarge-yposSmall);
		
		return boundingRectangle;
	}
}
