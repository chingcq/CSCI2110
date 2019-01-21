//StudentList class - unordered list of Student objects

public class StudentList {
	
	//fields
	private List<Student> students;
	
	//constructor
	public StudentList() {
		students = new List<Student>();
	}
	
	//added this so I may check my code reads file correctly
	public void enumerate() {
		students.enumerate();
	}
	
	//add a Student to the list
	public void add(Student s) {
		students.add(s);
	}
	
	//delete the Student record identical to the argument Student
	public void delete(Student s) {
		students.remove(s);
	}
	
	//display records of all students taking argument major
	public void displayInMajor(String major) {
		//use s to store Student objects
		Student s=students.first();
		//loop through list with next, if major matches, print
		while(s!=null) {
			if (s.getMajor().equals(major))
				System.out.print(s);
			s=students.next();
		}
	}
	
	//display records of all students belonging to argument faculty
	//similar to the above method
	public void displayInFaculty(String faculty) {
		Student s=students.first();
		//print matched faculty in this method
		while(s!=null) {
			if(s.getFaculty().equals(faculty))
				System.out.print(s);
			s=students.next();
		}
	}
	
	//search for a Student with argument ID
	//use first and next with while loop, just like above methods
	//return index of the item, -1 if not found
	public int searchID(int id) {
		Student s=students.first();
		int index = 0;
		while(s!=null) {
			if(s.getID()==id)
				return index;
			s=students.next();
			index++;
		}
		
		return -1;
	}
	
	//search for a Student with argument last name and first name, return index
	public int searchName(String lastN, String firstN) {
		Student s=students.first();
		int index=0;
		
		while(s!=null) {
			if(s.getLName().equals(lastN) && s.getFName().equals(firstN))
				return index;
			s=students.next();
			index++;
		}
		
		return -1;
	}
	
	//search for a Student with argument email, return index
	public int searchEmail(String email) {
		Student s=students.first();
		int index=0;
		
		while(s!=null) {
			if(s.getEmail().equals(email))
				return index;
			s=students.next();
			index++;	
		}
		
		return -1;
	}
}
