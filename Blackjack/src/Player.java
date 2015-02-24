
public class Player {
	private int money;
	private int total;
	private int cardCount;
	private Card[] hand = new Card[10];
	
	public Player(){
		this.money = 10;
		this.total = 0;
		this.cardCount = 0;
	}// end constructor 
	
	public void getCard(int n){
		total += n;
	}// end getCard method
	
	public void cardToHand(Card c){
		hand[cardCount++] = c;
	}// end cardToHand method
	
	public void resetHand(){
		cardCount = 0;
		hand = new Card[10];
	}// end resetHand
	
	public Card[] returnHand(){
		return hand;
	}// end returnHand
	
	public void revealCard(){
		for(int i = 0; i < cardCount; i++){
			hand[i].setVisible(true);
		}// end for loop
	}
	public void getHand(){
		for(int i = 0; i < cardCount; i++){
			System.out.println(hand[i]);		
		}// end for loop
	}// end getHand method
	
	public void setTotal(int n){
		this.total = n;
	}// end setTotal method
	
	public int getTotal(){
		return this.total;
	}// end total method
	
	public void setMoney(int n){
		money += n;
	}// end setMoney method
	
	public int getMoney(){
		return money;
	}// end getMoney method
	
	public int getCardCount(){
		return cardCount;
	}// end getCard method
	
	public boolean canBet(int n){
		if(n > this.money) return false;
		return true;
	}// end canBet method
}// end Player class
