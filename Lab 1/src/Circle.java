/** This is the circle class.
 * @author david2
 */

public class Circle 
{
	//Fields x and y specifies center of circle
	private double x;
	private double y;
	private double radius;
	
	//Constructor creates a circle object with center x,y and radius radius
	public Circle (double x, double y, double radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	//Access methods for x, y, radius
	public double getX ()
	{
		return x;
	}
	
	public double getY ()
	{
		return y;
	}

	public double getRadius ()
	{
		return radius;
	}
	
	/**The contains method tests if circle c is inside this.circle and returns true if it is.
	 * The idea is, for circle c to be inside this.cicle, c's radius must be equal or smaller 
	 * than this.circle's radius, and the distance between the centers of the circles, centerDistance, 
	 * must be between 0 and the differenceRadius inclusive, where the differenceRadius is the 
	 * difference between the radius.
	 * @param c The argument circle
	 * @return true if c is inside this.circle, else return false
	 */
	public boolean contains (Circle c)
	{
		//The variables are isolated here to make the boolean expressions easier to read
		//centerDistance is the distance between centers
		//difference Radius is the difference between this.circle's radius and c's radius
		double centerDistance = Math.sqrt(Math.pow((x - c.getX()),2.0)+Math.pow(y - c.getY(),2.0));
		double differenceRadius = radius - c.getRadius();
		
		//If differenceRadius <0, it means c's radius is larger than this.radius, so c is not inside this.circle
		if(differenceRadius < 0)
			return false;
		//If the centerDistance is between 0 and differenceRadius inclusive, c is inside this.circle
		else if(centerDistance>=0&&centerDistance<=differenceRadius)
			return true;
		//Otherwise, c is not inside this.circle
		else
			return false;
	}
	
	/**The touches method tests if the argument circle c and this.circle touches.
	 * The circles touch if the distance between circle centers is the same as the sum of the 
	 * circle radiuses, or if the distance between centers is the same as the difference in 
	 * circle radiuses.
	 * @param c argument circle
	 * @return true if the circles touch
	 */
	public boolean touches (Circle c)
	{
		//These variables simplifies the boolean expression
		double centerDistance = Math.sqrt(Math.pow(x - c.getX(),2.0) + Math.pow(y - c.getY(),2.0));
		double sumRadius = radius + c.getRadius();
		//The abs method finds the absolute value of differenceRadius, so in the case of c1 is contained and
		//touched by c2, which means c1 radius is smaller than c2 radius, this method will return true as should.
		double differenceRadius = Math.abs(radius - c.getRadius());
		
		//If the distance between centers is equal to sum of radiuses, the circles are touching
		if(centerDistance == sumRadius || centerDistance == differenceRadius)
			return true;
		else
			return false;	
	}
}
