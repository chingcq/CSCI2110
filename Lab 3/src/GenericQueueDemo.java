/**A demo program to tests the methods of GenericQueue class
 * @author david2
 *
 */

import java.util.Scanner;

public class GenericQueueDemo {

	public static void main(String[] args) {
		//Scanner object for getting inputs
		Scanner keyboard = new Scanner (System.in);
		
		//create queue of integers
		GenericQueue<Integer> intQ = new GenericQueue<Integer>();

		//Integer object a to store integer inputs
		Integer a;
		
		//gets integer inputs and enqueue them in intQ, stops asking for input when user provides 0, 0 is not enqueued
		System.out.println("Let's create a queue of Integers, provide Integers separated by enter, 0 to terminate: ");
		a = keyboard.nextInt();
		while(a!=0)
		{
			intQ.enqueue(a);
			a = keyboard.nextInt();
		}
		
		//tests size method
		System.out.println("Queue has " + intQ.size() + " items.");
		
		//tests isEmpty
		System.out.println("Queue isEmpty is " + intQ.isEmpty() + ".");
		
		//tests peek
		System.out.println("Peek queue gives " + intQ.peek() + ".");
		
		//tests first and next
		System.out.println("First in queue is " + intQ.first() + ".");
		System.out.println("Next in queue is " + intQ.next() + ".");
		System.out.println("Next in queue is " + intQ.next() + ".");
		System.out.println("First in queue is " + intQ.first() + ".");
		System.out.println("Next in queue is " + intQ.next() + ".");
		
		
		//tests position of
		System.out.println("Enter the integer you want to find from queue: ");
		int findThis = keyboard.nextInt();
		System.out.println(findThis + " is at index " + intQ.positionOf(findThis) + ".");
		
		//tests remove
		System.out.println("Enter the integer you want to remove from queue: ");
		int removeThis = keyboard.nextInt();
		intQ.remove(removeThis);
		System.out.println("Now, first in queue is " + intQ.first() + ".");
		System.out.println("Now, queue has " + intQ.size() + " items.");
		
		//tests dequeue and clear
		System.out.println("How many items you want to dequeue? Provide non-negative integers, if input >= size of queue, queue will be cleared.");
		int number = keyboard.nextInt();
		if(number>=intQ.size())
			intQ.clear();
		else
		{
			for(int i=0; i<number; i++)
				intQ.dequeue();
		}
		System.out.println("Now the queue has: " + intQ.size() + " items.");
		System.out.println("Queue isEmpty is " + intQ.isEmpty() + ".");
		System.out.println("Peek queue gives " + intQ.peek() + ".");

	}

}
