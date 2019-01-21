//ListUtility class contains static methods used to operate lists

public class ListUtility<T> {
	
	//return list3 which contains items either in list1 or list2 or both, but no duplicates are in list3
	public static <T> List<T> findUnion(List<T> list1, List<T> list2){
		
		//create list3
		List<T> list3 = new List<T>();
		
		//create item which stores items from the list
		//start with the first item in list1
		T item = list1.first();
		
		//use while loop and next to go through every item in list1
		//if the item is not in list3 already, it is added to list3
		while(item!=null) {
			if(!list3.contains(item))
				list3.add(item);
			item=list1.next();
		}
		
		//after list1 is finished, repeat the same while loop with list2
		//look at every item in list2, if not already in list3, it is added
		item = list2.first();
		while(item!=null) {
			if(!list3.contains(item))
				list3.add(item);
			item=list2.next();
		}
		
		//return the reversed version, because during above process, first will become last
		//the reversed list3 is better looking
		return reverse(list3);
	}
	
	//return list3 which contains items common to both list1 and list2, no duplicates in list3
	public static <T> List<T> findIntersection(List<T> list1, List<T> list2){
		List<T> list3 = new List<T>();
		
		//the first while loop get every item in list1
		//then for each of the item, there is a second while loop
		T item1 = list1.first();
		while(item1!=null) {
			//the second while loop get every item in list2
			//so every item in list2 is compared to each item in list1
			//if the items are equal and list3 not contain that item, then item is added to list3
			T item2 = list2.first();
			while(item2!=null) {
				if(item1.equals(item2)&&!list3.contains(item1))
					list3.add(item1);
				item2=list2.next();
			}
			item1=list1.next();
		}
		
		//return the reversed version
		return reverse(list3);
	}
	
	//return list3 which contains items in list1 interleaved with items in list2
	public static <T> List<T> interleave(List<T> list1, List<T> list2){
		List<T> list3 = new List<T>();
		
		//item1 stores items from list1, item2 for list2
		T item1 = list1.first();
		T item2 = list2.first();
		
		//move through both list, add 1st item in list1 to list3, add 1st item in list2 to list3, then the 2nd item for list1 and list2, etc.
		//stops when one list is done
		while(item1!=null&&item2!=null) {
			list3.add(item1);
			list3.add(item2);
			item1=list1.next();
			item2=list2.next();
		}
		
		//if list1 is longer, then item1 not null, so add rest of list1 items to list3
		//if list1 is shorter or if same length, will not enter this loop
		while(item1!=null) {
			list3.add(item1);
			item1=list1.next();
		}
		
		//if list2 is longer, add rest of list2 to list3
		//otherwise, this loop will not execute
		while(item2!=null) {
			list3.add(item2);
			item2=list2.next();
		}
		
		//return reversed
		return reverse(list3);
	}
	
	//return list2 which is list1 with every second item removed
	public static <T> List<T> chopSkip(List<T> list1){
		List<T> list2 = new List<T>();
		//use item to store, start with first in list1
		T item = list1.first();
		//index for the current item, first item is index 0
		int index = 0;
		
		//every second item has odd index, 1, 3, 5... which means for second item: index modulo 2 == 1
		//so, only add if index modulo 2 == 0
		//the while loop will go through list1 and add items to list2 while skipping every second item
		while(item!=null) {
			if(index%2==0)
				list2.add(item);
			item=list1.next();
			index++;
		}
		
		//return reversed
		return reverse(list2);
	}
	
	//reversal method reverse unordered list, make it better to read, so ABC is ABC instead of CBA
	public static <T> List<T> reverse(List<T> list1){
		List<T> list2 = new List<T>();
		T item = list1.first();
		while(item!=null) {
			list2.add(item);
			item=list1.next();
		}
		return list2;
	}
}
