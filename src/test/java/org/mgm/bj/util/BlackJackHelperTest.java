package org.mgm.bj.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mgm.bj.model.Card;
import org.mgm.bj.model.Deck;
import org.mgm.bj.model.Hand;
import org.mgm.bj.model.Suit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackJackHelperTest {

    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(stdOut);
    }

    @Test
    void testSetupFirstRound() {
        Hand hand1 = new Hand();
        hand1.addCardToHand(new Card(Suit.Clubs, 6));
        Hand hand2 = new Hand();
        hand2.addCardToHand(new Card(Suit.Diamonds, 13));
        Hand dealerHand = new Hand();
        dealerHand.addCardToHand(new Card(Suit.Diamonds, 13));
        List<Hand> handList = new ArrayList<>();
        handList.add(hand1);
        handList.add(hand2);

        Deck deck = BlackJackHelper.setupDeck();
        BlackJackHelper.setupFirstRound(handList, deck, dealerHand);
        assertEquals("Dealing to player 1 card: 6 Clubs, Ace Hearts\n" +
                "Dealing to player 2 card: King Diamonds, Ace Clubs\n" +
                "Dealing to computer, card:  face down", byteArrayOutputStream.toString()
                .trim());

    }

    @Test
    void testPlayDealerHand() {
        Hand dealerHand = new Hand();
        dealerHand.addCardToHand(new Card(Suit.Diamonds, 13));
        Deck deck = BlackJackHelper.setupDeck();
        BlackJackHelper.playDealerHand(dealerHand, deck);
        assertEquals("Dealing to computer, cards: King Diamonds, Ace Hearts\n" +
                "Dealer stands.", byteArrayOutputStream.toString()
                .trim());

    }

    @Test
    void testFindBlackjackWinner() {
        Hand hand1 = new Hand();
        hand1.addCardToHand(new Card(Suit.Clubs, 6));
        hand1.addCardToHand(new Card(Suit.Spades, 10));
        Hand hand2 = new Hand();
        hand2.addCardToHand(new Card(Suit.Diamonds, 13));
        hand2.addCardToHand(new Card(Suit.Hearts, 1));
        Hand dealerHand = new Hand();
        dealerHand.addCardToHand(new Card(Suit.Spades, 13));
        dealerHand.addCardToHand(new Card(Suit.Diamonds, 9));
        List<Hand> handList = new ArrayList<>();
        handList.add(hand1);
        handList.add(hand2);

        BlackJackHelper.findBlackjackWinner(handList, dealerHand);
        assertEquals("Scoring player 1 has  16, dealer has 19.  Dealer wins.\n" +
                "Scoring player 2 has  21, dealer has 19.  Player 2 wins.", byteArrayOutputStream.toString()
                .trim());

    }

    @Test
    void testFindBlackjackWinnerDealerBusted() {
        Hand hand1 = new Hand();
        hand1.addCardToHand(new Card(Suit.Clubs, 2));
        hand1.addCardToHand(new Card(Suit.Spades, 10));
        hand1.addCardToHand(new Card(Suit.Hearts, 10));
        Hand hand2 = new Hand();
        hand2.addCardToHand(new Card(Suit.Diamonds, 13));
        hand2.addCardToHand(new Card(Suit.Hearts, 1));
        Hand dealerHand = new Hand();
        dealerHand.addCardToHand(new Card(Suit.Spades, 13));
        dealerHand.addCardToHand(new Card(Suit.Diamonds, 5));
        dealerHand.addCardToHand(new Card(Suit.Diamonds, 10));
        List<Hand> handList = new ArrayList<>();
        handList.add(hand1);
        handList.add(hand2);

        BlackJackHelper.findBlackjackWinner(handList, dealerHand);
        assertEquals("Scoring player 1 busted. Dealer wins.\n" +
                "Scoring player 2 has 21, Dealer Busted  Player 2 wins.", byteArrayOutputStream.toString()
                .trim());

    }

    @Test
    void testDealerHandBusted() {
        Hand dealerHand = new Hand();
        dealerHand.addCardToHand(new Card(Suit.Diamonds, 7));
        dealerHand.addCardToHand(new Card(Suit.Diamonds, 9));
        dealerHand.addCardToHand(new Card(Suit.Hearts, 6));
        Deck deck = BlackJackHelper.setupDeck();
        BlackJackHelper.playDealerHand(dealerHand, deck);
        assertEquals("Dealing to computer, cards: 7 Diamonds, 9 Diamonds, 6 Hearts, Ace Hearts\n" +
                "Dealer busted.", byteArrayOutputStream.toString()
                .trim());

    }
}
