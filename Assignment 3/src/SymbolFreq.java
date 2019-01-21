//SymbolFreq, contains symbol and its frequency of occurrence

public class SymbolFreq {
	//fields
	private char symbol;
	private int freq;
	
	//constructor
	public SymbolFreq(char c) {
		symbol = c;
		freq = 1;
	}
	//get symbol
	public char getSymbol() {
		return symbol;
	}
	//get freq
	public int getFreq() {
		return freq;
	}
	//set freq
	public void setFreq(int freq) {
		this.freq = freq;
	}
	//increment freq by 1
	public void incFreq() {
		freq++;
	}
	
	//toString
	public String toString() {
		return symbol + "\t" + freq;
	}
}
