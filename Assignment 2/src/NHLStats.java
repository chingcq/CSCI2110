import java.util.ArrayList;

//holds unordered list of PlayerRecord objects
public class NHLStats {
	//fields
	private List<PlayerRecord> playerlist;
	
	//constructor
	public NHLStats() {
		playerlist=new List<PlayerRecord>();
	}
	
	//add a PlayerRecord
	public void add(PlayerRecord p) {
		playerlist.add(p);
	}
	
	//display players with highest points, display their name, points, and team
	//also returns the list so main method can write to output file
	public List<PlayerRecord> highestPoints() {
		//new list to contain the players with highest points
		List<PlayerRecord> players = new List<PlayerRecord>();
		//set highest point to 0
		int hP = 0;
		//store first PlayerRecord from playerlist in p
		PlayerRecord p = playerlist.first();
		//look at every PlayerRecord in playerlist
		while(p!=null) {
			//if p's points is greater than hP, update hP to p's points
			//and clear the List players, then, add p to List players
			if(p.getPoints() > hP) {
				hP=p.getPoints();
				players.clear();
				players.add(p);
			}
			//else if p's points is equal to hP, no need to update hP, no need to clear players, just add p
			else if(p.getPoints() == hP)
				players.add(p);
			//else p's points is smaller than hP, do nothing
			else
				;
			//regardless of p's points, always move to next PlayerRecord
			p = playerlist.next();
		}
		//now, players contain all players with highest points, display their name, points, team
		System.out.println("Players with highest points: ");
		p = players.first();
		while(p!=null) {
			System.out.println("Name: " + p.getName() + " Points: " + p.getPoints() + " Team: " + p.getTeam());
			p = players.next();
		}
		return players;
	}
	
	//display most aggresive players, their name, team, position
	//also returns the list so main method can write to output file
	public List<PlayerRecord> mostAggressive() {
		//new list to contain the most aggressive players
		List<PlayerRecord> players = new List<PlayerRecord>();
		//set penalty minutes to 0
		int pim = 0;
		//store first PlayerRecord from playerlist in p
		PlayerRecord p = playerlist.first();
		//look at every PlayerRecord in playerlist
		while(p!=null) {
			//if p's PIM is greater than pim, update pim to p's PIM
			//and clear the List players, then, add p to List players
			if(p.getPIM() > pim) {
				pim=p.getPIM();
				players.clear();
				players.add(p);
			}
			//else if p's PIM is equal to pim, no need to update pim, no need to clear players, just add p
			else if(p.getPIM() == pim)
				players.add(p);
			//else p's PIM is smaller than pim, do nothing
			else
				;
			//regardless of p's PIM, always move to next PlayerRecord
			p = playerlist.next();
		}
		//now, players contain all most aggressive players, display their name, team, position
		System.out.println("Most aggressive players: ");
		p = players.first();
		while(p!=null) {
			System.out.println("Name: " + p.getName() + " Team: " + p.getTeam() + " Position: " + p.getPos());
			p = players.next();
		}
		return players;
	}
	
	//display most valuable players, their name, team
	//same algorithm as the two methods before
	public List<PlayerRecord> mostValuable() {
		//new list
		List<PlayerRecord> players = new List<PlayerRecord>();
		//set gwg to 0
		int gwg = 0;
		//first PlayerRecord
		PlayerRecord p = playerlist.first();
		//every PlayerRecord in playerlist
		while(p!=null) {
			//if p's GWG is greater than gwg
			if(p.getGWG() > gwg) {
				gwg=p.getGWG();
				players.clear();
				players.add(p);
			}
			//else if p's GWG is equal to gwg
			else if(p.getGWG() == gwg)
				players.add(p);
			//else p's GWG is smaller than gwg
			else
				;
			//move to next PlayerRecord
			p = playerlist.next();
		}
		//now, players contain all most valuable players, display their name, team
		System.out.println("Most valuable players: ");
		p = players.first();
		while(p!=null) {
			System.out.println("Name: " + p.getName() + " Team: " + p.getTeam());
			p = players.next();
		}
		return players;
	}
	
	//display most promising players, their name, team
	//same algorithm as the three methods before
	public List<PlayerRecord> mostPromising() {
		//new list
		List<PlayerRecord> players = new List<PlayerRecord>();
		//set sog to 0
		int sog = 0;
		//first PlayerRecord
		PlayerRecord p = playerlist.first();
		//every PlayerRecord in playerlist
		while(p!=null) {
			//if p's SOG is greater than sog
			if(p.getSOG() > sog) {
				sog=p.getSOG();
				players.clear();
				players.add(p);
			}
			//else if p's SOG is equal to sog
			else if(p.getSOG() == sog)
				players.add(p);
			//else p's GWG is smaller than gwg
			else
				;
			//move to next PlayerRecord
			p = playerlist.next();
		}
		//now, players contain all most promising players, display their name, team
		System.out.println("Most promising players: ");
		p = players.first();
		while(p!=null) {
			System.out.println("Name: " + p.getName() + " Team: " + p.getTeam());
			p = players.next();
		}
		return players;
	}
	
	//this method creates an ArrayList of team objects, each team object contains team name, PIM, GWG
	//the returned ArrayList can then be used to find teams with highest PIM or GWG
	public ArrayList<Team> teamInfo(){
		//declare the ArrayList teams
		ArrayList<Team> teams = new ArrayList<Team>();
		//store first PlayerRecord in p
		PlayerRecord p = playerlist.first();
		//look at every PlayerRecord
		while(p!=null) {
			//store team name of p in teamName
			String teamName = p.getTeam();
			//use indexInList method to find index of team object in teams that has same teamName
			int index = indexInList(teams, teamName);
			//if the index is not -1, it means the team object with same name already exists
			//so, just add player's PIM and GWG to the team's PIM and GWG
			if(index!=-1) {	
				teams.get(index).setPIM(p.getPIM());
				teams.get(index).setGWG(p.getGWG());
			}
			//else index is -1, so no team object with the teamName is in teams
			//create a team object with the teamName and add to teams
			else {
				Team newTeam = new Team(p.getTeam(), p.getPIM(), p.getGWG());
				teams.add(newTeam);
			}
			//move to next playerRecord
			p = playerlist.next();
		}
		//return teams
		return teams;
	}
	
	//this method takes in the teams ArrayList and teamName String, checks if any team object in teams ArrayList has the teamName
	//if yes, the index for that team object is returned, else return -1
	public int indexInList(ArrayList<Team> teams, String teamName) {
		for(int i=0; i<teams.size(); i++) {
			if(teams.get(i).getTeam().equals(teamName))
				return i;
		}
		return -1;
	}
	
	//display teams with most penalty minutes
	//also returns the list mostPTeams so main method can write to output
	public ArrayList<Team> mostPTeam() {
		//use teamInfo method to get an ArrayList of Team objects, teams
		ArrayList<Team> teams = teamInfo();
		//mostPTeams contains the teams with most PIM
		ArrayList<Team> mostPTeams = new ArrayList<Team>();
		//initialize to 0
		int teamPIM = 0;
		//find teams with most PIM, add to mostPTeams
		for(int i=0; i<teams.size();i++) {
			if(teams.get(i).getPIM()>teamPIM) {
				teamPIM = teams.get(i).getPIM();
				mostPTeams.clear();
				mostPTeams.add(teams.get(i));
			}
			else if(teams.get(i).getPIM() == teamPIM)
				mostPTeams.add(teams.get(i));
			else
				;
		}
		//display teams with most PIM
		System.out.println("Teams with most penalty minutes: ");
		for(int i=0; i<mostPTeams.size();i++) {
			System.out.println(mostPTeams.get(i).getTeam());
		}
		return mostPTeams;
	}
	
	//display teams with most game winning goals
	//also returns the list mostGTeams so main method can write to output
	public ArrayList<Team> mostGTeam() {
		//use teamInfo method to get an ArrayList of Team objects, teams
		ArrayList<Team> teams = teamInfo();
		//mostPTeams contains the teams with most GWG
		ArrayList<Team> mostGTeams = new ArrayList<Team>();
		//initialize to 0
		int teamGWG = 0;
		//find teams with most PIM, add to mostPTeams
		for(int i=0; i<teams.size();i++) {
			if(teams.get(i).getGWG()>teamGWG) {
				teamGWG = teams.get(i).getGWG();
				mostGTeams.clear();
				mostGTeams.add(teams.get(i));
			}
			else if(teams.get(i).getGWG() == teamGWG)
				mostGTeams.add(teams.get(i));
			else
				;
		}
		//display teams with most GWG
		System.out.println("Teams with most game winning goals: ");
		for(int i=0; i<mostGTeams.size();i++) {
			System.out.println(mostGTeams.get(i).getTeam());
		}
		return mostGTeams;
	}
	
	
}
