import java.util.Random;
public class Deck {
	private Random gen = new Random();
	private int count;
	private Card[] d = new Card[52];
	
	public Deck(){ //Constructor
		count = 0; 
		for(int j = 0; j < 4; j++){ // First for loop that keeps track of the suits
			for(int i = 1; i < 14; i++){ // Nested for loop to assign the value and suit of the card
				switch(j){
				case 0: d[count] = new Card(i,"Spades"); break; 		// Assigns Ace - King Spades 
				case 1: d[count] = new Card(i,"Clubs"); break;  		// Assigns Ace - King Clubs
				case 2: d[count] = new Card(i,"Diamonds"); break;		// Assigns Ace - King Diamonds
				case 3: d[count] = new Card(i,"Hearts"); break;			// Assigns Ace - King Hearts
				}// end switch case statements
				count++; //Increments by one to traverse the array indices of 0-51
			}// end Second for loop
		}// end First for loop
		count = 51; // Sets it to 51 because after making a deck the count is 52 and that's out of bounds for the array.
	}// end Constructor
	
	public Card topCard(){ // Returns the top card without decrementing the count variable
		return d[count];
	}// end topCard method
	
	public Card deal(){
		return d[count--];
	}// end draw method
	
	public void shuffle(Card[] deck){ // Shuffles the deck 15 times
		for(int a = 0; a < 16; a++){   
			for(int i = 0; i < count; i++){
				int rand = gen.nextInt(52); // 0 - 51 inclusive
				Card temp = deck[i];
				deck[i] = deck[rand];
				deck[rand] = temp;
				}// end nested for loop
		}// end for loop
	}// end shuffle method 
	
	public void display(){ // Displays all the cards in the deck
		for(int i = 0; i <= count; i++){ // Uses a for loop to print out the remaining cards
			System.out.println(d[i]);
		} // end for loop
	}// end showCards method
	
	public Card[] getDeck(){ 
		return this.d;
	}// end getDeck
	
	public int getCount(){ // Returns the number of cards in the deck
		return (count + 1); // Added 1 because originally it is zero-based.
	}// end getCount method

}// end Deck class
