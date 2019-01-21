/**LatticePathsB uses methods in LatticePathsA to create an ArrayList containing the paths for a lattice of size input size
 * for each path string in path string list, replaceNE method will recursively replace NE with D to generate the diagonal path strings
 * replaceNE method will add the diagonal path strings to another list
 * in the end, two lists are added together
 */
import java.util.Scanner;
import java.util.ArrayList;

public class LatticePathsB {

	public static void main(String[] args) {
		//get size
		System.out.println("Enter the lattice size: ");
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		
		//start measuring time
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		//create binary strings in list using methods from A
		ArrayList<String> binaryStrList = LatticePathsA.binaryStrListMaker(size);
		//convert binary strings to path strings and put in list using methods from A
		ArrayList<String> pathStrList = LatticePathsA.binaryToPath(binaryStrList);
		//this new list will store diagonal path strings
		ArrayList<String> diagPathList = new ArrayList<String>();
		
		//for every path string in list
		for(int i=0; i<pathStrList.size(); i++){
			//call recursive method, see recursive method comments for detail
			//this will generate the diagonal path strings, and add to diagonal list
			//the inputs:
			//subPath1 will be "" for the first call for each non-diagonal path string
			//subPath2 will be the non-diagonal path string
			//diagPathList is the ArrayList to contain diagonal strings
			replaceNE("", pathStrList.get(i), diagPathList);
		}
		
		//add diagonal strings to non-diagonal path string list
		pathStrList.addAll(diagPathList);
		
		//end measuring time
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		
		//display results
		System.out.println("The lattice paths are: " + pathStrList);
		System.out.println("There are " + pathStrList.size() + " paths");
		System.out.print("Execution time is: " + executionTime + " ms");
	}
	
	
	/**replaceNE is a recursive method
	 * it basically looks for NE and replace to D
	 * a path string is broken to 2 parts, subPath1 (sub1) and subPath2 (sub2)
	 * sub1 contains the part which are already examined by the for loop for NE
	 * so for each replacement made, sub1 is the substring before and including the D just replaced
	 * sub2 is the substring after the D just replaced
	 * 
	 * the benefit of this division is that:
	 * when a replacement is made, the new path string is broken to 2 substrings, they are both used to call replaceNE method again
	 * but only sub2 is used for the for loop in the method, so only NEs in sub2 will be considered for replacements
	 * the NEs in sub1 are ones that have been replaced in previous calls and they are left alone in this way
	 * 
	 * note: only need to check for NE and replace NE, no need for EN, since for each NE replaced, 
	 * there will be a EN replaced that results in same path
	 * 
	 * @param subPath1 the substring before and includes newly replaced D
	 * @param subPath2 the substring after newly replaced D
	 * @param diagPathList the reference for the list, so newly generated paths may be added to it
	 */
	public static void replaceNE(String subPath1, String subPath2, ArrayList<String> diagPathList) {
		//base case, if sub2 does not contain NE, no replacement will be made, and no need to call again, just return
		if(!subPath2.contains("NE"))
			return;
		else {
			//else, sub2 contains 1 or more NE, need to replace
			//newPath for the string after replacement
			String newPath = "";
			//looks through every char of sub2, exclude the last char, because checking two consecutive chars
			for(int i=0; i<subPath2.length()-1; i++) {
				//if the char at i and char at i+1 make NE, replace it
				//there are 4 cases for the NE
				if(subPath2.charAt(i)=='N'&&subPath2.charAt(i+1)=='E') {
					//subPath2 contains NE and only has two chars
					if(subPath2.length()==2) {
						//new path is then just subPath1 + D
						newPath = subPath1 + "D";
						
						diagPathList.add(newPath);
						//only 2 char and they are NE, they are replaced, so nothing left, no need to call again
						return;
					}
					//the NE to be replaced is at beginning
					else if(i==0) {
						//replace the NE at the beginning with D, add it to subPath1, add the rest of sub2
						newPath = (subPath1 + "D") + subPath2.substring(i+2);
						
						diagPathList.add(newPath);
						
						//use the part of sub2 after the replaced NE to call method recursively
						//this takes care of other NE in sub2
						replaceNE((subPath1 + "D"), subPath2.substring(i+2), diagPathList);
					}
					//the NE to be replaced is at end
					else if(i==subPath2.length()-2){
						//add part of sub2 before the NE at the end to sub1, then, add D to end
						newPath = subPath1 + subPath2.substring(0, i) + "D";
						
						diagPathList.add(newPath);
						//NE at end means no more sub2, no need to call again
						return;
					}
					//the NE to be replaced is somewhere in middle
					else {
						//add part of sub2 before the NE to be replaced to sub1, add D, add part of sub2 after the NE
						newPath = (subPath1 + subPath2.substring(0, i) + "D") + subPath2.substring(i+2);
						
						diagPathList.add(newPath);
						
						//part of sub2 after the NE might contain more NE, so call method with it
						replaceNE((subPath1 + subPath2.substring(0, i) + "D"), subPath2.substring(i+2), diagPathList);
					}
				}
				//if char at i and i+1 not NE, or if NE already replaced, for loop will i++
			}
			//for loop finishes, meaning every char looked at, method finishes
			//return to main method, look at next string
		}
	}
}
