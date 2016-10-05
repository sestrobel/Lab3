package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerBase.Deck;
import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.DeckException;

public class Deck_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void DeckBuildTest() {
		Deck d = new Deck();
		assertTrue(d.getDeck().size() == 52);
		try {
			Card x = d.Draw();
			assertTrue(x instanceof Card);
		} catch (DeckException e) {
			e.printStackTrace();
		}

		
	}

	@Test
	public void JokerDeckBuildTest() {
		Deck d = new Deck(2);
		assertTrue(d.getDeck().size() == 54);
	}

	@Test
	public void JokerWildDeckBuildTest() {
		ArrayList<Card> wilds = new ArrayList<Card>();
		wilds.add(new Card(eSuit.CLUBS, eRank.TWO, 1));
		wilds.add(new Card(eSuit.DIAMONDS, eRank.TWO, 1));
		wilds.add(new Card(eSuit.SPADES, eRank.TWO, 1));
		wilds.add(new Card(eSuit.HEARTS, eRank.TWO, 1));
		Deck d = new Deck(2, wilds);
		assertTrue(d.getDeck().size() == 54);
	}

}
