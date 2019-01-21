import java.io.*;
import java.util.Random;
import java.util.Scanner;

//A geography quiz
public class CountryCapitalGeographyQuiz {

	//create a list of country-capital pairs with input file
	//use random number generator to generate an index between 0 to size-1 inclusive
	//use the random number and getAt method to get the random country-capital pair
	//use random number generator to generate 0 or 1, if 0 ask for capital, if 1 ask for country
	//get answer from user
	//depending on 0 or 1, input the country or capital along with answer into contains method
	//if contains is true, answer is correct
	public static void main(String[] args) throws IOException {
		//open file
		File file = new File("CountriesCapitals.txt");
		Scanner inputFile = new Scanner(file);
		//declarations
		String country, capital;
		CountryCapital ccpair;
		CountryCapitalList cclist = new CountryCapitalList();
		//read the file and create list of CountryCapital pairs
		while(inputFile.hasNext()) {
			country=inputFile.nextLine();
			capital=inputFile.nextLine();
			ccpair=new CountryCapital(country,capital);
			cclist.add(ccpair);
		}
		
		//Starts quiz
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to the Country-Capital Quiz\nPlay? ");
		String response = input.nextLine();
		
		//make a random object to generate random numbers
		Random random = new Random();
		
		//declare index and q, to be randomly generated
		int index, q;
		
		//store answer
		String answer;
		
		//store whether answer is correct
		boolean correct;
		
		//keep playing if user input Yes
		while(response.equals("Yes")) {
			
			//index, integer generated randomly, between 0 inclusive to size() exclusive, so index is within bound
			index = random.nextInt(cclist.size());
			
			//gets item at the random index
			ccpair = cclist.getAt(index);
			
			//generate random number 0 or 1
			q = random.nextInt(2);
			
			//if q=0 ask capital, if q=1 ask country
			if(q==0) {
				System.out.println("What is the capital of " + ccpair.getCountry() + "?");
				answer=input.nextLine();
				//check answer
				correct = cclist.contains(ccpair.getCountry(), answer);
				//print result depending on correctness
				if(correct)
					System.out.print("Correct. ");
				else
					System.out.print("Incorrect. The correct answer is " + ccpair.getCapital() + ". ");
				//ask if play again
				System.out.print("Play? ");
				response = input.nextLine();
			}
			else {
				System.out.println("What country has " + ccpair.getCapital() + " as its capital?");
				answer=input.nextLine();
				//check answer
				correct = cclist.contains(answer, ccpair.getCapital());
				//print result depending on correctness
				if(correct)
					System.out.print("Correct. ");
				else
					System.out.print("Incorrect. The correct answer is " + ccpair.getCountry() + ". ");
				//ask if play again
				System.out.print("Play? ");
				response = input.nextLine();
			}
		//end of while loop
		}
		//Any response other than Yes will stop the quiz
		System.out.println("Game over.");
	//end of main
	}
}
