package org.mgm.bj;

import org.mgm.bj.constant.BlackjackConstant;
import org.mgm.bj.model.Deck;
import org.mgm.bj.model.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mgm.bj.exception.IncorrectNumberOfPlayerException;
import org.mgm.bj.util.BlackJackHelper;
import org.mgm.bj.util.PlayerHelper;

/**
 * Blackjack class is the main class which is the entrypoint to the game and also it takes the number of players as user input and also
 * it handles the game.
 * @author avipokhrel
 */
public class Blackjack {
    /**
     * This method will run the application.
     * @param args
     */
    public static void main(String[] args) {
        try {
            int numOfPlayers = Integer.parseInt(args[0]);
            if (numOfPlayers > BlackjackConstant.MAX_NUM_OF_PLAYERS || numOfPlayers <= 0)
                throw new IncorrectNumberOfPlayerException("Invalid Player Count");
            System.out.println("Starting game with " + numOfPlayers + " players.");
            List<Hand> handList = new ArrayList<>(numOfPlayers);
            for (int i = 0; i < numOfPlayers; i++) {
                handList.add(new Hand());
            }
            Hand dealerHand = new Hand();
            Deck deck = BlackJackHelper.setupDeck();
            System.out.println("Shuffling.");
            Collections.shuffle(deck.getCardList());
            BlackJackHelper.setupFirstRound(handList, deck, dealerHand);
            PlayerHelper.playPlayerHand(handList, deck);
            BlackJackHelper.playDealerHand(dealerHand, deck);
            BlackJackHelper.findBlackjackWinner(handList, dealerHand);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | IncorrectNumberOfPlayerException ex) {
            System.out.println("Please enter a valid number from 1-3");
        }
    }
}
