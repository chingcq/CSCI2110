import java.util.ArrayList;
import java.util.Scanner;

//read words from keyboard, create binary tree assuming inputs are in level order
//print height, number of nodes, inorder, preorder, postorder and level order traversals
public class BinaryTreeDemo1 {

	public static void main(String[] args) {
		//get first input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter name or done: ");
		String input = keyboard.nextLine();
		//make an empty tree
		BinaryTree<String> tree=new BinaryTree<String>();
		//list - used to help create level order tree
		ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
		//if first input is "done", set tree empty
		//else, make root in tree, add the tree to list
		if(input.equals("done"))
			tree=null;
		else {
			tree.makeRoot(input);
			list.add(tree);
			//get second input
			System.out.print("Enter name or done: ");
			input = keyboard.nextLine();
		}
		//newNode
		BinaryTree<String> newNode;
		//while input not done
		while(!input.equals("done")) {
			//make newNode with input
			newNode=new BinaryTree<String>();
			newNode.makeRoot(input);
			//if list's first tree's left is null, attach newNode to left, and add newNode to list
			if(list.get(0).getLeft()==null) {
				list.get(0).attachLeft(newNode);
				list.add(newNode);
			}
			//node left full, but right is null, attach to right, and add newNode to list
			else if(list.get(0).getRight()==null) {
				list.get(0).attachRight(newNode);
				list.add(newNode);
			}
			//else, first tree in list is full, remove from list
			//add newNode to left of second tree (now first tree) in list, add newNode to list
			else {
				list.remove(0);
				list.get(0).attachLeft(newNode);
				list.add(newNode);
			}
			//get next input
			System.out.print("Enter name or done: ");
			input = keyboard.nextLine();
		}
		
		//displays methods
		System.out.print("Height of the tree: " + BinaryTree.height(tree));
		System.out.print("\nNumber of nodes in the tree: " + BinaryTree.nodes(tree));
		System.out.print("\nInorder:\t");
		BinaryTree.inorder(tree);
		System.out.print("\nPreorder:\t");
		BinaryTree.preorder(tree);
		System.out.print("\nPostorder:\t");
		BinaryTree.postorder(tree);
		System.out.print("\nLevelorder:\t");
		BinaryTree.levelOrder(tree);
	}
}
