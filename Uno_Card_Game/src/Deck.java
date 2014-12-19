import java.util.ArrayList;


public class Deck {

	ArrayList<Card> cards;
	
	public Deck() {

		cards = new ArrayList<Card>();

//		initiate the numbered cards
		for(int i = 0; i < 10; i++){
			cards.add(new Card(i, CardColor.BLUE, SpecialCardType.NONE));
			cards.add(new Card(i, CardColor.GREEN, SpecialCardType.NONE));
			cards.add(new Card(i, CardColor.RED, SpecialCardType.NONE));
			cards.add(new Card(i, CardColor.YELLOW, SpecialCardType.NONE));
		}
		
//		initial +2s
		cards.add(new Card(CardColor.BLUE, SpecialCardType.PLUS_2));
		cards.add(new Card(CardColor.GREEN, SpecialCardType.PLUS_2));
		cards.add(new Card(CardColor.RED, SpecialCardType.PLUS_2));
		cards.add(new Card(CardColor.YELLOW, SpecialCardType.PLUS_2));
		
//		initiate +4s
		cards.add(new Card(CardColor.WILD, SpecialCardType.PLUS_4));
		cards.add(new Card(CardColor.WILD, SpecialCardType.PLUS_4));
		
//		initiate Wild Cards
		cards.add(new Card(CardColor.WILD, SpecialCardType.NONE));
		cards.add(new Card(CardColor.WILD, SpecialCardType.NONE));
		
//		initiate Reverse cards
		cards.add(new Card(CardColor.BLUE, SpecialCardType.REVERSE));
		cards.add(new Card(CardColor.GREEN, SpecialCardType.REVERSE));
		cards.add(new Card(CardColor.RED, SpecialCardType.REVERSE));
		cards.add(new Card(CardColor.YELLOW, SpecialCardType.REVERSE));
		
//		initiate Skips
		cards.add(new Card(CardColor.BLUE, SpecialCardType.SKIP));
		cards.add(new Card(CardColor.GREEN, SpecialCardType.SKIP));
		cards.add(new Card(CardColor.RED, SpecialCardType.SKIP));
		cards.add(new Card(CardColor.YELLOW, SpecialCardType.SKIP));
		
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
}
