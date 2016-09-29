package pokerExceptions;

import pokerBase.Deck;

public class DeckException extends Exception {
	private Deck d;
	
	public DeckException(Deck d, String message) {
		super(message);
		this.d = d;
	} //had gibbons help
}
