public class Cards{

	private String suit;
	private String rank;

	public Cards(String suit, String rank){  //Constructor
		this.suit=suit;
		this.rank=rank;
	}

	//Setter and Getter methods
	public String getSuit(){
		return suit;
	}
	public void setSuit(String suit){
		this.suit=suit;
	}

	public String getRank(){
		return rank;
	}
	public void setRank(String rank){
		this.rank=rank;
	}

	//Method to return the deck
	public String toString(){
		return rank+" of "+suit;
	}

}