/**A small demo for GenericStack class
 * @author david2
 *
 */
public class GenericStackDemo {
	
	public static void main(String[] args) {
		//create stack1
		GenericStack<String> stack1 = new GenericStack<String>();
		//pushes 3 Strings
		stack1.push("London");
		stack1.push("Paris");
		stack1.push("Halifax");
		//tests getSize
		System.out.println(stack1.getSize());
		//tests pop
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		//tests getSize again
		System.out.println(stack1.getSize());
		//tests peek
		System.out.println(stack1.peek());
		//tests isEmpty
		System.out.println(stack1.isEmpty());
		//creates stack2
		GenericStack<Integer> stack2 = new GenericStack<Integer>();
		//tests push
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		//tests getSize
		System.out.println(stack2.getSize());
		//tests pop
		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
		//tests getSize
		System.out.println(stack2.getSize());
	}

}
