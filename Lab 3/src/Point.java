/**A generic Point class which has fields xpos and ypos, get and set methods and a toString method.
 * @author david2
 *
 */
public class Point<T> {

	//fields
	private T xpos;
	private T ypos;
	
	//constructor
	public Point (T x, T y) {
		xpos = x;
		ypos = y;
	}
	
	//get methods
	public T getX() {
		return xpos;
	}
	
	public T getY() {
		return ypos;
	}
	
	//set methods
	public void setX(T x) {
		xpos = x;
	}
	
	public void setY(T y) {
		ypos = y;
	}
	
	//toString method which returns xpos and ypos as a string
	public String toString() {
		String str = "XPOS: " + xpos + "\t YPOS: " + ypos;
		
		return str;
	}
	
}
