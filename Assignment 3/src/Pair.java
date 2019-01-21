//Pair class contains value, which is a symbol
//and prob, which is the probability of occurrence
//Pair implements Comparable interface, so it has compareTo(), and can be used in OrderedList

public class Pair implements Comparable<Pair> {
	//fields
	private char value;
	private double prob;
	
	//constructor
	public Pair(char value, double prob) {
		this.value = value;
		this.prob = prob;
	}
	
	//get methods
	public char getValue() {
		return value;
	}
	
	public double getProb() {
		return prob;
	}
	
	//set methods
	public void setValue(char value) {
		this.value = value;
	}
	
	public void setProb(double prob) {
		this.prob = prob;
	}
	
	//toString
	public String toString() {
		return value + "\t" + Double.toString(prob);
	}
	
	//compareTo, first compare with probability, then if probability is same, compare with value
	public int compareTo(Pair other) {
		if(this.prob<other.getProb())
			return -1;
		else if(this.prob>other.getProb())
			return 1;
		else if(this.value<other.getValue())
			return -1;
		else if(this.value>other.getValue())
			return 1;
		else
			return 0;
	}

}
