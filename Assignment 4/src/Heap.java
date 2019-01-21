import java.util.ArrayList;

public class Heap<T extends Comparable<T>>
{
	ArrayList<T> heapList;
	
	public Heap()
	{
		heapList = new ArrayList<T>();
	}
	
	//Assignment 4 methods
	
	//returns the key with smallest priority
	public T findMin() {
		//empty heap case
		if(heapList.isEmpty())
			return null;
		//in heap, smallest key is in leaf node
		//leaf nodes' start index is index of parent of rightmost leaf node on last level + 1
		//leaf nodes' end index is size - 1
		//just have to check these keys
		int lastLeaf = heapList.size()-1;
		int firstLeaf = (lastLeaf-1)/2+1;
		//set first minKey to root
		T minKey = heapList.get(0);
		//find minKey by comparing all leaf nodes
		for(int i = firstLeaf; i<=lastLeaf; i++) {
			if(heapList.get(i).compareTo(minKey)<0)
				minKey = heapList.get(i);
		}
		//return minKey
		return minKey;
	}
	
	//returns key with smallest priority and also deletes it
	//can't use findMin directly because it only returns the key, not the index
	public T dequeueMin() {
		
		//this code block is basically the same as findMin, but it returns key and index
		if(heapList.isEmpty()) {
			System.out.println("Heap is empty");
			return null;
		}
		int lastLeaf = heapList.size()-1;
		int firstLeaf = (lastLeaf-1)/2+1;
		T minKey = heapList.get(0);
		int minIndex = 0;
		for(int i = firstLeaf; i<=lastLeaf; i++) {
			if(heapList.get(i).compareTo(minKey)<0) {
				minKey = heapList.get(i);
				minIndex = i;
			}
		}
		
		//remove last item, put it in place of minIndex
		T item = heapList.remove(heapList.size()-1);
		//if last item is minIndex, no need to sift
		if(minIndex==heapList.size())
			return minKey;
		heapList.set(minIndex, item);
		
		//sift item up, same algorithm as add, compare item with its parent
		int index = minIndex;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);
		while(index>0 && item.compareTo(parent)>0) {
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
		//return minKey, the dequeued item
		return minKey;
	}
	
	
	public int size()
	{
		return heapList.size();
	}
	
	public boolean isEmpty()
	{
		return heapList.isEmpty();
	}
	
	public void clear()
	{
		heapList.clear();
	}
	public void enumerate()
	{
		System.out.println(heapList);
	}
	
	public void add(T item)
	{
		heapList.add(item);
		
		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);
		
		while (index>0 && item.compareTo(parent)>0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}
	
	public T deleteMax()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return null;
		}
		
		else
		{
			T ret = heapList.get(0);	//get the item in the root. This is the largest item.
			
			T item = heapList.remove(heapList.size()-1);	//remove the last item.
			
			if (heapList.size()==0)
				return ret;						//if there was only one item in the heap to begin with, we are done.
				
			heapList.set(0, item);			//otherwise, proceed. Put the item in the root.
			int index, lIndex, rIndex, maxIndex;
			T maxChild;
			boolean found=false;
			index = 0;
			lIndex = index*2+1;
			rIndex = index*2+2;
			
			while (!found)
			{
				if (lIndex<size()&&rIndex<size())	//case 1: item to be sifted down has two children
				{
					//find the maxChild and maxIndex
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex))>0)
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}
					
					//sift down if necesssary
					if (item.compareTo(maxChild)<0)
					{
						heapList.set(maxIndex, item);
						heapList.set(index, maxChild);
						index = maxIndex;
					}
					else
						found = true;
				}
						
				else if (lIndex < size()) //case 2: item to be sifted down has only left child
				//note: item to be sifted down cannot have only right child - it will violate the complete binary tree property
				{
					if (item.compareTo(heapList.get(lIndex))<0)
					{
						heapList.set(index, heapList.get(lIndex));
						heapList.set(lIndex,item);
						
						index = lIndex;
					}
				
					else
						found = true;
				}
				else //case 3: item to be sifted down has no children
					found = true;
						
				lIndex = index*2+1;
				rIndex = index*2+2;
			}
			return ret;
		}

	}			

}