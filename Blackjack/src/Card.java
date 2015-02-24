
public class Card{
	private String suit;  // Spades, Clubs, Diamonds, Hearts
	private String rank;  // A, 2 ,3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
	private int value;    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
	private boolean visible; // True or false.
	
	public Card(int value, String suit){
		this.suit = suit;
		this.visible = true;
		switch (value){
		case 1:  this.rank = "Ace";   this.value = 11; break;
		case 2:  this.rank = "2" ;    this.value = 2; break;
		case 3:  this.rank = "3";     this.value = 3; break;
		case 4:  this.rank = "4";     this.value = 4; break; 
		case 5:  this.rank = "5";     this.value = 5; break;
		case 6:  this.rank = "6";     this.value = 6; break;
		case 7:  this.rank = "7";     this.value = 7; break;
		case 8:  this.rank = "8";     this.value = 8; break;
		case 9:  this.rank = "9";     this.value = 9;  break;
		case 10: this.rank = "10";    this.value = 10; break;
		case 11: this.rank = "Jack";  this.value = 10; break;
		case 12: this.rank = "Queen"; this.value = 10; break;
		case 13: this.rank = "King";  this.value = 10; break;
		}// end switch case statements
	}// end Constructor
	
	public void setVisible(boolean t){
		this.visible = t;
	}// end setVisible method
		
	
	public String getRank(){
		return this.rank;
	}// end getRank method
	
	public String getSuit(){
		return this.suit;
	}// end getSuit method
	
	public int getValue(){
		return this.value;
	}// end getValue method
	
	public String toString(){
		String str;
		if(this.visible == false){    
			return "???? of ????";
		}// end if statement
		else{ 
			//this.rank = getRank();
			//this.suit = tSuit; 
			str = getRank() + " of " + getSuit();
		} // end else statement
		return str;
	}// end toString 	
} //end class Card
