//CountryCapitalList contains unordered list of CountryCapital

public class CountryCapitalList {
	//attribute
	private List<CountryCapital> cclist;
	
	//constructor
	public CountryCapitalList() {
		cclist = new List<CountryCapital>();
	}
	
	//add an item to list
	public void add(CountryCapital pair) {
		cclist.add(pair);
	}
	
	//get size of list
	public int size() {
		return cclist.size();
	}
	
	//get first
	public CountryCapital first() {
		return cclist.first();
	}
	
	//get next
	public CountryCapital next() {
		return cclist.next();
	}
	
	//return item at the input index, use for loop and next to get to the item at index, and return it
	//the main program gurantees only index within bound will be provided
	public CountryCapital getAt(int index) {
		CountryCapital ccpair = cclist.first();
		for(int i=0;i<index;i++) {
			ccpair = cclist.next();
		}
		return ccpair;
	}
	
	//contains take in a country and capital as input, then check if that country and capital is one pair and is in the list
	//true if the pair is in the list
	//this method help main method in quiz to check answer
	public boolean contains(String country, String capital) {
		CountryCapital ccpair = cclist.first();
		while(ccpair!=null) {
			if(ccpair.getCountry().equals(country)&&ccpair.getCapital().equals(capital))
				return true;
			ccpair=cclist.next();
		}
		
		return false;
	}

}
