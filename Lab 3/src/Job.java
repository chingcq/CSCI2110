/**A job class to hold two fields, String owner, and int jobID
 */
public class Job {
	//fields
	private String owner;
	private int jobId;
	
	//constructor
	public Job(String o, int j)
	{
		owner = o;
		jobId = j;
	}
	
	//get methods
	public String getOwner()
	{
		return owner;
	}
	public int getJobId()
	{
		return jobId;
	}
}
