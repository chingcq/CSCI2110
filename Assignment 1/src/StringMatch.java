/**StringMatch gets two strings, and tests if the 2nd string is contained in the 1st string and for how many times
 * it is not a match if the 2nd string is longer than the first
 * comparison is case sensitive
 * 
 */

import java.util.Scanner;

public class StringMatch {

	public static void main(String[] args) {
		//inputs
		Scanner input = new Scanner(System.in);
		String str, subStr;
		System.out.print("Enter a string: ");
		str = input.nextLine();
		System.out.print("Enter a substring: ");
		subStr = input.nextLine();
		
		//call strMatch method which returns number of times subStr is found in str
		int timesFound = strMatch(str, subStr);
		
		//display results accordingly
		if(timesFound>0)
			System.out.println("Substring " + subStr + " was found in " + str + " " + timesFound + " times");
		else
			System.out.println("No matches - substring " + subStr + " was not found in " + str);
		

	}
	
	/** strMatch takes two strings, checks how many times is subStr contained in str
	 * 
	 * @param str the string containing or not containing subStr
	 * @param subStr the substring contained or not in the str
	 * @return how many times subStr is contained in str
	 */
	public static int strMatch(String str, String subStr) {
		//index1 for str
		//index2 for subStr
		//count for number of times subStr in str
		int index1, index2, count=0;
		
		//loop through str
		for (int i=0; i<str.length(); i++) {
			//comparison start with ith char of str and 0th char of subStr
			index1 = i; 
			index2 = 0;
			//flag variable, assume same
			boolean same = true;
			//while did not reach end of subStr and same is true
			while (index2 < subStr.length() && same) {
				//checks if end of str is reached
				//if not end of str, and char at index1 and index2 are same
				if (index1<str.length() && str.charAt(index1)==subStr.charAt(index2)) {
					index1++;
					index2++;
				}
				//either reached end of str, or char not same, set same to false, this exits while
				else
					same = false;
			}
			//while exited, now if same is still true, means reached end of subStr and still same, so found subStr once
			//turn index1 back by 1 because after the last char in subStr is compared (is same), index1++ and index2++
			//then, index2 is out of bound (==length), index1 also ++ed, so index1 is at the first not compared char of str
			//index1 is at the right value, but at end of for loop, i++, so set index1 1 back
			//set i=index1 because the last several chars were same, so no need to return to i that are less than index1
			if (same)
			{
				i = index1-1;
				count++;
			}
		}
		return count;		
	}
	
}
