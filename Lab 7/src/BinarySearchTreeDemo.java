import java.util.Scanner;

//demo for lab 7 methods
public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		//create BinarySearchTree with user inputs
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		Scanner input = new Scanner(System.in);
		System.out.println("Create a binary search tree of Strings.");
		System.out.print("Insert a String (stop to terminate): ");
		String str = input.nextLine();
		while(!str.equals("stop")) {
			bst.insert(str);
			System.out.print("Insert a String (stop to terminate): ");
			str = input.nextLine();
		}
		//test findMax
		System.out.println("Max is: " + bst.findMax());
		//test findMin
		System.out.println("Min is: " + bst.findMin());
		//test recursiveSearch
		System.out.print("Enter a String to search for: ");
		str = input.nextLine();
		BinaryTree<String> t = bst.recursiveSearch(str);
		if(t==null)
			System.out.println("String entered not found in binary search tree.");
		else
			System.out.println("This is data in the node found: " + t.getData());
		
		//make two binary tree to test isBinarySearchTree() method
		//A1 is BST
		BinaryTree<String> A1 = new BinaryTree<String>();
		BinaryTree<String> B1 = new BinaryTree<String>();
		BinaryTree<String> C1 = new BinaryTree<String>();
		BinaryTree<String> D1 = new BinaryTree<String>();
		A1.makeRoot("A");
		B1.makeRoot("B");
		C1.makeRoot("C");
		D1.makeRoot("D");
		A1.attachRight(B1);
		B1.attachRight(C1);
		C1.attachRight(D1);
		//A2 is not BST
		BinaryTree<String> A2 = new BinaryTree<String>();
		BinaryTree<String> B2 = new BinaryTree<String>();
		BinaryTree<String> C2 = new BinaryTree<String>();
		BinaryTree<String> D2 = new BinaryTree<String>();
		A2.makeRoot("A");
		B2.makeRoot("B");
		C2.makeRoot("C");
		D2.makeRoot("D");
		A2.attachLeft(B2);
		A2.attachRight(C2);
		C2.attachRight(D2);
		//test isBinarySearchTree()
		System.out.println("Two binary trees A1 and A2 are made, A1 is BST, A2 is not BST, now test isBinarySearchTree method:");
		System.out.println("Is A1 BST?\t" + BinarySearchTree.isBinarySearchTree(A1));
		System.out.println("Is A2 BST?\t" + BinarySearchTree.isBinarySearchTree(A2));
	}

}
