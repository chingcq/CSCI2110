import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HeapDemo2 {

	public static void main(String[] args) throws FileNotFoundException {
		//heap of Strings
		Heap<String> myHeap = new Heap<String>();
		
		//read from input file and add to heap
		System.out.print("Enter name of input file: ");
		Scanner keyboard = new Scanner(System.in);
		String filename = keyboard.nextLine();
		keyboard.close();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String str;
		while(inputFile.hasNext()) {
			str = inputFile.nextLine();
			myHeap.add(str);
		}
		inputFile.close();
		
		//remove max items from myHeap and write to output file
		PrintWriter outputFile = new PrintWriter("sorted.txt");
		while(!myHeap.isEmpty()) {
			str = myHeap.deleteMax();
			outputFile.println(str);
		}
		outputFile.close();
	}

}
