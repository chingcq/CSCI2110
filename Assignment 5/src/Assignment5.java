import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment5 {
	
	public static void main(String[] args) throws FileNotFoundException {
		//read file specified by user
		//get filename
		System.out.print("Enter text file name: ");
		Scanner keyboard = new Scanner(System.in);
		String filename = keyboard.next();
		//open file
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		//create adjacency matrix from file
		//get number of vertices
		int num = Integer.parseInt(inputFile.nextLine());
		//create adjMatrix
		int[][] adjMatrix = new int[num][num];
		String firstVertex, secondVertex;
		int x, y;
		//fill adjMatrix
		while(inputFile.hasNext()) {
			firstVertex = inputFile.next();
			secondVertex = inputFile.next();
			x = firstVertex.charAt(0)-65;
			y = secondVertex.charAt(0)-65;
			adjMatrix[x][y] = 1;
			adjMatrix[y][x] = 1;
		}
		keyboard.close();
		inputFile.close();
		
		//display adjMatrix
		for(int row=0; row<num; row++) {
			for (int col=0; col<num; col++)
				System.out.print(adjMatrix[row][col] + " ");
			System.out.println();
		}
		
		//display traversal
		//ArrayList contains DFS traversal, vertices are in integers
		ArrayList<Integer> resultDFS = new ArrayList<Integer>(num);
		//call DFS to add traversal to resultDFS, use 0(A) as first vertex
		DFS(adjMatrix, resultDFS, 0);
		
		//ArrayList contains DFS traversal, vertices are in integers
		//call BFS to add traversal to resultBFS, use 0(A) as first vertex
		ArrayList<Integer> resultBFS = BFS(adjMatrix, 0);

		//display DFS traversal
		System.out.println("Depth First Search Traversal: ");
		for(int i: resultDFS) {
			System.out.print((char)(i+65) + " ");
		}
		System.out.println();
		
		//display BFS traversal
		System.out.println("Breadth First Search Traversal: ");
		for(int i: resultBFS) {
			System.out.print((char)(i+65) + " ");
		}
		System.out.println();
		
	}
	
	//method for depth first search traversal
	public static void DFS(int[][] adjMatrix, ArrayList<Integer> result, int vertex) {
		//if the current vertex is not already in result, put it in result, meaning it got traversed
		if(!result.contains(vertex))
			result.add(vertex);
		//check for neighbors, visit them if they have not been visited
		for(int i=0; i<adjMatrix[vertex].length; i++) {
			//check if it's a neighbor
			if(adjMatrix[vertex][i]==1)
				//check if the neighbor is not visited
				if(!result.contains(i))
					//visit
					DFS(adjMatrix, result, i);
		}
	}
	
	//method for breadth first search traversal
	public static ArrayList<Integer> BFS(int[][] adjMatrix, int vertex) {
		//use arraylist as queue
		ArrayList<Integer> queue = new ArrayList<Integer>();
		//empty result list
		ArrayList<Integer> result = new ArrayList<Integer>();
		//enqueue first vertex
		queue.add(vertex);
		//while not empty
		while(!queue.isEmpty()) {
			//dequeue v and list v in result
			int v = queue.remove(0);
			result.add(v);
			//look at each neighbor of v
			for(int i=0; i<adjMatrix[v].length; i++) {
				//check if v,i is a neighbor
				if(adjMatrix[v][i]==1)
					//enqueue neighbor to queue if not already in result or already in queue
					if(!result.contains(i) && !queue.contains(i))
						queue.add(i);
			}
		}
		return result;
	}

}
