/** DNAMatch gets filename for a file containing DNA sequence, gets a string, and checks how many times string present in file
 * 
 */

import java.util.Scanner;
import java.io.*;

public class DNAMatch {

	public static void main(String[] args) throws IOException {
		//get file name
		Scanner input = new Scanner(System.in);
		//System.out.print("Enter the filename to read from: ");
		//String filename = input.nextLine();
		//open file
		File file = new File ("Genome.txt");
		Scanner inputFile = new Scanner(file);
		
		//String genomeStr to store genome sequence from the file, concatenate every line of DNA in the file
		String genomeStr = "";
		while(inputFile.hasNext()) {
			genomeStr = genomeStr + inputFile.nextLine();
		}
		
		//get test string
		System.out.print("Enter the test string: ");
		String testStr = input.next();
		
		//starts measuring time
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		//calls strMatch method from StringMatch class to find number of times test string is present in DNA sequence
		int timesFound = StringMatch.strMatch(genomeStr, testStr);
		
		//finish time measurement
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		
		//display result accordingly
		if(timesFound>0)
			System.out.println("Substring " + testStr + " was found " + timesFound + " times");
		else
			System.out.println("Substring " + testStr + " was not found");
		System.out.println("Execution time for string matching: " + executionTime + " ms");
	}
}
