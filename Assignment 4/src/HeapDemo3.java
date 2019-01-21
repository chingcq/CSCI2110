import java.util.Scanner;

public class HeapDemo3<T extends Comparable<T>>{

	public static void main(String[] args) {
		//get heap1 from user
		Heap<Integer> heap1 = new Heap<Integer>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter positive integers into heap1 (-1 when done): ");
		Integer num = keyboard.nextInt();
		while (num!=-1)
		{
			heap1.add(num);
			num = keyboard.nextInt();
		}
		System.out.println("heap1: ");
		heap1.enumerate();
		//get heap2 from user
		Heap<Integer> heap2 = new Heap<Integer>();
		System.out.print("Enter positive integers into heap2 (-1 when done): ");
		num = keyboard.nextInt();
		while (num!=-1)
		{
			heap2.add(num);
			num = keyboard.nextInt();
		}
		System.out.println("heap2: ");
		heap2.enumerate();
		
		//merge heap1 and heap2 to heap3 and enumerate
		Heap<Integer> heap3 = merge(heap1, heap2);
		System.out.println("merged heap: ");
		heap3.enumerate();
	}
	//method for merging two heaps
	public static<T extends Comparable<T>> Heap<T> merge(Heap<T> heap1, Heap<T> heap2){
		//create result heap
		Heap<T> result = new Heap<T>();
		//copy larger heap to result heap
		//and add other heap to result heap
		if(heap1.size()>=heap2.size()) {
			while(!heap1.isEmpty())
				result.add(heap1.deleteMax());
			while(!heap2.isEmpty())
				result.add(heap2.deleteMax());
		}
		else {
			while(!heap2.isEmpty())
				result.add(heap2.deleteMax());
			while(!heap1.isEmpty())
				result.add(heap1.deleteMax());
		}
		//return result
		return result;
	}
	
}
