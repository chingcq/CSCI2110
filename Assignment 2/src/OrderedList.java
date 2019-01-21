import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//contains merge and main method for exercise 2
public class OrderedList<T extends Comparable<T>>
{
	//main method
	public static void main(String[] args) throws FileNotFoundException {
		//create three ordered lists
		OrderedList<String> list1 = new OrderedList<String>();
		OrderedList<String> list2 = new OrderedList<String>();
		OrderedList<String> list3 = new OrderedList<String>();
		
		//get first file name, open file
		Scanner keyboard = new Scanner(System.in);
		System.out.print("File name for first list: ");
		String filename = keyboard.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		//name stores names
		String name;
		//add names to list1
		while(inputFile.hasNext()) {
			name = inputFile.nextLine();
			//using insert method makes sure list1 will be ordered and without repeated items
			list1.insert(name);
		}
		
		//get second file name, open file, read and add names to list2
		System.out.print("File name for second list: ");
		filename = keyboard.nextLine();
		file = new File(filename);
		inputFile = new Scanner(file);
		while(inputFile.hasNext()) {
			name = inputFile.nextLine();
			list2.insert(name);
		}
		
		//merge list1 and list2
		list3 = merge(list1, list2);
		
		//display lists
		list1.enumerate();
		list2.enumerate();
		list3.enumerate();
	}
	
	//merge two OrderedLists to form another OrderedList, insert method is used for adding because it keeps list ordered and prevents repetition
	public static <T extends Comparable<T>> OrderedList<T> merge (OrderedList<T> list1, OrderedList<T> list2){
		//list3
		OrderedList<T> list3 = new OrderedList<T>();
		//cursors for list1 and list2
		int cursor1 = 0;
		int cursor2 = 0;
		//while both cursors are not out of bound
		//if any cursor is out of bound, exit while loop
		while(cursor1<list1.size() && cursor2<list2.size()) {
			//if item1 is less than item2, add item1 to list3, cursor1++
			if(list1.get(cursor1).compareTo(list2.get(cursor2)) < 0) {
				list3.insert(list1.get(cursor1));
				cursor1++;
			}
			//else if item1 is greater than item2, add item2 to list3, cursor2++
			else if(list1.get(cursor1).compareTo(list2.get(cursor2)) > 0) {
				list3.insert(list2.get(cursor2));
				cursor2++;
			}
			//else item1 equal item2, add item1 or item2, cursor1++ and cursor2++
			else {
				list3.insert(list1.get(cursor1));
				cursor1++;
				cursor2++;
			}			
		}
		
		//if cursor1 is out of bound, add remaining items in list2 to list3
		if(cursor1>=list1.size()) {
			while(cursor2<list2.size()) {
				list3.insert(list2.get(cursor2));
				cursor2++;
			}
		}
		//if cursor2 is out of bound, add remaining items in list1 to list3
		if(cursor2>=list2.size()) {
			while(cursor1<list1.size()) {
				list3.insert(list1.get(cursor1));
				cursor1++;
			}
		}
		
		return list3;
	}
	
	private ArrayList<T> elements;
	private int cursor;
	
	public OrderedList(int cap)
	{
		elements = new ArrayList<T>(cap);
		cursor=-1;
	}
	public OrderedList()
	{
		elements = new ArrayList<T>();
		cursor=-1;
	}
	public int size()
	{
		return elements.size();
	}
	public boolean isEmpty()
	{
		return elements.isEmpty();
	}
	public void clear()
	{
		elements.clear();
	}
	public T get(int pos)
	{
		if (pos<0||pos>=elements.size())
		{
			System.out.println("Index out of bounds");
			//System.exit(0);
			return null;
		}
		return elements.get(pos);
	}
	public T first()
	{
		if (elements.size()==0)
			return null;
		cursor=0;
		return elements.get(cursor);
	}
	public T next()
	{
		if (cursor<0||cursor==(elements.size()-1))
			return null;
		cursor++;
		return elements.get(cursor);
	}
	
	public void enumerate()
	{
		System.out.println(elements);
	}
	
	public int binarySearch(T item)
	{
		if (elements.size()==0)
			return -1;
			
		int lo=0, hi=elements.size()-1, mid=0;
		
		while (lo<=hi)
		{
			mid = (lo+hi)/2;
			int c = item.compareTo(elements.get(mid));
			if (c==0) return mid;
			if (c<0) hi = mid-1;
			if (c>0) lo = mid+1;
		}
		
		if (item.compareTo(elements.get(mid))<0)
			return (-(mid+1));
		else
			return (-(mid+2));
	}
	//add an item to the end of the ordered list
	//useful method for the two-finger walking algorithm
	public void add(T item)
	{
		elements.add(item);
		
	}
	
	public void insert(T t)
	{
		if (elements.size()==0)
		{
			elements.add(t);
			return;
		}
		int pos = binarySearch(t);
		if (pos>=0)
		{
			System.out.println("Item " + t + " already present");
			return;
		}
		else
			elements.add(-pos-1, t);
	}
	public void remove(T item)
	{
		int pos = binarySearch(item);
		if (pos<0)
		{
			System.out.println("No such element");
			//System.exit(0);
			return;
		}
		else
			elements.remove(pos);
			
	}
	public T remove(int pos)
	{
		return elements.remove(pos);
	}
	
}