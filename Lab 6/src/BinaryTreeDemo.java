import java.util.ArrayList;
import java.util.Scanner;

//This is just a starter demo program
//TODO: Get inputs from the user. Do not hardcode them.
public class BinaryTreeDemo
{
	public static void main(String[] args)
	{
		//get root from user, if user enters done, an empty tree will be made
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter root (done means empty tree): ");
		String root = keyboard.nextLine();
		BinaryTree<String> tree = new BinaryTree<String>();
		if(root.equals("done"))
			tree=null;
		else {
			tree.makeRoot(root);
			System.out.print("Now, what you enter will be interpreted as level order traversal for left subtree of root. \n");
			tree.attachLeft(newTree());
			System.out.print("Now, what you enter will be interpreted as level order traversal for right subtree of root. \n");
			tree.attachRight(newTree());
		}
		
		//test steps 1 - 4
		//nodes
		System.out.print("Number of nodes in the tree: " + BinaryTree.nodes(tree));
		//height
		System.out.print("\nHeight of the tree: " + BinaryTree.height(tree));
		//heightBalance
		System.out.print("\nIs tree height balanced: " + BinaryTree.checkBalance(tree));
		//level order
		System.out.print("\nLevelorder:\t");
		BinaryTree.levelOrder(tree);
		//other orders
		System.out.print("\nInorder:\t");
		BinaryTree.inorder(tree);
		System.out.print("\nPreorder:\t");
		BinaryTree.preorder(tree);
		System.out.print("\nPostorder:\t");
		BinaryTree.postorder(tree);
		
	}
	
	//return a tree created with user inputs interpreted as level order traversal
	//basically same code as in BinaryTreeDemo1, with small changes
	public static BinaryTree<String> newTree(){
		//get first input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter name or done: ");
		String input = keyboard.nextLine();
		//make an empty tree
		BinaryTree<String> tree=new BinaryTree<String>();
		//list - used to help create level order tree
		ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
		//if first input is "done", return empty tree
		//else, make root in tree, add the tree to list
		if(input.equals("done"))
			return null;
		else {
			tree.makeRoot(input);
			list.add(tree);
		}
		//newNode
		BinaryTree<String> newNode;
		//get second input
		System.out.print("Enter name or done: ");
		input = keyboard.nextLine();
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
		
		return tree;
	}
}