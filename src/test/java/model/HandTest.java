package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {
    @Test
    void testHandTotalWithNormalTwoCards() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 6));
        hand.addCardToHand(new Card(Suit.Diamonds, 13));
        assertEquals(16, hand.getTotal());
    }

    @Test
    void testHandTotalWithNormalThreeCards() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 6));
        hand.addCardToHand(new Card(Suit.Diamonds, 13));
        hand.addCardToHand(new Card(Suit.Hearts, 4));
        assertEquals(20, hand.getTotal());
    }

    @Test
    void testHandTotalWithNormalFourCards() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 6));
        hand.addCardToHand(new Card(Suit.Diamonds, 2));
        hand.addCardToHand(new Card(Suit.Hearts, 5));
        hand.addCardToHand(new Card(Suit.Spades, 8));
        assertEquals(21, hand.getTotal());
    }

    @Test
    void testHandTotalWithNormalBusted() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 6));
        hand.addCardToHand(new Card(Suit.Diamonds, 13));
        hand.addCardToHand(new Card(Suit.Hearts, 7));
        assertEquals(23, hand.getTotal());
    }

    @Test
    void testHandTotalWithOneAce() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 6));
        hand.addCardToHand(new Card(Suit.Diamonds, 1));
        assertEquals(17, hand.getTotal());
    }

    @Test
    void testHandTotalWithTwoAce() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 7));
        hand.addCardToHand(new Card(Suit.Diamonds, 1));
        hand.addCardToHand(new Card(Suit.Hearts, 1));
        hand.addCardToHand(new Card(Suit.Spades, 10));
        assertEquals(19, hand.getTotal());
    }

    @Test
    void testIsBustedValid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 13));
        hand.addCardToHand(new Card(Suit.Hearts, 9));
        hand.addCardToHand(new Card(Suit.Diamonds, 3));
        assertTrue(hand.isBusted());
    }

    @Test
    void testIsBustedInValid() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 13));
        hand.addCardToHand(new Card(Suit.Hearts, 9));
        hand.addCardToHand(new Card(Suit.Diamonds, 1));
        assertFalse(hand.isBusted());
    }
}
