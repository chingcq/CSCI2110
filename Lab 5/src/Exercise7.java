//solution for exercise 7
public class Exercise7 {
	
	//returns the minimal number of moves required to move n number of disks from from to to
	public static long moves(int n, int from, int to, int temp) {
		//base case, if number of disk is 1, just move it from from to to, this is 1 move
		if(n==1)
			return 1;
		//recursive case, if number of disk is larger than 1
		//then it's basically 3 steps:
		//1. move n-1 disks on top from from to temp, so just call the moves method again
		//2. move disk on bottom from from to to, this is 1 move
		//3. move the n-1 disks from temp to to, so just call moves method again
		else {
			return moves(n-1,from,temp,to) + 1 + moves(n-1,temp,to,from);
		}
	}

	public static void main(String[] args) {
		
		//declare these outside for loop
		long numberOfMoves;
		long startTime, endTime, executionTime;
		
		//hard code n=8, 12, 16, 20, 24, 28, and 32
		for(int i=8;i<=32;i+=4) {
			System.out.println("Number of disks: " + i);
			//starts measuring time
			startTime = System.currentTimeMillis();
			
			//find number of moves
			numberOfMoves = moves(i, 1, 3, 2);
			
			//ends measuring time
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			
			//display results
			System.out.println("Number of moves: " + numberOfMoves);
			System.out.println("Execution time: " + executionTime);
		}
	}
}
