/**A StudentRecord class that holds three attributes:
 * String firstName, String lastName, int bannerID
 * Also has get, set, and toString methods
 * @author david2
 *
 */
public class StudentRecord {
	//fields
	private String firstName;
	private String lastName;
	private int bannerID;
	
	//constructor
	public StudentRecord(String f, String l, int b) {
		firstName = f;
		lastName = l;
		bannerID = b;
	}
	
	
	//get methods
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getBannerID() {
		return bannerID;
	}

	//set methods
	public void setFirstName(String f) {
		firstName = f;
	}
	
	public void setLastName(String l) {
		lastName = l;
	}
	
	public void setBannerID(int b) {
		bannerID = b;
	}

	//toString method
	public String toString() {
		String str = "First Name: " + firstName + " Last Name: " + lastName + " BannerID: " + bannerID;
		return str;
	}
}
