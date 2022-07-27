package org.mgm.bj.business;

import org.junit.jupiter.api.Test;
import org.mgm.bj.model.Card;
import org.mgm.bj.model.Hand;
import org.mgm.bj.model.Suit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * DealerStrategyTest contains test cases for DealerStrategy.
 * @author avipokhrel
 */
public class DealerStrategyTest {
    @Test
    void testDealerStrategyValid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 1));
        hand.addCardToHand(new Card(Suit.Diamonds, 6));
        assertTrue(DealerDecisionMaker.getStrategy(hand));
    }

    @Test
    void testRiskyStrategyInValid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 10));
        hand.addCardToHand(new Card(Suit.Diamonds, 11));
        assertFalse(DealerDecisionMaker.getStrategy(hand));
    }

    @Test
    void testHitTill16Valid() {
        assertTrue(DealerStrategy.hitTill16(16));
    }

    @Test
    void testHitTill16InValid() {
        assertFalse(DealerStrategy.hitTill16(17));
    }

    @Test
    void testHitOnSoft17() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 1));
        hand.addCardToHand(new Card(Suit.Diamonds, 6));
        assertTrue(DealerStrategy.hitOnSoft17(hand));
    }

    @Test
    void testHitOnSoft17Hard17() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 13));
        hand.addCardToHand(new Card(Suit.Diamonds, 7));
        assertFalse(DealerStrategy.hitOnSoft17(hand));
    }

    @Test
    void testHitOnSoft17Invalid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 1));
        hand.addCardToHand(new Card(Suit.Diamonds, 10));
        hand.addCardToHand(new Card(Suit.Hearts, 6));

        assertFalse(DealerStrategy.hitOnSoft17(hand));
    }

    @Test
    void testHitOnSoft17Valid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 1));
        hand.addCardToHand(new Card(Suit.Diamonds, 1));
        hand.addCardToHand(new Card(Suit.Hearts, 5));
        assertTrue(DealerStrategy.hitOnSoft17(hand));
    }

    @Test
    void testHitOnSoft17TwoAcesValid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 1));
        hand.addCardToHand(new Card(Suit.Diamonds, 1));
        hand.addCardToHand(new Card(Suit.Hearts, 10));
        hand.addCardToHand(new Card(Suit.Hearts, 5));
        assertFalse(DealerStrategy.hitOnSoft17(hand));
    }
}
