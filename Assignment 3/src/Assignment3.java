import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Assignment3 {
	
	public static void main(String[] args) throws FileNotFoundException {
		//step 1
		
		//open file
		File file = new File("Pokemon.txt");
		Scanner inputFile = new Scanner(file);
		
		//freqs store the frequencies
		ArrayList<SymbolFreq> freqs = new ArrayList<SymbolFreq>();
		//total occurrence
		int total = 0;
		
		//read lines, convert to chars
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			char[] chars = line.toCharArray();
			//count frequency for each char
			for(char c: chars) {
				//skip spaces
				if(c!=' ') {
					//total increment
					total++;
					//exist is whether symbol c exist in freqs
					boolean exist = false;
					//index for freqs
					int index = 0;
					//as long as c does not exist in freqs and haven't reached end of freqs
					while(!exist && index<freqs.size()) {
						//if found c in freqs, increment its frequency, set exist to true
						if(freqs.get(index).getSymbol()==c) {
							freqs.get(index).incFreq();
							exist = true;
						}
						//else increment index to check every symbol in freqs
						else
							index++;
					}
					//if exist is false, make a SymbolFreq object, add to freqs
					if(!exist) {
						SymbolFreq s = new SymbolFreq(c);
						freqs.add(s);
					}
				}
			}
		}
		inputFile.close();
		
		//step 2
		
		//OrderedList is used to contain pair Objects, so they will be ordered based on probability
		OrderedList<Pair> pairs = new OrderedList<Pair>();
		
		//remove SymbolFreq objects from freqs, make Pair objects from them, insert to OrderedList
		while(!freqs.isEmpty()) {
			SymbolFreq s = freqs.remove(0);
			Pair newPair = new Pair(s.getSymbol(), (double)s.getFreq()/total);
			pairs.insert(newPair);
		}
		
		//step 3
		
		//step 3.1
		//Queue s constructed by removing elements from pairs, pairs is already sorted
		//loop through each pair
		//create binary tree with pair
		//enqueue tree to s
		ArrayList<BinaryTree<Pair>> s = new ArrayList<BinaryTree<Pair>>();
		Pair pair = pairs.first();
		while(pair!=null) {
			BinaryTree<Pair> newTree = new BinaryTree<Pair>();
			newTree.makeRoot(pair);
			s.add(newTree);
			pair = pairs.next();
		}
		
		//step 3.2
		//Queue t
		ArrayList<BinaryTree<Pair>> t = new ArrayList<BinaryTree<Pair>>();
		
		//step 3.3 Huffman algorithm
		
		BinaryTree<Pair> a;
		BinaryTree<Pair> b;
		
		//step 3.3.1
		
		//if t is empty, dequeue first 2 trees from s
		//make combined tree p
		//attach a, b to p
		//enqueue p to t
		if(t.isEmpty()&&s.size()>=2) {
			a = s.remove(0);
			b = s.remove(0);
			BinaryTree<Pair> p = new BinaryTree<Pair>();
			double probP = a.getData().getProb()+b.getData().getProb();
			Pair newPair = new Pair('0', probP);
			p.makeRoot(newPair);
			p.attachLeft(a);
			p.attachRight(b);
			t.add(p);
		}
		else
			System.out.println("Need at least 2 symbols to encode.");
		
		//step 3.3.2 - 3.3.5
		
		//t is not empty, loop until s is empty
		while(!s.isEmpty()) {
			
			//step 3.3.2
			
			//for a
			//s front has smaller prob, let s front be a
			if(s.get(0).getData().getProb() < t.get(0).getData().getProb())
				a = s.remove(0);
			//t front has smaller prob, let t front be a
			else if(s.get(0).getData().getProb() > t.get(0).getData().getProb())
				a = t.remove(0);
			//if same prob, let s front be a
			else
				a = s.remove(0);
			
			//special cases, if loop entered with only 1 item in t or s
			//and item is removed
			//now t or s is empty
			//then get(0) will be out of bounds
			
			//if s is empty, b is t front
			if(s.isEmpty())
				b = t.remove(0);
			//if t is empty, b is s front
			else if(t.isEmpty())
				b = s.remove(0);
			//both not empty
			else {
				//s front has smaller prob, let s front be b
				if(s.get(0).getData().getProb() < t.get(0).getData().getProb())
					b = s.remove(0);
				//t front has smaller prob, let t front be b
				else if(s.get(0).getData().getProb() > t.get(0).getData().getProb())
					b = t.remove(0);
				//if same prob, let s front be b
				else
					b = s.remove(0);
			}
			
			//step 3.3.3
			BinaryTree<Pair> p = new BinaryTree<Pair>();
			double probP = a.getData().getProb()+b.getData().getProb();
			Pair newPair = new Pair('0', probP);
			p.makeRoot(newPair);
			p.attachLeft(a);
			p.attachRight(b);
			//step 3.3.4
			t.add(p);
		}
		
		//step 3.3.6, reduce t to only 1 item
		while(t.size()>1) {
			a = t.remove(0);
			b = t.remove(0);
			BinaryTree<Pair> p = new BinaryTree<Pair>();
			double probP = a.getData().getProb()+b.getData().getProb();
			Pair newPair = new Pair('0', probP);
			p.makeRoot(newPair);
			p.attachLeft(a);
			p.attachRight(b);
			t.add(p);
		}
		
		//step 4
		
		//dequeue huffman tree from queue t
		BinaryTree<Pair> huffmanTree = t.remove(0);
		
		//create codes which contains codes for all symbols
		String[] codes = findEncoding(huffmanTree);
		
		//create output file
		PrintWriter outputFile = new PrintWriter("Huffman.txt");
		
		//the OrderedList pairs from before contains symbols and probabilities
		//use pairs and codes for output
		DecimalFormat format = new DecimalFormat("0.00000");
		pair = pairs.first();
		while(pair!=null) {
			outputFile.print(pair.getValue() + "\t");
			outputFile.print(format.format(pair.getProb()) + "\t");
			outputFile.print(codes[(byte) pair.getValue()]);
			outputFile.println("");
			pair = pairs.next();
		}
		outputFile.close();
		
		//step 5
		
		//firstly, read Huffman.txt and store codes in an array, the index is the symbol cast to byte
		//read
		file = new File("Huffman.txt");
		inputFile = new Scanner(file);
		StringTokenizer token;
		char value;
		String code;
		//store codes
		String[] codesRead = new String[256];
		//use tokenizer to skip first two item, use charAt(0) to get symbol
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			value = line.charAt(0);
			token = new StringTokenizer(line, "\t");
			token.nextToken();
			token.nextToken();
			code = token.nextToken();
			codesRead[(byte)value] = code;
		}
		//now, read Pokemon.txt and encode it to Encoded.txt
		//read file
		file = new File("Pokemon.txt");
		inputFile = new Scanner(file);
		//open output file
		outputFile = new PrintWriter("Encoded.txt");
		//read and encode each line char by char
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			//line to char array
			char[] chars = line.toCharArray();
			//encode char by char
			for(char c: chars) {
				if(c!=' ')
					outputFile.print(codesRead[(byte)c]);
				else
					outputFile.print(' ');
			}
			outputFile.print('\n');
		}
		outputFile.close();
		
		//step 6
		
		//in order to decode, use the huffmanTree from before
		//read Encoded.txt
		file = new File("Encoded.txt");
		inputFile = new Scanner(file);
		//open Decoded.txt
		outputFile = new PrintWriter("Decoded.txt");
		//read Encoded lines and decode, the decode method will write to the output file
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			//parameters are line, huffmanTree, huffmanTree, outputFile
			decode(line, huffmanTree, huffmanTree, outputFile);
		}
		outputFile.close();
	}
	
	//recursive method to find Huffman encoding for values in trees
	//codes stored in array a
	//each value is converted to its byte value, which is used as its index in array a
	public static void findEncoding(BinaryTree<Pair> t, String[] a, String prefix){
		if (t.getLeft()==null&& t.getRight()==null){
			a[(byte)(t.getData().getValue())]= prefix;
		}
		else{
			findEncoding(t.getLeft(), a, prefix+"0");
			findEncoding(t.getRight(), a, prefix+"1");
		}
	}
	
	//wrapper for findEncoding method
	//result is a size 256 array, which contains codes for values in t
	//result is returned
	public static String[] findEncoding(BinaryTree<Pair> t){
		String[] result = new String[256];
		findEncoding(t, result, "");
		return result;
	}
	
	//recursive method to decode huffman codes
	//line is the code
	//root is the huffmanTree root
	//curr is the current huffmanTree node
	//outputFile is for writing to Decoded.txt
	public static void decode(String line, BinaryTree<Pair> root, BinaryTree<Pair> curr, PrintWriter outputFile) {
		//if current node is leaf node, it means the value of that node is the coded value
		//continue decoding with the rest of the line
		if(curr.getLeft()==null && curr.getRight()==null) {
			outputFile.print(curr.getData().getValue());
			decode(line, root, root, outputFile);
		}
		//if reached end of line, write \n
		else if(line.isEmpty())
			outputFile.print('\n');
		//if current char is ' ', write ' ' to output, and keep decoding with rest of line
		else if(line.charAt(0)==' ') {
			outputFile.print(' ');
			decode(line.substring(1), root, root, outputFile);
		}
		//if char is 0, keep decoding with current tree being the left child, and rest of the line
		else if(line.charAt(0)=='0')
			decode(line.substring(1), root, curr.getLeft(), outputFile);
		//if char is 1, decode with right subtree and rest of the line
		else if(line.charAt(0)=='1')
			decode(line.substring(1), root, curr.getRight(), outputFile);
	}
}
