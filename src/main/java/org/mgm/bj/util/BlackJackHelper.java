package org.mgm.bj.util;

import org.mgm.bj.business.DealerDecisionMaker;
import org.mgm.bj.model.Card;
import org.mgm.bj.model.Deck;
import org.mgm.bj.model.Hand;
import org.mgm.bj.model.Suit;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHelper {
    public static void findBlackjackWinner(List<Hand> handList, Hand dealerHand) {
        for (int playerCount = 0; playerCount < handList.size(); playerCount++) {
            if (handList.get(playerCount).isBusted()) {
                System.out.println("Scoring player " + (playerCount + 1) + " busted. Dealer wins.");
            } else if (dealerHand.isBusted()) {
                System.out.println("Scoring player " + (playerCount + 1) + " has " + handList.get(playerCount).getTotal() + ", Dealer Busted  Player " + (playerCount + 1) + " wins.");
            } else if (dealerHand.getTotal() >= handList.get(playerCount).getTotal()) {
                System.out.println("Scoring player " + (playerCount + 1) + " has  " + handList.get(playerCount).getTotal() + ", dealer has " + dealerHand.getTotal() + ".  Dealer wins.");
            } else if (dealerHand.getTotal() < handList.get(playerCount).getTotal()) {
                System.out.println("Scoring player " + (playerCount + 1) + " has  " + handList.get(playerCount).getTotal() + ", dealer has " + dealerHand.getTotal() + ".  Player " + (playerCount + 1) + " wins.");
            }
        }
    }

    public static void playDealerHand(Hand dealerHand, Deck deck){
        while(true) {
            dealerHand.addCardToHand(deck.dealACard());
            System.out.println("Dealing to computer, cards: " + dealerHand.getCardToString());
            if (!DealerDecisionMaker.getStrategy(dealerHand)){
                if (dealerHand.isBusted()) {
                    System.out.println("Dealer busted.");
                }
                break;
            }
            System.out.println("Dealer hits.");
        }

        if (!dealerHand.isBusted()) {
            System.out.println("Dealer stands.");
        }
    }

    public static Deck setupDeck(){
        ArrayList<Card> cardList = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                Suit suit = Suit.getSuit(j);
                Card card = new Card(suit, i);
                cardList.add(card);
            }
        }
        Deck deck = new Deck();
        deck.setDeckWithCards(cardList);
        return deck;
    }

    public static void setupFirstRound(List<Hand> handList, Deck deck, Hand dealerHand) {
        // Deal one card to all the players
        for (int playerCount = 0; playerCount < handList.size(); playerCount++) {
            handList.get(playerCount).addCardToHand(deck.dealACard());
            System.out.println("Dealing to player " + (playerCount + 1) + " card: " + handList.get(playerCount).getCardToString());
        }

        // Dealing to the computer
        dealerHand.addCardToHand(deck.dealACard());
        System.out.println("Dealing to computer, card:  face down");
    }

}
