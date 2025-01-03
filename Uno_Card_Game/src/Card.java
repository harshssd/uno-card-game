
public class Card {

	private int number;
	private CardColor color;
	private SpecialCardType speciality;
	
	public Card(int n, CardColor c, SpecialCardType s) {
		this.number = n;
		this.color = c;
		this.speciality = s;
	}

	public Card(CardColor c, SpecialCardType s) {
		this.color = c;
		this.speciality = s;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public CardColor getColor() {
		return color;
	}

	public void setColor(CardColor color) {
		this.color = color;
	}

	public SpecialCardType getSpeciality() {
		return speciality;
	}

	public void setSpeciality(SpecialCardType speciality) {
		this.speciality = speciality;
	}
	
	public void printCard(){
		System.out.println("Number: "+number+ " of color"+color+" having speciality "+speciality);
	}
	
}
