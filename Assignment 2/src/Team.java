//contains team name, team penalty minutes, team game winning goals
public class Team {
	//fields
	private String team;
	private int pim, gwg;
	
	//constructor
	public Team(String team, int pim, int gwg) {
		this.team=team;
		this.pim=pim;
		this.gwg=gwg;
	}
	
	//set new team pim by adding another player's pim to the team pim
	public void setPIM(int pim) {
		this.pim += pim;
	}
	
	//set new team gwg by adding another player's gwg to the team gwg
	public void setGWG(int gwg) {
		this.gwg += gwg;
	}
	
	//get team name
	public String getTeam() {
		return team;
	}
	
	//get team PIM
	public int getPIM() {
		return pim;
	}
	
	//get team GWG
	public int getGWG() {
		return gwg;
	}

}
