package structure;

public class Card {
	/** 
	 * The value of current card. For Zi color, the values less than 5 would be Feng
	 */
	private int value;
	
	/**
	 * The color of current card
	 */
	private Color color;
	
	public Card(int val, Color col) {
		this.value = val;
		this.color = col;
	}
	
	/**
	 * Retrieve the value of the card
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Retrieve the color of the card
	 * @return
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * helps check if two cards are identical
	 * @param card
	 * @return
	 */
	public boolean checkEqual(Card card) {
		return this.value == card.value && this.color == card.color;
	}
	
	/**
	 * helps check if the card is the next card
	 */
	public boolean checkNext(Card card) {
		return (card.value == this.value + 1) && card.color == this.color;
	}
	
	@Override
	public String toString() {
		return "" + this.value + this.color;
	}
	
}
