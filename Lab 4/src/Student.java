//Student class holds ID, fName, lName, email, major, faculty, constructor, toString, equals, get methods

public class Student {
	//fields: studentID, firstname, lastname, email, major, faculty
	private int studentID;
	private String fName, lName, email, major, faculty;
	
	//constructor
	public Student (int studentID, String fName, String lName, String email, String major, String faculty) {
		this.studentID=studentID;
		this.fName=fName;
		this.lName=lName;
		this.email=email;
		this.major=major;
		this.faculty=faculty;
	}
	
	//toString, formated
	public String toString() {
		return String.format("%-10d %-10s %-10s %-20s %-15s %s \n", studentID, fName, lName, email, major, faculty);
	}
	
	//equals method compares all fields for two Student being compared
	public boolean equals(Student other) {
		return (studentID==other.getID()&&fName.equals(other.getFName())&&lName.equals(other.getLName())&&email.equals(other.getEmail())&&major.equals(other.getMajor())&&faculty.equals(other.getFaculty()));
	}
	
	//get methods
	public int getID() {
		return studentID;
	}
	
	public String getFName() {
		return fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMajor() {
		return major;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	//set methods
	public void setID(int id) {
		studentID=id;
	}
	
	public void setFName(String fn) {
		fName=fn;
	}
	
	public void setLName(String ln) {
		lName=ln;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setMajor(String major) {
		this.major=major;
	}
	
	public void setFaculty(String faculty) {
		this.faculty=faculty;
	}
}