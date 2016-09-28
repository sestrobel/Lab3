package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.DeckException;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

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
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if (eSuit != eSuit.JOKER && eRank != eRank.JOKER) {
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
			}
		}
		for (int x = 0; x == NbrOfJoker; x++) {
			deckCards.add(new Card(eSuit.JOKER, eRank.JOKER, iCardNbr++));
		}
		Collections.shuffle(deckCards);
	} //I think it's good? -Liz

	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {

		// TODO Lab3 - Implement joker and wild constructor

	}

	public Card Draw() throws DeckException {
		
		if (deckCards.remove(0) instanceof Card)
			return deckCards.remove(0);
		else
			throw new DeckException("You don't have any cards left!!");		
	} //I think it's good? -Liz
}
