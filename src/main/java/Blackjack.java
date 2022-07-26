import constant.BlackjackConstant;
import model.Deck;
import model.Hand;
import util.BlackJackHelper;
import util.PlayerHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exception.IncorrectNumberOfPlayerException;

public class Blackjack {
    public static void main(String[] args) {
        try {
            int numOfPlayers = Integer.parseInt(args[0]);
            if (numOfPlayers > BlackjackConstant.MAX_NUM_OF_PLAYERS || numOfPlayers <=0 ) throw new IncorrectNumberOfPlayerException("Invalid Player Count");
            System.out.println("Starting game with " + numOfPlayers + " players.");
            List<Hand> handList = new ArrayList<>(numOfPlayers);
            for (int i = 0; i < numOfPlayers; i++) {
                handList.add(new Hand());
            }
            Hand dealerHand = new Hand();
            Deck deck=BlackJackHelper.setupDeck();
            System.out.println("Shuffling.");
            Collections.shuffle(deck.getCardList());
            BlackJackHelper.setupFirstRound(handList, deck, dealerHand);
            PlayerHelper.playPlayerHand(handList, deck);
            BlackJackHelper.playDealerHand(dealerHand, deck);
            BlackJackHelper.findBlackjackWinner(handList, dealerHand);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | IncorrectNumberOfPlayerException ex){
            System.out.println("Please enter a valid number from 1-3");
        }
    }
}
