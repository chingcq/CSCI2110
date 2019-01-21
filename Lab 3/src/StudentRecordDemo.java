/**This program gets file name from user, open that file, reads first name, last name, and bannerID on each line of the file,
 * creates a StudentRecord object from inputs read each line, pushes the object into stack1.
 * Then, stack1 is popped until empty, and each popped object (StudentRecord)'s last name value is pushed into stack2.
 * Then, stack2 is popped until empty, and each popped object (last name in String) is displayed.
 * @author david2
 *
 */

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class StudentRecordDemo {

	public static void main(String[] args) throws IOException {
		//creates a stack object, stack1, to hold StudentRecord objects
		GenericStack<StudentRecord> stack1 = new GenericStack<StudentRecord>();
		
		//gets name of the file containing student records from user
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		//opens the file and uses tokenizer
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		StringTokenizer token;
		
		//reads student records from file line to line as long as file has next line
		while (inputFile.hasNext()){
			//stores each line in line
			String line = inputFile.nextLine();
			//splits line into firstName, lastName, bannerID, and stores into String variables
			token = new StringTokenizer(line, " ");
			String f = token.nextToken();
			String l = token.nextToken();
			String bString = token.nextToken();
			//converts bannerID from String to Integer object
			Integer bInt = new Integer(bString);
			//creates a student record object for the values read from this line
			StudentRecord recordRead = new StudentRecord(f, l, bInt);
			//pushes recordRead into stack1
			stack1.push(recordRead);
		}
		//after while loop, the records in the file are all pushed into stack1, closes file
		inputFile.close();
		
		//creates stack2 which holds String objects
		GenericStack<String> stack2 = new GenericStack<String>();
		
		//pops stack1 item by item, and pushes last names into stack2
		//keeps popping and pushing if stack1 is not empty
		while(!stack1.isEmpty()) {
			//this stacks1.pop() returns the top StudentRecord object popped
			//.getLastName() gets the last name from the StudentRecord object
			//last name is then pushed to stack2
			stack2.push(stack1.pop().getLastName());
		}
		
		//pops stack2 and displays the items
		while(!stack2.isEmpty()) {
			System.out.println(stack2.pop());
		}
	}
}
