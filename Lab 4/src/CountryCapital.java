//CountryCapital class contains a country name and its capital name, and get methods

public class CountryCapital {
	
	//attributes
	private String country, capital;
	
	//constructor
	public CountryCapital(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	
	//get methods
	public String getCountry() {
		return country;
	}
	
	public String getCapital() {
		return capital;
	}
	
	//toString
	public String toString(){
		return country+ " " + capital;
	}
}
