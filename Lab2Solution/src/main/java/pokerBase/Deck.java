package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.DeckException;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public ArrayList<Card> getDeck() {
		return deckCards;
	}
	
	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if (eSuit != eSuit.JOKER && eRank != eRank.JOKER) {
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
			}
		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJoker) {
		this();
		for (int x = 0; x < NbrOfJoker; x++) {
			deckCards.add(new Card(eSuit.JOKER, eRank.JOKER, 99));
		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		this(NbrOfJokers);
		for (Card c : deckCards) {
			for (Card wc : Wilds) {
				if (c.geteRank() == wc.geteRank() && c.geteSuit() == wc.geteSuit()) {
					c.setbWild(true);
				}
			}
		}
		Collections.shuffle(deckCards);

	}

	public Card Draw() throws DeckException {

		try {
			return deckCards.remove(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DeckException(this, "You don't have any cards left!!");
		} catch (Exception e) {
			throw new DeckException(this, "Something went wrong.");
		}

	} // had gibbons help
}
