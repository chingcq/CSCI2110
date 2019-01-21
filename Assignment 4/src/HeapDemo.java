import java.util.Scanner;
public class HeapDemo
{
	public static void main(String[] args)
	{
		//read input and make heap
		Heap<Integer> myHeap = new Heap<Integer>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter positive integers into the heap (-1 when done): ");
		Integer num = keyboard.nextInt();
		while (num!=-1)
		{
			myHeap.add(num);
			num = keyboard.nextInt();
		}
		System.out.println("The heap: ");
		myHeap.enumerate();
		
		//test Assignment 4 methods
		//test findMin()
		System.out.println("findMin returns: " + myHeap.findMin());
		System.out.print("call dequeueMin? yes or no: ");
		keyboard.nextLine();
		//keep dequeue if input is yes
		String yn = keyboard.nextLine();
		while(yn.equals("yes")) {
			//test dequeueMin()
			System.out.println("dequeueMin returns: " + myHeap.dequeueMin());
			System.out.println("After dequeueMin(), Heap is: ");
			myHeap.enumerate();
			//test findMin() again
			System.out.println("findMin returns: " + myHeap.findMin());
			System.out.print("call dequeueMin? yes or no: ");
			yn = keyboard.nextLine();
		}
	}
}