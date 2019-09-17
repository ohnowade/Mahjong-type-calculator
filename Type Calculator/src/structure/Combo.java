package structure;

import java.util.*;

public class Combo {
	/**
	 * The cards in current combo
	 */
	private List<Card> cards;
	
	/**
	 * The type of the combo
	 */
	private ComboType type;
	
	public Combo(ComboType type) {
		this.type = type;
		cards = new ArrayList<Card>();
	}
	
	/**
	 * Add a card to current combo
	 * @param newCard
	 */
	public void addCard(Card newCard) {
		cards.add(newCard);
	}
	
	/**
	 * Retrieve the type of this combo
	 * @return
	 */
	public ComboType getType() {
		return this.type;
	}
	
	/**
	 * Retrieve all the cards in this combo
	 * @return
	 */
	public List<Card> getCards() {
		return this.cards;
	}
	
	/**
	 * helps check if two combo are equal
	 * @param other
	 * @return
	 */
	public boolean checkEqual(Combo other) {
		return this.cards.get(0).checkEqual(other.cards.get(0)) &&
				this.type == other.type;
	}
	
	@Override
	public String toString() {
		String represent = "";
		for (Card temp : cards) {
			represent += temp.toString() + " ";
		}
		represent += "(" + this.type + ")";
		return represent;
	}
	
}
