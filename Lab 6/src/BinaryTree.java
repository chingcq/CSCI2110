import java.util.ArrayList;

public class BinaryTree<T> 
{
	//fields
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	//constructor
	public BinaryTree()
	{
		parent = left = right = null;
		data = null;
	}
	
	//methods for Lab 6
	
	//step 1
	//find number of nodes
	public static <T> int nodes(BinaryTree<T> tree) {
		//base case, empty tree, zero node
		if (tree==null)
			return 0;
		//recursive case, 1 node plus nodes in left subtree plus nodes in right subtree
		else
			return 1 + nodes(tree.getLeft()) + nodes(tree.getRight());
	}
	
	//step 2
	//find height
	public static <T> int height(BinaryTree<T> tree) {
		//base case, empty tree, height -1
		if(tree==null)
			return -1;
		//recursive case, 1 plus height of left subtree or right subtree, whichever is higher
		else
			return 1 + Math.max(height(tree.getLeft()), height(tree.getRight()));
	}
	
	//step 3
	//checkBalance checks if tree is height balanced, contains an effective recursive method heightBalance which does the actual work
	//need this wrapper since the heightBalance method returns an int
	public static <T> boolean checkBalance(BinaryTree<T> tree) {
		int result = heightBalance(tree);
		//heightBalance will return -1 if tree is not height balanced
		if(result>-1)
			return true;
		else
			return false;
	}
	
	//step 3
	//heightBalance checks if tree is height balanced recursively, it returns an int, so it needs a wrapper
	//this method starts from the leaf nodes and "climb" up, leaf nodes are at height 0
	//each parent node to the leaf node adds to height by 1 (climb up by 1)
	//at each internal node, height of left subtree and right subtree is compared
	//if height differ by 0 or 1, the higher height is returned to its parent so its parent can compare its left and right subtrees
	//if height differ by more than 1, -1 is returned
	//if -1 is returned, the calling method also returns -1
	public static <T> int heightBalance(BinaryTree<T> tree) {
		//base case, empty tree, return 0
		if(tree==null)
			return 0;
		//recursively check if left subtree is balanced
		int leftHeight = heightBalance(tree.getLeft());
		//if leftHeight is -1, it means left subtree is not balanced, so also return -1
		if(leftHeight==-1)
			return -1;
		//recursively check if right subtree is balanced
		int rightHeight = heightBalance(tree.getRight());
		if(rightHeight==-1)
			return -1;
		//check if this subtree is balanced
		//if not balanced, return -1
		if(Math.abs(leftHeight-rightHeight)>1)
			return -1;
		//here, means all subtrees are balanced for this node, and this subtree is balanced
		//return the max height of this subtree, so the parent node can compare
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	//step 4
	//traverse tree with level order traversal
	public static <T> void levelOrder(BinaryTree<T> tree) {
		//empty tree, do nothing
		if(tree==null)
			return;
		//make empty list of trees
		ArrayList<BinaryTree<T>> level = new ArrayList<BinaryTree<T>>();
		//add tree root to list
		level.add(tree);
		//while level is not empty
		while(!level.isEmpty()) {
			//store first tree node in level in t
			BinaryTree<T> t = level.get(0);
			//display t
			System.out.print(t.getData() + "\t");
			//if t has a left child, add to level
			if(t.getLeft()!=null)
				level.add(t.getLeft());
			//if t has a right child, add to level
			if(t.getRight()!=null)
				level.add(t.getRight());
			//after added t's children, remove t
			level.remove(0);
			//now, while move to next in level, which is left child of t, then, right child of t, and etc.
		}
	}

	//make root
	public void makeRoot(T data)
	{
		if (!isEmpty())
		{
			System.out.println("Can't make root. Already exists");
		}
		else
			this.data = data;
	}
	//set methods
	public void setData(T data)
	{
		this.data = data;
	}
	public void setLeft(BinaryTree<T> tree)
	{
		left = tree;
	}
	public void setRight(BinaryTree<T> tree)
	{
		right = tree;
	}
	public void setParent(BinaryTree<T> tree)
	{
		parent = tree;
	}
	//get methods
	public T getData()
	{
		return data;
	}
	public BinaryTree<T> getParent()
	{
		return parent;
	}
	public BinaryTree<T> getLeft()
	{
		return left;
	}
	public BinaryTree<T> getRight()
	{
		return right;
	}
	//attach methods
	public void attachLeft(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (left!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{
			tree.setParent(this);
			this.setLeft(tree);
		}
	}
	public void attachRight(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (right!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{
			tree.setParent(this);
			this.setRight(tree);
		}
	}
	//detach methods
	public BinaryTree<T> detachLeft()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft!=null) retLeft.setParent(null);
		return retLeft;
	}
	public BinaryTree<T> detachRight()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retRight = right;
		right = null;
		if (retRight!=null) retRight.setParent(null);
		return retRight;
	}
	//is Empty
	public boolean isEmpty()
	{
		if (data == null)
			return true;
		else
			return false;
	}
	//clear tree
	public void clear()
	{
		left = right = parent =null;
		data = null;
	}
	//go back to root
	public BinaryTree<T> root()
	{
		if (parent == null)
			return this;
		else
		{
			BinaryTree<T> next = parent;
			while (next.getParent()!=null)
				next = next.getParent();
			return next;
		}
	}
	//preorder traversal
	public static <T> void preorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			System.out.print(t.getData()+"\t");
			preorder(t.getLeft());	
			preorder(t.getRight());
		}
	}
	//inorder traversal
	public static <T> void inorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}
	//postorder traversal
	public static <T> void postorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}
}