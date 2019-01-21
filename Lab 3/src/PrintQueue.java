/**PrintQueue class, contains a queue of Job objects, and methods to operate on the printQueue
 * @author david2
 *
 */
public class PrintQueue {
	
	//fields
	private GenericQueue<Job> pq;
	
	//constructor
	public PrintQueue(){
		pq = new GenericQueue<Job>();
	}
	
	//lpr method creates a Job object with arguments, and enqueues the Job object to pq
	public void lpr(String owner, int jobID) {
		Job newJob = new Job (owner, jobID);
		pq.enqueue(newJob);
	}
	
	//lpq method prints all the jobs in this queue pq
	public void lpq() {
		//checks if queue is empty
		if(pq.isEmpty())
			System.out.print("Empty print queue.");
		else
		{
			//Job j, used to store first, and next Jobs get from queue
			Job j;
			//get first Job from queue
			j = pq.first();
			//prints entries in queue (first Job)
			System.out.println(j.getOwner() + "\t\t\t" + j.getJobId());
			//set j to next Job object
			j = pq.next();
			//while queue end is not reached (j is not pointing to null)
			while(j!=null)
			{
				//prints the next entry (next Job)
				System.out.println(j.getOwner() + "\t\t\t" + j.getJobId());
				//store next Job in j and go back to while loop 
				j = pq.next();
			}
		}
	}
	
	//lprm removes the active job at the front of the queue if jobID matches, error message otherwise
	public void lprm(int jobID) {
		//check empty queue
		if(pq.isEmpty())
			System.out.println("Empty print queue, nothing removed.");
		//check if jobID matches at front
		else if(pq.peek().getJobId()!=jobID)
			System.out.println("Front Job jobID does not match input jobID, nothing removed.");
		//dequeue
		else
			pq.dequeue();
	}
	
	//lprmALL removes all jobs from the queue that have been submitted by the owner
	public void lprmALL(String owner) 
	{
		//first look at first Job object
		//while loop not finish unless first Object no longer contains owner=owner
		//if first Job contains owner=owner, it is removed, and 2nd Job becomes 1st Job, so loops again and tests the new first Job
		//if pq becomes empty after removal, method terminates
		while(pq.first().getOwner().equals(owner))
		{
			pq.remove(pq.first());
			if(pq.isEmpty())
				return;
		}
		
		//after first Job is tested and does not contain owner=owner
		//enter this while if 2nd Job is not null (has a Job object)
		//after each next() calls, cursor-- so the Job being operated is the right one
		//for example, after evaluating if 2nd Job is null, cursor--, so 2nd Job can be evaluated again to see if it contains owner=owner
		//if 2nd Job does contains owner, cursor-- again, so 2nd Job gets removed
		//after 2nd Job is removed, cursor-- again, because 3rd Job is now 2nd and we want to evaluate it
		//checks isEmpty after each removal
		while(pq.next()!=null)
		{
			pq.cursor--;
			if(pq.next().getOwner().equals(owner))
			{
				pq.cursor--;
				pq.remove(pq.next());
				pq.cursor--;
				if(pq.isEmpty())
					return;
			}
		}
	}
}