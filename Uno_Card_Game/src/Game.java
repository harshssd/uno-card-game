import java.util.ArrayList;
import java.util.Scanner;


public class Game {

	private static int numberOfPlayers;
	private static Player[] players;
	private static ArrayList<Card> cardsStack;
	private static Card topCard;
	private static Player currentTurn;
	private static boolean isComplete;
	private static int cardsPerPlayer;
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of players");
        while(true){
        	try{
        		numberOfPlayers = Integer.parseInt(scanner.next());
        		break;
        	}catch(NumberFormatException n){
        		System.out.println("Please enter a number");
        	}
        }
    	System.out.println("There are "+numberOfPlayers+ " Players");
    	
    	createPlayers();
    	
    	createCardStack();
    	
        while(true){
        	System.out.println("Enter number of cards / players");
        	try{
        		cardsPerPlayer = Integer.parseInt(scanner.next());
        		break;
        	}catch(NumberFormatException n){
        		System.out.println("Please enter a number");
        	}
        }
    	
    	distributeCards();
    
    	while(true){
    		for(Player player: players){
    			currentTurn = player;
    			play(player);
    			if(player.isWinner()){
    				System.out.println("Player " + "<Player Name>"+ "Wins");
    				isComplete = true;
    				break;
    			}
    		}
    		if(isComplete) break;
    	}
    	
	}
	
	
	private static void play(Player player) {
		System.out.println("Top card is : ");
		topCard.printCard();
		System.out.println("");
		System.out.println("You have the following cards :");
		for(Card card: player.cardsInHand){
			card.printCard();			
		}
		Scanner scanner = new Scanner(System.in);
		int selection = 1;
		while(true){
			System.out.println("Enter 1: Draw From Stack or 2: Drop");
			try{
        		selection = Integer.parseInt(scanner.next());
        		if(selection==1){
        			Card selectedCard = cardsStack.remove(0);
        			System.out.println("Card Added");
        			selectedCard.printCard();
        			player.addCard(selectedCard);
        			break;
        		}
        		else if(selection==2){
        			System.out.println("Enter the index of the card to drop");
        			while(true){
        	        	try{
        	        		selection = Integer.parseInt(scanner.next());
        	        		if(selection<=player.cardsInHand.size()){
        	        			topCard = player.cardsInHand.remove(selection);
        	        			break;
        	        		}else{
        	        			System.out.println("Enter a valid index");
        	        		}
        	        	}catch(NumberFormatException n){
        	        		System.out.println("Please enter a number");
        	        	}
        	        }
        			break;
        		}        			
        		else{
        			System.out.println("Enter 1: select From Stack or 2: topCard");
        		}
        	}catch(NumberFormatException n){
        		System.out.println("Please enter a number");
        	}
        }			
	}


	private static void createCardStack() {
		double numberOfStacks = Math.ceil(numberOfPlayers/2);
		cardsStack = new ArrayList<Card>();
		while(numberOfStacks>0){
			cardsStack.addAll(new Deck().getCards());
			--numberOfStacks;
		}
	}


	private static void distributeCards() {
		while(cardsPerPlayer>0){
			for(Player player: players){
				int index = (int)Math.random()*cardsStack.size();
				player.cardsInHand.add(cardsStack.remove(index));
			}
			--cardsPerPlayer;
		}
		topCard = cardsStack.remove(0);
	}


	private static void createPlayers() {
		int count = 0;
		players = new Player[numberOfPlayers];
		while(count<numberOfPlayers){
			
			players[count] = new Player();
			++count;
		}
	}

	
	
	
	
}
