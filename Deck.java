import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Deck{
	ArrayList<Cards> cards = new ArrayList<Cards>(); //Card is the data type
	Random rand = new Random();
	public void createDeck(){
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","K","Q"};
		String suits[]= {"Clubs","Hearts","Diamonds","Spades"};	
		for (String suit : suits){
			for (String rank: ranks){
				cards.add(new Cards(suit,rank));
			}
		}
	}

	public void shuffleDeck(){
		Collections.shuffle(cards);
		printDeck();
	}

	public void printDeck(){
		System.out.println("This is your deck:\n");
		for (Cards card: cards){
			System.out.println(card);
		}
	}

	public Cards showCard(){


		return cards.get(rand.nextInt(52));
	}

	public int findCard() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the card you wish to search (In the format \"<rank> of <suit>\")\nFor example 6 of Spades");
		String ss = br.readLine();
		String[] input = ss.split(" of ");
		Cards new_c = new Cards(input[1], input[0]);
		int count=0;
		for (Cards i: cards){

			if (Objects.equals(new_c.getSuit(), i.getSuit()) && Objects.equals(new_c.getRank(), i.getRank())){
				return count;
			}
			count++;
		}
		return  66;
	}

	public void dealCards(int n){
		System.out.println("\nDealing "+n+" cards...");
		int i=0,l;
		int[] ar = new int[n];
		while (i<n){
			l= rand.nextInt(52);
			for (int x: ar){
				if (x==l){
					continue;
				}
			}
			ar[i++]=l;
			System.out.println(cards.get(l));
		}
	}

	public void sameCards(int c1, int c2){


		System.out.println("Card 1: "+ cards.get(c1));
		System.out.println("Card 2: "+ cards.get(c2));
		if (Objects.equals(cards.get(c1).getSuit(), cards.get(c2).getSuit())){
			System.out.println("The given cards are of the same Suit");
		}
		else{
			System.out.println("The cards are not of the same Suit");
		}
	}

	public void compareCard(int c1, int c2){
		System.out.println("Card 1: "+ cards.get(c1));
		System.out.println("Card 2: "+ cards.get(c2));
		if (Objects.equals(cards.get(c1).getSuit(), cards.get(c2).getSuit())){
			System.out.print("The 2 cards have the same Suit");
		} else if (Objects.equals(cards.get(c1).getRank(), cards.get(c2).getRank())){
			System.out.println("The 2 cards have the same Rank");
		} else{
			System.out.println("The 2 cards neither have the same Suit not the same Rank");
		}
	}

	public int[] pick2Cards(){
		System.out.println("Picking 2 cards...");
		int[] ar = new int[2];
		int c1 = rand.nextInt(52), c2= rand.nextInt(52);
		while (c2==c1){
			c2= rand.nextInt(52);
		}
		ar[0]=c1;
		ar[1]= c2;
		return ar;
	}

}