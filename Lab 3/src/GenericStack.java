/**A stack class built with ArrayList, it is last in first out and of generic type
 * @author david2
 *
 */

import java.util.ArrayList;

public class GenericStack<T> {
	//fields
	private ArrayList<T> stack;
	
	//constructor
	public GenericStack() {
		stack = new ArrayList<T>();
	}
	
	//getSize returns number of objects in stack, which is also the size of the ArrayList stack
	public int getSize() {
		return stack.size();
	}
	
	//peek returns the object at the top of the stack
	//first checks if stack is empty, returns null if empty
	//the index for the top object is stack.size()-1
	//uses ArrayList's get method with the index of top object to get it and returns it
	public T peek() {
		if(stack.isEmpty())
			return null;
		else
			return stack.get(stack.size()-1);
	}
	
	//pop removes the top object
	//first checks if stack is empty, returns null if empty
	//the index for top object is stack.size()-1
	//uses ArrayList's remove method to remove the top object from stack with the index
	//the remove method will return the reference to the object removed, which is returned again by pop
	public T pop() {
		if(stack.isEmpty())
			return null;
		else
			return stack.remove(stack.size()-1);
	}
	
	//push adds the argument object to the top of the stack
	//ArrayList's add method adds the object to the top of the ArrayList
	public void push(T element) {
		stack.add(element);
	}
	
	//isEmpty return true if stack is empty
	//uses ArrayList's isEmpty method and returns the result
	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
