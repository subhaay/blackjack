package org.mgm.bj.util;

import org.mgm.bj.model.Card;
import org.mgm.bj.model.Deck;
import org.mgm.bj.model.Hand;
import org.mgm.bj.model.Suit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerHelperTest {

    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void testPlayerHand() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 6));
        hand.addCardToHand(new Card(Suit.Diamonds, 13));
        hand.addCardToHand(new Card(Suit.Hearts, 4));
        List<Hand> handList = new ArrayList<>();
        handList.add(hand);
        String data = "hit";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Deck deck = BlackJackHelper.setupDeck();
        PlayerHelper.playPlayerHand(handList, deck);
        assertEquals("Dealing to player 1 card: 6 Clubs, King Diamonds, 4 Hearts, Ace Hearts\n" +
                "Hit or Stand?\n" +
                "Dealing to player 1 card: 6 Clubs, King Diamonds, 4 Hearts, Ace Hearts, Ace Clubs\n" +
                "Busted over 21.", byteArrayOutputStream.toString()
                .trim());

    }

    @Test
    void testPlayerHandStand() {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.Clubs, 6));
        hand.addCardToHand(new Card(Suit.Diamonds, 13));
        hand.addCardToHand(new Card(Suit.Hearts, 4));
        List<Hand> handList = new ArrayList<>();
        handList.add(hand);
        String data = "stand";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Deck deck = BlackJackHelper.setupDeck();
        PlayerHelper.playPlayerHand(handList, deck);
        assertEquals("Dealing to player 1 card: 6 Clubs, King Diamonds, 4 Hearts, Ace Hearts\n" +
                "Hit or Stand?", byteArrayOutputStream.toString()
                .trim());

    }

    @AfterEach
    public void tearDown() {
        System.setOut(stdOut);
    }

}
