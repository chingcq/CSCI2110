import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

//program for lab 9
public class lab9 {
	
	public static void main(String[] args) throws FileNotFoundException {
		//create two empty HashMap with String key and String value
		//value is full name
		HashMap<String, String> name = new HashMap<String, String>();
		//value is password
		HashMap<String, String> pass = new HashMap<String, String>();
		
		//read file, get fullname, username, password, and add them to two HashMap
		System.out.print("Enter name of user info file: ");
		Scanner keyboard = new Scanner(System.in);
		String filename = keyboard.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String line, fullname, username, password;
		while(inputFile.hasNext()) {
			line = inputFile.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(line, "\t");
			fullname = tokenizer.nextToken();
			username = tokenizer.nextToken();
			password = tokenizer.nextToken();
			//add username, fullname to name
			name.put(username, fullname);
			//add username, password to pass
			pass.put(username, password);
		}
		inputFile.close();
		
		//prompt user to enter login name and password
		//count number of tries, have count = 1, 2, 3 which is 3 tries
		int count = 1;
		//boolean correct is whether password is correct
		boolean correct = false;
		while(count<4 && !correct) {
			//get username and password from user
			System.out.print("Login: ");
			username = keyboard.nextLine();
			System.out.print("Password: ");
			password = keyboard.nextLine();
			
			//check password
			//if password is correct for the username
			if(password.equals(pass.get(username))) {
				correct = true;
				System.out.println("\nLogin successful");
				System.out.println("Welcome " + name.get(username));
			}
			//if not correct
			else {
				//if failed first or second try
				if(count<3) {
					int attempts = 3 - count;
					System.out.println("\nEither the username or password is incorrect. You have " + attempts + " more attempts.\n");
				}
				//if failed third try
				else
					System.out.println("\nSorry. Incorrect login. Please contact the system administrator.");
				
				//count++ indicates next try
				count++;
			}
		}
		keyboard.close();
	}
}
