/*
 * `````````````	
 * Marco Tran
 * CECS 274
 * Prog 1 - Blackjack
 * 2/10/2015
 * 
 */
import java.util.Scanner;
public class driver {
	public static void main(String[] args){
		Deck d = new Deck();
		Scanner menuInput = new Scanner(System.in);
		Scanner gameInput = new Scanner(System.in);
		Scanner betInput = new Scanner(System.in);
		Player p1 = new Player();
		Player dealer = new Player();
		String gInput = "";
		String menu =	   "(Be sure to shuffle the deck before you play)\n" + 
						   "1. New Deck" + "\n" +
						   "2. Shuffle cards in Deck" + "\n" +
						   "3. Display all cards remaining in the deck" + "\n" +
						   "4. Play Black Jack" + "\n" + 		   
						   "5. Exit";
		System.out.println("\t Blackjack Game!");
		System.out.println(menu);
		int choice = menuInput.nextInt();
		while(choice != 5){ 																// Menu while loop; Controls the menu
			switch(choice){ 
			case(1): d = new Deck(); break; 												// Makes a new deck
			case(2): d.shuffle(d.getDeck()); System.out.println("Shuffled"); break;		 	// Shuffles the deck
			case(3): d.display(); break; 													// Displays the remaining cards
			case(4):
					if(d.getCount() > 10){														// Shuffles the deck before the game starts
						System.out.println("There are " + d.getCount()+ " cards in the deck."); // Starts the game

				    	 p1.setTotal(0); 			// Total value of cards in player's hand
				    	 dealer.setTotal(0); 		// Total value of cards in dealer's hand
		    			 if(p1.getMoney() == 0){ 	// Checks if the player ran out of money   
				    		 System.out.println("You ran out of money. Game Over");
				    		 System.exit(0); 												// Stops the program
				    		 }// end if statement
				    	 System.out.println("You have " + p1.getMoney() + " dollars. How much do you want to bet?");
				    	 int bet = betInput.nextInt(); 										// Takes the input of user
				    	 if(p1.canBet(bet)){ 												// Starts the game if the player can bet.

				    		 //Dealer's Initial Hand 
				    		 d.topCard().setVisible(false);									// Sets the dealer's first card invisible
				    		 dealer.cardToHand(d.topCard());								// Puts the top card into the dealer's hand								
				    		 System.out.println("Dealer's Hand: ");							
				    		 dealer.getCard(d.deal().getValue());							// Gets the value of the top most card and then goes to the next card after
				    		 dealer.cardToHand(d.topCard());								// Puts the top card into the dealer's hand
				    		 dealer.getCard(d.deal().getValue());							// Gets the value of the top most card and then goes to the next card after
				    		 dealer.getHand(); 												// Prints out what is in the hand
				    		 //Dealer's Initial Hand
				    		 
				    		 //Your Initial Hand
			    			 p1.cardToHand(d.topCard());									// Puts the top card into the player's hand
			    			 p1.getCard(d.deal().getValue());								// Gets the value of the top most card and then goes to the next card after
			    			 p1.cardToHand(d.topCard());									// Puts the top card into the player's hand
			    			 p1.getCard(d.deal().getValue());								// Gets the value of the top most card and then goes to the next card after
			    			 System.out.println("\nPlayer: Total: " + p1.getTotal());		
			    			 p1.getHand();													// Prints out what is in the hand
			    			 //Your Initial Hand
			    			 
				    		 while(p1.getTotal() <= 21){									// While loop that keeps going until the player goes over 21 points
				    			 System.out.println("Would you like to hit? (Y/N)");
				    			 gInput = gameInput.nextLine(); 							// Handles the user input
				    			 if(gInput.equalsIgnoreCase("y") || (gInput.equalsIgnoreCase("yes"))){
				    				 if(d.topCard().getValue() == 11 && (p1.getTotal() + (d.topCard().getValue()) <= 21)){
				    					 p1.cardToHand(d.topCard());
				    					 p1.getCard(d.deal().getValue());
				    					 System.out.println("Player: Total: " + p1.getTotal());
				    					 p1.getHand();
				    				 } // end if statement
				    				 else if(p1.getTotal() + d.topCard().getValue() > 21){
				    					 p1.cardToHand(d.topCard());
				    					 p1.getCard(d.deal().getValue());
				    					 System.out.println("You went over 21!\n");
				    					 System.out.println("Player: Total: " + p1.getTotal());
				    					 p1.getHand();
				    					 p1.setMoney(-bet);
				    				 }// end else if 
				    				 else{
				    					 if(d.topCard().getRank().equalsIgnoreCase("Ace")){
				    						 if(p1.getTotal() + d.topCard().getValue() > 21)
				    						 {
				    							 p1.cardToHand(d.topCard());
				    							 p1.getCard(1);
						    					 System.out.println("Player: Total: " + p1.getTotal());
						    					 p1.getHand();
				    						 }
				    					 }
				    					 else{
				    						 p1.cardToHand(d.topCard());
					    					 p1.getCard(d.deal().getValue());
					    					 System.out.println("Player: Total: " + p1.getTotal());
					    					 p1.getHand();
				    					 }

					    				 if((p1.getTotal() > 21)){
					    					 for(int i = 0; i < p1.getCardCount(); i++){
					    						 if(p1.returnHand()[i].getValue() == 11){
					    							 p1.getCard(-10);
					    							 }//
					    						 }
					    					 }
					    				 }// end else statement
				    			 } // end if statement
				    			 else if(gInput.equalsIgnoreCase("n") || (gInput.equalsIgnoreCase("no"))){
								     while(dealer.getTotal() < 17){
								    	 if(d.topCard().getValue() == 11 && dealer.getTotal() + d.topCard().getValue() > 21){
								    	 System.out.println("Dealer takes a card: " + d.topCard());
								    	 dealer.cardToHand(d.topCard());
								    	 dealer.getCard(1);
								    	 }
								    	 else{
									    	 System.out.println("Dealer takes a card: " + d.topCard());
									    	 dealer.cardToHand(d.topCard());
									    	 dealer.getCard(d.topCard().getValue());
								    	 }// end else statement
								     }// end while loop
								     System.out.println("Dealer stands\n\n");
								     if(dealer.getTotal() > 21){
								    	 p1.setMoney(bet);
				    					 System.out.println("You won!");
				    					 dealer.revealCard();
				    					 System.out.println("Dealer's Hand: " + dealer.getTotal());
				    					 dealer.getHand();
				    					 System.out.println("\nPlayer: Total " + p1.getTotal());
				    					 p1.getHand();
				    					 break;
								     }// end if statement
				    				 if(dealer.getTotal() < p1.getTotal()){
				    					 p1.setMoney(bet);
				    					 System.out.println("You won!");
				    					 dealer.revealCard();
				    					 System.out.println("Dealer's Hand: " + dealer.getTotal());
				    					 dealer.getHand();
				    					 System.out.println("\nPlayer: Total:  " + p1.getTotal());
				    					 p1.getHand();
				    					 break;
				    				 }// end if statement
				    				 else if(dealer.getTotal() == p1.getTotal()){
				    					 p1.setMoney(bet);
				    					 System.out.println("You tied! But you won!");
				    					 dealer.revealCard();
				    					 System.out.println("Dealer's Hand: " + dealer.getTotal());
				    					 dealer.getHand();
				    					 System.out.println("\nPlayer: Total: " + p1.getTotal());
				    					 p1.getHand();
				    					 break;
				    					 }// end else if statement
				    				 else{
				    					 p1.setMoney(-bet);
				    					 System.out.println("You lost!");
				    					 dealer.revealCard();
				    					 System.out.println("Dealer's Hand: " + dealer.getTotal());
				    					 dealer.getHand();
				    					 System.out.println("\nPlayer: Total: " + p1.getTotal());
				    					 p1.getHand();
				    					 break;
				    					 }// end else statement
				    				 } // end else if statement
				    			 else{
				    				 System.out.println("Incorrect Input. Use \"Y\" for yes and \"N\" for no");
				    				 }// end else statement
				    			 }// end while loop
				    		 }// end if player can bet statement
				    	 else{
				    		 System.out.println("You don't have that much money");
				    		 }// end else statement
				    	 break;
				    	 }// end if statement
					else{
						System.out.println("There are only " + d.getCount() + " cards left in the deck." + "\n" +
										   "You have to make a new deck to play more Blackjack!");
						break;
						}// end else statement 
			case(5): System.exit(0); break;
			}// end Switch Case statements
			p1.resetHand();
			dealer.resetHand();
			
			System.out.println("\n\n" + menu);
			choice = menuInput.nextInt(); // Asks for menu choice
			}// end Switch Case			
		System.out.println("Thanks for playing!");

	} // end method main
}// end driver class
