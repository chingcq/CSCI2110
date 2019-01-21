/**A queue class based on ArrayList, it is first in first out and of generic type
 * @author david2
 *
 */

import java.util.ArrayList;

public class GenericQueue<T> {
	//fields
	private ArrayList<T> queue;
	int cursor;
	
	//constructor
	public GenericQueue() {
		queue = new ArrayList<T>();
		cursor = -1;
	}
	
	//enqueue adds item to end of queue
	public void enqueue(T item) {
		queue.add(item);
	}
	
	//dequeue removes item from front of queue and returns that item
	//checks if empty, if empty, return null
	//else, use ArrayList's remove method to remove item at front, which is at index 0
	//the remove method will shift everything behind first item by 1 place to front
	//remove method also returns the item removed, which is returned by dequeue
	public T dequeue() {
		if(queue.isEmpty())
			return null;
		else
			return queue.remove(0);
	}
	
	//size returns the number of items in the queue
	//implemented by ArrayList's size method
	public int size() {
		return queue.size();
	}
	
	//isEmpty returns true if queue is empty, uses ArrayList's isEmpty method
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	//clear method clears the queue
	//uses ArrayList's clear method
	public void clear() {
		queue.clear();
	}
	
	//peek returns the entry from the front of the queue, null if the queue is empty
	public T peek() {
		if(queue.isEmpty())
			return null;
		else
			return queue.get(0);
	}
	
	//positionOf returns the position of the specified item and -1 if not found
	public int positionOf(T item) {
		//ArrayList has an indexOf method which return position of item and -1 if not found
		return queue.indexOf(item);
	}
	
	//remove the first occurrence of the specified item
	public void remove(T item) {
		queue.remove(item);
	}
	
	//first returns the first item in the queue (which is at index 0), null if queue is empty
	//also resets cursor to 0
	public T first() {
		if(queue.isEmpty())
			return null;
		else
		{
			cursor = 0;
			return queue.get(cursor);
		}
	}
	
	//next return the next item in the queue relative to the previous call to first or next
	//returns null if end of queue is reached or if first was not called for at least 1 time or if queue is empty
	public T next() {
		if(cursor<0 || cursor==queue.size()-1 || queue.isEmpty())
			return null;
		else
		{
			cursor++;
			return queue.get(cursor);
		}
	}	
}
