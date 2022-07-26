package org.mgm.bj.business;

import org.junit.jupiter.api.Test;
import org.mgm.bj.model.Card;
import org.mgm.bj.model.Hand;
import org.mgm.bj.model.Suit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DealerDecisionMakerTest {
    @Test
    void testComplexStrategyValid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 1));
        hand.addCardToHand(new Card(Suit.Diamonds, 6));
        assertTrue(DealerDecisionMaker.getStrategy(hand));
    }

    @Test
    void testComplexStrategyInValid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 10));
        hand.addCardToHand(new Card(Suit.Diamonds, 6));
        assertTrue(DealerDecisionMaker.getStrategy(hand));
    }

    @Test
    void testHitOnSoft17Hard17() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 13));
        hand.addCardToHand(new Card(Suit.Diamonds, 7));
        assertFalse(DealerDecisionMaker.getStrategy(hand));
    }

    @Test
    void testHitOnSoft17Soft17() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 1));
        hand.addCardToHand(new Card(Suit.Diamonds, 6));
        assertTrue(DealerDecisionMaker.getStrategy(hand));
    }
}
