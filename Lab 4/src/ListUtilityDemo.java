import java.util.Scanner;
import java.util.StringTokenizer;

public class ListUtilityDemo {

	public static void main(String[] args) {
		//Assume list contains single char strings
		
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		
		String str;
		
		Scanner input = new Scanner(System.in);
		StringTokenizer token;
		
		System.out.print("Please enter first list of strings (separated by space): ");
		str = input.nextLine();
		token = new StringTokenizer(str, " ");
		while(token.hasMoreTokens())
			list1.add(token.nextToken());
		
		System.out.print("Please enter second list of strings (separated by space): ");
		str = input.nextLine();
		token = new StringTokenizer(str, " ");
		while(token.hasMoreTokens())
			list2.add(token.nextToken());
		
		//reverse list1 and list2, otherwise ABC input will become CBA
		list1 = ListUtility.reverse(list1);
		list2 = ListUtility.reverse(list2);
		
		System.out.println("Union of List 1 and 2: ");
		ListUtility.findUnion(list1, list2).enumerate();
		
		System.out.println("\nIntersection of List 1 and 2: ");
		ListUtility.findIntersection(list1, list2).enumerate();
		
		System.out.println("\nInterleave of List 1 and 2: ");
		ListUtility.interleave(list1, list2).enumerate();
		
		System.out.println("\nChopSkip of List 1: ");
		ListUtility.chopSkip(list1).enumerate();
		
		System.out.println("\nChopSkip of List 2: ");
		ListUtility.chopSkip(list2).enumerate();
	}

}
