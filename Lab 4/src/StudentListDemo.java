//demonstrates methods in StudentList class

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class StudentListDemo {

	public static void main(String[] args) throws IOException {
		
		//get file name
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		//open the file and use tokenizer
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		StringTokenizer token;
		
		//declare variables
		String line, idStr, FName, LName, Email, Major, Faculty;
		Student s;
		Integer idInt;
		StudentList students = new StudentList();
		
		//read Student info, break into tokens, store in above variables, construct Student object s, add to list
		while(inputFile.hasNext()) {
			line = inputFile.nextLine();
			token = new StringTokenizer(line, " ");
			idStr = token.nextToken();
			FName = token.nextToken();
			LName = token.nextToken();
			Email = token.nextToken();
			Major = token.nextToken();
			Faculty = token.nextToken();
			
			idInt = new Integer(idStr);
			
			s = new Student(idInt, FName, LName, Email, Major, Faculty);
			students.add(s);
		}
		
		inputFile.close();
		
		//test methods
		System.out.println("Students in Physics Major: ");
		students.displayInMajor("Physics");
		
		System.out.println("Students in Science Faculty: ");
		students.displayInFaculty("Science");
		
		//add a new made-up Student
		Student stdt = new Student(200199, "Ash", "Ketchum", "aketchum@email.com", "Pokemon Study", "Science");
		students.add(stdt);
		System.out.println("New student in science added.");
		
		//now display everyone in Science
		System.out.println("Students in Science Faculty: ");
		students.displayInFaculty("Science");
		
		//now delete made-up student
		students.delete(stdt);
		System.out.println("New student in science deleted.");
		
		//now display everyone in Science again
		System.out.println("Students in Science Faculty: ");
		students.displayInFaculty("Science");
		
		//now search for id 200120 and display index
		System.out.println("Index for ID 200120: ");
		System.out.println(students.searchID(200120));
		
		//now test search when item does not exist
		System.out.println("Index for ID 200199: ");
		System.out.println(students.searchID(200199));
		
		//now search for last name and first name and display index
		System.out.println("Index for Allison Page: ");
		System.out.println(students.searchName("Page", "Allison"));
		
		//now test search when item does not exist
		System.out.println("Index for Ash Ketchum: ");
		System.out.println(students.searchName("Ketchum", "Ash"));
		
		//now search for email and display index
		System.out.println("Index for jreid@email.com: ");
		System.out.println(students.searchEmail("jreid@email.com"));
		
		//now test search when item does not exist
		System.out.println("Index for notexist@email.com: ");
		System.out.println(students.searchEmail("notexist@email.com"));
	}

}
