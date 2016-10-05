package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.HandException;

public class Hand_Test {

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
	public void TestRoyalFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());
	}

	
//	@Test
//	public void TestStraightFlush() {
//		Hand h = new Hand();
//		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
//		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
//		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
//		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
//		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
//		Hand x = h;
//
//		try {
//			h.EvaluateHand();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		assertTrue(h == x);
//		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
//		assertTrue(h.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
//	} //Liz's

	@Test
	public void TestStraightFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));

		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());


	}
	

	@Test
	public void TestStraight() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
		Hand ha = new Hand();
		ha.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE, 1));

		try {
			ha = Hand.EvaluateHand(ha);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(ha.getHs().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(ha.getHs().getHiHand() == eRank.FIVE.getiRankNbr());

		
		
	}

	@Test
	public void TestFiveOfAKind() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));

		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(h.getHs().getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());

	}
	
	@Test
	public void TestFourOfAKind() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE, 1));

		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(h.getHs().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
		Hand ha = new Hand();
		ha.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));

		try {
			ha = Hand.EvaluateHand(ha);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(ha.getHs().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(ha.getHs().getHiHand() == eRank.TEN.getiRankNbr());

	}

	@Test
	public void TestExplodeHands() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
		ArrayList<Hand> arr = new ArrayList<Hand>();
		try {
			arr = Hand.ExplodeHands(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(arr.size() == 52);
	}

	@Test
	public void TestFullHouse() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
		Hand ha = new Hand();
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		ha.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			ha = Hand.EvaluateHand(ha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(ha.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(ha.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
		
	}
	
	@Test
//	public static Hand PickBestHand(ArrayList<Hand> Hands) throws HandException {
	public void TestPickBestHand() {
		Hand h1 = new Hand();
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		Hand h2 = new Hand();
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.SIX,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.SEVEN,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.EIGHT,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		try {
			h2 = Hand.EvaluateHand(h2);
		} catch (HandException e1) {
			e1.printStackTrace();
		}
		try {
			h1 = Hand.EvaluateHand(h1);
		} catch (HandException e1) {
			e1.printStackTrace();
		}

		ArrayList<Hand> arr = new ArrayList<Hand>();
		arr.add(h1);
		arr.add(h2);
		Hand wh = new Hand();
		try {
			wh = Hand.PickBestHand(arr);
			assertTrue(wh.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
			assertTrue(wh.getHs().getHiHand() == eRank.NINE.getiRankNbr());
		} catch (HandException e) {
			e.printStackTrace();
		}
		assertTrue(wh.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(wh.getHs().getHiHand() == eRank.NINE.getiRankNbr());
		
		
		
	}
	
	@Test
	public void TestFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
	}
	
	@Test
	public void TestThreeOfAKind() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
		Hand h1 = new Hand();
		h1.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		try {
			h1 = Hand.EvaluateHand(h1);
		} catch (HandException e1) {
			e1.printStackTrace();
		}
		
		assertTrue(h1.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h1.getHs().getHiHand() == eRank.FIVE.getiRankNbr());
		
		Hand h2 = new Hand();
		h2.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.SIX,1));
		
		try {
			h2 = Hand.EvaluateHand(h2);
		} catch (HandException e1) {
			e1.printStackTrace();
		}
		assertTrue(h2.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h2.getHs().getHiHand() == eRank.FIVE.getiRankNbr());
		
	}
	
	@Test
	public void TestTwoPair() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.QUEEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == eRank.TEN.getiRankNbr());

		
		Hand h1 = new Hand();
		h1.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		try {
			h1 = Hand.EvaluateHand(h1);
		} catch (HandException e1) {
			e1.printStackTrace();
		}
		
		assertTrue(h1.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h1.getHs().getHiHand() == eRank.FIVE.getiRankNbr());
		assertTrue(h1.getHs().getLoHand() == eRank.THREE.getiRankNbr());
		
		Hand h2 = new Hand();
		h2.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		
		try {
			h2 = Hand.EvaluateHand(h2);
		} catch (HandException e1) {
			e1.printStackTrace();
		}
		assertTrue(h2.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h2.getHs().getHiHand() == eRank.FIVE.getiRankNbr());
		assertTrue(h2.getHs().getLoHand() == eRank.THREE.getiRankNbr());
		
		
	}
	
	@Test
	public void TestPair() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
		Hand h1 = new Hand();
		h1.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h1.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		try {
			h1 = Hand.EvaluateHand(h1);
		} catch (HandException e1) {
			e1.printStackTrace();
		}
		
		assertTrue(h1.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h1.getHs().getHiHand() == eRank.FIVE.getiRankNbr());
		
		Hand h2 = new Hand();
		h2.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.SEVEN,1));
		h2.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		
		try {
			h2 = Hand.EvaluateHand(h2);
		} catch (HandException e1) {
			e1.printStackTrace();
		}
		assertTrue(h2.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h2.getHs().getHiHand() == eRank.FIVE.getiRankNbr());
		
		Hand h3 = new Hand();
		h3.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h3.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h3.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h3.AddToCardsInHand(new Card(eSuit.SPADES, eRank.QUEEN,1));
		h3.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h3 = Hand.EvaluateHand(h3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h3.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h3.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
	}
	
	@Test
	public void TestHighCard() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
	}
	
//	public void EvaluateHand() {
//		try {
//			Hand h = EvaluateHand(this);
//			h.hs = h.getHs();
//			h.bScored = h.bScored;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
	
	@Test
	public void TestEvaluateHand() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		Hand x = h; //undergoes h.evaluatehand
		Hand y = h; //undergoes h = Hand.evaluatehand(h)
		try {
			y = Hand.EvaluateHand(y);
		} catch (Exception e) {
			e.printStackTrace();
		}
		x.EvaluateHand();
	
		assertTrue(x.getHs().getHandStrength() == y.getHs().getHandStrength());
		
	}
	

} 
