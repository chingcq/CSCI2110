//Binary Search Tree class
//uses the Binary Tree class
public class BinarySearchTree<T extends Comparable<T>>
//you are using the compareTo method on objects of type T; hence T should extend Comparable<T>
{
	private BinaryTree<T> tree;
	private int size;
	
	public BinarySearchTree()
	{
		tree = new BinaryTree<T>();
		size=0;
	}
	//lab 7
	
	//return largest key in binary search tree
	//this is a wrapper for the recursive findMax method, calls the recursive method with tree
	public T findMax() {
		return findMax(this.tree);
	}
	//recursive findMax method
	//larger nodes on right, largest one is when there is no longer a right child
	public T findMax(BinaryTree<T> t) {
		if(t.getRight()==null)
			return t.getData();
		else
			return findMax(t.getRight());
	}
	
	//return smallest key in binary search tree
	//similar algorithm except going left instead because small nodes are on left
	public T findMin() {
		return findMin(this.tree);
	}
	//recursive findMin method
	public T findMin(BinaryTree<T> t) {
		if(t.getLeft()==null)
			return t.getData();
		else
			return findMin(t.getLeft());
	}
	
	//driver method for recursive search
	public BinaryTree<T> recursiveSearch(T key){
		if(tree.isEmpty())
			return null;
		else
			return recursiveSearch(tree, key);
	}
	//recursive method for recursive search
	public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key){
		//reached empty tree, key not found
		if(t==null)
			return null;
		//compareTo return 0, found, return t
		if(key.compareTo(t.getData())==0)
			return t;
		//compareTo return negative, key smaller, go to left child
		else if(key.compareTo(t.getData())<0)
			return recursiveSearch(t.getLeft(), key);
		//compareTo return positive, key larger, go to right child
		else
			return recursiveSearch(t.getRight(), key);
	}
	
	//method that determines whether a binary tree is BST
	//uses two other recursive method to check if a subtree's values are all smaller or larger
	public static <T extends Comparable<T>> boolean isBinarySearchTree(BinaryTree<T> t) {
		//reached null, return true
		if(t==null)
			return true;
		//return statement includes 4 conditions in &&
		//-is left subtree's values all smaller
		//-is right subtree's values all larger
		//-are nodes in left subtree all BST
		//-are nodes in right subtree all BST
		return isSubtreeSmaller(t.getLeft(), t.getData()) && isSubtreeLarger(t.getRight(), t.getData()) && isBinarySearchTree(t.getLeft()) && isBinarySearchTree(t.getRight());
	}
	//check if values in a subtree are all smaller than value
	public static <T extends Comparable<T>> boolean isSubtreeSmaller(BinaryTree<T> t, T value) {
		//reached null, no value to compare, return true
		if(t==null)
			return true;
		//if data value is smaller than value, keep checking left and right child with same value
		if(t.getData().compareTo(value)<0)
			return isSubtreeSmaller(t.getLeft(), value) && isSubtreeSmaller(t.getRight(), value);
		//if data value not larger than value, return false
		else
			return false;
			
	}
	//check if values in a subtree are all larger than value
	public static <T extends Comparable<T>> boolean isSubtreeLarger(BinaryTree<T> t, T value) {
		//reached null, no value to compare, return true
		if(t==null)
			return true;
		//if data value is larger than value, keep checking left and right child with same value
		if(t.getData().compareTo(value)>0)
			return isSubtreeLarger(t.getLeft(), value) && isSubtreeLarger(t.getRight(), value);
		//if data value not larger than value, return false
		else
			return false;
	}
	
	
	
	public BinaryTree<T> getTree()
	{
		return tree;
	}
	public boolean isEmpty()
	{
		return tree.isEmpty();
	}
	public int size()
	{
		return size;
	}
	public BinaryTree<T> search(T key)
	{
		BinaryTree<T> t = tree;
		if (isEmpty()) return null;
		while (t!=null)
		{
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
		return null;
	}
		
		
	public void insert(T item)
	{
		BinaryTree<T> newNode = new BinaryTree<T>(); //sets left, right, parent and data to null
		newNode.setData(item);

		if (size==0){tree = newNode; size++;return;}
		
		BinaryTree<T> t = tree;
		boolean done = false;
		while (!done)
		{
			int c = item.compareTo(t.getData());
			if (c==0)
			{
				System.out.println("Duplicate key. Can't insert");
				return;
			}
			else if (c<0) //need to go left
			{
				if (t.getLeft()==null)	//place to insert found
				{
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
					t = t.getLeft(); //otherwise go left one branch
			}
			else //c>0; need to go right
			{
				if (t.getRight()==null) //place to insert found
				{
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}
		}
	}
	
	public BinaryTree<T> findPredecessor(BinaryTree<T> node)
	{
		if (node==null) return null;
		if (node.getLeft()==null) return null;
		BinaryTree<T> pred = node.getLeft();
		while (pred.getRight()!=null)
			pred = pred.getRight();
		return pred;
	}
	
	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach)
	{
		if (deleteNode==null) return;
		BinaryTree<T> parent = deleteNode.getParent();
		
		if (parent == null) return;
		if (attach == null)
		{
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}
		if (deleteNode==parent.getRight())
		{
			parent.detachRight();
			deleteNode.setParent(null);
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachRight(attach);
			attach.setParent(parent);
		}
		else
		{
			parent.detachLeft();
			deleteNode.setParent(null);
			
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachLeft(attach);
			attach.setParent(parent);
		}
		deleteNode.clear();
	}
	
	public void delete(T key)
	{
		if (size==0){System.out.println("Can't delete. Empty tree"); return;}
		BinaryTree<T> deleteNode = search(key);
		if (deleteNode==null) {System.out.println("Key not found. Can't delete"); return;}
		
		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null)
		{
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null)
		{
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
		else if (deleteNode.getRight()==null)
		{
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else
		{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}
		size--;
	}
}
	