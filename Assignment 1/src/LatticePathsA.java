/**LatticePathsA generate path strings of N and E, stores them in ArrayList.
 * There are three methods:
 * binaryListMaker creates binary strings of 1s and 0s ranging from 0 to 2^(2*size)-1.
 * zeroesStr creates a string of zeroes, this is called in binaryListMaker to add leading zeroes
 * to binary strings so all strings are 2*size bits.
 * binaryToPath converts binary strings to path strings, basically change 0 to N, 1 to E
 */

import java.util.Scanner;
import java.util.ArrayList;

public class LatticePathsA {

	public static void main(String[] args) {
		
		//get input size
		System.out.println("Enter the lattice size: ");
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		
		//start measuring time
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		//binaryStrList stores binary strings
		//calls binaryStrListMaker method, which returns ArrayList of 2*size bits binary strings
		ArrayList<String> binaryStrList = binaryStrListMaker(size);
		
		//pathStrList stores path strings
		//calls binaryToPath method, which converts 2*size bits binary strings in binaryStrList to
		//2*size bits path strings
		ArrayList<String> pathStrList = binaryToPath(binaryStrList);
		
		//end measuring time
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		
		//display results
		System.out.println("The lattice paths are: " + pathStrList);
		System.out.println("There are " + pathStrList.size() + " paths");
		System.out.print("Execution time is: " + executionTime + " ms");

	}
	
	/** binaryStrListMaker, loops from 0 to 2^(2*size)-1,
	 * use if with bitCount to find numbers that contain size number of 1s 
	 * (which means also contains size number of 0s), 
	 * convert such numbers to binary strings
	 * check how many leading zeroes are needed for the binary strings to have 2*size bits
	 * use zeroesStr method to return a string of that many leading zeroes
	 * concatenate the binary string to the leading zeroes string
	 * this gives the binary strings with size number of zeroes, which is adequate representation of the path
	 * add these binary strings to ArrayList and returns ArrayList
	 * 
	 * @param size is size of the lattice, i.e. size x size lattice
	 * @return ArrayList containing binary strings
	 */
	public static ArrayList<String> binaryStrListMaker(int size){
		
		//for the binary strings
		ArrayList<String> binaryStrList = new ArrayList<String>();
		
		//for the binary string
		String binaryStr;
		
		//number of leading zeroes require to have 2*size bits for a string
		int leadingZeroes;
		
		//loop from 0 to 2^(2*size)-1
		for(int i=0;i<Math.pow(2, 2*size);i++)
		{
			//make sure only convert i with size number of 1s or 0s
			//because number of N and E should be same, which is size
			if(Integer.bitCount(i)==size)
			{
				//create a binary string from the number
				//likely missing leading zeroes
				binaryStr = Integer.toBinaryString(i);
				//check how many leading zeroes missing
				leadingZeroes = 2*size - binaryStr.length();
				//create a string of leading zeroes and concatenate with binary string
				binaryStr = zeroesStr(leadingZeroes) + binaryStr;
				//add the 2*size bits string to ArrayList
				binaryStrList.add(binaryStr);
			}
		}
		//return the list;
		return binaryStrList;
	}
	
	/** this method creates a string of zeroes
	 * @param leadingZeroes number of leading zeroes needed
	 * @return String containing leadingZeroes number of zeroes
	 */
	public static String zeroesStr (int leadingZeroes) {
		String zeroesStr = "";
		//add argument number of zeroes
		for(int i=0;i<leadingZeroes;i++) {
			zeroesStr = zeroesStr + "0";
		}
		return zeroesStr;	
	}
	
	/** this method converts binary strings (1 and 0) to path strings (N and E)
	 * 
	 * @param binaryStrList ArrayList containing binary strings
	 * @return ArrayList containing path strings
	 */
	public static ArrayList<String> binaryToPath(ArrayList<String> binaryStrList){
		
		//use size of argument ArrayList in declaration, I think this can make program faster
		ArrayList<String> pathStrList = new ArrayList<String>(binaryStrList.size());
		
		//loops while binary ArrayList is not empty
		while(!binaryStrList.isEmpty())
		{
			//remove strings from binary list to get the string and reduce storage use
			String binaryStr = binaryStrList.remove(0);
			//first, replace 0 with N
			String pathN = binaryStr.replaceAll("0", "N");
			//then, replace 1 with E
			String path = pathN.replaceAll("1", "E");
			//add path string to path list
			pathStrList.add(path);
		}
		
		return pathStrList;
	}

}
