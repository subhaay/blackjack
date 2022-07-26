package org.mgm.bj.util;

import org.mgm.bj.model.Deck;
import org.mgm.bj.model.Hand;

import java.util.List;
import java.util.Scanner;

/**
 * PlayerHelper class handles the player hand, giving them option to hit or stand and also calculates the total.
 * @author avipokhrel
 */
public class PlayerHelper {
    /**
     * This method add card to players hand based on hit or stand response.
     * @param handList
     * @param deck
     */
    public static void playPlayerHand(List<Hand> handList, Deck deck) {
        Scanner scan = new Scanner(System.in);
        for (int playerCount = 0; playerCount < handList.size(); playerCount++) {
            handList.get(playerCount).addCardToHand(deck.dealACard());
            System.out.println("Dealing to player " + (playerCount + 1) + " card: " + handList.get(playerCount).getCardToString());
            while (true) {
                System.out.println("Hit or Stand?");
                String userInput;
                while (true) {
                    userInput = scan.nextLine();
                    if (userInput.equals("hit") || userInput.equals("stand")) {
                        break;
                    } else {
                        System.out.println("Please respond with Hit or Stand?");
                    }
                }
                if (userInput.equals("hit")) {
                    handList.get(playerCount).addCardToHand(deck.dealACard());
                    System.out.println("Dealing to player " + (playerCount + 1) + " card: " + handList.get(playerCount).getCardToString());
                    if (handList.get(playerCount).isBusted()) {
                        System.out.println("Busted over 21.");
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
