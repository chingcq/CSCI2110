import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

//hashtable for lab 8
public class hashtable {

	public static void main(String[] args) {
		//get table_size from user
		System.out.print("Enter the size of the hash table: ");
		Scanner keyboard = new Scanner(System.in);
		int table_size = keyboard.nextInt();
		
		//delcare arraylist of linkedlist of the input table size
		//linkedinlist store Integer
		ArrayList<LinkedList<Integer>> hashTable = new ArrayList<LinkedList<Integer>>(table_size);
		//create empty linkedlist objects and put in arraylist
		for(int i=0; i<table_size; i++) {
			LinkedList<Integer> l = new LinkedList<Integer>();
			hashTable.add(l);
		}
		
		//get number of keys from user
		System.out.print("Enter the number of keys to be hashed: ");
		int num = keyboard.nextInt();
		keyboard.close();
		
		//generate num number of random keys, hash map them
		Random rand = new Random();
		int key, pos;
		//num number of keys using for loop
		for(int i=0; i<num; i++) {
			//random number between 1 and 10000
			key = rand.nextInt(10000) + 1;
			//hash function to get pos of key
			pos = key % table_size;
			//add key to hashtable, add at front of linkedlist
			hashTable.get(pos).add(0, key);
		}
		
		//enumerate hash table, find number of collisions and longest list length
		int collision = 0, length = 0;
		System.out.println("Hash Table created: ");
		//iterate hashTable
		for(LinkedList<Integer> list: hashTable) {
			//enumerate linkedlist
			if(list.isEmpty())
				System.out.println("-->empty");
			else {
				//iterate linkedinlist and display
				for(Integer i: list)
					System.out.print("-->"+i);
				System.out.println("");
			}
			//number of collision
			//if list has more than 2 items, collision increase by size minus 1
			if(list.size() > 1)
				collision += list.size()-1;
			//longest list length
			//if list length exceeds current max length, update current max length
			if(list.size() > length)
				length = list.size();
		}
		//dispaly results
		System.out.println("Statistics: ");
		System.out.println("Table size: " + table_size);
		System.out.println("Number of keys: " + num);
		System.out.println("Load factor: " + (double)num/table_size);
		System.out.println("Number of collisions: " + collision);
		System.out.println("Longest list: " + length);
		
	}

}