import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

//show methods in NHLStats
public class NHLListDemo {

	public static void main(String[] args) throws FileNotFoundException {
		//open the file and use tokenizer
		File file = new File("nhlstats.txt");
		Scanner inputFile = new Scanner(file);
		StringTokenizer token;
		
		//declare variables
		String line, name, pos, team, gpStr, gStr, aStr, pimStr, sogStr, gwgStr;
		PlayerRecord p;
		int gp, g, a, pim, sog, gwg;
		NHLStats nhl = new NHLStats();
		
		//read NHL info, break into tokens, store in above variables, construct PlayerRecord object p, add to list
		while(inputFile.hasNext()) {
			line = inputFile.nextLine();
			token = new StringTokenizer(line, "\t");
			name = token.nextToken();
			pos = token.nextToken();
			team = token.nextToken();
			gpStr = token.nextToken();
			gStr = token.nextToken();
			aStr = token.nextToken();
			pimStr = token.nextToken();
			sogStr = token.nextToken();
			gwgStr = token.nextToken();
			
			gp = Integer.parseInt(gpStr);
			g = Integer.parseInt(gStr);
			a = Integer.parseInt(aStr);
			pim = Integer.parseInt(pimStr);
			sog = Integer.parseInt(sogStr);
			gwg = Integer.parseInt(gwgStr);
			
			p = new PlayerRecord(name, pos, team, gp, g, a, pim, sog, gwg);
			nhl.add(p);
		}
		inputFile.close();
		
		//create output file
		PrintWriter outputFile = new PrintWriter("nhlstatsoutput.txt");
		outputFile.println("NHL Results Summary");
		
		//call the methods, which returns the lists, and write the lists to output file
		//players with highest points
		outputFile.println();
		outputFile.println("Players with highest points and their teams:");
		List<PlayerRecord> players = nhl.highestPoints();
		p = players.first();
		while(p!=null) {
			outputFile.println("Name: " + p.getName() + "\tTeam: " + p.getTeam());
			p = players.next();
		}
		//most aggressive players
		outputFile.println();
		outputFile.println("Most aggressive players, their teams and their positions:");
		players = nhl.mostAggressive();
		p = players.first();
		while(p!=null) {
			outputFile.println("Name: " + p.getName() + "\tTeam: " + p.getTeam() + "\tPosition: " + p.getPos());
			p = players.next();
		}
		//most valuable players
		outputFile.println();
		outputFile.println("Most valuable players and their teams:");
		players = nhl.mostValuable();
		p = players.first();
		while(p!=null) {
			outputFile.println("Name: " + p.getName() + "\tTeam: " + p.getTeam());
			p = players.next();
		}
		//most promising players
		outputFile.println();
		outputFile.println("Most promising players and their teams:");
		players = nhl.mostPromising();
		p = players.first();
		while(p!=null) {
			outputFile.println("Name: " + p.getName() + "\tTeam: " + p.getTeam());
			p = players.next();
		}
		//teams with most penalty minutes
		outputFile.println();
		outputFile.println("Teams that had the most number of penalty minutes:");
		ArrayList<Team> teams = nhl.mostPTeam();
		for(int i=0; i<teams.size();i++) {
			outputFile.println("Team: " + teams.get(i).getTeam());
		}
		//teams with most game winning goals
		outputFile.println();
		outputFile.println("Teams that had the most number of game winning goals:");
		teams = nhl.mostGTeam();
		for(int i=0; i<teams.size();i++) {
			outputFile.println("Team: " + teams.get(i).getTeam());
		}
		
		outputFile.close();
	}

}