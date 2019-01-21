/**A demo program to tests the methods in PritnQueue class
 * @author david2
 *
 */

public class PrintQueueDemo {

	public static void main(String[] args) {
		//creates an empty PrintQueue object
		PrintQueue pq = new PrintQueue();
		
		//adds entries to queue
		pq.lpr("swilliams", 309);
		pq.lpr("ronaldinho", 300);
		pq.lpr("marionjones", 312);
		pq.lpr("swilliams", 267);
		pq.lpr("davidh", 135);
		pq.lpr("ronaldinho", 301);
				
		//prints queue
		pq.lpq();
		
		//tests lprm, remove 309
		pq.lprm(309);
		
		//tests lprmALL, remove all of ronaldinho
		pq.lprmALL("ronaldinho");	
		
		//prints queue again
		pq.lpq();
	}
}
