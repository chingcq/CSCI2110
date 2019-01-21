//contains all instance variables for one player
public class PlayerRecord {
	//fields
	private String name, pos, team;
	private int gp, g, a, pim, sog, gwg;
	
	//constructor
	public PlayerRecord(String name, String pos, String team, int gp, int g, int a, int pim, int sog, int gwg) {
		this.name=name;
		this.pos=pos;
		this.team=team;
		this.gp=gp;
		this.g=g;
		this.a=a;
		this.pim=pim;
		this.sog=sog;
		this.gwg=gwg;
	}
	
	//get g
	public int getG() {
		return g;
	}
	//get a
	public int getA() {
		return a;
	}
	
	//get points
	public int getPoints() {
		return g+a;
	}
	//get player name
	public String getName() {
		return name;
	}
	//get player position
	public String getPos() {
		return pos;
	}
	//get team name
	public String getTeam() {
		return team;
	}
	//get penalties in minutes
	public int getPIM() {
		return pim;
	}
	//get shots on goal
	public int getSOG() {
		return sog;
	}
	//get game winning goals
	public int getGWG() {
		return gwg;
	}
}
