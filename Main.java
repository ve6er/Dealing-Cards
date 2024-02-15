import java.io.IOException;
import java.util.*;

class Main{

	public static int options() throws IOException{
		Scanner scn = new Scanner(System.in);
		System.out.println("\nEnter 1 to reload the deck" +
				"\nEnter 2 to print your deck" +
				"\nEnter 3 to shuffle your deck" +
				"\nEnter 4 to pick a random card" +
				"\nEnter 5 to deal cards" +
				"\nEnter 6 to find the index of a card" +
				"\nEnter 7 to find if 2 random cards have the same Suit" +
				"\nEnter 8 to compare 2 random cards" +
				"\nEnter 9 to exit");
		return scn.nextInt();
	}

	public static void main(String args[]) throws IOException {
		Deck deck = new Deck();
		Random rand = new Random();
		Scanner scn = new Scanner(System.in);
		System.out.println("Creating the Deck...");
		deck.createDeck();
		System.out.print("Deck created!");
		int ans= options();

		while (true){
			if (ans==1){
				deck.createDeck();
				System.out.println("Reloaded your deck");
			}
			else if (ans==2){
				deck.printDeck();
			}
			else if (ans==3){
				deck.shuffleDeck();
			}
			else if (ans==4){
				System.out.println("Showing you a random card\n"+deck.showCard());
			}
			else if (ans==5){
				System.out.println("How many cards do you want?");
				int n = scn.nextInt();
				while (n>52 || n<0){
					System.out.println("Invalid input. Please enter a number from 1 to 52");
					n=scn.nextInt();
				}
				deck.dealCards(n);
			}
			else if (ans==6){
				int v;
				while (true) {
					v = deck.findCard();
					if (v != 66) {
						System.out.println("The card is at position " + (v+1));
						break;
					} else {
						System.out.println("Invalid card name. Please try again in the specified format");
					}
				}
			}
			else if (ans==7){
				int [] arr= deck.pick2Cards();
				deck.sameCards(arr[0],arr[1]);
			}
			else if (ans==8){
				int [] arr= deck.pick2Cards();
				deck.compareCard(arr[0], arr[1]);
			}
			else if (ans==9){
				System.exit(0);
			}
			else{
				System.out.println("Please enter a valid option");
			}
			ans=options();
		}
	}
}