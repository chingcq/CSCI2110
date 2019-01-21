/** This is the rectangle class.
 * @author David Cui 
 * */

public class Rectangle 
{
	private double xpos;
	private double ypos;
	private double width;
	private double height;
	
	//This is the constructor
	public Rectangle (double xpos, double ypos, double width, double height)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		this.width = width;
		this.height = height;		
	}
	
	//The following four mutator methods set the fields
	public void setXpos (double xpos)
	{
		this.xpos = xpos;
	}
	
	public void setYpos (double ypos)
	{
		this.ypos = ypos;
	}
	
	public void setWidth (double width)
	{
		this.width = width;
	}
	
	public void setHeight (double height)
	{
		this.height = height;
	}
	
	//The following four access methods get the fields
	public double getXpos ()
	{
		return xpos;
	}
	
	public double getYpos ()
	{
		return ypos;
	}
	
	public double getWidth ()
	{
		return width;
	}
	
	public double getHeight ()
	{
		return height;
	}
	
	/**This method returns true if argument rectangle r is contained inside this.rectangle, else return false
	 * The idea is the opposite corners of r must be bounded by corresponding opposite corners of this.rectangle. 
	 * There are two sets of opposite corners for each rectangle, but only one set of opposite corners needs to be 
	 * tested because the rectangle geometry given in this lab indicates that if one set of opposite corners is 
	 * contained, the other set must also be contained.
	 * @param r the argument rectangle
	 * @return return true if r is contained by this.rectangle, else return false
	 */
	public boolean contains (Rectangle r)
	{
		//In order to simplify the boolean expressions for readability, I decide to declare some variable
		//These extra steps will make the code slightly inefficient, but I think the readability is worth it
		double xpos2 = xpos + width;                       //x coordinate for the bottom right corner
		double ypos2 = ypos + height;                      //y coordinate for the bottom right corner
		double rxpos = r.getXpos();                        //xpos for r
		double rxpos2 = r.getXpos()+r.getWidth();          //xpos2 for r
		double rypos = r.getYpos();                        //ypos for r
		double rypos2 = r.getYpos()+r.getHeight();         //ypos2 for r
		
		//Tests if top left corner of r is bounded by top left corner of this.rectangle &&
		//if bottom right corner of r is bounded by bottom right corner of this.rectangle
		//If both are conditions are true, the rectangle r should be contained and the method returns true
		if ((rxpos >= xpos && rypos >= ypos)&&(rxpos2 <= xpos2 && rypos2 <= ypos2))
			return true;
		else
			return false;
	}
	
	/**This method returns true if argument rectangle touches this.rectangle, else return false.
	 * My algorithm is comparing each of the four sides of this.rectangle with the corresponding two parallel sides 
	 * of the argument rectangle. That means, comparing right side of this.rectangle with both right and left sides
	 * of rectangle r. 
	 * If the right or left side of this.rectangle has the same x as the right or left side of r. Or if the top or bottom
	 * side of this.rectangle has the same y as the top or bottom side of r. Then, the rectangles are touching.
	 * @param r argument rectangle
	 * @return true when this.rectangle touches r, else false.
	 */
	public boolean touches (Rectangle r)
	{
		//Begin with testing left side of this.rectangle with left or right side of rectangle r
		if (xpos == r.getXpos() || xpos == (r.getXpos()+r.getWidth()))
			return true;
		//If the above didn't return true, the left side of this.rectangle is not touching r
		//So, now test the right side of this.rectangle with right and left sides of r
		else if (xpos+width == r.getXpos() || xpos+width == r.getXpos()+r.getWidth())
			return true;
		//If left and right do not touch, now test the top side of this.rectangle with top and bottom of r
		else if (ypos == r.getYpos() || ypos == r.getYpos()+r.getHeight())
			return true;
		//If left, right and top do not touch, now test the bottom side of this.rectangle with top and bottom of r
		else if (ypos+height == r.getYpos() || ypos+height == r.getYpos()+r.getHeight())
			return true;
		//If all four sides of this.rectangle do not touch with r's corresponding sides, the rectangles are not touching
		else
			return false;
	}
}
